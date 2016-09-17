
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>HOTEL CREATE</title>

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

.invert:hover {
	-webkit-filter: invert(70%);
	filter: invert(70%);
	cursor: default;
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
				<div class="row">
					<!-- 					PHOTO -->
					<a href="#!"><img id="Img"
						style="height: 200px; padding: 10px; width: 200px;"
						src="<i:urlToImage url="new_hotel.png" />"> </a>
					<!-- 					END OF PHOTO -->
					<!-- 				INPUT -->
					<input multiple style="margin-top: 60px; display: none" type="file"
						id="imgInput" onchange="uploadHotel('')" accept="image/*" />
					<!-- 				END OF INPUT -->
				</div>
				<div class="row">
					<p style="margin-top: 20px;">
						<input type="checkbox" class="filled-in" id="sendNotif"
							name="sendNotif" /> <label for="sendNotif"> <span
							id=lbl_sendnotif>SEND NOTIF</span></label>
					</p>
				</div>
			</div>

			<div class="col s9">

				<div class="row">
					<div class="col s5 offset-s1">
						<!-- 						NAME -->
						<div class="input-field">
							<input id="name" type="text" class="validate" length="45"
								onkeyup="setHotelName()"> <label id="nameLbl"
								data-error="NAME INVALID" for="name"><span
								id="admin_edit_name"></span></label>
						</div>
						<!-- 							END OF NAME -->
					</div>
					<div class="col s5 offset-s1">
						<!-- 						STARS -->
						<input id="rating" type="number" class="rating" min=1 max=5 step=1
							data-size="xs" data-stars="5" onchange="setHotelStars()">
						<label id="ratingLbl" data-error="STARS SHOULD BE 1-5"
							for="rating"><span id="admin_edit_stars"></span> </label>
						<!-- 							END OF STARS -->
					</div>
				</div>

				<div class="row">
					<div class="col s7 offset-s1">
						<!-- 						ADDRESS -->
						<div class="input-field">
							<input id="address" type="text" class="validate" length="145"
								onkeyup="setHotelLocation()" placeholder=""> <label
								id="addressLbl" data-error="ADDRESS IS INVALID" for="address"><span
								id="admin_edit_address"></span> </label>
						</div>
						<!-- 						END OF ADDRESS -->
					</div>
					<div class="col s3 offset-s1">
						<!-- 						PHONE -->
						<div class="input-field">
							<input id="phone" type="text" class="validate" length="20"
								onkeyup="setHotelPhone()" placeholder=""> <label
								id="phoneLbl" data-error="PHONE NUMBER IS INVALID" for="phone"><span
								id="admin_edit_phone"></span></label>
						</div>
						<!-- 							END OF PHONE -->
					</div>
				</div>


				<div class="row">
					<div class="col s3 offset-s1">
						<!-- 								CHECKBOX -->
						<p>
							<input onclick="setHotelCon(1,'hasParking')" type="checkbox" class="filled-in" id="hasParking"
								name="hasParking" /> <label id="label_parking" for="hasParking">PARKING</label>
						</p>
						<p>
							<input onclick="setHotelCon(2,'hasPool')" type="checkbox" class="filled-in" id="hasPool"
								name="hasPool" /> <label id="label_pool" for="hasPool">SWIM
								POOL</label>
						</p>
					</div>
					<div class="col s4">
						<p>
							<input onclick="setHotelCon(3,'hasGym')" type="checkbox" class="filled-in" id="hasGym"
								name="hasGym" /> <label id="label_gym" for="hasGym">FIT
								GYM</label>
						</p>
						<p>
							<input onclick="setHotelCon(4,'hasSpa')" type="checkbox" class="filled-in" id="hasSpa"
								name="hasSpa" /> <label id="label_spa" for="hasSpa">SPA
							</label>
						</p>
					</div>
					<div class="col s4">
						<p>
							<input onclick="setHotelCon(5,'hasService')" type="checkbox" class="filled-in" id="hasService"
								name="hasService" /> <label id="label_service" for="hasService">SERVICE</label>
						</p>
						<p>
							<input onclick="setHotelCon(6,'hasCleaner')" type="checkbox" class="filled-in" id="hasCleaner"
								name="hasCleaner" /> <label id="label_cleaner" for="hasCleaner">CLEANER</label>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- 						DESC -->

			<div class="input-field">
				<textarea placeholder=""
					style="padding-bottom: 10px; padding-top: 10px; padding-left: 15px;"
					onkeyup="setHotelDesc()" id="desc" class="materialize-textarea"
					class="validate">${message}</textarea>
				<label id="descLbl" data-error="DESCRIPTION IS INVALID" for="desc"><span
					id="admin_edit_desc"></span> </label>
			</div>

			<!-- 							END OF DESC -->
		</div>


		<div class="row">
			<!-- 							SEND NOTIF -->
			<div class="col s12">
				<a class="waves-effect waves-light btn" id="create_button"
					onclick="createHotel()"
					style="margin-left: 10px; margin-top: 10px; width: 98%; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
					<span id=btn_create>CREATE</span>
				</a>
				<p id="create_error" style="color: red"></p>
			</div>
		</div>

		<div class="row">
			<div class="card">
				<div class="container-fluid">
					<div class="row" style="margin-top: 15px; margin-bottom: 10px;">
						<div class="card-image col s4" style="position: relative;">
							<div>
								<img id="ImgCard"
									style="height: 180px; width: 230px; padding: 10px;"
									src="<i:urlToImage url="new_hotel.png" />">
							</div>

						</div>

						<div class="col s7">

							<div class="row"
								style="margin-top: 15px; margin-bottom: 10px; font-size: 1.3rem; padding-left: 0;">
								<div class="container-fluid" style="padding: 0px">
									<div class="row" style="margin-bottom: 0px;">
										<div class="col s6">
											<span id="hotel_card_name"></span>
										</div>
										<div class="col s3">
											<a class="tooltipped index_search_stars" data-position="icon"
												data-tooltip=""
												style="color: #0d0d0d; text-decoration: none;"> <i
												id="card_star_1" class="fa fa fa-star-o" aria-hidden="true"></i>
												<i id="card_star_2" class="fa fa fa-star-o"
												aria-hidden="true"></i> <i id="card_star_3"
												class="fa fa fa-star-o" aria-hidden="true"></i> <i
												id="card_star_4" class="fa fa fa-star-o" aria-hidden="true"></i>
												<i id="card_star_5" class="fa fa fa-star-o"
												aria-hidden="true"></i>
											</a>
										</div>
										<div class="col s3">
											<div class="row" style="margin: 0px">
												<a class="tooltipped tooltip_rating" data-position="icon"
													data-tooltip="Rating"
													style="padding: 0 20px 0 20px; margin-left: 30px;font-size: 15px; color: #0d0d0d; text-decoration: none;">
													<i class="fa fa-lg fa-thumbs-up invert" aria-hidden="true"></i>
													<span>5.0</span>
												</a>
											</div>
						
<!-- 											<div class="row" style="margin-top: 14px; float:right"> -->
<!-- 													############ --> 

<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>


							<div class="row" style="margin-bottom: 10px;">
								<div style="padding:0px" class="col s6"><a class="tooltipped index_search_location" data-position="icon"
									data-tooltip="" style="color: #0d0d0d; text-decoration: none;"><i
									class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
								<span id="hotel_card_location"></span></div>
								<div class="col s4 offset-s2">
									<a id="index_room_parking" class="tooltipped" data-position="icon"
														data-tooltip="Parking" style="color: #0d0d0d; float:right"><i id="con1"
														class="material-icons invert" style="display:none; font-size:1.3rem">local_parking</i></a>

													<a id="index_room_pool" class="tooltipped" data-position="icon"
														data-tooltip="Pool" style="color: #0d0d0d; float:right"><i id="con2"
														class="material-icons invert" style="display:none; font-size:1.3rem">pool</i></a>

													<a id="index_room_gym" class="tooltipped" data-position="icon"
														data-tooltip="Gym" style="color: #0d0d0d; float:right"><i id="con3"
														class="material-icons invert" style="display:none; font-size:1.3rem">fitness_center</i></a>

													<a id="index_room_spa" class="tooltipped" data-position="icon"
														data-tooltip="Spa" style="color: #0d0d0d; float:right"><i id="con4"
														class="material-icons invert" style="display:none; font-size:1.3rem">spa</i></a>

													<a id="index_room_service" class="tooltipped" data-position="icon"
														data-tooltip="Room service" style="color: #0d0d0d; float:right"><i id="con5"
														class="material-icons invert" style="display:none; font-size:1.3rem">room_service</i></a>

													<a id="index_room_cleaner" class="tooltipped"
														data-position="icon" data-tooltip="Dry cleaner"><img
														class="invert" id="con6"
														style="display:none; max-width: 17%; max-height: 17%; float:right"
														src="${pageContext.servletContext.contextPath}/resources/images/cleaner.png" /></a>
								</div>
							</div>

							<div class="row" style="margin-bottom: 10px">
								<a class="tooltipped tooltip_phone_number" data-position="icon"
									data-tooltip=""
									style="color: #0d0d0d; margin-left: -2px; text-decoration: none;"><i
									class="fa fa-lg fa-phone-square invert" aria-hidden="true"></i></a>
								<span id="hotel_card_phoneNumber"></span>
							</div>

							<div class="row" style="margin-bottom: 5px">
								<div class="col s1" style="padding: 0px; margin-right: -25px;">
									<a class="tooltipped index_search_description"
										data-position="icon" data-tooltip=""
										style="color: #0d0d0d; margin-left: -4px; cursor: default"><i
										class="material-icons invert" style="font-size: 20px;">receipt</i></a>
								</div>
								<div class="col s10" style="display: inline-block"
									id="hotel_card_desc"></div>
								<%-- 								<span id="hotelInfo${hotel.id}">${hotel.desc.substring(0, hotel.desc.length() < 150 ? hotel.desc.length() : 150)}</span> --%>
								<%-- 								<a onclick="changeInfo(${hotel.id})" style="cursor: pointer" --%>
								<!-- 									class="tooltipped tooltip_showe_all_info" data-position="icon" -->
								<%-- 									data-tooltip="" id="dots${hotel.id}">...</a> <input --%>
								<%-- 									id="infoOpened${hotel.id}" type="hidden" value="false" /> <input --%>
								<%-- 									id="fullInfo${hotel.id}" type="hidden" value="${hotel.desc}" /> --%>
								<%-- 								<input id="shortInfo${hotel.id}" type="hidden" --%>
								<%-- 									value="${hotel.desc.substring(0, hotel.desc.length() < 150 ? hotel.desc.length() : 150)}" /> --%>
							</div>
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
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/image.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?language=en&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU&libraries=places&callback=initAutocomplete"
		async defer></script>
	<script>
		init();
	</script>
</body>

</html>
