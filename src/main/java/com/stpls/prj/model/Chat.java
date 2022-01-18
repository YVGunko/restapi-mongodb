package com.stpls.prj.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Chat {
	@Id
    private String id;
	private List<String> userIdList;
	//ToDo
}
