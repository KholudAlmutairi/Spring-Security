package com.example.demo.Api;

public class ApiException extends RuntimeException{
    public ApiException (String massage){
        super(massage);
    }
}

