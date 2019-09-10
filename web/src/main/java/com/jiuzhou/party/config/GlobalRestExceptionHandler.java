package com.jiuzhou.party.config;

import com.jiuzhou.party.base.BaseResponse;
import com.jiuzhou.party.base.excep.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler({ NoHandlerFoundException.class })
    public BaseResponse notFoundException(Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        BaseResponse errorResponse = new BaseResponse("404", "Not Found");
        return errorResponse;
    }

    @ExceptionHandler({ Exception.class })
    public BaseResponse globalException(Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        BaseResponse errorResponse = new BaseResponse("500", e.getMessage());
        log.error("执行逻辑错误",e);
        return errorResponse;
    }

    @ExceptionHandler({ ApiException.class })
    public BaseResponse apiException(ApiException e, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        BaseResponse errorResponse = new BaseResponse(e.getCode(), e.getMessage());
        return errorResponse;
    }
}