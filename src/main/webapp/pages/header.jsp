<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/themes/bootshop/bootstrap.min.css"
	media="screen" />
<link
	href="${pageContext.servletContext.contextPath}/resources/themes/css/base.css"
	rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link
	href="${pageContext.servletContext.contextPath}/resources/themes/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/resources/themes/css/font-awesome.css"
	rel="stylesheet" type="text/css">

<!-- Materialize -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css"
	media="screen,projection" />

<!--  Scripts -->
<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery-3.1.0.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/themes/js/bootstrap.min.js"
	type="text/javascript"></script>

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/materialize/js/materialize.min.js"></script>

<!-- Slider stuff	 -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<style>
body {
	background-color: #F7F7F7;
}

img.logo {
	width: 160px;
	height: 60px;
	padding-top: 0px;
    margin-top: 10px;
}

.login {
	margin-top: 5px;
}

.btn-large {
	height: 30px;
	line-height: 30px;
}

.imageavatar:hover {
	cursor: pointer;
}
</style>

<!-- =================================================================== -->

<fmt:message key="header.error.mailuse" var="fmtMailUse" />

<!-- =================================================================== -->
	<c:choose>
		<c:when test="${user == null}">
			<c:choose> 
			<c:when test="${language == null}">
				<script>
					var currentLanguage = 'en';
					var sor = 'language == null';
				</script>
			</c:when>
			<c:otherwise>
				<script>
					var currentLanguage = '${language}';
					var sor = 'language != null';
				</script>
			</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<script>
				var currentLanguage = '${user.language}';
				var sor = 'user.language';
			</script>
		</c:otherwise>
	</c:choose>
	
