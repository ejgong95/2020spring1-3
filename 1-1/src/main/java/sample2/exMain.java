package sample2;

public class exMain {
	
	public static void main(String[] args) {
		MyMessage mm = new MyMessageKr();
		mm.sayHello("홍길동");
		mm = new MyMessageEn();
		mm.sayHello("홍길동");				
	}
}
