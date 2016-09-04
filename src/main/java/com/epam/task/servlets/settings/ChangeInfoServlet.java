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

//change last name and first name
@WebServlet("/change_info")
public class ChangeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		if(lastName == null || firstName == null) {
			return; //wtf
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (firstName != "") {
			user.setFirstName(firstName);
		}
		if (lastName != "") {
			user.setLastName(lastName);
		}
		int result = new UserService().updateUser(user);
		session.setAttribute("user", user);
		response.getWriter().write(result > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
