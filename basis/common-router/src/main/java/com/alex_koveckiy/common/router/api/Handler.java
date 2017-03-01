package com.alex_koveckiy.common.router.api;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;

public interface Handler {
    String getName();
    Response<?> handle(final Request<?> msg);
}
