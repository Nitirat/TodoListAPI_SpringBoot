package com.example.todoListAPI.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
	
	@Id
    private String id;
	
	private String subject;
	private String detail;
	private boolean done = false;
		
	public Task() {
		super();
	}
	
	public Task(String subject, String detail) {
		super();
		this.subject = subject;
		this.detail = detail;
	}
	
	public Task(String subject, String detail, boolean done) {
		super();
		this.subject = subject;
		this.detail = detail;
		this.done = done;
	}
	
	public Task(String id, String subject, String detail, boolean done) {
		super();
		this.id = id;
		this.subject = subject;
		this.detail = detail;
		this.done = done;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}


}
