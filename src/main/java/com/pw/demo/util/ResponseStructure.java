package com.pw.demo.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
@Getter
@Setter
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;
}
