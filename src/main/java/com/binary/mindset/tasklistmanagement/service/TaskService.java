
package com.binary.mindset.tasklistmanagement.service;

import com.binary.mindset.tasklistmanagement.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAllByProject(Integer projectId);

    Task findByTaskIdAndProjectId(Integer taskId, Integer projectId);
}
