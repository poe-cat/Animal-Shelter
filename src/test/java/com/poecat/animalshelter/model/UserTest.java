package com.poecat.animalshelter.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTest {

    @Test
    public void shouldSaveUserRoles() {

        //given
        User user = new User();
        List<Role> roles = new ArrayList<>();

        //when
        roles.add(new Role("USER"));
        roles.add(new Role("MODERATOR"));
        user.setRoles(roles);

        //then
        assertAll(
                () -> assertThat(user.getRoles(), is(not(emptyCollectionOf(Role.class)))),
                () -> assertThat(user.getRoles().stream().toList().size(), is(2)),
                () -> assertThat(user.getRoles(), is(not(empty())))
                );
    }
}
