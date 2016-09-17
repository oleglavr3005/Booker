package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.OrderService;
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
		
		if(userIdString == null || status == null || !(status.equalsIgnoreCase("BANNED") || status.equalsIgnoreCase("ACTIVE"))) {
			response.sendError(500);
			return;
		}
		
		UserStatus statusEnum = UserStatus.valueOf(status);
		int userId = Integer.parseInt(userIdString);
		if(statusEnum == UserStatus.BANNED) {	//clear cart
			new OrderService().removeAllOrdersByStatus(userId, OrderStatus.ORDER);
		}
		int changed = new UserService()
				.updateUserStatus(userId, statusEnum);
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
