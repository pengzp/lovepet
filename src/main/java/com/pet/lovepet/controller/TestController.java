package com.pet.lovepet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lovepet
 * @description:
 * @author: Mr.peng
 * @create: 2020-04-01 21:38
 **/

@Api(description = "测试接口")
@Controller("test")
@RequestMapping("/test")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value = "获取信息", notes = "通过参数获取信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param1", value = "参数1", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "param2", value = "参数2", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "param3", value = "参数3", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "param4", value = "参数4", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "param5", value = "参数5", paramType = "query", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "getInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map getOtp(@RequestParam(name = "param1") String param1,
                      @RequestParam(name = "param2") String param2,
                      @RequestParam(name = "param3") String param3,
                      @RequestParam(name = "param4") String param4,
                      @RequestParam(name = "param5") String param5
    ) {
        System.out.println("调用测试接口");
        Map map = new HashMap();
        map.put("result1", "返回值1");
        map.put("result2", "返回值2");
        map.put("result3", "返回值3");
        map.put("result4", "返回值4");
        map.put("result5", "返回值5");

        return map;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        logger.info("- 数据库日志info");
        logger.error("- 数据库日志error");
        logger.info("一条不带‘-’的日志，看会不会记录如数据库");
        return "";
    }
}