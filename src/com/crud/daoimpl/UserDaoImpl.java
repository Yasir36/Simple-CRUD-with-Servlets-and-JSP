package com.crud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.bean.UserBean;
import com.crud.dao.UserDao;
import com.crud.db.DBConnection;

public class UserDaoImpl implements UserDao {
	Connection con = DBConnection.getConnection();
	
	@Override
	public int addUser(UserBean user) {
		try {
			System.out.println("in add user");
			PreparedStatement pst = con.prepareStatement("INSERT INTO users(user_fname,user_lname) VALUES(?,?)");
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int removeUser(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("DELETE FROM users WHERE user_id ="+id);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(UserBean user, int id) {

		try {
			PreparedStatement pst = con.prepareStatement("UPDATE users SET user_fname = ? ,user_lname= ? WHERE user_id = ?");
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setInt(3, user.getUserID());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public UserBean getUser(int id)
	{
		UserBean user;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE user_id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				user = new UserBean(rs.getInt("user_id"),rs.getString("user_fname"),rs.getString("user_lname"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> users = new ArrayList<>();
		UserBean user;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				user = new UserBean(rs.getInt("user_id"),rs.getString("user_fname"),rs.getString("user_lname"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
