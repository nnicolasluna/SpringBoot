package com.example.taskmanager.status;

import com.example.taskmanager.tasks.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusDTO> getAll() {
        return statusService.getAll();
    }
    @PostMapping
    public StatusDTO create(@Validated(StatusDTO.CreateValidationGroup.class) @RequestBody StatusDTO dto) {
        return statusService.create(dto);
    }

}
