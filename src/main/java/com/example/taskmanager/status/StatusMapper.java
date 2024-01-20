package com.example.taskmanager.status;

import com.example.taskmanager.category.CategoryMapper;
import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StatusMapper {

    private TaskMapper taskMapper;
    public StatusDTO toDTO(Status status) {
        List<TaskDTO> tasks = Optional.ofNullable(status.getTasks())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> taskMapper.toDTO(c))
                .toList();
        return new StatusDTO(status.getUuid(), status.getName(), status.getDescription(),tasks);
    }

    public Status toModel(StatusDTO dto) {
        List<Task> tasks = Optional.ofNullable(dto.getTasks())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> taskMapper.toModel(c))
                .toList();
        return new Status(dto.getUuid(), dto.getName(), dto.getDescription(), tasks);
    }
}
