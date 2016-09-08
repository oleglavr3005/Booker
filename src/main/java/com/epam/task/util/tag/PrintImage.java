package com.epam.task.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintImage extends SimpleTagSupport {
	private String url;
	private String id;

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		writer.println("/booker/get_image/" + url);
	}
}
