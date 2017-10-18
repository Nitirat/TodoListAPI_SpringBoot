package com.example.todoListAPI.domain;

public class ResponseDelete {
	
    private String message;

    public ResponseDelete(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
