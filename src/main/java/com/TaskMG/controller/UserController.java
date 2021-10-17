package com.TaskMG.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskMG.model.Task;
import com.TaskMG.model.User;
import com.TaskMG.service.UserService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> userRegistration(@RequestBody User user)
			throws Exception {
			String message = userService.register(user);
			ResponseEntity<String> response = new ResponseEntity<String>(message,HttpStatus.CREATED);
			return response;

		}

	@PostMapping(value = "/login")
	public ResponseEntity<String> userLogin(@RequestBody User user) throws Exception {
		String message ;

		
		message = userService.login(user);
		ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.CREATED);
		return response;
		}
	
	@PostMapping(value="/addTask")
	public ResponseEntity<String> userLogin(@RequestBody Task task) throws Exception {
		String message;
		message = userService.addTask(task);
		ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.CREATED);
		return response;
		
	}
	
	
	@GetMapping(value= "/taskList/{user_id}")
	public ResponseEntity<List<Task>> getUserTasks(@PathVariable String user_id  ) throws Exception {
		List<Task> taskList = userService.getUserTasks(user_id);
		ResponseEntity<List<Task>> response = new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping(value = "/deleteTask/{task_id}")
	public ResponseEntity<String> deleteTask(@PathVariable String task_id) throws  Exception {
	
			String message=userService.deleteTask(task_id);
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.OK);
			return response;
		}
	
}



