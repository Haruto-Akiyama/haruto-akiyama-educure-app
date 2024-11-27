package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotEmpty;


public class userUpdateForm {
	
	 @NotEmpty(message = "{usersNumber}")
	    private String usersNumber;
	    
	    @NotEmpty(message = "{usersName}")
	    private String usersName;
	    
	    private int usersRole;
	    
	    @NotEmpty(message = "{usersLogin}")
	    private String usersLogin;
	    
	    @NotEmpty(message = "{usersPass}")
	    private String usersPass;
	
	
	
	public String getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(String usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public int getUsersRole() {
		return usersRole;
	}
	public void setUsersRole(int usersRole) {
		this.usersRole = usersRole;
	}
	public String getUsersLogin() {
		return usersLogin;
	}
	public void setUsersLogin(String usersLogin) {
		this.usersLogin = usersLogin;
	}
	public String getUsersPass() {
		return usersPass;
	}
	public void setUsersPass(String usersPass) {
		this.usersPass = usersPass;
	}
	
}
