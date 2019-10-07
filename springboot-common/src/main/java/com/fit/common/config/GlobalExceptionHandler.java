package com.fit.common.config;

import com.fit.common.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-05
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public ResponseVo handle(HttpServletRequest request, Exception e) {
        log.error("{} invoke error:", request.getRequestURL(), e);
        return ResponseVo.failWith(e.getMessage());
    }

}
