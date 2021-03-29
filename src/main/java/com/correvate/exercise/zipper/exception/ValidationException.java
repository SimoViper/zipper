package com.correvate.exercise.zipper.exception;

import com.correvate.exercise.zipper.model.Error;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ValidationException extends Exception {
    private Error error;
}
