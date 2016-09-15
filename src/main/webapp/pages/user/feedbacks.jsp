<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">
<link href="${pageContext.servletContext.contextPath}/resources/css/rating.css" rel="stylesheet">
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
<c:if test="${fn:length(feedbacks) == 0}">
	<h5 style="color: red; margin-bottom: 63px; text-align: center;">
		<span id="feedback_without_feedback"></span>
	</h5>
		<img src="${pageContext.servletContext.contextPath}/resources/images/comment.png" alt="comments" 
			class="img-responsive center-block" style="max-height:400px; opacity:.3; margin-bottom:50px"/>
</c:if>

<c:forEach var="feedback" items="${feedbacks}">
	<div id="feedbacks_card_${feedback.id}" class="col s10 offset-s1">
		<div class="card">
			<div class="container-fluid">
				<div class="row" style="margin-top: 15px; margin-bottom: 10px;">
					<div class="media col">
						<div class="media-body">
							<h4 style="font-size: 1.3rem; margin-top: 0; margin-bottom: 10px;">
								<a href="/booker/hotel/<c:out value="${feedback.hotel.id}"/>">
								<c:out value="${feedback.hotel.name}"/></a>
							</h4>
							<div class="col s6" style="margin-top: 15px; padding-left: 0;">
								<input id="title_feedback_${feedback.id}" class="validate" type="text" value="<c:out value="${feedback.title}"/>">
								<label id="title_feedback_${feedback.id}_label" data-error="" for="title_feedback_${feedback.id}" class="">
									<span id="title_feedback_span_${feedback.id}"></span>
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
							            <li class="current"><span style="width:${feedback.rating * 20}%"></span></li>
							        </ol>
							        <span class="manager_hotel_star" style="font-size: 14; position: relative; left: 10px; top: 8px;"></span>
									<span id="rate_span" style="font-size: 14; position: relative; left: 10px; top: 8px;">${feedback.rating}</span>
									<span style="font-size: 14; position: relative; left: 10px; top: 8px;"> / 5</span>
							    </div>
							</div>
						</div>
						<textarea id="feedback_${feedback.id}" class="materialize-textarea validate" style="padding-top: 0;"><c:out value="${feedback.comment}"/></textarea>
						<div id="button_panel_${feedback.id}" class="row" style="text-align: center;">
							<a class="waves-effect waves-light btn" onclick="deleteFeedback(${feedback.id})"
								style="margin-left: 10px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;">
								<span class="feedback_error_${feedback.id}"></span>
								<span class="my_feedback_delete"></span>
							</a>
							<a class="waves-effect waves-light btn" onclick="updateFeedback(${feedback.id})" style="background: #26A69A;text-align: center;color: #F7F7F7;">
								<span class="my_feedback_edit">Edit</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<!-- PAGINATOR 3000 -->
<div id="paginationdemo" class="row">
	<div id="demo5" class="col s6 offset-s4"></div>
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

<script
	src="${pageContext.servletContext.contextPath}/resources/js/order/createOrder.js"
	type="text/javascript"></script>
<script>
// 	var pagesCount = '${countOfPages}';
// 	var currentPage = '${currentPage}';
// 	if (pagesCount > 1) {
// 		jQuery(function() {
// 			jQuery("#demo5").paginate({
// 				count : pagesCount,
// 				start : currentPage,
// 				display : 5,
// 				border : false,
// 				//		border_color			: '#fff',
// 				text_color : '#fff',
// 				background_color : '#26A69A',
// 				//		border_hover_color		: '#ccc',
// 				text_hover_color : '#000',
// 				background_hover_color : '#CFCFCF',
// 				images : true,
// 				mouse : 'press',
// 				onChange : function(page) {
// 					findPage(window.location.href,page);
// 				}
// 			});
// 		});
// 	}
	
	$(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50,position: 'top'});
	  });
</script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/hotel/rating.js"></script>