package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.RoomPhoto;
import com.epam.task.util.ImageSetter;

@WebServlet("/upload_room")
public class LoadRoomPicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoadRoomPicturesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String spliterator = ":::";
    	try {
			List<RoomPhoto> photos = new ImageSetter(request).uploadRoomImages();
			if (photos.isEmpty()){
				photos.add(new RoomPhoto(0,"no_image.jpg", "", 0));
			}
			StringBuilder roomImages = new StringBuilder();
			for(RoomPhoto hotelPhoto : photos) {
				if(roomImages.length() != 0) {
					roomImages.append(spliterator);
				}
				roomImages.append(hotelPhoto.getImg());
			}			
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(roomImages.toString());
		} catch (Exception e) {
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
