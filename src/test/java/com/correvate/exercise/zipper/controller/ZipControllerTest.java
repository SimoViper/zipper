package com.correvate.exercise.zipper.controller;

import com.correvate.exercise.zipper.service.ZipService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static com.correvate.exercise.zipper.util.TestHelper.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class ZipControllerTest {

    private static final String ZIP_FILE = "zip file";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZipService zipService;

    @Test
    public void shouldReturnZipFile() throws Exception {
        when(zipService.zipFiles(any())).thenReturn(ZIP_FILE.getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(multipart(ZIP)
                .file(getMockMultipartFile(ORIGINAL_FILE_NAME, TEST_FILE_CONTENT))
                .file(getMockMultipartFile(ORIGINAL_FILE_NAME_SECOND, TEST_FILE_THE_SECOND)))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(ZIP_FILE)));

        verify(zipService).zipFiles(any());
    }

    @Test
    public void shouldReturnBadRequestIfNoFiles() throws Exception {
        mockMvc.perform(multipart(ZIP)
                .file(new MockMultipartFile(PARAM_FILES, new byte[0])))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code", is("VALIDATION_ERROR_EMPTY_LIST")))
                .andExpect(jsonPath("$.message", is("Input file list Empty")));

        verify(zipService, never()).zipFiles(any());
    }


}
