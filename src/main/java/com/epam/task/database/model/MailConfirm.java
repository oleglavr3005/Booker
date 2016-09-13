package com.epam.task.database.model;

import com.epam.task.database.transformers.DataBaseField;

public class MailConfirm {

	@DataBaseField(fieldName = "confirm_id")
	private int id;

	@DataBaseField(fieldName = "user_id")
	private int userId;

	@DataBaseField(fieldName = "e_mail")
	private String email;

	@DataBaseField(fieldName = "confirm_code")
	private String confirmCode;

	public MailConfirm(int id, int userId, String email, String confirmCode) {
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.confirmCode = confirmCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}
	
	
}
