package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.User;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/cabinet/admin/request/*")
public class RequestPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
			return;
		}
		Request userRequest = new RequestService().getRequestById(id);
		int userId = userRequest.getUserId();
		User user = new UserService().getUserById(userId);
		
		request.setAttribute("request", userRequest);
		request.setAttribute("firstName", user.getFirstName());
		request.setAttribute("lastName", user.getLastName());
		request.setAttribute("userPhoto", user.getImage());
		
		request.getRequestDispatcher("/pages/admin/request.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
