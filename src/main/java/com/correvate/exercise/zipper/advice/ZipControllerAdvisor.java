package com.correvate.exercise.zipper.advice;


import com.correvate.exercise.zipper.exception.ValidationException;
import com.correvate.exercise.zipper.model.Error;
import com.correvate.exercise.zipper.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ZipControllerAdvisor {

    private static final String ERROR_ZIP_FILE = "Error occurred creating zip file";
    private static final String GENERIC_ERROR = "Error occurred during transaction";
    private static final String VALIDATION_FAILED = "Validation Failed";
    public static final String LIMIT_SIZE_EXCEEDED = "Limit size exceeded";

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(
            IOException ex) {
        log.error(ERROR_ZIP_FILE, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .code(Error.ZIP_CREATION_EXCEPTION.name())
                        .message(Error.ZIP_CREATION_EXCEPTION.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            IOException ex) {
        log.error(GENERIC_ERROR, ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .code(Error.GENERIC_ERROR.name())
                        .message(Error.GENERIC_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            ValidationException ex) {
        log.error(VALIDATION_FAILED, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .code(ex.getError().name())
                        .message(ex.getError().getMessage())
                        .build());
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ErrorResponse> handleSizeLimitException(
            MultipartException ex) {
        log.error(LIMIT_SIZE_EXCEEDED, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .code(Error.LIMIT_SIZE_EXCEEDED_ERROR.name())
                        .message(Error.LIMIT_SIZE_EXCEEDED_ERROR.getMessage())
                        .build());
    }
}
