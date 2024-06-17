package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;

import com.chrisferdev.ecommerce.backend.infrastructure.entity.UserEntity;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer>{
    Optional<UserEntity> findByEmail(String email);
}
