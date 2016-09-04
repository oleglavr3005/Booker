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
									<p id="footer.info" />
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.contact" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.terms" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.rules" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.faq" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.info.story" /></a>
								</div>
							</div>

							<div class="col s2 offset-s1">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.visit" />
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.home" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.news" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.premium" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.shop" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.visit.forum" /></a>
								</div>
							</div>

							<div class="col s2 offset-s1">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.support" />
								</h5>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.center" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.guides" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.tools" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.tutorial" /></a>
								</div>
								<div>
									<a href="#" style="color: #e6e6e6; font-size: 1rem;"><p
											id="footer.support.webinars" /></a>
								</div>
							</div>




							<div class="col s2 offset-s2">
								<h5 class="title-footer"
									style="font-size: 1.6rem; color: #e6e6e6">
									<p id="footer.social" />
								</h5>
								<div>
									<a href="https://www.facebook.com/proquest/" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-facebook-official " aria-hidden="true"
										style="margin-right: 8px;"></i> <p
											id="footer.social.facebook" /></a>
								</div>
								<div>
									<a href="https://www.youtube.com/user/proquesttraining" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-youtube-play " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.youtube" /></a>
								</div>
								<div>
									<a href="https://twitter.com/proquest" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-twitter " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.twitter" /></a>
								</div>
								<div>
									<a href="https://www.pinterest.com/proquest/" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-pinterest-p " aria-hidden="true"
										style="margin-right: 11px;"></i> <p
											id="footer.social.pinterest" /></a>
								</div>
								<div>
									<a href="https://plus.google.com/+proquest" style="color: #e6e6e6; font-size: 1rem;"><i
										class="fa fa-lg fa-google-plus " aria-hidden="true"
										style="margin-right: 7px;"></i> <p
											id="footer.social.wordpress" /></a>
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
				<p id="footer.copyright" />
			</div>
		</div>
	</section>