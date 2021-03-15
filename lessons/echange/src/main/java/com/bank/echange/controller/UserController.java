package com.bank.echange.controller;

import com.bank.echange.dto.UserDto;
import com.bank.echange.entity.User;
import com.bank.echange.repositori.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserRepository userRepository;

    @PostMapping
    public Long createUser(@RequestBody UserDto user) {
        userRepository.save(new User()
        .setFirstName(user.getFirstName()))
                .setLastName(user.getLastName())
                .setPhone(user.getPhone());
        return -1L;
    }
}
