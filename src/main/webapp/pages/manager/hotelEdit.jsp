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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>MAIN PAGE</title>

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

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<div class="row">
					<!-- 					PHOTO -->



					<a href="#!"><img id="Img"
						style="height: 100px; padding: 10px; width: 110px;"
						<%-- 														src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
 								src="<i:urlToImage url="${hotel.photos[0].img }" />">
					</a>
					<!-- 					END OF PHOTO -->


					<a class="waves-effect waves-light btn" id="create_button"
						onclick="updateHotel(${hotel.id})"
						style="margin-left: 10px; margin-top: 100px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>UPDATE</span></a>
					<p id="create_error" style="color: red"></p>
				</div>
				<div class="row">
					<p>
						<input type="checkbox" class="filled-in" id="isDeleted"
							name="isDeleted" /> <label for="isDeleted">DELETED</label>
					</p>

					<input id="hotId" name=hotelId type="hidden" value="${hotel.id}" />
					<a class="waves-effect waves-light btn" id="create_room_button"
						href="${pageContext.servletContext.contextPath}/cabinet/create_room"
						style="margin-left: 10px; margin-top: 100px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>CREATE_ROOM</span></a>


					<script>
						$('#isDeleted').attr('checked',
								'${hotel.isDeleted}' == 'true');
					</script>

				</div>


			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s6">

							<!-- 						NAME -->

							<div class="input-field">
								<input id="name" type="text" class="validate" length="45"
									value="${hotel.name}" placeholder="Name of Hotel"> <label
									id="nameLbl" data-error="${fmtName}" for="name"><fmt:message
										key="admin.edit.name" /></label>
							</div>

							<!-- 							END OF NAME -->

						</div>

						<div class="col s6" style="margin-top: 15px;">

							<!-- 						STARS -->
							<input id="rating" onchange="rate()" type="number"
								value="${hotel.stars}" class="rating" min=0 max=5 step=1
								data-size="xs" data-stars="5"> <span
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

						<div class="col s8">
							<!-- 						ADDRESS -->
							<div class="input-field">
								<input id="address" type="text" class="validate" length="145"
									placeholder="Address of hotel"
									value="${hotel.city} ${hotel.street}"> <label
									id="cityLbl" data-error="${fmtName}" for="city"><fmt:message
										key="admin.edit.city" /></label>
							</div>
							<!-- 							END OF ADDRESS -->

						</div>



						<div class="col s4">

							<!-- 						PHONE -->

							<div class="input-field">
								<input id="phone" type="text" class="validate" length="45"
									placeholder="Name of phone" value="${hotel.phoneNumber}">
								<label id="phoneLbl" data-error="${fmtName}" for="phone"><fmt:message
										key="admin.edit.phone" /></label>
							</div>

							<!--####################### END OF PHONE ############################# -->

						</div>




					</div>

					<div class="row">

						<div class="col s12">

							<!-- 						DESC -->

							<div class="input-field">
								<textarea placeholder="Desc" id="desc"
									class="materialize-textarea" class="validate" length="999">${hotel.desc}</textarea>
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



	<div class="container">
		<div class="row">


			<div class="col s10 offset-s1">
				<div id="switchContent">
					<jsp:include page="../cards/hotelPhotoCard.jsp"></jsp:include>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col s3 offset-s3">

				<a class="my-btn waves-effect waves-light btn"
					style="background: #26A69A; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px; margin: 0 auto;"
					onclick="pushInput()">ADD_IMAGE </a>

				<!-- 				INPUT -->
				<input multiple style="margin-top: 60px; display: none" type="file"
					id="imgInput" onchange="updateHotelPhotos(${hotel.id})"
					accept="image/*" />
				<!-- 				END OF INPUT -->

			</div>

			<div class="col s3 offset-s1">
				<a class="my-btn waves-effect waves-light btn"
					style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px; margin: 0 auto;"
					onclick="removeHotelPhoto()">REMOVE_SELECTED </a>
			</div>
		</div>


	</div>

	<div class="container-fluid">
		<div class="row">
			<div id="admin" class="col s12">
				<div class="card material-table">
					<div class="table-header">
						<span class="table-title">Rooms</span>
						<div class="actions">
							<a href="${pageContext.servletContext.contextPath}/cabinet/create_room"
								class="my-btn waves-effect waves-light btn" style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">Create Room</a>
								 <button
								class="search-toggle waves-effect btn-flat nopadding" style="margin-left: 10px;"><i
								class="material-icons">search</i></button>
						</div>
					</div>
					<table id="datatable">
						<thead>
							<tr>
								<th>#</th>
								<th>Type</th>
								<th>Capacity</th>
								<th>Convinions</th>
								<th>Food</th>
								<th>Free Book</th>
								<th>Deleted</th>
								<th>Price</th>
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
											<a class="tooltipped" data-position="icon"
												data-tooltip="Wifi" style="color: #0d0d0d;"><i
												class="material-icons invert">wifi</i></a>
										</c:if> <c:if test="${room.shower == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Shower"><img class="invert"
												style="max-width: 15%; margin-top: -1rem"
												src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
										</c:if> <c:if test="${room.parking == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Parking" style="color: #0d0d0d;"><i
												class="material-icons invert">local_parking</i></a>
										</c:if> <c:if test="${room.condition == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Condition" style="color: #0d0d0d;"><i
												class="material-icons invert">toys</i></a>
										</c:if> <c:if test="${room.pool == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Pool" style="color: #0d0d0d;"><i
												class="material-icons invert">pool</i></a>
										</c:if> <c:if test="${room.gym == true}">
											<a class="tooltipped" data-position="icon" data-tooltip="Gym"
												style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
										</c:if> <c:if test="${room.balcony == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Balcony"><img class="invert"
												style="max-width: 15%; margin-top: -1rem"
												src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
										</c:if></td>
									<td><a class="tooltipped" data-position="icon"
										data-tooltip="Food" style="color: #0d0d0d;"><i
											class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${room.food}</span></td>
									<td><c:if test="${room.daysCount >= 0}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if> <c:if test="${room.daysCount < 0}">
											<span class="glyphicon glyphicon-remove-sign"
												aria-hidden="true"></span>
										</c:if></td>
									<td><c:if test="${room.deleted}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if> <c:if test="${room.deleted}">
											<span class="glyphicon glyphicon-remove-sign"
												aria-hidden="true"></span>
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
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
	
	</script>


	<!-- 
 
//-->
</body>

</html>