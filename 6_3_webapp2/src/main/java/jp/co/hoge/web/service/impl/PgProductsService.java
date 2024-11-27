package jp.co.hoge.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.hoge.web.controller.form.deleteForm;
import jp.co.hoge.web.controller.form.registerForm;
import jp.co.hoge.web.controller.form.searchForm;
import jp.co.hoge.web.controller.form.updateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.entity.Products;
import jp.co.hoge.web.service.ProductsService;
@Service
public class PgProductsService implements ProductsService {

	@Autowired
	private ProductsDao productsDao;
	
	public  List<Products> findProducts(searchForm searchForm){
		
		return productsDao.findProducts(searchForm);
		
	}
	public List<Products> findProductsId(registerForm registerForm){
		
		return productsDao.findProductsId(registerForm);
		
	}
	public void registerProducts(registerForm registerForm) {
		
	}
	public List<Products>checkRegisterProducts(registerForm registerForm){
		return productsDao.checkRegisterProducts(registerForm);
	}
	public List<Products>findDeleteProductsId(deleteForm deleteForm){
		return productsDao.findDeleteProductsId(deleteForm);
	}
	public void deleteProducts(deleteForm deleteForm) {
		
	}
	public List<Products>findUpdateId(updateForm updateForm){
		return productsDao.findUpdateId(updateForm);
	}
	public void updateProducts(updateForm updateForm) {
		
	}
}
