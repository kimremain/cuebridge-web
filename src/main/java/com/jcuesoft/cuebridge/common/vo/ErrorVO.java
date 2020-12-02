package com.jcuesoft.cuebridge.common.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorVO implements Serializable {

    private static final long serialVersionUID = -6019572782960950435L;

    static String status = HttpStatus.INTERNAL_SERVER_ERROR.toString(); 
    
    /**
     * 화면코드
     */
    String code;
    
    /**
     * 유저행위
     */
    String action;

    /**
     * 오류 메세지
     */
    String message;
    
    /**
     * userID
     */
    String userID;
    
    /**
     * Exception
     */
    Throwable ex;
    
    public ErrorVO(String code){
        this(status, code);
    }
    
    public ErrorVO(String status, Throwable ex){
        this(status, status, ex.getMessage(), ex);
    }
    
    
    public ErrorVO(String status, String code){
        this(status, code, "", new Exception(code));
    }
    

    public ErrorVO(String status, String code, String message){
        this(status, code, message, new Exception(message));
    }
    
    public ErrorVO(String status, String code, String mesage, Throwable ex){
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getException() {
        return ex;
    }

    public void setException(Throwable ex) {
        this.ex = ex;        
    }

}
