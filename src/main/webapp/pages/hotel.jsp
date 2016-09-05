
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
<title>${hotel.name}</title>

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
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<!-- GALERY -->

<!-- <link rel="stylesheet" -->
<!-- 	href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css"> -->
<!-- <link rel="stylesheet" href="css/bootstrap-image-gallery.min.css"> -->

<!-- END OFGALERY -->

<!-- <script -->
<!-- 	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->



<!-- IMPORTED -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<!-- END OF IMPORTED -->



<script
	src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>

<link
	href="${pageContext.servletContext.contextPath}/resources/css/styleMap.css"
	rel="stylesheet">

<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU"></script>
<script>
	points = [ {
		"id" : "<c:out value="${hotel.id}"></c:out>",
		"name" : "<c:out value="${hotel.name}"></c:out>",
		"photo" : "${pageContext.servletContext.contextPath}/resources/images/${MainPhoto.img}",
		"address" : "<c:out value="${hotel.city}"></c:out> <c:out value="${hotel.street}"></c:out>",
		"phone" : "225-(254)220-5391",
		"lat" : "<c:out value="${hotel.XCoord}"></c:out>",
		"lon" : "<c:out value="${hotel.YCoord}"></c:out>",
	} ]
</script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/map/showPointsOnMap.js"></script>

<!-- JTable -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function () {
		$j('#example').DataTable();
	});
</script>
<style>
div #sidebar-wrapper {
	position: relative;
	left: 0;
	margin-top: 0px;
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

.well {
	padding: 0px;
}
</style>
</head>

<body>
<!-- 	<div id="blueimp-gallery" class="blueimp-gallery"> -->
		
		
<!-- 		<div class="slides"></div> -->
		

<!-- 		<h3 class="title"></h3> -->
<!-- 		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a> <a -->
<!-- 			class="play-pause"></a> -->
<!-- 		<ol class="indicator"></ol> -->
		

<!-- 		<div class="modal fade"> -->
<!-- 			<div class="modal-dialog"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" aria-hidden="true">&times;</button> -->
<!-- 						<h4 class="modal-title"></h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body next"></div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-default pull-left prev"> -->
<!-- 							<i class="glyphicon glyphicon-chevron-left"></i> Previous -->
<!-- 						</button> -->
<!-- 						<button type="button" class="btn btn-primary next"> -->
<!-- 							Next <i class="glyphicon glyphicon-chevron-right"></i> -->
<!-- 						</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div id="links" style="margin-right: 8.3333333333%;">
			<div class="row">
				<div class="col s4">
					<a href='${pageContext.servletContext.contextPath}/resources/images/photoOfHotels/${hotel.photos[0].img}' title="Banana"
						data-gallery> 
						<img src="${pageContext.servletContext.contextPath}/resources/images/photoOfHotels/${hotel.photos[0].img}" 
							alt="Banana" style="width: 100%; padding-top: 15px;">
					</a>
					<div style="overflow-x: auto;">
						<div style="margin: 10px; white-space: nowrap;">
							<c:forEach items="${hotelPhotos}" var="photo">
								<div style="display: inline-block;">
									<a href='<c:out value="${photo.img }"></c:out>'
										title="<c:out value=" ${photo.img } "></c:out>" data-gallery>
										<img style="height: 60px;"
										src="<c:out value="${photo.img }"></c:out>"
										alt="<c:out value="${photo.img }"></c:out>">
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>

				<div class="col s8">
					<div class="container-fluid">
						<div class="row">
							<div class="col s6">
								<h5>
									<c:out value="${hotel.name }"></c:out>
								</h5>
							</div>
							<div class="col s4 offset-s1" style="margin-top: 15px;">
							<a class="tooltipped" data-position="icon" data-tooltip="Stars"
										style="color: #0d0d0d;">
								<c:forEach var="i" begin="1" end="${hotel.stars}">
									<i class="fa fa-lg fa-star" aria-hidden="true"></i> 
								</c:forEach>
								<c:forEach var="i" begin="${hotel.stars}" end="4">
									<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								</c:forEach>
							</a>
							</div>
						</div>
						<div class="row">
							<a class="tooltipped" data-position="icon" data-tooltip="Location"
								style="color: #0d0d0d;text-decoration: none;"><i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
							<a id="togle" class="tooltipped" data-position="icon" data-tooltip="Show map"
								style="cursor: pointer;">${hotel.city} ${hotel.street}</a>
						</div>

						<div class="row" style="margin-bottom: 5px">
							<a class="tooltipped" data-position="icon" data-tooltip="Description"
								style="color: #0d0d0d; cursor:default"><i class="material-icons invert" style="font-size: 20px;">receipt</i></a>
							 <span>${hotel.desc}</span>
						</div>
						<div class="row" style="height: 10px; margin: 0;">
							<c:if test="${conveniences.wiFi == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Wifi"
									style="color: #0d0d0d;"><i class="material-icons invert">wifi</i></a>
							</c:if>
							<c:if test="${conveniences.shower == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Shower"><img
									class="invert" style="max-width: 5%; margin-top:-1rem"
									src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
							</c:if>
							<c:if test="${conveniences.parking == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Parking" style="color: #0d0d0d;"><i
									class="material-icons invert">local_parking</i></a>
							</c:if>
							<c:if test="${conveniences.condition == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Condition" style="color: #0d0d0d;"><i
									class="material-icons invert">toys</i></a>
							</c:if>
							<c:if test="${conveniences.pool == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Pool"
									style="color: #0d0d0d;"><i class="material-icons invert">pool</i></a>
							</c:if>
							<c:if test="${conveniences.gym == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Gym"
									style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
							</c:if>
							<c:if test="${conveniences.balcony == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Balcony"><img class="invert"
									style="max-width: 230%; height: 230%; margin-top: -18px;"
									src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
							</c:if>
						</div>
					</div>
				</div>
			</div>

			<!--             SEARCH FORM -->

				<div class="row">

					<div class="col s3">
						<input type="date" name="startDate" id="date_from"
							class="datepicker validate"
							value="${startDate}"><label id="startLbl"
							data-error="${fmtStart}" for="date_from"><fmt:message
								key="index.search.start" /></label>
					</div>

					<div class="col s3">
						<input type="date" name="endDate" id="date_to"
							class="datepicker validate"
							value="${endDate}"><label id="endLbl"
							data-error="${fmtEnd}" for="date_to"><fmt:message
								key="index.search.end" /></label>
					</div>

					<div class="col s3">
						<input id="people" type="text" class="validate" name="people"
							value="${people}"> <label id="pplLbl"
							data-error="${fmtPeople}" for="pplCount"><fmt:message
								key="index.search.ppl" /></label>
					</div>

					<div class="col s2 offset-s1">
						<a id="search" class="waves-effect waves-light btn"
							onclick="searchRooms(${hotel.id})"
							style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">SEARCH</a>
					</div>

				</div>

			<!--           END OF SEARCH FORM -->


		</div>
		<div id="togle_place" class="col s12" style="margin-top: 18px;">
			<div id="google_map" style="height: 400px; width: 83%;"></div>
		</div>
	</div>
	<div class="container">
		<div id="switchContent" class="row">
			<jsp:include page="roomCard.jsp"></jsp:include>
		</div>
	</div>
	<div class="container">
		<div id="switchContent" class="row">
			<jsp:include page="commentCard.jsp"></jsp:include>
		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


	<script
		src="${pageContext.servletContext.contextPath}/resources/js/customerSlider.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/hotel/dropDownComments.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>

</body>

</html>
