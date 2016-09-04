package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.transformers.DataBaseField;

public class Request {
	@DataBaseField(fieldName = "request_id")
	private int id;
	@DataBaseField(fieldName = "user_id")
	private int userId;
	@DataBaseField(fieldName = "message")
	private String message;
	@DataBaseField(fieldName = "request_date")
	private Timestamp requestDate;
	@DataBaseField(fieldName = "status")
	private RequestStatus status;
	
	public Request(int id, int userId, String message, Timestamp requestDate, String status) {
		this.id = id;
		this.userId = userId;
		this.message = message;
		this.requestDate = requestDate;
		this.status = status == null ? null : RequestStatus.valueOf(status);
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : RequestStatus.valueOf(status);
	}

	
}
