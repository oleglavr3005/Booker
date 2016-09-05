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

<!-- <h6> -->
<%-- 	<c:if test="${countOfHotels > 0 }"> --%>
<%-- 		<fmt:message key="card.header" /> --%>
<%-- 		<span id="periodicals_number_for_all_users">${countOfHotels}</span> --%>
<%-- 	</c:if> --%>
<%-- 	<c:if test="${countOfHotels <= 0 }"> --%>
<%-- 		<fmt:message key="card.no.periodicals" /> --%>
<%-- 	</c:if> --%>
<!-- </h6> -->
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
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">

					<div class="card-image col s4" style="position: relative;">
						<a
							href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}">
							<img src="<i:urlToImage url="${hotel.photos[0].img}" />"
							style="height: 170px; width: 200px; padding: 10px;">
						</a>

					</div>

					<div class="col s6">

						<div class="row" style="margin-top: 15px;">
							<div class="col s5">
								<a href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}">${hotel.name}</a>
							</div>
							<div class="col s6 offset-s1">
							<a class="tooltipped" data-position="icon" data-tooltip="Stars"
										style="color: #0d0d0d;text-decoration: none;">
								<c:forEach var="i" begin="1" end="${hotel.stars}">
									<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								</c:forEach>
							</a>
							</div>
						</div>


						<div class="row">
							<a class="tooltipped" data-position="icon" data-tooltip="Location"
								style="color: #0d0d0d;text-decoration: none;"><i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
							<span>${hotel.city}
								${hotel.street}</span>
						</div>

						<div class="row" style="margin-bottom: 5px">
							<a class="tooltipped" data-position="icon" data-tooltip="Description"
								style="color: #0d0d0d; cursor:default"><i class="material-icons invert" style="font-size: 20px;">receipt</i></a>
							<span>${hotel.desc}</span>
						</div>
					</div>

					<div class="col s2">
						<div class="row">
						<a class="tooltipped" data-position="icon" data-tooltip="Rating"
							style="color: #0d0d0d;text-decoration: none;">
							<i class="fa fa-lg fa-star invert" aria-hidden="true"></i> <span>${hotel.rating }</span>
							</a>
						</div>


						<div class="row" style="margin-top: 130px">

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

<!-- PAGINATOR 3000 -->
		<div id="paginationdemo" class="row">
			<div id="demo5" class="col s4 offset-s5"></div>
		</div>
<!-- END OF PAGINATOR 3000 -->


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