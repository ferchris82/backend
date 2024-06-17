package com.chrisferdev.ecommerce.backend.application;

import com.chrisferdev.ecommerce.backend.domain.model.User;
import com.chrisferdev.ecommerce.backend.domain.port.IUserRepository;

public class RegistrationService {
    private final IUserRepository iUserRepository;

    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User register(User user){
        return iUserRepository.save(user);
    }
}
