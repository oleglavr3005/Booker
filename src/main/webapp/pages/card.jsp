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
			<div class="card-image" style="position: relative;">
				<c:choose>

					<c:when test="${periodical.sale > 0}">
						<a
							href="${pageContext.servletContext.contextPath}/periodical/${periodical.id}">
							<img class="my-card-img${periodical.id}"
							src="<i:urlToImage url="${periodical.image}" />"
							style="height: 250px; width: 230px; padding: 10px;">
						</a>
						<img class="my-card-img-sale${periodical.id}"
							src="${pageContext.servletContext.contextPath}/resources/images/sale.png"
							style="position: absolute; width: 40px; height: 40px; margin-top: 7px;">
						<script>
							var width = $('.my-card-img${periodical.id}')
									.width();
							$('.my-card-img-sale${periodical.id}').css(
									'margin-left', width - 30 + 'px');
						</script>

						<c:if test="${userState == 'user' && periodical.userId != '0'}">
							<img
								src="${pageContext.servletContext.contextPath}/resources/images/bookmark.png"
								style="position: absolute; width: 40px; height: 40px; margin-top: 8px; margin-left: 6px;">

						</c:if>

					</c:when>

					<c:otherwise>
						<c:choose>

							<c:when test="${userState == 'user' && periodical.userId != '0'}">
								<a
									href="${pageContext.servletContext.contextPath}/periodical/${periodical.id}">
									<img src="<i:urlToImage url="${periodical.image}" />"
									style="height: 250px; width: 230px; padding: 10px;">
								</a>
								<img
									src="${pageContext.servletContext.contextPath}/resources/images/bookmark.png"
									style="position: absolute; width: 40px; height: 40px; margin-top: 8px; margin-left: 6px;">
								<%-- 							</c:if> --%>
							</c:when>

							<c:otherwise>
								<a
									href="${pageContext.servletContext.contextPath}/periodical/${periodical.id}">
									<img src="<i:urlToImage url="${periodical.image}" />"
									style="height: 250px; width: 230px; padding: 10px;">
								</a>
							</c:otherwise>

						</c:choose>
					</c:otherwise>

				</c:choose>

			</div>


			<div class="card-content"
				style="margin-top: -10px; height: auto; padding-top: 10px;">
				<h6>
					<a
						href="${pageContext.servletContext.contextPath}/periodical/${periodical.id}">${periodical.name}</a>
					<c:if test="${userState == 'user'}">
						<c:choose>
							<%-- 						<c:when test="${userState != 'admin'}"> --%>
							<%-- 							<c:choose> --%>
							<c:when test="${periodical.status == 'ACTIVE'}">
								<br>
								<div style="color: green">
									<fmt:message key="card.status.active" />
								</div>
							</c:when>
							<c:when test="${periodical.status == 'REMOVED'}">
								<br>
								<div style="color: grey">
									<fmt:message key="card.status.removed" />
								</div>
							</c:when>
							<c:otherwise>
								<br>
								<div style="color: red">
									<fmt:message key="card.status.notactive" />
								</div>
							</c:otherwise>
							<%-- 							</c:choose> --%>
							<%-- 						</c:when> --%>
						</c:choose>
					</c:if>

				</h6>

				<div class="my-card-item">
					<i class="fa fa-lg fa-copyright" aria-hidden="true"></i> <b><fmt:message
							key="card.content.publisher" /> : </b>
					<div style="padding-left: 26px; font-size: 16px;">${periodical.publisher}</div>
				</div>

				<c:choose>
					<c:when test="${language == 'en'}">
						<div class="my-card-item">
							<i class="fa fa-lg fa-bars" aria-hidden="true"></i> <b><fmt:message
									key="card.content.genre" /> : </b>
							<div style="display: inline-block; font-size: 16px; !important">
								${periodical.genre}</div>
						</div>

					</c:when>
					<c:otherwise>
						<div class="my-card-item">
							<i class="fa fa-lg fa-bars" aria-hidden="true"></i> <b><fmt:message
									key="card.content.genre" /> : </b>
							<div style="display: inline-block; font-size: 16px; !important">
								${periodical.genreUk}</div>
						</div>

					</c:otherwise>
				</c:choose>

				<div class="my-card-item">
					<i class="fa fa-lg fa-star" aria-hidden="true"></i> <b><fmt:message
							key="card.content.rating" /> : </b>
					<div style="display: inline-block; font-size: 16px;">${periodical.score}</div>
				</div>

				<div class="my-card-item">
					<i class="fa fa-lg fa-refresh" aria-hidden="true"></i> <b><fmt:message
							key="card.content.period" /> : </b>
					<div style="display: inline-block; font-size: 16px;">
						${periodical.period}</div>
				</div>

				<div class="my-card-item">
					<i class="fa fa-lg fa-money" aria-hidden="true"></i> <b
						style="margin-left: 5px;"><fmt:message
							key="card.content.price" /> : </b>
					<div style="display: inline-block; font-size: 16px;">
						${periodical.price}</div>
					<fmt:message key="card.content.money" />
				</div>
			</div>

			<c:if test="${userState == 'user'}">
				<!-- =================================================================== -->
				<fmt:message key="card.bookmark.on" var="fmtOn" />

				<fmt:message key="card.bookmark.off" var="fmtOff" />

				<fmt:message key="card.status.active" var="fmtActive" />

				<fmt:message key="card.status.notactive" var="fmtNotActive" />
				<!-- =================================================================== -->


				<c:choose>
					<c:when test="${periodical.userId != '0'}">
						<div id='card_bookmark_${periodical.id}' class="card-action">
							<a href="#!" style="color: green"
								onclick="removeBookmark(${periodical.id}, '${fmtOn}', '${fmtOff}',false)"><fmt:message
									key="card.bookmark.on" /><img
								src="${pageContext.servletContext.contextPath}/resources/images/success.png"
								style="position: width: 15px; height: 35px;"></a>
						</div>
					</c:when>
					<c:otherwise>
						<div id='card_bookmark_${periodical.id}' class="card-action">
							<a href="#!"
								onclick="addBookmark(${periodical.id}, '${fmtOn}', '${fmtOff}',false)"><fmt:message
									key="card.bookmark.off" /><img
								src="${pageContext.servletContext.contextPath}/resources/images/on_future.png"
								style="position: width: 15px; height: 35px;"></a>
						</div>
					</c:otherwise>
				</c:choose>
			</c:if>

			<c:if test="${userState == 'admin'}">
				<div id='card_bookmark_${periodical.id}' class="card-action"
					style="height: 30px; padding: 5px 5px 5px 10px;">
					<div class="row">
						<span id="publish_status_${periodical.id}"
							class="col s4 offset-s2" style="text-align: center;"> <c:choose>
								<c:when test="${periodical.status == 'ACTIVE'}">
									<a onclick="setStatus(${periodical.id}, false, '${language}')"
										href="#!" style="color: green;"><fmt:message
											key="card.status.active" /></a>
								</c:when>
								<c:when test="${periodical.status == 'NOT_ACTIVE'}">
									<a onclick="setStatus(${periodical.id}, true, '${language}')"
										href="#!" style="color: red;"><fmt:message
											key="card.status.notactive" /></a>
								</c:when>
								<c:otherwise>
									<a style="color: grey;"><fmt:message
											key="card.status.removed" /></a>
								</c:otherwise>
							</c:choose>
						</span>
					</div>

				</div>
			</c:if>


		</div>
	</div>
</c:forEach>

<c:if test="${userState == 'admin'}">
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/index.js"
		type="text/javascript"></script>
</c:if>