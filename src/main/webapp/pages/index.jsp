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
	href="${pageContext.servletContext.contextPath}/resources/css/rangeSlider/rangeStyle.css"
	rel="stylesheet">

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


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">

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
	<input id="lang" type="hidden" value="${language}" />

	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">
		<h4 style="text-align: center; margin-top: 20px;">
			<fmt:message key="index.search.header" />
		</h4>

		<!-- 		FORM START -->
		<form id="myForm" action="search" method="post">
			<input id="togler" type="hidden" name="togler" value="${togler}" />

			<div class="row">

				<div class="col s8 offset-s2">
					<input id="nam" type="text" class="validate" name="name"
						value="${name}"> <label id="nameLbl"
						data-error="${fmtName}" for="nam"><fmt:message
							key="index.search.name" /></label>
				</div>

				<div class="col s3 offset-s2">
					<input type="date" name="startDate" id="date_from"
						class="datepicker validate" onchange="checkDate()"
						value="${startDate}"><label id="startLbl"
						data-error="${fmtStart}" for="date_from"><fmt:message
							key="index.search.start" /></label>
				</div>

				<div class="col s3 offset-s2">
					<input type="date" name="endDate" id="date_to"
						class="datepicker validate" onchange="checkDate()"
						value="${endDate}"><label id="endLbl"
						data-error="${fmtEnd}" for="date_to"><fmt:message
							key="index.search.end" /></label>
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
					<input id="people" type="text" class="validate" name="people"
						value="${people}"> <label id="pplLbl"
						data-error="${fmtPeople}" for="pplCount"><fmt:message
							key="index.search.ppl" /></label>
				</div>



			</div>

			<div class="row">

				<div id="search_divider" class="divider"
					style="margin-bottom: 20px;"></div>

				<div id="togle_place" class="col s12" style="margin-top: 18px;">

					<div id="details_panel" style="display: none">

						<div class="row">

							<div class="col s4 offset-s1 ">

								<label id="room_type"> ROOM_TYPE </label>
								<p>
									<input type="checkbox" class="filled-in" id="typeStandart"
										name="typeStandart" /> <label for="typeStandart">STANDART</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="typeLux"
										name="typeLux" /> <label for="typeLux">LUX</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="typeDelux"
										name="typeDelux" /> <label for="typeDelux">DELUX</label>
								</p>


								<label id="room_type"> ROOM_FOOD </label>
								<p>
									<input type="checkbox" class="filled-in" id="foodNone"
										name="foodNone" /><label for="foodNone">NONE</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodBreakfast"
										name="foodBreakfast" /> <label for="foodBreakfast">BREAKFAST</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodTwice"
										name="foodTwice" /> <label for="foodTwice">TWICE</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodFull"
										name="foodFull" /> <label for="foodFull">FULL</label>
								</p>

							</div>

							<div class="col s4 offset-s2 ">

								<p style="margin-top: 20px;">
									<input type="checkbox" class="filled-in" id="hasWiFi"
										name="hasWiFi" /> <label for="hasWiFi">WIFI</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasShower"
										name="hasShower" /> <label for="hasShower">SHOWER</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasParking"
										name="hasParking" /> <label for="hasParking">PARKING</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasCondition"
										name="hasCondition" /> <label for="hasCondition">AIR
										CONDITION</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasPool"
										name="hasPool" /> <label for="hasPool">SWIM POOL</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasGym"
										name="hasGym" /> <label for="hasGym">FIT GYM</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasBalcony"
										name="hasBalcony" /> <label for="hasBalcony">BALCONY</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="noDeposit"
										name="noDeposit" /> <label for="noDeposit">NO DEPOSIT</label>
								</p>

							</div>

							<div class="col s1 offset-s1">
								<div class="rangePrint" id="printMinPrice">${minPrice}</div>
							</div>

							<div class="col s8">

								<label class="labelstyle"><fmt:message
										key="index.search.price" />PRICE</label>
								<section class="range-slider">
									<div id="priceSlider"></div>
								</section>

							</div>

							<div class="col s1">
								<div class="rangePrint" id="printMaxPrice">${maxPrice}</div>
							</div>


						</div>
					</div>
					<div class="row">
						<div class="col s10">
							<a id="togle" class="waves-effect waves-light btn"
								onclick="togle()"
								style="background: #26A69A; text-align: center; width: 100%; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><i
								id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x"
								aria-hidden="true" style="margin-left: 45%"></i></a>
						</div>
						<div class="col s2">
							<a id="search" class="waves-effect waves-light btn"
								onclick="searchForm()"
								style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">SEARCH</a>
						</div>


					</div>


				</div>

			</div>


			<input id="minStars" type="hidden" value="${minStars}" name="minStars" /> <input
				id="maxStars" type="hidden" value="${maxStars}" name="maxStars" /> 
				<input id="minPrice" type="hidden" value="${minPrice}" name="minPrice" />
				<input id="maxPrice" type="hidden" value="${maxPrice}" name="maxPrice" />
				<input id="minUserPrice" type="hidden" value="${minUserPrice}" name="minUserPrice" />
				<input id="maxUserPrice" type="hidden" value="${maxUserPrice}" name="maxUserPrice" />
			<!-- 				<input type="submit" value="Submit"> -->
		</form>

		<!-- 		FORM END -->

	</div>

	<div class="container">
		<h6>
			<c:if test="${countOfHotels > 0 }">
				<fmt:message key="card.header" />
				<span id="periodicals_number_for_all_users">${countOfHotels}</span>
			</c:if>
			<c:if test="${countOfHotels <= 0 }">
				<fmt:message key="card.no.hotels" />
			</c:if>
		</h6>


