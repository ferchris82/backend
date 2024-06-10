package com.chrisferdev.ecommerce.backend.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderProduct {

    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer productId; 

    public BigDecimal getTotalItem(){
        return this.price.multiply(quantity);
    }
}
