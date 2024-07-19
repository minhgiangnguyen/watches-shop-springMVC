<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Edit Orders</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">edit</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<h3 style="color: ${colorCss}">${msg}</h3>
			<div class="row">
				<div class="col-md-12">
					<!-- general form elements -->

					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Edit</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<f:form action="${contextPath}/admin/orders/edit" method="post"
							modelAttribute="order" >							
							<table class="table">
								<tr>
									<td>Order ID</td>
									<td><f:hidden path="orderId" />${order.orderId}</td>
								</tr>
								<tr>
									<td>Order Date</td>
									<td><f:hidden path="orderDate" />${order.orderDate}</td>
								</tr>
								<tr>
									<td>Account ID</td>
									<td><f:hidden path="accountId" />${order.accountId}</td>
								</tr>
								<tr>
									<td>Receive Address</td>
									<td><f:hidden path="receiveAddress" />${order.receiveAddress}</td>
								</tr>								
								<tr>
									<td>Receive Phone</td>
									<td><f:hidden path="receivePhone" />${order.receivePhone}</td>
								</tr>
								
								<tr>
									<td>Status</td>
									<td><select name="status" id="status">
											<c:if test="${order.status==true}">
												<option selected value="1">Delivered</option>
												<option value="0">Not Delivery</option>
											</c:if>
											<c:if test="${order.status==false}">
												<option value="1">Delivered</option>
												<option selected value="0">Not Delivery</option>
											</c:if>
									</select></td>
								</tr>																				
								<tr>
									<td colspan="2"><button class="btn btn-success">Submit
										</button></td>
								</tr>
							</table>
						</f:form>
					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>




