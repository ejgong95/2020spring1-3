package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.WriteDao;
import logic.ItemCatalog;
import logic.WriteCatalog;
import model.Bbs;
import model.Item;
import model.Writing;

@Controller
public class ReadController {
	@Autowired
	private WriteCatalog writeCatalog;
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private WriteDao writeDao;
	
	//페이지별 정보보기? (페이지 번호 누르면 그 페이지에 해당하는 내용들 출력)
	@RequestMapping(value="/read/product.html")
	public ModelAndView readItems(Integer pageNo) {
		ModelAndView mav = new ModelAndView("home/template");
		Integer count = itemCatalog.getItemCount();
		int pageCnt = 0;
		int currentPage = 0;
		if (pageNo == null) {
			currentPage = 1;
		} else {
			currentPage = pageNo;
		}
		if (count > 0) {
			pageCnt = count / 5;
			if(count % 5 > 0) {
				pageCnt++;
			}
		}
		List<Item> itemList = itemCatalog.getItems(currentPage);
		mav.addObject("ITEM_LIST", itemList);//
		mav.addObject("COUNT", pageCnt);//
		mav.addObject("BODY", "itemList.jsp");
		return mav;
		
		
	}
	
	//목록을 보여주는 컨트롤러 매핑
	@RequestMapping(value="/read/read.html")
	public ModelAndView readBBS(Integer pageNo) {
		ModelAndView mav = new ModelAndView("home/template");
		int currentPage = 0;
		if (pageNo == null) {
			currentPage = 1;
		} else {
			currentPage = pageNo;
		}
		int startRow = (currentPage - 1) * 5 + 1;
		int endRow = (currentPage  * 5);
//		Condition c = new Condition(); //검색 범위를 위한 모델
//		c.setStartRow(startRow); // 범위설정
//		c.setEndRow(endRow);
		List<Bbs> bbsList = writeCatalog.readBbs(currentPage);//DB에서 검색
		mav.addObject("BBS_LIST", bbsList); //검색결과를 MAV에 저장
		Integer totalCount = writeCatalog.getBbsCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 > 0) {
			pageCount++;
		}
		mav.addObject("pageCount", pageCount); //페이지 갯수를 저장
		mav.addObject("RESULT", "OK");
		mav.addObject("BODY", "bbsListView.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/readDetail.html")
	public ModelAndView detail (Integer SEQNO) {
		ModelAndView mav = new ModelAndView("home/template");
		Bbs bbs = writeCatalog.getBbsDetail(SEQNO);//글번호로 조회
		mav.addObject("BBS", bbs);
		mav.addObject("BODY", "bbsRead.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/readImage.html")
	public ModelAndView readImage(Integer id) { //id : 글번호
		ModelAndView mav = new ModelAndView("home/template");
		Writing writing = writeDao.getImageWriting(id);//글번호 검색
		mav.addObject("writing", writing);
		mav.addObject("BODY", "imageRead.jsp");
		return mav;
	}
	
	
}
