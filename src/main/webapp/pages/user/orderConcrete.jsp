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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>MAIN PAGE</title>

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

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">

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
<style>
.invert:hover {
	-webkit-filter: invert(70%);
	filter: invert(70%);
}
</style>
</head>


<body>
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="/pages/header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container-fluid">

		<div class="row" style="margin-top: 20px;">

			<div class="col s3 offset-s1">
				<a href='<c:out value="${mainPhoto.id}"></c:out>' title="Banana"
					data-gallery> <img
					src="<c:out value="${mainPhoto.img}"></c:out>" alt="Banana">
				</a>


				<div style="overflow-x: auto;">
					<div style="margin: 10px; white-space: nowrap;">
						<c:forEach items="${hotelPhotos}" var="photo">
							<div style="display: inline-block;">
								<a href='<c:out value="${photo.img }"></c:out>'
									title="<c:out value="${photo.img }"></c:out>" data-gallery>
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

					<!-- HOTEL NAME + ICONS -->
					<div class="row" style="margin-bottom: 0;">
						<div class="col s8">
							<h5>
								<a href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}"><c:out value="${hotel.name}"></c:out></a>
							</h5>
						</div>

						<div class="col s4" style="padding-left: 0px; padding-right: 0px;">
							<c:if test="${room.wifi == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 24px; cursor: default;">
									<a class="tooltipped" data-position="icon" data-tooltip="Wifi"
										style="color: #0d0d0d;"><i class="material-icons invert">wifi</i></a>
								</div>
							</c:if>

							<c:if test="${room.shower == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 32px; height: 32px;">
									<a class="tooltipped" data-position="icon"
										data-tooltip="Shower"><img class="invert"
										style="max-width: 230%;"
										src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
								</div>
							</c:if>

							<c:if test="${room.parking == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 24px; cursor: default;">
									<a class="tooltipped" data-position="icon"
										data-tooltip="Parking" style="color: #0d0d0d;"><i
										class="material-icons invert">local_parking</i></a>
								</div>
							</c:if>

							<c:if test="${room.condition == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 24px; cursor: default;">
									<a class="tooltipped" data-position="icon"
										data-tooltip="Condition" style="color: #0d0d0d;"><i
										class="material-icons invert">toys</i></a>
								</div>
							</c:if>

							<c:if test="${room.pool == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 24px; cursor: default;">
									<a class="tooltipped" data-position="icon" data-tooltip="Pool"
										style="color: #0d0d0d;"><i class="material-icons invert">pool</i></a>
								</div>
							</c:if>

							<c:if test="${room.gym == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 24px; cursor: default;">
									<a class="tooltipped" data-position="icon" data-tooltip="Gym"
										style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
								</div>
							</c:if>

							<c:if test="${room.balcony == true}">
								<div class="col s1"
									style="margin-top: 10px; width: 32px; height: 32px;">
									<a class="tooltipped" data-position="icon"
										data-tooltip="Balcony"><img class="invert"
										style="max-width: 230%;"
										src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
								</div>
							</c:if>
						</div>
					</div>
					<!-- END OF HOTEL NAME + ICONS -->


					<!-- MAP MARKER -->
					<div class="row">
						<div class="col s12">
							<a class="tooltipped" data-position="icon" data-tooltip="Location"
								style="color: #0d0d0d;"><i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
							 <span>${hotel.city} ${hotel.street}</span>
						</div>
					</div>
					<!-- END OF MAP MARKER -->


					<!-- ROOM TYPE MARKER -->
					<div class="row ">
						<div class="col s12">
							<h5 style="font-size: 1rem; margin: 0 0 0 0;">
								@icon for Room type@ ROOM_TYPE :
								<c:out value="${room.type }"></c:out>
							</h5>
						</div>
					</div>
					<!-- END OF ROOM TYPE MARKER -->

					<!-- ORDER DATE MARKER -->
					<div class="row ">
						<div class="col s12">
							<a class="tooltipped" data-position="icon" data-tooltip="Order date"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a>
							 Order date <span id="order_date">${order.orderDate}</span>
						</div>
					</div>
					<!-- END OF ORDER DATE MARKER -->

					<!-- START DATE MARKER -->
					<div class="row ">
						<div class="col s12">
							<a class="tooltipped" data-position="icon" data-tooltip="Start date"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a>
							 From: <span id="start_date">${order.startDate}</span>
						</div>
					</div>
					<!-- END OF START DATE MARKER -->

					<!-- END DATE MARKER -->
					<div class="row ">
						<div class="col s12">
							<a class="tooltipped" data-position="icon" data-tooltip="End date"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a>
							To: <span id="end_date">${order.endDate}</span>
						</div>
					</div>
					<!-- END OF END DATE MARKER -->


					<!-- ROW WITH STATUS | FOOD | PRICE -->
					<div class="row ">
						<div class="col s4">
							<!-- 						TWO DIFFERENT ICONS IF.ACTIVE OR IF.FINISHED -->
							<span>Status ${order.status}</span>
						</div>
						<div class="col s4" style="margin-bottom: 0;">
							<a class="tooltipped" data-position="icon" data-tooltip="Food type"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a>
							<span>${room.food}</span>
						</div>
						<div class="col s4">
							<a class="tooltipped" data-position="icon" data-tooltip="Price"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-money invert" aria-hidden="true"></i></a>
							<span>${order.price}</span>
							<c:if test="${room.daysCount == -1}">
								<a class="tooltipped" data-position="icon" data-tooltip="No deposit"
									style="color: #0d0d0d;"><i class="fa fa-2x fa-exclamation-circle invert" aria-hidden="true"></i></a>
							</c:if>
						</div>
					</div>
					<!-- END OF ROW WITH STATUS | FOOD | PRICE -->




				</div>
			</div>
		</div>

		<div class="row">
