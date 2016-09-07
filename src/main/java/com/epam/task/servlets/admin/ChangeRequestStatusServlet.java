package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.service.RequestService;

@WebServlet("/change_request_status")
public class ChangeRequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeRequestStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestIdString = request.getParameter("requestId");
		String status = request.getParameter("status"); //APPROVED DECLINED
		
		if(requestIdString == null || status == null) {
			return;
		}
		
		int changed = new RequestService()
				.updateRequestStatus(Integer.parseInt(requestIdString), RequestStatus.valueOf(status));
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
