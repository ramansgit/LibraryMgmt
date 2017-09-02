package com.library.model;

/**
 * carries user information in the system
 * @author Test
 *
 */

public class UserPojo {
	
	private String userId;
	private String userName;
	private String email;
	private String mobile;

	
	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userName=" + userName
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
