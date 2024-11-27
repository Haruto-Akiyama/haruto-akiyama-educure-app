package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.hoge.web.controller.form.registerForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.Products;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class registerContoroller {

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

    
    @PostMapping("/registerItem")
    public String register(@Validated @ModelAttribute("registerForm") registerForm registerForm, 
                           BindingResult bindingResult, Model model) {

        // バリデーションエラーがある場合
        if (bindingResult.hasErrors()) {
            // エラーメッセージを表示する
            model.addAttribute("errorMessage", "すべてのフィールドを正しく入力してください。");
            return "register";  // 登録画面に戻る
        }

        // 既に登録されているIDか確認
        List<Products> products = productsDao.findProductsId(registerForm);
        if (!products.isEmpty()) {
            model.addAttribute("errorMessage", "そのIDは既に登録済みです");
            return "register";  // 登録画面に戻る
        }

        // 新規登録
        productsDao.registerProducts(registerForm);
        List<Products> resultRegister = productsDao.checkRegisterProducts(registerForm);
        model.addAttribute("registerProductsList", resultRegister);
        return "registerResult";  // 登録結果画面に遷移
    }
}
