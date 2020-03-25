package com.binary.mindset.tasklistmanagement.crud.repository;

import com.binary.mindset.tasklistmanagement.crud.entity.ProjectEntity;
import com.binary.mindset.tasklistmanagement.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {

}
