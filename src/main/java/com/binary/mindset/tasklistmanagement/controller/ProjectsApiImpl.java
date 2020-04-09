package com.binary.mindset.tasklistmanagement.controller;

import com.binary.mindset.tasklistmanagement.ProjectsApiDelegate;
import com.binary.mindset.tasklistmanagement.model.Project;
import com.binary.mindset.tasklistmanagement.model.Task;
import com.binary.mindset.tasklistmanagement.service.ProjectService;
import com.binary.mindset.tasklistmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectsApiImpl implements ProjectsApiDelegate {

    private final ProjectService projectService;
    private final TaskService taskService;

    @Autowired
    public ProjectsApiImpl(final ProjectService projectService, final TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> getProject(Integer projectId) {
        Project project = projectService.findById(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteProject(Integer projectId) {
        // Check if there are tasks belonging to that project and delete them
        List<Task> tasks = taskService.findAllByProject(projectId);
        if(!tasks.isEmpty()) {
            taskService.deleteAllByProjectId(projectId);
        }
        projectService.deleteById(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Task>> getTasks(Integer projectId) {
        List<Task> tasks = taskService.findAllByProject(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> getTask(Integer projectId, Integer taskId) {
        Task task = taskService.findByTaskIdAndProjectId(taskId, projectId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Integer projectId, Integer taskId) {
        taskService.deleteByIdAndProjectId(taskId, projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
