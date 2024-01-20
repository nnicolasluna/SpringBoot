package com.example.taskmanager.status;

import com.example.taskmanager.tasks.TaskDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class StatusDTO {
    @NotNull(message = "Uuid cannot be null", groups = {TaskDTO.UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {TaskDTO.CreateValidationGroup.class})
    private UUID uuid;
    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 3)
    private String name;
    @NotBlank(message="Description cannot be blank")
    @Size(max = 2000, min = 3)
    private String description;
    private List<TaskDTO> tasks;

    public StatusDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public StatusDTO() {
    }


    public StatusDTO(UUID uuid, String name, String description, List<TaskDTO> tasks) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public interface CreateValidationGroup {

    }
    public interface UpdateValidationGroup {

    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
