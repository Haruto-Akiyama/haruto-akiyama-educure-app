package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotNull;

public class loginForm {
	
	@NotNull(message = "{loginIdError}")
	private String loginId;
	
	@NotNull(message = "{passError}")
    private String pass;

    // ゲッターとセッター
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
