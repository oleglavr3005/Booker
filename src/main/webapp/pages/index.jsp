<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<!-- 		FORM START -->
	<form id="myForm" action="search" method="post">
		<div class="row">
			<div class="col s5 offset-s1">
				<h4 style="text-align: center; margin-top: 20px;">
					<span id="index_search_header"></span>
				</h4>
				<input id="togler" type="hidden" name="togler" value="${togler}" />
				<div class="row">
					<div class="input-field col s12">
						<input id="nam" type="text" class="validate" name="name"
							value="${name}"> <label id="nameLbl"
							data-error="${fmtName}" for="nam"><span
							id="index_search_name"></span> </label>
					</div>
					<div class="input-field col s6">
						<input type="text" name="startDate" id="date_from"
							class="datepicker validate" onchange="onDate()"
							style="cursor: default;" value="${startDate}"><label
							id="startLbl" data-error="${fmtStart}" for="date_from"><span
							id="index_search_start"></span></label>
					</div>
					<div class="input-field col s6">
						<input type="text" name="endDate" id="date_to"
							onchange="onEndDate()" class="datepicker validate"
							style="cursor: default;" value="${endDate}"><label
							id="endLbl" data-error="${fmtEnd}" for="date_to"><span
							id="index_search_end"></span></label>
					</div>
				</div>
				<div class="row">
					<div class="col s6">
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
								<label class="labelstyle"><span id="index_search_price"></span></label>

								<section class="range-slider">
									<div id="rangeSlider"></div>
								</section>
							</div>
						</div>
					</div>
					<div class="input-field col s6">
						<input id="people" value="${people}" type="number"
							class="rating validate" name="people" min=1 max=1000>
						<!-- 					<input id="" type="text" class=""  -->
						<!-- 						value="">  -->
						<label id="pplLbl" data-error="${fmtPeople}" for="pplCount"><span
							id="index_search_ppl"></span></label>
					</div>
				</div>
				<input id="minStars" type="hidden" value="${minStars}"
					name="minStars" /> <input id="maxStars" type="hidden"
					value="${maxStars}" name="maxStars" /> <input id="minPrice"
					type="hidden" value="${minPrice}" name="minPrice" /> <input
					id="maxPrice" type="hidden" value="${maxPrice}" name="maxPrice" />
				<input id="minUserPrice" type="hidden" value="${minUserPrice}"
					name="minUserPrice" /> <input id="maxUserPrice" type="hidden"
					value="${maxUserPrice}" name="maxUserPrice" />
				<!-- 				<input type="submit" value="Submit"> -->
			</div>
			<div class="col s5" style="height: 320px;">
				<!-- MAP ========================================================================== -->
				<jsp:include page="map.jsp"></jsp:include>
				<!-- MAP End======================================================================= -->
			</div>
		</div>
		<div class="container">
			<div id="search_divider" class="divider" style="margin-bottom: 20px;"></div>
			<div id="togle_place" class="col s12" style="margin-top: 18px;">
				<div id="details_panel" style="display: none">
					<div class="row">
						<div class="row">
							<div class="col s4 offset-s2">

								<h6 id="room_type" style="margin-bottom: 15px;"></h6>
								<p>
									<input type="checkbox" class="filled-in" id="typeStandart"
										name="typeStandart" /> <label id="index_room_type_standart"
										for="typeStandart"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="typeLux"
										name="typeLux" /> <label id="index_room_type_lux"
										for="typeLux"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="typeDelux"
										name="typeDelux" /> <label id="index_room_type_delux"
										for="typeDelux"></label>
								</p>
								<h6 id="room_food" style="margin-bottom: 15px;"></h6>
								<p>
									<input type="checkbox" class="filled-in" id="foodNone"
										name="foodNone" /><label id="index_room_type_food_none"
										for="foodNone"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodBreakfast"
										name="foodBreakfast" /> <label
										id="index_room_type_food_breakfast" for="foodBreakfast">BREAKFAST</label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodTwice"
										name="foodTwice" /> <label id="index_room_type_food_twice"
										for="foodTwice"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="foodFull"
										name="foodFull" /> <label id="index_room_type_food_full"
										for="foodFull">Full</label>
								</p>

							</div>
							<div class="col s4 offset-s2 ">

								<p style="margin-top: 20px;">
									<input type="checkbox" class="filled-in" id="hasWiFi"
										name="hasWiFi" /> <label id="label_wifi" for="hasWiFi"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasShower"
										name="hasShower" /> <label id="label_shower" for="hasShower"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasParking"
										name="hasParking" /> <label id="label_parking"
										for="hasParking"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasCondition"
										name="hasCondition" /> <label id="label_condition"
										for="hasCondition"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasPool"
										name="hasPool" /> <label id="label_pool" for="hasPool"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasGym"
										name="hasGym" /> <label id="label_gym" for="hasGym"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="hasBalcony"
										name="hasBalcony" /> <label id="label_balcony"
										for="hasBalcony"></label>
								</p>
								<p>
									<input type="checkbox" class="filled-in" id="noDeposit"
										name="noDeposit" /> <label id="index_room_noDeposit"
										for="noDeposit"></label>
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col s2" style="width: 12%;">
								<div class="rangePrint" id="printMinPrice" style="">
									<%-- 									${minPrice} --%>
									<input onchange="updateMinPrice()" id="inputPrintMinPrice"
										type="number" name="inputPrintMinPrice" value="${minPrice}"
										min="${minPrice}" max="${maxPrice}"
										style="margin-bottom: 0px; text-align: center; margin-top: -5px; height: 1.5rem;">
								</div>
							</div>
							<div class="col s8">
								<label class="labelstyle"> <span
									id="index_search_price_2"></span>
								</label>
								<section class="range-slider">
									<div id="priceSlider"></div>
								</section>
							</div>
							<div class="col s2" style="width: 12%;">
								<div class="rangePrint" id="printMaxPrice">
									<%-- 									${maxPrice} --%>
									<input onchange="updateMaxPrice()" id="inputPrintMaxPrice"
										type="number" name="inputPrintMaxPrice" min="${minPrice}"
										max="${maxPrice}" value="${maxPrice}"
										style="margin-bottom: 0px; text-align: center; margin-top: -5px; height: 1.5rem;">
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="row">
					<div class="col s9">
						<!-- onclick="togle()" -->
						<a id="togle" class="waves-effect waves-light btn"
							style="background: #26A69A; text-align: center; width: 100%; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><i
							id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x"
							aria-hidden="true" style="margin-left: 45%"></i></a>
					</div>
					<div class="col s3">
						<a id="search" class="waves-effect waves-light btn"
							onclick="searchForm()"
							style="width: 100%; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"></a>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 		FORM END -->

	<div class="container">
		<div class="row">
			<div class="col s3">
				<h6>
					<c:if test="${countOfHotels > 0 }">
						<span id="card_header"> </span>
						<span id="periodicals_number_for_all_users">${countOfHotels}</span>
					</c:if>
				</h6>
			</div>
			<div class="col s5 offset-s4">
				<c:if test="${countOfHotels > 0 }">
					<div style="float: right">
					<span class="sort_by" style="font-size: 15; position: relative; /* display: inline-block; */ bottom: 3px;"></span>
					<select id="compare" class="chosen-select optionstyle"
						onchange="findPage(window.location.href,1)">
						<option id="index_option_star_asc" class="optionstyle"
							value="compareByStarsAsc"></option>
						<option id="index_option_star_desc" class="optionstyle"
							value="compareByStarsDesc"></option>
						<option id="index_option_rating_asc" class="optionstyle"
							value="compareByRatingAsc"></option>
						<option id="index_option_rating_desc" class="optionstyle"
							value="compareByRatingDesc" selected="selected"></option>
					</select>
					</div>
				</c:if>
			</div>
		</div>


		<!-- SWITCH CONTENT -->
		<div id="switchContent" class="row">
			<jsp:include page="card.jsp"></jsp:include>
		</div>
		<!-- END OF SWITCH CONTENT -->


	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<!-- 	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>


	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/noUIslider/slider.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/details.js"></script>
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
		/* 
		 var togler = $('#togler').val();
		 if (togler == 'true') {
		 $("#togle").click();
		 }
		 else {
		 $('#togler').val("false");
		 }  */
	</script>

	<script>
		(function() {
			var flag = 0;
			jQuery('#details_panel').hide();
			$('#togler').val("false");
			jQuery('#togle').on('click', function() {
				if (flag == 0) {
					jQuery('#details_panel').slideDown(500);
					jQuery('#arrow_icon').css("transform", "rotate(180deg)");
					$('#togler').val("true");
					flag = 1;
				} else {
					jQuery('#details_panel').slideUp(500);
					jQuery('#arrow_icon').css("transform", "rotate(0deg)");
					$('#togler').val("false");
					flag = 0;
				}
			});
		})();

		(function() {
			map_initialize();
		})();
	</script>

	<!-- 	DATEPICKER -->
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/picker.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/picker.date.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/datepicker/datepicker.js"></script>


</body>

</html>