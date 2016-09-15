package com.epam.task.database.dto;

public class SmsDto {
	
	
	public SmsDto(String number, String language, String code) {
		super();
		this.number = number;
		this.language = language;
		this.code = code;
	}

	int nmb;   

	String number;
	
	String language;
	
	String code;
	
	public String getText(){
		if (language.equals("en")){
	//		nmb = 1;
			nmb = 0;
			return "Confirm Code : " + code;
		}
		else {
			nmb = 0;
			return "Код Підтвердження : " + code;
		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNmb() {
		return nmb;
	}

	public void setNmb(int nmb) {
		this.nmb = nmb;
	}

}
