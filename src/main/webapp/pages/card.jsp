<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
							id="hotel_button_previous"><span>
					</button>
					<button type="button" class="btn btn-primary next">
						<span id="hotel_button_next"><span> <i
								class="glyphicon glyphicon-chevron-right"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- <h6> -->
<%-- 	<c:if test="${countOfHotels > 0 }"> --%>
<%-- 		<fmt:message key="card.header" /> --%>
<%-- 		<span id="periodicals_number_for_all_users">${countOfHotels}</span> --%>
<%-- 	</c:if> --%>
<%-- 	<c:if test="${countOfHotels <= 0 }"> --%>
<%-- 		<fmt:message key="card.no.periodicals" /> --%>
<%-- 	</c:if> --%>
<!-- </h6> -->
<div class="divider" style="margin-bottom: 20px;"></div>
<div class="container-fluid">
	<div class="row">
		<div class="col s3">
			<c:if test="${countOfHotels == 0}">
				<h5 style="color: red; margin-bottom: 63px;">
					<fmt:message key="card.no.periodicals" />
				</h5>
			</c:if>
		</div>
	</div>

</div>

<c:forEach var="hotel" items="${suitableHotels}">

	<div id="hotel_card_${hotel.id}" class="col s12">
		<div class="card">

			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">

					<div class="card-image col s4" style="position: relative;">


						<div id="links">
							<c:if test="${fn:length(hotel.photos) == 0}">
								<a href="<i:urlToImage url="no.jpg" />" title="No image"
									data-gallery> <img src="<i:urlToImage url="no.jpg" />"
									alt="No image">
								</a>
							</c:if>
							<c:if test="${fn:length(hotel.photos) != 0}">
								<a href='<i:urlToImage url="${hotel.photos[0].img}" />'
									data-gallery> <img
									src="<i:urlToImage url="${hotel.photos[0].img }" />"
									style="height: 220px; width: 300px; padding: 10px;">
								</a>

								<div style="display: none;">
									<c:forEach items="${hotel.photos}" var="photo" begin="1">
										<a href='<i:urlToImage url="${photo.img}" />' data-gallery>
											<img style="height: 60px;"
											src="<i:urlToImage url="${photo.img}" />"
											alt="<c:out value="${photo.id }"></c:out>">
										</a>
									</c:forEach>
								</div>
							</c:if>
						</div>


						<%--                                                     <a href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}"> --%>
						<%--                                                         <img <%-- src="${pageContext.servletContext.contextPath}/resources/images/photoOfHotels/${hotel.photos[0].img}" src=" --%>
						<%--                                                         <i:urlToImage url="${hotel.photos[0].img}" />" style="height: 170px; width: 200px; padding: 10px;"> --%>
						<!--                                                     </a> -->

					</div>

					<div class="col s6">

						<div class="row" style="margin-top: 15px; margin-bottom: 10px">
							<div class="col s5">
								<a
									href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}">${hotel.name}</a>
							</div>
							<div class="col s6 offset-s1">
								<a class="tooltipped" data-position="icon" data-tooltip="Stars"
									style="color: #0d0d0d; text-decoration: none;"> <c:forEach
										var="i" begin="1" end="${hotel.stars}">
										<i class="fa fa-lg fa-star" aria-hidden="true"></i>
									</c:forEach> <c:forEach var="i" begin="${hotel.stars}" end="4">
										<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</a>
							</div>
						</div>


						<div class="row" style="margin-bottom: 10px;">
							<a class="tooltipped" data-position="icon"
								data-tooltip="Location"
								style="color: #0d0d0d; text-decoration: none;"><i
								class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i></a>
							<span>${hotel.city} ${hotel.street}</span>
						</div>

						<div class="row" style="margin-bottom: 10px">
							<a class="tooltipped" data-position="icon"
								data-tooltip="phone number"
								style="color: #0d0d0d; text-decoration: none;"><i
								class="fa fa-lg fa-phone-square invert" aria-hidden="true"></i></a>
							<span>${hotel.phoneNumber}</span>
						</div>

						<div class="row" style="margin-bottom: 5px">
							<a class="tooltipped" data-position="icon"
								data-tooltip="Description"
								style="color: #0d0d0d; cursor: default"><i
								class="material-icons invert" style="font-size: 20px;">receipt</i></a>
							<span id="hotelInfo${hotel.id}">${hotel.desc.substring(0, hotel.desc.length() < 150 ? hotel.desc.length() : 150)}</span>
							<a onclick="changeInfo(${hotel.id})" style="cursor: pointer"
								class="tooltipped" data-position="icon"
								data-tooltip="Show full info" id="dots${hotel.id}">...</a> <input
								id="infoOpened${hotel.id}" type="hidden" value="false" /> <input
								id="fullInfo${hotel.id}" type="hidden" value="${hotel.desc}" />
							<input id="shortInfo${hotel.id}" type="hidden"
								value="${hotel.desc.substring(0, hotel.desc.length() < 150 ? hotel.desc.length() : 150)}" />
						</div>
					</div>

					<div class="col s2">
						<div class="row" style="margin-top: 14px">
							<a class="tooltipped" data-position="icon" data-tooltip="Rating"
								style="margin-left: 50px; color: #0d0d0d; text-decoration: none;">
								<i class="fa fa-lg fa-thumbs-up invert" aria-hidden="true"></i> <span>${hotel.rating }</span>
							</a>
						</div>


						<div class="row" style="margin-top: 30px">

							<a class="waves-effect waves-light btn"
								href="${pageContext.servletContext.contextPath}/cabinet/my_hotels/${hotel.id}"
								style="margin-left: 10px; background: #e68a00; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;
															<c:if test="${user.id !=hotel.managerId}">visibility: hidden</c:if>"><span
								id="card_edit"></span></a> <a class="waves-effect waves-light btn"
								href="${pageContext.servletContext.contextPath}/hotel/${hotel.id}"
								style="margin-top: 30px; margin-left: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>INFO</span></a>
						</div>

					</div>
				</div>
			</div>


		</div>
	</div>
