<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
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
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/style.css">

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
	background-color: #26A69A;
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
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">

		<h4 style="text-align: center; margin-top: 20px;">
			<span id="settings_header"></span>
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s10 offset-s1">
				<ul class="tabs" style="background: #12444c;">
					<li class="tab col s3"><a class="active" href="#test1"
						style="color: #F7F7F7;"><b><p id="tab_personal">PERSONAL</p></b></a></li>
					<li class="tab col s3"><a href="#test2" style="color: #F7F7F7"><b><p
									id="tab_contact">CONTACT</p></b></a></li>
					<c:if test="${user.type eq 'USER' }">
						<li class="tab col s3"><a href="#test3"
							style="color: #F7F7F7"><b><p id="tab_manage">MANAG</p></b></a></li>
					</c:if>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<div class="container-fluid">
					<div class="row settings-title">
						<h4 style="text-align: center; margin-top: 20px;">
							<span id="settings_header_PERSONAL"></span>
						</h4>
					</div>

					<div class="row">
						<div class="col s4">
							<a href="#!"><img id="avatarImg"
								style="max-height: 200px; padding: 10px; max-width: 290px; float: right"
								<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="${user.image}" />">
							</a> <input style="margin-top: 60px; display: none" type="file"
								id="avatarInput" onchange="showPhoto()" accept="image/*" />
						</div>
						<div class="col s7 offset-s1">

							<div class="row fields">
								<div class="input-field col s10">
									<div class="ui pointing label"
										style="background-color: #f7f7f7;">
										<span id="settings_enter_name"
											style="color: #b7b2b2; background-color: #9990;"></span>
									</div>
									<input id="name" type="text" class="validate"
										value="${user.firstName}" length="45"> <label
										id="nameLbl" data-error="${fmtName}" for="name"> </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s10">
									<div class="ui pointing label"
										style="background-color: #f7f7f7;">
										<span id="settings_enter_surname"
											style="color: #b7b2b2; background-color: #9990;"></span>
									</div>
									<input id="surname" type="text" class="validate"
										value="${user.lastName}" length="45"> <label
										id="surnameLbl" data-error="${fmtSurname}" for="surname"></label>
								</div>
							</div>


						</div>
					</div>



					<div class="row" style="margin-top: 20px;">
						<div class="col s3 offset-s9">
							<a id="savePersonal" class="waves-effect waves-light btn"
								onclick="savePersonalData('${fmtMail}','${fmtMailExist}')"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
								class="settings_enter_save"></span> </a>
						</div>
					</div>

					<div class="divider"></div>

					<div class="row" style="margin-bottom: 10px;">
						<h4 id="pwd_title" style="text-align: center; margin-top: 20px;">
							<span id="settings_header_pass"></span>
						</h4>

					</div>
					<div class="row inline field fields">
						<div class="input-field col s8 offset-s2">
<!-- 							<div class="ui pointing label" style="background-color: #f7f7f7;"> -->
<!-- 								<span id="settings_enter_pass" -->
<!-- 									style="color: #b7b2b2; background-color: #9990;"></span> -->
<!-- 							</div> -->
							<input id="currentPassword" type="password" class="validate">
							<label id="currentPasswordLbl" data-error="${fmtPass}"
								for="currentPassword"><span id="settings_enter_pass"></span></label>
						</div>
					</div>
					<div class="row inline field fields">
						<div class="input-field col s8 offset-s2">
<!-- 							<div class="ui pointing label" style="background-color: #f7f7f7;"> -->
<!-- 								<span id="settings_enter_passnew" -->
<!-- 									style="color: #b7b2b2; background-color: #9990;"></span> -->
<!-- 							</div> -->
							<input id="newPassword" type="password" class="validate">
							<label id="newPasswordLbl" data-error="${fmtNewPass}"
								for="newPassword"><span id="settings_enter_passnew"></span></label>
						</div>
					</div>
					<div class="row inline field fields">
						<div class="input-field col s8 offset-s2">
