<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>My feedback</title>

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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

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
</head>

<body>
	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="min-height: 345px;">


		<div class="row" style="padding-top: 30px; margin: 0;">
			<div class="col s3 offset-s1">
				<h6 style="font-size: 1.2rem;">
					<c:if test="${countOfFeedbacks > 0 }">
						<span id="myfeedbacks_header"> </span>
						<span id="myfeedbacks_count_of_feedbacks">${countOfFeedbacks}</span>
					</c:if>
					<c:if test="${countOfFeedbacks <= 0 }">
						<span id="myfeedbacks_no_feedbacks"></span>
					</c:if>
				</h6>
			</div>
			<div class="col s5 offset-s2" >
				<div style="float: right;">
					<c:if test="${countOfFeedbacks > 0 }">
					<span class="sort_by"
						style="font-size: 15; position: relative; /* display: inline-block; */ bottom: 3px;"></span>
						<select id="compare" class="chosen-select optionstyle"
							onchange="findPage(window.location.href,1)">
							<option id="shoping_card_date_asc" class="optionstyle"
								value="compareByDateAsc"></option>
							<option id="shoping_card_date_desc" class="optionstyle"
								value="compareByDateDesc" selected="selected"></option>
						</select>
					</c:if>
				</div>
			</div>
		</div>


		<div id="switchContent" class="row" style="margin-bottom: 0;">
			<jsp:include page="feedbacks.jsp"></jsp:include>
		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->




	<!-- IMPORTED -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<!-- END OF IMPORTED -->
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/feedback.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>


	<script
		src="${pageContext.servletContext.contextPath}/resources/js/customerSlider.js">
		$(document).ready(function() {
			$(".date_posted").each(function(index, element) {
				var date = element.innerText;
				date = date.substring(0, date.lastIndexOf(':'));
				element.textContent = date;
			});
		});
	</script>

</body>
</html>