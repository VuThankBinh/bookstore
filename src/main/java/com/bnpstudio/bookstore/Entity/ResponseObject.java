package com.bnpstudio.bookstore.entity;

import org.springframework.http.HttpStatus;

<<<<<<< HEAD
public class ResponseObject<T> {
    private HttpStatus status;
    private String message;
    private T data;
    public ResponseObject() {
    }
    public ResponseObject(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    private HttpStatus status;
    private String message;
    private Object data;
    
>>>>>>> 60c801f62ae8a157964bd06ff44336f750454601
    
}
