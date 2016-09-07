package com.epam.task.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.service.RequestService;
import com.epam.task.database.service.UserService;

@WebServlet("/cabinet/admin")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("users", new UserService().getAllUsers());
		request.setAttribute("requestsPending", new RequestService().getAllRequestsByStatus(RequestStatus.PENDING));
		request.setAttribute("requestsApproved", new RequestService().getAllRequestsByStatus(RequestStatus.APPROVED));
		request.setAttribute("requestsDeclined", new RequestService().getAllRequestsByStatus(RequestStatus.DECLINED));
		
		request.getRequestDispatcher("pages/admin/adminPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
