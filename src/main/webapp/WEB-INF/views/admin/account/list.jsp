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
					<h1 class="m-0">List Account</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">account</li>
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
							<h3 class="card-title">Table account</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table class="table table-bordered table-responsive">
								<thead>
									<tr>
										<th>ID</th>
										<th>UserName</th>
										<th>FullName</th>
										<th>Avatar</th>
										<th>Email</th>
										<th>Address</th>
										<th>Gender</th>
										<th>Phone</th>
										<th>Role</th>
										<th>Active</th>
										<th>Create Date</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${accList}" var="acc">
										<tr>
											<td>${acc.accountId}</td>
											<td>${acc.userName}</td>
											<td>${acc.fullName}</td>
											<td><img
												src="${contextPath}/assets_admin/dist/img/account/${acc.avatar}"
												width="100" /></td>
											<td>${acc.email}</td>
											<td>${acc.address}</td>
											<td><c:choose>
											<c:when test="${acc.gender==true}">Men</c:when>
											<c:otherwise>Women</c:otherwise>
											</c:choose></td>
											<td>${acc.phone}</td>
											<td><c:choose>
													<c:when test="${acc.role==true}">Admin</c:when>
													<c:otherwise>User</c:otherwise>
												</c:choose>
											<td><c:choose>
													<c:when test="${acc.active==true}">Activated</c:when>
													<c:otherwise>Not activated</c:otherwise>
												</c:choose></td>
											<td><fmt:formatDate value="${acc.createDate}"
													pattern="dd/MM/yyyy" /></td>
											<td><a
												href="${contextPath}/admin/account/edit/${acc.accountId}"
												class="btn btn-info">Edit</a> <a
												href="${contextPath}/admin/account/delete/${acc.accountId}"
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
