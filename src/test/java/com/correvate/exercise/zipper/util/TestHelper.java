package com.correvate.exercise.zipper.util;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;

public class TestHelper {

    public static final String TEST_FILE_CONTENT = "Test File";
    public static final String TEST_FILE_THE_SECOND = "Test File The Second";
    public static final String ORIGINAL_FILE_NAME = "test.txt";
    public static final String ORIGINAL_FILE_NAME_SECOND = "test2.txt";
    public static final String PARAM_FILES = "files";
    public static final String ZIP = "/zip";

    public static MockMultipartFile getMockMultipartFile(String originalFileName, String fileContent) {
        return new MockMultipartFile(PARAM_FILES, originalFileName,
                MediaType.TEXT_PLAIN_VALUE, fileContent.getBytes(StandardCharsets.UTF_8));
    }
}
