package jp.co.hoge.web.service;

import java.util.List;

import jp.co.hoge.web.controller.form.deleteForm;
import jp.co.hoge.web.controller.form.registerForm;
import jp.co.hoge.web.controller.form.searchForm;
import jp.co.hoge.web.controller.form.updateForm;
import jp.co.hoge.web.entity.Products;

public interface ProductsService {

	public  List<Products> findProducts(searchForm searchForm);
	public List<Products> findProductsId(registerForm registerForm);
	public void registerProducts(registerForm registerForm);
	public List<Products>checkRegisterProducts(registerForm registerForm);
	public List<Products>findDeleteProductsId(deleteForm deleteForm);
	public void deleteProducts(deleteForm deleteForm);
	public List<Products>findUpdateId(updateForm updateForm);
	public void updateProducts(updateForm updateForm);
}
