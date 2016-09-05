<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Booker | Settings</title>
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
			<fmt:message key="settings.header" />
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #638F98;">
					<li class="tab col s3"><a class="active" href="#test1"
						style="color: #1A3D44"><b><p id="tab_personal">PERSONAL</p></b></a></li>
					<li class="tab col s3"><a href="#test2" style="color: #1A3D44"><b><p
									id="tab_contact">CONTACT</p></b></a></li>
					<c:if test="${user.type eq 'USER' }">
						<li class="tab col s3"><a href="#test3"
							style="color: #1A3D44"><b><p id="tab_manage">MANAG</p></b></a></li>
					</c:if>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<div class="container">
					<div class="row settings-title">
						<h4>
							<fmt:message key="settings.header.PERSONAL" />
						</h4>
					</div>

					<div class="row">
						<div class="col s4">
							<a href="#!"><img id="avatarImg"
								style="height: 100px; padding: 10px; width: 110px;"
								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"></a>
						</div>
						<div class="col s8">

<!-- 							<div class="file-field input-field"> -->
<!-- 								<div class="waves-effect waves-light btn"> -->
									<input style="margin-top:60px" type="file" id="avatarInput"
								onchange="showPhoto()" accept="image/*" />
<!-- 								</div> -->
<!-- 								<div class="file-path-wrapper"> -->
<!-- 									<input class="file-path validate" type="text"> -->
<!-- 								</div> -->
<!-- 							</div> -->

							
						</div>
					</div>

					<div class="row fields">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.name" />
							</div>
							<input id="name" type="text" class="validate"
								value="${user.firstName}" length="45"> <label
								id="nameLbl" data-error="${fmtName}" for="name"> </label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.surname" />
							</div>
							<input id="surname" type="text" class="validate"
								value="${user.lastName}" length="45"> <label
								id="surnameLbl" data-error="${fmtSurname}" for="surname"></label>
						</div>
					</div>

					<div class="row" style="margin-top: 20px;">
						<div class="col s3 offset-s7">
							<a id="savePersonal" class="waves-effect waves-light btn"
								onclick="savePersonalData('${fmtMail}','${fmtMailExist}')"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
									key="settings.enter.save" /></a>
						</div>
					</div>

					<div class="divider"></div>

					<div class="row" style="margin-bottom: 10px;">
						<h4 id="pwd_title">
							<fmt:message key="settings.header.pass" />
						</h4>
					</div>
					<div class="row inline field fields">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.pass" />
							</div>
							<input id="currentPassword" type="password" class="validate">
							<label id="currentPasswordLbl" data-error="${fmtPass}"
								for="currentPassword"></label>
						</div>
					</div>
					<div class="row inline field fields">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.passnew" />
							</div>
							<input id="newPassword" type="password" class="validate">
							<label id="newPasswordLbl" data-error="${fmtNewPass}"
								for="newPassword"></label>
						</div>
					</div>
					<div class="row inline field fields">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.passrepeat" />
							</div>
							<input id="repeatPassword" type="password" class="validate">
							<label id="repeatPasswordLbl" data-error="${fmtRepPass}"
								for="repeatPassword"></label>
						</div>
					</div>
					<div class="row" style="margin-top: 20px;">
						<div class="col s3 offset-s7">
							<a id="savePassword" class="waves-effect waves-light btn"
								onclick="savePassword('${fmtHeader}','${fmtSucces}')"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
									key="settings.enter.save" /></a>
						</div>
					</div>
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

					<div class="row fields">
						<div class="input-field col s9">
							<div class="ui pointing label">
								<fmt:message key="settings.enter.phone" />
							</div>
							<input id="phoneNumber" type="text" class="validate"
								value="${user.phoneNumber}" length="45"> <label
								id="phoneLbl" data-error="${fmtName}" for="phoneNumber">
							</label>

							<!-- 							<div class="switch"> -->
							<!-- 								<label> Off <input type="checkbox" id="phoneCheckBox"> <span -->
							<!-- 									class="lever"></span> On -->
							<!-- 								</label> -->
							<!-- 								<label for="phoneCheckBox">I  -->
							<!--  									WANT RECEIVE MESSAGES ABOUT NEW ROOMS!</label>  -->
							<!-- 							</div> -->



							<p>
								<input type="checkbox" class="filled-in" id="phoneCheckBox"
									name="phonoCheckBox" /> <label for="phoneCheckBox">I
									WANT RECEIVE MESSAGES ABOUT NEW ROOMS!</label>
							</p>
						</div>
					</div>


					<c:if test="${user.socialNetworkId == null}">
						<div class="row">
							<div class="input-field col s9">
								<div class="ui pointing label">
									<fmt:message key="settings.enter.mail" />
								</div>
								<input id="email" type="email" class="validate"
									value="${user.email}" length="80"> <label id="emailLbl"
									data-error="${fmtMail}" for="email"> </label>
								<p>
									<input type="checkbox" class="filled-in" id="eMailBox"
										name="eMailBox" /> <label for="eMailBox">I WANT
										RECEIVE MAILS ABOUT NEW ROOMS!</label>
								</p>
							</div>
						</div>
					</c:if>

					<script>
						$('#phoneCheckBox').attr('checked',
								'${user.phoneNotif}' == 'true');
						$('#eMailBox').attr('checked',
								'${user.emailNotif}' == 'true');
					</script>

					<div class="row" style="margin-top: 20px;">
						<div class="col s3 offset-s7">
							<a id="savePersonal" class="waves-effect waves-light btn"
								onclick="saveContactData()"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
									key="settings.enter.save" /></a>
						</div>
					</div>


				</div>

			</div>
			<!-- 			End of Tab #2 -->

			<c:if test="${user.type eq 'USER' }">
				<!-- 			Tab #3 -->
				<div id="test3" class="col s12">

					<div class="container">
						<div class="row settings-title">
							<h4>
								<fmt:message key="settings.header.MANAGE" />
							</h4>
						</div>

						<div class="row fields">
							<div class="input-field col s9">
								<div class="ui pointing label">
									<fmt:message key="settings.enter.request" />
								</div>
								<textarea id="requestForm" class="materialize-textarea"
									value="${message}">${message}</textarea>
							</div>
						</div>

						<div class="row" style="margin-top: 20px;">
							<div class="col s12">
								<a id="savePersonal" class="waves-effect waves-light btn"
									onclick="createRequest()"
									style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
										key="settings.enter.save" /></a>
							</div>
						</div>


					</div>

				</div>
				<!-- 			End of Tab #3 -->
			</c:if>
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
