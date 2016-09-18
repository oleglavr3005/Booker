package com.epam.task.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.util.ConfirmCodeGenerator;
import com.epam.task.util.PasswordHasher;

@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ForgotPassword.class);

    public ForgotPassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email == null) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		try {
			UserService userService = new UserService();
			User user = userService.getUserByEmail(email);
			String newPass = ConfirmCodeGenerator.getCode();
			user.setPassword(PasswordHasher.hash(newPass));
			userService.updateUser(user);
			userService.sendPass(user, newPass);
			response.getWriter().write("+");
		} catch (NoSuchAlgorithmException e) {
        	LOGGER.error("Hash exception", e);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
