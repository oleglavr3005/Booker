package com.epam.task.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;

@WebServlet("/change_lang")
public class ChangeLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeLanguageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language"); //en ua
		
		if(language == null || !(language.equalsIgnoreCase("en") || (language.equalsIgnoreCase("ua")) ) ) {
			response.sendError(500);
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			user.setLanguage(language);
			session.setAttribute("user", user);
			new UserService().updateUser(user);
		} else {
			session.setAttribute("language", language);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
