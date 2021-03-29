package com.correvate.exercise.zipper.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private String code;
    private String message;
}
