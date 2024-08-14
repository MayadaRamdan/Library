package com.Library.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatronNotFoundException extends RuntimeException {

    private String msg ;

}
