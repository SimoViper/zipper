package com.correvate.exercise.zipper.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ZipService {

    byte[] zipFiles(List<MultipartFile> files) throws IOException;

}
