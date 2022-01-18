package com.stpls.prj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stpls.prj.model.Access;
import com.stpls.prj.model.Project;
import com.stpls.prj.repository.AccessRepository;
import com.stpls.prj.repository.ProjectRepository;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;
    @Autowired
    private AccessRepository accRepo;

	public List<Project> getUserProjects(String userId) {
		// TODO userId > access > projectList
		List<Project> responce = new ArrayList<>();
		List<Access> accList = accRepo.findByUserId(userId);
		for (Access access:accList) {
			Project pr = repo.findById(access.getProjectId()).get();
			responce.add(new Project(pr.getId(), pr.getName(), pr.getStatus()));
		}
		return responce;
	}
}
