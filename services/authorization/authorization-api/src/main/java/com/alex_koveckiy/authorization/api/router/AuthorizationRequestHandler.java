package com.alex_koveckiy.authorization.api.router;

import com.alex_koveckiy.common.protocol.ResponseData;
import com.alex_koveckiy.common.router.api.RequestHandler;

public interface AuthorizationRequestHandler<R extends ResponseData> extends RequestHandler<R> {
}
