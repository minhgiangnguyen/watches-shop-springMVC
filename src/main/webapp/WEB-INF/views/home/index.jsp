<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />

<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/elegant-icons.css" type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/nice-select.css" type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${contextPath}/assets_home/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/assets_home/css/style.css"
	type="text/css">
<style>
/* .modal {
	position: absolute;
	top: -155px;
	left: -175px;
   
} */
.modal-dialog {
	top: -5vh;
	right: 3vw;
}

a.disabled {
	/* Make the disabled links grayish*/
	color: gray;
	/* And disable the pointer events */
	pointer-events: none;
}

.modal-dialog, .modal-content {
	/* 80% of window height */
	height: 80%;
}

.modal-body {
	/* 100% = dialog height, 120px = header + footer */
	max-height: calc(100% - 120px);
	overflow-y: scroll;
}
.watch-name {
	display: inline-block;
	max-width: 200px; /* hoặc chiều rộng mà bạn muốn */
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="img/logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$150.00</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="${contextPath}/assets_home/img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Spanis</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<div class="header__top__right__auth">
				<a href="#"><i class="fa fa-user"></i> Login</a>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Shop</a></li>
				<li><a href="#">Pages</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shoping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
						<li><a href="./blog-details.html">Blog Details</a></li>
					</ul></li>
				<li><a href="./blog.html">Blog</a></li>
				<li><a href="./contact.html">Contact</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
				<li>Free Shipping for all Order of $99</li>
			</ul>
		</div>
	</div>
	<!-- Humberger End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>

								<li><i class="fa fa-envelope"></i></li>
								<li></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a>
							</div>
							<%-- <div class="header__top__right__language">
								<img src="${contextPath}/assets_home/img/language.png" alt="">
								<div>English</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">Spanis</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div> --%>
							<div class="header__top__right__auth">
								<c:choose>
									<c:when test="${!empty sessionScope.userid}">
										<a class="nav-link" href="${contextPath}/logout">Logout</a>
									</c:when>
									<c:otherwise>
										<a href=" ${contextPath}/login "><i class="fa fa-user"></i>
											Login</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="${contextPath}/home"><img
							src="${contextPath}/assets_home/img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="${contextPath}/home">Home</a></li>
							<c:forEach items="${genders}" var="g">
								<li><a href="${contextPath}/watches/shop/${g.genderName}">${g.genderName}</a></li>
							</c:forEach>
							<li><a href="${contextPath}/sale">Sale</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<!-- <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li> -->
							<li><a href="${contextPath}/cart"><i
									class="fa fa-shopping-bag"></i><span id="basket_total"><jsp:include
											page="${contextPath}/countItems"></jsp:include></span></a></li>
						</ul>
						<div class="header__cart__price"></div>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->

	<!-- Hero Section Begin -->
	<!-- <section class="hero"> -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Brands</span>
						</div>
						<ul>
							<c:forEach items="${brands}" var="b">
								<li><a href="${contextPath}/watches/brand/${b.brandName}">${b.brandName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="search" method="get">
								<input type="text" placeholder="Search for name watch"
									id="searchInput" name="q">
								<button type="submit" class="site-btn">SEARCH</button>
							</form>
						</div>

						<!-- Modal SEARCH-->

						<div class="modal fade" id="searchModal">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content" style="margin-top: 300px !important;">
									<div class="modal-header">
										<h5 class="modal-title" id="searchFor">Search for "..."</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close"></button>
									</div>
									<div class="modal-body" id="searchBody">...</div>
									<div class="modal-footer">
										<a href="" id="seeAll">SEE ALL "..."</a>
										<p id="notFound"></p>
									</div>
								</div>
							</div>
						</div>
						<!-- Modal SEARCH-->

						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>+65 11.188.888</h5>
								<span>support 24/7 time</span>
							</div>
						</div>
					</div>
					<c:if test="${page=='home_content'}">
						<div class="hero__item set-bg"
							data-setbg="${contextPath}/assets_home/img/banner/${banner.picture}">
							<div class="hero__text">
								<a href="${banner.bannerUrl}" class="primary-btn">SHOP NOW</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<c:if test="${!empty page && !empty fodder}">
		<jsp:include page="${fodder}/${page}.jsp" />
	</c:if>
	<c:if test="${!empty page && empty fodder}">
		<jsp:include page="${page}.jsp" />
	</c:if>


	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.html"><img src="img/logo.png" alt=""></a>
						</div>
						<ul>
							<li>Address: 60-49 Road 11378 New York</li>
							<li>Phone: +65 11.188.888</li>
							<li>Email: hello@colorlib.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<h6>Useful Links</h6>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">About Our Shop</a></li>
							<li><a href="#">Secure Shopping</a></li>
							<li><a href="#">Delivery infomation</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Our Sitemap</a></li>
						</ul>
						<ul>
							<li><a href="#">Who We Are</a></li>
							<li><a href="#">Our Services</a></li>
							<li><a href="#">Projects</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Innovation</a></li>
							<li><a href="#">Testimonials</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Join Our Newsletter Now</h6>
						<p>Get E-mail updates about our latest shop and special
							offers.</p>
						<form action="#">
							<input type="text" placeholder="Enter your mail">
							<button type="submit" class="site-btn">Subscribe</button>
						</form>
						<div class="footer__widget__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-pinterest"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer__copyright">
						<div class="footer__copyright__text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
						<div class="footer__copyright__payment">
							<img src="img/payment-item.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="${contextPath}/assets_home/js/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/assets_home/js/bootstrap.min.js"></script>
	<script src="${contextPath}/assets_home/js/jquery.nice-select.min.js"></script>
	<script src="${contextPath}/assets_home/js/jquery-ui.min.js"></script>
	<script src="${contextPath}/assets_home/js/jquery.slicknav.js"></script>
	<script src="${contextPath}/assets_home/js/mixitup.min.js"></script>
	<script src="${contextPath}/assets_home/js/owl.carousel.min.js"></script>
	<script src="${contextPath}/assets_home/js/main.js"></script>
	<script>
		var path = '${pageContext.servletContext.contextPath}';
	</script>
	<script type="text/javascript"
		src="${contextPath}/assets_home/js/home.js"></script>
	<script>
		var path = '${pageContext.servletContext.contextPath}';
		
		$("#searchInput").keyup(function(e) {
			var txt = $("#searchInput").val();
			if (txt.length == 0) {
				$('#searchModal').modal('hide');
			} else {
				$.post(path + "/search?q=" + txt, function(data) {
					
					if (data.trim().length == 0){
						$("#notFound").html('Not Found')
						$("#seeAll").html("");
					}
					if (data.trim().length != 0){
						$("#notFound").html('')
						$("#seeAll").html("SEE ALL " + '"' + txt + '"');
						$("#seeAll").attr("href", path + '/search?q=' + txt);

					}
					$("#searchBody").html(data);
					 

				})
				$("#searchFor").html("SEARCH FOR " + txt);
				

				$('#searchModal').modal({
					show : true
				});
			}

		});

	
	</script>

</body>

</html>
