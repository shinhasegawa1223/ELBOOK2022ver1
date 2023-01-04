package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	//クラス名　インスタンス化
	UserMapper userMapper;
	
	private final PasswordEncoder passwordEncoder; 

	// リストを作成　returnを使用して戻り値を取得する
	public List<UserList> findUser() {
		//UserMapperクラスのfindUserを使用する　引数は無し
		return userMapper.findUser();
	}

	public UserList targetUser(int user_id) {
		return userMapper.targetUser(user_id);
	}

	public void createUser(UserList userList) {
		String pass = passwordEncoder.encode(userList.getPass());
		userList.setPass(pass);
		userMapper.createUser(userList);
	}

	public void editUser(UserList userList) {
		String pass = passwordEncoder.encode(userList.getPass());
		userList.setPass(pass);
		userMapper.editUser(userList);
	}

	public void deleteUser(int user_id) {
		userMapper.deleteUser(user_id);
	}

}