<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<c:if test="${isEmpty==false}">
	<c:forEach items="${watches}" var="w">
		<a href="${contextPath}/shop/${w.watchSlug}" class="latest-product__item">
			<div class="latest-product__item__pic">
				<img src="${contextPath}/assets_home/img/product/${w.thumbnail}"
					alt="">
			</div>
			<div class="latest-product__item__text">
				<h6> ${w.watchName}</h6>

				<c:if test="${w.haveSale ==true }">
					<span class="d-inline">$<fmt:formatNumber value="${w.salePrice}"
							type="number" maxFractionDigits="0" /></span>
					<span class="d-inline"
						style="font-weight: 400; text-decoration: line-through; font-size: 14px; color: #b2b2b2">$<fmt:formatNumber
							value="${w.price}" type="number" maxFractionDigits="0" /></span>
				</c:if>
				<c:if test="${w.haveSale ==false }">
					<span class="d-inline">$<fmt:formatNumber value="${w.price}"
							type="number" maxFractionDigits="0" /></span>
				</c:if>



			</div>
		</a>
	</c:forEach>
</c:if>
<%-- <c:if test="${isEmpty==false}">
	<table class="table">
		<tbody>
			<c:forEach items="${watches}" var="w">
				<tr>
					<th scope="row"><img
						src="${contextPath}/assets_home/img/product/${w.thumbnail}"
						width="100px"></th>
					<td>
						<p>${w.watchName}</p> <br /> <fmt:formatNumber
							value="${promo.discount}"></fmt:formatNumber>
					</td>

				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</c:if> --%>
<c:if test="${isEmpty==true}"></c:if>

