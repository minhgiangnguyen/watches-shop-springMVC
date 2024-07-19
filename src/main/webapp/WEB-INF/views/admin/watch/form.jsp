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
					<h1 class="m-0">Add Watch</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">add Watch</li>
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
							<h3 class="card-title">Table Watch</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<f:form action="${contextPath}/admin/watch/save" method="post"
								modelAttribute="watch" enctype="multipart/form-data">
								<input type="hidden" name="thumbOld" value="${watch.thumbnail}" />
								<input type="hidden" name="pictureListOld" value="${watch.pictureList}" />
								<f:hidden path="watchId" />
								<f:hidden path="create" />
								<div class="row">
									<div class="col-md-6">
										<table class="table">
											<tr>
												<td>WatchCode</td>
												<td><f:input path="watchCode" /></td>
											</tr>
											<tr>
												<td>WatchName</td>
												<td><f:input path="watchName" /></td>
											</tr>
											<tr>
												<td>Price</td>
												<td><f:input path="price" /></td>
											</tr>
											<tr>
												<td>Gender</td>
												<td><f:select path="genderId" items="${gender}"
														itemValue="genderId" itemLabel="genderName"></f:select></td>
											</tr>
											<tr>
												<td>Thumbnail</td>
												<td><input type="file" name="file" /></td>
											</tr>
											
											<tr>
												<td>Brand</td>
												<td><f:select path="brandId" items="${brand}"
														itemValue="brandId" itemLabel="brandName"></f:select></td>
											</tr>
										</table>
									</div>
									<div class="col-md-6">
										<table class="table">
											<tr>
												<td>Color</td>
												<td><f:select path="colorId" items="${color}"
														itemValue="colorId" itemLabel="colorValue"></f:select></td>
											</tr>
											<tr>
												<td>Strap Type</td>
												<td><f:select path="strapTypeId" items="${straptype}"
														itemValue="strapTypeId" itemLabel="strapName"></f:select></td>
											</tr>
											<tr>
												<td>Size</td>
												<td><f:select path="sizeId" items="${size}"
														itemValue="sizeId" itemLabel="sizeValue"></f:select></td>
											</tr>
											<tr>
												<td>Movement</td>
												<td><f:select path="movementId" items="${movement}"
														itemValue="movementId" itemLabel="movementName"></f:select></td>
											</tr>
											<tr>
												<td>Material</td>
												<td><f:select path="materialId" items="${material}"
														itemValue="materialId" itemLabel="materialName"></f:select></td>
											</tr>
											<tr>
												<td>Descriptions</td>
												<td><f:input path="description" /></td>
											</tr>

										</table>
									</div>
								</div>
								<button style="margin-left: 660px; padding: 10px 30px;"
									class="btn btn-primary">Submit</button>
							</f:form>
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
