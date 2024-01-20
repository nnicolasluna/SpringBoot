package com.example.taskmanager.category;

import com.example.taskmanager.status.StatusDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO create(CategoryDTO dto);
}
