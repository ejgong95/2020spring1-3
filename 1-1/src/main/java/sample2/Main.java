package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//스프링 빈 환경설정 파일을 연다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sample2/beans.xml");
		MyMessage mm = (MyMessage) ctx.getBean("myMessageKr"); //환경설정 파일에 주입
		mm.sayHello("홍길동");

	}

}
