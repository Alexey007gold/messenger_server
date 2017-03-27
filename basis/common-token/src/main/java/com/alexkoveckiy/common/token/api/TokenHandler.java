package com.alexkoveckiy.common.token.api;

import com.alexkoveckiy.common.exceptions.InvalidTokenException;
import com.alexkoveckiy.common.protocol.RoutingData;
import org.jose4j.jwt.JwtClaims;

/**
 * Created by alex on 11.03.17.
 */
public interface TokenHandler {
    String createDeviceToken(String userId, String deviceId) throws InvalidTokenException;
    String createTemporaryToken(String userId, String deviceId) throws InvalidTokenException;
    String getProfileIdFromDeviceToken(String token) throws InvalidTokenException;
    JwtClaims getClaimsFromDeviceToken(String token) throws InvalidTokenException;
    RoutingData getRoutingDataFromTemporaryToken(String token) throws InvalidTokenException;
}
