<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>

<meta charset="utf-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>${hotel.name}</title>

<link
	href="${pageContext.servletContext.contextPath}/resources/css/rangeSlider/rangeStyle.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/star-rating/star-rating.css"
	rel="stylesheet">

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
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/table.css">


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
	/*   background: */
	/*     url('http://3.bp.blogspot.com/-UXVFcPTKwrk/VC9-GaPAooI/AAAAAAAAFfo/g_uYO8A1PCo/s1600/black%2Bgrey%2Bgradient%2Bbackground%2Bfor%2Bweb.jpg') */
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
	<input id="photos" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />
	<input id="lang" type="hidden" value="${language}" />
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />


	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<!-- 	TEMP BUTTON FOR STATISTIC -->
	<a class="waves-effect waves-light btn" id="create_button"
		href="${pageContext.servletContext.contextPath}/cabinet/hotel_orders/${hotel.id}"
		style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
		id=btn_update></span></a>
	<!-- 	END OF TEMP BUTTON FOR STATISTIC -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<div class="row">
					<!-- 					PHOTO -->

					<img id="Img" style="height: 200px; padding: 10px; width: 200px;"
						<%-- 														src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
 								src="<i:urlToImage url="${hotel.photos[0].img }" />">
					<!-- 					END OF PHOTO -->
				</div>

				<div class="row">
					<p>
						<input type="checkbox" class="filled-in" id="isDeleted"
							onclick="changeIsDeleted()" name="isDeleted" /> <label
							for="isDeleted"><span id="admin_deleted"></span></label>
					</p>

				</div>


			</div>

			<div class="col s9">

				<div class="row">
					<div class="col s5 offset-s1">
						<!-- 						NAME -->
						<div class="input-field">
							<input id="name" type="text" class="validate" length="45"
								value="${hotel.name}"> <label id="nameLbl"
								data-error="NAME INVALID" for="name"><span
								id="admin_edit_name"></span></label>
						</div>
						<!-- 							END OF NAME -->
					</div>
					<div class="col s5 offset-s1">
						<!-- 						STARS -->
						<input id="rating" value="${hotel.stars}" type="number"
							class="rating" min=1 max=5 step=1 data-size="xs" data-stars="5">
						<label id="ratingLbl" data-error="RATING SHOULD BE 1-5"
							for="rating"><span id="admin_edit_stars"></span> </label>

						<!-- 							END OF STARS -->
					</div>
				</div>

				<div class="row">
					<div class="col s7 offset-s1">
						<!-- 						ADDRESS -->
						<div class="input-field">
							<input id="address" type="text" class="validate" length="145"
								value="${hotel.location}"> <label id="addressLbl"
								data-error="ADDRESS IS INVALID" for="address"><span
								id="admin_edit_address"></span> </label>
						</div>
						<!-- 						END OF ADDRESS -->
					</div>
					<div class="col s3 offset-s1">
						<!-- 						PHONE -->
						<div class="input-field">
							<input id="phone" type="text" class="validate" length="20"
								value="${hotel.phoneNumber}"> <label id="phoneLbl"
								data-error="PHONE NUMBER IS INVALID" for="phone"><span
								id="admin_edit_phone"></span></label>
						</div>
						<!-- 							END OF PHONE -->
					</div>
				</div>


				<div class="row">
					<div class="col s3 offset-s1">
						<!-- 								CHECKBOX -->
						<p>
							<input type="checkbox" class="filled-in" id="hasParking"
								name="hasParking" /> <label id="label_parking" for="hasParking">PARKING</label>
						</p>
						<p>
							<input type="checkbox" class="filled-in" id="hasPool"
								name="hasPool" /> <label id="label_pool" for="hasPool">SWIM
								POOL</label>
						</p>
					</div>
					<div class="col s4">
						<p>
							<input type="checkbox" class="filled-in" id="hasGym"
								name="hasGym" /> <label id="label_gym" for="hasGym">FIT
								GYM</label>
						</p>
						<p>
							<input type="checkbox" class="filled-in" id="hasSpa"
								name="hasSpa" /> <label id="label_spa" for="hasSpa">SPA
							</label>
						</p>
					</div>
					<div class="col s4">
						<p>
							<input type="checkbox" class="filled-in" id="hasService"
								name="hasService" /> <label id="label_service" for="hasService">SERVICE</label>
						</p>
						<p>
							<input type="checkbox" class="filled-in" id="hasCleaner"
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
					id="desc" class="materialize-textarea" class="validate"
					length="999">${hotel.desc}</textarea>
				<label id="descLbl" data-error="${fmtName}" for="desc"><span
					id="admin_edit_desc"></span></label>
			</div>
			<!-- 							END OF DESC -->
		</div>

		<div class="row">
			<!-- 							SEND NOTIF -->
			<div class="col s12">
				<a class="waves-effect waves-light btn" id="create_button"
					onclick="updateHotel(${hotel.id})"
					style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span
					id=btn_update></span></a>
				<p id="create_error" style="color: red"></p>
			</div>
		</div>

		<!-- CREATE BUTTON -->


	</div>



	<div class="container">
		<div class="row">


			<div class="col s10 offset-s1">
				<div id="switchContent">
					<jsp:include page="../cards/hotelPhotoCard.jsp"></jsp:include>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col s3 offset-s1">

				<a id="pushImage" class="waves-effect waves-light btn"
					style="background: #26A69A; color: #FFFFFF; margin: 0 auto;"
					onclick="pushInput()"><span id="btn_add_image"></span> </a>

				<!-- 				INPUT -->
				<input multiple style="margin-top: 60px; display: none" type="file"
					id="imgInput" onchange="updateHotelPhotos(${hotel.id})"
					accept="image/*" />
				<!-- 				END OF INPUT -->

			</div>

			<div class="col s3 offset-s1">
				<a id="btnToMain" class="waves-effect waves-light btn"
					style="background: #e68a00;; color: #FFFFFF; margin: 0 auto;"
					onclick="promoteToMain()"><span id="btn_main"></span>MAIN </a>
			</div>

			<div class="col s3 offset-s1">
				<a class="waves-effect waves-light btn"
					style="background: #F55151; color: #FFFFFF; margin: 0 auto;"
					onclick="removeHotelPhoto()"><span id="btn_remove"></span> </a>
			</div>
		</div>


	</div>

	<div class="container-fluid">
		<div class="row">
			<div id="admin" class="col s12">
				<div class="card material-table">
					<div class="table-header">
						<span class="table-title" id="room_header"></span>
						<div class="actions">
							<a id="createBtn"
								href="${pageContext.servletContext.contextPath}/cabinet/create_room?hotelId=${hotel.id}"
								class="my-btn waves-effect waves-light btn"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
								<span class="btn_create_room"></span>
							</a>
							<button class="search-toggle waves-effect btn-flat nopadding"
								style="margin-left: 10px;">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>
					<table id="datatable">
						<thead>
							<tr>
								<th>#</th>
								<th><span id="room_type"></span></th>
								<th><span id="room_capacity"></span></th>
								<th><span id="room_conv"></span></th>
								<th><span id="room_food"></span></th>
								<th><span id="room_free"></span></th>
								<th><span id="room_deleted"></span></th>
								<th><span id="room_price"></span></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="room" items="${rooms}">
								<tr>
									<td><a
										href="${pageContext.servletContext.contextPath}/cabinet/room/${room.id}"><c:out
												value="${room.number }"></c:out></a></td>
									<td><c:out value="${room.type }"></c:out></td>
									<td>${room.doubleBedsCount * 2 + room.bedsCount}</td>
									<td><c:if test="${room.wifi == true}">
											<a class="tooltipped index_room_wifi" data-position="icon"
												data-tooltip="Wifi" style="color: #0d0d0d;"><i
												class="material-icons invert">wifi</i></a>
										</c:if> <c:if test="${room.shower == true}">
											<a class="tooltipped index_room_shower" data-position="icon"
												data-tooltip="Shower"><img class="invert"
												style="width: 18px; margin-top: -0.8em;"
												src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
										</c:if> <c:if test="${room.parking == true}">
											<a class="tooltipped index_room_parking" data-position="icon"
												data-tooltip="Parking" style="color: #0d0d0d;"><i
												class="material-icons invert">local_parking</i></a>
										</c:if> <c:if test="${room.condition == true}">
											<a class="tooltipped index_room_conditioner"
												data-position="icon" data-tooltip="Condition"
												style="color: #0d0d0d;"><i class="material-icons invert">toys</i></a>
										</c:if> <c:if test="${room.pool == true}">
											<a class="tooltipped index_room_pool" data-position="icon"
												data-tooltip="Pool" style="color: #0d0d0d;"><i
												class="material-icons invert">pool</i></a>
										</c:if> <c:if test="${room.gym == true}">
											<a class="tooltipped index_room_gym" data-position="icon"
												data-tooltip="Gym" style="color: #0d0d0d;"><i
												class="material-icons invert">fitness_center</i></a>
										</c:if> <c:if test="${room.balcony == true}">
											<a class="tooltipped index_room_balcony" data-position="icon"
												data-tooltip="Balcony"><img class="invert"
												style="width: 18px; margin-top: -0.8em;"
												src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
										</c:if></td>
									<td><a class="tooltipped tooltip_food"
										data-position="icon" data-tooltip="Food"
										style="color: #0d0d0d;"><i
											class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${room.food}</span></td>
									<td><c:if test="${room.daysCount >= 0}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if> <c:if test="${room.daysCount < 0}">
											<span class="glyphicon glyphicon-remove-sign"
												aria-hidden="true"></span>
										</c:if></td>
									<td><c:if test="${room.deleted}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if></td>
									<td><c:out value="${room.price }"></c:out></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer END==================================================================== -->
	<script src="//code.jquery.com/jquery-1.12.3.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/image.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotelEdit.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?language=en&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU&libraries=places&callback=initAutocomplete"
		async defer></script>
	<script>
	if (${hotel.isDeleted} == true) {
		$('#isDeleted').click();
	}
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
	</script>

	<script>
		$('#hasParking').attr('checked', '${hotel.parking}' == 'true');
		$('#hasPool').attr('checked', '${room.pool}' == 'true');
		$('#hasGym').attr('checked', '${room.gym}' == 'true');
		$('#hasSpa').attr('checked', '${room.spa}' == 'true');
		$('#hasService').attr('checked', '${room.service}' == 'true');
		$('#hasCleaner').attr('checked', '${room.cleaner}' == 'true');
	</script>


	<!-- 
 
//-->
</body>

</html>