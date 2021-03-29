package com.correvate.exercise.zipper.validation;

import com.correvate.exercise.zipper.exception.ValidationException;
import com.correvate.exercise.zipper.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
public class RequestValidator {

    private static final String VALIDATION_FAILED = "Validation Failed";

    public static void validRequest(List<MultipartFile> files) throws ValidationException {
        if(files.size() == 1 && files.get(0).isEmpty()){
            log.error(VALIDATION_FAILED);
            throw new ValidationException(Error.VALIDATION_ERROR_EMPTY_LIST);
        }
    }
}

