package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.hoge.web.controller.form.deleteForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.Products;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class deleteController {

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
    
    @PostMapping("/deleteItem")
    public String delete(@Validated @ModelAttribute("deleteForm") deleteForm deleteForm, 
                           BindingResult bindingResult, Model model) {
    	
    	// バリデーションエラーがある場合
        if (bindingResult.hasErrors()) {
            // エラーメッセージを表示する
            model.addAttribute("errorMessage", "すべてのフィールドを正しく入力してください。");
            return "delete";  // 登録画面に戻る
        }
        
        List<Products> products =  productsDao.findDeleteProductsId(deleteForm);
        
        if (products.isEmpty()) {
            model.addAttribute("errorMessage", "該当する商品はありません");
            return "delete";  // 登録画面に戻る
        }else {
        	 productsDao.deleteProducts(deleteForm);
        	 model.addAttribute("deleteProductsList",products);
        	return "deleteResult";
        }
    }
}
