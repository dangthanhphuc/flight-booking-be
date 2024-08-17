package com.example.flight_booking_be.services.user;

import com.example.flight_booking_be.dtos.UserCreationDTO;
import com.example.flight_booking_be.dtos.UserUpdateDTO;
import com.example.flight_booking_be.entities.User;
import com.example.flight_booking_be.enums.Role;
import com.example.flight_booking_be.exception.AppException;
import com.example.flight_booking_be.exception.ErrorCode;
import com.example.flight_booking_be.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepo userRepository;
    PasswordEncoder passwordEncoder;

    public User createRequest(UserCreationDTO request){
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        passwordEncoder = new BCryptPasswordEncoder(5);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(roles);

        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found!"));
    }

    public User updateUser(Long userId, UserUpdateDTO request){
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
