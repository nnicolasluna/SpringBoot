package com.example.taskmanager.category;

import com.example.taskmanager.status.StatusDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO create(CategoryDTO dto);

    CategoryDTO edit(CategoryDTO dto);

    CategoryDTO delete(UUID uuid);

    CategoryDTO getOne(UUID uuid);
}
