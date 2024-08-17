package com.example.flight_booking_be.exception;

import com.example.flight_booking_be.dtos.ApiResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode){
        super(errorCode.getMessgae());
        this.errorCode = errorCode;
    }
}
