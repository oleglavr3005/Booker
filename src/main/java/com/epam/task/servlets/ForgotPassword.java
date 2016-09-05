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
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService userService = new UserService();
			User user = userService.getUserByEmail(request.getParameter("email"));
			String newPass = new ConfirmCodeGenerator().getCode();
			user.setPassword(PasswordHasher.hash(newPass));
			userService.updateUser(user);
			userService.sendPass(user, newPass);
			response.getWriter().write("+");
		} catch (Exception e) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
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
