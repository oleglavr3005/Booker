
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>ROOM CREATE</title>

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
	<input id="hotelId" type="hidden" value="${hotelId}" />
	<input id="lang" type="hidden" value="${language}" />

	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<!-- 					PHOTO -->
				<div class="row">
					<a href="#!"><img id="Img"
						style="height: 100px; padding: 10px; width: 110px;"
						<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="new_room.png" />">
					</a>
					<!-- 					END OF PHOTO -->
					<!-- 				INPUT -->
					<input multiple style="margin-top: 5px; display: none" type="file"
						id="imgInput" onchange="uploadRoom()" accept="image/*" />
					<!-- 				END OF INPUT -->

				</div>

				<!-- 						ROOM TYPE -->
				<div class="row">
					<select id="roomType" class="chosen-select optionstyle" onchange="setRoomType()">
						<option id="subscribes_table_roomtype_standart"
							class="optionstyle" value="STANDART" selected="selected">
						</option>
						<option id="subscribes_table_roomtype_lux" class="optionstyle"
							value="LUX"></option>
						<option id="subscribes_table_roomtype_delux" class="optionstyle"
							value="DELUX"></option>
					</select>
				</div>
				<!-- 						END OF ROOM TYPE -->


				<!-- 						FOOD TYPE -->
				<div class="row">
					<select id="foodType" class="chosen-select optionstyle" onchange="setRoomFood()">
						<option id="subscribes_table_roomfood_none" class="optionstyle"
							value="NONE" selected="selected"></option>
						<option id="subscribes_table_roomfood_breakfast"
							class="optionstyle" value="BREAKFAST"></option>
						<option id="subscribes_table_roomfood_twice" class="optionstyle"
							value="TWICE"></option>
						<option id="subscribes_table_roomfood_full" class="optionstyle"
							value="FULL"></option>
					</select>
				</div>
				<!-- 						END OF FOOD TYPE -->

			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s5 offset-s1" style="margin-top: 20px;">

							<!-- NUMBER -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomNumber()" id="number" type="text" class="validate" name="number">
								<label id="numberLbl" data-error="${fmtPeople}" for="number"><span
									id="room_concrete_number"></span></label>
							</div>

							<!-- 							END OF NUMBER -->


							<!-- 1 BEDS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomSingle()" id="single" onchange="checkBeds()" type="number"
									class="validate" name="single" min=0 max=100> <label
									id="singleLbl" data-error="${fmtPeople}" for="single"><span
									id="room_concrete_single"></span> </label>
							</div>

							<!-- 							END OF 1 BEDS COUNT -->

							<!-- 2 BEDS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomDouble()" id="double" onchange="checkBeds()" type="number"
									class="validate" name="single" min=0 max=100> <label
									id="doubleLbl" data-error="${fmtPeople}" for="double"><span
									id="room_concrete_double"></span></label>
							</div>

							<!-- 							END OF 2 BEDS COUNT -->



							<!-- PRICE -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomPrice()" id="price" type="number" class="validate"
									name="percentage" min=1 max=1000000> <label
									id="percentageLbl" data-error="${fmtPeople}" for="percentage"><span
									id="room_concrete_price"></span> </label>
							</div>

							<!-- 							END OF PRICE -->

							<!-- DAYS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomDays()" id="days" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="days" min=0 max=365> <label
									id="daysLbl" data-error="${fmtPeople}" for="days"><span
									id="room_concrete_days"></span> </label>
							</div>

							<!-- 							END OF DAYS COUNT -->

							<!-- PERCENTAGE COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input onkeyup="setRoomPerc()" id="percentage" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="percentage" min=0 max=100> <label
									id="percentageLbl" data-error="${fmtPeople}" for="percentage"><span
									id="room_concrete_percentage"></span> </label>
							</div>

							<!-- 							END OF PERCENTAGE COUNT -->

						</div>

						<div class="col s5 offset-s1" style="margin-top: 20px;">

							<!-- 								CHECKBOX -->

							<p style="margin-top: 20px;">
								<input onclick="setRoomCon(1)" type="checkbox" class="filled-in" id="hasWiFi"
									name="hasWiFi" /> <label id="label_wifi" for="hasWiFi">WIFI</label>
							</p>
							<p>
								<input onclick="setRoomCon(2)" type="checkbox" class="filled-in" id="hasShower"
									name="hasShower" /> <label id="label_shower" for="hasShower">SHOWER</label>
							</p>
							<p>
								<input onclick="setRoomCon(3)" type="checkbox" class="filled-in" id="hasTv" name="hasTv" />
								<label id="label_tv" for="hasTv">TV</label>
							</p>
							<p>
								<input onclick="setRoomCon(4)" type="checkbox" class="filled-in" id="hasCondition"
									name="hasCondition" /> <label id="label_condition"
									for="hasCondition">AIR CONDITION</label>
							</p>
							<p>
								<input onclick="setRoomCon(5)" type="checkbox" class="filled-in" id="hasBalcony"
									name="hasBalcony" /> <label id="label_balcony"
									for="hasBalcony">BALCONY</label>
							</p>

							<!-- 							FREE BOOK -->

							<p>
								<input type="checkbox" class="filled-in" id="freeBook"
									onclick="changeFreeBookCreate()" name="freeBook" /> <label
									id="room_free" for="freeBook">FREEBOOK</label>
							</p>

							<!-- 							SEND NOTIF -->
							<p style="margin-top: 20px;">
								<input type="checkbox" class="filled-in" id="sendNotif"
									name="sendNotif" /> <label id="lbl_sendnotif" for="sendNotif">SEND
									NOTIF</label>
							</p>

							<div class="row">
								<a class="waves-effect waves-light btn" id="create_button"
									onclick="createRoom()"
									style="margin-left: 10px; text-align: center; width: 100%; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
									<span id="settings_enter_save">SAVE</span>
								</a>
								<p id="create_error" style="color: red"></p>
							</div>
							<script>
								function changeFreeBook() {
									var freeBook = document
											.getElementById('freeBook').checked;
									$('#percentage').prop('disabled', freeBook);
									$('#days').prop('disabled', freeBook);
								}
								$('#freeBook').attr('checked',
										'${room.daysCount}' < 0);
							</script>

						</div>


					</div>

				</div>
			</div>
		</div>
		<div class="row">

			<div class="card">
				<div class="container-fluid">
					<div class="row" style="margin-top: 15px; margin-bottom: 0px;">
						<div class="card-image col s4" style="position: relative;">
							<div>
								<img id="ImgCard"
									style="height: 180px; width: 230px; padding: 10px;"
									src="<i:urlToImage url="new_hotel.png" />">
							</div>
						</div>

						<div class="col s5">

							<!-- ROOM TYPE ZONE -->
							<div class="row" style="margin-top: 15px;">
									<span id="room_create_card_type"></span>
								<span style="margin-left: 5px;" class="roomCard_countOfFree">
								</span> 1
							</div>
							<!-- 				END OF ROOM TYPE ZONE -->

							<!-- BEDS ICON ZONE -->
							<div class="row">
								<a class="tooltipped tooltip_double_beds" data-position="icon"
									data-tooltip="Double beds" style="color: #0d0d0d;"><img
									class="invert" style="max-width: 7%;"
									src="${pageContext.servletContext.contextPath}/resources/images/double_bed.png" /></a>
								<span id="doubleCountCard"></span> <a
									class="tooltipped tooltip_single_beds" data-position="icon"
									data-tooltip="Single beds" style="color: #0d0d0d;"><img
									class="invert" style="max-width: 7%;"
									src="${pageContext.servletContext.contextPath}/resources/images/single_bed.png" /></a>
								<span id="singleCountCard"></span>
							</div>
							<!-- END OF BEDS ICON ZONE -->

							<!-- ROOM FOOD ZONE -->
							<div class="row">
								<a class="tooltipped tooltip_food" data-position="icon"
									data-tooltip="Food" style="color: #0d0d0d;"><i
									class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a>
									<span id="room_create_card_food"></span>
							</div>
							<!-- END OF ROOM FOOD ZONE -->

							<!-- ROOM PRICE ZONE -->
							<div class="row">
								<div class="col s6" style="margin-left: -13px;">
									<a class="tooltipped tooltip_price" data-position="icon"
										data-tooltip="Price for one day" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-money invert" aria-hidden="true"></i></a> 
									<span id="room_create_card_price"></span>

									<i id="showInfo" onclick="showCardInfo()"
										class="fa fa-lg fa-info invert tooltipped tooltip_show_info"
										data-tooltip="Show additional info" aria-hidden="true"></i>
								</div>
							</div>


							<!-- END OF ROOM PRICE ZONE -->

						</div>

						<div class="col s3">
							<div class="row"
								style="float: right; text-align: right; font-size: 0.3rem; color: black; margin-right: 0px;">
									<a id="con1" class="tooltipped index_room_wifi" data-position="icon"
										data-tooltip="Wifi" style="dispaly:none; color: #0d0d0d;"><i
										class="material-icons invert">wifi</i></a>

									<a id="con2" style="dispaly:none; "class="tooltipped index_room_shower" data-position="icon"
										data-tooltip="Shower"><img class="invert"
										style="max-width: 10%; margin-top: -1.5rem"
										src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" />
									</a>

									<a id="con3" class="tooltipped index_room_conditioner"
										data-position="icon" data-tooltip="Condition"
										style="dispaly:none; color: #0d0d0d;"><i class="material-icons invert">toys</i></a>

									<a id="con4" style="dispaly:none; "class="tooltipped index_room_balcony" data-position="icon"
										data-tooltip="Balcony"><img class="invert"
										style="max-width: 10%; margin-top: -1.5rem"
										src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" />
									</a>

									<a id="con5" class="tooltipped index_room_tv" data-position="icon"
										data-tooltip="Television" style="dispaly:none; color: #0d0d0d;"><i
										class="material-icons invert">tv</i></a>
							</div>
						</div>
					</div>

					<!-- 						INFO MONEY REFUND ZONE -->
					<div class="row">
						<div id="details_panel" class="col s12"
							style="display: none">
									<div id="content"
										style="border: 1px solid; border-radius: 10px; padding: 5px; ">
										<span class="room_card_info1">YOU WILL GET 100% REFUND
											IN CASE OF CANCELING ORDER ONLY IN</span> ${room.daysCount} <span
											class="room_card_info2">DAYS BEFORE MOVING IN, AFTER
											THESE PERIOD REFUND WILL BE ONLY</span> ${room.percentage}%
									</div>
									<div
										style="border: 1px solid green; border-radius: 10px; padding: 5px; ">
										<span class="room_card_info3">FREE_BOOK</span>
									</div>
						</div>

					</div>
					<!-- 						END OF INFO MONEY REFUND ZONE -->
background-color: rgba(255, 0, 0, 0.3);
background-color: rgba(0, 255, 0, 0.3);

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
		src="${pageContext.servletContext.contextPath}/resources/js/manager/room.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/image.js"></script>

</body>

</html>
