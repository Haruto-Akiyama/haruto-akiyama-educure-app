package jp.co.hoge.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.UserService;

@Service
public class PgUserService implements UserService{

	@Autowired
	private UserDao userDao;
	
	 @Override
	 public  List<User>findIdAndPass(Integer loginId,Integer pass){
			return userDao.findIdAndPass(loginId, pass);
		}
	 @Override
	 public  List<User>findUserNumber(int number){
		return userDao.findUserNumber(number);
		 
	 }
	 @Override
	 public void registerUser(int number,String name,int role,int loginId,int pass) {
		 
	 }
	 @Override
	 public void updateUser(int number,String name,int role,int loginId,int pass) {
		 
	 }
	 
	 @Override
	 public  List<User>findDeleteUserNumber(userDeleteForm userDeleteForm){
		return userDao.findDeleteUserNumber(userDeleteForm);
		 
	 }
	 
	 @Override
	 public void delUser(userDeleteForm userDeleteForm) {
		 
	 }
	 
	 @Override
	 public  List<User>findUserLoginId(int loginId){
		return userDao.findUserLoginId(loginId);
		 
	 }
}
