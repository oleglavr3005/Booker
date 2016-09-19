package com.epam.task.servlets.settings;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.model.User;
import com.epam.task.database.service.MailConfirmService;
import com.epam.task.database.service.UserService;
import com.epam.task.util.ConfirmCodeGenerator;
import com.epam.task.util.MailSender;
import com.epam.task.util.StringUtil;

@WebServlet("/change_email")
public class ChangeEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangeEmailServlet.class);

    public ChangeEmailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mailNotifString = request.getParameter("mailNotif");
		
		if(!StringUtil.isBoolean(mailNotifString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		Boolean mailNotif = Boolean.parseBoolean(mailNotifString);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String em = email == null ? user.getEmail() : email;
		
		int result;
		if(user.getEmail().equals(em)) {
			user.setEmailNotif(mailNotif);
			result = new UserService().updateUser(user);
			session.setAttribute("user", user);
		} else {

			String confirmCode = ConfirmCodeGenerator.getCode();
			new Thread(new Runnable() {

				@Override
				public void run() {
					sendConfirmation(user.getFirstName(), em, confirmCode);
				}
			}).start();
			
			MailConfirmService mailConfirmService = new MailConfirmService();
			MailConfirm mailConfirm = mailConfirmService.getMailConfirmByUser(user.getId());
			if(mailConfirm == null) {
				result = mailConfirmService.insertMailConfirm(new MailConfirm(0, user.getId(), em, confirmCode));
			} else {
				mailConfirm.setEmail(em);
				mailConfirm.setConfirmCode(confirmCode);
				result = mailConfirmService.updateMailConfirm(mailConfirm);
			}
		}
		
		try {
			JSONObject json = new JSONObject();
			json.put("changed", result > 0 ? "true" : "false");
			json.put("email", email);
			response.getWriter().print(json.toString());
			response.getWriter().flush();
		} catch (JSONException e) {
        	LOGGER.error("JSON exception", e);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void sendConfirmation(String name, String email, String confirmCode) {
		String subject = "Mail Confirmation";
		String link = "http://localhost:8080/booker/email_confirmation?token=" + confirmCode;
		String text = "<body style='background-color: #fff'>" +

				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Mail Confirmation"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + name + "</h1>"
				+ "<p>In order to confirm email pls click here: </p>" + "</div><div id='one'><p>"
				+ link + "<p></div></div></div></body>";

		MailSender.send(subject, text, email);
	}
}
