package com.haxul.filestore.services;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.dto.FileUploadDto;
import com.haxul.filestore.helpers.RandomString;
import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadService {

    private static final String UPLOADED_FOLDER = "/home/haxul/IdeaProjects/file-store/server/upload/";

    @Autowired
    private RandomString randomString;

    @Autowired
    private UserDao userDao;

    @Autowired
    private FileDao fileDao;

    @Transactional
    public void uploadFile(FileUploadDto inputFiles, String username) throws IOException {
        UserEntity currentUser = userDao.findUserEntityByUsername(username);
        List<FileEntity> fileList = new ArrayList<>();

        File dir = new File(UPLOADED_FOLDER);
        MultipartFile[] files = inputFiles.getFiles();

        for (MultipartFile file : files) {
            byte[] bytes = file.getBytes();
            if (!dir.exists()) dir.mkdirs();

            String fileName = randomString.generate(20) + "__" + file.getOriginalFilename();
            String path = dir.getAbsolutePath() + File.separator + fileName;

            File uploadFile = new File(path);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
            outputStream.write(bytes);

            FileEntity fileEntity = new FileEntity(fileName, path, currentUser);
            fileDao.save(fileEntity);
            fileList.add(fileEntity);

            outputStream.close();
        }
        List<FileEntity> currentUserFileList = currentUser.getFileEntities();
        fileList.addAll(currentUserFileList);
        currentUser.setFileEntities(fileList);
    }
}
