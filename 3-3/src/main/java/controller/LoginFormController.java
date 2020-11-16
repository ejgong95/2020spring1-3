package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;

@Controller
public class LoginFormController {
	private Shop shop; //DB쪽의 객체
	private Validator loginValidator; //validator 객체
	

	
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@ModelAttribute
	public User setUp() {
		return new User(); //login.jsp에 주입될 객체 생성
	}
	
	@RequestMapping(method=RequestMethod.GET) //login.jsp 폼을 띄운다
	public String loginFormSetup() {		
		return "login";		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult  br) {
		this.loginValidator.validate(user, br);//유효성 검사 실행
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) { //유효성 검사 결과 오류가 있는 경우, login.jsp에 에러 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser = this.shop.getUser(user); //DB에서 조회
			if(loginUser != null) {
				mav.setViewName("loginSuccess");
				mav.addObject("loginUser", loginUser);
				return mav;		
			} else {
				br.reject("error.login.user");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		} catch(EmptyResultDataAccessException e) {
			br.reject("error.login.user"); //에러 메세지 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}		
	}
	
	
}
