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
					<h1 class="m-0">MATERIAL MANAGEMENT</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Material</li>
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
							<h3 class="card-title">Add Material</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<f:form action="${contextPath}/admin/material/save"
							method="post" modelAttribute="material"
							enctype="multipart/form-data">
							<f:hidden path="materialId" />
							<div class="card-body">
								<div class="form-group">
									<label for="materialName">Material Name</label>
									<f:input path="materialName" />
 
								</div>
								
							</div>
							<!-- /.card-body -->
							<div class="card-footer">
								<button class="btn btn-primary">Submit</button>
							</div>
						</f:form>
					</div>
					<!-- /.card -->
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">List Material</h3>
							<div class="card-tools">
								<form action="${contextPath}/admin/material/search" method="post">
									<div class="input-group input-group-sm" style="width: 150px;">
										<input type="text" name="searchname"
											class="form-control float-right" placeholder="Search">
	
										<div class="input-group-append">
											<button type="submit" class="btn btn-default">
												<i class="fas fa-search"></i>
											</button>
										</div>
									</div>
								</form>
							</div>						
						</div>
						<!-- /.card-header -->
						<div class="card-body table-responsive p-0" style="height: 300px;">
							<table class="table table-head-fixed text-nowrap">
								<thead>
									<tr>
										<th>ID</th>
										<th>Material Name</th>
										<th>Edit/Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${materialList}" var="m">
										<tr>
											<td>${m.materialId}</td>
											<td>${m.materialName}</td>
											<td><a
												href="${contextPath}/admin/material/edit/${m.materialId}"
												class="btn btn-info">Edit</a> <a
												href="${contextPath}/admin/material/delete/${m.materialId}"
												class="btn btn-danger"
												onclick="return confirm('Do you delete this color?')">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
			<!-- /.row -->
		</div>
	</section>
	<!-- /.content -->
</div>

