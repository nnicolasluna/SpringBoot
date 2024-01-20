package com.example.taskmanager.category;

import com.example.taskmanager.status.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }
    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return categoryService.create(dto);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable String uuid) {
        try {
            CategoryDTO category = categoryService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(category);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @PutMapping
    public CategoryDTO edit(@Validated(CategoryDTO.UpdateValidationGroup.class)  @RequestBody CategoryDTO dto) {
        return categoryService.edit(dto);
    }

    @DeleteMapping("/{uuid}")
    public CategoryDTO delete(@PathVariable String uuid) {
        return categoryService.delete(UUID.fromString(uuid));
    }

}
