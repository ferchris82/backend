package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.chrisferdev.ecommerce.backend.domain.model.Product;
import com.chrisferdev.ecommerce.backend.domain.port.IProductRepository;
import com.chrisferdev.ecommerce.backend.infrastructure.mapper.ProductMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ProductCrudRepositoryImpl implements IProductRepository {
    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(iProductCrudRepository.save(productMapper.tProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct(iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id: " + id + " no existe")));
    }

    @Override
    public void deleteById(Integer id) {
        iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id: " + id + " no existe"));
        iProductCrudRepository.deleteById(id);
    }

}
