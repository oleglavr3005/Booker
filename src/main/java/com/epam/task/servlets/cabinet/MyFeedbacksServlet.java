package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.dto.FeedbackDto;
import com.epam.task.database.model.Feedback;
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
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		List<Feedback> listFeedback = new FeedbackService().getAllFeedbacksByUser(user.getId());
		int countOfFeedbacks = listFeedback.size();
		
		int countOfPages = (int) Math.ceil(countOfFeedbacks / 5.0);
		if (page > countOfPages) {
			page--;
		}
		
		String compareBy = request.getParameter("compareBy");  //compareByDateAsc compareByDateDesc
		List<Feedback> listFeedbackByPage = new FeedbackService().getAllFeedbacksByUserAndPage(user.getId(), page, compareBy);

		request.setAttribute("countOfFeedbacks", countOfFeedbacks);
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("feedbacks", FeedbackDto.listConverter(listFeedbackByPage));
		request.setAttribute("currentPage", page);
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("/pages/user/feedbacks.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/user/myFeedbacks.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
