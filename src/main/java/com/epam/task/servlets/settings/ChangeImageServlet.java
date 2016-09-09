package com.epam.task.servlets.settings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.util.ImageSetter;

@WebServlet("/change_image")
public class ChangeImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String photo = new ImageSetter(request).uploadImage();
			User user = (User) request.getSession().getAttribute("user");
			user.setImage(photo);
			new UserService().updateUser(user);
			
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(photo);
		} catch (Exception e) {
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
