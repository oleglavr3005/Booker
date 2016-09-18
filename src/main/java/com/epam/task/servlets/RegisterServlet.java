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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class);

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (surname == null || name == null || email == null || password == null || password.length() < 6) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		try {
			User user = new User();
			user.setLastName(surname);
			user.setFirstName(name);
			user.setEmail(email);
			user.setType("USER");
			user.setStatus("PENDING");
			user.setPassword(PasswordHasher.hash(password));
			user.setConfirmCode(ConfirmCodeGenerator.getCode());
			
			user.setLanguage("en");
			
			user.setImage("avatar.png");
			
			UserService userService = new UserService();
			userService.insertUser(user);

			response.getWriter().write("true");
		} catch (NoSuchAlgorithmException e) {
        	LOGGER.error("Hash exception", e);
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
