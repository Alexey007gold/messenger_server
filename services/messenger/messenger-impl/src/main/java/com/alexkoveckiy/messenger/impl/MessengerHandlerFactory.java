package com.alexkoveckiy.messenger.impl;

import com.alexkoveckiy.common.router.api.HandlerFactoryByCommand;
import com.alexkoveckiy.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 23.02.17.
 */

@Component
public class MessengerHandlerFactory extends HandlerFactoryByCommand<MessengerRequestHandler> {
}