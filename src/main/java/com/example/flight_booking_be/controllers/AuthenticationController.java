package com.example.flight_booking_be.controllers;

import com.example.flight_booking_be.dtos.ApiResponse;
import com.example.flight_booking_be.dtos.AuthenticationRequest;
import com.example.flight_booking_be.dtos.IntrospectRequest;
import com.example.flight_booking_be.responses.AuthenticationResponse;
import com.example.flight_booking_be.responses.IntrospectResponse;
import com.example.flight_booking_be.responses.Response;
import com.example.flight_booking_be.services.user.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    Response<String> authenticate(@RequestBody AuthenticationRequest request){
        var result =  authenticationService.authenticate(request);
        return Response.<String>builder()
                .data(result.getToken())
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException{
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

}
