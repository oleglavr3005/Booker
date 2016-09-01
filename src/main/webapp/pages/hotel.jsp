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
<title>Hotel Page</title>

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
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<link rel="stylesheet" href="css/bootstrap-image-gallery.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>



<!-- JTable -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#example').DataTable();
} );
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

.well {
	padding: 0px;
}
</style>
</head>


<body>
	<div id="blueimp-gallery" class="blueimp-gallery">
		<!-- The container for the modal slides -->
		<div class="slides"></div>
		<!-- Controls for the borderless lightbox -->
		<h3 class="title"></h3>
		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a> <a
			class="play-pause"></a>
		<ol class="indicator"></ol>
		<!-- The modal dialog, which will be used to wrap the lightbox content -->
		<div class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" aria-hidden="true">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body next"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left prev">
							<i class="glyphicon glyphicon-chevron-left"></i> Previous
						</button>
						<button type="button" class="btn btn-primary next">
							Next <i class="glyphicon glyphicon-chevron-right"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->


	<!-- 	<div id="wrapper" style="position: relative; min-height: 100%;"> -->


	<!-- SideBar ========================================================================= -->
	<%-- 		<jsp:include page="side.jsp"></jsp:include> --%>
	<!-- SideBar End====================================================================== -->


	<div class="container" style="margin-top: 20px">


		<div id="links">
			<div class="row">
				<div class="col s4">
					<a
						href='<c:out value="${mainPhoto.id}"></c:out>'
						title="Banana" data-gallery> <img
						src="<c:out value="${mainPhoto.img}"></c:out>"
						alt="Banana">
					</a>


					<div style="overflow-x: auto;">
						<div style="margin: 10px; white-space: nowrap;">
						<c:forEach items="${hotelPhoto}" var="photo">
						   <div style="display: inline-block;">
								<a
									href='<c:out value="${photo.img }"></c:out>'
									title="<c:out value="${photo.img }"></c:out>" data-gallery> <img style="height: 60px;"
									src="<c:out value="${photo.img }"></c:out>"
									alt="<c:out value="${photo.img }"></c:out>">
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
				<div class="col s6 offset-s1">
					<h1>
						<c:out value="${hotel.name }"></c:out>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
		<table id="example" class="display">
    <thead>
        <tr>
          	<th>Name</th>
						<th>Position</th>
						<th>Office</th>
        </tr>
    </thead>

						<c:forEach items="${rooms}" var="room">
						    <tbody>
    <tr>
							<td><c:out value="${ room.price}"></c:out></td>
							<td><c:out value="${ room.price}"></c:out></td>
							<td><c:out value="${ room.price}"></c:out></td>
						
						</tr>
						</c:forEach>
					
        <tr>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
        </tr>
        <tr>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
        </tr>
    </tbody>
</table>
			
		</div>
	</div>

	<!-- 	</div> -->



	<!-- Footer ========================================================================== -->
	<jsp:include page="foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

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


	<!-- 	<script type="text/javascript" -->
	<%-- 		src="${pageContext.servletContext.contextPath}/resources/js/search/details.js"></script> --%>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.js"></script>

	<script>
		var range = document.getElementById('rangeSlider');
		noUiSlider.create(range, {
			start : [ 1, 5 ], // Handle start position
			step : 1, // Slider moves in increments of '1'
			connect : true, // Display a colored bar between the handles
			behaviour : 'tap-drag', // Move handle on tap, bar is draggable
			range : { // Slider can select '1' to '5'
				'min' : 1,
				'max' : 5
			}
		});
	</script>

	<script>
		var range2 = document.getElementById('priceSlider');
		noUiSlider.create(range2, {
			start : [ 100, 5000 ], // Handle start position
			step : 1, // Slider moves in increments of '1'
			connect : true, // Display a colored bar between the handles
			behaviour : 'tap-drag', // Move handle on tap, bar is draggable
			range : { // Slider can select '1' to '5'
				'min' : 100,
				'max' : 5000
			}
		});

		function togle() {
			var elem1 = document.getElementById("details_panel");
			var style = document.defaultView.getComputedStyle(elem1, null)
					.getPropertyValue("display");
			if (style == 'none') {
				document.getElementById('details_panel').style.display = "block";

				$('#arrow_icon').removeClass("fa-angle-double-down");
				$('#arrow_icon').addClass("fa-angle-double-up");
			} else {
				document.getElementById('details_panel').style.display = "none";

				$('#arrow_icon').removeClass("fa-angle-double-up");
				$('#arrow_icon').addClass("fa-angle-double-down");
			}
		}
	</script>

</body>

</html>