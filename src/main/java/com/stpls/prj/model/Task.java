package com.stpls.prj.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;

@Document
public class Task {
	public Task(@NonNull String id, @NonNull String name, @NonNull String status, @NonNull String projectId,
			@NonNull List<String> userIdList) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.projectId = projectId;
		this.userIdList = userIdList;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    private @NonNull String id;
	private @NonNull String name;
	private @NonNull String status;
	private @NonNull String projectId;
	private @NonNull List<String> userIdList;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public List<String> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}
}
