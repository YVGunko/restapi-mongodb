package com.stpls.prj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stpls.prj.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

	List<Task> findByProjectId(String projectId);
}
