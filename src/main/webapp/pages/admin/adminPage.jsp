<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>Booker | ADMIN</title>
<link rel="icon" type="image/ico"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.ico">
<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/simple-sidebar.css"
	rel="stylesheet">

<link type="text/css" rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css"
	media="screen,projection" />


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/languages.min.css">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">


<style>
.btn {
	background: #26A69A;
	color: #999999;
}

.optionstyle {
	font-size: 15px;
	font-family: 'Times NewRoman', Times, serif;
}

.labelstyle {
	font-size: 18px;
	font-family: 'Times NewRoman', Times, serif;
}

.tabs {
	box-shadow: 0 3px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
	transition: box-shadow .25s;
	border-radius: 5px;
	background-color: #F3EAEA;
}

.bg-img {
	border-style: solid;
	border-width: 3px 0px 0px;
	border-color: grey;
	width: 100%;
	/* 	background: */
	/* 		url('http://3.bp.blogspot.com/-UXVFcPTKwrk/VC9-GaPAooI/AAAAAAAAFfo/g_uYO8A1PCo/s1600/black%2Bgrey%2Bgradient%2Bbackground%2Bfor%2Bweb.jpg') */
	background:
		url(${pageContext.servletContext.contextPath}/resources/images/foot.jpg)
		center center no-repeat;
	background-size: cover; &: before { content : '';
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background-image: linear-gradient(to bottom right, #002f4b, #dc4225);
	opacity: .6;
}

}
.well {
	padding: 0px;
}
</style>

</head>
<body>

	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">

		<h4 style="text-align: center; margin-top: 20px;">
			<fmt:message key="admin.header" />
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #638F98;">
					<li class="tab col s5 offset-s1"><a class="active" href="#test1"
						style="color: #1A3D44"><b><p id="tab_users">USERS</p></b></a></li>
					<li class="tab col s5 offset-s1"><a href="#test2" style="color: #1A3D44"><b><p
									id="tab_contact">CONTACT</p></b></a></li>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<div class="container">
					<div class="row settings-title">
						<h4>
							<fmt:message key="settings.header.USERS" />
						</h4>
					</div>

TABS WITH USERS
ID | fName | lName | mail | phoneNumber | type | status(comboBox) | 

					
				</div>
			</div>
			<!-- 			End of Tab #1 -->


			<!-- 				Tab #2 -->
			<div id="test2" class="col s12">
				<div class="container">
					<div class="row settings-title">
						<h4>
							<fmt:message key="settings.header.CONTACT" />
						</h4>
					</div>


TABS WITH MAILS
ID | userId | reqDate | message | status | 			(status == 'PENDING' => whiteBackground + 2 button (APPROVE(GREEN)) / DECLINE(RED))ELSE grey) 

				</div>

			</div>
			<!-- 			End of Tab #2 -->

		</div>
	</div>
		

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/tablesorter/jquery-1.10.2.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/settings/settings.js"></script>

	<script>
		$(document).ready(function() {
			$('input#name, input#surname, input#email').characterCounter();
		});
	</script>

</body>
</html>
