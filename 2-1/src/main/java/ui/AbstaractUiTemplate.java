package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstaractUiTemplate extends AbstractUi{
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
	//유효성검사
	protected boolean isValidNumber(String str) {
		if(StringUtils.isBlank(str)) { //비어있으면 false
			return false;
		}
		if( ! StringUtils.isNumeric(str)) { //숫자형태 문자열 아닌경우 false
			return false;
		}
		int number = NumberUtils.toInt(str);
		if(getMinMenuNumber() <= number &&
				number <= getMaxMenuNumber()) { //최소~최대 메뉴 번호 사이
			return true;
		}
		return false;
	}
	public void show() {
		showMenu();
		String inputedString = this.getInputedString(); //this -> AbstractUi
		if(isValidNumber(inputedString)) { //유효성 검사
			execute(NumberUtils.toInt(inputedString)); //유효한 메뉴면 실행
		}
		
	}

}
