<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">

<style>
b {
	margin-left: 8px;
	font-size: 15px;
}

.invert:hover {
	-webkit-filter: invert(70%);
	filter: invert(70%);
	cursor: default;
}
</style>

<!-- MOVE TO HOTEL -->
<h6>
	<c:if test="${countOfRooms > 0 }">
		<fmt:message key="card.header" />
		<span id="periodicals_number_for_all_users">${countOfRooms}</span>
	</c:if>
	<c:if test="${countOfRooms <= 0 }">
		<fmt:message key="card.no.periodicals" />
	</c:if>
</h6>
<div class="divider" style="margin: 0;"></div>

<c:if test="${countOfRooms == 0}">
	<h5 style="color: red; margin-bottom: 63px;">
		<fmt:message key="card.no.periodicals" />
	</h5>
</c:if>

<!--END MOVE TO HOTEL -->

<input id="flag" type="hidden" value="true" />

<script>
		if ($('#date_from').val() == "" || $('#date_to').val() == ""){
			$('#flag').val("false");
		}
	</script>


<c:forEach var="room" items="${rooms}">

	<div id="hotel_card_${room.id}" class="col s10 offset-s1">
		<div class="card">

			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">

					<div class="card-image col s4" style="position: relative;">
						<a><img src="${pageContext.servletContext.contextPath}/resources/images/photoOfHotelsRoom/${room.photos[0].img}"
							style="height: 170px; width: 200px; padding: 10px;"> </a>

					</div>

					<div class="col s5">

						<div class="row" style="margin-top: 15px;">
							<span>${room.type}</span>
						</div>

						<div class="row">
							<a class="tooltipped" data-position="icon"
								data-tooltip="Double beds" style="color: #0d0d0d;"><img
								class="invert" style="max-width: 7%;"
								src="${pageContext.servletContext.contextPath}/resources/images/double_bed.png" /></a>
							<span>${room.doubleBedsCount}</span> <a class="tooltipped"
								data-position="icon" data-tooltip="Single beds"
								style="color: #0d0d0d;"><img class="invert"
								style="max-width: 7%;"
								src="${pageContext.servletContext.contextPath}/resources/images/single_bed.png" /></a>
							<span>${room.bedsCount}</span>
						</div>

						<div class="row">
							<a class="tooltipped" data-position="icon" data-tooltip="Food"
								style="color: #0d0d0d;"><i
								class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${room.food}</span>
						</div>

						<div class="row">
							<a class="tooltipped" data-position="icon" data-tooltip="Price for one day"
								style="color: #0d0d0d;"><i class="fa fa-lg fa-money invert"
								aria-hidden="true"></i></a> <span>${room.price}</span>
									<c:if test="${room.daysCount == -1}">
										<a class="tooltipped" data-position="icon" data-tooltip="No deposit"
										style="color: #0d0d0d;"><i class="fa fa-2x fa-exclamation-circle invert" aria-hidden="true"></i></a>
									</c:if>
						</div>

					</div>

					<div class="col s3">
						<div class="row" style="float: right; text-align:right; font-size:0.3rem">
							<c:if test="${room.wifi == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Wifi"
									style="color: #0d0d0d;"><i class="material-icons invert">wifi</i></a>
							</c:if>

							<c:if test="${room.shower == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Shower"><img
									class="invert" style="max-width: 10%; margin-top:-1.5rem"
									src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
							</c:if>

							<c:if test="${room.parking == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Parking" style="color: #0d0d0d;"><i
									class="material-icons invert">local_parking</i></a>
							</c:if>

							<c:if test="${room.condition == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Condition" style="color: #0d0d0d;"><i
									class="material-icons invert">toys</i></a>
							</c:if>

							<c:if test="${room.pool == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Pool"
									style="color: #0d0d0d;"><i class="material-icons invert">pool</i></a>
							</c:if>

							<c:if test="${room.gym == true}">
								<a class="tooltipped" data-position="icon" data-tooltip="Gym"
									style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
							</c:if>

							<c:if test="${room.balcony == true}">
								<a class="tooltipped" data-position="icon"
									data-tooltip="Balcony"><img class="invert"
									style="max-width: 10%; margin-top:-1.5rem"
									src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
							</c:if>
						</div>
					</div>
				</div>

				<c:if test="${user != null}">
					<div class="row">
						<div class="col s3 offset-s8" id="cont"></div>

						<c:if test="${startDate != null}">
							<div class="col s2 offset-s10" style="float: right">
								<a id="btn${room.id}" class="waves-effect waves-light btn"
									onclick="addToCart(${room.id})"
									style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>ADD
										TO CART</span></a>
							</div>
						</c:if>

						<c:if test="${startDate == null}">
							<div id="hiddenError" class="col s2 offset-s6">ERROR
								WITH INFO</div>
						</c:if>


					</div>
				</c:if>
				<c:if test="${user == null}">
					<div class="row">
						<div class="col s2" style="float: right">
							<a class="waves-effect waves-light btn" disabled
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>U
									NEED 2 LOGIN</span></a>
						</div>
					</div>
				</c:if>

			</div>


		</div>
	</div>

</c:forEach>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row" style="margin-bottom: 0;">
	<div id="demo5" class="col s4 offset-s5" style="margin-top: 10px;"></div>
</div>
<!-- END OF PAGINATOR 3000 -->


<!-- IMPORTED -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<!-- END OF IMPORTED -->

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>

<script type="text/javascript">
		var pagesCount = '${countOfPages}';
		var currentPage = '${currentPage}';
		
		if (pagesCount > 1) {
			jQuery(function() {
				jQuery("#demo5").paginate({
					count : pagesCount,
					start : currentPage,
					display : 5,
					border : false,
					//		border_color			: '#fff',
					text_color : '#fff',
					background_color : '#26A69A',
					//		border_hover_color		: '#ccc',
					text_hover_color : '#000',
					background_hover_color : '#CFCFCF',
					images : true,
					mouse : 'press',
					onChange : function(page) {
						findPage(window.location.href,page);
					}
				});
			});
		}
 	</script> 


<script
	src="${pageContext.servletContext.contextPath}/resources/js/order/createOrder.js"
	type="text/javascript"></script>