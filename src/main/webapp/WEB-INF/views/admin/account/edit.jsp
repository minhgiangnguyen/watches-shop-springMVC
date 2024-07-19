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
					<h1 class="m-0">Edit Account</h1>
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
						<f:form action="${contextPath}/admin/account/edit" method="post"
							modelAttribute="account" enctype="multipart/form-data">
							<input type="hidden" name="pictureOld" value="${account.avatar}" />
							<table class="table">
								<tr>
									<td>Account Id</td>
									<td><f:hidden path="accountId" />${account.accountId}</td>
								</tr>
								<tr>
									<td>User name</td>
									<td><f:hidden path="userName" />${account.userName}</td>
								</tr>
								<tr>
									<td>Password</td>
									<td><f:input path="password" /></td>
								</tr>
								<tr>
									<td>Full Name</td>
									<td><f:input path="fullName" /></td>
								</tr>
								<tr>
									<td>Avatar</td>
									<td><input type="file" name="file" /></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><f:input path="email" /></td>
								</tr>
								<tr>
									<td>Address</td>
									<td><f:input path="address" /></td>
								</tr>
								<tr>
									<td>Phone</td>
									<td><f:input path="phone" /></td>
								</tr>
								<tr>
									<td>Gender</td>
									<td><select name="gender" id="gender">
											<c:if test="${account.gender==true}">
												<option selected value="1">Men</option>
												<option value="0">Women</option>
											</c:if>
											<c:if test="${account.gender==false}">
												<option value="1">Men</option>
												<option selected value="0">Women</option>
											</c:if>
									</select></td>
								</tr>
								<tr>
									<td>Active</td>
									<td><select name="active" id="active">
											<c:if test="${account.active==true}">
												<option selected value="1">Activated</option>
												<option value="0">Not Activated</option>
											</c:if>
											<c:if test="${account.active==false}">
												<option value="1">Activated</option>
												<option selected value="0">Not Activated</option>
											</c:if>
									</select></td>
								</tr>
								<tr>
									<td>Role</td>
									<td><select name="role" id="role">
											<c:if test="${account.role==true}">
												<option selected value="1">Admin</option>
												<option value="0">User</option>
											</c:if>
											<c:if test="${account.role==false}">
												<option value="1">Admin</option>
												<option selected value="0">User</option>
											</c:if>
									</select></td>
								</tr>
								<tr>
									<td>Create Date</td>
									<td><f:input path="createDate"/></td>
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



