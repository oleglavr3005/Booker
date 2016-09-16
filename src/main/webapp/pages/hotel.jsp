
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">
<!--  <link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->


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
<!--   
not add 
<link rel="stylesheet" 
  href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
add 
<link 
  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" 
  rel="stylesheet"> 
 
<link rel="stylesheet" 
  href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css"> 
 
<link 
  href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css" 
  rel="stylesheet"> 
 
<link rel="stylesheet" 
  href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css"> 
<link rel="stylesheet" href="css/bootstrap-image-gallery.min.css"> 
<script 
  src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script 
  src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script> 
 
 
-->
<!-- <link rel="stylesheet" -->
<!-- 	href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css"> -->
<!-- <link rel="stylesheet" href="css/bootstrap-image-gallery.min.css"> -->

<!-- END OFGALERY -->

<!-- <script -->
<!-- 	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->



<!-- IMPORTED -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<!-- END OF IMPORTED -->




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

	<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
	<div id="blueimp-gallery" class="blueimp-gallery">
		<!-- The container for the modal slides -->
		<div class="slides"></div>
		<!-- Controls for the borderless lightbox -->
		<h3 class="title"></h3>
		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a> <a
			class="play-pause"></a>
		<ol class="indicator"></ol>
		<!-- The modal dialog, which will be used to wrap the lightbox content -->
		<div class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" aria-hidden="true">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body next"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left prev">
							<i class="glyphicon glyphicon-chevron-left"></i> <span
								id="hotel_button_previous"><span>
						</button>
						<button type="button" class="btn btn-primary next">
							<span id="hotel_button_next"><span> <i
									class="glyphicon glyphicon-chevron-right"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input id="lang" type="hidden" value="${language}" />
	<input id="pageNmb" type="hidden"
		value="1" />
	


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px; margin-bottom: 50px">

		<div id="links">
			<div class="row">
				<div class="col s4">
					<c:if test="${fn:length(hotel.photos) == 0}">
						<a href="<i:urlToImage url="no.jpg" />" title="No image"
							data-gallery> <img src="<i:urlToImage url="no.jpg" />"
							alt="No image">
						</a>
					</c:if>
					<c:if test="${fn:length(hotel.photos) != 0}">
						<a href='<i:urlToImage url="${hotel.photos[0].img}" />'
							data-gallery> <img
							src="<i:urlToImage url="${hotel.photos[0].img }" />">
						</a>


						<div style="overflow-x: auto;">
							<div style="margin: 10px; white-space: nowrap;">
								<c:forEach items="${hotel.photos}" var="photo" begin="1">
									<div style="display: inline-block;">
										<a href='<i:urlToImage url="${photo.img}" />' data-gallery>
											<img style="height: 60px;"
											src="<i:urlToImage url="${photo.img}" />"
											alt="<c:out value="${photo.id }"></c:out>">
										</a>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</div>


				<div class="col s8">
					<div class="container-fluid">
						<div class="row">
							<div class="col s6">
								<h5>
									<c:out value="${hotel.name }"></c:out>
								</h5>
							</div>
							<div class="col s3" style="margin-top: 15px;">
								<a id="index_search_stars" class="tooltipped"
									data-position="icon" data-tooltip="" style="color: #0d0d0d;">
									<c:forEach var="i" begin="1" end="${hotel.stars}">
										<i class="fa fa-lg fa-star" aria-hidden="true"></i>
									</c:forEach> <c:forEach var="i" begin="${hotel.stars}" end="4">
										<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</a>
							</div>
							<div class="col s2 offset-s1" style="margin-top: 15px;">
								<a class="tooltipped tooltip_rating" data-position="icon" data-tooltip="Rating"
									style="margin-left: 50px; color: #0d0d0d; text-decoration: none;">
									<i class="fa fa-lg fa-thumbs-up invert" aria-hidden="true"></i>
									<span>${hotel.rating }</span>
								</a>
							</div>
						</div>
						<div class="row">
							<a id="index_search_location" class="tooltipped"
								data-position="icon" data-tooltip=""
								style="color: #0d0d0d; text-decoration: none;"><i
								class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
							<a id="hotel_map_button" class="tooltipped" data-position="icon"
								data-tooltip="Show map" style="cursor: pointer;">${hotel.location}</a>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<a class="tooltipped tooltip_phone_number" data-position="icon"
								data-tooltip="" style="color: #0d0d0d; margin-left: -2px; text-decoration: none;"><i
								class="fa fa-lg fa-phone-square invert" aria-hidden="true"></i></a>
							<span>${hotel.phoneNumber}</span>
						</div>
						<div class="row" style="margin-bottom: 5px">
							<a id="index_search_description" class="tooltipped"
								data-position="icon" data-tooltip=""
								style="color: #0d0d0d; cursor: default; margin-left: -4px;"><i
								class="material-icons invert" style="font-size: 20px;">receipt</i></a>
							<span>${hotel.desc}</span>
						</div>
						<div class="row" style="height: 10px; margin-left: -12;">
							<c:if test="${hotel.parking == true}">
								<a id="index_room_parking" class="tooltipped" data-position="icon"
									data-tooltip="Parking" style="color: #0d0d0d;"><i
									class="material-icons invert">local_parking</i></a>
							</c:if>
							<c:if test="${hotel.pool == true}">
								<a id="index_room_pool" class="tooltipped" data-position="icon"
									data-tooltip="Pool" style="color: #0d0d0d;"><i
									class="material-icons invert">pool</i></a>
							</c:if>
							<c:if test="${hotel.gym == true}">
								<a id="index_room_gym" class="tooltipped" data-position="icon"
									data-tooltip="Gym" style="color: #0d0d0d;"><i
									class="material-icons invert">fitness_center</i></a>
							</c:if>
							<c:if test="${hotel.spa == true}">
								<a id="index_room_spa" class="tooltipped" data-position="icon"
									data-tooltip="Spa" style="color: #0d0d0d;"><i
									class="material-icons invert">spa</i></a>
							</c:if>
							<c:if test="${hotel.service == true}">
								<a id="index_room_service" class="tooltipped" data-position="icon"
									data-tooltip="Room service" style="color: #0d0d0d;"><i
									class="material-icons invert">room_service</i></a>
							</c:if>
							<c:if test="${hotel.cleaner == true}">
								<a id="index_room_cleaner" class="tooltipped"
									data-position="icon" data-tooltip="Dry cleaner"><img
									class="invert"
									style="max-width: 230%; height: 230%; margin-top: -18px;"
									src="${pageContext.servletContext.contextPath}/resources/images/cleaner.png" /></a>
							</c:if>
						</div>
					</div>
				</div>
			</div>

			<!--             SEARCH FORM -->

			<div class="row">

				<div class="col s3">						
						<input type="date" name="startDate" id="date_from"
						class="datepicker validate" onchange="onDate()"  style="cursor: default;"
						value="${startDate}"><label id="startLbl"
						data-error="${fmtStart}" for="date_from"><span
				    id="index_search_start"></span></label>						
				</div>

				<div class="col s3">
					<input type="date" name="endDate" id="date_to"
						class="datepicker validate" style="cursor: default;"
						value="${endDate}"><label id="endLbl"
						data-error="${fmtEnd}" for="date_to"><span
				    id="index_search_end"></span></label>
				</div>

				<div class="col s3">
					<input id="people" type="text" class="validate" name="people"
						value="${people}"> <label id="pplLbl" data-error=""
						for="pplCount"><span id="index_search_ppl"></span></label>
				</div>

				<div class="col s2 offset-s1">
					<a id="search" class="waves-effect waves-light btn"
						onclick="searchRooms(${hotel.id})"
						style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
						id="index_search_button"></span></a>
				</div>

			</div>
			<!--           END OF SEARCH FORM -->

		</div>
		<!-- MAP ========================================================================== -->
		<jsp:include page="map.jsp"></jsp:include>
		<!-- MAP End======================================================================= -->
	</div>
	<div class="container">
		<div class="row">
			<div class="col s4 offset-s1">
				<h6>
					<c:if test="${countOfRooms > 0 }">
						<span id="hotel_count_room"></span>
						<span id="periodicals_number_for_all_users">${countOfRooms}</span>
					</c:if>
					<c:if test="${countOfRooms <= 0 }">
						<span id="card_no_hotels"></span>
					</c:if>
				</h6>
			</div>
			<div class="col s5 offset-s2">
				<c:if test="${countOfRooms > 0 }">
					<span id="sort_by" style="font-size: 15;position: relative;/* display: inline-block; */bottom: 3px;"></span>
					<select id="compare" class="chosen-select optionstyle"
						onchange="findPage(window.location.href,1)"><span
						id="hotel_price"></span>
						<option id="hotel_option_star_asc" class="optionstyle"
							value="compareByPriceAsc"></option>
						<option id="hotel_option_star_desc" class="optionstyle"
							value="compareByPriceDesc"></option>
						<option id="hotel_option_people_asc" class="optionstyle"
							value="compareByPeopleAsc"></option>
						<option id="hotel_option_people_desc" class="optionstyle"
							value="compareByPeopleDesc" selected="selected"></option>
					</select>
				</c:if>
			</div>
		</div>
	</div>

	<div class="container">
		<div id="switchContent" class="row" style="margin-bottom: 0;">
			<jsp:include page="roomCard.jsp"></jsp:include>
		</div>
	</div>
	<div class="container">
		<div id="switchContent" class="row">
			<jsp:include page="comments/commentCard.jsp"></jsp:include>
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
		
			<!-- 	DATEPICKER -->
		<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/picker.js"></script>
		<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/picker.date.js"></script>
		<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/datepicker.js"></script>
</body>
</html>
