package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.Cart;
import model.Custom_info;


@Controller
public class CartController {
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/cart/login.html", method=RequestMethod.POST)
	public ModelAndView cartLogin(@Valid Custom_info guest, BindingResult br,
			HttpSession session) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		String password = loginDao.getPassword(guest.getId());
		if ( ! guest.getPassword().equals(password)) { //로그인 실패
			mav.addObject("cartLogin", "fail");
			return mav;
		} else { //로그인 성공
			mav.addObject("cartLogin", "success");
			session.setAttribute("loginUser", guest.getId());
			//DB에서 장바구니 정보를 불러온다
		}
		return mav;
	}
	
	@Autowired
	private LoginDao loginDao;
	
	//로그인 안했을 때의 매핑
	@RequestMapping(value="/cart/login.html", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nocartlogin");
		mav.addObject("guest", new Custom_info());
		return mav;
	}
	//-------------
	
	
	@RequestMapping(value="/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		if(id == null) { //로그인 안 한 경우
			ModelAndView mav = new ModelAndView(
					"redirect:/cart/login.html");
			mav.addObject("RESULT", "nologin");
			return mav;
		}
		Cart cart = (Cart) session.getAttribute("CART");
		if (cart == null) {
			cart = this.cart;
		}
		cart.addCart(CODE, 1, id); //상품, 번호, 계정
		session.setAttribute("CART", cart);
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM", 1);
		return mav;
	}
}
