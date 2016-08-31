package com.epam.task.controller.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.util.Extracter;

public class View {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public View(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	public String getParameter(String param){
		return request.getParameter(param);
	}
	
	public Integer getSessionUserId() throws Exception{
		Object id = request.getSession().getAttribute("userID");
		
		if(id==null)
			throw new Exception("userId is null");
			
		return (Integer)id;
	}
	
	public String getLocale(){
		return (String) request.getSession().getAttribute("locale");
	}
	public String getLastUrlParam(){
		return Extracter.getLast(request.getPathInfo());
	}
	
	public void setAttribute(String arg, Object obj){
		request.setAttribute(arg, obj);
	}
	
	public void forward(String page) throws ServletException, IOException{
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	
}
