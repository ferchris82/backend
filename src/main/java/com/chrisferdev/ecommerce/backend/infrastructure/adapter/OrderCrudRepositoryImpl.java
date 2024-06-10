package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import com.chrisferdev.ecommerce.backend.domain.model.Order;
import com.chrisferdev.ecommerce.backend.domain.model.OrderState;
import com.chrisferdev.ecommerce.backend.domain.port.IOrderRepository;
import com.chrisferdev.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.chrisferdev.ecommerce.backend.infrastructure.entity.UserEntity;
import com.chrisferdev.ecommerce.backend.infrastructure.mapper.IOrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCrudRepositoryImpl implements IOrderRepository {
    private final IOrderMapper iOrderMapper;
    private final IOrderCrudRepository iOrderCrudRepository;

    public OrderCrudRepositoryImpl(IOrderMapper iOrderMapper, IOrderCrudRepository iOrderCrudRepository) {
        this.iOrderMapper = iOrderMapper;
        this.iOrderCrudRepository = iOrderCrudRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);

        orderEntity.getOrderProduts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return iOrderMapper.toOrder(iOrderCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Orden con Id: "+ id+" no encontrada")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Integer id, String state) {
        if(state.equals(OrderState.CANCELED)){
            iOrderCrudRepository.updateStateById(id,OrderState.CANCELED);
        }else{
            iOrderCrudRepository.updateStateById(id,OrderState.CONFIRMED);
        }
    }
}
