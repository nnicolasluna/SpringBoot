package com.example.taskmanager.category;

import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryMapper {


    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getUuid(), category.getName(), category.getDescription());
    }

    public Category toModel(CategoryDTO dto) {
        return new Category(dto.getUuid(), dto.getName(), dto.getDescription());
    }
}
