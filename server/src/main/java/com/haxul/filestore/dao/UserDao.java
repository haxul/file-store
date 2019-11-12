package com.haxul.filestore.dao;

import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Integer> {

    UserEntity findUserEntityByUsername(String username);

    @Modifying
    @Query("update UserEntity u set u.fileEntities = ?1 where u.id = ?2")
    int updateFilesForUser(List<FileEntity> files, int id);

}