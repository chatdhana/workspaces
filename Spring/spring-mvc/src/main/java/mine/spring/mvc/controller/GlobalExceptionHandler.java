package mine.spring.mvc.controller;

import java.util.Locale;

import mine.spring.mvc.common.MessageConstant;
import mine.spring.mvc.domain.dto.AbstractResponse;
import mine.spring.mvc.domain.dto.SimpleResponse;
import mine.spring.mvc.util.MessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageUtil messageUtil;

    @ExceptionHandler
    public ResponseEntity<AbstractResponse> handleException(Throwable exception, Locale locale, HttpHeaders httpHeaders)
            throws Exception {
        AbstractResponse responseBody = messageUtil.addFailureMessageToResponse(SimpleResponse.class, locale,
                MessageConstant.COMMON_INPUT_ERROR);
        ResponseEntity<AbstractResponse> response = new ResponseEntity<AbstractResponse>(responseBody,
                HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
