package com.pet.lovepet.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {
    private String code;
    private String message;
    private StatusMessage statusMessage;

    public ResponseResult() {
        this.statusMessage = StatusMessage.SUCCESS;
        this.code = statusMessage.getCode();
        this.message = statusMessage.getMessage();
    }

    public ResponseResult(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static ResponseResult successResult(){
        return new ResponseResult();
    }

    public static ResponseResult errorResult(){
        return new ResponseResult(StatusMessage.ERROR.getCode(),StatusMessage.ERROR.getMessage());
    }

    public static ResponseResult errorResult(String code,String message){
        return new ResponseResult(code,message);
    }

    public static ResponseResult errorResult(StatusMessage statusMessage){
        return new ResponseResult(statusMessage.getCode(),statusMessage.getMessage());
    }
}
