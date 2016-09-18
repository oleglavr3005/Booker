package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/change_request_status")
public class ChangeRequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangeRequestStatusServlet.class);

    public ChangeRequestStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestIdString = request.getParameter("requestId");
		String status = request.getParameter("status"); //APPROVED DECLINED
		
		if(requestIdString == null || status == null || 
				!(status.equalsIgnoreCase("APPROVED") || status.equalsIgnoreCase("DECLINED") )) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		RequestService requestService = new RequestService();
		RequestStatus statusEnum = RequestStatus.valueOf(status);
		int requestId = Integer.parseInt(requestIdString);
		Request req = requestService.getRequestById(requestId);

		int changed = 0;
		if(req != null && req.getStatus() == RequestStatus.PENDING) {
			changed = requestService
					.updateRequestStatus(requestId, statusEnum);
			if (statusEnum == RequestStatus.APPROVED) {
				int userId = req.getUserId();
				new UserService().updateUserType(userId, UserType.MANAGER);
			}
		}
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
