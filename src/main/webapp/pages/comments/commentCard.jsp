<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/commentStyle.css">
<link href="${pageContext.servletContext.contextPath}/resources/css/rating.css" rel="stylesheet">

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
			<c:if test="${user != null && canComment != 'false'}">	
			<div id="newComment" style="margin: 20px; overflow: hidden;">
				<div class="row">
					<div class="col s6" style="margin-top: 15px; margin-left: 20px; margin-right: 20px;">
						<input id="title_comment" class="validate" type="text" value="">
						<label id="title_comment_label" data-error="" for="title_comment" class="">
							<span id="title_comment_span"></span>
						</label>
					</div>
					<div class="col s6" style="margin-top: 15px;">
						<div class="vote-block" rel="v:rating" style="overflow: inherit;">
					        <div typeof="v:Rating">
					            <div itemprop="aggregateRating" itemscope="" itemtype="http://schema.org/AggregateRating">
					                <meta itemprop="bestRating" content="5">
					                <meta property="v:rating" content="1">
					                <meta itemprop="ratingCount" property="v:votes">
					            </div>
					        </div>
					        <ol class="rating show-current">
					            <li>5</li>
					            <li>4</li>
					            <li>3</li>
					            <li>2</li>
					            <li>1</li>
					            <li class="current"><span style="width:20%"></span></li>
					        </ol>
					        <span id="manager_hotel_star" style="font-size: 14; position: relative; left: 10px; top: 8px;"></span>
							<span id="rate_span" style="font-size: 14; position: relative; left: 10px; top: 8px;">1</span>
							<span style="font-size: 14; position: relative; left: 10px; top: 8px;"> / 5</span>
					    </div>
					</div>
				</div>
				<textarea id="comment" class="materialize-textarea validate" style="height: 80px;"></textarea>
					<div id="comment_error_panel" class="row" style="display : none; padding-top: 20px;">
					 <div style="border: 1px solid red; border-radius: 10px; padding: 15px; background-color: rgba(255, 0, 0, 0.3);">
						<span class="comment_error"></span>
					</div>
				</div>
				<div style="margin-top: 20px;">
					<a id="createComment" class="waves-effect waves-light btn" onclick="addNewComment(${hotel.id})" style="width: 200px;background: #26A69A;text-align: center;color: #F7F7F7;margin-left: calc(50% - 100px);"></a>
				</div>
			</div>
			</c:if>
			<c:if test="${canComment == 'false'}">
				<div class="row" style="padding-top: 20px;">
					 <div style="border: 1px solid red; border-radius: 10px; padding: 15px; background-color: rgba(255, 0, 0, 0.3);">
						<span class="comment_can_not"></span>
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

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/hotel/rating.js"></script>