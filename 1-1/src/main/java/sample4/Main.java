package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//스프링 환경 설정 파일을 연다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample4/beans.xml");
		//id danaka를 가져옴
		MessageBean bean = (MessageBean) ctx.getBean("messageBean");
		//메서드 호출
		bean.sayHello();

	}

}
