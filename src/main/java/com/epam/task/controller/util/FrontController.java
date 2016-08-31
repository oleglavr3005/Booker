package com.epam.task.controller.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.reflections.Reflections;

import com.epam.task.util.MailInit;

@WebServlet("/frontcontroller/*")
@MultipartConfig(maxFileSize = 16177215)
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		MailInit.initializeSession();

		String controllerPackage = getServletContext().getInitParameter(
				"controllers");

		Reflections reflections = new Reflections(controllerPackage);

		Set<Class<?>> controllers = reflections
				.getTypesAnnotatedWith(Controller.class);

		for (Class<?> clazz : controllers) {
			String parentKey = "";

			if (clazz.isAnnotationPresent(RequestMapping.class))
				parentKey = clazz.getAnnotation(RequestMapping.class).value();

			Set<Method> methods = getAnnotatedMethods(clazz);

			for (Method method : methods) {
				RequestMapping rq = method.getAnnotation(RequestMapping.class);
				String key = parentKey + rq.value() + rq.method().name();

				ActionFactory.addAction(key, method);
			}
		}

	}

	private Set<Method> getAnnotatedMethods(Class<?> clazz) {
		Set<Method> methods = new HashSet<>();

		for (Method method : clazz.getMethods()) {
			if (method.isAnnotationPresent(RequestMapping.class))
				methods.add(method);
		}
		return methods;
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		View view = new View(request, response);
		Method action = ActionFactory.getAction(request);

		try {
			if (action != null) {
				action.invoke(action.getDeclaringClass().newInstance(), view);
			} else {
				response.sendError(404);
			}
		} catch (InvocationTargetException | IllegalArgumentException
				| IllegalAccessException | InstantiationException e) {
			response.sendError(404);
		}
	}

}
