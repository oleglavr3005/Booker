
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
<title>HOTEL LIST</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/styleMap.css"
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
	href="${pageContext.servletContext.contextPath}/resources/css/star-rating/star-rating.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">


<!-- GALERY -->
<!-- Add local libraries for gallery -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/font-awesome.min.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/jquery-ui.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/nouislider.min.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.css">
<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/jquery.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/jquery.blueimp-gallery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>




<style>
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

.well {
	padding: 0px;
}
</style>
</head>

<body>

	<input id="lang" type="hidden" value="${language}" />

	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<!-- 					PHOTO -->
				<a href="#!"><img id="avatarImg"
					style="height: 100px; padding: 10px; width: 110px;"
					<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="new_hotel.jpg" />">
				</a>
				<!-- 					END OF PHOTO -->
				<!-- 				INPUT -->
				<%-- 				<input style="margin-top: 60px" type="file" id="avatarInput" --%>
				<%-- 					onchange="showPhoto()" accept="image/*" /> --%>
				<!-- 				END OF INPUT -->

				<a class="waves-effect waves-light btn" id="create_button" onclick="createHotel()"
					style="margin-left: 10px; margin-top: 100px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>CREATE</span></a>
<p id="create_error" style="color: red"></p>



			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s6">

							<!-- 						NAME -->

							<div class="input-field">
								<input id="name" type="text" class="validate" length="45"
									placeholder="Name of Hotel"> <label id="nameLbl"
									data-error="${fmtName}" for="name"><fmt:message
										key="admin.edit.name" /></label>
							</div>

							<!-- 							END OF NAME -->

						</div>
					</div>

					<div class="row">
						<div class="col s7">

							<!-- 						STARS -->
							<input id="rating" onchange="rate()" value="0" type="number"
								class="rating" min=0 max=5 step=1 data-size="xs" data-stars="5">
							<span
								style="margin-left: 25px; margin-top: 20px; padding-top: 20px;"><fmt:message
									key="manager.hotel.star" />STAR : <span id="rate_span">0</span>
								/ 5 |</span>
							<script>
								function rate() {

									var count = document
											.getElementById("rate_span");
									count.innerHTML = $('#rating').val();

								}
							</script>

							<!-- 							END OF STARS -->

						</div>
					</div>

					<div class="row">

						<div class="col s4">

							<!-- 						CITY -->

							<div class="input-field">
								<input id="city" type="text" class="validate" length="45"
									placeholder="Name of city"> <label id="cityLbl"
									data-error="${fmtName}" for="city"><fmt:message
										key="admin.edit.city" /></label>
							</div>

							<!-- 							END OF CITY -->

						</div>

						<div class="col s4">

							<!-- 						STREET -->

							<div class="input-field">
								<input id="street" type="text" class="validate" length="45"
									placeholder="Name of street"> <label id="streetLbl"
									data-error="${fmtName}" for="street"><fmt:message
										key="admin.edit.street" /></label>
							</div>

							<!-- 							END OF STREET -->

						</div>


						<div class="col s4">

							<!-- 						PHONE -->

							<div class="input-field">
								<input id="phone" type="text" class="validate" length="45"
									placeholder="Name of phone"> <label id="phoneLbl"
									data-error="${fmtName}" for="phone"><fmt:message
										key="admin.edit.phone" /></label>
							</div>

							<!-- 							END OF PHONE -->

						</div>




					</div>

					<div class="row">

						<div class="col s12">

							<!-- 						DESC -->

							<div class="input-field">
								<textarea placeholder="Desc" id="desc"
									class="materialize-textarea" class="validate" length="999">${message}</textarea>
								<label id="descLbl" data-error="${fmtName}" for="desc"><fmt:message
										key="admin.edit.desc" /></label>
							</div>

							<!-- 							END OF DESC -->

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>

</body>

</html>
