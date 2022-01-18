package com.stpls.prj.model;

import java.time.Instant;
import org.bson.types.Binary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.NonNull;

@Document
public class Photo {
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    private String id;
	private @NonNull String title;
	private @NonNull String projectId;
	private Binary image;
	@CreatedDate
	private Instant createdDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
