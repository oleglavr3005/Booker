<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>Booker | My hotels</title>

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


<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery-3.1.0.min.js"></script>


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

	<div class="container" style="min-height: 340px;">
		<div class="row">
			<div class="col s10 offset-s1">
				<a class="waves-effect waves-light btn" id="create_button"
					href="${pageContext.servletContext.contextPath}/cabinet/create_hotel" 
					style="margin-left: 10px; width:100%; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
					<span id=btn_create_hotel></span>
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col s3">
				<h6>
					<c:if test="${countOfHotels > 0 }">
						<span id="my_hotels_header"></span>
						<span id="periodicals_number_for_all_users">${countOfHotels}</span>
					</c:if>
				</h6>
			</div>
			<div class="col s5 offset-s4" style="text-align: right;">
				<c:if test="${countOfHotels > 0 }">
					<span class="sort_by" style="font-size: 15; position: relative; /* display: inline-block; */ bottom: 3px;"></span>
					<select id="compare" class="chosen-select optionstyle"
						onchange="findPage(window.location.href,1)">
						<option class="optionstyle index_option_star_asc"
							value="compareByStarsAsc"></option>
						<option class="optionstyle index_option_star_desc"
							value="compareByStarsDesc"></option>
						<option class="optionstyle index_option_rating_asc"
							value="compareByRatingAsc"></option>
						<option class="optionstyle index_option_rating_desc"
							value="compareByRatingDesc" selected="selected"></option>
					</select>
				</c:if>
			</div>
		</div>

		<!-- SWITCH CONTENT -->
		<div id="switchContent" class="row">
			<jsp:include page="../cards/managerHotelCard.jsp"></jsp:include>
		</div>
		<!-- END OF SWITCH CONTENT -->

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
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/image.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?language=en&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU&libraries=places&callback=initAutocomplete"
		async defer></script>
	<script>
		$('#rating').rating('update', 1);
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		document.title = languages.script.current.title.my_hotels;
	});
	</script>
</body>

</html>
