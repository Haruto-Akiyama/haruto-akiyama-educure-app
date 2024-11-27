package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.hoge.web.controller.form.updateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.Products;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class updateController {
	
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
    
    @PostMapping("/updateItem")
    public String update(@Validated @ModelAttribute("updateForm") updateForm updateForm, 
                           BindingResult bindingResult, Model model) {
    	
    	 // バリデーションエラーがある場合
        if (bindingResult.hasErrors()) {
            // エラーメッセージを表示する
            model.addAttribute("errorMessage", "すべてのフィールドを正しく入力してください。");
            return "update"; 
        }
        
        List<Products> products = productsDao.findUpdateId(updateForm);
        
        if(products.isEmpty()) {
        	
        	model.addAttribute("errorMessage", "該当の商品は登録されていません");
            return "update"; 
            
        }else {
        	
        	productsDao.updateProducts(updateForm);
        	 List<Products> updatedProducts = productsDao.findUpdateId(updateForm);
        	 model.addAttribute("updatedProducts", updatedProducts);
             return "updateResult";  // 登録結果画面に遷移
             
        }
    	
		
    	
    	
    }

}
