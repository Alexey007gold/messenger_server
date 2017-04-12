package com.alexkoveckiy.common.protocol;

import java.util.UUID;

import static com.alexkoveckiy.common.protocol.ResponseFactory.ResponseStatusEnum.OK;

/**
 * Created by alex on 06.04.17.
 */
public class ResponseFactory {

    public static <T extends ResponseData> Response<T> createResponse(Request<?> req, T data) {
        Response<T> response = new Response<>();
        setHeader(req, response);
        response.setData(data);
        response.setStatus(new ResponseStatus(OK.code, OK.message));
        return response;
    }

    public static <T extends ResponseData> Response<T> createResponse(Request<?> req, ResponseStatusEnum status) {
        Response<T> response = new Response<>();
        setHeader(req, response);
        response.setStatus(new ResponseStatus(status.code, status.message));
        return response;
    }

    public static <T extends ResponseData> Response<T> createResponse(ActionHeader header, T data) {
        Response<T> response = new Response<>();
        response.setHeader(header);
        response.setData(data);
        response.setStatus(new ResponseStatus(OK.code, OK.message));
        return response;
    }

    public static <T extends ResponseData> Response<T> createResponse(Request<?> req, ResponseStatusEnum status, String message) {
        Response<T> response = new Response<>();
        setHeader(req, response);
        response.setStatus(new ResponseStatus(status.code, status.message + " (" + message + ")"));
        return response;
    }

    private static <T extends ResponseData> void setHeader(Request<?> req, Response<T> response) {
        response.setHeader(new ActionHeader(UUID.randomUUID().toString(), req.getHeader().getUuid(),
                req.getHeader().getCommand(), req.getHeader().getType(), req.getHeader().getVersion()));
    }

    public enum ResponseStatusEnum {
        OK(200, "Ok"),
        BAD_REQUEST(400, "Bad request"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not found"),
        NOT_ACCEPTABLE(422, "Not acceptable"),
        UNPROCESSABLE_ENTITY(422, "Unprocessable entity"),
        TOO_MANY_REQUESTS(429, "Too many requests"),
        INTERNAL_SERVER_ERROR(500, "Internal server error"),
        NOT_IMPLEMENTED(501, "Not implemented");

        private final int code;
        private final String message;

        ResponseStatusEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
