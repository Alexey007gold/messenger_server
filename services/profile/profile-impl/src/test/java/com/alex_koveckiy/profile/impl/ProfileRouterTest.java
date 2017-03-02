package com.alex_koveckiy.profile.impl;

import com.alex_koveckiy.profile.impl.router.ProfileRouter;
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
public class ProfileRouterTest {

    @InjectMocks
    private ProfileRouter profileRouter;

    @Test
    public void testGetName() {
        assertThat(profileRouter.getName(), is("profile"));
    }
}
