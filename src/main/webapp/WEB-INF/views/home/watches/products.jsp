<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section" style="padding-bottom: 0px">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<nav>
					<ol class="breadcrumb" style="background-color: white">
						<li class="breadcrumb-item"><a href="${contextPath}/home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">${nameList}</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad" style="padding-top: 0px">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-5">
				<div class="sidebar">
					<div class="sidebar__item">
						<h4>Department</h4>
						<ul>
							<li><a href="#">Fresh Meat</a></li>
							<li><a href="#">Vegetables</a></li>
							<li><a href="#">Fruit & Nut Gifts</a></li>
							<li><a href="#">Fresh Berries</a></li>
							<li><a href="#">Ocean Foods</a></li>
							<li><a href="#">Butter & Eggs</a></li>
							<li><a href="#">Fastfood</a></li>
							<li><a href="#">Fresh Onion</a></li>
							<li><a href="#">Papayaya & Crisps</a></li>
							<li><a href="#">Oatmeal</a></li>
						</ul>
					</div>
					<div class="sidebar__item">
						<h4>Price</h4>
						<div class="price-range-wrap">
							<div
								class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
								data-min="10" data-max="540">
								<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
							</div>
							<div class="range-slider">
								<div class="price-input">
									<input type="text" id="minamount"> <input type="text"
										id="maxamount">
								</div>
							</div>
						</div>
					</div>
					<div class="sidebar__item sidebar__item__color--option">
						<h4>Colors</h4>
						<c:forEach items="${colors}" var="c">
							<div
								class="sidebar__item__color sidebar__item__color--${fn:toLowerCase(c.colorValue)}">
								<label for="${fn:toLowerCase(c.colorValue)}">
									${c.colorValue} <input type="radio"
									id="${fn:toLowerCase(c.colorValue)}">
								</label>
							</div>
						</c:forEach>
					</div>
					<div class="sidebar__item">
						<h4>Popular Size</h4>
						<div class="sidebar__item__size">
							<label for="large"> Large <input type="radio" id="large">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="medium"> Medium <input type="radio"
								id="medium">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="small"> Small <input type="radio" id="small">
							</label>
						</div>
						<div class="sidebar__item__size">
							<label for="tiny"> Tiny <input type="radio" id="tiny">
							</label>
						</div>
					</div>
					
				</div>
			</div>
			<div class="col-lg-9 col-md-7">

				<div class="filter__item">
					<div class="row">
						<div class="col-lg-4 col-md-5">
							<div class="filter__sort">
								<span>Sort By</span> <select>
									<option value="0">Default</option>
									<option value="0">Default</option>
								</select>
							</div>
						</div>
						<!-- <div class="col-lg-4 col-md-4">
							<div class="filter__found">
								<h6>
									<span>16</span> Products found
								</h6>
							</div>
						</div>
						<div class="col-lg-4 col-md-3">
							<div class="filter__option">
								<span class="icon_grid-2x2"></span> <span class="icon_ul"></span>
							</div>
						</div> -->
					</div>
				</div>
				<c:if test="${isEmpty==false }">
					<div class="row">
						<c:forEach items="${watches}" var="w">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="${contextPath}/assets_home/img/product/${w.thumbnail}">
										<c:if test="${w.haveSale ==true }">
											<div class="product__discount__percent">
												-
												<fmt:formatNumber value="${w.discount}" type="number" />
												%
											</div>
										</c:if>
										<ul class="product__item__pic__hover">
											<li><a href="#" onclick="addBasket('${w.watchId}')"> <i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<h5>
											<a href="${contextPath}/shop/${w.watchSlug}">${w.watchName}</a>
										</h5>
										<c:if test="${w.haveSale ==true }">
											<div class="product__item__price">
												$
												<fmt:formatNumber value="${w.salePrice}" type="number"
													maxFractionDigits="0" />
												<span>$<fmt:formatNumber value="${w.price}"
														type="number" maxFractionDigits="0" /></span>
											</div>
										</c:if>
										<c:if test="${w.haveSale ==false }">
											<div class="product__item__price">
												$
												<fmt:formatNumber value="${w.price}" type="number"
													maxFractionDigits="0" />
											</div>
										</c:if>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="product__pagination">
						<c:forEach var="i" begin="1" end="${totalPage}">
							<c:choose>
								<c:when test="${i==currentPage}">
									<a class="disabled" href="?pageNo=${i}">${i}</a>
								</c:when>
								<c:otherwise>
									<a href="${currentUrl}?pageNo=${i}">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!-- <a href="#"><i class="fa fa-long-arrow-right"></i></a> -->
					</div>
				</c:if>
				<c:if test="${isEmpty==true }">
					<p>Not found product</p>
				</c:if>
			</div>
		</div>
	</div>
</section>
<!-- Product Section End -->