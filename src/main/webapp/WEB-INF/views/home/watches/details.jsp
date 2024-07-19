<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />

<style>
.product__details__price span {
	display: inline-block;
	font-weight: 400;
	text-decoration: line-through;
	margin-left: 10px;
	font-size: 27px;
	color: #b2b2b2
}
</style>

<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large"
							src="${contextPath}/assets_home/img/product/${watch.thumbnail}"
							alt="">
					</div>
					<div class="product__details__pic__slider owl-carousel">
						<c:forEach items="${pictureList}" var="pic">
							<img
								data-imgbigurl="${contextPath}/assets_home/img/product/${pic}"
								src="${contextPath}/assets_home/img/product/${pic}" alt="">
						</c:forEach>
						<img
							data-imgbigurl="${contextPath}/assets_home/img/product/${watch.thumbnail}"
							src="${contextPath}/assets_home/img/product/${watch.thumbnail}"
							alt="">
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${watch.watchName}</h3>
					<c:if test="${watch.haveSale ==true }">
						<div class="product__details__price">
							$
							<fmt:formatNumber value="${watch.salePrice}" type="number"
								maxFractionDigits="0" />
							<span>$<fmt:formatNumber value="${watch.price}"
									type="number" maxFractionDigits="0" /></span>
						</div>
					</c:if>
					<c:if test="${watch.haveSale ==false }">
						<div class="product__details__price">
							$
							<fmt:formatNumber value="${watch.price}" type="number"
								maxFractionDigits="0" />
						</div>
					</c:if>

					<p>${watch.description}</p>
					<!--  <div class="product__details__quantity">
						<div class="quantity">
							<div class="pro-qty">
								<input type="number" onchange="updateBasket('${watch.watchId}',this.value)" value="${baskets.quantity}" min="1" max="100"/>
							</div>
						</div> 
					</div> -->
					<a href="#" class="primary-btn"
						onclick="addBasket('${watch.watchId}')">ADD TO CARD</a> <a
						href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
					<ul>
						<li><b>Movement</b> <span>${watch.movementName}</span></li>
						<!-- <li><b>Shipping</b> <span>01 day shipping. <samp>Free
									pickup today</samp></span></li> -->
						<li><b>Material</b> <span>${watch.materialName}</span></li>
						<li><b>Strap Type</b> <span>${watch.strapName}</span></li>
						<li><b>Case Size</b> <span>${watch.sizeValue}mm</span></li>

					</ul>
				</div>
			</div>
			<%-- 	<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
						</li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-2" role="tab" aria-selected="false">Information</a></li>
						<!-- <li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-3" role="tab" aria-selected="false">Reviews <span>(1)</span></a>
						</li> -->
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								${watch.description}</div>
						</div>
						<div class="tab-pane" id="tabs-2" role="tabpanel">
							<div class="product__details__tab__desc"></div>
						</div>
						<div class="tab-pane" id="tabs-3" role="tabpanel">
							<div class="product__details__tab__desc"></div>
						</div>
					</div>
				</div>
			</div> --%>
		</div>
	</div>
</section>
<!-- Product Details Section End -->