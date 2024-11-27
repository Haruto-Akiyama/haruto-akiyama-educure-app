package jp.co.hoge.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import jp.co.hoge.web.controller.form.deleteForm;
import jp.co.hoge.web.controller.form.registerForm;
import jp.co.hoge.web.controller.form.searchForm;
import jp.co.hoge.web.controller.form.updateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.entity.Products;

@Repository
public class PgProductsDao implements ProductsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Products> findProducts(searchForm searchForm) {
        
        String sql = "SELECT * FROM products WHERE 1=1";  // ダミー条件
        if (searchForm.getProductsId() != null) {
            sql += " AND id = ?";
        }
        if (searchForm.getProductsName() != null && !searchForm.getProductsName().isEmpty()) {
            sql += " AND name = ?";
        }
        sql += " ORDER BY id";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
                int i = 1;
                if (searchForm.getProductsId() != null) {
                    ps.setInt(i++, searchForm.getProductsId());
                }
                if (searchForm.getProductsName() != null && !searchForm.getProductsName().isEmpty()) {
                    ps.setString(i++, searchForm.getProductsName());
                }
            }
        }, new BeanPropertyRowMapper<>(Products.class));
    }
    
    @Override
    public List<Products> findProductsId(registerForm registerForm){
    	
    	String sql = "SELECT * FROM products WHERE id = ?"; 
    	
    	 return jdbcTemplate.query(sql, new PreparedStatementSetter() {
    		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
    			 ps.setInt(1,registerForm.getProductsId());
    		 }
                 
         }, new BeanPropertyRowMapper<>(Products.class));
     }
    
    @Override
    public void registerProducts(registerForm registerForm) {
        // SQLのINSERT文
        String sql = "INSERT INTO products (id, name, units) VALUES (?, ?, ?)";

        // jdbcTemplate.updateを使って、INSERT処理を実行
        jdbcTemplate.update(sql, registerForm.getProductsId(), registerForm.getProductsName(), registerForm.getProductsUnits());
    
    }
    
    @Override
    public List<Products>checkRegisterProducts(registerForm registerForm){
    	String sql = "SELECT * FROM products WHERE id = ?";
    	return jdbcTemplate.query(sql, new PreparedStatementSetter() {
   		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
   			 ps.setInt(1,registerForm.getProductsId());
   		 }
                
        }, new BeanPropertyRowMapper<>(Products.class));
    }
    
    @Override
    public List<Products>findDeleteProductsId(deleteForm deleteForm){
    	
    	String sql = "SELECT * FROM products WHERE id = ?";
    	return jdbcTemplate.query(sql, new PreparedStatementSetter() {
   		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
   			 ps.setInt(1,deleteForm.getDeleteProductsId());
   		 }
                
        }, new BeanPropertyRowMapper<>(Products.class));
    }
    
    @Override
    public void deleteProducts(deleteForm deleteForm) {
        String sql = "DELETE FROM products WHERE id = ?";
        // jdbcTemplate.updateを使って、DELETE処理を実行
        jdbcTemplate.update(sql, deleteForm.getDeleteProductsId());
    }
    
    @Override
    public List<Products>findUpdateId(updateForm updateForm){
    	
    	String sql = "SELECT * FROM products WHERE id = ?";
    	
    	 return jdbcTemplate.query(sql, new PreparedStatementSetter() {
    		 public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
    			 ps.setInt(1,updateForm.getUpdateProductsId());
    		 }
                 
         }, new BeanPropertyRowMapper<>(Products.class));
    }
    
    @Override
    public void updateProducts(updateForm updateForm) {
        // 商品名と在庫数を更新するSQL文
        String sql = "UPDATE products SET name = ?, units = ? WHERE id = ?";

        // jdbcTemplateを使ってSQLを実行
        jdbcTemplate.update(sql, updateForm.getUpdateProductsName(), updateForm.getUpdateProductsUnits(), updateForm.getUpdateProductsId());
    }


}
