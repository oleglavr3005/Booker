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
		<div class="col s2" style=" float: left;">
			<li class="dropup">
				<a class="dropdown-toggle" data-toggle="dropdown" style="color: #ccd9dc; font-size: 18;">
					<span class="foot_language"></span> 
					<i class="fa fa-flag-o" aria-hidden="true"></i>
				</a>
				<ul class="dropdown-menu" style="font-size: 18;">
					<li><a class="language" rel="uk" onclick="changeLanguage('ua')" ><span
							class="lang-sm lang-lbl" lang="uk"></span></a></li>
					<li><a class="language" rel="en" onclick="changeLanguage('en')"><span
							class="lang-sm lang-lbl" lang="en"></span></a></li>
				</ul>
			</li>
		</div>
		<div сlass="col s1 offset-s1"
				style="color: #cccccc;float:right; font-size: 15px;">
				<span id="footer_copyright"> </span>
			</div>
			<div class="col s1" style="color: #8c8c8c; font-size: 20px;padding-right:5px; float:right; width:auto;">
				&#169 2016</div>
			
		</div>
	</section>
	
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/internalization.js"></script>
	<script>
		updateLanguage();
	</script>
	