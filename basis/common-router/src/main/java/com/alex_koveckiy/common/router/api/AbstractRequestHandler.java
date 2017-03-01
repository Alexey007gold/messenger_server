package com.alex_koveckiy.common.router.api;


import com.alex_koveckiy.common.datamapper.DataMapper;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.RequestData;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.protocol.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler<R> {

    @Autowired
    private DataMapper dataMapper;

    private final Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public Response<R> handle(Request<?> msg) {
        Request<T> request = new Request<>();
        request.setHeader(msg.getHeader());
        request.setData(dataMapper.convert(msg.getData(), clazz));

        return process(request);
    }
}
