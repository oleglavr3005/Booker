package com.epam.task.servlets.settings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

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
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (firstName.length() > 0) {
			user.setFirstName(firstName);
		}
		if (lastName.length() > 0) {
			user.setLastName(lastName);
		}
		int result = new UserService().updateUser(user);
		session.setAttribute("user", user);
		
		try {
			JSONObject json = new JSONObject();
			json.put("changed", result > 0 ? "true" : "false");
			json.put("firstName", user.getFirstName());
			json.put("lastName", user.getLastName());
			response.getWriter().print(json.toString());
			response.getWriter().flush();
		} catch (JSONException e) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
