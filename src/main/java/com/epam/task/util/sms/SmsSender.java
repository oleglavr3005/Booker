package com.epam.task.util.sms;

public class SmsSender {
	
	private static final String LOGIN = "lighthouse_group"; 
	private static final String PASS = "12345678";
	


//	private static Logger LOG = Logger.getLogger(SmsSender.class);
//	static {
//		DOMConfigurator.configure("src/main/java/com/xml/Warn.xml");
//	}
	

	public static void sendSms(String number, String text, int nmb) {

		SendApi sd = new SendApi(LOGIN, PASS, "utf-8", true);
		System.out.println(text);
	//	sd.sendSms(number, text, 0, "", "", 0, "", "");
		sd.getBalance();

	}
	
	public static void main(String[] args) {
		sendSms("0630489892","sss",0);
	}
	
	

}
