package com.epam.task.servlets;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
 * Servlet implementation class FacebookCallBackServlet
 */
@WebServlet("/oauth2callback")
public class FacebookCallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FacebookCallBackServlet.class);
	private ObjectMapper objectMapper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacebookCallBackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Check if the user have rejected
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
		final OAuth2AccessToken accessToken = s.getAccessToken(code);
		// testing login
		System.out.println(accessToken + ", 'rawResponse'='" + accessToken.getRawResponse() + "')");
		// Now we're going to access a protected resource...
		final OAuthRequest req = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me", s);
		s.signRequest(accessToken, req);
		final Response res = req.send();
		// get user facebook id
		User socUser = getFacebookUser(res);
		System.out.println(socUser);
		// find user by email
		UserService userService = new UserService();
		User user = userService.getUserByEmail(socUser.getEmail());

		if (user == null) {
			// set user picture
			System.out.println("Print image");
//			saveImage(socUser.getSocialNetworkId());
			socUser.setImage(saveFacebookPhoto(socUser.getSocialNetworkId()));
			userService.insertUser(socUser);
		}
		user = userService.getUserByEmail(socUser.getEmail());
		// set User to session
		request.getSession().setAttribute("user", user);

		response.sendRedirect(request.getContextPath() + "/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private User getFacebookUser(Response response) throws IOException {
		objectMapper = new ObjectMapper();
		String responseBody = response.getBody();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		//JsonNode idNode = jsonNode.get("id");
		String userId = jsonNode.get("id").asText();
		String[] nameSurname = jsonNode.get("name").asText().split(" ");
		String name = nameSurname[0];
		String surname = nameSurname[1];
		// return idNode.asText();
		User user = new User();
		user.setSocialNetwork("FB");
		user.setSocialNetworkId(userId); // set FaceBookId
		user.setLastName(surname);
		user.setFirstName(name);
		user.setEmail(user.getSocialNetworkId() + "@booker.com");
		user.setStatus("ACTIVE");
		user.setType("USER");
		user.setPassword("pass");
		user.setLanguage("en"); // change lang
		return user;
	}
	private String saveFacebookPhoto(String socId)  {
		String url = "http://graph.facebook.com/"+socId+"/picture?type=large";
		try {
			url = getFinalLocation(url);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(url);
		  String savePath = "C://epam//images";
		  File fileSaveDir = new File(savePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	        }		
	//	String savePath = Paths.get(".").toAbsolutePath().normalize().toFile() + "/resources/images" + File.separator
      //          + socId + ".jpg";
		System.out.println(savePath);
		 URL imageUrl = null;
		try {
			imageUrl = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage image = null;

            URL url1;
			try {
				url1 = new URL(url);
				  image = ImageIO.read(url1);

		            ImageIO.write(image, "jpg",new File(fileSaveDir + "\\" + socId +".jpg"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
		return socId +".jpg";
	}
	
	
	public static String getFinalLocation(String address) throws IOException{
	    URL url = new URL(address);
	    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	    int status = conn.getResponseCode();
	    if (status != HttpURLConnection.HTTP_OK) 
	    {
	        if (status == HttpURLConnection.HTTP_MOVED_TEMP
	            || status == HttpURLConnection.HTTP_MOVED_PERM
	            || status == HttpURLConnection.HTTP_SEE_OTHER)
	        {
	            String newLocation = conn.getHeaderField("Location");
	            return getFinalLocation(newLocation);
	        }
	    }
	    return address;
	}
}
