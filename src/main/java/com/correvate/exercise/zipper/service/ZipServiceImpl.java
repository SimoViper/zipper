package com.correvate.exercise.zipper.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@Service
public class ZipServiceImpl implements ZipService{

    private static final String REQUEST_FULFILLED = "Request Fulfilled";

    @Override
    public byte[] zipFiles(List<MultipartFile> files) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);

        for(MultipartFile file : files) {
            zipOutputStream.putNextEntry(new ZipEntry(Objects.nonNull(file.getOriginalFilename()) ? file.getOriginalFilename() : ""));
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream, zipOutputStream);
            inputStream.close();
            zipOutputStream.closeEntry();
        }
        zipOutputStream.finish();
        zipOutputStream.flush();
        zipOutputStream.close();

        log.info(REQUEST_FULFILLED);
        return byteArrayOutputStream.toByteArray();
    }
}
