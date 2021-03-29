package com.correvate.exercise.zipper.validation;

import com.correvate.exercise.zipper.exception.ValidationException;
import com.correvate.exercise.zipper.model.Error;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RequestValidator {

    public static void validRequest(List<MultipartFile> files) throws ValidationException {
        if(files.size() == 1 && files.get(0).isEmpty()){
            throw new ValidationException(Error.VALIDATION_ERROR_EMPTY_LIST);
        }
    }
}
