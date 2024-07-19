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
					<h1 class="m-0">Banner Management</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Banner</li>
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
							<h3 class="card-title">${nameForm}Banner</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<f:form action="${contextPath}/admin/banner/save" method="post"
							modelAttribute="banner" enctype="multipart/form-data">
							<input type="hidden" name="pictureOld" value="${banner.picture}" />
							<f:hidden path="bannerId" />
							<div class="card-body">

								<div class="form-group">
									<label>Banner Name</label>
									<f:input path="bannerName" cssClass="form-control" />
									<f:errors style="color: red" path="bannerName"></f:errors>
								</div>
								<div class="form-group">
									<label>Banner Description</label>
									<f:input path="bannerDesc" cssClass="form-control" />
									<f:errors style="color: red" path="bannerDesc"></f:errors>
								</div>
								<div class="form-group">
									<label>Banner Url</label>
									<f:input path="bannerUrl" cssClass="form-control" />
									<f:errors style="color: red" path="bannerUrl"></f:errors>
								</div>
								<div class="form-group">
									<div class="mb-3">
										<label class="form-label">Banner Picture</label> <input
											class="form-control" type="file" name="file">
										<p style="color: red">${err }</p>
									</div>
								</div>

								<div class="form-group">
									<div class="mb-3">
										<label class="form-label">Start date(dd/MM/yyyy) </label>
										<f:input path="start" cssClass="form-control" />
										<f:errors style="color: red" path="start"></f:errors>
									</div>
								</div>
								<div class="form-group">
									<div class="mb-3">
										<label class="form-label">End date(dd/MM/yyyy)</label>
										<f:input path="end" cssClass="form-control" />
										<f:errors style="color: red" path="end"></f:errors>
									</div>
								</div>
								<div class="form-group">
									<div class="mb-3">
										<label class="form-label">Default Banner</label>
										<f:radiobutton path="defaultBanner" value="true" label="Yes"/>
										<f:radiobutton path="defaultBanner" value="false" label="No"/>
										<f:errors style="color: red" path="defaultBanner"></f:errors>
									</div>
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

		</div>
	</section>
	<!-- /.content -->

</div>



