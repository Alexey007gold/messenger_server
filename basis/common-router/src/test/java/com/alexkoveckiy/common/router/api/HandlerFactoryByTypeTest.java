package com.alexkoveckiy.common.router.api;

import com.alexkoveckiy.common.protocol.ActionHeader;
import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.router.impl.HandlerFactoryByType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 20.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class HandlerFactoryByTypeTest {

    @InjectMocks
    private HandlerFactoryByTypeMock handlerFactory = Mockito.mock(HandlerFactoryByTypeMock.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void getRouteKeyTest() {
        Request<?> request1 = new Request<>();
        ActionHeader header1 = new ActionHeader();
        header1.setType("handler_one");
        request1.setHeader(header1);
        Request<?> request2 = new Request<>();
        ActionHeader header2 = new ActionHeader();
        header2.setType("handler_two");
        request2.setHeader(header2);

        assertThat(handlerFactory.getRouteKey(request1), is("handler_one"));
        assertThat(handlerFactory.getRouteKey(request2), is("handler_two"));
    }

    private class HandlerFactoryByTypeMock extends HandlerFactoryByType {
        @Override
        protected String getRouteKey(Request msg) {
            return super.getRouteKey(msg);
        }
    }
}
