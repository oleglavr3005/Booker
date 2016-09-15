<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="i" uri="../../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<link type="text/css" rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/languages.min.css">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/table.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/style.css">

<link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.5.1.css">
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

div .table-footer {
	height: 56px;
	padding-left: 24px;
	padding-right: 14px;
	display: -webkit-flex;
	display: flex;
	-webkit-flex-direction: row;
	flex-direction: row;
	-webkit-justify-content: flex-end;
	justify-content: flex-end;
	-webkit-align-items: center;
	align-items: center;
	font-size: 12px !important;
	color: rgba(0, 0, 0, 0.54);
}

div.material-table .table-footer .dataTables_length {
	display: -webkit-flex;
	display: flex;
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

		<h4 style="text-align: center; margin-top: 20px; color: #387f7b;">
			<span id="subscribes_header"></span>
		</h4>

		<div class="row">

			<!-- 			Tab Holder -->
			<div class="col s8 offset-s2">
				<ul class="tabs" style="background: #12444c;">
					<li class="tab col s3"><a class="active" href="#test1"
						style="color: #F7F7F7"><b><p id="tab_active"></p></b></a></li>
					<li class="tab col s3"><a href="#test2" style="color: #F7F7F7"><b>
								<p id="tab_ended"></p>
						</b></a></li>
					<li class="tab col s3"><a href="#test3" style="color: #F7F7F7"><b>
								<p id="tab_all"></p>
						</b></a></li>
					<li class="tab col s3"><a href="#test4" style="color: #F7F7F7"><b>
								<p id="tab_charts">CHARTS</p>
						</b></a></li>
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
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_id"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_name"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_room"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_sdate"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_edate"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;">
										<p class="tb_head_price"></p>
									</th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="activeOrder" items="${activeOrders}">
									<tr class="order${activeOrder.id}">
										<td class="lalign" style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/cabinet/order/${activeOrder.id}">#${activeOrder.id}</a></td>

										<td style="text-align: center;"><a
											href="${pageContext.servletContext.contextPath}/hotel/${activeOrder.hotel.id}">${activeOrder.hotel.name}</a></td>

										<td style="text-align: center;">
											<c:if test="${activeOrder.room.type == 'STANDART'}">
												<span id="subscribes_table_roomtype_standart"></span>
											</c:if> <c:if test="${activeOrder.room.type == 'LUX'}">
												<span id="subscribes_table_roomtype_lux"></span>
											</c:if> <c:if test="${activeOrder.room.type == 'DELUX'}">
												<span id="subscribes_table_roomtype_delux"></span>
											</c:if>
										</td>

										<td style="text-align: center;"><span
											id="start_date${activeOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${activeOrder.startDate}" /></span></td>

										<td style="text-align: center;"><span
											id="end_date${activeOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${activeOrder.endDate}" /></span></td>

										<script type="text/javascript"
											src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

										<script>
											var id = ${activeOrder.id};
											changeDate(id);
										</script>

										<td style="text-align: center;">${activeOrder.price}</td>

										<td style="text-align: center;"><span style="color: red"
											id="active_after_status${activeOrder.id}"></span><a
											id="active_btn${activeOrder.id }"
											class="my-btn waves-effect waves-light btn"
											style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif;"
											onclick="removeOrderTable(${activeOrder.id})"> <span
												class="subscribes_table_remove"></span>
										</a></td>
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
							<span id="subscribes_empty"></span>
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
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_id"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_name"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_room"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_sdate"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_edate"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_price"></p></th>
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
											id="start_date${finishedOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${finishedOrder.startDate}" /></span></td>

										<td style="text-align: center;"><span
											id="end_date${finishedOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${finishedOrder.endDate}" /></span></td>

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
							<span id="subscribes_empty"></span>
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
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_id">ID</p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_name"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_room"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_sdate"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_edate"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_price"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"><p
											class="tb_head_status"></p></th>
									<th
										style="text-align: center; border-radius: 0; background-color: #70b9b2; color: #e8f7f7;"></th>
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
											id="start_date${allOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${allOrder.startDate}" /></span></td>

										<td style="text-align: center;"><span
											id="end_date${allOrder.id}"><fmt:formatDate
													pattern="yyyy-MM-dd" value="${allOrder.endDate}" /></span></td>

										<script type="text/javascript"
											src="${pageContext.servletContext.contextPath}/resources/js/order/format.js"></script>

										<script>
									var id = ${allOrder.id};
									changeDate(id);</script>

										<td style="text-align: center;">${allOrder.price}</td>

										<c:choose>
											<c:when test="${allOrder.status == 'ACTIVE'}">
												<td class="lalign"
													style="text-align: center; color: #70C67C"><span
													class="card_status_active"></span></td>
												<td style="text-align: center;"><span
													style="color: red" id="all_after_status${allOrder.id}"></span>
													<a id="all_btn${allOrder.id }"
													class="my-btn waves-effect waves-light btn"
													style="background: #F55151; color: #FFFFFF; font-family: 'Times NewRoman', Times, serif;"
													onclick="removeOrderTable(${allOrder.id})"> <span
														class="subscribes_table_remove"></span>
												</a></td>
											</c:when>
											<c:when test="${allOrder.status == 'CANCELED'}">
												<td style="text-align: center; color: #666666"><span
													class="card_status_removed"></span></td>

												<td style="text-align: center; color: #F55151"><b></b></td>
											</c:when>
											<c:otherwise>
												<td style="text-align: center; color: #F55151"><span
													class="card_status_ended"></span></td>
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
							<span id="subscribes_empty"></span>
						</h5>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 			End of Tab #3 -->


			<!-- 				Tab #4 -->
			<div id="test4" class="col s12">

				<div>
					<h4 style="text-align: center; margin-top: 20px;">
						<span id="orders_charts_HOTELSCHART">MOST VISITED HOTELS</span>
					</h4>
					<div id="donutChart" style="height: 250px; float: left"></div>
				</div>

				<div>
					<h4 style="text-align: center; margin-top: 200px;">
						<span id="orders_charts_MONTHCHART">MONTHLY ACTIVITY</span>
					</h4>
					<div id="lineChart" style="height: 250px; margin-bottom: 30px"></div>
				</div>

			</div>
			<!-- 			End of Tab #4 -->

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

 -->
	<script src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">
	(function(window, document, undefined) {

		var factory = function($, DataTable) {
			"use strict";

			$('.search-toggle').click(function() {
				if ($('.hiddensearch').css('display') == 'none')
					$('.hiddensearch').slideDown();
				else
					$('.hiddensearch').slideUp();
			});

			/* Set the defaults for DataTables initialisation */
			$.extend(true, DataTable.defaults, {
				dom : "<'hiddensearch'f'>" + "tr" + "<'table-footer'lip'>",
				renderer : 'material'
			});

			/* Default class modification */
			$.extend(DataTable.ext.classes, {
				sWrapper : "dataTables_wrapper",
				sFilterInput : "form-control input-sm",
				sLengthSelect : "form-control input-sm"
			});

			/* Bootstrap paging button renderer */
			DataTable.ext.renderer.pageButton.material = function(settings,
					host, idx, buttons, page, pages) {
				var api = new DataTable.Api(settings);
				var classes = settings.oClasses;
				var lang = settings.oLanguage.oPaginate;
				var btnDisplay, btnClass, counter = 0;

				var attach = function(container, buttons) {
					var i, ien, node, button;
					var clickHandler = function(e) {
						e.preventDefault();
						if (!$(e.currentTarget).hasClass('disabled')) {
							api.page(e.data.action).draw(false);
						}
					};

					for (i = 0, ien = buttons.length; i < ien; i++) {
						button = buttons[i];

						if ($.isArray(button)) {
							attach(container, button);
						} else {
							btnDisplay = '';
							btnClass = '';

							switch (button) {

							case 'first':
								btnDisplay = lang.sFirst;
								btnClass = button
										+ (page > 0 ? '' : ' disabled');
								break;

							case 'previous':
								btnDisplay = '<i class="material-icons">chevron_left</i>';
								btnClass = button
										+ (page > 0 ? '' : ' disabled');
								break;

							case 'next':
								btnDisplay = '<i class="material-icons">chevron_right</i>';
								btnClass = button
										+ (page < pages - 1 ? ''
												: ' disabled');
								break;

							case 'last':
								btnDisplay = lang.sLast;
								btnClass = button
										+ (page < pages - 1 ? ''
												: ' disabled');
								break;

							}

							if (btnDisplay) {
								node = $(
										'<li>',
										{
											'class' : classes.sPageButton
													+ ' ' + btnClass,
											'id' : idx === 0
													&& typeof button === 'string' ? settings.sTableId
													+ '_' + button
													: null
										}).append($('<a>', {
									'href' : '#',
									'aria-controls' : settings.sTableId,
									'data-dt-idx' : counter,
									'tabindex' : settings.iTabIndex
								}).html(btnDisplay)).appendTo(container);

								settings.oApi._fnBindAction(node, {
									action : button
								}, clickHandler);

								counter++;
							}
						}
					}
				};

				// IE9 throws an 'unknown error' if document.activeElement is used
				// inside an iframe or frame. 
				var activeEl;

				try {
					// Because this approach is destroying and recreating the paging
					// elements, focus is lost on the select button which is bad for
					// accessibility. So we want to restore focus once the draw has
					// completed
					activeEl = $(document.activeElement).data('dt-idx');
				} catch (e) {
				}

				attach($(host).empty().html('<ul class="pagination"/>')
						.children('ul'), buttons);

				if (activeEl) {
					$(host).find('[data-dt-idx=' + activeEl + ']').focus();
				}
			};

			/*
			 * TableTools Bootstrap compatibility
			 * Required TableTools 2.1+
			 */
			if (DataTable.TableTools) {
				// Set the classes that TableTools uses to something suitable for Bootstrap
				$.extend(true, DataTable.TableTools.classes, {
					"container" : "DTTT btn-group",
					"buttons" : {
						"normal" : "btn btn-default",
						"disabled" : "disabled"
					},
					"collection" : {
						"container" : "DTTT_dropdown dropdown-menu",
						"buttons" : {
							"normal" : "",
							"disabled" : "disabled"
						}
					},
					"print" : {
						"info" : "DTTT_print_info"
					},
					"select" : {
						"row" : "active"
					}
				});

				// Have the collection use a material compatible drop down
				$.extend(true, DataTable.TableTools.DEFAULTS.oTags, {
					"collection" : {
						"container" : "ul",
						"button" : "li",
						"liner" : "a"
					}
				});
			}

		}; // /factory

		// Define as an AMD module if possible
		if (typeof define === 'function' && define.amd) {
			define([ 'jquery', 'datatables' ], factory);
		} else if (typeof exports === 'object') {
			// Node/CommonJS
			factory(require('jquery'), require('datatables'));
		} else if (jQuery) {
			// Otherwise simply initialise as normal, stopping multiple evaluation
			factory(jQuery, jQuery.fn.dataTable);
		}

	})(window, document);

	$(document)
			.ready(
					function() {
						$('#tab1')
								.dataTable(
										{
											"oLanguage" : {
												"sStripClasses" : "",
												"sSearch" : "",
												"sSearchPlaceholder" : "Enter Keywords Here",
												"sInfo" : "_START_ -_END_ of _TOTAL_",
												"sLengthMenu" : '<span>Rows per page:</span><select class="browser-default">'
														+ '<option value="10">10</option>'
														+ '<option value="20">20</option>'
														+ '<option value="30">30</option>'
														+ '<option value="40">40</option>'
														+ '<option value="50">50</option>'
														+ '<option value="-1">All</option>'
														+ '</select></div>'
											},
											bAutoWidth : false
//												aoColumnDefs : [ {
//													sWidth : "18%",
//													aTargets : [ 3 ]
//												}, {
//													sWidth : "7%",
//													aTargets : [ 0 ]
//												}, {
//													sWidth : "7%",
//													aTargets : [ 6 ]
//												} ]

										});
					});
	$(document)
	.ready(
			function() {
				$('#tab2')
						.dataTable(
								{
									"oLanguage" : {
										"sStripClasses" : "",
										"sSearch" : "",
										"sSearchPlaceholder" : "Enter Keywords Here",
										"sInfo" : "_START_ -_END_ of _TOTAL_",
										"sLengthMenu" : '<span>Rows per page:</span><select class="browser-default">'
												+ '<option value="10">10</option>'
												+ '<option value="20">20</option>'
												+ '<option value="30">30</option>'
												+ '<option value="40">40</option>'
												+ '<option value="50">50</option>'
												+ '<option value="-1">All</option>'
												+ '</select></div>'
									},
									bAutoWidth : false
//										aoColumnDefs : [ {
//											sWidth : "18%",
//											aTargets : [ 3 ]
//										}, {
//											sWidth : "7%",
//											aTargets : [ 0 ]
//										}, {
//											sWidth : "7%",
//											aTargets : [ 6 ]
//										} ]

								});
			});
	$(document)
	.ready(
			function() {
				$('#tab3')
						.dataTable(
								{
									"oLanguage" : {
										"sStripClasses" : "",
										"sSearch" : "",
										"sSearchPlaceholder" : "Enter Keywords Here",
										"sInfo" : "_START_ -_END_ of _TOTAL_",
										"sLengthMenu" : '<span>Rows per page:</span><select class="browser-default">'
												+ '<option value="10">10</option>'
												+ '<option value="20">20</option>'
												+ '<option value="30">30</option>'
												+ '<option value="40">40</option>'
												+ '<option value="50">50</option>'
												+ '<option value="-1">All</option>'
												+ '</select></div>'
									},
									bAutoWidth : false
//										aoColumnDefs : [ {
//											sWidth : "18%",
//											aTargets : [ 3 ]
//										}, {
//											sWidth : "7%",
//											aTargets : [ 0 ]
//										}, {
//											sWidth : "7%",
//											aTargets : [ 6 ]
//										} ]

								});
			});
	</script>


	<!--  <script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery-3.1.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/tablesorter/jquery.tablesorter.min.js"></script>-->
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/order/removeOrder.js"></script>

	<!-- CHARTS -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/charts/charts.js"></script>


</body>
</html>
