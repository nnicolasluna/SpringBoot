package com.example.taskmanager.status;
import java.util.List;
import java.util.UUID;
public interface StatusService {
    List<StatusDTO> getAll();
    StatusDTO create(StatusDTO dto);

}
