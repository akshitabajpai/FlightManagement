package com.capgemini.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "User1")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Users {
	@Id
	@Column(name="user_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="user_id")
	private Integer userId;
	
	//@NotEmpty(message="User Type Is Mandatory")
	@Column(name="user_type")
	private String userType;
	
//	@NotEmpty(message="User Name Is Mandatory")
//	@Size(min=3, max=25, message="Length can be 3 and 25 chars")
//	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[][A-Za-z]+)",message="allow only alphabets and a blank scpace is allowed")
	@Column(name="user_name")
	private String userName;
	
//	@NotEmpty(message="Password Is Mandatory")
//	@Size(min=6, max=25, message="Length can be 3 and 25 chars")
//	@Column(name="user_pass")
	private int userPassword;
	
//	@NotEmpty(message="User Email Is Mandatory")
//	@Size(min=3, max=25, message="Length can be 3 and 25 chars")
	@Column(name="user_email")
	private String userEmail;
	
	public int getUserId() {
		return userId;
		}
	
	public void setUserId(int userId) {
		this.userId = userId;
		}
	
	public String getUserType() {
		return userType;
		}
	
	public void setUserType(String userType) {
		this.userType = userType;
		}
	
	public String getUserName() {
		return userName;
		}
	
	public void setUserName(String userName) {
		this.userName = userName;
		}
	
	public int getUserPassword() {
		return userPassword;
		}
	
	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
		}
	
	public String getUserEmail() {
		return userEmail;
		}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		}
	
	public Users(int userId, String userType, String userName, int userPassword, String userEmail) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		}
	
	public Users() {
		super();
	// TODO Auto-generated constructor stub
		}
	
	@Override
	public String toString() {
		return "User1 [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail + "]";
		}

}
