<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
	
<div class="men">
	<div class="container">
		<div class="col-md-12 single_top">
			<h1 class="page-heading product-listing">
				Brands <span class="heading-counter">There are ${totalBrand }
					brands</span>
			</h1>
			<!-- <div class="product-count">Showing 1 - 4 of 4 items</div> -->
			<c:forEach items="${brands}" var="b">
				<div class="brand_box">
					<div class="left-side col-xs-12 col-sm-3">
						<img
							src="${contextPath}/assets_home/images/logo_brand/${b.brandLogo}"
							alt="" width=200 />
					</div>
					<div class="middle-side col-xs-12 col-sm-5">
						<h4>
							<a href="${contextPath}/watches/brand/${b.brandName}">${b.brandName}</a>
						</h4>
						<p></p>
					</div>
					<div class="right-side col-xs-12 col-sm-4">
						<p>
							<a href="${contextPath}/watches/brand/${b.brandName}">${b.count} Product</a>
						</p>
						<a href="${contextPath}/watches/brand/${b.brandName}" class="btn btn1 btn-primary btn-normal btn-inline "
							target="_self">View Products</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
</div>