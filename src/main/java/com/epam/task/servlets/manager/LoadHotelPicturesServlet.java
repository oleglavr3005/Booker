package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.util.ImageSetter;

/**
 * Servlet implementation class LoadHotelPicturesServlet
 */
@WebServlet("/upload_hotel")
public class LoadHotelPicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadHotelPicturesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spliterator = "***";
    	try {
			List<HotelPhoto> photos = new ImageSetter(request,"/hotel").uploadHotelImages();
			if (photos.isEmpty()){
				photos.add(new HotelPhoto(0,"hotel/no_image.jpg", "", 0));
			}
			StringBuilder hotelImages = new StringBuilder();
			for(HotelPhoto hotelPhoto : photos) {
				if(hotelImages.length() != 0) {
					hotelImages.append(spliterator);
				}
				hotelImages.append(hotelPhoto.getImg());
			}
			int roomId = Integer.parseInt(request.getParameter("roomId"));
			HotelPhotoService service = new HotelPhotoService();
			for( HotelPhoto hotelPhoto : photos){
				hotelPhoto.setHotelId(roomId);
				service.insertHotelPhoto(hotelPhoto);
			}			
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(hotelImages.toString());
		} catch (Exception e) {
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
