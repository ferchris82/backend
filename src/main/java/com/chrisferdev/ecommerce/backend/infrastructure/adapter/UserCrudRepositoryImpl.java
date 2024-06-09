package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import com.chrisferdev.ecommerce.backend.domain.model.User;
import org.springframework.stereotype.Repository;

import com.chrisferdev.ecommerce.backend.domain.port.IUserRepository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository{
    private final IUserCrudRepository iUserCrudRepository;
    

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository) {
        this.iUserCrudRepository = iUserCrudRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
