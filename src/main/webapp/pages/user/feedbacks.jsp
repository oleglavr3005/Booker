<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">

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
<!-- MOVE TO HOTEL -->
<div style="margin: 20px;"></div>
<c:if test="${countOfRooms == 0}">
	<h5 style="color: red; margin-bottom: 63px;">
		<span id="card_no_periodicals"></span>
	</h5>
</c:if>

<c:forEach var="feedback" items="${feedbacks}">
	<div id="feedbacks_card_${feedback.id}" class="col s10 offset-s1">
		<div class="card">
			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">
					<div class="media col">
						<div class="media-body">
							<h4 style="font-size: 1.3rem; margin-top: 0; margin-bottom: 10px;">
								<c:out value="${feedback.hotel.name}"></c:out>
							</h4>
							<a class="tooltipped" data-position="icon" data-tooltip="Stars"
								style="color: #0d0d0d; text-decoration: none;"
								data-tooltip-id="5701b81f-c345-f4bd-c005-58f8e04f7175"><c:forEach
									var="i" begin="1" end="${feedback.rating}">
									<i class="fa fa-lg fa-star" aria-hidden="true"></i>
								</c:forEach> <c:forEach var="i" begin="${feedback.rating}" end="4">
									<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
								</c:forEach></a>
							<span class="date_posted" style="padding-left: 20px;">
								<c:out value="${feedback.date}"></c:out>
							</span>
						</div>
					</div>
				</div>
				<div class="row" style="margin-bottom: 5px; padding-top: 0;">
					<p style="margin: 10px;">
						<c:out value="${feedback.comment}"></c:out>
					</p>
				</div>
				<div class="row" style="padding-left: calc(50% - 80px);">
					<a class="waves-effect waves-light btn" onclick="deleteComment(${feedback.id})"
						style="width: 160px; margin-left: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
						<span class="feedback_error"></span>
						<span class="my_feedback_delete"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row" style="margin-bottom: 0;">
	<div id="demo5" class="col s4 offset-s5" style="margin-top: 10px;"></div>
</div>
<!-- END OF PAGINATOR 3000 -->

<!-- IMPORTED -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- END OF IMPORTED -->
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/feedback.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/search/search.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jPage/paginate.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/resources/js/order/createOrder.js"
	type="text/javascript"></script>
<script>
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
	
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
</script>