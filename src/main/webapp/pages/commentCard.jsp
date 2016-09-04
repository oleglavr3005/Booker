<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/commentStyle.css">

<div class="col s10 offset-s1">
	<div class="card">
		<div class="container-fluid">
			<c:forEach var="comment" items="${feedbacks}">
				<div class="comment_card" id="comment_id_${comment.id}" style="margin: 20px; display: none">
					<div class="row">
						<div class="media">
					    	<img src="${pageContext.servletContext.contextPath}/resources/images/${comment.img}" style="margin-right: 0;" width="60" height="60" alt="Avatar" class="pull-left">
					        <div class="media-body">
					           	<h4 style="font-size: 1.3rem; margin-top: 0; margin-bottom: 10px;" ><c:out value="${comment.firstName}"></c:out> <c:out value="${comment.lastName}"></c:out></h4>
					               	<span class="date_posted"><c:out value="${comment.date}"></c:out></span>
					        </div>
					    </div>
					    <p style="margin: 20px 0; padding-left: 1.5rem; border-left: 5px solid #ee6e73; word-wrap: break-word;"><c:out value="${comment.comment}"></c:out></p>
					</div>
			        <!-- end row -->
			    </div>
			</c:forEach>
			<div style="margin:20px">
				<a id="togle" class="waves-effect waves-light btn" onclick="addComments(1)" style="width: 14%;background: #26A69A;text-align: center;color: #F7F7F7;margin-left: 43%;">
					<i id="arrow_icon" class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true"></i>
				</a>
 			</div>
		</div>
	</div>
</div>
