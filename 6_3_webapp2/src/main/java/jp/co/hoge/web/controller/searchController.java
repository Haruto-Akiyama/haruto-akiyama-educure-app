package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.hoge.web.controller.form.searchForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.Products;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class searchController {

	@Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductsDao productsDao;
    @Autowired
    private RoleDao roleDao;
    
    @PostMapping("/list")
	public String select(@ModelAttribute("searchForm") searchForm searchForm, Model model) {
    	
    	List<Products>products = productsDao.findProducts(searchForm);
    	
    	if (products.isEmpty()) {

			model.addAttribute("errorMessage", "入力されたデータはありませんでした");
			return "search";

		}
    	
    	model.addAttribute("productsList",products);
    	
		return "searchResult";
    	
    }
}
