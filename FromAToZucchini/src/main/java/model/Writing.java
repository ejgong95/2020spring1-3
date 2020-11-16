package model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Writing {
	private Integer writing_id;//�۹�ȣ
	private Integer parent_id;//�θ�� ��ȣ
	private Integer group_id;//�׷� ��ȣ
	private Integer order_no;//���� ��ȣ
	@NotEmpty(message="작성자를 입력하세요.")
	private String writer_name;//�г���
	private String email;//�̸���
	@NotEmpty(message="암호를 입력하세요.")
	private String password;//��ȣ
	@NotEmpty(message="제목을 입력하세요.")
	private String title;//����
	private String register_date;//�ۼ���
	@NotEmpty(message="내용을 입력하세요.")
	private String content;//�� ����
	private String image_name;//���� �̸�
	
	public Integer getWriting_id() {
		return writing_id;
	}
	
	private MultipartFile image; //파일
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	public void setWriting_id(Integer writing_id) {
		this.writing_id = writing_id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
}



