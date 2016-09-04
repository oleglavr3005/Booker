<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="i" uri="../WEB-INF/PrintImage.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="hotel_card_${room.id}" class="col s10 offset-s1">
	<div class="card">
		<c:forEach var="room" items="${rooms}">
		<div class="row add_bottom_30">
	        <div class="col-md-9">
	            <div class="review_desc">
	                <div class="row">
	                    <div class="media">
	                        <img src="http://www.ansonika.com/reviewer/img/avatar/avatar_1.png" width="60" height="60" alt="Avatar" class="pull-left">
	                        <div class="media-body">
	                            <h4>Frank Smith <small>Uk - London</small></h4>
	                            <span class="date_posted"><i class=" icon-calendar-3"></i> 14 September 2014</span>
	                        </div>
	                    </div>
	                    <blockquote>""</blockquote>
	                </div>
	                <!-- end row -->
	            </div>
	        </div>
	    </div>
		</c:forEach>
	</div>
</div>
