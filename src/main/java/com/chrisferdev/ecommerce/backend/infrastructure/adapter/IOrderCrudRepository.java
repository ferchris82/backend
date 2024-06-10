package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.chrisferdev.ecommerce.backend.domain.model.OrderState;
import com.chrisferdev.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.chrisferdev.ecommerce.backend.infrastructure.entity.UserEntity;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer>{

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.state = :state WHERE o.id = :id")
    void updateStateById(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);
}
