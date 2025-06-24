package org.codetime.gestionstock.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.codetime.gestionstock.dto.CategoryDto;
import org.codetime.gestionstock.exception.EntityNotFoundException;
import org.codetime.gestionstock.exception.ErrorCodes;
import org.codetime.gestionstock.repository.ArticleRepository;
import org.codetime.gestionstock.repository.CategoryRepository;
import org.codetime.gestionstock.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private ArticleRepository articleRepository;

    public CategoryServiceImpl(ArticleRepository articleRepository, CategoryService categoryService, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCode(String code) {
       if(!StringUtils.hasLength(code)){
           log.error("Category CODE is null");
           return null;
       }

       return categoryRepository.findCategoryByCode(code)
               .map(CategoryDto::fromEntity)
               .orElseThrow(() -> new EntityNotFoundException(
                       "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
                       ErrorCodes.CATEGORY_NOT_FOUND)
               );
    }

    @Override
    public List<CategoryDto> findAll() {

       return  categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());

    }
}
