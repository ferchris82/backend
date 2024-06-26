package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;

import com.chrisferdev.ecommerce.backend.infrastructure.entity.UserEntity;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer>{

}
