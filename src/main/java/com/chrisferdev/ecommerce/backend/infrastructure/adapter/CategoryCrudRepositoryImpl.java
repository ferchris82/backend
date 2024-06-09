package com.chrisferdev.ecommerce.backend.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.chrisferdev.ecommerce.backend.domain.model.Category;
import com.chrisferdev.ecommerce.backend.domain.port.ICategoryRepository;
import com.chrisferdev.ecommerce.backend.infrastructure.mapper.CategoryMapper;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList(iCategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
            ()-> new RuntimeException("Categoría con id:"+id+ " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.deleteById(id);
    }

}
