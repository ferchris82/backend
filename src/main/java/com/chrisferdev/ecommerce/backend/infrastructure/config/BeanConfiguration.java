package com.chrisferdev.ecommerce.backend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chrisferdev.ecommerce.backend.application.CategoryService;
import com.chrisferdev.ecommerce.backend.application.UserService;
import com.chrisferdev.ecommerce.backend.domain.port.ICategoryRepository;
import com.chrisferdev.ecommerce.backend.domain.port.IUserRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){
        return new CategoryService(iCategoryRepository);
    }
}
