use user_task;
drop table Task_Details;
drop table User;



CREATE TABLE User(
	user_id varchar(30) primary key not null,
	user_name    varchar(30) not null,
	password varchar(30) not  null
	
	
);

CREATE TABLE Task_Details(
	task_id varchar(30) primary key not null,
	user_id varchar(30) not null,
	description  varchar(100) not null,
	target_date date not null
)