</c:forEach>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row">
	<div id="demo5" class="col s4 offset-s5"></div>
</div>
<!-- END OF PAGINATOR 3000 -->


<script type="text/javascript">
                                var pagesCount = '${countOfPages}';
                                var currentPage = '${currentPage}';

                                if (pagesCount > 1) {
                                    jQuery(function() {
                                        jQuery("#demo5").paginate({
                                            count: pagesCount,
                                            start: currentPage,
                                            display: 5,
                                            border: false,
                                            //		border_color			: '#fff',
                                            text_color: '#fff',
                                            background_color: '#26A69A',
                                            //		border_hover_color		: '#ccc',
                                            text_hover_color: '#000',
                                            background_hover_color: '#CFCFCF',
                                            images: true,
                                            mouse: 'press',
                                            onChange: function(page) {
                                                findPage(window.location.href, page);
                                            }
                                        });
                                    });
                                }

                            </script>

<script type="text/javascript">
                                function changeInfo(hotelId) {
                                    var infoOpened = document.getElementById("infoOpened" + hotelId);
                                    var fullInfo = document.getElementById("fullInfo" + hotelId).value;
                                    var shortInfo = document.getElementById("shortInfo" + hotelId).value;
                                    var span = document.getElementById("hotelInfo" + hotelId);

                                    if (infoOpened.value != 'true') {
                                        span.innerHTML = fullInfo;
                                        $("#dots" + hotelId).attr("data-tooltip", "Hide info");
                                        infoOpened.value = true;
                                    } else {
                                        span.innerHTML = shortInfo;
                                        $("#dots" + hotelId).attr("data-tooltip", "Show full info");
                                        infoOpened.value = false;
                                    }

                                }

                            </script>

<script>
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
	
	</script>