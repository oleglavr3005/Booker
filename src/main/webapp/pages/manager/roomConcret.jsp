
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />
<html lang="en">

<head>
<meta charset="utf-8">
<title>HOTEL_NAME ${room.number}</title>

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
<link
	href="${pageContext.servletContext.contextPath}/resources/css/star-rating/star-rating.css"
	rel="stylesheet">
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


<!-- GALERY -->
<!-- Add local libraries for gallery -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/font-awesome.min.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/jquery-ui.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/nouislider.min.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.css">
<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/jquery.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/jquery.blueimp-gallery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">

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


<link
	href="${pageContext.servletContext.contextPath}/resources/js/image-picker/image-picker.css"
	rel="stylesheet">
</head>

<body>

	<input id="lang" type="hidden" value="${language}" />

	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<!-- 					PHOTO -->
				<div class="row">
					<a href="#!"><img id="Img"
						style="height: 100px; padding: 10px; width: 110px;"
						<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="new_hotel.jpg" />">
					</a>
					<!-- 					END OF PHOTO -->
					<!-- 				INPUT -->
					<input style="margin-top: 5px" type="file" id="imgInput"
						onchange="uploadRoom()" accept="image/*" />
					<!-- 				END OF INPUT -->

					<a class="waves-effect waves-light btn" id="create_button"
						onclick="updateRoom()"
						style="margin-left: 10px; margin-top: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>SAVE</span></a>
					<p id="create_error" style="color: red"></p>
				</div>

				<div class="row">
					<p>
						<input type="checkbox" class="filled-in" id="isDeleted"
							name="isDeleted" /> <label for="isDeleted">DELETED</label>
					</p>

					<script>
						$('#isDeleted').attr('checked',
								'${room.deleted}' == 'true');
					</script>

					<p>
						<input type="checkbox" class="filled-in" id="freeBook"
							onclick="changeFreeBook()" name="freeBook" /> <label
							for="freeBook">FREEBOOK</label>
					</p>



				</div>


			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s4 offset-s2" style="margin-top: 20px;">

							<!-- 						ROOM TYPE -->
							<div class="row">
								<select id="roomType" class="chosen-select optionstyle">
									<option class="optionstyle" value="STANDART"
										selected="selected">STANDART</option>
									<option class="optionstyle" value="LUX">LUX</option>
									<option class="optionstyle" value="DELUXE">DELUXE</option>
								</select>
							</div>
							<!-- 						END OF ROOM TYPE -->




							<!-- 1 BEDS COUNT -->

							<div class="row">
								<input id="single" value="${room.bedsCount}" type="number"
									class="validate" name="single" min=1 max=100> <label
									id="singleLbl" data-error="${fmtPeople}" for="single"><fmt:message
										key="room.concrete.single" /></label>
							</div>

							<!-- 							END OF 1 BEDS COUNT -->

							<!-- DAYS COUNT -->

							<div class="row">
								<input id="days" value="${room.daysCount}" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="days" min=1 max=365> <label
									id="daysLbl" data-error="${fmtPeople}" for="days"><fmt:message
										key="room.concrete.days" /></label>
							</div>

							<!-- 							END OF DAYS COUNT -->

							<!-- NUMBER -->

							<div class="row">
								<input id="number" value="${room.number}" type="number"
									class="validate" name="days" min=1 max=365> <label
									id="daysLbl" data-error="${fmtPeople}" for="days"><fmt:message
										key="room.concrete.number" /></label>
							</div>

							<!-- 							END OF NUMBER -->

							<!-- PRICE -->

							<div class="row">
								<input id="price" value="${room.price}" type="number"
									class="validate" name="percentage" min=1 max=100> <label
									id="percentageLbl" data-error="${fmtPeople}" for="percentage"><fmt:message
										key="room.concrete.price" /></label>
							</div>

							<!-- 							END OF PRICE -->

						</div>

						<div class="col s4 offset-s2" style="margin-top: 20px;">

							<!-- 						FOOD TYPE -->
							<div class="row">
								<select id="foodType" class="chosen-select optionstyle">
									<option class="optionstyle" value="NONE" selected="selected">NONE
									</option>
									<option class="optionstyle" value="BREAKFAST">BREAKFAST</option>
									<option class="optionstyle" value="TWICE">TWICE</option>
									<option class="optionstyle" value="FULL">FULL</option>
								</select>
							</div>
							<!-- 						END OF FOOD TYPE -->

							<!-- 2 BEDS COUNT -->

							<div class="row">
								<input id="double" value="${room.doubleBedsCount}" type="number"
									class="validate" name="single" min=1 max=100> <label
									id="doubleLbl" data-error="${fmtPeople}" for="double"><fmt:message
										key="room.concrete.double" /></label>
							</div>

							<!-- 							END OF 2 BEDS COUNT -->

							<!-- PERCENTAGE COUNT -->

							<div class="row">
								<input id="percentage" value="${room.percentage}" type="number"
									<c:if test="${room.daysCount < 0 }"> disabled="disabled"</c:if>
									class="validate" name="percentage" min=1 max=100> <label
									id="percentageLbl" data-error="${fmtPeople}" for="percentage"><fmt:message
										key="room.concrete.percentage" /></label>
							</div>

							<!-- 							END OF PERCENTAGE COUNT -->






							<!-- 								CHECKBOX -->

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

							<!-- 								END OF CHECKBOX -->

						</div>


					</div>

				</div>
			</div>
		</div>
	</div>
	
	
	<div class="container">
	
<select class="image-picker masonry show-html" id="images" multiple="multiple">
<c:forEach var="photo" items="${room.photos}">
   <option data-img-src="<i:urlToImage url="${photo.img }" />" value="${photo.id}">${photo.desc }</option>
</c:forEach>
</select>
<a class="my-btn waves-effect waves-light btn"
									style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px; margin: 0 auto;"
									onclick="remove()"><fmt:message
											key="subscribes.table.remove" /> </a>
</div>
	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->
	<script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">$(document).ready(function() {
	    $('#photos').DataTable();
	} );</script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>
		
		<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>
		
		
				<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/image-picker/image-picker.js"></script>
				<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/image-picker/image-picker.min.js"></script>
		<script src="http://rvera.github.io/image-picker/js/jquery.masonry.min.js"></script>
<script type="text/javascript">
		$("select").imagepicker();
		var container = jQuery("select.image-picker.masonry").next("ul.thumbnails");
    container.imagesLoaded(function(){
      container.masonry({
        itemSelector:   "li",
      });
    });
    
    
    function remove() {
    	var values = $('#images').val();
    	alert(values);
	}
    </script>
	<script>
						function changeFreeBook(){
							var freeBook = document.getElementById('freeBook').checked;
							$('#percentage').prop('disabled', freeBook);
							$('#days').prop('disabled', freeBook);
						}
					
						$('#freeBook').attr('checked',
								'${room.daysCount}' < 0);
					</script>


</body>

</html>
