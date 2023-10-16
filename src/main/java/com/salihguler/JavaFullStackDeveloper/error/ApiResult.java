package com.salihguler.JavaFullStackDeveloper.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
//Spring Fremworke gelen errorları kendimize göre yakalamak
//Eğer sistemde Null varsa BAckende göndermee (Jackson: Objeyi Json a çevirir)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    //MESC
    private int status;
    private String path;
    private String message;
    private String error;
    private Date createdDate=new Date(System.currentTimeMillis());
    private Map<String,String> validationErrors;

    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }

    public ApiResult(int status, String path, String message, String error) {
        this.status = status;
        this.path = path;
        this.message = message;
        this.error = error;
    }

    public ApiResult()
    {

    }



}
