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

import com.stpls.prj.model.Task;
import com.stpls.prj.repository.TaskRepository;

@RestController
public class TaskController
{
	@Autowired
	TaskRepository repository;

	@GetMapping("/tasks")
	public List<Task> getTasks()
	{
		List<Task> employeesList = repository.findAll();
		return employeesList;
	}
	
	@GetMapping("/task")
	public List<Task> getTasks(@RequestParam("projectId") String projectId)
	{
		List<Task> employeesList = repository.findByProjectId(projectId);
		return employeesList;
	}

	@GetMapping("/task/{id}")
	public Optional<Task> getTask(@PathVariable String id)
	{
		Optional<Task> emp = repository.findById(id);
		return emp;
	}

	@PutMapping("/task/{id}")
	public Optional<Task> update(@RequestBody Task newRecord, @PathVariable String id) throws ValidatorException
	{
		Optional<Task> optionalEmp = repository.findById(id);
		if (optionalEmp.isPresent()) {
			Task emp = optionalEmp.get();
			emp.setName(newRecord.getName());
			emp.setStatus(newRecord.getStatus());
			emp.setProjectId(newRecord.getProjectId());
			emp.setUserIdList(newRecord.getUserIdList());
			repository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/task/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		Boolean result = repository.existsById(id);
		repository.deleteById(id);
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}

	@PostMapping("/task")
	public Task add(@RequestBody Task newRecord)
	{ /*
		this.id = id;
		this.name = name;
		this.status = status;
		this.projectId = projectId;
		this.userIdList = userIdList;*/
		
		String id = String.valueOf(UUID.randomUUID().toString());
		Task emp = new Task(id, newRecord.getName(), newRecord.getStatus(), newRecord.getProjectId(), newRecord.getUserIdList());
		repository.insert(emp);
		return emp;
	}
	
}
