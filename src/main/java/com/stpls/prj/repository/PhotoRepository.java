package com.stpls.prj.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stpls.prj.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {


	Optional<Photo> findById(String id);

	Optional<Photo> findByProjectId(String projectId);
}
