package com.haxul.filestore.dao;


import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao extends CrudRepository<FileEntity, Integer> {
    FileEntity findFileEntityById(int id);

    List<FileEntity> findFileEntitiesByUserEntity_IdOrderByCreatedDesc(int id, Pageable pageable);

//    @Query("SELECT f FROM FileEntity f where f.userEntity=:id ORDER BY f.created")
//    List<FileEntity> getAllFiles(int id, int limit, int offset);

}