package com.zl.dafeng.novate;


import android.content.Context;

import com.zl.dafeng.novate.Exception.ConfigLoader;

/**
 * BaseResponse Data T
 * Created by Tamic on 2016-06-06.
 */
public class NovateResponse<T> {
    //结果码
    private int code = 1;
    /*错误信息:msg, error, message*/
    private String msg, error, message;
    /*真实数据 data或者result*/
    private T info, result;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NovateResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", info=" + info +
                ", result=" + result +
                '}';
    }

    public boolean isOk(Context context) {
        return ConfigLoader.checkSucess(context, getCode());
    }
}
