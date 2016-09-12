<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/jquery-ui.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/nouislider.min.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/hotel/blueimp-gallery.css">
<script
	src="${pageContext.servletContext.contextPath}/resources/js/hotel/jquery.blueimp-gallery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">

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

<!--  STArt gallery -->
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
<!-- end GALLERY -->

<div class="divider" style="margin-bottom: 20px;"></div>

<c:if test="${countOfOrders == 0}">
	<h5 style="color: red; margin-bottom: 63px;">
		<span id="card_no_periodicals"></span>
	</h5>
</c:if>


<c:forEach var="order" items="${orders}">
	<div id="hotel_card_${order.id}" class="col s12">
		<div class="card">
			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">
					<div class="card-image col s4" style="position: relative;">
						<div id="links">
							<c:if test="${fn:length(order.room.photos) == 0}">
								<a href="<i:urlToImage url="no.jpg" />" title="No image"
									data-gallery> <img src="<i:urlToImage url="no.jpg" />"
									alt="No image">
								</a>
							</c:if>
							<c:if test="${fn:length(order.room.photos) != 0}">
								<a href='<i:urlToImage url="${order.room.photos[0].img}" />'
									data-gallery> <img
									src="<i:urlToImage url="${order.room.photos[0].img }" />"
									style="height: 170px; width: 200px; padding: 10px;">
								</a>

								<div style="display: none;">
									<c:forEach items="${order.room.photos}" var="photo" begin="1">
										<a href='<i:urlToImage url="${photo.img}" />' data-gallery>
											<img style="height: 60px;"
											src="<i:urlToImage url="${photo.img}" />"
											alt="<c:out value="${photo.id }"></c:out>">
										</a>
									</c:forEach>
								</div>
							</c:if>
						</div>

						<%-- 						<a><img src="<i:urlToImage url="${order.room.photo}" />" --%>
						<%-- 							style="height: 170px; width: 200px; padding: 10px;"> </a> --%>
					</div>

					<div class="col s8">
						<div class="row" style="margin-bottom: 0px;">
							<div class="col s8">
								<div class="row" style="margin-top: 15px; margin-bottom: 0px">
									<div class="col s6">
										<div class="row">
											<a href="${pageContext.servletContext.contextPath}/hotel/${order.hotel.id}">${order.hotel.name}</a>
										</div>
										<div class="row" style="margin-top: 15px;">
											<div>
												<a class="tooltipped tooltip_start_date" data-position="icon"
													data-tooltip="" style="color: #0d0d0d;"><i
													class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a>
												<span class="order_card_from"></span> <span
													id="start_date${order.id}">${order.startDate}</span>
											</div>
										</div>
										<div class="row">
											<div>
												<a class="tooltipped tooltip_start_date" data-position="icon"
													data-tooltip="" style="color: #0d0d0d;"> <i
													class="fa fa-lg fa-calendar invert" aria-hidden="true"></i></a>
												<span class="order_card_to"> </span> <span
													id="end_date${order.id}">${order.endDate}</span>
											</div>
											<script type="text/javascript"
												src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

											<script>
									var id = ${order.id};
									changeDate(id);</script>
										</div>


									</div>

									<div class="col s4 offset-s2">
										<div class="row">${order.room.type}</div>

										<div class="row">
											<a class="tooltipped tooltip_double_beds" data-position="icon"
												data-tooltip="" style="color: #0d0d0d;"><img
												class="invert" style="max-width: 15%;"
												src="${pageContext.servletContext.contextPath}/resources/images/double_bed.png" /></a>
											<span>${order.room.doubleBedsCount}</span> <a
												class="tooltipped tooltip_single_beds" data-position="icon"
												data-tooltip="" style="color: #0d0d0d;"><img
												class="invert" style="max-width: 15%;"
												src="${pageContext.servletContext.contextPath}/resources/images/single_bed.png" /></a>
											<span>${order.room.bedsCount}</span>
										</div>

										<div class="row">
											<a class="tooltipped tooltip_food" data-position="icon"
												data-tooltip="" style="color: #0d0d0d;"><i
												class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${order.room.food}</span>
										</div>

										<div class="row">
											<a class="tooltipped tooltip_price" data-position="icon"
												data-tooltip="" style="color: #0d0d0d;"><i
												class="fa fa-lg fa-money invert" aria-hidden="true"></i></a> <span>${order.price}</span>

											<%-- 											<c:if test="${order.room.daysCount == -1}"> --%>
											<!-- 												<a class="tooltipped" data-position="icon" -->
											<%-- 													data-tooltip="No deposit" style="color: #0d0d0d;"><i --%>
											<%-- 													class="fa fa-2x fa-exclamation-circle invert" --%>
											<%-- 													aria-hidden="true"></i></a> --%>
											<%-- 											</c:if> --%>

										</div>

									</div>
								</div>

							</div>

							<div class="col s4">
								<div class="row"
									style="float: right; text-align: right; font-size: 0.3rem">
									<c:if test="${order.room.wifi == true}">
										<a class="tooltipped index_room_wifi" data-position="icon" data-tooltip=""
											style="color: #0d0d0d;"><i class="material-icons invert">wifi</i></a>
									</c:if>

									<c:if test="${order.room.shower == true}">
										<a class="tooltipped index_room_shower" data-position="icon"
											data-tooltip=""><img class="invert"
											style="max-width: 10%; margin-top: -1.5rem"
											src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
									</c:if>

									<c:if test="${order.room.parking == true}">
										<a class="tooltipped index_room_parking" data-position="icon"
											data-tooltip="" style="color: #0d0d0d;"><i
											class="material-icons invert">local_parking</i></a>
									</c:if>

									<c:if test="${order.room.condition == true}">
										<a class="tooltipped index_room_conditioner" data-position="icon"
											data-tooltip="" style="color: #0d0d0d;"><i
											class="material-icons invert">toys</i></a>
									</c:if>

									<c:if test="${order.room.pool == true}">
										<a class="tooltipped index_room_pool" data-position="icon" data-tooltip=""
											style="color: #0d0d0d;"><i class="material-icons invert">pool</i></a>
									</c:if>

									<c:if test="${order.room.gym == true}">
										<a class="tooltipped index_room_gym" data-position="icon" data-tooltip=""
											style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
									</c:if>

									<c:if test="${order.room.balcony == true}">
										<a class="tooltipped index_room_balcony" data-position="icon"
											data-tooltip=""><img class="invert"
											style="max-width: 10%; margin-top: -1.5rem"
											src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col s12">
						<textarea style="padding-top: 0px" id="comment${order.id}"
							class="materialize-textarea placeholder_enter_comment"
							placeholder=""></textarea>
					</div>
				</div>

				<div class="row" style="margin-right: 10px;">
					<div class="col s2">
						<a id="remove${order.id}" class="waves-effect waves-light btn"
							style="background: #F55151; color: #FFFFFF; font-size: 10px;"
							onclick="removeOrderCard(${order.id})"><span
							class="btn_remove"></span></a>
					</div>
					<div class="col s2 offset-s6">
						<a class="tooltipped" data-position="icon"
							data-tooltip="Money to pay" style="color: #0d0d0d;"><i
							class="fa fa-lg fa-money invert" aria-hidden="true"></i></a>
						<c:choose>
							<c:when test="${order.room.daysCount == -1}">
								<span>0</span>
							</c:when>
							<c:otherwise>
								<span>${order.price / 2}</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col s2 ">
						<a id="book${order.id}" class="waves-effect waves-light btn"
							style="background: #26A69A; color: #FFFFFF; font-size: 10px;"
							onclick="bookOrderCard(${order.id},${order.room.daysCount})"><span
							class="order_card_order"></span></a>
					</div>
				</div>



				<div id="field${order.id}" class="divider"
					style="margin-bottom: 5px;"></div>

			</div>
		</div>


	</div>
	<!-- 	</div> -->
