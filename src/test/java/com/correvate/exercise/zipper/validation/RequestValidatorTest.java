package com.correvate.exercise.zipper.validation;


import com.correvate.exercise.zipper.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.correvate.exercise.zipper.util.TestHelper.ORIGINAL_FILE_NAME;
import static com.correvate.exercise.zipper.util.TestHelper.ORIGINAL_FILE_NAME_SECOND;
import static com.correvate.exercise.zipper.util.TestHelper.PARAM_FILES;
import static com.correvate.exercise.zipper.util.TestHelper.TEST_FILE_CONTENT;
import static com.correvate.exercise.zipper.util.TestHelper.TEST_FILE_THE_SECOND;
import static com.correvate.exercise.zipper.util.TestHelper.getMockMultipartFile;

public class RequestValidatorTest {

    @Test
    public void testValidRequestNoExceptionThrownIfValid(){
        List<MultipartFile> files = Arrays.asList(getMockMultipartFile(ORIGINAL_FILE_NAME, TEST_FILE_CONTENT),
                getMockMultipartFile(ORIGINAL_FILE_NAME_SECOND, TEST_FILE_THE_SECOND));
        Assertions.assertDoesNotThrow(() ->
                RequestValidator.validRequest(files)
        );
    }

    @Test
    public void testValidRequestExceptionThrownIfInvalid(){
        List<MultipartFile> files = Collections.singletonList(new MockMultipartFile(PARAM_FILES, new byte[0]));
        Assertions.assertThrows(ValidationException.class, () -> {
            RequestValidator.validRequest(files);
        });
    }


}
