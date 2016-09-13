<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.servletContext.contextPath}/resources/css/styleMap.css" rel="stylesheet">

<c:choose>
	<c:when test="${user != null}">
		<c:if test="${user.language == 'ua'}">
			<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?language=uk&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU"></script>
		</c:if>
		<c:if test="${user.language == 'en'}">
			<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?language=en&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU"></script>
		</c:if>
	</c:when>
	<c:otherwise>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js??language=en&key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU"></script>
	</c:otherwise>
</c:choose>

<script>
	hotelsJson = [ 
	<c:forEach var="hotel" items="${hotels}">
	    {"id" : "<c:out value="${hotel.id}"></c:out>",
		"name" : "<a href='${pageContext.servletContext.contextPath}/hotel/${hotel.id}'><c:out value="${hotel.name}"></c:out></a>",
		"photo" : "/booker/get_image/${hotel.photos[0].img}",
		"address" : "<c:out value="${hotel.city}"></c:out> <c:out value="${hotel.street}"></c:out>",
		"phone" : "<c:out value="${hotel.phoneNumber}"></c:out>",
		"lat" : "<c:out value="${hotel.XCoord}"></c:out>",
		"lon" : "<c:out value="${hotel.YCoord}"></c:out>"},
	</c:forEach>
	    ];

	(function() {
		var flag = 0;
		var fladTwo = 0;
		jQuery('#google_map').hide();
		jQuery('#hotel_map_button').on('click', function() {
			if (flag == 0) {
				jQuery('#google_map').slideDown(500);
				flag = 1;
				if (fladTwo == 0) {
					setTimeout(map_initialize, 500);
					fladTwo = 1;
				}
			} else {
				jQuery('#google_map').slideUp(500);
				flag = 0;
			}
		});
		jQuery('#map_button').on('click', function() {
			if (flag == 0) {
				jQuery('#google_map').slideDown(500);
				flag = 1;
				if (fladTwo == 0) {
					setTimeout(map_initialize, 500);
					fladTwo = 1;
				}
			} else {
				jQuery('#google_map').slideUp(500);
				flag = 0;
			}
		});
	})();
</script>
<script	src="${pageContext.servletContext.contextPath}/resources/js/map/showPointsOnMap.js"></script>

<div class="col s12" style="margin-top: 18px; padding: 0;">
	<div id="google_map" style="height: 400px; width: 83%;"></div>
</div>
