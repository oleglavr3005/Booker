package com.epam.task.servlets.social.vk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.util.VKOAuth2Details;

/**
 * Servlet implementation class VkLoginServlet
 */
@WebServlet("/vkLogin")
public class VkLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VkLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String autorizationString = VKOAuth2Details.userAuthorizationUri + "?client_id=" + VKOAuth2Details.clientId
				+ "&redirect_uri=" + VKOAuth2Details.redirectUri + "&scope=wall," + VKOAuth2Details.scope
				+ "&response_type=token" + "&v=5.52";
		response.sendRedirect(autorizationString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
