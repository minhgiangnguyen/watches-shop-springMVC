<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
        
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <c:forEach items="${baskets}" var="b">
                            <tbody>
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img src="${contextPath}/assets_home/img/product/${b.thumbnail}" width="80px" alt="">
                                        <h5>${b.watchName}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        $ <fmt:formatNumber value="${b.price}" />
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div >
                                                <input type="number" style="width:60px" onchange="updateBasket('${b.watchId}',this.value)" value="${b.quantity}" min="1" max="100"/>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        $ <fmt:formatNumber value="${b.price*b.quantity}"/>
                                        <c:set var="total" value="${total+b.price*b.quantity}" />
                                    </td>
                                    <td class="shoping__cart__item__close">
                                       <a href="#" onclick="removeItem('${b.watchId}')"><span class="icon_close" ></span></a> 
                                    </td>
                                </tr>
                                                            
                            </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">         
                
                <div class="col-lg-12">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>                     
                            <li>Total <span>$ <fmt:formatNumber value="${total}"/></span></li>
                        </ul>
                        <a href="${contextPath}/checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->