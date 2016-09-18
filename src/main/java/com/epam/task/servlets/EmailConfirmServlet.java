package com.epam.task.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.model.User;
import com.epam.task.database.service.MailConfirmService;
import com.epam.task.database.service.UserService;

@WebServlet("/email_confirmation")
public class EmailConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EmailConfirmServlet.class);

    public EmailConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("token");
		UserService userService = new UserService();
		MailConfirmService mailConfirmService = new MailConfirmService();
		MailConfirm confirm = mailConfirmService.getMailConfirmByCode(code);

		if (confirm != null) {
			User user = userService.getUserById(confirm.getUserId());
			user.setEmail(confirm.getEmail());
			userService.updateUser(user);

			HttpSession session = request.getSession();
			User userInSession = (User) session.getAttribute("user");
			if (userInSession != null && user.getId() == userInSession.getId()) {
				session.setAttribute("user", user);
			}

			response.sendRedirect(request.getContextPath() + "/home");
			mailConfirmService.removeMailConfirm(confirm.getId());
		} else {
        	LOGGER.error("Attempt to load a page than does not exist");
			response.sendError(404);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
