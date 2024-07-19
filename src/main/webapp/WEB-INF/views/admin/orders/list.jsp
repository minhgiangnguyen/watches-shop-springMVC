<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Order</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Order</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<h3 style="color: ${colorCss}">${msg}</h3>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Table Order</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table class="table table-bordered table-responsive">
								<thead>
									<tr>
										<th>Order ID</th>
										<th>Order Date </th>
										<th>Account ID</th>
										<th>Receive Address</th>
										<th>ReceivePhone</th>
										<th>Status</th>									
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderList}" var="ol">
										<tr>
											<td><a href="${contextPath}/admin/orders/details">${ol.orderId}</a></td>
											<td><fmt:formatDate value="${ol.orderDate}" pattern="dd/MM/yyyy"/></td>
											<td>${ol.accountId}</td>										
											<td>${ol.receiveAddress}</td>
											<td>${ol.receivePhone}</td>
											<td><c:choose>
											<c:when test="${ol.status==true}">Delivered</c:when>
											<c:otherwise>Not Delivery</c:otherwise>
											</c:choose></td>											
											<td><a
												href="${contextPath}/admin/orders/edit/${ol.orderId}"
												class="btn btn-info">Edit</a> <a
												href="${contextPath}/admin/orders/delete/${ol.orderId}"
												class="btn btn-danger"
												onclick="return confirm('Do you delete this account?')">Delete</a>

											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
						<%-- <div class="card-footer clearfix">
							<ul class="pagination  m-0 float-right">
								<c:forEach var="i" begin="1" end="${totalPage}">
									<c:choose>
										<c:when test="${i==currentPage}">
											<li class="page-item disabled"><a class="page-link"
												href="${contextPath}/admin/watch?pageNo=${i}">${i} </a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="${contextPath}/admin/watch?pageNo=${i}">${i} </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<!-- <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">&raquo;</a></li> -->
							</ul>
						</div>  --%>
					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->

</div>
