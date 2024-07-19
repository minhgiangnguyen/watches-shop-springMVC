<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<!-- Checkout Section Begin -->

<section class="checkout spad">
	<div class="container">

		<div class="checkout__form">
			<h4>Billing Details</h4>
			<form action="checkout" method="post">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<div class="row">
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										Full Name<span>*</span>
									</p>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>${sessionScope.fullname}</p>

								</div>
							</div>
						</div>
						<div class="checkout__input">
							<p>
								Address<span>*</span>
							</p>
							<input type="text" name="address" value="${sessionScope.address}"
								class="checkout__input__add">
						</div>


						<div class="row">
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										Phone<span>*</span>
									</p>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="checkout__input">
									<input type="text" name="phone" value="${sessionScope.phone}">
								</div>
							</div>
						</div>

						<div class="checkout__input">
							<p>
								Order notes<span>*</span>
							</p>
							<input type="text"
								placeholder="Notes about your order, e.g. special notes for delivery.">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="checkout__order">
							<h4>Your Order</h4>
							<div class="checkout__order__products">
								Products <span>Price</span>
							</div>
							<c:forEach items="${baskets}" var="b">
								<div>
									<ul>
										<li><p class="watch-name"
												data-watch-name="${b.watchName}"></p>
											<span>$ <fmt:formatNumber value="${b.price}" /></span></li>
									</ul>
								</div>
								<div class="checkout__order__total">
									Totals<span>$ <fmt:formatNumber
											value="${b.price*b.quantity}" /></span>
								</div>
							</c:forEach>
							<button type="submit" class="site-btn">PLACE ORDER</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		const watchNames = document.querySelectorAll('.watch-name');

		watchNames.forEach(function(watchNameElement) {
			const watchName = watchNameElement.getAttribute('data-watch-name');

			if (watchName.length > 50) {
				watchNameElement.innerText = watchName.slice(0, 30) + '...';
			} else {
				watchNameElement.innerText = watchName;
			}
		});
	});
</script>
<!-- Checkout Section End -->