<!-- 		here will be labedfor text area, comment ill be editable -->
			<div class="col s7 offset-s1" style="border: 1px solid">${order.comment}</div>
			<div class="col s4">
				<c:if test="${order.status != ACTIVE}">
					<div class="col s2 offset-s1"
						style="margin-top: 18px; margin-left: 0;">
<%-- 						<a id="calceOrder" class="waves-effect waves-light btn" onclick="removeOrder(${order.id})" --%>
<%-- 							style="background: #F55151; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message --%>
<%-- 								key="Cancel" /></a> --%>
					</div>
				</c:if>
			</div>

		</div>


	</div>




	<!-- Footer ========================================================================== -->
	<jsp:include page="/pages/foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<div id="modal1" class="modal"
		style="width: 25% !important; max-height: 40% !important">
		<div class="modal-content">
			<!-- 			<h4>VK auth</h4> -->
			<p>
				<img alt="Vk Log"
					src="http://1863x.com/wp-content/uploads/2016/01/vk-vkontakte-logo-vk.jpg"
					width="275px" height="200px;">
			</p>
			<div class="progress" style="width: 275px;">
				<div class="indeterminate"></div>
			</div>
			<!-- 			<div class="modal-footer"> -->

			<!-- 			</div> -->
		</div>

	</div>

	<c:if test="${vkOAuth}">
		<script type="text/javascript">
			$(document).ready(function() {
				$(window).load(function() {

					$('.modal-trigger').leanModal();
					$('#modal1').openModal();

					debugger;

					var token = window.location.hash.substr(1);
					$.post('vk_oauth', {
						token : token.split("&")[0].split("=")[1],
						user_id : token.split("&")[2].split("=")[1]
					}, function() {
						//NEED normal names
						document.location.href = '/MainPage/';

					});
				});
			});
		</script>
	</c:if>



	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			var date = document.getElementById("start_date");
			var dateObject = new Date(date.innerHTML);
			var curr_date = dateObject.getDate();
			if (curr_date < 10) {
				curr_date = "0" + curr_date;
			}
			var curr_month = dateObject.getMonth() + 1;
			if (curr_month < 10) {
				curr_month = "0" + curr_month;
			}
			var curr_year = dateObject.getFullYear();
			date.innerHTML = (curr_year + "-" + curr_month + "-" + curr_date);
			// return date = (curr_year + "-" + curr_month + "-" + curr_date);
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			var date = document.getElementById("end_date");
			var dateObject = new Date(date.innerHTML);
			var curr_date = dateObject.getDate();
			if (curr_date < 10) {
				curr_date = "0" + curr_date;
			}
			var curr_month = dateObject.getMonth() + 1;
			if (curr_month < 10) {
				curr_month = "0" + curr_month;
			}
			var curr_year = dateObject.getFullYear();
			date.innerHTML = (curr_year + "-" + curr_month + "-" + curr_date);
			// return date = (curr_year + "-" + curr_month + "-" + curr_date);
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			var date = document.getElementById("order_date");
			var dateObject = new Date(date.innerHTML);
			var curr_date = dateObject.getDate();
			if (curr_date < 10) {
				curr_date = "0" + curr_date;
			}
			var curr_month = dateObject.getMonth() + 1;
			if (curr_month < 10) {
				curr_month = "0" + curr_month;
			}
			var curr_year = dateObject.getFullYear();
			date.innerHTML = (curr_year + "-" + curr_month + "-" + curr_date);
			// return date = (curr_year + "-" + curr_month + "-" + curr_date);
		});
	</script>


	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/order/removeOrder.js"></script>


</body>

</html>