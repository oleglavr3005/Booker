<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>

<html lang="en">

<head>

<meta charset="utf-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>SHOPPING CART</title>

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
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->
	<script>
		$(document).ready(function() {
			jQuery.noConflict();
		});
	</script>
	<div class="container">
		<h4 style="text-align: center; margin-top: 20px;">
			<span class="user_cart_header"></span>
		</h4>
		<c:if test="${countOfOrders <= 0 }">
			<h6 class="shopping_card_notice" style="margin-top: 20px;"></h6>
		</c:if>
		<!-- <div class="row"><span id="shoping_card_shop_list"></span></div> -->
		<div class="row">
			<div class="col s3">
				<h6>
					<c:if test="${countOfOrders > 0 }">
						<span class="card_header"></span>
						<span id="periodicals_number_for_all_users">${countOfOrders}</span>
					</c:if>
				</h6>
			</div>
			<div class="col s5 offset-s4">
				<c:if test="${countOfOrders > 0 }">
					<span class="sort_by" style="font-size: 15;position: relative;/* display: inline-block; */bottom: 3px;"></span>
					<select id="compare" class="chosen-select optionstyle"
						onchange="findPage(window.location.href,1)">
						<option id="shoping_card_date_asc" class="optionstyle"
							value="compareByDateAsc"></option>
						<option id="shoping_card_date_desc" class="optionstyle"
							value="compareByDateDesc" selected="selected"></option>
						<option id="shoping_card_price_asc" class="optionstyle"
							value="compareByPriceAsc"></option>
						<option id="shoping_card_price_desc" class="optionstyle"
							value="compareByPriceDesc"></option>
					</select>
				</c:if>
			</div>
		</div>



		<!-- SWITCH CONTENT -->
		<div id="switchContent" class="row">
			<jsp:include page="../orderCard.jsp"></jsp:include>
		</div>

		<!-- END OF SWITCH CONTENT -->



		<!-- TEST ZONE -->

<!-- 		<div class="row"> -->
<!-- 			<div class="col s2 offset-s1"> -->
<!-- 				<a class="waves-effect waves-light btn" -->
<!-- 					style="background: #26A69A; color: #FFFFFF;" -->
<!-- 					onclick="testFunction(0)">0</a> -->
<!-- 			</div> -->
<!-- 			<div class="col s2 offset-s1"> -->
<!-- 				<a class="waves-effect waves-light btn" -->
<!-- 					style="background: #26A69A; color: #FFFFFF;" -->
<!-- 					onclick="testFunction(1)">1</a> -->
<!-- 			</div> -->
<!-- 			<div class="col s2 offset-s1"> -->
<!-- 				<a class="waves-effect waves-light btn" -->
<!-- 					style="background: #26A69A; color: #FFFFFF;" -->
<!-- 					onclick="testFunction(2)">2</a> -->
<!-- 			</div> -->
<!-- 			<div class="col s2 offset-s1"> -->
<!-- 				<a class="waves-effect waves-light btn" -->
<!-- 					style="background: #26A69A; color: #FFFFFF;" -->
<!-- 					onclick="testFunction(3)">3</a> -->
<!-- 			</div> -->
<!-- 		</div> -->


<!-- 		<script type="text/javascript" -->
<%-- 			src="${pageContext.servletContext.contextPath}/resources/js/test/recommendModal.js"></script> --%>


		<!-- END OF TEST ZONE -->




	</div>

	<!-- SUCCES MODAL  -->
	<div id="modal1" class="modal"
		style="width: 50% !important; max-height: 80% !important">
		<div class="modal-header" style="padding-bottom: 0px">
			<h4 id="registrationHeader">
				<span id="shopping_cart_modal_header"></span>
			</h4>
		</div>
		<div class="modal-content">
			<div class="container-fluid" id="modalContainer">

				<div class="row" id="empty" style="display: none">
					<img alt="thank you for order"
						src="http://localhost:8080/booker/resources/images/order1.jpg"
						class="img-responsive center-block"
						style="max-width: 150px; max-height: 150px; margin-bottom: 10px; margin-top: 30px">
				</div>



				<div class="row" id="row0" style="display: none">
					<div class="col s4">
						<a id="href01" href="http://localhost:8080/booker/hotel/"> <img
							id="img0" src="<i:urlToImage url="new_hotel.jpg" />"
							style="height: 110px; width: 150px;">
						</a>
					</div>
					<div class="col s6">
						<div class="row" style="margin-top: 15px; margin-bottom: 10px">
							<div class="col s5">
								<a id="href02" href="http://localhost:8080/booker/hotel/"><span
									id="hotelName0"></span></a>
							</div>
							<div class="col s6 offset-s1">
								<i id="00" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="01" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="02" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="03" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="04" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="row">
							<i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i><span
								id="location0"></span>
						</div>
					</div>
				</div>



				<div class="row" id="row1" style="display: none">
					<div class="col s4">
						<a id="href11" href="http://localhost:8080/booker/hotel/"> <img
							id="img1"
							<%-- 							src="<i:urlToImage url="new_hotel.jpg" />" --%>
							style="height: 110px; width: 150px;">
						</a>
					</div>
					<div class="col s6">
						<div class="row" style="margin-top: 15px; margin-bottom: 10px">
							<div class="col s5">
								<a id="href12" href="http://localhost:8080/booker/hotel/"><span
									id="hotelName1"></span></a>
							</div>
							<div class="col s6 offset-s1">
								<i id="10" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="11" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="12" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="13" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="04" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="row">
							<i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i><span
								id="location1"></span>
						</div>
					</div>
				</div>



				<div class="row" id="row2" style="display: none">
					<div class="col s4">
						<a id="href21" href="http://localhost:8080/booker/hotel/"> <img
							id="img2" src="<i:urlToImage url="new_hotel.jpg" />"
							style="height: 110px; width: 150px;">
						</a>
					</div>
					<div class="col s6">
						<div class="row" style="margin-top: 15px; margin-bottom: 10px">
							<div class="col s5">
								<a id="href22" href="http://localhost:8080/booker/hotel/"><span
									id="hotelName2"></span></a>
							</div>
							<div class="col s6 offset-s1">
								<i id="20" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="21" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="22" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="23" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								<i id="24" class="fa fa-lg fa-star-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="row">
							<i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i><span
								id="location2"></span>
						</div>
					</div>
				</div>



			</div>
		</div>
		<div class="modal-footer" style="padding-bottom: 0px; height: 40px;">
			<a id="shopping_cart_click"
				href="${pageContext.servletContext.contextPath}/cabinet/orders"></a>
		</div>
	</div>
	<!-- 	END OF SUCCES MODAL -->



	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>


	<script type="text/javascript">
		var pagesCount = '${countOfPages}';
		//	pagesCount = 3;
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
						findPage(window.location.href, page);
					}
				});
			});
		}
	</script>

	<script>
// 		var count = $
// 		{
// 			countOfOrders
// 		};
// 		$('#periodicals_number_for_all_users').html(count);
	</script>

</body>

</html>