package com.epam.task.servlets.settings;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.service.RequestService;

@WebServlet("/create_request")
public class CreateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateRequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		
		if(message == null) {
			response.sendError(500);
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		RequestService service = new RequestService();
		Request userRequest = service.getRequestByUserId(user.getId());
		
		int result;
		String resultString;
		if (userRequest == null) { //if user has no request, create new
			result = service.insertRequest(new Request(0, user.getId(), message, new Timestamp(new Date().getTime()), "PENDING"));
			resultString = "sent";
		} else { //else modify or remove
			if(message.length() > 0) {	//update
				if(userRequest.getStatus() == RequestStatus.DECLINED) {	//if was declined earlier
					resultString = "sent_again";
				} else {
					resultString = "updated";
				}
				userRequest.setMessage(message);
				userRequest.setStatus("PENDING");
				userRequest.setRequestDate(new Timestamp(new Date().getTime()));
				result = service.updateRequest(userRequest);
			} else {					//remove
				result = service.removeRequest(userRequest.getId());
				resultString = "removed";
			}
		}

		response.getWriter().write(result > 0 ? resultString : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
