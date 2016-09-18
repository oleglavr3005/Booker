package com.epam.task.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

@WebServlet("/googleLogin")
public class GoogleLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String clientId = "313857400439-aeq4b1i4ouolnr4p2inh462i4mu0duhq.apps.googleusercontent.com";
    private final String clientSecret = "0b4DAckgRD5JLHoko5RdPOGB";
    private final String secretState = "secret" + new Random().nextInt(999_999);
    private static final String CALLBACK_URL = "http://localhost:8080/booker/googlecallback";


	public GoogleLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 OAuth20Service service = new ServiceBuilder()
	                .apiKey(clientId)
	                .apiSecret(clientSecret)
	                .scope("profile") // replace with desired scope
	                .state(secretState)
	                .callback(CALLBACK_URL)
	                .build(GoogleApi20.instance());
		 HttpSession sess = request.getSession();
		sess.setAttribute("oauth2Service", service);
		response.sendRedirect(service.getAuthorizationUrl(null));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
