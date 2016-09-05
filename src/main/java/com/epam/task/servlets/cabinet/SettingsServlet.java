package com.epam.task.servlets.cabinet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.User;
import com.epam.task.database.service.RequestService;

@WebServlet("/cabinet/settings")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SettingsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Request req = new RequestService().getRequestByUserId(user.getId());
		
		request.setAttribute("message", req == null ? "" : req.getMessage());
		request.getRequestDispatcher("/pages/user/settings.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
