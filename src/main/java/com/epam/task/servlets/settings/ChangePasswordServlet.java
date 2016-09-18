package com.epam.task.servlets.settings;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.util.PasswordHasher;

@WebServlet("/change_password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangePasswordServlet.class);

    public ChangePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String newPasswordConfirm = request.getParameter("newPasswordConfirm");
		
		if(oldPassword == null || newPassword == null || newPasswordConfirm == null || newPassword.length() < 6) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		try {
			if(user.getPassword().equals(PasswordHasher.hash(oldPassword))) {
				if (newPassword.length() > 5) {
					if(newPassword.equals(newPasswordConfirm)) {
						user.setPassword(PasswordHasher.hash(newPassword));
						new UserService().updateUser(user);
						session.setAttribute("user", user);
						response.getWriter().write("true");
					} else {
						response.getWriter().write("passwordsDontMatch");
					}
				} else {
					response.getWriter().write("shortNewPass");
				}
			} else {
				response.getWriter().write("wrongOldPass");
			}
		} catch (NoSuchAlgorithmException e) {
        	LOGGER.error("Hashing exception");
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
