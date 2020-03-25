package com.binary.mindset.tasklistmanagement.service.impl;

import com.binary.mindset.tasklistmanagement.crud.entity.TaskEntity;
import com.binary.mindset.tasklistmanagement.crud.repository.TaskRepository;
import com.binary.mindset.tasklistmanagement.model.Task;
import com.binary.mindset.tasklistmanagement.service.TaskService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MapperFacade mapperFacade;

    @Autowired
    public TaskServiceImpl(final TaskRepository taskRepository, final MapperFacade mapperFacade) {
        this.taskRepository = taskRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<Task> findAllByProject(Integer projectId) {
        Iterable<TaskEntity> tasks = taskRepository.findAllByProjectId(projectId);
        return mapperFacade.mapAsList(tasks, Task.class);
    }

    @Override
    public Task findByTaskIdAndProjectId(Integer taskId, Integer projectId) {
        Optional<TaskEntity> task = taskRepository.findByIdAndProjectId(taskId, projectId);
        return task.map(tsk -> mapperFacade.map(tsk, Task.class))
                .orElseThrow(() -> Problem.valueOf(Status.NOT_FOUND, "Task not found"));
    }
}
