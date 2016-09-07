package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.UserService;

@WebServlet("/change_user_status")
public class ChangeUserStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeUserStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIdString = request.getParameter("userId");
		String status = request.getParameter("status"); //BANNED ACTIVE
		
		if(userIdString == null || status == null) {
			return;
		}
		
		int changed = new UserService()
				.updateUserStatus(Integer.parseInt(userIdString), UserStatus.valueOf(status));
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
