package com.stpls.prj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stpls.prj.Level;

import lombok.NonNull;

@Document(collection = "access")
public class Access {
	public Access() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Access(@NonNull String id, @NonNull String userId, @NonNull String projectId, @NonNull String level) {
		super();
		this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.level = level;
	}
	@Id
    private @NonNull String id;
	private @NonNull String userId;
	private @NonNull String projectId;
	private @NonNull String level; //"Владелец","Пользователь","Наблюдатель" 
	//ToDo
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
