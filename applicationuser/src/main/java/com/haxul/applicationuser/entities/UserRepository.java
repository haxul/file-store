package com.haxul.applicationuser.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
