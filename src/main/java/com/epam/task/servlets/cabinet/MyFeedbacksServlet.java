package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;

@WebServlet("/cabinet/my_feedbacks")
public class MyFeedbacksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyFeedbacksServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		request.setAttribute("feedbacks", new FeedbackService().getAllFeedbacksByUser(user.getId()));
		request.getRequestDispatcher("/pages/user/myFeedbacks.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
