package com.epam.task.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.UserService;

@WebServlet("/signup_confirmation")
public class SignUpConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SignUpConfirmServlet.class);

    public SignUpConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("token");
		UserService userService = new UserService();
		User user = userService.getUserByConfirmCode(code);
		if (user != null && user.getStatus().equals(UserStatus.PENDING)) {
			user.setStatus("ACTIVE");
			userService.updateUser(user);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
        	LOGGER.error("Attempt to load page that does not exist");
			response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
