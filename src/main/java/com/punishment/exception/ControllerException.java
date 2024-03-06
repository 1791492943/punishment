package com.punishment.exception;

import com.punishment.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(Exception.class)
    public R<String> exception(Exception e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

}
