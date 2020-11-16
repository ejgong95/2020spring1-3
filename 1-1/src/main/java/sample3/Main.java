package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//스프링 환경 설정 파일을 연다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample3/beans.xml");
		//id danaka를 가져옴
		Danaka danaka = (Danaka) ctx.getBean("danaka");
		//메서드 호출
		danaka.has();
		

	}

}
