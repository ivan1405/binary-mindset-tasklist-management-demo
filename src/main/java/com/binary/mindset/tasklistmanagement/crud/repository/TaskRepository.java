package com.binary.mindset.tasklistmanagement.crud.repository;

import com.binary.mindset.tasklistmanagement.crud.entity.TaskEntity;
import com.binary.mindset.tasklistmanagement.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByProjectId(Integer projectId);

    Optional<TaskEntity> findByIdAndProjectId(Integer taskId, Integer projectId);

    void deleteAllByProjectId(Integer projectId);

    void deleteByIdAndProjectId(Integer taskId, Integer projectId);
}
