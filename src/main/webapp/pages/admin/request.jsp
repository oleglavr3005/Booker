<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>Booker | Request №${request.id}</title>

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
			<div class="col s4">
				<!-- 					PHOTO -->
				<img id="Img"
					style="max-height: 200px; padding: 10px; max-width: 260px;"
					src="<i:urlToImage url="${userPhoto}" />">
				<!-- 					END OF PHOTO -->

			</div>


			<div class="col s7" style="margin-top : 15px;">
				<div class="container-fluid">

					<div class="row">
						<div class="col s9" style="margin-tom:20px;">

							<!-- 						NAME -->

							<span id="admin_request_name"></span> : <span>${firstName} </span> <span>
								${lastName}</span>

							<!-- 							END OF NAME -->

						</div>
					</div>

					<div class="row">
						<div class="col s9">

							<!-- 						DATE -->

							<span id="admin_page_reqDate"></span> : <span>${request.requestDate}
							</span> <!-- 							END OF DATE -->
						</div>
					</div>

					<div class="row">
						<div class="col s9">

							<!-- 						STATUS -->

							<span id="admin_request_status"></span> : 
							<c:if test="${request.status == 'APPROVED'}">
								<span class="admin_request_status_approved"></span>
							</c:if>
							<c:if test="${request.status == 'DECLINED'}">
								<span class="admin_request_status_declined"></span>
							</c:if>
							<c:if test="${request.status == 'PENDING'}">
								<span class="admin_request_status_pending"></span>
							</c:if>
						
							 <!-- 							END OF STATUS -->
						</div>
					</div>


				</div>
			</div>
		</div>


		<div class="row">

			<div class="col s12">

				<!-- 						MESSAGE -->
				<div style="min-height:150px; font-size: 15px; padding: 10px; 	border: solid 1px #000; border-radius: 10px; background-color: lightgray;">${request.message}</div>

				<!-- 							END OF MESSAGE -->

			</div>
		</div>


		<c:if test="${request.status == 'PENDING'}">
			<div id="btn_row" class="row">
				<div class="col s3 offset-s2">
					<a class="waves-effect waves-light btn" id="create_button"
						onclick="chageStatus(${request.id},true,'../../')"
						style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
						<span id="request_approve"></span></a>

				</div>
				<div class="col s3 offset-s2">
					<a class="waves-effect waves-light btn" id="create_button"
						onclick="chageStatus(${request.id},false,'../../')"
						style="margin-left: 10px; margin-top: 10px; background: #F55151; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
						<span id="request_decline"></span></a>

				</div>
			</div>
		</c:if>
		
		<c:if test="${request.status != 'PENDING'}"><div style="height: 70px"></div></c:if>

	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/request.js"></script>

	<script type="text/javascript">
	$(document).ready(function() {
		document.title = languages.script.current.title.request +  ' №' + '${request.id}';
	});
	</script>

</body>

</html>
