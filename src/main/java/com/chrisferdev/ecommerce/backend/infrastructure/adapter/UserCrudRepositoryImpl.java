package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import com.chrisferdev.ecommerce.backend.domain.model.User;
import org.springframework.stereotype.Repository;

import com.chrisferdev.ecommerce.backend.domain.port.IUserRepository;
import com.chrisferdev.ecommerce.backend.infrastructure.mapper.UserMapper;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository{
    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(iUserCrudRepository.findById(id).get());
    }
}
