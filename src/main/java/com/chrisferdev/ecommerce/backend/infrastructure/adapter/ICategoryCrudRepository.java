package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;

import com.chrisferdev.ecommerce.backend.infrastructure.entity.CategoryEntity;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer>{
    
}
