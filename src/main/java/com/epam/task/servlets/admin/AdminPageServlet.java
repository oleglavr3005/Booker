package com.epam.task.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Request;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/cabinet/admin")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("users", new UserService().getAllNotAdmins());
		List<Request> requests = new RequestService().getAllRequests();
		int maxSize = 20;
		for(Request userRequest : requests) {
			String message = userRequest.getMessage();
			int endIndex = message.length() < maxSize ? message.length() : maxSize;
			String newMessage = message.substring(0, endIndex);
			if (endIndex == maxSize) {
				newMessage += "...";
			}
			userRequest.setMessage(newMessage);
		}
		request.setAttribute("requests", requests);
		
		request.getRequestDispatcher("/pages/admin/adminPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
