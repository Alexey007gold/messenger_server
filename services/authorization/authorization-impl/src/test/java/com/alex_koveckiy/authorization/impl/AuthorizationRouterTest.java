package com.alex_koveckiy.authorization.impl;

import com.alex_koveckiy.authorization.impl.router.AuthorizationRouter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 02.03.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationRouterTest {

    @InjectMocks
    private AuthorizationRouter authorizationRouter;

    @Test
    public void testGetName() {
        assertThat(authorizationRouter.getName(), is("authorization"));
    }
}
