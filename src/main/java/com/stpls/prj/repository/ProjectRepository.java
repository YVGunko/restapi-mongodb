package com.stpls.prj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stpls.prj.model.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {


}
