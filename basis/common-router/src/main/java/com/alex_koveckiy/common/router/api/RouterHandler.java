package com.alex_koveckiy.common.router.api;

import com.alex_koveckiy.common.protocol.Request;

public interface RouterHandler extends Handler {
	String getRouteKey(final Request<?> msg);
}
