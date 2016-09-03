
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>${hotel.name}</title>
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link type="image/png" rel="icon" href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">
    <link href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/styleMap.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/simple-sidebar.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css" media="screen,projection" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/languages.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <link rel="stylesheet" href="css/bootstrap-image-gallery.min.css">
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
    
    <link href="${pageContext.servletContext.contextPath}/resources/css/styleMap.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCKs6QYAUVp6Eb7EbfnChID4kNfYjpkLjU"></script>
    <script>
        points = [{
            "id": "<c:out value="${hotel.id}"></c:out>",
            "name": "<c:out value="${hotel.name}"></c:out>",
            "photo": "${pageContext.servletContext.contextPath}/resources/images/${MainPhoto.img}",
            "address": "<c:out value="${hotel.city}"></c:out> <c:out value="${hotel.street}"></c:out>",
            "phone": "225-(254)220-5391",
            "lat": "<c:out value="${hotel.XCoord}"></c:out>",
            "lon": "<c:out value="${hotel.YCoord}"></c:out>",
        }]
    </script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/showHotels.js"></script>
    
    <!-- JTable -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">

    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').DataTable();
        });

    </script>
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
            /* 	background: */
            /* 		url('http://3.bp.blogspot.com/-UXVFcPTKwrk/VC9-GaPAooI/AAAAAAAAFfo/g_uYO8A1PCo/s1600/black%2Bgrey%2Bgradient%2Bbackground%2Bfor%2Bweb.jpg') */
            background: url(${pageContext.servletContext.contextPath}/resources/images/foot.jpg) center center no-repeat;
            background-size: cover;
            &: before {
                content: '';
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
     <div id="blueimp-gallery" class="blueimp-gallery">
        <!-- The container for the modal slides -->
        <div class="slides"></div>
        <!-- Controls for the borderless lightbox -->
        <h3 class="title"></h3>
        <a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a>
        <a class="play-pause"></a>
        <ol class="indicator"></ol>
        <!-- The modal dialog, which will be used to wrap the lightbox content -->
        <div class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" aria-hidden="true">&times;</button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body next"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left prev">
                            <i class="glyphicon glyphicon-chevron-left"></i> Previous
                        </button>
                        <button type="button" class="btn btn-primary next">
                            Next <i class="glyphicon glyphicon-chevron-right"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <input id="lang" type="hidden" value="${language}" />


    <!-- Header ========================================================================= -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Header End====================================================================== -->

    <div class="container" style="margin-top: 20px">

        <div id="links" style="margin-right: 8.3333333333%;">
            <div class="row">
                <div class="col s4">
                    <a href='<c:out value="${mainPhoto.id}"></c:out>' title="Banana" data-gallery> <img
						src="<c:out value="${mainPhoto.img}"></c:out>" alt="Banana">
					</a>
                    <div style="overflow-x: auto;">
                        <div style="margin: 10px; white-space: nowrap;">
                            <c:forEach items="${hotelPhotos}" var="photo">
                                <div style="display: inline-block;">
                                    <a href='<c:out value="${photo.img }"></c:out>' title="<c:out value=" ${photo.img } "></c:out>" data-gallery>
										<img style="height: 60px;"
										src="<c:out value="${photo.img }"></c:out>"
										alt="<c:out value="${photo.img }"></c:out>">
									</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="col s8">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col s6">
                                <h5>
									<c:out value="${hotel.name }"></c:out>
								</h5>
                            </div>
                            <div class="col s4 offset-s1" style="margin-top: 15px;">
                                <c:forEach var="i" begin="1" end="${hotel.stars}">
                                    <i class="fa fa-lg fa-star-o" aria-hidden="true"></i>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row">
                            <i class="fa fa-lg icon-map-marker" aria-hidden="true"></i>
                            <a id="togle">${hotel.city}	${hotel.street}</a>
                        </div>

                        <div class="row" style="margin-bottom: 5px">
                            <i class="material-icons" style="font-size: 20px;">receipt</i> <span>${hotel.desc}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="togle_place" class="col s12" style="margin-top: 18px;">
            <div id="google_map" style="height: 400px; width: 83%;"></div>
        </div>
    </div>
    <div class="container">
        <div id="switchContent" class="row">
            <jsp:include page="roomCard.jsp"></jsp:include>
        </div>
    </div>

    <!-- Footer ========================================================================== -->
    <jsp:include page="foot.jsp"></jsp:include>
    <!-- Footer End====================================================================== -->
    
    <script src="${pageContext.servletContext.contextPath}/resources/js/customerSlider.js"></script>
    
</body>

</html>
