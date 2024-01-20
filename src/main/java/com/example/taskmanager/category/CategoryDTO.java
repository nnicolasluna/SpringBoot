package com.example.taskmanager.category;
import com.example.taskmanager.tasks.TaskDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import java.util.List;

public class CategoryDTO {
    @NotNull(message = "Uuid cannot be null", groups = {TaskDTO.UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {TaskDTO.CreateValidationGroup.class})
    private UUID uuid;
    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 3)
    private String name;
    @NotBlank(message="Description cannot be blank")
    @Size(max = 2000, min = 3)
    private String description;

    public CategoryDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public CategoryDTO() {
    }


    public CategoryDTO(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public interface UpdateValidationGroup {

    }


    public void setDescription(String description) {
        this.description = description;
    }
}
