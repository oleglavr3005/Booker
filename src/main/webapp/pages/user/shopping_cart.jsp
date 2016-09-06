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

	<div class="container">
		<h4 style="text-align: center; margin-top: 20px;">
			<fmt:message key="user.cart.header" />
		</h4>

		<div class="row">SHOP LIST</div>
		<div class="row">
			<div class="col s3">
				<h6>
					<c:if test="${countOfOrders > 0 }">
						<fmt:message key="card.header" />
						<span id="periodicals_number_for_all_users">${countOfOrders}</span>
					</c:if>
					<c:if test="${countOfOrders <= 0 }">
						<fmt:message key="card.no.hotels" />
					</c:if>
				</h6>
			</div>
			<div class="col s4 offset-s5">
				<c:if test="${countOfOrders > 0 }">
					<select id="compare" class="chosen-select optionstyle"
						onchange="findPage(window.location.href,1)">
						<option class="optionstyle" value="compareByDateAsc">date
							asc</option>
						<option class="optionstyle" value="compareByDateDesc"
							selected="selected">date desc</option>
						<option class="optionstyle" value="compareByPriceAsc">price
							asc</option>
						<option class="optionstyle" value="compareByPriceDesc">price
							desc</option>
					</select>
				</c:if>
			</div>
		</div>



		<!-- SWITCH CONTENT -->
		<div id="switchContent" class="row">
			<jsp:include page="../orderCard.jsp"></jsp:include>
		</div>

		<!-- END OF SWITCH CONTENT -->





	</div>

	<!-- SUCCES MODAL  -->
	<div id="modal1" class="modal"
		style="width: 35% !important; max-height: 50% !important">
		<div class="modal-content">
			<h6>GZ WITH SUCCESFULL ORDER CREATION</h6>
			<a href="href="${pageContext.servletContext.contextPath}/cabinet/orders">CLICK
				IF YOU WANT TO LOOK AT YOUR ORDER LIST : </a>
		</div>

	</div>
	<!-- 	END OF SUCCES MODAL -->




	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>

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
						// 											$('._current','#paginationdemo').removeClass('_current').hide();
						// 											$('#p'+page).addClass('_current').show();
						findPage(window.location.href, page);
					}
				});
			});
		}
	</script>

</body>

</html>