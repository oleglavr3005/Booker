package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Request;
import com.epam.task.database.model.enums.RequestStatus;

public class RequestService {
	
	private DaoManager daoManager;
	
	public RequestService() {
		super();
		daoManager = new DaoManager();
	}

	public List<Request> getAllRequests() {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().getAllRequests());
	}

	public List<Request> getAllRequestsByStatus(RequestStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().getAllRequestsByStatus(status));
	}

	public Request getRequestById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().getRequestById(id));
	}

	public Request getRequestByUserId(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().getRequestByUserId(id));
	}

	public int insertRequest(Request request) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().insertRequest(request));
	}

	public int updateRequest(Request request) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().updateRequest(request));
	}

	public int updateRequestStatus(int requestId, RequestStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().updateRequestStatus(requestId, status));
	}

	public int removeRequest(int requestId) {
		return daoManager.executeAndClose(() -> daoManager.getRequestDao().removeRequest(requestId));
	}
}
