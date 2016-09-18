<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">

<head>

<meta charset="utf-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>Booker | Order №${order.id}</title>

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
</head>


<body>
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />

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
								id="hotel_button_previous"></span>
						</button>
						<button type="button" class="btn btn-primary next">
							<span id="hotel_button_next"></span> <i
								class="glyphicon glyphicon-chevron-right"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header ========================================================================= -->
	<jsp:include page="/pages/header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container-fluid">

		<div class="row" style="margin-top: 20px;">

			<div id="links">
				<div class="row">
					<div class="col s4 offset-s1">
						<c:if test="${fn:length(room.photos) == 0}">
							<a href="<i:urlToImage url="no.jpg" />" title="No image"
								data-gallery> <img style="width: 350px; height: 260px;"
								src="<i:urlToImage url="no.jpg" />" alt="No image">
							</a>
						</c:if>
						<c:if test="${fn:length(room.photos) != 0}">
							<a href='<i:urlToImage url="${room.photos[0].img}" />'
								data-gallery> <img style="width: 350px; height: 260px;"
								src="<i:urlToImage url="${room.photos[0].img}" />">
							</a>


							<div style="overflow-x: auto;">
								<div style="margin: 10px; white-space: nowrap;">
									<c:forEach items="${room.photos}" var="photo" begin="1">
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
					<div class="col s7">
						<div class="container-fluid">
							<!-- HOTEL NAME + ICONS -->
							<div class="row" style="margin-bottom: 0;">
								<div class="col s8">
									<h5>
										<a
											href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}"><c:out
												value="${hotel.name}"></c:out></a>
									</h5>
								</div>
								<div class="col s4"
									style="padding-left: 0px; padding-right: 0px;">
									<c:if test="${room.wifi == true}">
										<div class="col s1"
											style="margin-top: 10px; width: 24px; cursor: default;">
											<a class="tooltipped index_room_wifi" data-position="icon"
												data-tooltip="Wifi" style="color: #0d0d0d;"><i
												class="material-icons invert">wifi</i></a>
										</div>
									</c:if>
									<c:if test="${room.shower == true}">
										<div class="col s1"
											style="margin-top: 10px; width: 32px; height: 32px;">
											<a class="tooltipped index_room_shower" data-position="icon"
												data-tooltip="Shower"><img class="invert"
												style="max-width: 230%;"
												src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
										</div>
									</c:if>
									<c:if test="${room.condition == true}">
										<div class="col s1"
											style="margin-top: 10px; width: 24px; cursor: default;">
											<a class="tooltipped index_room_conditioner"
												data-position="icon" data-tooltip="Condition"
												style="color: #0d0d0d;"><i class="material-icons invert">toys</i></a>
										</div>
									</c:if>
									<c:if test="${room.balcony == true}">
										<div class="col s1"
											style="margin-top: 10px; width: 32px; height: 32px;">
											<a class="tooltipped index_room_balcony" data-position="icon"
												data-tooltip="Balcony"><img class="invert"
												style="max-width: 230%;"
												src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
										</div>
									</c:if>

									<c:if test="${room.tv == true}">
										<div class="col s1"
											style="margin-top: 10px; width: 32px; height: 32px;">
											<a class="tooltipped index_room_tv" data-position="icon"
												data-tooltip="Television" style="color: #0d0d0d;"><i
												class="material-icons invert">tv</i></a>
										</div>


									</c:if>
								</div>
							</div>
							<!-- END OF HOTEL NAME + ICONS -->

							<!-- MAP MARKER -->
							<div class="row">
								<div class="col s12">
									<a class="tooltipped index_search_location"
										data-position="icon" data-tooltip="Location"
										style="color: #0d0d0d;"><i
										class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
									<span>${hotel.location}</span>
								</div>
							</div>
							<!-- END OF MAP MARKER -->


							<!-- ROOM TYPE MARKER -->
							<div class="row ">
								<div class="col s12">
									<a class="tooltipped tooltip_room_type" data-position="icon"
										data-tooltip="Location" style="color: #0d0d0d;"><i
										class="fa fa-hotel invert" aria-hidden="true"></i></a>
									<c:if test="${room.type == 'STANDART'}">
										<span id="subscribes_table_roomtype_standart"></span>
									</c:if>
									<c:if test="${room.type == 'LUX'}">
										<span id="subscribes_table_roomtype_lux"></span>
									</c:if>
									<c:if test="${room.type == 'DELUX'}">
										<span id="subscribes_table_roomtype_delux"></span>
									</c:if>
								</div>
							</div>
							<!-- END OF ROOM TYPE MARKER -->

							<!-- ORDER DATE MARKER -->
							<div class="row ">
								<div class="col s12">
									<a class="tooltipped tooltip_order_date" data-position="icon"
										data-tooltip="Order date" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a> <span
										id="order_concrete_order_date"></span> <span id="order_date">${order.orderDate}</span>
								</div>
							</div>
							<!-- END OF ORDER DATE MARKER -->

							<!-- START DATE MARKER -->
							<div class="row ">
								<div class="col s12">
									<a class="tooltipped tooltip_start_date" data-position="icon"
										data-tooltip="Start date" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a> <span
										id="order_card_from"></span> <span id="start_date">${order.startDate}</span>
								</div>
							</div>
							<!-- END OF START DATE MARKER -->

							<!-- END DATE MARKER -->
							<div class="row ">
								<div class="col s12">
									<a class="tooltipped tooltip_start_date" data-position="icon"
										data-tooltip="End date" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a> <span
										id="order_card_to"></span> <span id="end_date">${order.endDate}</span>
								</div>
							</div>
							<!-- END OF END DATE MARKER -->


							<!-- ROW WITH STATUS | FOOD | PRICE -->
							<div class="row ">
								<div class="col s12">
									<a class="tooltipped tooltip_status" data-position="icon"
										data-tooltip="Order status" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-clock-o invert" aria-hidden="true"></i></a> <span
										id="subscribes_table_status"></span>
									<c:if test="${order.status == 'ACTIVE'}">
										<span id="subscribes_table_status_active"></span>
									</c:if>
									<c:if test="${order.status == 'FINISHED'}">
										<span id="subscribes_table_status_finished"></span>
									</c:if>
									<c:if test="${order.status == 'CANCELED'}">
										<span id="subscribes_table_status_canceled"></span>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col s12" style="margin-bottom: 0;">
									<a class="tooltipped tooltip_food" data-position="icon"
										data-tooltip="Food type" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span
										id="subscribes_table_roomfood"></span>
									<c:if test="${room.food == 'NONE'}">
										<span id="subscribes_table_roomfood_none"></span>
									</c:if>
									<c:if test="${room.food == 'BREAKFAST'}">
										<span id="subscribes_table_roomfood_breakfast"></span>
									</c:if>
									<c:if test="${room.food == 'TWICE'}">
										<span id="subscribes_table_roomfood_twice"></span>
									</c:if>
									<c:if test="${room.food == 'FULL'}">
										<span id="subscribes_table_roomfood_full"></span>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col s12">
									<a class="tooltipped tooltip_price" data-position="icon"
										data-tooltip="Price" style="color: #0d0d0d;"><i
										class="fa fa-lg fa-money invert" aria-hidden="true"></i></a> <span
										id="subscribes_table_price"></span> <span>${order.price}</span>
									<c:if test="${room.daysCount == -1}">
										<a class="tooltipped tooltip_no_deposit" data-position="icon"
											data-tooltip="No deposit" style="color: #0d0d0d;"><i
											class="fa fa-2x fa-exclamation-circle invert"
											aria-hidden="true"></i></a>
									</c:if>
								</div>
							</div>
							<!-- END OF ROW WITH STATUS | FOOD | PRICE -->




						</div>
					</div>
				</div>

				<div class="row">
					<!-- 		here will be labedfor text area, comment ill be editable -->
					<div class="col s8 offset-s1">
						<div
							style="font-size: 15px; padding: 10px; border: solid 1px #000; border-radius: 10px; background-color: lightgray;">
							<div class="ui pointing label"
								style="padding: 5px; padding-left: 20px; padding-right: 20px;">
								<span id="order_concret_comment"></span>
							</div>
							<div class="input-field">
								<textarea id="comment"
									<c:if test="${order.status != 'ACTIVE' || user.type == 'MANAGER'}">readonly</c:if>
									class="materialize-textarea">${order.comment}</textarea>
								<label id="commentLbl" data-error="COMMENT IS NOT VALID!"
									for="name"></label>
							</div>
						</div>
					</div>

					<c:if test="${order.status == 'ACTIVE' && user.type == 'USER'}">
						<div class="col s2 offset-s1">
							<div class="row">
								<a class="waves-effect waves-light btn" id="create_button"
									onclick="updateComment(${order.id})"
									style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
									<span id="request_approve"></span>
								</a>
							</div>
							<div class="row" id="commentInfo"></div>
						</div>
					</c:if>


					<!-- 					<div class="col s4"> -->
					<%-- 						<c:if test="${order.status != ACTIVE}"> --%>
					<!-- 							<div class="col s2 offset-s1" -->
					<!-- 								style="margin-top: 18px; margin-left: 0;"> -->
					<%-- 														<a id="calceOrder" class="waves-effect waves-light btn" onclick="removeOrder(${order.id})" --%>
					<%-- 															style="background: #F55151; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message --%>
					<%-- 																key="Cancel" /></a> --%>
					<!-- 							</div> -->
					<%-- 						</c:if> --%>
					<!-- 					</div> -->

				</div>


			</div>

		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="/pages/foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/order/concrete.js"></script>

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

	<script type="text/javascript">
	$(document).ready(function() {
		document.title = languages.script.current.title.order +  ' №' + '${order.id}';
	});
	</script>
	
</body>

</html>