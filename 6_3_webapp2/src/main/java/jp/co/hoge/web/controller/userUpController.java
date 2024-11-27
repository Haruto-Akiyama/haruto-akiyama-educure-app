package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.hoge.web.controller.form.userUpdateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class userUpController {

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

    @PostMapping("/userUpdate")
    public String loginSubmit(@Validated @ModelAttribute("userUpdateForm") userUpdateForm userUpdateForm, 
            BindingResult bindingResult, Model model, HttpSession session) {

        try {

            if (bindingResult.hasErrors()) {
                return "userUpdate"; // エラーがある場合、再度ユーザー更新ページに戻る
            }
            int number;
            int loginId;
            int pass;

            number = Integer.parseInt(userUpdateForm.getUsersNumber());
            loginId = Integer.parseInt(userUpdateForm.getUsersLogin());
            pass = Integer.parseInt(userUpdateForm.getUsersPass());

            // loginidの重複チェック
            List<User> userLoginidList = userDao.findUserLoginId(loginId);

            // userLoginidList の各ユーザーについてログインIDを確認
            for (User user : userLoginidList) {
                if (user.getLoginid().equals(loginId)) {
                    // エラーメッセージを表示する
                    model.addAttribute("errorMessage", "そのログインIDは既に使われています。");
                    return "userUpdate";  
                }
            }

            // 既に登録されているIDか確認
            List<User> userIdList = userDao.findUserNumber(number);

            if (userIdList.isEmpty()) {
                // 登録処理
                userDao.registerUser(number, userUpdateForm.getUsersName(), userUpdateForm.getUsersRole(), loginId, pass);
                userIdList = userDao.findUserNumber(number);
                // 遷移
                model.addAttribute("userIdList", userIdList);
                return "userResult"; 

            } else {
                // 更新処理
                userDao.updateUser(number, userUpdateForm.getUsersName(), userUpdateForm.getUsersRole(), loginId, pass);
                userIdList = userDao.findUserNumber(number);
                // 遷移
                model.addAttribute("userIdList", userIdList);
                return "userResult"; 
            }

        } catch (NumberFormatException ne) {
            model.addAttribute("errorMessage", "管理番号、ログインID、パスワードは整数を入力してください");
            return "userUpdate";
        }

    } 
}
