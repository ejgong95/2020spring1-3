package controller;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import utils.UserEntryValidator;

@Controller
public class UserEntryFormController {
	private Shop shop;	
	private UserEntryValidator userEntryValidator;
	private MessageSource messageSource;//프로퍼티즈 파일 처리를 위해 필요
	
	   public void setShop(Shop shop) {
	      this.shop = shop;
	   }
	   public void setuserEntryValidator(UserEntryValidator userEntryValidator) {
	      this.userEntryValidator = userEntryValidator;
	   }
	   public void setMessageSource(MessageSource messageSource) {
	      this.messageSource = messageSource;
	   }
	   
	   @ModelAttribute
	   public User setUP() {
	      User user = new User();
	      MessageSourceAccessor msa = new MessageSourceAccessor(this.messageSource);
	      user.setUserId(msa.getMessage("user.userId.default"));//디폴트 메시지를 불러온다.
	      user.setUserName(msa.getMessage("user.userName.default"));//디폴트 메시지를 불러온다.
	      return user;
	   }
	   
	   
	   @RequestMapping(method=RequestMethod.GET)
	   public String toUserEntry() {
		   return "userEntry";
	   }
	   
	   @RequestMapping(method=RequestMethod.POST)
	   public ModelAndView onSubmit(User user, BindingResult br) {
		   this.userEntryValidator.validate(user, br);
			ModelAndView mav = new ModelAndView();
			if(br.hasErrors()) {
				mav.getModel().putAll(br.getModel());
				return mav;
			}
			try {
				this.shop.putUser(user);//DB에 삽입
				mav.setViewName("userEntrySuccess");
				mav.addObject("user",user);
				return mav;
			}catch(DataIntegrityViolationException e) {
				br.reject("error.duplicate.user");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
	   }
}
