package com.epam.task.util;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class ImageGetter {
	private static final Logger LOGGER = Logger.getLogger(ImageGetter.class);
	
	public static void upload(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getInitParameter("images-folder");
		String imageUrl = Extracter.getLast(request.getPathInfo());
		path += imageUrl;
		response.addHeader("Content-Type", "image/jpeg, image/jpg, image/png, image/gif");
		try{
			FileInputStream fileInputStream = new FileInputStream(path);
			
			byte[] bytes = IOUtils.toByteArray(fileInputStream);
			ServletOutputStream s = response.getOutputStream();
			s.write(bytes);
			s.close();
		} catch (Exception e){
        	LOGGER.error("Error while getting image", e);
			e.printStackTrace();
		}
	}
}
