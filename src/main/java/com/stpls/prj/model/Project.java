package com.stpls.prj.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
@Document
public class Project implements Persistable<String>{
	public Project(@NonNull String name, @NonNull String status) {
		super();
		this.id = String.valueOf(UUID.randomUUID().toString());
		this.name = name;
		this.status = status;
		this.createdDate = new Date();
	}
	public Project(@NonNull String id, @NonNull String name, @NonNull String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Project() {
		
	}
	@Override
    public String toString() {
        return String.format(
                "Project[id=%s, createdDate=%s, lastModifiedDate=%s, name='%s', status='%s']",
                id, createdDate, lastModifiedDate, name, status);
    }
	@Id
    private @NonNull String id;
	@CreatedDate
    private Date createdDate;
	@LastModifiedDate
    private Date lastModifiedDate;
	private @NonNull String name;
	private @NonNull String status;
	private boolean persisted;
	public void setPersisted(boolean persisted) {
        this.persisted = persisted;
    }
    @Override
    public boolean isNew() {
        return persisted;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
