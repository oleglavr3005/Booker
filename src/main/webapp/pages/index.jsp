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
<title>Periodical</title>


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

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script type="text/javascript">
	function getVals() {
		// Get slider values
		var parent = this.parentNode;
		var slides = parent.getElementsByTagName("input");
		var slide1 = parseFloat(slides[1].value);
		var slide2 = parseFloat(slides[2].value);
		// Neither slider will clip the other, so make sure we determine which is larger
		if (slide1 > slide2) {
			var tmp = slide2;
			slide2 = slide1;
			slide1 = tmp;
		}

		var displayElement = parent.getElementsByClassName("rangeValues")[0];
		displayElement.innerHTML = slide1 + " - " + slide2;
	}

	window.onload = function() {
		// Initialize Sliders
		var sliderSections = document.getElementsByClassName("range-slider");
		for (var x = 0; x < sliderSections.length; x++) {
			var sliders = sliderSections[x].getElementsByTagName("input");
			for (var y = 0; y < sliders.length; y++) {
				if (sliders[y].type === "range") {
					sliders[y].oninput = getVals;
					// Manually trigger event first time to display values
					sliders[y].oninput();
				}
			}
		}
	}
</script>


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

}
.side-img {
/* 	background: */
/* 		url('http://iphonewalls.net/wp-content/uploads/2012/06/Wooden%20Planks%20iPhone%20Wallpaper.jpg') */
background:
		url(${pageContext.servletContext.contextPath}/resources/images/side.jpg)
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

}
.well {
	padding: 0px;
}

/*  sidebar styles  */
ul.sidebar-nav li a {
	font-weight: bold;
	font-size: 17px;
}

ul.sidebar-nav li a:hover {
	background-color: #fff;
	color: black;
}

ul.sidebar-nav li a i {
	float: right;
	margin-top: 11.5px;
	margin-right: 35px;
}

ul.sidebar-nav li a:hover i {
	color: black;
}

ul.sidebar-nav li.sidebar-brand a i {
	float: right;
	margin-top: 21.5px;
	margin-right: 45px;
}

ul.sidebar-nav li.sidebar-brand a:hover {
	background-color: lightgrey;
	color: black;
}

ul.sidebar-nav li.sidebar-brand a:hover i {
	color: black;
}
/*  end of sidebar styles  */

/* styles for 2xslider */
section.range-slider {
	position: relative;
	width: 200px;
	height: 35px;
	text-align: center;
}

section.range-slider input {
	pointer-events: none;
	position: absolute;
	overflow: hidden;
	left: 0;
	top: 15px;
	width: 220px;
	outline: none;
	height: 18px;
	margin: 0;
	padding: 0;
}

section.range-slider input::-webkit-slider-thumb {
	pointer-events: all;
	position: relative;
	z-index: 1;
	outline: 0;
}

section.range-slider input::-moz-range-thumb {
	pointer-events: all;
	position: relative;
	z-index: 10;
	-moz-appearance: none;
	width: 9px;
}

section.range-slider input::-moz-range-track {
	position: relative;
	z-index: -1;
	background-color: rgba(0, 0, 0, 1);
	border: 0;
}

section.range-slider input:last-of-type::-moz-range-track {
	-moz-appearance: none;
	background: none transparent;
	border: 0;
}

section.range-slider input[type=range]::-moz-focus-outer {
	border: 0;
}

/* end of slider styles */
</style>
</head>


<body>
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->


<!-- 	<div id="wrapper" style="position: relative; min-height: 100%;"> -->


		<!-- SideBar ========================================================================= -->
<%-- 		<jsp:include page="side.jsp"></jsp:include> --%>
		<!-- SideBar End====================================================================== -->


		<div class="container">
			<h4 style="text-align: center; margin-top: 20px;">
				<fmt:message key="index.search.header" />
			</h4>

			<div class="row">

				<div class="col s2">
					<label class="labelstyle"><fmt:message
							key="index.search.publisher" /></label> <select id="search_publisher"
						class="chosen-select optionstyle">
						<option class="optionstyle"><fmt:message
								key="index.search.publisher" /></option>
						<c:forEach var="publishment" items="${publishments}">
							<option class="optionstyle">${publishment}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col s2 offset-s3">
					<label class="labelstyle"><fmt:message
							key="index.search.genre" /></label> <select id="search_genre"
						class="chosen-select optionstyle">
						<option class="optionstyle"><fmt:message
								key="index.search.genre" /></option>
						<c:choose>
							<c:when test="${language == 'en'}">
								<c:forEach var="genre" items="${genres}">
									<option class="optionstyle">${genre}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="genre" items="${genresUk}">
									<option class="optionstyle">${genre}</option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>

			</div>

			<div class="row">

				<div class="col s2">
					<label class="labelstyle"><fmt:message
							key="index.search.price" /></label>

					<section class="range-slider">
						<!-- 						<span class="rangeValues"></span>  -->
						<input id="min_price" value="${minPrice}" min="${minPrice}"
							max="${maxPrice}" step="1" type="range"> <input
							id="max_price" value="${maxPrice}" min="${minPrice}"
							max="${maxPrice}" step="1" type="range">
					</section>

				</div>

				<div class="col s2 offset-s3">
					<label class="labelstyle"><fmt:message
							key="index.search.period" /></label> <select id="search_duraion"
						class="chosen-select optionstyle">
						<option class="optionstyle"><fmt:message
								key="index.search.period" /></option>
						<option class="optionstyle">7
							<fmt:message key="index.search.days" /></option>
						<option class="optionstyle">14
							<fmt:message key="index.search.days" /></option>
						<option class="optionstyle">30
							<fmt:message key="index.search.days" /></option>
					</select>
				</div>
				
				<div class="col s2 offset-s3" style="margin-top: 18px;">
					<a id="search" class="waves-effect waves-light btn"
						onclick="searchPeriodicals()"
						style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
							key="index.search.button" /></a>
				</div>

			</div>

		</div>



		<div class="container">
			<div id="switchContent" class="row">
<%-- 				<jsp:include page="card.jsp"></jsp:include> --%>
			</div>
		</div>


<!-- 	</div> -->



	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<div id="modal1" class="modal" style="width: 25% !important ; max-height: 40% !important ">
		<div class="modal-content">
			<!-- 			<h4>VK auth</h4> -->
			<p>
				<img alt="Vk Log"
					src="http://1863x.com/wp-content/uploads/2016/01/vk-vkontakte-logo-vk.jpg" width ="275px" height = "200px;">
			</p>
			<div class="progress" style="width:275px;">
					<div class="indeterminate"></div>
				</div>
<!-- 			<div class="modal-footer"> -->
				
<!-- 			</div> -->
		</div>

	</div>

	<script>
		$("#ex2").slide({});
	</script>

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


</body>

</html>