package com.epam.task.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class ImageSetter {

	private HttpServletRequest request;
	private final String UPLOAD_PATH;

	public ImageSetter(HttpServletRequest request) {
		this.request = request;
		UPLOAD_PATH = request.getServletContext().getInitParameter("images-folder");
	}
	
	public ImageSetter(HttpServletRequest request, String destination){
		this.request = request;
		UPLOAD_PATH = request.getServletContext().getInitParameter("images-folder") + destination+"/";
	}
	
	@SuppressWarnings("rawtypes")
	public String uploadImage() throws Exception {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		File uploadDir = new File(UPLOAD_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				String fileName = new File(item.getName()).getName().replaceAll("%20", "").replaceAll(" ", "");
				String extension = FilenameUtils.getExtension(fileName);
				if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg")
						&& !extension.equalsIgnoreCase("png") && !extension.equalsIgnoreCase("raw")
						 && !extension.equalsIgnoreCase("tiff") && !extension.equalsIgnoreCase("wmf")
						 && !extension.equalsIgnoreCase("jp2") && !extension.equalsIgnoreCase("gif")
						 && !extension.equalsIgnoreCase("psd")) throw new Exception();
				File storeFile;
				while(true){
					storeFile = new File(UPLOAD_PATH + new Random().nextInt(10000000) + fileName);
					if(!storeFile.exists()) break;
				}
				item.write(storeFile);
				return storeFile.getName();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return null;
	}
}
