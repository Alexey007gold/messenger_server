package com.alex_koveckiy.common.router.api;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.protocol.ResponseData;

public interface RequestHandler<R extends ResponseData> extends Handler {
    Response<R> process(Request<?> data);
}
