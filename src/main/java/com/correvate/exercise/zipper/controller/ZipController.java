package com.correvate.exercise.zipper.controller;

import com.correvate.exercise.zipper.exception.ValidationException;
import com.correvate.exercise.zipper.service.ZipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.correvate.exercise.zipper.validation.RequestValidator.validRequest;

@Slf4j
@RestController("/files")
public class ZipController {

    private static final String REQUEST_RECEIVED = "Zip Request received for ";
    private static final String FILES = " files";

    private final ZipService zipService;

    public ZipController(ZipService zipService) {
        this.zipService = zipService;
    }

    @PostMapping(path = "/zip", produces="application/zip")
    public  byte[] zip(@RequestParam("files") List<MultipartFile> files) throws IOException, ValidationException {
        log.info(REQUEST_RECEIVED + files.size() + FILES);
            validRequest(files);
            return zipService.zipFiles(files);
    }
}
