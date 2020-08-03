package com.crud.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.bean.UserBean;
import com.crud.dao.UserDao;
import com.crud.daoimpl.UserDaoImpl;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;
	UserBean user;
    public UpdateUser() {
        super();
        userDao = new UserDaoImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		user = new UserBean();
		user.setUserID(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDao.addUser(user);
		
		request.setAttribute("users", userDao.getAllUsers());
		RequestDispatcher view = request.getRequestDispatcher("user.jsp");
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
