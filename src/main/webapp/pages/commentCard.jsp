<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/commentStyle.css">
<link href="${pageContext.servletContext.contextPath}/resources/css/star-rating/star-rating.css" rel="stylesheet">

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
		/*   background: */
		/*     url('http://3.bp.blogspot.com/-UXVFcPTKwrk/VC9-GaPAooI/AAAAAAAAFfo/g_uYO8A1PCo/s1600/black%2Bgrey%2Bgradient%2Bbackground%2Bfor%2Bweb.jpg') */
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

<div class="col s10 offset-s1">
	<div class="card">
		<div class="container-fluid">
			<c:if test="${user != null}">	
			<div id="newComment" style="margin: 20px; overflow: hidden;">
				<div>
					<div class="col s6" style="margin-top: 15px;">
						<input id="title_comment" type="text" value="">
						<label id="title_comment_label" data-error="" for="title_comment" class="">
							<span id="title_comment_span">Title</span>
						</label>
					</div>
					<div class="col s6" style="margin-top: 15px;">
						<input id="rating" onchange="rate()" type="number"
							value="0" class="rating" min=0 max=10 step=1
							data-size="xs" data-stars="5"> 
						<span id="manager_hotel_star" style="margin-left: 25px; margin-top: 20px; padding-top: 20px;">
							STAR : 
							<span id="rate_span">0</span>
							/ 5 |
						</span>
						<script>
							function rate() {
								var count = document.getElementById("rate_span");
								count.innerHTML = $('#rating').val();
							}
						</script>
					</div>
				</div>
				<textarea id="comment" style="height: 80px;"></textarea>
				<div style="margin-top: 20px;">
					<a id="createComment" class="waves-effect waves-light btn" onclick="addNewComment(${hotel.id})" style="width: 25%;background: #26A69A;text-align: center;color: #F7F7F7;margin-left: 37.5%;">Add comment</a>
				</div>
			</div>
			</c:if>
			<!-- OneComment ========================================================================= -->
				<jsp:include page="oneComment.jsp"></jsp:include>
			<!-- OneComment End====================================================================== -->
			<div style="margin:20px">
				<a id="commentButton" class="waves-effect waves-light btn" onclick="addComments(5)" style="width: 14%;background: #26A69A;text-align: center;color: #F7F7F7;margin-left: 43%;">
					<i id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true"></i>
				</a>
 			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>