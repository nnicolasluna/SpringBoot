package com.example.taskmanager.status;

import com.example.taskmanager.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> getStatusByUuid(UUID uuid);

}
