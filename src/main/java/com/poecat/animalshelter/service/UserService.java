package com.poecat.animalshelter.service;

import com.poecat.animalshelter.model.UserRegistrationDto;
import com.poecat.animalshelter.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

}
