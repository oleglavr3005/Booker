package com.epam.task.servlets.social.vk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.epam.task.database.service.VkService;

/**
 * Servlet implementation class VkOauthServlet
 */
@WebServlet("/vk_oauth")
public class VkOauthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VkOauthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("vkOAuth", true);
		//request.setAttribute("user", null);
		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String token = request.getParameter("token");

		VkService service = new VkService();
		User socUser;
		try {
			socUser = service.getUserByToken(userId, token);

			UserService userService = new UserService();
			User user = userService.getUserByEmail(socUser.getEmail());
			
			if (user == null) {
				userService.insertUser(socUser);
			}
			user = userService.getUserByEmail(socUser.getEmail());

			request.getSession().setAttribute("user_id", userId);
			request.getSession().setAttribute("token", token);
			request.getSession().setAttribute("user", user);

			response.sendRedirect(request.getContextPath() + "/home");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
