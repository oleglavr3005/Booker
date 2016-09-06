package com.epam.task.servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

/**
 * Servlet implementation class GoogleCallbackServlet
 */
@WebServlet("/googlecallback")
public class GoogleCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NETWORK_NAME = "G+";
	private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/plus/v1/people/me";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleCallbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = request.getParameter("error");
		if ((null != error) && ("access_denied".equals(error.trim()))) {
			HttpSession sess = request.getSession();
			sess.invalidate();
			response.sendRedirect(request.getContextPath()); // redirect to home
																// page
			return;
		}

		// OK the user have consented so lets find out about the user
		HttpSession sess = request.getSession();
		OAuth20Service s = (OAuth20Service) sess.getAttribute("oauth2Service");
		String code = request.getParameter("code");
		OAuth2AccessToken accessToken = s.getAccessToken(code);
		// testing login
		System.out.println(accessToken + ", 'rawResponse'='" + accessToken.getRawResponse() + "')");
		//accessToken = s.refreshAccessToken(accessToken.getRefreshToken());
	        System.out.println("Refreshed the Access Token!");
	        System.out.println("(if your curious it looks like this: " + accessToken
	                + ", 'rawResponse'='" + accessToken.getRawResponse() + "')");
	        System.out.println();
	        final OAuthRequest req = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, s);
			s.signRequest(accessToken, req);
			final Response res = req.send();
			System.out.println(res.getBody());
			//
			User socUser = getGoogleUser(res);
			System.out.println(socUser);
			// find user by email
			UserService userService = new UserService();
			User user = userService.getUserByEmail(socUser.getEmail());
			
			if (user == null) {
				// set user picture
			//	System.out.println("Print image");
				saveGooglePhoto(socUser);
				userService.insertUser(socUser);
			}
			user = userService.getUserByEmail(socUser.getEmail());
			// set User to session
			request.getSession().setAttribute("user", user);

			response.sendRedirect(request.getContextPath() + "/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private User getGoogleUser(Response response) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String responseBody = response.getBody();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		//JsonNode idNode = jsonNode.get("id");
		String userId = jsonNode.get("id").asText();
		String name = jsonNode.get("name").get("familyName").asText();
		String surname = jsonNode.get("name").get("givenName").asText();
		String img = jsonNode.get("image").get("url").asText().split("\\?sz=")[0]; // Little fix
		// return idNode.asText();
		User user = new User();
		user.setSocialNetwork("GP"); // change to G+
		user.setSocialNetworkId(userId); // set GoogleId
		user.setLastName(surname);
		user.setFirstName(name);
		user.setImage(img); // setImage
		user.setEmail(user.getSocialNetworkId() + "@booker.com");
		user.setStatus("ACTIVE");
		user.setType("USER");
		user.setPassword("pass");
		user.setLanguage("en"); // change Lang
		return user;
	}
	private void saveGooglePhoto(User socUser)  {
		String url = socUser.getImage();
		 String SAVE_DIR = getServletContext().getInitParameter("images-folder");
//		  String appPath = getServletContext().getRealPath("");
//		  String savePath = appPath + SAVE_DIR;
		  File fileSaveDir = new File(SAVE_DIR);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	        }		
	//	String savePath = Paths.get(".").toAbsolutePath().normalize().toFile() + "/resources/images" + File.separator
      //          + socId + ".jpg";
		BufferedImage image = null;
            URL url1;
			try {
				url1 = new URL(url);
				  image = ImageIO.read(url1);

		            ImageIO.write(image, "jpg",new File(fileSaveDir + "\\" + socUser.getSocialNetworkId() +".jpg"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          socUser.setImage(socUser.getSocialNetworkId() + ".jpg");
	}
}
