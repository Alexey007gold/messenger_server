package com.alex_koveckiy.common.router;

import com.alex_koveckiy.common.protocol.ActionHeader;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.impl.FirstRouter;
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
public class FirstRouterTest {

    @InjectMocks
    private FirstRouter firstRouter;

    @Test
    public void testGetName() {
        assertThat(firstRouter.getName(), is("first-router"));
    }

    @Test
    public void testGetRouteKey() {
        Request<?> request = new Request<>();
        ActionHeader header = new ActionHeader();
        header.setType("handler_one");
        request.setHeader(header);

        assertThat(firstRouter.getRouteKey(request), is("handler_one"));

        header.setType("handler_two");

        assertThat(firstRouter.getRouteKey(request), is("handler_two"));
    }
}
