
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



				<!-- 				HOTEL NAME -->

				<div class="row">
					<label class="labelstyle"><span
							id="roomCreate_hotel"></span> </label> <select id="hotel_name"
						class="chosen-select optionstyle">
						<option class="optionstyle" selected="selected"
							value="${hotels[0].id}">${hotels[0].name}</option>
						<c:forEach var="hotel" items="${hotels}" begin="1">
							<option class="optionstyle" value="${hotel.id}">${hotel.name}</option>
						</c:forEach>
					</select>
				</div>

				<!-- 			END OF HOTEL NAME -->


				<!-- 						ROOM TYPE -->
				<div class="row">
					<select id="roomType" class="chosen-select optionstyle">
						<option class="optionstyle" value="STANDART" selected="selected">STANDART</option>
						<option class="optionstyle" value="LUX">LUX</option>
						<option class="optionstyle" value="DELUX">DELUX</option>
					</select>
				</div>
				<!-- 						END OF ROOM TYPE -->



				<!-- 						FOOD TYPE -->
				<div class="row">
					<select id="foodType" class="chosen-select optionstyle">
						<option class="optionstyle" value="NONE" selected="selected">NONE
						</option>
						<option class="optionstyle" value="BREAKFAST">BREAKFAST</option>
						<option class="optionstyle" value="TWICE">TWICE</option>
						<option class="optionstyle" value="FULL">FULL</option>
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
								<input id="number" type="number" class="validate" name="days"
									min=1 max=365> <label id="numberLbl"
									data-error="${fmtPeople}" for="number"><span
										id="room_concrete_number"></span></label>
							</div>

							<!-- 							END OF NUMBER -->


							<!-- 1 BEDS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input id="single" type="number" class="validate" name="single"
									min=0 max=100> <label id="singleLbl"
									data-error="${fmtPeople}" for="single"><span
										id="room_concrete_single"></span> </label>
							</div>

							<!-- 							END OF 1 BEDS COUNT -->

							<!-- 2 BEDS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input id="double" type="number" class="validate" name="single"
									min=0 max=100> <label id="doubleLbl"
									data-error="${fmtPeople}" for="double"><span
										id="room_concrete_double"></span></label>
							</div>

							<!-- 							END OF 2 BEDS COUNT -->



							<!-- PRICE -->

							<div class="row" style="margin-bottom: 0px">
								<input id="price" type="number" class="validate"
									name="percentage" min=1 max=1000000> <label
									id="percentageLbl" data-error="${fmtPeople}" for="percentage"><span
										id="room_concrete_price"></span> </label>
							</div>

							<!-- 							END OF PRICE -->

							<!-- DAYS COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input id="days" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="days" min=1 max=365> <label
									id="daysLbl" data-error="${fmtPeople}" for="days"><span
										id="room_concrete_days"></span> </label>
							</div>

							<!-- 							END OF DAYS COUNT -->

							<!-- PERCENTAGE COUNT -->

							<div class="row" style="margin-bottom: 0px">
								<input id="percentage" type="number"
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
								<input type="checkbox" class="filled-in" id="hasWiFi"
									name="hasWiFi" /> <label for="hasWiFi">WIFI</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasShower"
									name="hasShower" /> <label for="hasShower">SHOWER</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasParking"
									name="hasParking" /> <label for="hasParking">PARKING</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasCondition"
									name="hasCondition" /> <label for="hasCondition">AIR
									CONDITION</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasPool"
									name="hasPool" /> <label for="hasPool">SWIM POOL</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasGym"
									name="hasGym" /> <label for="hasGym">FIT GYM</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="hasBalcony"
									name="hasBalcony" /> <label for="hasBalcony">BALCONY</label>
							</p>

							<!-- 							FREE BOOK -->

							<p>
								<input type="checkbox" class="filled-in" id="freeBook"
									onclick="changeFreeBook()" name="freeBook" /> <label
									for="freeBook">FREEBOOK</label>
							</p>

							<!-- 							SEND NOTIF -->
							<p style="margin-top: 20px;">
								<input type="checkbox" class="filled-in" id="sendNotif"
									name="sendNotif" /> <label for="sendNotif">SEND NOTIF</label>
							</p>

							<div class="row">
								<a class="waves-effect waves-light btn" id="create_button"
									onclick="createRoom()"
									style="margin-left: 10px; text-align: center; width: 100%; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>SAVE</span></a>
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

							<!-- 				END OF FREE BOOK -->

							<!-- 								END OF CHECKBOX -->




						</div>


					</div>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s10 offset-s1"></div>
			<div class="col s1">.</div>

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
