package com.epam.task.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.util.ConfirmCodeGenerator;
import com.epam.task.util.PasswordHasher;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (surname == null || name == null || email == null || password == null || password.length() < 6) {
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
		} catch (Exception e) {
			response.getWriter().write("false");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
