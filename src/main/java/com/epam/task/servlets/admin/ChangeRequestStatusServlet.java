package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/change_request_status")
public class ChangeRequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeRequestStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestIdString = request.getParameter("requestId");
		String status = request.getParameter("status"); //APPROVED DECLINED
		
		if(requestIdString == null || status == null || !(status.equalsIgnoreCase("APPROVED") || status.equalsIgnoreCase("DECLINED") )) {
			response.sendError(500);
			return;
		}
		
		RequestService requestService = new RequestService();
		RequestStatus statusEnum = RequestStatus.valueOf(status);
		int changed = requestService
				.updateRequestStatus(Integer.parseInt(requestIdString), statusEnum);
		if (statusEnum == RequestStatus.APPROVED) {
			int userId = requestService.getRequestById(Integer.parseInt(requestIdString)).getUserId();
			new UserService().updateUserType(userId, UserType.MANAGER);
		}
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
