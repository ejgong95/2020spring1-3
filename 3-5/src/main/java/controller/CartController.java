package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Controller
public class CartController {
	@Autowired
	private Shop shop;
	
	@RequestMapping(value="/cart/cartAdd.html") //장바구니 추가 매핑
	public ModelAndView add(Integer itemId, Integer quantity,
			HttpSession session) {
		//파라메터 2개 itemId, quantity과
		//세션(로그인 여부를 판단하기위해)
		Item selectedItem = shop.getItem(itemId); //상품 번호로 상품을 찾음
		Cart cart = (Cart) session.getAttribute("CART_KEY"); //세션에서 카트를 찾음
		if(cart == null) {
			cart = this.shop.getCart(); //없으면 생성	
		}
		cart.push(new ItemSet(selectedItem, quantity)); //ItemSet 생성 후 카트에 담음
		session.setAttribute("CART_KEY", cart);
		session.setAttribute("ITEM_KEY", selectedItem);
		session.setAttribute("NUMBER", quantity);
		//redirect (forward로 할 경우 새로고침할때마다 계속 입력)
		ModelAndView mav = new ModelAndView("redirect:/cart/result.html");
		return mav;		
	}
	
	
	@RequestMapping(value="/cart/result.html")
	public ModelAndView reload(HttpSession session) { //add메소드 결과가 여기로 이동
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		Item selectedItem = (Item) session.getAttribute("ITEM_KEY");
		Integer quantity = (Integer) session.getAttribute("NUMBER");
		User loginUser = (User) session.getAttribute("USER_KEY");
		ModelAndView mav = new ModelAndView("cart/cart");
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		mav.addObject("message", selectedItem.getItemName() + "을(를)" 
				+ quantity + "개 카트에 담았습니다.");
		mav.addObject("cart", cart);
		return mav;
		
	}
	
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		if (cart == null) {
			cart = this.shop.getCart();
		}
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart", cart);
		User loginUser = (User) session.getAttribute("USER_KEY");
		if (loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		return mav;
	}
	
	
	
	@RequestMapping(value="/cart/cartClear.html") //장바구니 삭제 매핑
	public ModelAndView clear(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = this.shop.getCart();
		}
		cart.clearAll();
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		mav.addObject("message", "카트를 비웠습니다.");
		return mav;
	}
	
}
