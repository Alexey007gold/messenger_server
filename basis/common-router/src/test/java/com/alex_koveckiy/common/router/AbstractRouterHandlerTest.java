package com.alex_koveckiy.common.router;

import com.alex_koveckiy.common.protocol.ActionHeader;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.api.AbstractRouterHandler;
import com.alex_koveckiy.common.router.api.Handler;
import com.alex_koveckiy.common.router.api.HandlerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by alex on 02.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractRouterHandlerTest {

    @InjectMocks
    private AbstractRouterHandler<Handler> handler =
            Mockito.mock(AbstractRouterHandler.class, Mockito.CALLS_REAL_METHODS);

    @Spy
    private HandlerFactory handlerFactory;

    private Handler handler1;
    private Handler handler2;

    private Request<?> request1;
    private Request<?> request2;

    @Before
    public void init() {
        handler1 = (Mockito.mock(Handler.class));
        handler2 = (Mockito.mock(Handler.class));

        request1 = new Request<>();
        ActionHeader header1 = new ActionHeader();
        header1.setType("handler_one");
        request1.setHeader(header1);
        request2 = new Request<>();
        ActionHeader header2 = new ActionHeader();
        header2.setType("handler_two");
        request2.setHeader(header2);

        when(handler.getRouteKey(request1)).thenReturn("handler_one");
        when(handler.getRouteKey(request2)).thenReturn("handler_two");

        when(handlerFactory.getHandler("handler_one")).thenReturn(handler1);
        when(handlerFactory.getHandler("handler_two")).thenReturn(handler2);
    }

    @Test
    public void testHandle() {
        handler.handle(request1);

        verify(handler1).handle(request1);
        verify(handler2, never()).handle(any());

        handler.handle(request2);

        verify(handler1).handle(request1);
        verify(handler2).handle(request2);
    }
}
