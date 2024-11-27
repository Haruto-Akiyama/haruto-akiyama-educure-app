package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class userDelContoroller {
	
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
    
    
    @PostMapping("/userDelNumber")
    public String delete(@Validated @ModelAttribute("userDeleteForm") userDeleteForm userDeleteForm, 
                           BindingResult bindingResult, Model model) {
    	
    	// バリデーションエラーがある場合
        if (bindingResult.hasErrors()) {
            // エラーメッセージを表示する
            model.addAttribute("errorMessage", "すべてのフィールドを正しく入力してください。");
            return "userDelete";  // 登録画面に戻る
        }
        
        List<User> users =  userDao.findDeleteUserNumber(userDeleteForm);
        
        if(users.isEmpty()) {
        	
        	//Numberが登録されていないときの処理
        	model.addAttribute("errorMessage", "該当するユーザはいません");
            return "userDelete";  // 登録画面に戻る
        	
        }else {
        	  // 削除処理
            userDao.delUser(userDeleteForm);
            model.addAttribute("usersDelList", users);  // 修正: 渡す属性名を一致させる
            return "userDeleteResult";
        }
    
    }

}
