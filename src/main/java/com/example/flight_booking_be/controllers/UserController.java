package com.example.flight_booking_be.controllers;

import com.example.flight_booking_be.dtos.ApiResponse;
import com.example.flight_booking_be.dtos.UserCreationDTO;
import com.example.flight_booking_be.dtos.UserUpdateDTO;
import com.example.flight_booking_be.entities.User;
import com.example.flight_booking_be.responses.Response;
import com.example.flight_booking_be.responses.UserResponse;
import com.example.flight_booking_be.services.user.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/identity")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create-users")
    Response<UserResponse> createUser(@RequestBody @Valid UserCreationDTO request) throws IOException {

        if(!Objects.equals(request.getPassword(), request.getRetypePassword())) {
            throw new IOException("Password and retype password not match !");
        }

        Response<UserResponse> apiResponse = new Response<>();

        User user = userService.createRequest(request);

        apiResponse.setData(UserResponse.fromUser(user));

        return apiResponse;
    }

    @GetMapping("/get-users")
    ApiResponse<List<User>> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<User>>builder()
                .result(userService.getUser())
                .build();
    }

    @GetMapping("/get-user/{userId}")
    User getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PutMapping("/edit-user/{userId}")
    User editUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateDTO request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/delete-user/{userId}")
    String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "User has been deleted!";
    }
}
