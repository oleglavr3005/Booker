<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/commentStyle.css">

<div class="col s10 offset-s1">
	<div class="card">
		<div class="container-fluid">
			<c:forEach var="comment" items="${feedbacks}"> comment.toString
				<div class="comment_card" id="comment_id_${comment.id}" style="margin: 20px; display: none">
					<div class="row" style="margin-bottom: 0;">
						<div class="media">
					    	<img src="${pageContext.servletContext.contextPath}/resources/images/${comment.img}" style="margin-right: 0; padding-left: 11px; width: 10%;" width="60" height="60" alt="Avatar" class="pull-left">
					        <div class="media-body">
					           	<h4 style="font-size: 1.3rem; margin-top: 0; margin-bottom: 10px;" ><c:out value="${comment.firstName}"></c:out> <c:out value="${comment.lastName}"></c:out></h4>
					            <a class="tooltipped" data-position="icon" data-tooltip="Stars" style="color: #0d0d0d;text-decoration: none;" data-tooltip-id="5701b81f-c345-f4bd-c005-58f8e04f7175">
									<c:forEach var="i" begin="1" end="${comment.rating}">
										<i class="fa fa-lg fa-star" aria-hidden="true"></i> 
									</c:forEach>
									<c:forEach var="i" begin="${comment.rating}" end="4">
										<i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</a>
					            <span class="date_posted" style="padding-left: 20px;"><c:out value="${comment.date}"></c:out></span>
					        </div>
					    </div>
					    <p style="margin: 20px 0 0 12px; padding-left: 1.5rem; border-left: 4px solid #ee6e73; word-wrap: break-word;"><c:out value="${comment.comment}"></c:out></p>
					</div>
			        <!-- end row -->
			    </div>
			</c:forEach>
			<div style="margin:20px">
				<a id="commentButton" class="waves-effect waves-light btn" onclick="addComments(5)" style="width: 14%;background: #26A69A;text-align: center;color: #F7F7F7;margin-left: 43%;">
					<i id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true"></i>
				</a>
 			</div>
		</div>
	</div>
</div>
