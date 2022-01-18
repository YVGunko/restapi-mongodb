package com.stpls.prj.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stpls.prj.model.User;
import com.stpls.prj.repository.UserRepository;

@RestController
public class UserController
{
	@Autowired
	UserRepository userRepository;

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"isWorking\" : true }";
	}

	@GetMapping("/user")
	public List<User> getUsers()
	{
		List<User> employeesList = userRepository.findAll();
		return employeesList;
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable String id)
	{
		Optional<User> emp = userRepository.findById(id);
		return emp;
	}

	@PutMapping("/user/{id}")
	public Optional<User> update(@RequestBody User newEmployee, @PathVariable String id) throws ValidatorException
	{
		Optional<User> optionalEmp = userRepository.findById(id);
		if (optionalEmp.isPresent()) {
			User emp = optionalEmp.get();
			emp.setName(newEmployee.getName());
			emp.setLastName(newEmployee.getLastName());
			emp.setEmail(newEmployee.getEmail());
			emp.setPosition(newEmployee.getPosition());
			emp.setIsEmployee(newEmployee.getIsEmployee());
			emp.setIsProjectStarter(newEmployee.getIsProjectStarter());
			userRepository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/user/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		Boolean result = userRepository.existsById(id);
		userRepository.deleteById(id);
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}

	@PostMapping("/user")
	public User add(@RequestBody User newEmployee)
	{ /*
			this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.email = email;
		this.isEmployee = isEmployee;*/
		
		String id = String.valueOf(UUID.randomUUID().toString());
		User emp = new User(id, newEmployee.getName(), newEmployee.getLastName(), 
				newEmployee.getPosition(), newEmployee.getEmail(), newEmployee.getIsEmployee(), newEmployee.getIsProjectStarter());
		userRepository.insert(emp);
		return emp;
	}
	
}
