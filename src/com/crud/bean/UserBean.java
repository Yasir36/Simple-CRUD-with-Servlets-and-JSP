package com.crud.bean;

public class UserBean {
	private int userID;
	private String firstName;
	private String lastName;
	
	public UserBean(int userID, String firstName, String lastName)
	{
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
