package com.pet.lovepet.base;

public enum StatusMessage implements IMessage{
    //请求成功
    SUCCESS("1000","操作成功"),
    //请求失败
    ERROR("1001","系统异常"),
    //请求参数有误
    PARAM_ERROR("1002","请求参数有误"),
    //表示成功匹配
    SUCCESS_MATCH("1003","表示成功匹配"),
    //未登录
    NO_LOGIN("1100","未登录"),
    //用户已锁定
    LOCK("1111","用户已锁定"),
    //用户不存在
    NO_USER("1112","用户不存在"),
    //用户已离职
    IS_JOB("1113","用户已离职，请联系管理员"),
    ERROR_PASSWORD("1114","用户名或密码不正确");

    private String code;
    private String message;

    private StatusMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
