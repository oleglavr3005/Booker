<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">

<style>
b {
	margin-left: 8px;
	font-size: 15px;
}

.invert:hover {
	-webkit-filter: invert(70%);
	filter: invert(70%);
	cursor: default;
}
</style>
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
						<i class="glyphicon glyphicon-chevron-left"></i> <span
							id="hotel_button_previous"></span>
					</button>
					<button type="button" class="btn btn-primary next">
						<span id="hotel_button_next"></span> <i
							class="glyphicon glyphicon-chevron-right"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- MOVE TO HOTEL -->

<div class="divider" style="margin: 0;"></div>

<!--END MOVE TO HOTEL -->

<input id="flag" type="hidden" value="true" />

<script>
		if ($('#date_from').val() == "" || $('#date_to').val() == ""){
			$('#flag').val("false");
		}
	</script>


<c:forEach var="room" items="${rooms}">

	<input id="ids${room.id}" type="hidden" value="${room.allRoomIds}" />

	<div id="hotel_card_${room.id}" class="col s10 offset-s1">
		<div class="card">
			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 0px;">
					<div class="card-image col s4" style="position: relative;">
						<div id="links${room.id}">
							<c:if test="${fn:length(room.allPhotos) == 0}">
								<a href="<i:urlToImage url="no.jpg" />" title="No image"
									data-gallery="#blueimp-gallery-${room.id}"> <img
									src="<i:urlToImage url="no.jpg" />" alt="No image">
								</a>
							</c:if>
							<c:if test="${fn:length(room.allPhotos) != 0}">
								<a href='<i:urlToImage url="${room.allPhotos[0].img}" />'
									data-gallery="#blueimp-gallery-${room.id}"> <img
									src="<i:urlToImage url="${room.allPhotos[0].img }" />"
									style="padding: 10px;">
								</a>

								<div style="display: none;">
									<c:forEach items="${room.allPhotos}" var="photo" begin="1">
										<a href='<i:urlToImage url="${photo.img}" />'
											data-gallery="#blueimp-gallery-${room.id}"> <img
											style="height: 60px;"
											src="<i:urlToImage url="${photo.img}" />"
											alt="<c:out value="${photo.id }"></c:out>">
										</a>
									</c:forEach>
								</div>
							</c:if>
						</div>




						<%-- 						<a><img src="${pageContext.servletContext.contextPath}/resources/images/photoOfHotelsRoom/${room.photos[0].img}" --%>
						<%-- 							style="height: 170px; width: 200px; padding: 10px;"> </a> --%>

					</div>

					<div class="col s5">

						<!-- ROOM TYPE ZONE -->
						<div class="row" style="margin-top: 15px;">
							<c:if test="${room.type == 'STANDART'}">
								<span class="subscribes_table_roomtype_standart"></span>
							</c:if>
							<c:if test="${room.type == 'LUX'}">
								<span class="subscribes_table_roomtype_lux"></span>
							</c:if>
							<c:if test="${room.type == 'DELUX'}">
								<span class="subscribes_table_roomtype_delux"></span>
							</c:if>

							<span style="margin-left: 5px;" class="roomCard_countOfFree">
							</span> ${room.amount}
						</div>
						<!-- 				END OF ROOM TYPE ZONE -->

						<!-- BEDS ICON ZONE -->
						<div class="row">
							<a class="tooltipped tooltip_double_beds" data-position="icon"
								data-tooltip="Double beds" style="color: #0d0d0d;"><img
								class="invert" style="max-width: 7%;"
								src="${pageContext.servletContext.contextPath}/resources/images/double_bed.png" /></a>
							<span>${room.doubleBedsCount}</span> <a
								class="tooltipped tooltip_single_beds" data-position="icon"
								data-tooltip="Single beds" style="color: #0d0d0d;"><img
								class="invert" style="max-width: 7%;"
								src="${pageContext.servletContext.contextPath}/resources/images/single_bed.png" /></a>
							<span>${room.bedsCount}</span>
						</div>
						<!-- END OF BEDS ICON ZONE -->

						<!-- ROOM FOOD ZONE -->
						<div class="row">
							<a class="tooltipped tooltip_food" data-position="icon"
								data-tooltip="Food" style="color: #0d0d0d;"><i
								class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a>
							<c:if test="${room.food == 'NONE'}">
								<span id="subscribes_table_roomfood_none"></span>
							</c:if>
							<c:if test="${room.food == 'BREAKFAST'}">
								<span id="subscribes_table_roomfood_breakfast"></span>
							</c:if>
							<c:if test="${room.food == 'TWICE'}">
								<span id="subscribes_table_roomfood_twice"></span>
							</c:if>
							<c:if test="${room.food == 'FULL'}">
								<span id="subscribes_table_roomfood_full"></span>
							</c:if>
						</div>
						<!-- END OF ROOM FOOD ZONE -->

						<!-- ROOM PRICE ZONE -->
						<div class="row">
							<div class="col s6" style="margin-left: -13px;">
								<a class="tooltipped tooltip_price" data-position="icon"
									data-tooltip="Price for one day" style="color: #0d0d0d;"><i
									class="fa fa-lg fa-money invert" aria-hidden="true"></i></a> <span>${room.price}</span>

								<i id="showInfo${room.id}" onclick="showInfo(${room.id})"
									class="fa fa-lg fa-info invert tooltipped tooltip_show_info"
									data-tooltip="Show additional info" aria-hidden="true"></i>
							</div>

						</div>


						<!-- END OF ROOM PRICE ZONE -->

					</div>

					<div class="col s3">
						<div class="row"
							style="float: right; text-align: right; font-size: 0.3rem; color: black; margin-right: 0px;">
							<c:if test="${room.wifi == true}">
								<a class="tooltipped index_room_wifi" data-position="icon"
									data-tooltip="Wifi" style="color: #0d0d0d;"><i
									class="material-icons invert">wifi</i></a>
							</c:if>

							<c:if test="${room.shower == true}">
								<a class="tooltipped index_room_shower" data-position="icon"
									data-tooltip="Shower"><img class="invert"
									style="max-width: 10%; margin-top: -1.5rem"
									src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" />
								</a>
							</c:if>

							<c:if test="${room.condition == true}">
								<a class="tooltipped index_room_conditioner"
									data-position="icon" data-tooltip="Condition"
									style="color: #0d0d0d;"><i class="material-icons invert">toys</i></a>
							</c:if>

							<c:if test="${room.balcony == true}">
								<a class="tooltipped index_room_balcony" data-position="icon"
									data-tooltip="Balcony"><img class="invert"
									style="max-width: 10%; margin-top: -1.5rem"
									src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" />
								</a>
							</c:if>

							<c:if test="${room.tv == true}">
								<a class="tooltipped index_room_tv" data-position="icon"
									data-tooltip="Television" style="color: #0d0d0d;"><i
									class="material-icons invert">tv</i></a>
							</c:if>
						</div>

						<div class="row"
							style="margin-bottom: 0px; margin-top: 80px;
						<c:if test="${!(user != null && startDate != null)}"> visibility: hidden</c:if> ">
							<div class="input-field col s7 offset-s4" style="margin-top: -20;">
								<input id="countOfRooms${room.id}" type="number"
									class="validate" name="countOfRooms" min=1 value=1
									max="${room.amount}"><label id="nameLbl"
									data-error="NAME INVALID" for="name"><span
									class="room_orderedrooms"></span></label>
							</div>
						</div>


						<div class="row">
							<c:if test="${user != null && user.status != 'BANNED'}">
								<div class="col s3" id="cont"></div>
								<c:if test="${startDate != null}">
									<a id="btn${room.id}" class="waves-effect waves-light btn"
										onclick="addToCart(${room.id})"
										style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
										<span class="room_card_add_to_cart"></span>
									</a>
								</c:if>

								<c:if test="${startDate == null}">
									<div class="hiddenError" class="col s2 offset-s6"></div>
								</c:if>


							</c:if>
							<c:if test="${user != null && user.status == 'BANNED'}">
								<div class="room_card_YOURE_BANNED" class="col s2 offset-s6"></div>
							</c:if>
							<c:if test="${user == null}">
								<div class="row">
									<div class="col s9 offset-s1">
										<!-- 										<a class="waves-effect waves-light btn" disabled -->
										<!-- 											style="background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"> -->
										<label><span class="room_card_need_login"></span></label>
										<!-- 										</a> -->
									</div>
								</div>
							</c:if>

						</div>
					</div>
				</div>

				<!-- 						INFO MONEY REFUND ZONE -->
				<div class="row">
					<div id="details_panel${room.id}" class="col s12"
						style="display: none">
						<c:choose>
							<c:when test="${room.daysCount > -1}">
								<div
									style="border: 1px solid red; border-radius: 10px; padding: 5px; background-color: rgba(255, 0, 0, 0.3);">
									<span class="room_card_info1">YOU WILL GET 100% REFUND
										IN CASE OF CANCELING ORDER ONLY IN</span> ${room.daysCount} <span
										class="room_card_info2">DAYS BEFORE MOVING IN, AFTER
										THESE PERIOD REFUND WILL BE ONLY</span> ${room.percentage}%
								</div>
							</c:when>
							<c:otherwise>
								<div
									style="border: 1px solid green; border-radius: 10px; padding: 5px; background-color: rgba(0, 255, 0, 0.3);">
									<span class="room_card_info3">FREE_BOOK</span>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
				<!-- 						END OF INFO MONEY REFUND ZONE -->



			</div>


		</div>
	</div>

