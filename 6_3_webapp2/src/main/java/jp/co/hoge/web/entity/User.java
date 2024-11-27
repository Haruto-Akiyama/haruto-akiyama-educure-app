package jp.co.hoge.web.entity;

public class User {

	private Integer number;
	private String name;
	private Integer roleid;
	private Integer loginid;
	private Integer pass;
	private String rolename;
	public User() {
		
	}
	
	public User(Integer number,String name,Integer roleid,Integer loginid,Integer pass,String rolename) {
		this.number=number;
		this.name=name;
		this.roleid=roleid;
		this.loginid=loginid;
		this.pass=pass;
		this.rolename=rolename;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Integer getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}
	
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String role_name) {
		this.rolename = role_name;
	}

	
	@Override
	public String toString() {
	    return "User{" +
	           "number=" + number +
	           ", name='" + name + '\'' +
	           ", roleid=" + roleid +
	           ", loginid=" + loginid +
	           ", pass=" + pass +
	           '}';
	}

}
