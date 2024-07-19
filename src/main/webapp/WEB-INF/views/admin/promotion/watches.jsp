<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${watches}" var="w">
	<tr>
		<td>${w.watchId}</td>
		<td>${w.watchName}</td>
		<td><img
			src="${contextPath}/assets_home/img/product/${w.thumbnail}"
			width="100" /></td>
		<td><fmt:formatNumber value="${w.price}"></fmt:formatNumber></td>

		<td><fmt:formatNumber value="${w.salePrice}"></fmt:formatNumber>
		</td>
		<td><a
			href="${contextPath}/admin/promotion/${w.promoId}/watches/delete/${w.watchId}"
			class="btn btn-danger"
			onclick="return confirm('Do you remove this product from promotion?')">Remove</a></td>
	</tr>
</c:forEach>