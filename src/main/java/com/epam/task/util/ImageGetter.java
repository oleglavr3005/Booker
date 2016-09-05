package com.epam.task.util;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class ImageGetter {
	public static void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = request.getServletContext().getInitParameter("images-folder");
		String imageUrl = Extracter.getLast(request.getPathInfo());
		path += imageUrl;
		response.addHeader("Content-Type", "image/jpeg, image/jpg, image/png, image/gif");
		FileInputStream fileInputStream = new FileInputStream(path);
		byte[] bytes = IOUtils.toByteArray(fileInputStream);
		ServletOutputStream s = response.getOutputStream();
		s.write(bytes);
		s.close();
	}
}
