package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.HotelPhoto;
import com.epam.task.util.ImageSetter;

@WebServlet("/upload_hotel")
public class LoadHotelPicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(LoadHotelPicturesServlet.class);

    public LoadHotelPicturesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spliterator = ":::";
		response.setContentType("application/text");
		response.setCharacterEncoding("UTF-8");
    	try {
			List<HotelPhoto> photos = new ImageSetter(request).uploadHotelImages();
			if (photos.isEmpty()){
				photos.add(new HotelPhoto(0,"no_image.jpg", "", 0, true));
			}
			StringBuilder hotelImages = new StringBuilder();
			for(HotelPhoto hotelPhoto : photos) {
				if(hotelImages.length() != 0) {
					hotelImages.append(spliterator);
				}
				hotelImages.append(hotelPhoto.getImg());
			}		
			response.getWriter().write(hotelImages.toString());
		} catch (Exception e) {
        	LOGGER.error("Load hotel pics exception", e);
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
