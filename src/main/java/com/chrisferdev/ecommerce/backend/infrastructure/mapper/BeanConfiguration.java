package com.chrisferdev.ecommerce.backend.infrastructure.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chrisferdev.ecommerce.backend.application.UserService;
import com.chrisferdev.ecommerce.backend.domain.port.IUserRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }
}
