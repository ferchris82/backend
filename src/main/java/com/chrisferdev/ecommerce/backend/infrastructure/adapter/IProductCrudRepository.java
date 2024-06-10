package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;

import com.chrisferdev.ecommerce.backend.infrastructure.entity.ProductEntity;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}

