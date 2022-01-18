package com.stpls.prj.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stpls.prj.model.Project;
import com.stpls.prj.repository.ProjectRepository;
import com.stpls.prj.service.ProjectService;

@RestController
public class ProjectController
{
	@Autowired
	ProjectRepository repository;
	@Autowired
	ProjectService service;

	@GetMapping("/project")
	public List<Project> getProjects()
	{
		List<Project> employeesList = repository.findAll();
		return employeesList;
	}
	
	@GetMapping("/project/byUser/{id}")
	public List<Project> getProjectsByUser(@PathVariable String id)
	{
		List<Project> list = service.getUserProjects(id);
		return list;
	}

	@GetMapping("/project/{id}")
	public Optional<Project> getProject(@PathVariable String id)
	{
		Optional<Project> emp = repository.findById(id);
		return emp;
	}

	@PutMapping("/project/{id}")
	public Optional<Project> update(@RequestBody Project newRecord, @PathVariable String id) throws ValidatorException
	{
		Optional<Project> optionalEmp = repository.findById(id);
		if (optionalEmp.isPresent()) {
			Project emp = optionalEmp.get();
			emp.setName(newRecord.getName());
			emp.setStatus(newRecord.getStatus());
			emp.setPersisted(false);
			System.out.println(emp);
			repository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/project/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		Boolean result = repository.existsById(id);
		repository.deleteById(id);
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}

	@PostMapping("/project")
	public Project add(@RequestBody Project newRecord)
	{ /*
		this.id = id;
		this.name = name;
		this.status = status;*/
		
		Project emp = new Project(newRecord.getName(), newRecord.getStatus());
		emp.setPersisted(true);
		//repository.insert(emp);
		repository.save(emp);
		System.out.println(emp);
		return emp;
	}
	
}
