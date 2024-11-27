package jp.co.hoge.web.dao;

import java.util.List;

import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.entity.User;

public interface UserDao {

	public  List<User>findIdAndPass(int loginId,int pass);
	public  List<User>findUserNumber(int number);
	public void registerUser(int number,String name,int role,int loginId,int pass);
	public void updateUser(int number,String name,int role,int loginId,int pass);
	public  List<User>findDeleteUserNumber(userDeleteForm userDeleteForm);
	public void delUser(userDeleteForm userDeleteForm);
	public  List<User>findUserLoginId(int loginId);
}
