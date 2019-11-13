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

    @Query("select u.fileEntities from UserEntity u where u.id =?1 ")
    List<FileEntity> findFilesByUserId(int id);

}