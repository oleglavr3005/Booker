<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">

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




<c:forEach var="order" items="${orders}">

	<div id="hotel_card_${order.id}" class="col s10 offset-s1">
		<div class="card">

			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">

					<div class="card-image col s4" style="position: relative;">
						<a><img src="<i:urlToImage url="${order.room.photo}" />"
							style="height: 170px; width: 200px; padding: 10px;"> </a>

					</div>

					<div class="col s8">
						<div class="row" style="margin-bottom: 0px;">
							<div class="col s7">

								<div class="row" style="margin-top: 15px;">
									<div class="col s5"><a href="${pageContext.servletContext.contextPath}/hotel/${order.hotel.id}">${order.hotel.name}</a></div>
									<div class="col s5 offset-s1">${order.room.type}</div>
								</div>

								<div class="row" style="margin-top: 15px;">TANYAS_DATE</div>

								<div class="row">
									<a class="tooltipped" data-position="icon" data-tooltip="Price"
										style="color: #0d0d0d;"><i
										class="fa fa-lg fa-money invert" aria-hidden="true"></i></a> <span>${order.price}</span>
								</div>

							</div>

							<div class="col s5">
								<div class="row">
									<c:if test="${order.room.wifi == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Wifi" style="color: #0d0d0d;"><i
												class="material-icons invert">wifi</i></a>
										</div>
									</c:if>

									<c:if test="${order.room.shower == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Shower"><img class="invert"
												style="max-width: 230%;"
												src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
										</div>
									</c:if>

									<c:if test="${order.room.parking == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Parking" style="color: #0d0d0d;"><i
												class="material-icons invert">local_parking</i></a>
										</div>
									</c:if>

									<c:if test="${order.room.condition == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Condition" style="color: #0d0d0d;"><i
												class="material-icons invert">toys</i></a>
										</div>
									</c:if>

									<c:if test="${order.room.pool == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Pool" style="color: #0d0d0d;"><i
												class="material-icons invert">pool</i></a>
										</div>
									</c:if>

									<c:if test="${order.room.gym == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon" data-tooltip="Gym"
												style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
										</div>
									</c:if>

									<c:if test="${order.room.balcony == true}">
										<div class="col s2" style="margin-top: 5px;">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Balcony"><img class="invert"
												style="max-width: 230%;"
												src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
										</div>
									</c:if>
								</div>

								<div class="row">
									<div class="col s6 offset-s6">
										<a class="tooltipped" data-position="icon" data-tooltip="Food"
											style="color: #0d0d0d;"><i
											class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${order.room.food}</span>
									</div>
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col s4 offset-s8">
								<a id="btn${order.id}" class="my-btn waves-effect waves-light btn"
									style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px;"
									onclick="removeOrderCard(${order.id})">REMOVE</a>
							</div>
						</div>
					</div>




				</div>

				<c:if test="${user != null && inCart == false}">
					<div class="row">
						<div class="col s2 offset-s8">
							<input id="count" type="text" class="validate"> <label
								id="nameLbl" data-error="COUNT ERROR" for="count"><fmt:message
									key="room.card.count" /></label>
						</div>
						<div class="col s2">
							<a class="waves-effect waves-light btn"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>INFO</span></a>
						</div>
					</div>
				</c:if>
			</div>


		</div>
	</div>
</c:forEach>


<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/order/removeOrder.js"></script>