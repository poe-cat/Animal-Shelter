package com.poecat.animalshelter.service;

import com.poecat.animalshelter.model.Role;
import com.poecat.animalshelter.model.User;
import com.poecat.animalshelter.model.UserRegistrationDto;
import com.poecat.animalshelter.repository.UserRepository;
import com.poecat.animalshelter.security.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@Import({SecurityConfiguration.class})
public class UserServiceTest {

    private UserRegistrationDto userDto;

    @MockBean
    private SecurityConfiguration securityConfiguration;

    @Test
    public void shouldSaveNewUser() {

        //given
        userDto = prepareUserRegistrationData();

        User user = new User(userDto.getFirstName(), userDto.getLastName(),
                userDto.getEmail(), userDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));

        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        //when
        Mockito.when(securityConfiguration.passwordEncoder()).thenReturn(new BCryptPasswordEncoder());
        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.save(userDto);

        //then
        assertThat(userService.getAllUsers(), hasSize(1));

    }


    private UserRegistrationDto prepareUserRegistrationData() {

        userDto = new UserRegistrationDto("Alolan", "Vulpix",
                "alola@gmail.com", "poke");

        return userDto;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
