package com.TaskMG.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskMG.dao.UserDao;
import com.TaskMG.model.Task;
import com.TaskMG.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public String register(User user) throws Exception{
		
		return userDao.register(user);
		
	}

	@Override
	public String login(User user) throws Exception {
		String user_id;
		String password;
		user_id = userDao.login(user).getUser_id();
		password = userDao.login(user).getPassword();
		if(user.getUser_id().equals(user_id) && user.getPassword().equals(password)) {
			return "Login Successfull";
		}
		else {
			throw new Exception("User Details not found");
		}
	}

	@Override
	public String addTask(Task task) throws Exception {
		// TODO Auto-generated method stub
		String message = userDao.addTask(task);
		return message;
	}

	@Override
	public List<Task> getUserTasks(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserTasks(user_id);
	}


	@Override
	public String deleteTask(String task_id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteTask(task_id);
	}

}
