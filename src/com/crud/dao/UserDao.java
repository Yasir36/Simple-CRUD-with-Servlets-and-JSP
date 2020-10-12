package com.crud.dao;

import java.util.List;

import com.crud.bean.UserBean;

public interface UserDao {
	public int addUser(UserBean user);
	public int removeUser(int id);
	public int updateUser(UserBean user, int id);
	public UserBean getUser(int id);
	public List<UserBean> getAllUsers();	
}
