package com.alex_koveckiy.common.router;

import com.alex_koveckiy.common.protocol.ActionHeader;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.api.AbstractByCommandRouterHandler;
import com.alex_koveckiy.common.router.api.Handler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 02.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractByCommandRouterHandlerTest {

    @InjectMocks
    private AbstractByCommandRouterHandler<Handler> handler =
            Mockito.mock(AbstractByCommandRouterHandler.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void testGetRouteKey() {
        Request<?> request = new Request<>();
        ActionHeader header = new ActionHeader();
        header.setCommand("handler_one");
        request.setHeader(header);

        assertThat(handler.getRouteKey(request), is("handler_one"));

        header.setCommand("handler_two");

        assertThat(handler.getRouteKey(request), is("handler_two"));
    }
}
