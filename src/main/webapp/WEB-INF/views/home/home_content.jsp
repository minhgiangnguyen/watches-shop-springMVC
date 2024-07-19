<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<style>
.featured__item__text h5 span {
	display: inline-block;
	font-weight: 400;
	text-decoration: line-through;
	margin-left: 10px;
	font-size: 14px;
	color: #b2b2b2
}
</style>
<%-- <!-- Categories Section Begin -->
<section class="categories">
	<div class="container">
		<div class="row">
			<div class="categories__slider owl-carousel">
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="${contextPath}/assets_home/img/categories/cat-1.jpg">
						<h5>
							<a href="#">Fresh Fruit</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="${contextPath}/assets_home/img/categories/cat-2.jpg">
						<h5>
							<a href="#">Dried Fruit</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="${contextPath}/assets_home/img/categories/cat-3.jpg">
						<h5>
							<a href="#">Vegetables</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="${contextPath}/assets_home/img/categories/cat-4.jpg">
						<h5>
							<a href="#">drink fruits</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="${contextPath}/assets_home/img/categories/cat-5.jpg">
						<h5>
							<a href="#">drink fruits</a>
						</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section End --> --%>


<!-- Featured Section Begin -->
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Featured Product</h2>
				</div>
				<div class="featured__controls">
					<ul>
						<!-- <li class="active" data-filter="*">All</li> -->
						<li class="active" data-filter=".lastest">Lastest Product</li>
						<li data-filter=".topBuy">Top buy Product</li>
						
					</ul>
				</div>
			</div>
		</div> 
		<div class="row featured__filter">

			<c:forEach items="${watchs}" var="w">
				<div class="col-lg-3 col-md-4 col-sm-6 mix lastest">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="${contextPath}/assets_home/img/product/${w.thumbnail}">
							<ul class="featured__item__pic__hover">
								<li><a href="#" role="button"
									onclick="addBasket('${w.watchId}')"><i
										class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="${contextPath}/shop/${w.watchSlug}">${w.watchName}</a>
							</h6>
							<c:if test="${w.haveSale ==true }">
								<h5>
									$<fmt:formatNumber value="${w.salePrice}" type="number" maxFractionDigits = "0"/>
									<span>$<fmt:formatNumber value="${w.price}"
											type="number" maxFractionDigits = "0"/></span>
								</h5>
							</c:if>
							<c:if test="${w.haveSale ==false }">
								<h5>
									$<fmt:formatNumber value="${w.price}" type="number" maxFractionDigits = "0"/>
								</h5>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach items="${watchsTopBuy}" var="w">
				<div class="col-lg-3 col-md-4 col-sm-6 mix topBuy">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="${contextPath}/assets_home/img/product/${w.thumbnail}">
							<ul class="featured__item__pic__hover">
								<li><a href="#" role="button"
									onclick="addBasket('${w.watchId}')"><i
										class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="${contextPath}/shop/${w.watchSlug}">${w.watchName}</a>
							</h6>
							<c:if test="${w.haveSale ==true }">
								<h5>
									$<fmt:formatNumber value="${w.salePrice}" type="number" maxFractionDigits = "0"/>
									<span>$<fmt:formatNumber value="${w.price}"
											type="number" maxFractionDigits = "0"/></span>
								</h5>
							</c:if>
							<c:if test="${w.haveSale ==false }">
								<h5>
									$<fmt:formatNumber value="${w.price}" type="number" maxFractionDigits = "0"/>
								</h5>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</section>
<!-- Featured Section End -->

<!-- Banner Begin -->
<div class="banner">
	<div class="container">
		<div class="row">
			<c:forEach items="${genders}" var="g">
				<div class="col-lg-6 col-md-6 col-sm-6">

					<%-- <div class="hero__item set-bg"
						data-setbg="${contextPath}/assets_home/img/genders/${g.genderPicture}">
						<div class="hero__text">
							<a href="#" class="primary-btn">SHOP ${g.genderName}</a>
						</div>
					</div> --%>
					<div class="banner__pic">
						<img
							src="${contextPath}/assets_home/img/genders/${g.genderPicture}"
							alt="">
					</div>
					<a href="${contextPath}/watches/shop/${g.genderName}" class="primary-btn">SHOP ${g.genderName}</a>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<!-- Banner End -->


<%-- <!-- Latest Product Section Begin -->
<section class="latest-product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Latest Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Top Rated Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Review Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-1.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-2.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img
										src="${contextPath}/assets_home/img/latest-product/lp-3.jpg"
										alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Latest Product Section End --> --%>
