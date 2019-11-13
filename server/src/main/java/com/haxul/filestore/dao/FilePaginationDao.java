package com.haxul.filestore.dao;

import com.haxul.filestore.models.FileEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FilePaginationDao extends PagingAndSortingRepository<FileEntity, Integer> {
    List<FileEntity> findFileEntitiesByUserEntity_Id(int id, Pageable pageable);
}
