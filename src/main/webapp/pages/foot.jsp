<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>

	<section class="" style="   background-color: #387f7b  !important;">
		<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
		<img alt="" src="${pageContext.servletContext.contextPath}/resources/images/footer.png" style="width: 1400px;">

		</div>
		<div class="row" style="background-color: #0d353c; margin: auto; padding: 10px;">
			<div class="col s1 offset-s9"
				style="color: #8c8c8c; font-size: 20px;">
				&#169 2016</div>

			<div сlass="col s1 offset-s1"
				style="color: #cccccc; font-size: 15px;">
				<span id="footer_copyright"> </span>
			</div>
		</div>
	</section>
	
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/internalization.js"></script>
	<script>
		updateLanguage();
	</script>
	