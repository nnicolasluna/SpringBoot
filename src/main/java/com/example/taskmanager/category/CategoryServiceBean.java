package com.example.taskmanager.category;

import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusMapper;
import com.example.taskmanager.status.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
