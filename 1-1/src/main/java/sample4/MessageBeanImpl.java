package sample4;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	//생성자를 통한 주입
	public MessageBeanImpl(String name) { //생성자
		this.name = name;
	}
	
	//세터를 통한 주입
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}	

	
	public void sayHello() {
		String msg = greeting + name + "~";
		try {
			outputter.output(msg);//출력 
		} catch(Exception e) {
			
		}
		
	}

}
