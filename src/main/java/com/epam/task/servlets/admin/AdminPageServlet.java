package com.epam.task.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/cabinet/admin")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		List<User> usersWithoutAdmins = userService.getAllUsers();
		usersWithoutAdmins.removeAll(userService.getUsersByType(UserType.ADMIN));
		
		request.setAttribute("users", usersWithoutAdmins);
		request.setAttribute("requests", new RequestService().getAllRequests());
		
		request.getRequestDispatcher("/pages/admin/adminPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
