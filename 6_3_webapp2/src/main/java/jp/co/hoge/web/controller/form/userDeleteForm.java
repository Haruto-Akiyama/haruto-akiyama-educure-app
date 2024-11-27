package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotNull;

public class userDeleteForm {

	@NotNull(message = "{userDelNumber}")
	private int userDelNumber;

	
	public int getUserDelNumber() {
		return userDelNumber;
	}

	public void setUserDelNumber(int userDelNumber) {
		this.userDelNumber = userDelNumber;
	}
	
}
