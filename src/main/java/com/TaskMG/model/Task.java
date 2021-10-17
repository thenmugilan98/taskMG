package com.TaskMG.model;

import java.time.LocalDate;

public class Task {
	private String task_id;
	
	private String user_id;
	
	private String description;
	
	private LocalDate target_date;

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTarget_date() {
		return target_date;
	}

	public void setTarget_date(LocalDate target_date) {
		this.target_date = target_date;
	}

}
