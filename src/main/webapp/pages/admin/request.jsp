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
	<input id="photos" type="hidden" />
	<input id="lang" type="hidden" value="${language}" />

	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<!-- 					PHOTO -->
				<a href="#!"><img id="Img"
					style="height: 100px; padding: 10px; width: 110px;"
					src="<i:urlToImage url="${userPhoto}" />"> </a>
				<!-- 					END OF PHOTO -->

			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s9">

							<!-- 						NAME -->

							<span id="request_name"></span> : <span>${firstName} </span> <span>
								${lastName}</span>

							<!-- 							END OF NAME -->

						</div>
					</div>

					<div class="row">
						<div class="col s9">

							<!-- 						DATE -->

							<span id="request_date"> : <span>${request.requestDate}
							</span> <!-- 							END OF DATE -->
						</div>
					</div>

					<div class="row">
						<div class="col s9">

							<!-- 						STATUS -->

							<span id="request_status"> : <span>${request.status}
							</span> <!-- 							END OF STATUS -->
						</div>
					</div>


				</div>
			</div>
		</div>


		<div class="row">

			<div class="col s12">

				<!-- 						MESSAGE -->

				<div class="input-field">
					<textarea class="materialize-textarea">${request.message}</textarea>
					<label id="descLbl"><span id="request_message"></span></label>
				</div>

				<!-- 							END OF MESSAGE -->

			</div>
		</div>


		<c:if test="${request.status == 'PENDING'}">
			<div class="row">
				<div class="col s3 offset-s2">
					<a class="waves-effect waves-light btn" id="create_button"
						onclick="chageStatus(${request.id},true,'../../')"
						style="margin-left: 10px; margin-top: 100px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
						id="request_approve">APPROVE</span></a>

				</div>
				<div class="col s3 offset-s2">
					<a class="waves-effect waves-light btn" id="create_button"
						onclick="chageStatus(${request.id},false,'../../')"
						style="margin-left: 10px; margin-top: 100px; background: #F55151; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
						id="request_decline">DECLINE</span></a>

				</div>
			</div>
		</c:if>

	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/request.js"></script>


</body>

</html>
