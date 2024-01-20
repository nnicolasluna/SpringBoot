package com.example.taskmanager.status;

import com.example.taskmanager.exceptions.StatusNotFound;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusRepository;
import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class StatusServiceBean implements StatusService{

    @Autowired
    private StatusMapper mapper;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<StatusDTO> getAll() {
        return statusRepository.findAll().stream().map(status -> mapper.toDTO(status)).collect(Collectors.toList());
    }

    @Override
    public StatusDTO create(StatusDTO dto) {
        List<Task> tasks = Collections.emptyList();
        if (!CollectionUtils.isEmpty(dto.getTasks())) {
            tasks = taskRepository.findAllByUuidIn(dto.getTasks().stream().map(TaskDTO::getUuid).toList());
            // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.
        }

        Status status = mapper.toModel(dto);
        status.setTasks(tasks);
        Status savedstatus = statusRepository.save(status);
        return mapper.toDTO(savedstatus);
    }

    @Override
    public StatusDTO edit(StatusDTO statusDTO) {
        Optional<Status> optionalStatus = statusRepository.getStatusByUuid(statusDTO.getUuid());
        if (optionalStatus.isEmpty()) {
            throw new StatusNotFound(statusDTO.getUuid().toString());
        }
        List<Task> tasks;
        if (!CollectionUtils.isEmpty(statusDTO.getTasks())) {
            List<UUID> tasksUuids = statusDTO.getTasks().stream().map(TaskDTO::getUuid).toList();
            tasks = taskRepository.findAllByUuidIn(tasksUuids);
            List<UUID> missingIds = tasksUuids.stream()
                    .filter(id1 -> tasks.stream().noneMatch(obj2 -> obj2.getUuid().equals(id1)))
                    .toList();
            if (!CollectionUtils.isEmpty(missingIds)) {
                throw new TaskNotFoundException(missingIds.stream().map(UUID::toString).collect(Collectors.joining(", ")));
            }
        } else {
            tasks = Collections.emptyList();
        }
        Status status = optionalStatus.get();
        status.setDescription(statusDTO.getDescription());
        status.setName(statusDTO.getName());
        status.setTasks(tasks);
        statusRepository.save(status);
        return mapper.toDTO(status);
    }

    @Override
    public StatusDTO getOne(UUID uuid) {
        Status status = new Status(uuid);
        Optional<Status> status1 = statusRepository.findOne(Example.of(status));

        return mapper.toDTO(status1.get());
    }

    @Override
    public StatusDTO delete(UUID uuid) {
        Optional<Status> optionalStatus = statusRepository.getStatusByUuid(uuid);
        Status status = optionalStatus.get();
        statusRepository.delete(status);
        return mapper.toDTO(status);
    }


}
