package com.binary.mindset.tasklistmanagement.service;

import com.binary.mindset.tasklistmanagement.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProjects();

    Project findById(Integer projectId);
}
