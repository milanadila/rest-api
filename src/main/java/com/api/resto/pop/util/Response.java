package com.api.resto.pop.util;

import lombok.Data;

@Data
public class Response<T> {

    private String messsage;
    private T data;
}
