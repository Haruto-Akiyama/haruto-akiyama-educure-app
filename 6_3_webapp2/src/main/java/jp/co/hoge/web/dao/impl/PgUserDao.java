package jp.co.hoge.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public  List<User>findIdAndPass(int loginId,int pass){
		
		String sql = "SELECT * FROM users WHERE loginid = ? AND pass = ?";

		return jdbcTemplate.query(sql, new PreparedStatementSetter(){
			public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException{
				ps.setInt(1, loginId);
				ps.setInt(2, pass);
			}
		}, new BeanPropertyRowMapper<>(User.class));
		
	}
	
	@Override
	public  List<User>findUserNumber(int number){
		
		String sql = "SELECT * FROM users WHERE number = ?"; 
    	
   	 return jdbcTemplate.query(sql, new PreparedStatementSetter() {
   		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
   			 ps.setInt(1,number);
   		 }
                
        }, new BeanPropertyRowMapper<>(User.class));
    }
		
	@Override
	public void registerUser(int number,String name,int role,int loginId,int pass) {
		
		 // SQLのINSERT文
        String sql = "INSERT INTO users (number, name, roleid, loginid, pass) VALUES (?, ?, ?, ?, ?)";

        // jdbcTemplate.updateを使って、INSERT処理を実行
        jdbcTemplate.update(sql, number, name, role, loginId, pass);
		
	}
	
	@Override
	public void updateUser(int number, String name, int role, int loginId, int pass) {
	    String sql = "UPDATE users SET name = ?, roleid = ?, loginid = ?, pass = ? WHERE number = ?";

	    // jdbcTemplateを使ってSQLを実行
	    jdbcTemplate.update(sql, name, role, loginId, pass, number);
	}

	
	@Override
	public  List<User>findDeleteUserNumber(userDeleteForm userDeleteForm){
		
		String sql = "SELECT * FROM users WHERE number = ?";
		
    	return jdbcTemplate.query(sql, new PreparedStatementSetter() {
   		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
   			 ps.setInt(1,userDeleteForm.getUserDelNumber());
   		 }
                
        }, new BeanPropertyRowMapper<>(User.class));
    }
	@Override
	public void delUser(userDeleteForm userDeleteForm) {
		
		String sql = "DELETE FROM users WHERE number = ?";
        // jdbcTemplate.updateを使って、DELETE処理を実行
        jdbcTemplate.update(sql, userDeleteForm.getUserDelNumber());
        
	}
	
	@Override
	public  List<User>findUserLoginId(int loginId){
		
		String sql = "SELECT * FROM users WHERE loginid = ?";
		
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {
	   		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
	   			 ps.setInt(1,loginId);
	   		 }
	                
	        }, new BeanPropertyRowMapper<>(User.class));
	    }
}
