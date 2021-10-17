package com.TaskMG.service;

import java.util.List;

import com.TaskMG.model.Task;
import com.TaskMG.model.User;

public interface UserService {

	public String register(User user) throws Exception;

	public String login(User user) throws Exception;

	public String addTask(Task task) throws Exception;

	public List<Task> getUserTasks(String user_id) throws Exception;

	public String deleteTask(String task_id) throws Exception;

}
