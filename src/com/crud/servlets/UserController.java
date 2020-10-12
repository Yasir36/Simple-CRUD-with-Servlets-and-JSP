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

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;
	UserBean user; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userDao = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id;
		switch(action)
		{
			case "/AddNewUser":
			  {
				RequestDispatcher view = request.getRequestDispatcher("userForm.jsp");
		        view.forward(request, response);
			  }
			  break;
			case "/Add":
			  {
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				addUser(firstName, lastName);
			  }
			  break;
			case "/UpdateUser":
			  {				
				  id = Integer.parseInt(request.getParameter("id"));
				  request.setAttribute("user", userDao.getUser(id));
				  RequestDispatcher view = request.getRequestDispatcher("userForm.jsp");
			      view.forward(request, response);
			  }
			  break;
			case "/Update":
			  {				
				id = Integer.parseInt(request.getParameter("id"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				updateUser(id,firstName, lastName);
			  }
			  break;
			case "/Delete":
			  {
				id = Integer.parseInt(request.getParameter("id"));
				deleteUser(id);
			  }
			  break;
		}
		action="";
		request.setAttribute("users", userDao.getAllUsers());
		RequestDispatcher view = request.getRequestDispatcher("user.jsp");
        view.forward(request, response);
	}
	
	public void addUser(String firstName,String lastName)
	{
		user = new UserBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDao.addUser(user);
	}
	
	public void updateUser(int id,String firstName,String lastName)
	{		
		user = new UserBean();
		user.setUserID(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDao.updateUser(user, id);	
	}
	
	public void deleteUser(int id)
	{
		userDao.removeUser(id);
	}	

}
