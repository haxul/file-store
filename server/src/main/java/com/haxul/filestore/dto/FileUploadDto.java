package com.haxul.filestore.dto;


import com.haxul.filestore.models.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FileUploadDto {

    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public FileUploadDto(MultipartFile[] files) {
        this.files = files;
    }
}
