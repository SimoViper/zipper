package com.correvate.exercise.zipper.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.correvate.exercise.zipper.util.TestHelper.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ZipServiceTest {

    @Autowired
    private ZipService zipService;

    @Test
    public void testZipFiles() throws IOException {

        List<MultipartFile> files = Arrays.asList(getMockMultipartFile(ORIGINAL_FILE_NAME, TEST_FILE_CONTENT),
                getMockMultipartFile(ORIGINAL_FILE_NAME_SECOND, TEST_FILE_THE_SECOND));

        byte[] result = zipService.zipFiles(files);

        assertNotNull(result);
        assertNotEquals(result.length, 0);
    }
}
