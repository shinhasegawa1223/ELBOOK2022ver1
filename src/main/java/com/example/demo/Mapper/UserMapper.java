package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.UserList;

@Mapper
public interface UserMapper {

	//Listを使用してあたいを格納する　引数は無し
	List<UserList> findUser();

	List<UserList> targetUser(int user_id);

	void createUser(UserList userList);

	void editUser(UserList userList);

	void deleteUser(int user_id);

}