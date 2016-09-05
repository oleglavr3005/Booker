package com.epam.task.servlets.settings;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.util.PasswordHasher;

@WebServlet("/change_password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String newPasswordConfirm = request.getParameter("newPasswordConfirm");
		
		if(oldPassword == null || newPassword == null || newPasswordConfirm == null) {
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		
		// add "shortNewPass" result if havent complete validation
		
		try {
			if(user.getPassword().equals(PasswordHasher.hash(oldPassword))) {
				if(newPassword.equals(newPasswordConfirm)) {
					user.setPassword(PasswordHasher.hash(newPassword));
					new UserService().updateUser(user);
					session.setAttribute("user", user);
					response.getWriter().write("true");
				} else {
					response.getWriter().write("passwordsDontMatch"); //or return false
				}
			} else {
				response.getWriter().write("wrongOldPass"); //or return false
			}
		} catch (NoSuchAlgorithmException e) {
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
