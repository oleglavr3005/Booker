package com.epam.task.servlets.settings;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;

@WebServlet("/change_email")
public class ChangeEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeEmailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		if(email == null) {
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.setEmail(email);
		int result = new UserService().updateUser(user);
		session.setAttribute("user", user);
		response.getWriter().write(result > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
