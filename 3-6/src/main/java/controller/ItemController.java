 package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping(value="/item/create.html")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Item());//Item객체를 주입한다.
		return mav;	
	} //3-5에서는 User user = new User(); 객체를 만들었지만 이렇게 바로 주입해도 된다...
	
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(@Valid Item item, BindingResult br,
			HttpServletRequest request) {
		//@Vaild 유효성 검사
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("add");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		MultipartFile multiFile = item.getPicture();//파일을 불러온다.
		String fileName = null;
		String path = null;
		OutputStream out = null;
		if(multiFile != null) { //파일이 선택된 경우
			fileName = multiFile.getOriginalFilename();//파일 이름 저장
			path = request.getSession().getServletContext().
					getRealPath("/upload/" + fileName);//업로드할 절대경로를 획득
			System.out.println("업로드 경로 : " + path);
			File file = new File(path); //업로드될 파일객체 생성
			try {
				out = new FileOutputStream(path); //파일로 출력하는 객체 생성
				BufferedInputStream bis = new BufferedInputStream(
						multiFile.getInputStream());//파일로부터 입력하는 객체 생성
				byte[] buffer = new byte[8106];//8K크기의 메모리
				int read = 0;
				while((read = bis.read(buffer)) > 0) {
					out.write(buffer, 0, read);
				} //최대 8K씩 파일에서 읽고, 출력 파일에 쓴다. 반복이 끝나면 업로드 완료
				if(out != null) {
					out.close(); //파일 입출력에 사용한 객체를 닫는다.
				}
				if(bis != null) {
					bis.close(); //파일 입출력에 사용한 객체를 닫는다.
				}
			} catch(Exception e) {
				
			}
		}
		item.setPictureUrl(fileName); //모델 객체에 파일이름 설정
		this.itemCatalog.entryItem(item); //DB에 삽입
		ModelAndView mav = new ModelAndView("redirect:/item/index.html");
		return mav ;
	}
	
	
	@RequestMapping(value = "/item/confirm.html")
	   public ModelAndView confirm(Integer itemId) {
	      ModelAndView mav = new ModelAndView("delete"); // 뷰이름 설정
	      Item item = this.itemCatalog.getItem(itemId); // 상품번호로 상품건색
	      mav.addObject(item); // 검색결과를 ModelAndView에 저장
	      mav.addObject("imageName", item.getPictureUrl()); // 이미지이름만 따로 저장
	      return mav;
	   }
	
	@RequestMapping(value="/item/delete.html")
	public ModelAndView delete(Integer itemId) {
		this.itemCatalog.deleteItem(itemId); //DB에서 삭제
		return this.index(); //목록을 출력하는 메서드 호출
	}
	
	@RequestMapping(value="/item/edit.html")
	public ModelAndView edit(Integer itemId) {
		ModelAndView mav = new ModelAndView("update"); //뷰이름설정
		Item item = this.itemCatalog.getItem(itemId); //DB에서 상품번호로 검색
		mav.addObject(item); //검색결과를 ModelAndView에 저장
		return mav;
	}
	
	@RequestMapping(value="/item/search.html")
	public ModelAndView search(String itemName) {
		if(itemName == null || itemName.equals("")) { //상품명이 없는 경우
			return this.index(); //목록을 출력
		}
		List<Item> itemList =this.itemCatalog.findItems(itemName); //이름으로 검색
		if(itemList == null || itemList.isEmpty()) { //검색결과가 없는 경우
			return this.index();
		}
		ModelAndView mav = new ModelAndView("index");//뷰이름 설정
		mav.addObject("itemList", itemList); //검색결과를 ModelAndView에 저장
		return mav;
	}
	
	@RequestMapping(value="/item/update.html")
	public ModelAndView update(@Valid Item item, BindingResult br,
			HttpServletRequest request) {
		if(br.hasErrors()) {
			ModelAndView mav= new ModelAndView("update");
			mav.getModel().putAll(br.getModel());
			return mav;
			
		}
		MultipartFile multiFile = item.getPicture();//파일을 읽어온다
		String fileName = null;
		String path = null;
		OutputStream out = null;
		if (!item.getPicture().getOriginalFilename().equals("")) {
			//파일의 이름이 공백이 아닌경우, 즉 이미지파일을 선택한 경우
			fileName = multiFile.getOriginalFilename();//파일이름추출
			path = request.getSession().getServletContext().getRealPath(
					"/upload/"+fileName);//절대경로획득
			File file = new File(path);//업로드될 파일 객체 생성
			try {
				out = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(
						multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				while( (read=bis.read(buffer)) > 0 ) {
					out.write(buffer, 0, read);
				}
				if(out != null) {
					out.close();
				}
				if(bis != null) {
					bis.close();
				}
			} catch (Exception e) {
				
			}
			item.setPictureUrl(fileName); //새로운 이미지 파일이름을 설정
		}
		this.itemCatalog.updateItem(item); //DB에서 변경
		return this.index(); //변경 후 목록을 추출
	}
	
	
	
	
	@RequestMapping(value="/item/index.html")
	private ModelAndView index() {
		List<Item> itemList = this.itemCatalog.getItems(); //상품목록을 DB에서 조회
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList); //조회 결과를 맵에 저장
		ModelAndView mav = new ModelAndView("index"); //뷰이름 설정
		mav.addAllObjects(model); //맵을 ModelAndView에 저장
		return mav;
		
	}
	
	
	
	
	
}
