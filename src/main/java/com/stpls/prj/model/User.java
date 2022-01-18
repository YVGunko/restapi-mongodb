package com.stpls.prj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;
import lombok.NonNull;
@Document(collection = "user")
public class User {
	public User(String id, String name, String lastName, String position, String email, Boolean isEmployee, Boolean isProjectStarter) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.email = email;
		this.isEmployee = isEmployee;
		this.isProjectStarter = isProjectStarter;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    private String id;
	private @NonNull String name;
	private String lastName;
	private String position;
	private @NonNull String email;
	private @NonNull Boolean isEmployee;
	private @NonNull Boolean isProjectStarter;
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
			   result = EmailValidator.getInstance().isValid(email);
		   } catch (Exception ex) {
		      result = false;
		   }
		   return result;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws ValidatorException {
		if (isValidEmailAddress(email)) this.email = email; else throw new ValidatorException(email.concat(" is not valid email!") );
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Boolean getIsProjectStarter() {
		return isProjectStarter;
	}

	public void setIsProjectStarter(Boolean isProjectStarter) {
		this.isProjectStarter = isProjectStarter;
	}
}
