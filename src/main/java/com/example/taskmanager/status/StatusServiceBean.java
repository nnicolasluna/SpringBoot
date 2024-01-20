package com.example.taskmanager.status;

import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusRepository;
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


    public List<StatusDTO> getAll() {
        return statusRepository.findAll().stream().map(status -> mapper.toDTO(status)).collect(Collectors.toList());
    }

    @Override
    public StatusDTO create(StatusDTO dto) {
        Status status = mapper.toModel(dto);
        Status savedstatus = statusRepository.save(status);
        return mapper.toDTO(savedstatus);
    }


}
