package com.example.taskmanager.category;

import com.example.taskmanager.exceptions.StatusNotFound;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusMapper;
import com.example.taskmanager.status.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class CategoryServiceBean implements CategoryService {
    @Autowired
    private CategoryMapper mapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(status -> mapper.toDTO(status)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category category = mapper.toModel(dto);
        Category savedcategory = categoryRepository.save(category);
        return mapper.toDTO(savedcategory);
    }

    @Override
    public CategoryDTO edit(CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryByUuid(categoryDTO.getUuid());
        if (optionalCategory.isEmpty()) {
            throw new StatusNotFound(categoryDTO.getUuid().toString());
        }
        Category category = optionalCategory.get();
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO delete(UUID uuid) {
        Optional<Category> optionalStatus = categoryRepository.getCategoryByUuid(uuid);
        Category category = optionalStatus.get();
        categoryRepository.delete(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO getOne(UUID uuid) {
        Category category = new Category(uuid);
        Optional<Category> category1 = categoryRepository.findOne(Example.of(category));
        return mapper.toDTO(category1.get());
    }
}
