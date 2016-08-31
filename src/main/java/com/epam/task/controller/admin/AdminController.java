package com.epam.task.controller.admin;

import com.epam.task.controller.util.Controller;
import com.epam.task.controller.util.RequestMapping;
import com.epam.task.controller.util.View;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	// FINISHED
	@RequestMapping(value = "/home")
	public void index(View view) throws Exception {
		String state = (String) view.getRequest().getSession().getAttribute("userState");

		if (state != null && state.equals("admin")) {
			view.getRequest().getRequestDispatcher("/pages/index.jsp").forward(view.getRequest(), view.getResponse());
		} else if (state != null) {
			view.getResponse().sendRedirect(view.getRequest().getContextPath() + "/");
		} else {
			view.getResponse().sendError(404);
		}
	}

}
