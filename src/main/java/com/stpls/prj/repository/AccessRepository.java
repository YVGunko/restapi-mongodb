package com.stpls.prj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.stpls.prj.model.Access;

public interface AccessRepository extends MongoRepository<Access, String>{
	List<Access> findByUserId(@Param("userId") String userId);
	List<Access> findByUserIdAndProjectId(@Param("userId") String userId, @Param("projectId") String projectId);

}
