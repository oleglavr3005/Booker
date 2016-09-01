package com.epam.task.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.UserService;

/**
 * Servlet implementation class SignUpConfirmServlet
 */
@WebServlet("/signup_confirmation")
public class SignUpConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String code = request.getParameter("token");
			UserService userService = new UserService();
			User user = userService.getUserByConfirmCode(code);
			if (user != null && user.getStatus().equals(UserStatus.PENDING)) {
				user.setStatus("ACTIVE");
				userService.updateUser(user);
				request.getSession().setAttribute("userID", user.getId());
				request.getSession().setAttribute("userState", "user");
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				response.sendError(404);
			}
		} catch (Exception e) {
//			LOG.error("error with signup_confirm " + e);
			response.sendError(500);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