<!-- SWITCH CONTENT -->
		<div id="switchContent" class="row">
			<jsp:include page="card.jsp"></jsp:include>
		</div>

<!-- END OF SWITCH CONTENT -->

<!-- PAGINATOR 3000 -->
		<div id="paginationdemo" class="row">
			<div id="demo5" class="col s4 offset-s5"></div>
		</div>
<!-- END OFPAGINATOR 3000 -->
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


	<!-- 	VK MODAL LOADER -->
	<div id="modal1" class="modal"
		style="width: 25% !important; max-height: 40% !important">
		<div class="modal-content">
			<p>
				<img alt="Vk Log"
					src="http://1863x.com/wp-content/uploads/2016/01/vk-vkontakte-logo-vk.jpg"
					width="275px" height="200px;">
			</p>
			<div class="progress" style="width: 275px;">
				<div class="indeterminate"></div>
			</div>
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

					var token = window.location.hash.substr(1);
					$.post('vk_oauth', {
						token : token.split("&")[0].split("=")[1],
						user_id : token.split("&")[2].split("=")[1]
					}, function() {
						//NEED normal names
						document.location.href = '/booker/home';

					});
				});
			});
		</script>
	</c:if>
	<!--  END OF VK REDIRECT -->

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<!-- 	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>


	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/noUIslider/slider.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>

	<script>
		$('#typeStandart').attr('checked', '${typeStandart}' == 'true');
		$('#typeLux').attr('checked', '${typeLux}' == 'true');
		$('#typeDelux').attr('checked', '${typeDelux}' == 'true');

		$('#foodNone').attr('checked', '${foodNone}' == 'true');
		$('#foodBreakfast').attr('checked', '${foodBreakfast}' == 'true');
		$('#foodTwice').attr('checked', '${foodTwice}' == 'true');
		$('#foodFull').attr('checked', '${foodFull}' == 'true');

		$('#hasWiFi').attr('checked', '${hasWiFi}' == 'true');
		$('#hasShower').attr('checked', '${hasShower}' == 'true');
		$('#hasParking').attr('checked', '${hasParking}' == 'true');
		$('#hasCondition').attr('checked', '${hasCondition}' == 'true');

		$('#hasPool').attr('checked', '${hasPool}' == 'true');
		$('#hasGym').attr('checked', '${hasGym}' == 'true');
		$('#hasBalcony').attr('checked', '${hasBalcony}' == 'true');
		$('#noDeposit').attr('checked', '${noDeposit}' == 'true');

		var togler = $('#togler').val();
		if (togler == 'true') {
			$("#togle").click();
		}
		else {
			$('#togler').val("false");
		}
	</script>

	<script type="text/javascript">
		var pagesCount = '${countOfPages}';
		
		if (pagesCount > 1) {
			jQuery(function() {
				jQuery("#demo5").paginate({
					count : pagesCount,
					start : 1,
					display : 5,
					border : false,
					//		border_color			: '#fff',
					text_color : '#fff',
					background_color : '#26A69A',
					//		border_hover_color		: '#ccc',
					text_hover_color : '#000',
					background_hover_color : '#CFCFCF',
					images : false,
					mouse : 'press',
					onChange : function(page) {
						// 											$('._current','#paginationdemo').removeClass('_current').hide();
						// 											$('#p'+page).addClass('_current').show();
						findPage(window.location.href,page);
					}
				});
			});
		}
	</script>


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