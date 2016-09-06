<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.i18n.text" />

	<section class="bg-img" style="background-color: #292b34;">
		<div class="container-fluid">
			<div class="well well-sm main-footer"
				style="background-color: transparent; border: 0px; margin-bottom: 0px;">
				<div class="row" style="margin-bottom: 0px;">
					<div class="col-md-12">
						<div class="row" style="margin-bottom: 10px;">

							<div class="col s2">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.info"> </p>
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.contact"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.terms"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.rules"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.faq"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.story"> </p></a>
								</div>
							</div>

							<div class="col s2 offset-s1">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.visit"> </p>
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.home"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.news"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.premium"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.shop"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.forum"> </p></a>
								</div>
							</div>

							<div class="col s2 offset-s1">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.support"> </p>
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.center"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.guides"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.tools"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.tutorial"> </p></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.webinars"> </p></a>
								</div>
							</div>




							<div class="col s2 offset-s2">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.social"> </p>
								</h5>
								<div>
									<a href="https://www.facebook.com/proquest/" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-facebook-official " aria-hidden="true"
										style="margin-right: 8px;"></i> <p
											id="footer.social.facebook"> </p></a>
								</div>
								<div>
									<a href="https://www.youtube.com/user/proquesttraining" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-youtube-play " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.youtube"> </p></a>
								</div>
								<div>
									<a href="https://twitter.com/proquest" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-twitter " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.twitter"> </p></a>
								</div>
								<div>
									<a href="https://www.pinterest.com/proquest/" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-pinterest-p " aria-hidden="true"
										style="margin-right: 11px;"></i> <p
											id="footer.social.pinterest"> </p></a>
								</div>
								<div>
									<a href="https://plus.google.com/+proquest" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-google-plus " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.wordpress"> </p></a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="row" style="background-color: #1a1a1a; margin: auto;">
			<div class="col s1 offset-s9"
				style="height: 40px; color: #8c8c8c; margin-top: 20px; font-size: 20px;">
				&#169 2016</div>

			<div сlass="col s1 offset-s1"
				style="color: #cccccc; margin-top: 20px; font-size: 20px;">
				<p id="footer.copyright"> </p>
			</div>
		</div>
	</section>