package com.TaskMG.dao;

import java.util.List;

import com.TaskMG.model.Task;
import com.TaskMG.model.User;

public interface UserDao {

	public String register(User user) throws Exception;
	
	public User login(User user);

	public String addTask(Task task) throws Exception;

	public List<Task> getUserTasks(String user_id) throws Exception;

	public String deleteTask(String task_id) throws Exception;
	
	

}
