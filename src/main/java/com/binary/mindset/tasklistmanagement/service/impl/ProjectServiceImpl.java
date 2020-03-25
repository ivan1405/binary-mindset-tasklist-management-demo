package com.binary.mindset.tasklistmanagement.service.impl;

import com.binary.mindset.tasklistmanagement.crud.entity.ProjectEntity;
import com.binary.mindset.tasklistmanagement.crud.repository.ProjectRepository;
import com.binary.mindset.tasklistmanagement.model.Project;
import com.binary.mindset.tasklistmanagement.service.ProjectService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final MapperFacade mapperFacade;

    @Autowired
    public ProjectServiceImpl(final ProjectRepository projectRepository, final MapperFacade tasklistManagementMapper) {
        this.projectRepository = projectRepository;
        this.mapperFacade = tasklistManagementMapper;
    }

    @Override
    public List<Project> findAllProjects() {
        Iterable<ProjectEntity> projects = projectRepository.findAll();
        return mapperFacade.mapAsList(projects, Project.class);
    }

    @Override
    public Project findById(Integer projectId) {
        Optional<ProjectEntity> project = projectRepository.findById(projectId);
        return project.map(proj -> mapperFacade.map(proj, Project.class))
                .orElseThrow(() -> Problem.valueOf(Status.NOT_FOUND, "Project not found"));
    }
}
