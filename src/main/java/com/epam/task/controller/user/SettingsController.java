package com.epam.task.controller.user;

import java.io.IOException;

import com.epam.task.controller.util.Controller;
import com.epam.task.controller.util.RequestMapping;
import com.epam.task.controller.util.View;
import com.epam.task.database.model.User;
import com.epam.task.database.service.UserService;

@Controller
@RequestMapping(value = "/cabinet/settings")
public class SettingsController {

	//FINISHED
	@RequestMapping(value = "")
	public void index(View view) throws IOException {
		try {
			String state = (String) view.getRequest().getSession().getAttribute("userState");
			if (state != null) {
				view.getRequest().setAttribute("userState", "user");
				User user = new UserService().getUserById(view.getSessionUserId());
				view.getRequest().setAttribute("user", user);
				view.getRequest().getRequestDispatcher("/pages/cabinet/settings.jsp")
						.forward(view.getRequest(), view.getResponse());
			} else {
				view.getResponse().sendError(404);
			}
		} catch (Exception e) {
			view.getResponse().sendError(404);
		}
	}

	
}
