package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.util.ImageSetter;

/**
 * Servlet implementation class LoadRoomPicturesServlet
 */
@WebServlet("/upload_room")
public class LoadRoomPicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadRoomPicturesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<RoomPhoto> photo = new ImageSetter(request,"/room").uploadRoomImages();
			if (photo.isEmpty()){
				photo.add(new RoomPhoto(0,"room/no_image.jpg", "", 0));
			}
			int roomId = Integer.parseInt(request.getParameter("roomId"));
			RoomPhotoService service = new RoomPhotoService();
			for( RoomPhoto roomPhoto : photo){
				roomPhoto.setRoomId(roomId);
				service.insertRoomPhoto(roomPhoto);
			}			
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(photo.get(0).getImg());
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