</c:forEach>

<c:if test="${countOfOrders > 0 }">

	<div class="row">
		<div class="col s8 offset-s2">
			<textarea id="comment" class="materialize-textarea placeholder_enter_comment"
				placeholder=""></textarea>
		</div>
	</div>

	<div class="row">
		<div class="col s3 offset-s1">
			<span id="order_card_total_price"></span> <span>${summary/2}</span> <span
				id="order_card_uan"></span> <a class="tooltipped"
				data-position="icon"
				data-tooltip="You pay a half of the sum for orders with deposit. And no money for orders with no deposit"
				style="color: #0d0d0d;"><i
				class="fa fa-2x fa-exclamation-circle invert" aria-hidden="true"></i></a>

		</div>
		<div class="col s2 offset-s3">
			<a id="clearBtn" class="waves-effect waves-light btn"
				style="background: #F55151; color: #FFFFFF; font-size: 10px;" onclick="clearCart()"><span
				id="order_card_clear"></span></a>
		</div>
		<div class="col s2 offset-s1">
			<a class="waves-effect waves-light btn"
				style="background: #26A69A; color: #FFFFFF; font-size: 10px;"
				onclick="bookOrderCard(null,${summary})"><span
				id="order_card_order"></span></a>
		</div>
	</div>
	<div id="field" class="divider" style="margin-bottom: 5px;"></div>

</c:if>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row">
	<div id="demo5" class="col s4 offset-s5"></div>
</div>
<!-- END OF PAGINATOR 3000 -->

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/order/removeOrder.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/order/createOrder.js"></script>

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
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
	
	</script>