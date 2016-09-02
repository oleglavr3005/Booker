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
</head>


<body>
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">
		<h4 style="text-align: center; margin-top: 20px;">
			<fmt:message key="index.search.header" />
		</h4>
		
		<form action="search" method="post">

		<div class="row">

			<div class="col s8 offset-s2">
				<input id="name" type="text" class="validate" name="name" value="${name}"> <label
					id="nameLbl" data-error="${fmtName}" for="name"><fmt:message
						key="index.search.name" /></label>
			</div>

			<div class="col s3 offset-s2">
				<label class="labelstyle"><fmt:message
						key="concrete.date.from" /></label> <input type="date" name="startDate" id="date_from"
					class="datepicker" onchange="checkDate()" value="${startDate}">
			</div>

			<div class="col s3 offset-s2">
				<label class="labelstyle"><fmt:message
						key="concrete.date.to" /></label> <input type="date" name="endDate" id="date_to"
					class="datepicker" onchange="checkDate()" value="${endDate}">
			</div>

		</div>

		<div class="row">

			<div class="col s3 offset-s2">
				<div class="container-fluid">
					<div class="row">
						<i id="star1" class="fa fa-star col s1 fa-2x" aria-hidden="true"></i>
						<i id="star2" class="fa fa-star col s1 offset-s1 fa-2x"
							aria-hidden="true"></i> <i id="star3"
							class="fa fa-star col s1 offset-s1 fa-2x" aria-hidden="true"></i>
						<i id="star4" class="fa fa-star col s1 offset-s1 fa-2x"
							aria-hidden="true"></i> <i id="star5"
							class="fa fa-star col s1 offset-s1 fa-2x" aria-hidden="true"></i>
					</div>

					<div class="row">
						<label class="labelstyle"><fmt:message
								key="index.search.price" /></label>

						<section class="range-slider">
							<div id="rangeSlider"></div>
						</section>
					</div>
				</div>
			</div>

			<div class="col s3 offset-s2">
				<input id="pplCount" type="text" class="validate" name="people" value="${people}"> <label
					id="pplLbl" data-error="${fmtPeople}" for="pplCount"><fmt:message
						key="index.search.ppl" /></label>
			</div>

			<div class="col s2 offset-s3" style="margin-top: 18px;">
				<a id="search" class="waves-effect waves-light btn"
					onclick="submit()" 
<%-- 					href="${pageContext.servletContext.contextPath}/search" --%>
					style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><fmt:message
						key="index.search.button" /></a>
			</div>

		</div>

		<div class="row">

			<div id="search_divider" class="divider" style="margin-bottom: 20px;"></div>

			<div id="togle_place" class="col s12" style="margin-top: 18px;">

				<div id="details_panel" style="display: none">

					<div class="row">

						<div class="col s4 offset-s1 ">
						
						<script>
						var a = '${typeStandart}';
						alert(a);
						alert('${typeLux}');
						</script>

							<label id="room_type"> ROOM_TYPE </label>
							<p>
								<input type="checkbox" class="filled-in" id="room_standart" name="room_standart" value="${typeStandart}"/> <label
									for="room_standart">STANDART</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="room_lux" name="room_lux" value="${typeLux}"/> <label
									for="room_lux">LUX</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="room_delux" name="room_delux" value="${typeDelux}"/> <label
									for="room_delux">DELUX</label>
							</p>


							<label id="room_type"> ROOM_FOOD </label>
							<p>
								<input type="checkbox" class="filled-in" id="food_none" name="food_none" value="${foodNone}"/> <label
									for="food_none">NONE</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="food_breakfast" name="food_breakfast" value="${foodBreakfast}"/>
								<label for="food_breakfast">BREAKFAST</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="food_twice" name="food_twice" value="${foodTwice}"/> <label
									for="food_twice">TWICE</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="food_full" name="food_full" value="${foodFull}" /> <label
									for="food_full">FULL</label>
							</p>

						</div>

						<div class="col s4 offset-s2 ">

							<p style="margin-top: 20px;">
								<input type="checkbox" class="filled-in" id="wifi" name="wifi" value="${hasWiFi}"/> <label
									for="wifi">WIFI</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="shower" name="shower" value="${hasShower}"/> <label
									for="shower">SHOWER</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="parking" name="parking" value="${hasParking}"/> <label
									for="parking">PARKING</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="condition" name="condition" value="${hasCondition}"/> <label
									for="condition">AIR CONDITION</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="pool" name="pool" value="${hasPool}"/> <label
									for="pool">SWIM POOL</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="gym" name="gym" value="${hasGym}"/> <label
									for="gym">FIT GYM</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="balcony" name="balcony" value="${hasBalcony}" /> <label
									for="balcony">BALCONY</label>
							</p>
							<p>
								<input type="checkbox" class="filled-in" id="no_deposit" name="no_deposit" value="${noDeposit}" /> <label
									for="no_deposit">NO DEPOSIT</label>
							</p>

						</div>



						<div class="col s8 offset-s2 ">

							<label class="labelstyle"><fmt:message
									key="index.search.price" />PRICE</label>
							<section class="range-slider">
								<div id="priceSlider"></div>
							</section>

						</div>

					</div>
				</div>

				<a id="togle" class="waves-effect waves-light btn" onclick="togle()"
					style="background: #26A69A; text-align: center; width: 100%; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><i
					id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true"
					style="margin-left: 45%"></i></a>
			</div>

		</div>
		
		
	<input id="minStars" type="hidden" value="1"
		 name="minStars"/>
	<input id="maxStars" type="hidden" value="5"
		 name="maxStars"/>
	<input id="minPrice" type="hidden" value="0"
		 name="minPrice"/>
	<input id="maxPrice" type="hidden" value="100"
		 name="maxPrice"/>
		

 	 <input type="submit" value="Submit">
	</form>

	</div>



	<div class="container">
		<div id="switchContent" class="row">
			<jsp:include page="card.jsp"></jsp:include> 
		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


<!-- 	VK MODAL LOADER -->
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
<!-- 	END OF VK MODAL LOADER -->


<!-- 	VK REDIRECT -->
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
<!--  END OF VK REDIRECT -->



		
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>
		
		
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/noUIslider/slider.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
		

<!-- 	DATEPICKER -->
<!-- 	<script type="text/javascript"> -->
<!--/ 	$(document).ready(function() {
// 		$('.datepicker').pickadate({
// 			    selectMonths: true, // Creates a dropdown to control month
// 			    selectYears: 15 // Creates a dropdown of 15 years to control year
// 		});
// 	});
<!-- 	</script> -->
	
	
</body>

</html>