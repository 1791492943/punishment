package com.punishment.exception;

import com.punishment.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> handleValidationExceptions(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();

        if (fieldError != null) {
            String message = fieldError.getDefaultMessage();
            return R.error(message);
        }

        return R.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<String> exception(Exception e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }



}
