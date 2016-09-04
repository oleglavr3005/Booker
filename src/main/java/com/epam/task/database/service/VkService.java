package com.epam.task.database.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.epam.task.database.model.User;
import com.epam.task.util.VKOAuth2Details;

public class VkService {

	public User getUserByToken(String userId, String token) throws IOException, ParseException {

		User user = new User();
		String userInfo = VKOAuth2Details.usersGetMethodUri + "?user_ids=" + userId + "&fields=photo_max_orig"
				+ "&v=5.52" + "&access_token=" + token;

		URL url = new URL(userInfo);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

		JSONParser parser = new JSONParser();
		JSONObject jObject = (JSONObject) parser.parse(inputStreamReader);

		JSONObject response = (JSONObject) ((JSONArray) jObject.get("response")).get(0);

		user.setSocialNetwork("VK");
		user.setSocialNetworkId(response.get("id").toString());
		user.setLastName(response.get("last_name").toString());
		user.setFirstName(response.get("first_name").toString());
		user.setEmail(user.getSocialNetworkId() + "@booker.com");
		user.setStatus("ACTIVE");
		user.setType("USER");
		user.setPassword("pass");

		return user;
	}
}