<!-- 							<div class="ui pointing label" style="background-color: #f7f7f7;"> -->
<!-- 								<span id="settings_enter_passrepeat" -->
<!-- 									style="color: #b7b2b2; background-color: #9990;"></span> -->
<!-- 							</div> -->
							<input id="repeatPassword" type="password" class="validate">
							<label id="repeatPasswordLbl" data-error="${fmtRepPass}"
								for="repeatPassword"><span id="settings_enter_passrepeat"></span></label>
						</div>
					</div>
					<div class="row" style="margin-top: 20px;">
						<div class="col s3 offset-s7">
							<a id="savePassword" class="waves-effect waves-light btn"
								onclick="savePassword('${fmtHeader}','${fmtSucces}')"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
								id="settings_save_pass"></span></a>
						</div>
					</div>
				</div>
			</div>
			<!-- 			End of Tab #1 -->


			<!-- 				Tab #2 -->
			<div id="test2" class="col s12">
				<div class="container">
					<h4 style="text-align: center; margin-top: 20px;">
						<span id="settings_header_CONTACT"></span>
					</h4>

					<div class="row fields">
						<div class="input-field col s12">
<!-- 							<div class="ui pointing label" style="background-color: #f7f7f7;"> -->
<!-- 								<span id="settings_enter_phone" -->
<!-- 									style="color: #b7b2b2; background-color: #9990;"></span> -->
<!-- 							</div> -->
							<input id="phoneNumber" type="text" class="validate"
								value="${user.phoneNumber}" length="45"> <label style="margin-top: -25px;"
								id="phoneLbl" data-error="${fmtName}" for="phoneNumber"><span id="settings_enter_phone"></span>
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
									name="phonoCheckBox" <c:if
								test="${user.phoneNumber == null || user.phoneNumber == ''}">disabled</c:if>/> <label for="phoneCheckBox"> <span
									class="settings_chk_mails">I WANT RECEIVE MESSAGES ABOUT
										NEW ROOMS!</span></label>
							</p>
						</div>
					</div>


					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" class="validate"
 								<c:if test="${user.email.substring(user.email.length()-1) != '*'}"> value="${user.email}"</c:if> 
								length="80"> <label style="margin-top: -25px;" id="emailLbl"
								data-error="${fmtMail}" for="email"><span id="settings_enter_mail"></span></label>
							
								<p>
									<input style="margin-top 5px" type="checkbox" class="filled-in" id="eMailBox"
										name="eMailBox" <c:if
								test="${user.email.substring(user.email.length()-1) == '*'}">disabled</c:if>/> <label for="eMailBox"> <span
										class="settings_chk_mails"> </span></label>
								</p>
						</div>
					</div>

					<script>
						$('#phoneCheckBox').attr('checked',
								'${user.phoneNotif}' == 'true');
						$('#eMailBox').attr('checked',
								'${user.emailNotif}' == 'true');
					</script>

					<div class="row" style="margin-top: 20px;">
						<div class="col s4 offset-s1">
							<label ><span style="display:none" id="settings_confirmMail">text</span></label>
							
						</div>
						<div class="col s3 offset-s4">
							<a id="savePersonal" class="waves-effect waves-light btn"
								onclick="saveContactData()"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
								class="settings_enter_save"></span></a>
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
								<span id="settings_header_MANAGE"></span>
							</h4>
						</div>

						<div class="row fields">
							<div class="input-field col s12">
								<textarea id="requestForm" class="materialize-textarea">${request.message}</textarea>
								<label for="settings_enter_requests">
									<span id="settings_enter_request"></span>
								</label>
							</div>
						</div>
						
						<div class="row" style="margin-top: 20px;">
							<div class="col s2">
								<a id="cancelRequest" class="waves-effect waves-light btn"
									onclick="createRequest(false)"
									style="background: #F55151; 
									<c:if test="${request.message == ''}"> visibility: hidden; </c:if>
									color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
									class="subscribes_table_remove"></span></a>
							</div>
							<div class="col s2 offset-s8">
								<a id="createRequest" class="waves-effect waves-light btn"
									onclick="createRequest(true)"
									style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
									class="btn_send"></span></a>
							</div>
						</div>


					</div>

				</div>
				<!-- 			End of Tab #3 -->
			</c:if>
		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
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
