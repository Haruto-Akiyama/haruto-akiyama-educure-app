package jp.co.hoge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.hoge.web.controller.form.deleteForm;
import jp.co.hoge.web.controller.form.loginForm;
import jp.co.hoge.web.controller.form.registerForm;
import jp.co.hoge.web.controller.form.searchForm;
import jp.co.hoge.web.controller.form.updateForm;
import jp.co.hoge.web.dao.ProductsDao;
import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.Role;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.ProductsService;
import jp.co.hoge.web.service.RoleService;
import jp.co.hoge.web.service.UserService;

@Controller
public class loginController {

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

	@GetMapping("/")
	public String showLoginForm(Model model) {
		// LoginForm オブジェクトを作成して、JSP に渡す
		model.addAttribute("loginForm", new loginForm());
		return "login";  // login.jsp を表示
	}

	@PostMapping("/login")
	public String loginSubmit(@Validated @ModelAttribute("loginForm") loginForm loginForm, 
			BindingResult bindingResult, Model model, HttpSession session) {

		try {
			Integer.parseInt(loginForm.getLoginId());
			Integer.parseInt(loginForm.getPass());
		} catch (NumberFormatException ne) {
			model.addAttribute("errorMessage", "IDとパスワードは必須で整数を入力してください");
			return "login"; // ログイン失敗時、エラーメッセージを表示
		}

		if (bindingResult.hasErrors()) {
			return "login"; // エラーがある場合、再度ログインページに戻る
		}

		List<User> users = userDao.findIdAndPass(Integer.parseInt(loginForm.getLoginId()), Integer.parseInt(loginForm.getPass()));

		if (users.isEmpty()) {
			model.addAttribute("errorMessage", "IDまたはPASSが間違っています");
			return "login"; // ログイン失敗時、エラーメッセージを表示
		}

		User user = users.get(0);
		session.setAttribute("user", user);
		session.setAttribute("roleId", user.getRoleid()); // セッションにroleIdを保存

		// ユーザーのroleidをModelに追加（必須ではないが、ビューに渡すことで使いやすくなる）
		model.addAttribute("roleId", user.getRoleid());

		// 役職の情報をセッションに保存（必要に応じて）
		List<Role> roles = roleDao.findAllRoles();
		session.setAttribute("roles", roles);

		return "menu"; // メニュー画面に遷移
	}

	@Controller
	public class MenuController {

		@GetMapping("/search")
		public String search(Model model, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			model.addAttribute("searchForm", new searchForm());
			return "search"; // search.jspに遷移
		}

		@GetMapping("/register")
		public String register(Model model, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			model.addAttribute("registerForm", new registerForm());
			return "register"; // register.jspに遷移
		}

		@GetMapping("/update")
		public String update(Model model, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			model.addAttribute("updateForm", new updateForm());
			return "update"; // update.jspに遷移
		}

		@GetMapping("/delete")
		public String delete(Model model, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			model.addAttribute("deleteForm", new deleteForm());
			return "delete"; // delete.jspに遷移
		}

		@GetMapping("/userSettings")
		public String userSettings(Model model, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			return "userMenu"; // userSettings.jspに遷移
		}

		@GetMapping("/logout")
		public String logout(HttpServletRequest request, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていなければログインページへ
			}

			// ログアウト処理を行う
			request.getSession().invalidate(); // セッションを無効化
			return "/logout"; // ログイン画面にリダイレクト
		}

		@GetMapping("/menu")
		public String toMenu(HttpServletRequest request, HttpSession session) {
			if (session.getAttribute("user") == null) {
				return "redirect:/"; // ログインしていない場合はログイン画面へリダイレクト
			}

			return "menu";
		}
	}
}
