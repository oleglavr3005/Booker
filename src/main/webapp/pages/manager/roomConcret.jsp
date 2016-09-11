
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>HOTEL_NAME ${room.number}</title>

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
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">

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


<link
	href="${pageContext.servletContext.contextPath}/resources/js/image-picker/image-picker.css"
	rel="stylesheet">
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
				<div class="row">
					<img id="Img" style="height: 100px; padding: 10px; width: 110px;"
						<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="${room.photos[0].img }" />">

					<!-- 					END OF PHOTO -->
					<!-- 				INPUT -->
					<%-- 					<input style="margin-top: 5px; display:none" type="file" id="imgInput"  --%>
					<%-- 						onchange="uploadRoom()" accept="image/*" /> --%>
					<!-- 				END OF INPUT -->

					<a class="waves-effect waves-light btn" id="create_button"
						onclick="updateRoom(${room.id})"
						style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
						<span id="room_concret_save"></span>
					</a>
					<p id="create_error" style="color: red"></p>
				</div>

				<div class="row">
					<p>
						<input type="checkbox" class="filled-in" id="isDeleted"
							onclick="changeIsDeleted()" name="isDeleted" /> <label
							id="room_concret_deleted" for="isDeleted"></label>
					</p>

					<script>
						$('#isDeleted').attr('checked',
								'${room.deleted}' == 'true');
					</script>

					<p>
						<input type="checkbox" class="filled-in" id="freeBook"
							onclick="changeFreeBook()" name="freeBook" /> <label
							id="room_concret_freebook" for="freeBook"></label>
					</p>



				</div>


			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s4 offset-s2" style="margin-top: 20px;">

							<!-- 						ROOM TYPE -->
							<div class="row">
								<select id="roomType" class="chosen-select optionstyle">
									<option class="optionstyle" value="STANDART"
										<c:if test="${room.type == 'STANDART'}"> selected="selected"</c:if>>
										<span id="index_room_type_standart"></span></option>
									<option class="optionstyle" value="LUX"
										<c:if test="${room.type == 'LUX'}"> selected="selected"</c:if>>
										<span id="index_room_type_lux"></span></option>
									<option class="optionstyle" value="DELUX"
										<c:if test="${room.type == 'DELUX'}"> selected="selected"</c:if>>
										<span id="index_room_type_delux"></span></option>
								</select>
							</div>
							<!-- 						END OF ROOM TYPE -->




							<!-- 1 BEDS COUNT -->

							<div class="row">
								<input id="single" value="${room.bedsCount}" type="number"
									class="validate" name="single" min=1 max=100> <label
									id="singleLbl" data-error="${fmtPeople}" for="single"><span
									id="room_concrete_single"></span> </label>
							</div>

							<!-- 							END OF 1 BEDS COUNT -->

							<!-- DAYS COUNT -->

							<div class="row">
								<input id="days"
									<c:if test="${room.daysCount >= 0 }"> value="${room.daysCount}"</c:if>
									type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="days" min=1 max=365> <label
									id="daysLbl" data-error="" for="days"><span
									id="room_concrete_days"></span> </label>
							</div>

							<!-- 							END OF DAYS COUNT -->

							<!-- NUMBER -->

							<div class="row">
								<input id="number" value="${room.number}" type="number"
									class="validate" name="days" min=1 max=365> <label
									id="daysLbl" data-error="" for="days"><span
									id="room_concrete_number"></span></label>
							</div>

							<!-- 							END OF NUMBER -->

							<!-- PRICE -->

							<div class="row">
								<input id="price" value="${room.price}" type="number"
									class="validate" name="percentage" min=1 max=100> <label
									id="percentageLbl" data-error="" for="percentage"><span
									id="room_concrete_price"></span> </label>
							</div>

							<!-- 							END OF PRICE -->

						</div>

						<div class="col s4 offset-s2" style="margin-top: 20px;">

							<!-- 						FOOD TYPE -->
							<div class="row">
								<select id="foodType" class="chosen-select optionstyle">
									<option class="optionstyle" value="NONE" selected="selected"
										<c:if test="${room.food == 'NONE'}"> selected="selected"</c:if>>
										<span id="index_room_type_food_none"></span>
									</option>
									<option class="optionstyle" value="BREAKFAST"
										<c:if test="${room.food == 'BREAKFAST'}"> selected="selected"</c:if>>
										<span id="index_room_type_food_breakfast"></span>
									</option>
									<option class="optionstyle" value="TWICE"
										<c:if test="${room.food == 'TWICE'}"> selected="selected"</c:if>>
										<span id="index_room_type_food_twice"></span>
									</option>
									<option class="optionstyle" value="FULL"
										<c:if test="${room.food == 'FULL'}"> selected="selected"</c:if>>
										<span id="index_room_type_food_full"></span>
									</option>
								</select>
							</div>
							<!-- 						END OF FOOD TYPE -->

							<!-- 2 BEDS COUNT -->

							<div class="row">
								<input id="double" value="${room.doubleBedsCount}" type="number"
									class="validate" name="single" min=1 max=100> <label
									id="doubleLbl" data-error="${fmtPeople}" for="double"><span
									id="room_concrete_double"></span> </label>
							</div>

							<!-- 							END OF 2 BEDS COUNT -->

							<!-- PERCENTAGE COUNT -->

							<div class="row">
								<input id="percentage" value="${room.percentage}" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="percentage" min=1 max=100> <label
									id="percentageLbl2" data-error="" for="percentage"><span
									id="room_concrete_percentage"></span></label>
							</div>

							<!-- 							END OF PERCENTAGE COUNT -->




							<!-- 								CHECKBOX -->

							<p style="margin-top: 20px;">
								<input type="checkbox" class="filled-in" id="hasWiFi"
									name="hasWiFi" /> <label id="label_wifi" for="hasWiFi">WIFI</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasShower"
									name="hasShower" /> <label id="label_shower" for="hasShower">SHOWER</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasParking"
									name="hasParking" /> <label id="label_parking"
									for="hasParking">PARKING</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasCondition"
									name="hasCondition" /> <label id="label_condition"
									for="hasCondition">AIR CONDITION</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasPool"
									name="hasPool" /> <label id="label_pool" for="hasPool">SWIM
									POOL</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasGym"
									name="hasGym" /> <label id="label_gym" for="hasGym">FIT
									GYM</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasBalcony"
									name="hasBalcony" /> <label id="label_balcony"
									for="hasBalcony">BALCONY</label>
							</p>

							<!-- 								END OF CHECKBOX -->

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
					<jsp:include page="../cards/roomPhotoCard.jsp"></jsp:include>
				</div>
			</div>

			<div class="row">
				<div class="col s3 offset-s3">

					<a id="btn_add_image" class="waves-effect waves-light btn"
						style="background: #26A69A; color: #FFFFFF; margin: 0 auto;"
						onclick="pushInput()"></a>

					<!-- 				INPUT -->
					<input multiple style="margin-top: 60px; display: none" type="file"
						id="imgInput" onchange="updateRoomPhotos(${room.id})"
						accept="image/*" />
					<!-- 				END OF INPUT -->

				</div>

				<div class="col s3 offset-s1">
					<a id="btn_remove" class="waves-effect waves-light btn"
						style="background: #F55151; color: #FFFFFF; margin: 0 auto;"
						onclick="removeRoomPhoto()"></a>
				</div>
			</div>


		</div>


	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->
	<script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">$(document).ready(function() {
	    $('#photos').DataTable();
	} );</script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>

	<script>
		$('#hasWiFi').attr('checked', '${room.wifi}' == 'true');
		$('#hasShower').attr('checked', '${room.shower}' == 'true');
		$('#hasParking').attr('checked', '${room.parking}' == 'true');
		$('#hasCondition').attr('checked', '${room.condition}' == 'true');

		$('#hasPool').attr('checked', '${room.pool}' == 'true');
		$('#hasGym').attr('checked', '${room.gym}' == 'true');
		$('#hasBalcony').attr('checked', '${room.balcony}' == 'true');
	</script>


	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/room.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/image.js"></script>

</body>

</html>
