package controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs;
import model.Custom_info;

@Controller
public class HomeController {	
	@RequestMapping(value="/home/intro.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY", BODY);
		return mav;
	}
	@RequestMapping(value="/home/template.html")
	public ModelAndView template() {
		ModelAndView mav = new ModelAndView("home/template");
		return mav;
	}
	
	@RequestMapping(value="/home/bbsForm.html")
	public ModelAndView bbsForm() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Bbs()); //객체 주입
		mav.addObject("BODY","bbsInput.jsp");
		return mav;
	}
	
	
	
	//게시글 등록 컨트롤러
	
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/home/write.html", method=RequestMethod.POST)
	public ModelAndView write(@Valid Bbs bbs, BindingResult br, 
				HttpSession session) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY", "bbsInput.jsp"); //에러메세지를 jsp로 넘겨줌
			mav.getModel().putAll(br.getModel()); //
			return mav;
		}
		String id = (String) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		if(id == null) { //로그인을 하지 않은 경우
			mav.addObject("NOLOGIN", "yes");
			//ex)mav.addObject("NOITEM", "yes"); 상품을 등록하시려면 로그인하셔야합니다
			//메세지를 구별하기위해
			mav.addObject("guest", new Custom_info());
			mav.addObject("BODY", "nologin.jsp");
			return mav;
		} else { // 로그인을 한 경우
			bbs.setId(id); //작성자 계정을 설정
			writeCatalog.putBBS(bbs);//DB에 삽입
			return new ModelAndView("redirect:/read/read.html");
		}
		
	}
	
	//회원가입
	@RequestMapping(value="/home/userentry.html")
	public ModelAndView entryForm() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("guest", new Custom_info());
		mav.addObject("BODY", "userentry.jsp");
		return mav;
	}
	
	
	
}
