package com.epam.task.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

@WebServlet("/facebookLogin")
public class FacebookLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FACEBOOK_API_KEY = "123455368098854";
	private static final String FACEBOOK_API_SECRET = "64faa5e7544907cfdba7041d1ccd541f";
	private static final String CALLBACK_URL = "http://localhost:8080/booker/oauth2callback";

	public FacebookLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OAuth20Service service = new ServiceBuilder().apiKey(FACEBOOK_API_KEY).apiSecret(FACEBOOK_API_SECRET)
				.callback(CALLBACK_URL).build(FacebookApi.instance());

		HttpSession sess = request.getSession();
		sess.setAttribute("oauth2Service", service);
		response.sendRedirect(service.getAuthorizationUrl(null));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
