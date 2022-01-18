package com.stpls.prj.model;

import java.net.URI;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {
	@Id
    private String id;
	private String name;
	private String chatId;
	private List<URI> attachmentURIList;
	private String condition;//"Доставлено","Прочитано"
	//ToDo
}