</c:forEach>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row" style="margin-bottom: 0;">
	<div id="demo5" class="col s6 offset-s4" style="margin-top: 10px;"></div>
</div>
<!-- END OF PAGINATOR 3000 -->


<!-- IMPORTED -->

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery-3.1.0.min.js"></script>



<!-- END OF IMPORTED -->

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>

<script type="text/javascript">
		var pagesCount = '${countOfPages}';
		var currentPage = '${currentPage}';
		
		if (pagesCount > 1) {
			jQuery(function() {
				jQuery("#demo5").paginate({
					count : pagesCount,
					start : currentPage,
					display : 5,
					border : false,
					//		border_color			: '#fff',
					text_color : '#fff',
					background_color : '#26A69A',
					//		border_hover_color		: '#ccc',
					text_hover_color : '#000',
					background_hover_color : '#CFCFCF',
					images : true,
					mouse : 'press',
					onChange : function(page) {
						findPage(window.location.href,page);
					}
				});
			});
		}
 	</script>

<script>
 	var count = ${countOfRooms};
 		$('#periodicals_number_for_all_users').html(count);
 	</script>


<script
	src="${pageContext.servletContext.contextPath}/resources/js/order/createOrder.js"
	type="text/javascript"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/infoToggle.js"
	type="text/javascript"></script>

<script>
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
	
	</script>