package dao;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteDao {
	//게시글등록
	Integer getMaxId();
	void putBBS(Bbs bbs);
	
	void insertWriting(Writing writing);
	void updateWriting(Writing writing);
	void deleteWriting(Integer id);
	Writing getImageWriting(Integer id);
	Integer getMaxWritingId();
	List<Writing> getWriting(Condition pageNo); //매퍼에 condition으로 잡혀잇음
	Integer selectMaxGroupId();
	void updateOrderNo(Writing writing);
	
	//메서드 추가 int rownum = null;
	Integer selectImageCount(); //이미지 게시글 갯수검색
	Integer selectRownum(Integer seqno); // 글번호로 일련번호 검색
	
}
