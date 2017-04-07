package com.alexkoveckiy.common.router.api;

import com.alexkoveckiy.common.datamapper.DataMapper;
import com.alexkoveckiy.common.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {

    @Autowired
    private DataMapper dataMapper;

    private final Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public Response<?> handle(Request<?> msg) {
        Request<T> request = new Request<>();
        request.setHeader(msg.getHeader());
        request.setRoutingData(msg.getRoutingData());
        request.setData(dataMapper.convert(msg.getData(), clazz));

        try {
            return process(request);
        } catch (Exception e) {
            return ResponseFactory.createResponse(request, INTERNAL_SERVER_ERROR);
        }
    }

    protected abstract Response<R> process(Request<T> msg);
}
