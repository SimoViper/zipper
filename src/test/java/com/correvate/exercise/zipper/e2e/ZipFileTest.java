package com.correvate.exercise.zipper.e2e;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.correvate.exercise.zipper.util.TestHelper.*;
import static com.correvate.exercise.zipper.util.TestHelper.TEST_FILE_THE_SECOND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZipFileTest {

    private static final String APPLICATION_ZIP = "application/zip";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnZipFile() throws Exception {
        mockMvc.perform(multipart(ZIP)
                .file(getMockMultipartFile(ORIGINAL_FILE_NAME, TEST_FILE_CONTENT))
                .file(getMockMultipartFile(ORIGINAL_FILE_NAME_SECOND, TEST_FILE_THE_SECOND)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_ZIP));
    }
}
