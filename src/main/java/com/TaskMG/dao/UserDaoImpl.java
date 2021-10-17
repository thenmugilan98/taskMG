package com.TaskMG.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.TaskMG.model.Task;
import com.TaskMG.model.User;
import com.TaskMG.service.UserServiceImpl;
import com.TaskNG.entity.TaskEntity;
import com.TaskNG.entity.UserEntity;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
	
	static int count = 1;
	static int task_count = 1;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public String register(User userModel) throws Exception{
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUser_id("UID"+ UserDaoImpl.count++);
		userEntity.setUser_name(userModel.getUser_name());
		userEntity.setPassword(userModel.getPassword());
		entityManager.persist(userEntity);

			String message;
			message = "Success! user is regsitered and userid is " + userEntity.getUser_id();
			return message;
		}

	@Override
	public User login(User user) {
			User userTemp = new User();
			UserEntity userEntity = entityManager.find(UserEntity.class, user.getUser_id());
//			if(userEntity == null) {
//				throw new Exception();
//			
			
			userTemp.setUser_id(userEntity.getUser_id());
			userTemp.setPassword(userEntity.getPassword());
			

			return userTemp;
	
	}

	@Override
	@Transactional
	public String addTask(Task task) throws Exception {
		// TODO Auto-generated method stub
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTask_id("TID" +UserDaoImpl.task_count++);
		taskEntity.setUser_id(task.getUser_id());
		taskEntity.setDescription(task.getDescription());
		taskEntity.setTarget_date(task.getTarget_date());
		entityManager.persist(taskEntity);
		String message= "Success! task has been added with task id " + taskEntity.getTask_id();
		return message;
	}

	@Override
	@Transactional
	public List<Task> getUserTasks(String user_id) throws Exception {
		// TODO Auto-generated method stub
		List<Task> taskList = new ArrayList<Task>();
		Query query = entityManager.createQuery("select t from TaskEntity t where t.user_id =?1");
		query.setParameter(1, user_id);
		List<TaskEntity> taskListTemp = query.getResultList();
		for(TaskEntity taskEntity : taskListTemp) {
			Task task = new Task();
			task.setUser_id(taskEntity.getUser_id());
			task.setTask_id(taskEntity.getTask_id());
			task.setDescription(taskEntity.getDescription());
			task.setTarget_date(taskEntity.getTarget_date());
			taskList.add(task);
			
		}
		return taskList;
		
	}

	
	@Override
	public String deleteTask(String task_id) throws Exception {
		// TODO Auto-generated method stub
		TaskEntity taskEntity = entityManager.find(TaskEntity.class, task_id);
		return task_id;
		
	}
		
	}


