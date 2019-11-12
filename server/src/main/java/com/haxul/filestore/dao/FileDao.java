package com.haxul.filestore.dao;


import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao extends CrudRepository<FileEntity, Integer> {
    FileEntity findFileEntityById(int id);
    List<FileEntity> findFileEntitiesByUserEntityId(int id);
}