package com.epam.task.controller.general;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.task.controller.util.Controller;
import com.epam.task.controller.util.RequestMapping;
import com.epam.task.controller.util.View;

//FINISHED
@Controller
public class MainController {	

	// FINISHED
	@RequestMapping(value = "/")
	public void index(View view) throws ServletException, IOException {
		String state = (String) view.getRequest().getSession().getAttribute("userState");
		try {
			if (state == null) {
				
			} else if (state.equals("admin")) {
				view.getResponse().sendRedirect(view.getRequest().getContextPath() + "/admin/home");
			} else {
				view.getResponse().sendRedirect(view.getRequest().getContextPath() + "/cabinet/home");
			}
		} catch (Exception e) {
		}

	}

}
