package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstaractUiTemplate {
	private SelectTeamUi selectTeamUi;
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	protected void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("*************************");
		System.out.println("  스포츠 팀 관리 시스템 ver1.0");
		System.out.println(" 1. 종료");
		System.out.println(" 2. 팀 목록 보기");
		System.out.println();
		System.out.println("원하는 번호를 입력하고 Enter를 누르세요.");
		
	}


	protected int getMaxMenuNumber() { //최대 메뉴 번호 리턴
		// TODO Auto-generated method stub
		return 2;
	}


	protected int getMinMenuNumber() { //최소 메뉴 번호 리턴
		// TODO Auto-generated method stub
		return 1;
	}


	protected void execute(int number) {
		// TODO Auto-generated method stub
		switch (number) {
		case 1 : System.out.println("종료되었습니다. 이용해 주셔서 감사합니다.");
				 System.exit(0); //시스템 강제종료
				 break;
		case 2 : this.selectTeamUi.show(); //팀 목록을 보여주는 메뉴 호출
		
		}
	}

	public static void main(String[] args) {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("beans.xml");
		MenuUi menuUi = (MenuUi) ctx.getBean("menuUi");
		while(true) {
			menuUi.show(); //AbstaractUiTemplate에서 상속
		}
	}
}
