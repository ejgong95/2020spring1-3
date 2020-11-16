package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class Item {
	@NotNull(message="상품번호를 입력하세요")
	private Integer itemId;//상품번호
	@NotEmpty(message="이름을 입력하세요")
	private String itemName;//상품이름
	@NotNull
	@Min(0)
	@Range(min=0, max=1000000, message="{min}보다 크고 {max}보다 작아야 합니다.")
	private Integer price;//상품가격
	@NotEmpty(message="설명을 입력하세요.")
	private String description;//상품설명
	private MultipartFile picture;//업로드될 파일
	private String pictureUrl;//파일의 이름
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}
