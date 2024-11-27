package jp.co.hoge.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.hoge.web.controller.form.userDeleteForm;
import jp.co.hoge.web.controller.form.userUpdateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class userMenuContoroller {

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
    
    @GetMapping("/userUp")
    public String showUserUp(Model model,HttpSession session) {
    	
    	if (session.getAttribute("user") == null) {
            return "redirect:/"; // ログインしていなければログインページへ
        }
        
    	 model.addAttribute("userUpdateForm", new userUpdateForm());
    	
        return "userUpdate";  // login.jsp を表示
    }
    
    @GetMapping("/userDel")
    public String showUserDel(Model model,HttpSession session) {
       
    	if (session.getAttribute("user") == null) {
            return "redirect:/"; // ログインしていなければログインページへ
        }
    	
    	 model.addAttribute("userDeleteForm", new userDeleteForm());
    	
        return "userDelete";  // login.jsp を表示
    }
    
    @GetMapping("/userMenu")
    public String toUserMenu(Model model,HttpSession session) {
    	if (session.getAttribute("user") == null) {
            return "redirect:/"; // ログインしていなければログインページへ
        }
		return "userMenu";
    }
}
