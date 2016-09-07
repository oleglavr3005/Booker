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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link type="image/png" rel="icon"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
<title>Booker | ADMIN</title>
<link rel="icon" type="image/ico"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.ico">
<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"
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
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">

<link
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"
	rel="stylesheet">
<style>
.btn {
	background: #26A69A;
	color: #999999;
}

.optionstyle {
	font-size: 15px;
	font-family: 'Times NewRoman', Times, serif;
}

.labelstyle {
	font-size: 18px;
	font-family: 'Times NewRoman', Times, serif;
}

.tabs {
	box-shadow: 0 3px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
	transition: box-shadow .25s;
	border-radius: 5px;
	background-color: #F3EAEA;
}

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

}
.well {
	padding: 0px;
}
</style>

</head>
<body>

	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />

	<input id="lang" type="hidden" value="${language}" />


	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">

		<h4 style="text-align: center; margin-top: 20px;">
			<fmt:message key="admin.header" />
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #638F98;">
					<li class="tab col s5 offset-s1"><a class="active"
						href="#test1" style="color: #1A3D44"><b><p id="tab_users">USERS</p></b></a></li>
					<li class="tab col s5 offset-s1"><a href="#test2"
						style="color: #1A3D44"><b><p id="tab_contact">CONTACT</p></b></a></li>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<div class="container-fluid">
					<div class="row settings-title">
						<h4>
							<fmt:message key="settings.header.USERS" />
						</h4>
					</div>

					<table id="users">
						<thead>
							<tr>
								<th>ID</th>
								<th>fNane</th>
								<th>lName</th>
								<th>Mail</th>
								<th>Phone</th>
								<th>Type</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td><c:out value="${user.id }"></c:out></td>
									<td><c:out value="${user.firstName}"></c:out></td>
									<td><c:out value="${user.lastName}"></c:out></td>
									<td><c:out value="${user.email}"></c:out></td>
									<td><c:out value="${user.phoneNumber}"></c:out></td>
									<td><c:out value="${user.type}"></c:out></td>
									<td><select class="combobox">
											<option value="PA">Pennsylvania</option>
											<option value="CT">Connecticut</option>
									</select></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>




				</div>
			</div>
			<!-- 			End of Tab #1 -->


			<!-- 				Tab #2 -->
			<div id="test2" class="col s12">
				<div class="container-fluid">
					<div class="row settings-title">
						<h4>
							<fmt:message key="settings.header.CONTACT" />
						</h4>
					</div>


					<table id="requests">
						<thead>
							<tr>
								<th>ID</th>
								<th>userId</th>
								<th>reqDate</th>
								<th>message</th>
								<th>status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="request" items="${requests}">
								<tr
									<c:if test="${request.status == 'PENDING'}">
   					style="background-color: white;"
</c:if>
<c:if test="${request.status != 'PENDING'}">
   					style="background-color: lightgrey;"
</c:if>
>
									<td><a
										href="${pageContext.servletContext.contextPath}/cabinet/admin/request/${request.id}"><c:out
												value="${request.id }"></c:out></a></td>
									<td><c:out value="${request.userId}"></c:out></td>
									<td><c:out value="${request.requestDate}"></c:out></td>
									<td><c:out value="${request.message}"></c:out></td>
									<td style="text-align: center;"><c:if
											test="${request.status == 'PENDING'}">
											<a class="my-btn waves-effect waves-light btn"
												style="background: #26A69A; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px;"
												onclick="chageStatus(${request.id},true,'')">APPROVE</a>
											<a class="my-btn waves-effect waves-light btn"
												style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px;"
												onclick="chageStatus(${request.id},false,'')">DECLINED</a>
										</c:if> <c:if test="${request.status == 'DECLINED'}">
											<div style="color: #F55151;">
												<strong>DeCIde!</strong>
											</div>
										</c:if> <c:if test="${request.status == 'APPROVED'}">
											<div style="color: #3c763d;">
												<strong>Success!</strong>
											</div>

										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<!-- 			End of Tab #2 -->

		</div>
	</div>


	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/tablesorter/jquery-1.10.2.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/settings/settings.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/request.js"></script>

	<script>
		$(document).ready(function() {
			$('input#name, input#surname, input#email').characterCounter();
		});
	</script>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable({
				stateSave : true
			});
			$('#requests').DataTable({
				stateSave : true
			});
		});
	</script>
</body>
</html>
