package com.Library.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookNotFoundException extends RuntimeException {

    private String msg ;

}
