package com.chrisferdev.ecommerce.backend.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.chrisferdev.ecommerce.backend.domain.model.Product;
import com.chrisferdev.ecommerce.backend.infrastructure.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings(
        {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "urlImage", target = "urlImage"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated"),
            @Mapping(source = "userEntity.id", target = "userId"),
            @Mapping(source = "categoryEntity.id", target = "categoryId")
        }
    )

    Product toProduct(ProductEntity productEntity);
    Iterable<Product> toProductList(Iterable<ProductEntity> productEntity);

    @InheritInverseConfiguration
    ProductEntity tProductEntity(Product product);
}
