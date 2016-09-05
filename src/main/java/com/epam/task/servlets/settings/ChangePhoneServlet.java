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

@WebServlet("/change_phone")
public class ChangePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePhoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
		Boolean phoneNotif = Boolean.parseBoolean(request.getParameter("phoneNotif"));

		if(phoneNumber == null) {
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (phoneNumber != "") {		//super validation
			user.setPhoneNumber(phoneNumber);
		}
		user.setPhoneNotif(phoneNotif);
		int result = new UserService().updateUser(user);
		session.setAttribute("user", user);
		response.getWriter().write(result > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