<nav class="navbar navbar-default navbar-static-top"
	style="margin-bottom: 0px; background: #12444c;">
	<div class="container-fluid">
		<div class="row" style="margin-bottom: 0;">
			<div class="navbar-header" style="margin-left: 30px; margin-right: 50px;">
				<a href="${pageContext.servletContext.contextPath}/home" class="brand" style="padding-bottom: 0px; padding-top: 0px;">
					<img class="logo" src="${pageContext.servletContext.contextPath}/resources/themes/images/logo.png" alt="Periodicals" />
				</a>
			</div>
			<div class="col s1">
				<div class="col s1" style=" padding-left: 0;">
					<a id="en_button" class="waves-effect waves-light btn" onclick="changeLanguage('en')" 
					style="margin: 20px 10px 0 0;padding: 0;padding-left: 10px;padding-right: 28px;width: 100%;background: #26A69A;color: #F7F7F7;font-family: 'Times NewRoman', Times, serif;">EN</a>
				</div>
				<div class="col s1 offset-s3">
					<a id="ua_button" class="waves-effect waves-light btn" onclick="changeLanguage('ua')" 
					style="margin: 20px 10px 0 0;padding-left: 10px;padding-right: 28px;width: 100%;background: #26A69A;color: #F7F7F7;font-family: 'Times NewRoman', Times, serif;">UA</a>
				</div>
			</div>
			<div id="navbar" class="navbar-header" style="width: 340px; margin-bottom: 0px; float:right">
				<ul class="nav navbar-nav navbar-right" style="padding-top: 5px;">
					<c:choose>
						<c:when test="${user != null}">	
								<div class="dropdown" style="padding-top:0.7rem;">
								<span id="userNameSpan" style="font-size:1.3rem; margin-right:0.5rem; margin-top:20px">${user.firstName} ${user.lastName}</span>
									<img id="imageavatar"
	<%-- 									src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}" --%>
										src="<i:urlToImage url="${user.image}" />"
										alt="img"
										style="height: 50px; width: 50px; border-radius: 25px; margin-top:-0.5rem"
										class="imageavatar dropdown-toggle" data-toggle='dropdown'
										 />
									<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/cart" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_shopping_cart" class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/orders" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_orders" class="fa fa-briefcase" aria-hidden="true"></i></a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/my_feedbacks" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_feedbacks" class="fa fa-comment" aria-hidden="true"></i></a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/settings" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_settings" class="fa fa-cog" aria-hidden="true"></i></a></li>
										
										<c:if test="${user.type == 'MANAGER'}">			
											<li role="presentation" class="divider" style="border-color:lightgrey"></li>						
											<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/my_hotels" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_hotels" class="fa fa-building" aria-hidden="true"></i></a></li>
										</c:if>
										
										<c:if test="${user.type == 'ADMIN'}">			
											<li role="presentation" class="divider" style="border-color:lightgrey"></li>						
											<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/cabinet/admin" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_admin_stuff" class="fa fa-trash" aria-hidden="true"></i></a></li>
										</c:if>
										
										<li role="presentation" class="divider" style="border-color:lightgrey"></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="${pageContext.servletContext.contextPath}/log-out" style="color: #26A69A; font-size:1rem">
											<i id="header_dropdown_log_out" class="fa fa-sign-in" aria-hidden="true"></i></a></li>
									</ul>
								</div>
	<!-- 						</div> -->
	
	
	<!-- 						<li><a href="#" onclick="logout()" data-toggle="modal" -->
	<%-- 							style="padding-right: 10"> <fmt:message key="header.logout" /> --%>
	<!-- 								<i class="fa fa-sign-in" aria-hidden="true"></i></a></li> -->
						</c:when>
						<c:otherwise>
							
	
							<li><a class="modal-trigger" href="#signupModal">
							<span class="header_regist"> </span></a>
								<div id="signupModal" class="modal">
									<div class="modal-header">
										<h4 id="registrationHeader">
											<span class="header_regist"> </span>
										</h4>
									</div>
									<div class="modal-content" style="margin-top: -10px">
										<div class="form-horizontal registrationFrm">
											<div class="input-field">
												<input id="name" type="text" class="validate"> <label
													id="nameLbl" data-error="" for="name">
													<span class="header_regist_name"> </span>
												</label>
											</div>
											<div class="input-field">
												<input id="surname" type="text" class="validate"> <label
													id="surnameLbl" data-error="" for="surname">
													<span class="header_regist_surname"> </span>
												</label>
											</div>
											<div class="input-field">
												<input id="email" type="email" class="validate"> <label
													id="emailLbl" data-error="" for="email">
													<span class="header_regist_mail"> </span>
												</label>
											</div>
											<div class="input-field">
												<input id="password" type="password" class="validate">
												<label id="passwordLbl" data-error=""
													for="password">
													<span class="header_regist_pass"> </span></label>
											</div>
											<div class="input-field">
												<input id="сpassword" type="password" class="validate">
												<label id="сpasswordLbl" data-error=""
													for="сpassword">
													<span class="header_regist_cpass"> </span>
												</label>
											</div>
										</div>
	
	
										<!-- 											<div class="modal-footer"> -->
	
										<div class="row">
											<button id="registrationConfirmButton" type="submit"
												class="btn-flat btn-success login col s2 offset-s1"
												onclick="confirmRegistration(languages.error.current.emailLbl, languages.error.current.mailPasswordLbl, languages.error.current.header_regist_succes, languages.error.current.header_regist_confirmmail, languages.error.current.header_error_fail, languages.error.current.header_regist);"
												style="margin-left: 15px; width: 24%;">
												<span class="header_regist_confirm"> </span>
											</button>
											<button
												class="modal-action modal-close waves-effect waves-red btn-flat col s2 offset-s1"
												data-dismiss="modal" aria-hidden="true"
												style="margin-left: 10px;">
												<span class="header_regist_close"> </span>
											</button>
										</div>
	
										<!-- 											</div> -->
									</div>
								</div></li>
	
							<li><a class="waves-effect waves-white modal-trigger"
								href="#login" role="button" style="padding-right: 0">
									<span class="header_auth"> </span>
								</a>
								<div id="login" class="modal">
									<div class="modal-content">
										<h4>
											<span class="header_auth"> </span>
										</h4>
										<div class="form-horizontal loginFrm">
											<div class="input-field">
												<input id="emailAuth" type="email" class="validate">
												<label id="emailAuthLbl" data-error="${fmtMail}"
													for="emailAuth">
													<span class="header_author_mail"> </span>
												</label>
											</div>
											<div class="input-field">
												<input id="passwordAuth" type="password"> <label
													id="mailPasswordLbl" data-error="${fmtMailPass}"
													for="passwordAuth">
													<span class="header_author_pass"> </span>
												</label>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" id="sbm"
											class="btn-flat btn-success login" onclick="auth()"
											style="margin-left: 15px;">
											<span class="header_auth_enter"> </span>
										</button>
										<button class="btn-flat waves-effect waves-red "
											onclick="forgot()" style="margin-left: 15px;">
											<span class="header_auth_forgot"> </span>
										</button>
										<button
											class="modal-action modal-close waves-effect waves-red btn-flat"
											data-dismiss="modal" aria-hidden="true"
											style="margin-left: 10px;">
											<span id="header_auth_close"> </span>
										</button>
									</div>
								</div></li>
							<li>
							<a href="${pageContext.servletContext.contextPath}/facebookLogin" style="color: #e6e6e6; font-size: 1rem;"><i
											class="fa fa-2x fa-facebook" aria-hidden="true"></i></a>
							</li>
							<li>
							<a href="${pageContext.servletContext.contextPath}/googleLogin" style="color: #e6e6e6; font-size: 1rem;"><i
											class="fa fa-2x fa-google-plus" aria-hidden="true"
											></i></a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</nav>

<script>
	$(document).ready(function() {
		$('#passwordAuth').keypress(function(e) {
			if (e.keyCode == 13)
				$('#sbm').click();
		});
	});
</script>

<script>
	$(document).ready(function() {
		$('#сpassword').keypress(function(e) {
			if (e.keyCode == 13)
				$('#registrationConfirmButton').click();
		});
	});
</script>

<script>
	$('.modal-footer').css("border-top", "0px solid #FAFAFA");
	function logout() {
		$.post('${pageContext.servletContext.contextPath}/logout', function() {
			document.location.href = '/';
		});
	}
</script>
<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
</script>


<script type="text/javascript"
							src="${pageContext.servletContext.contextPath}/resources/js/registration/registration.js"></script>
						<script type="text/javascript"
							src="${pageContext.servletContext.contextPath}/resources/js/authorization/authorization.js"></script>