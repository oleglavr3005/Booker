<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>


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

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/style.css">
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

	<div class="container-fluid">

		<h4 style="text-align: center; margin-top: 20px;">
			<span id="admin_header"></span>
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #12444c;">
					<li id="admin_page_users" class="tab col s5 offset-s1"><a
						class="active" href="#test1" style="color: #F7F7F7"><b><p
									id="tab_users"></p></b></a></li>
					<li class="tab col s5 offset-s1"><a href="#test2"
						style="color: #F7F7F7"><b><p id="tab_request"></p></b></a></li>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<div class="container-fluid">
					<div class="row settings-title">
						<h4 style="text-align: center; margin-top: 20px;">
							<span id="settings_header_USERS"></span>
						</h4>
					</div>

					<table id="users" style="border-bottom: 0px solid #111;">
						<thead>
							<tr style="background-color: #70b9b2; color: #e8f7f7;">
								<th id="admin_page_id"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_fName"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_lName"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_mail"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_phone"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_type"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th id="admin_page_status"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td><c:out value="${user.id }"></c:out></td>
									<td><c:out value="${user.firstName}"></c:out></td>
									<td><c:out value="${user.lastName}"></c:out></td>
									<td><c:choose>
											<c:when
												test="${user.email.substring(user.email.length()-1) != '*'}">
												<c:out value="${user.email}"></c:out>
											</c:when>
											<c:otherwise>
												<span class='admin_page_no_email'>No email for this
													user</span>
											</c:otherwise>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${user.phoneNumber.length() > 0}">
												<c:out value="${user.phoneNumber}"></c:out>
											</c:when>
											<c:otherwise>
												<span class='admin_page_no_phone'>No phone for this
													user</span>
											</c:otherwise>
										</c:choose></td>
									<td><c:out value="${user.type}"></c:out></td>
									<td><select id="userStatus${user.id}" class="combobox"
										onchange="changeUserStatus(${user.id})">
											<option class="admin_page_active" value="ACTIVE"
												<c:if test="${user.status == 'ACTIVE'}"> selected="selected"</c:if>></option>
											<option class="admin_page_banned" value="BANNED"
												<c:if test="${user.status == 'BANNED'}"> selected="selected"</c:if>></option>
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
						<h4 style="text-align: center; margin-top: 20px;">
							<span id="settings_header_REQUESTS"></span>
						</h4>
					</div>


					<table id="requests" style="border-bottom: 0px solid #111;">
						<thead>
							<tr style="background-color: #70b9b2; color: #e8f7f7;">
								<th class="admin_page_id"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th class="admin_page_userId"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th class="admin_page_reqDate"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th class="admin_page_message"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
								<th class="admin_page_status"
									style="text-align: center; border-radius: 0; border-bottom: 0px solid #111;"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="request" items="${requests}">
								<tr id="req${request.id }"
									<c:if test="${request.status == 'PENDING'}"> style="background-color: white;"</c:if>
									<c:if test="${request.status != 'PENDING'}">style="background-color: lightgrey;"</c:if>>
									<td><c:out value="${request.id }"></c:out></td>
									<td><c:out value="${request.userId}"></c:out></td>
									<td><c:out value="${request.requestDate}"></c:out></td>
									<td><a
										href="${pageContext.servletContext.contextPath}/cabinet/admin/request/${request.id}"><c:out
												value="${request.message}"></c:out></a></td>
									<td style="text-align: center;" id="req${request.id }s"><c:if
											test="${request.status == 'PENDING'}">
											<div id="req${request.id }d">
												<a class="my-btn waves-effect waves-light btn"
													style="background: #26A69A; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif;"
													onclick="chageStatus(${request.id},true,'')"><i
													class="fa fa-check-circle" aria-hidden="true"></i></a> <a
													class="my-btn waves-effect waves-light btn"
													style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif;"
													onclick="chageStatus(${request.id},false,'')"><i
													class="fa fa-times-circle" aria-hidden="true"></i></a>
											</div>
											<div style="color: #F55151;" class="hidden"
												id="req${request.id }dc">
												<strong><span class="btn_declined"></span></strong>
											</div>
											<div style="color: #3c763d;" class="hidden"
												id="req${request.id }ap">
												<strong><span class="btn_approved"></span></strong>
											</div>

										</c:if>
										<c:if test="${request.status == 'DECLINED'}">
											<div style="color: #F55151;">
												<strong><span class="btn_declined"></span></strong>
											</div>
										</c:if> <c:if test="${request.status == 'APPROVED'}">
											<div style="color: #3c763d;">
												<strong><span class="btn_approved"></span></strong>
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
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/admin/adminPage.js"></script>

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
				stateSave : true,
				'length.dt': function(settings ) {
					$('#users').ready(updateLanguage()); 
					console.log('1');
		                },
							'drawCallback': function(settings ) {
								$('#users').ready(updateLanguage()); 
								console.log('2');
					                }
			});
			$('#requests').DataTable({
				stateSave : true
			});
		});
	</script>
</body>
</html>
