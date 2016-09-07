<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Booker | My Orders</title>
<link rel="icon" type="image/ico"
	href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.ico">
<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/simple-sidebar.css"
	rel="stylesheet">

<!--  <link type="text/css" rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css"
	media="screen,projection" /> 

 -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/languages.min.css">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="all"
	href="${pageContext.servletContext.contextPath}/resources/css/tablesorter/styles.css">
	 -->

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.6/dt-1.10.12/af-2.1.2/b-colvis-1.2.2/b-flash-1.2.2/rr-1.1.2/sc-1.4.2/se-1.2.0/datatables.min.css"/>

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

tr {
	height: 15px;
}

tr:nth-child(even) {
	background-color: #eee;
}

tr:nth-child(odd) {
	background-color: #fff;
}

th {
	background-color: #E0C022;
	color: white;
}

td, th {
	text-align: center;
}

.purchase-table {
	margin-top: 20px;
	margin-bottom: 40px;
}

.tabs {
	box-shadow: 0 3px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
	transition: box-shadow .25s;
	border-radius: 5px;
	background-color: #F3EAEA;
}

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
.container .row {margin-bottom: 0px;}
.dataTables_length {margin-top: 20px;}
.row {margin-bottom: 0px;}
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
			<fmt:message key="subscribes.header" />
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #638F98;">
					<li class="tab col s3"><a class="active" href="#test1"
						style="color: #1A3D44"><b><p id="tab_active">ACTIVE</p></b></a></li>
					<li class="tab col s3"><a href="#test2" style="color: #1A3D44"><b><p
									id="tab_ended">ENDED</p></b></a></li>
					<li class="tab col s3"><a href="#test3" style="color: #1A3D44"><b><p
									id="tab_all">ALL</p></b></a></li>
				</ul>
			</div>
			<!-- 			End of Tab Holder -->


			<!-- 				Tab #1 -->
			<div id="test1" class="col s12">
				<c:choose>
					<c:when test="${activeSubsSize != 0}">
						<table id="tab1" class="purchase-table">
							<thead>
								<tr>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_id">ID</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_date">HOTEL NAME</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_room">ROOM_TYPE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_sdate">START_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_edate">END_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_price">PRICE</p></th>
									<th style="text-align: center; border-radius: 0;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="activeOrder" items="${activeOrders}">
									<tr class="order${activeOrder.id}">
										<td class="lalign" style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/cabinet/order/${activeOrder.id}">#${activeOrder.id}</a></td>

										<td style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/hotel/${activeOrder.hotel.id}">${activeOrder.hotel.name}</a></td>

										<td style="text-align: center;">${activeOrder.room.type}</td>

										<td style="text-align: center;"><span
											id="start_date${activeOrder.id}">${activeOrder.startDate}</span></td>

										<td style="text-align: center;"><span
											id="end_date${activeOrder.id}">${activeOrder.endDate}</span></td>

										<script type="text/javascript"
											src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

										<script>
									var id = ${activeOrder.id};
									changeDate(id);</script>

										<td style="text-align: center;">${activeOrder.price}</td>

										<td style="text-align: center;"><a
											class="my-btn waves-effect waves-light btn"
											style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px;"
											onclick="removeOrderTable(${activeOrder.id})"><fmt:message
													key="subscribes.table.remove" /> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!--<div class="pager" id="pager1">
							<form>
								<img src="first.png" class="first" /> <img src="prev.png"
									class="prev" /> <span class="pagedisplay"></span>
								 this can be any element, including an input
								<img src="next.png" class="next" /> <img src="last.png"
									class="last" /> <select class="pagesize">
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="all">All Rows</option>
								</select>
							</form>
						</div> -->
					</c:when>
					<c:otherwise>
						<h5 style="color: red; margin-top: 55px; margin-left: 250px;">
							<fmt:message key="subscribes.empty" />
						</h5>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 			End of Tab #1 -->


			<!-- 				Tab #2 -->
			<div id="test2" class="col s12">
				<c:choose>
					<c:when test="${historySubsSize != 0}">
						<table id="tab2" class="purchase-table">
							<thead>
								<tr>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_id">ID</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_date">HOTEL NAME</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_room">ROOM_TYPE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_sdate">START_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_edate">END_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_price">PRICE</p></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="finishedOrder" items="${finishedOrders}">
									<tr class="order${finishedOrder.id}">
										<td class="lalign" style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/cabinet/order/${finishedOrder.id}">#${finishedOrder.id}</a></td>

										<td style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/hotel/${finishedOrder.hotel.id}">${finishedOrder.hotel.name}</a></td>

										<td style="text-align: center;">${finishedOrder.room.type}</td>

										<td style="text-align: center;"><span
											id="start_date${finishedOrder.id}">${finishedOrder.startDate}</span></td>

										<td style="text-align: center;"><span
											id="end_date${finishedOrder.id}">${finishedOrder.endDate}</span></td>

										<script type="text/javascript"
											src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

										<script>
									var id = ${finishedOrder.id};
									changeDate(id);</script>

										<td style="text-align: center;">${finishedOrder.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					<!-- 	<div class="pager" id="pager2">
							<form>
								<img src="first.png" class="first" /> <img src="prev.png"
									class="prev" /> <span class="pagedisplay"></span>
								<!-- this can be any element, including an input 
								<img src="next.png" class="next" /> <img src="last.png"
									class="last" /> <select class="pagesize">
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="all">All Rows</option>
								</select>
							</form>
						</div> -->
					</c:when>
					<c:otherwise>
						<h5 style="color: red; margin-top: 55px; margin-left: 250px;">
							<fmt:message key="subscribes.empty" />
						</h5>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 			End of Tab #2 -->


			<!-- 			Tab #3 -->
			<div id="test3" class="col s12">
				<c:choose>
					<c:when test="${allSubsSize != 0}">
						<table id="tab3" class="purchase-table">
							<thead>
								<tr>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_id">ID</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_date">HOTEL NAME</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_room">ROOM_TYPE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_sdate">START_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_edate">END_DATE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_price">PRICE</p></th>
									<th style="text-align: center; border-radius: 0;"><p
											id="tb_head_status">STATUS</p></th>
									<th style="text-align: center; border-radius: 0;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="allOrder" items="${allOrders}">
									<tr class="order${allOrder.id}">
										<td class="lalign" style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/cabinet/order/${allOrder.id}">#${allOrder.id}</a></td>

										<td style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/hotel/${allOrder.hotel.id}">${allOrder.hotel.name}</a></td>

										<td style="text-align: center;">${allOrder.room.type}</td>

										<td style="text-align: center;"><span
											id="start_date${allOrder.id}">${allOrder.startDate}</span></td>

										<td style="text-align: center;"><span
											id="end_date${allOrder.id}">${allOrder.endDate}</span></td>

										<script type="text/javascript"
											src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

										<script>
									var id = ${allOrder.id};
									changeDate(id);</script>

										<td style="text-align: center;">${allOrder.price}</td>

										<c:choose>
											<c:when test="${allOrder.status == 'ACTIVE'}">
												<td class="lalign"
													style="text-align: center; color: #70C67C"><fmt:message
														key="card.status.active" /></td>
												<td style="text-align: center;"><a
													class="my-btn waves-effect waves-light btn"
													style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif; border-radius: 25px;"
													onclick="removeOrderTable(${allOrder.id})"><fmt:message
															key="subscribes.table.remove" /> </a></td>
											</c:when>
											<c:when test="${allOrder.status == 'CANCELED'}">
												<td style="text-align: center; color: #666666"><fmt:message
														key="card.status.removed" /></td>

												<td style="text-align: center; color: #F55151"><b></b></td>
											</c:when>
											<c:otherwise>
												<td style="text-align: center; color: #F55151"><fmt:message
														key="card.status.ended" /></td>
												<td style="text-align: center; color: #F55151"><b></b></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				<!-- 		<div class="pager" id="pager3">
							<form>
								<img src="first.png" class="first" /> <img src="prev.png"
									class="prev" /> <span class="pagedisplay"></span>
								<!-- this can be any element, including an input 
								<img src="next.png" class="next" /> <img src="last.png"
									class="last" /> <select class="pagesize">
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="all">All Rows</option>
								</select>
							</form>
						</div> -->
					</c:when>
					<c:otherwise>
						<h5 style="color: red; margin-top: 55px; margin-left: 250px;">
							<fmt:message key="subscribes.empty" />
						</h5>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 			End of Tab #3 -->

		</div>
	</div>

	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer End====================================================================== -->
<!--  
	<script type="text/javascript">
$(document).ready(function() 
	    { 	
// 	var pagerOptions = {
// 		    container: $("#pager1"),
// 		    // Number of visible rows - default is 10
// 		    size: 10,
// 		  };	
	        $("#tab1").tablesorter(); 
	        $("#tab1").tablesorterPager({container: $("#pager1"),size: 10}); 
	        $("#tab3").tablesorter();
	        $("#tab3").tablesorterPager({container: $("#pager3"),size: 10});  
	    } 
	); 
</script>

<script type="text/javascript">
$(document).ready(function() 
	    { 	
    $("#tab2").tablesorter(); 
    $("#tab3").tablesorterPager({container: $("#pager2"),size: 10}); 
} 
); 
</script>

<script type="text/javascript">
$(document).ready(function() 
	    { 	
    $("#tab3").tablesorter();
    $("#tab3").tablesorterPager({container: $("#pager3"),size: 10});  
} 
); 
</script>

 --><script type="text/javascript"
		src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.6/dt-1.10.12/af-2.1.2/b-colvis-1.2.2/b-flash-1.2.2/rr-1.1.2/sc-1.4.2/se-1.2.0/datatables.min.js"></script>

	<script type="text/javascript">
	$(document).ready(function() {
	    $('#tab1').DataTable();
	} );
	$(document).ready(function() {
	    $('#tab2').DataTable();
	} );
	$(document).ready(function() {
	    $('#tab3').DataTable();
	} );
	</script>
 

	<!--  <script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery-3.1.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/tablesorter/jquery.tablesorter.min.js"></script>-->
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/order/removeOrder.js"></script>





</body>
</html>
