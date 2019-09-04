package com.api.resto.pop.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(){
        super("Id not found");
    }
}
