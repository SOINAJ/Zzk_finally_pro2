package com.example.zzk_finaly_pro_1.util;


import static com.example.zzk_finaly_pro_1.util.Code.*;

public class Result {
    private Object data;
    private Integer code;
    private String msc;

    public Result() {
    }

    public Result(Object data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public Result(Object data, Integer code, String msc) {
        this.data = data;
        this.code = code;
        this.msc = msc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsc() {
        return msc;
    }

    public void setMsc(String msc) {
        this.msc = msc;
    }


    public static Result Get_ativition(Object t){
        Integer oh = t != null ? GET_OK : GET_ERR;
        String msc = t != null ? "" : "error";
        return new Result(t, oh, msc);
    }

    public static Result Save_ativition(Object t){
        Integer oh = t != null ? SAVE_OK : SAVE_ERR;
        String msc = t != null ? "" : "error";
        return new Result(t, oh, msc);
    }

    public static Result Delete_ativition(Object t){
        Integer oh = t != null ? DELETE_OK : DELETE_ERR;
        String msc = t != null ? "" : "error";
        return new Result(t, oh, msc);
    }

    public static Result Update_ativition(Object t){
        Integer oh = t != null ? UPDATA_OK : UPDATA_ERR;
        String msc = t != null ? "" : "error";
        return new Result(t, oh, msc);
    }


    public static Result Get_ativition(Object t,String data){
        Integer oh = t != null ? GET_OK : GET_ERR;
        String msc = t != null ? data : "error";
        return new Result(t, oh, msc);
    }
    public static Result Save_ativition(Object t,String data){
        Integer oh = t != null ? SAVE_OK : SAVE_ERR;
        String msc = t != null ? data : "error";
        return new Result(t, oh, msc);
    }

    public static Result Delete_ativition(Object t,String data){
        Integer oh = t != null ? DELETE_OK : DELETE_ERR;
        String msc = t != null ? data : "error";
        return new Result(t, oh, msc);
    }

    public static Result Update_ativition(Object t,String data){
        Integer oh = t != null ? UPDATA_OK : UPDATA_ERR;
        String msc = t != null ? data : "error";
        return new Result(t, oh, msc);
    }
}
