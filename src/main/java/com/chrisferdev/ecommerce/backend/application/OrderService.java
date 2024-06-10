package com.chrisferdev.ecommerce.backend.application;

import com.chrisferdev.ecommerce.backend.domain.model.Order;
import com.chrisferdev.ecommerce.backend.domain.port.IOrderRepository;

public class OrderService {

    private final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    public Order save(Order order) {
        return this.iOrderRepository.save(order);
    }

    public Iterable<Order> findAll() {
        return this.iOrderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Integer userId) {
        return this.iOrderRepository.findByUserId(userId);
    }

    public void updateStateById(Integer id, String state) {
        this.iOrderRepository.updateStateById(id, state);
    }
}
