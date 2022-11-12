package com.example.demo.Entity;

import java.sql.Date;

import lombok.Data;

@Data
public class UserList {

	private int user_id;
	private String user_name;
	private String admin_flg;
	private String mail;
	private String pass;
	private Date create_time;

}

