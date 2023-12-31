package com.ssafy.cozytrain.common.handler;
import com.ssafy.cozytrain.common.exception.NoContentException;
import com.ssafy.cozytrain.common.exception.NotFoundException;
import com.ssafy.cozytrain.common.exception.AccessTokenExpiredException;
import com.ssafy.cozytrain.common.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.ssafy.cozytrain.common.utils.ApiUtils.error;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            NoHandlerFoundException.class,
            NotFoundException.class,
            Exception.class
    })
    public ResponseEntity<ApiUtils.ApiResult<?>> handleNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error(e, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<ApiUtils.ApiResult<?>> handleValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler({
            AccessTokenExpiredException.class
    })
    public ResponseEntity<ApiUtils.ApiResult<?>> handleTokenException(AccessTokenExpiredException e) {
        log.info("err: " + e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error(e, HttpStatus.UNAUTHORIZED));
    }

    @ExceptionHandler({
            NoContentException.class
    })
    public ResponseEntity<ApiUtils.ApiResult<?>> handleNoContentException(Exception e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error(e, HttpStatus.NO_CONTENT));
    }
}