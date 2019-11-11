package com.haxul.filestore.dao;


import com.haxul.filestore.models.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends CrudRepository<FileEntity, Integer> {

}