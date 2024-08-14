package com.Library.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class ApiResponse  implements Serializable {

    private HttpStatus code ;
    private String errorMessage ;
    private Object data ;

    public static ApiResponse of (HttpStatus httpStatus, String msg){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.code=httpStatus ;
        apiResponse.errorMessage= msg;

        return apiResponse;
    }

    public static ApiResponse ok(Object data){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.code=HttpStatus.OK ;
        apiResponse.data =data;

        return apiResponse;
    }


    public static ApiResponse ok( ){

        ApiResponse apiResponse=new ApiResponse();
        apiResponse.code=HttpStatus.OK ;
        return apiResponse;
    }
}
