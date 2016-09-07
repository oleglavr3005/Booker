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
<title>MAIN PAGE</title>

<link
	href="${pageContext.servletContext.contextPath}/resources/css/rangeSlider/rangeStyle.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/star-rating/star-rating.css"
	rel="stylesheet">

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


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/table.css">
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
</head>


<body>
	<input id="photos" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />
	<input id="lang" type="hidden" value="${language}" />
	<input id="mapping" type="hidden"
		value="${pageContext.servletContext.contextPath}/" />


	<!-- Header ========================================================================= -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container" style="margin-top: 20px">

		<div class="row">
			<div class="col s3">
				<div class="row">
					<!-- 					PHOTO -->
					<a href="#!"><img id="avatarImg"
						style="height: 100px; padding: 10px; width: 110px;"
						<%-- 								src="${pageContext.servletContext.contextPath}/resources/images/avatar/${user.image}"> --%>
								src="<i:urlToImage url="${hotel.photos }" />">
					</a>
					<!-- 					END OF PHOTO -->
					<!-- 				INPUT -->
					<%-- 				<input style="margin-top: 60px" type="file" id="avatarInput" --%>
					<%-- 					onchange="showPhoto()" accept="image/*" /> --%>
					<!-- 				END OF INPUT -->

					<a class="waves-effect waves-light btn" id="create_button"
						onclick="updateHotel()"
						style="margin-left: 10px; margin-top: 100px; background: #26A69A; color: #F7F7F7; font-family: 'Times NewRoman', Times, serif;"><span>UPDATE</span></a>
					<p id="create_error" style="color: red"></p>
				</div>
				<div class="row">
					<p>
						<input type="checkbox" class="filled-in" id="isDeleted"
							name="isDeleted" /> <label for="isDeleted">DELETED</label>
					</p>
					
					<script>
						$('#isDeleted').attr('checked',
								'${hotel.isDeleted}' == 'true');
					</script>
					
				</div>


			</div>


			<div class="col s9">
				<div class="container-fluid">

					<div class="row">
						<div class="col s6">

							<!-- 						NAME -->

							<div class="input-field">
								<input id="name" type="text" class="validate" length="45"
									value="${hotel.name}" placeholder="Name of Hotel"> <label
									id="nameLbl" data-error="${fmtName}" for="name"><fmt:message
										key="admin.edit.name" /></label>
							</div>

							<!-- 							END OF NAME -->

						</div>
					</div>

					<div class="row">
						<div class="col s7">

							<!-- 						STARS -->
							<input id="rating" onchange="rate()" type="number"
								value="${hotel.stars}" class="rating" min=0 max=5 step=1
								data-size="xs" data-stars="5"> <span
								style="margin-left: 25px; margin-top: 20px; padding-top: 20px;"><fmt:message
									key="manager.hotel.star" />STAR : <span id="rate_span">0</span>
								/ 5 |</span>
							<script>
								function rate() {

									var count = document
											.getElementById("rate_span");
									count.innerHTML = $('#rating').val();

								}
							</script>

							<!-- 							END OF STARS -->

						</div>
					</div>

					<div class="row">

						<div class="col s4">

							<!-- 						CITY -->

							<div class="input-field">
								<input id="city" type="text" class="validate" length="45"
									placeholder="Name of city" value="${hotel.city}"> <label
									id="cityLbl" data-error="${fmtName}" for="city"><fmt:message
										key="admin.edit.city" /></label>
							</div>

							<!-- 							END OF CITY -->

						</div>

						<div class="col s4">

							<!-- 						STREET -->

							<div class="input-field">
								<input id="street" type="text" class="validate" length="45"
									placeholder="Name of street" value="${hotel.street}"> <label
									id="streetLbl" data-error="${fmtName}" for="street"><fmt:message
										key="admin.edit.street" /></label>
							</div>

							<!-- 							END OF STREET -->

						</div>


						<div class="col s4">

							<!-- 						PHONE -->

							<div class="input-field">
								<input id="phone" type="text" class="validate" length="45"
									placeholder="Name of phone" value="${hotel.phoneNumber}">
								<label id="phoneLbl" data-error="${fmtName}" for="phone"><fmt:message
										key="admin.edit.phone" /></label>
							</div>

							<!-- 							END OF PHONE -->

						</div>




					</div>

					<div class="row">

						<div class="col s12">

							<!-- 						DESC -->

							<div class="input-field">
								<textarea placeholder="Desc" id="desc"
									class="materialize-textarea" class="validate" length="999">${hotel.desc}</textarea>
								<label id="descLbl" data-error="${fmtName}" for="desc"><fmt:message
										key="admin.edit.desc" /></label>
							</div>

							<!-- 							END OF DESC -->

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>



	<div class="container-fluid">
		<div class="row">
			<div id="admin" class="col s12">
				<div class="card material-table">
					<div class="table-header">
						<span class="table-title">Rooms</span>
						<div class="actions">
							<a href="#add_users"
								class="modal-trigger waves-effect btn-flat nopadding"><i
								class="material-icons">playlist_add</i></a> <a href="#"
								class="search-toggle waves-effect btn-flat nopadding"><i
								class="material-icons">search</i></a>
						</div>
					</div>
					<table id="datatable">
						<thead>
							<tr>
								<th>#</th>
								<th>Type</th>
								<th>Capacity</th>
								<th>Convinions</th>
								<th>Food</th>
								<th>Free Book</th>
								<th>Deleted</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="room" items="${rooms}">
								<tr>
									<td><c:out value="${room.number }"></c:out></td>
									<td><c:out value="${room.type }"></c:out></td>
									<td>${room.doubleBedsCount * 2 + room.bedsCount}</td>
									<td><c:if test="${room.wifi == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Wifi" style="color: #0d0d0d;"><i
												class="material-icons invert">wifi</i></a>
										</c:if> <c:if test="${room.shower == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Shower"><img class="invert"
												style="max-width: 15%; margin-top: -1rem"
												src="${pageContext.servletContext.contextPath}/resources/images/Shower-512.png" /></a>
										</c:if> <c:if test="${room.parking == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Parking" style="color: #0d0d0d;"><i
												class="material-icons invert">local_parking</i></a>
										</c:if> <c:if test="${room.condition == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Condition" style="color: #0d0d0d;"><i
												class="material-icons invert">toys</i></a>
										</c:if> <c:if test="${room.pool == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Pool" style="color: #0d0d0d;"><i
												class="material-icons invert">pool</i></a>
										</c:if> <c:if test="${room.gym == true}">
											<a class="tooltipped" data-position="icon" data-tooltip="Gym"
												style="color: #0d0d0d;"><i class="material-icons invert">fitness_center</i></a>
										</c:if> <c:if test="${room.balcony == true}">
											<a class="tooltipped" data-position="icon"
												data-tooltip="Balcony"><img class="invert"
												style="max-width: 15%; margin-top: -1rem"
												src="${pageContext.servletContext.contextPath}/resources/images/balcony.png" /></a>
										</c:if></td>
									<td><a class="tooltipped" data-position="icon"
										data-tooltip="Food" style="color: #0d0d0d;"><i
											class="fa fa-lg fa-cutlery invert" aria-hidden="true"></i></a> <span>${room.food}</span></td>
									<td><c:if test="${room.daysCount >= 0}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if> <c:if test="${room.daysCount < 0}">
											<span class="glyphicon glyphicon-remove-sign"
												aria-hidden="true"></span>
										</c:if></td>
									<td><c:if test="${room.deleted}">
											<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
										</c:if> <c:if test="${room.deleted}">
											<span class="glyphicon glyphicon-remove-sign"
												aria-hidden="true"></span>
										</c:if></td>
									<td><c:out value="${room.price }"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer ========================================================================== -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- Footer END==================================================================== -->
	<script src="//code.jquery.com/jquery-1.12.3.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/star-rating/star-rating.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/manager/hotel.js"></script>

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
							$('#datatable')
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
// 												aoColumnDefs : [ {
// 													sWidth : "18%",
// 													aTargets : [ 3 ]
// 												}, {
// 													sWidth : "7%",
// 													aTargets : [ 0 ]
// 												}, {
// 													sWidth : "7%",
// 													aTargets : [ 6 ]
// 												} ]

											});
						});
	</script>

	<!-- 
 
//-->
</body>

</html>