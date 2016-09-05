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
		
		user.setPhoneNumber(phoneNumber);
			
		if(phoneNumber.length() == 0) {
			user.setPhoneNotif(false);
		} else {
			user.setPhoneNotif(phoneNotif);
		}
		
		int result = new UserService().updateUser(user);
		session.setAttribute("user", user);
		
		try {
			JSONObject json = new JSONObject();
			json.put("changed", result > 0 ? "true" : "false");
			json.put("phoneNumber", user.getPhoneNumber());
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
