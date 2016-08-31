package com.epam.task.controller.general;

import com.epam.task.controller.util.Controller;
import com.epam.task.controller.util.RequestMapping;
import com.epam.task.controller.util.View;

// FINISHED
@Controller
public class PeriodicalController {
	
	// FINISHED
	@RequestMapping(value = "/search")
	public void index(View view) throws Exception {
		view.getRequest().getRequestDispatcher("/pages/card.jsp").forward(view.getRequest(), view.getResponse());
	}

	
}
