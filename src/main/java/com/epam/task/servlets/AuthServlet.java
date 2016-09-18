package com.epam.task.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.UserService;
import com.epam.task.util.PasswordHasher;

@WebServlet({ "/auth" })
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AuthServlet.class);

    public AuthServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email == null || password == null || password.length() < 6) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			User user = new UserService().getUserByEmail(email);
			if (user == null || user.getStatus().equals(UserStatus.PENDING) || !user.getPassword()
					.equals(PasswordHasher.hash(password))) {
				response.getWriter().write("false");
				response.getWriter().flush();
				return;
			}
			request.getSession().setAttribute("user", user);
			
			JSONObject json = new JSONObject();
			json.put("logged", true);
			
			response.getWriter().print(json.toString());
		} catch (JSONException e) {
        	LOGGER.error("JSON exception", e);
			response.getWriter().write("false");
		} catch (NoSuchAlgorithmException e) {
        	LOGGER.error("Hash exception", e);
			response.getWriter().write("false");
		}
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
