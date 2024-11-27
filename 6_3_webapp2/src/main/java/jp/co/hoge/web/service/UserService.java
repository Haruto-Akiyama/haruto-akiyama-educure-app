package jp.co.hoge.web.service;

import java.util.List;

import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.entity.User;

public interface UserService {

	public  List<User>findIdAndPass(Integer loginId,Integer pass);
	public  List<User>findUserNumber(int number);
	public void registerUser(int number,String name,int role,int loginId,int pass);
	public void updateUser(int number,String name,int role,int loginId,int pass);
	public  List<User>findDeleteUserNumber(userDeleteForm userDeleteForm);
	public void delUser(userDeleteForm userDeleteForm);
	public  List<User>findUserLoginId(int loginId);
}
