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
</style>

<h6>
	<c:if test="${countOfHotels > 0 }">
		<fmt:message key="card.header" />
		<span id="periodicals_number_for_all_users">${countOfHotels}</span>
	</c:if>
	<c:if test="${countOfHotels <= 0 }">
		<fmt:message key="card.no.periodicals" />
	</c:if>
</h6>
<div class="divider" style="margin-bottom: 20px;"></div>

<c:if test="${countOfHotels == 0}">
	<h5 style="color: red; margin-bottom: 63px;">
		<fmt:message key="card.no.periodicals" />
	</h5>
</c:if>

<c:forEach var="hotel" items="${hotels}">

	<div id="hotel_card_${hotel.id}" class="col s10 offset-s1">
		<div class="card">

			<div class="container-fluid">
				<div class="row">

					<div class="card-image col s4" style="position: relative;">
						<a
							href="${pageContext.servletContext.contextPath}/booker/hotel/${hotel.id}">
							<img src="<i:urlToImage url="${hotel.photo}" />"
							style="height: 170px; width: 200px; padding: 10px;">
						</a>

					</div>

					<div class="col s6">
						<div class="row">
							<span>${hotel.name}</span> <span>STAR_ZONE</span>
						</div>

						<div class="row">
							<i class="fa fa-2x icon-map-marker" aria-hidden="true"></i> <span>${hotel.city}
								${hotel.street}</span>
						</div>

						<div class="row">
							<i class="material-icons prefix"
								style="margin-left: -5px; margin-right: 10px; margin-top: 14px;">receipt</i>
							<span>${hotel.desc}</span>
						</div>
					</div>

					<div class="col s2">
						<div class="row">
							<i class="fa fa-2x fa-star" aria-hidden="true"></i> <span>RATING
								: ${hotel.rating }</span>
						</div>


						<div class="row" style="margin-top: 50px">

							<a class="waves-effect waves-light btn"
								href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>INFO</span></a>
						</div>

					</div>
				</div>
			</div>


		</div>
	</div>	
</c:forEach>

<c:if test="${userState == 'admin'}">
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/index.js"
		type="text/javascript"></script>
</c:if>