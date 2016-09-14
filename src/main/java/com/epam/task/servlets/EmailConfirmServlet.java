package com.epam.task.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.model.User;
import com.epam.task.database.service.MailConfirmService;
import com.epam.task.database.service.UserService;

@WebServlet("/email_confirmation")
public class EmailConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmailConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String code = request.getParameter("token");
			UserService userService = new UserService();
			MailConfirmService mailConfirmService = new MailConfirmService();
			MailConfirm confirm = mailConfirmService.getMailConfirmByCode(code);
			
			if(confirm != null) {
				User user = userService.getUserById(confirm.getUserId());
				user.setEmail(confirm.getEmail());
				userService.updateUser(user);
				
				HttpSession session = request.getSession();
				User userInSession = (User) session.getAttribute("user");
				if(userInSession != null && user.getId() == userInSession.getId()) {
					session.setAttribute("user", user);
				}
				
				response.sendRedirect(request.getContextPath() + "/home");
				mailConfirmService.removeMailConfirm(confirm.getId());
			} else {
				response.sendError(404);
			}
		} catch (Exception e) {
			response.sendError(500);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
