package com.pet.lovepet.controller;

import com.google.common.base.Strings;
import com.pet.lovepet.base.BaseController;
import com.pet.lovepet.entity.User;
import com.pet.lovepet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.RequestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/4/9 10:01
 * @Description:
 */
@Slf4j
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String loginname, String pwd, Model model, HttpSession session, HttpServletRequest request){
        if (!Strings.isNullOrEmpty(loginname)&&!Strings.isNullOrEmpty(pwd)){
            User user=userService.findUserByLoginName(loginname);
            if(user!=null && user.getPassword().equalsIgnoreCase(pwd)){
                log.info("{}登录成功", loginname);
                session.setAttribute(CURRENT_USER, user);
                return "redirect:/index";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/login",method =RequestMethod.POST )
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
                        HttpServletResponse response, @RequestParam(defaultValue = "false") boolean rememberMe,
                        Model model, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException exception) {
            model.addAttribute("error", "登录失败：用户名或密码错误");
            log.info("登录失败：账户{}不存在", username);
        } catch (LockedAccountException exception) {
            model.addAttribute("error", "失败次数过多，账号被锁定，请稍后再试");
            log.info("登录失败：账户{}被锁定", username);
        } catch (AuthenticationException exception) {
            User user = userService.findUserByLoginName(username);
            int failtimes = user.getFailTimes();
            user.setFailTimes(failtimes + 1);
            if (failtimes + 1 >= 3) {
                model.addAttribute("error", "失败次数太多，账号被锁定");
                if(!user.getLocked()){
                    user.setLocked(true);
                    user.setLockedDate(new Date());
                }
            }else{
                model.addAttribute("error", "用户名或密码错误，您还有"+(2-failtimes)+"次机会");
            }
            //保存
            try {
                userService.save(user);
            }catch (Exception e){
                log.info("登录信息修改异常："+e);
            }
            log.info("登录失败：账户{}密码错误", username);
        }
        if (subject.isAuthenticated()){
            log.info("{}登录成功", subject.getPrincipal().toString());
            User user = getCurrentUser();
            user.setFailTimes(0);
            user.setLockedDate(null);
            /*user.setLastLoginDate(new Date());
            user.setLastLoginIp(RequestUtil.getIpAddr(request));*/
            //保存
            try {
                userService.save(user);
            }catch (Exception e){
                log.info("登录信息修改异常："+e);
            }
            session.setAttribute(CURRENT_USER, user);
            return "redirect:/index";
        }else {
            return "login";
        }
    }

    /**
     *@description 退出登录
     *@return: java.lang.String
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
