package com.chrisferdev.ecommerce.backend.infrastructure.config;

import com.chrisferdev.ecommerce.backend.application.OrderService;
import com.chrisferdev.ecommerce.backend.domain.port.IOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chrisferdev.ecommerce.backend.application.CategoryService;
import com.chrisferdev.ecommerce.backend.application.ProductService;
import com.chrisferdev.ecommerce.backend.application.UserService;
import com.chrisferdev.ecommerce.backend.domain.port.ICategoryRepository;
import com.chrisferdev.ecommerce.backend.domain.port.IProductRepository;
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

    @Bean
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }
}
