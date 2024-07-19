<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Watch</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Watch</li>
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
							<table class="table table-bordered table-responsive">
								<thead>
									<tr>
										<th>ID</th>
										<th>Watch Code</th>
										<th>Watch Name</th>
										<th>Watch Slug</th>
										<th>Thumbnail</th>
										<th>Picture List</th>
										<th>Price</th>
										<th>Sale Price</th>
										<th>Discount Rate</th>
										<th>Color</th>
										<th>Gender</th>
										<th>Brand</th>
										<th>Size</th>
										<th>Movement</th>
										<th>Strap Type</th>
										<th>Material</th>
										<th>Description</th>
										<th>Create Date</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${wList}" var="w">
										<tr>
											<td>${w.watchId}</td>
											<td>${w.watchCode}</td>
											<td>${w.watchName}</td>
											<td>${w.watchSlug}</td>
											<td><img
												src="${contextPath}/assets_home/img/product/${w.thumbnail}"
												width="100" /></td>
											<td>
											<a
												href="${contextPath}/admin/watch/picture-list/${w.watchId}"
												class="btn btn-info">Edit</a>
												<!-- Modal picture list-->
												<button type="button" class="btn btn-primary"
													data-toggle="modal" data-target="#pictureList-${w.watchId}">
													Show</button> <!-- Modal Desc-->
												<div class="modal fade" id="pictureList-${w.watchId}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalCenterTitle"
													aria-hidden="true">
													<div class="modal-dialog  modal-dialog-centered"
														role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLongTitle">Picture List</h5>
																<button type="button" class="close" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
															</div>
															<div class="modal-body">
																<c:forEach items="${fn:split(w.pictureList, ';')}"
																	var="pic">
																	<img
																		src="${contextPath}/assets_home/img/product/${pic}"
																		width="300" />
																</c:forEach>

															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>

															</div>
														</div>
													</div>
												</div> <!-- Modal Desc-->
											</td>
											<td>$<fmt:formatNumber value="${w.price}" type="number"
													maxFractionDigits="0" /></td>
											<c:if test="${w.haveSale==true}">
												<td>$<fmt:formatNumber value="${w.salePrice}"
														type="number" maxFractionDigits="0" /></td>
											</c:if>
											<c:if test="${w.haveSale==false}">
												<td></td>
											</c:if>
											<c:if test="${w.haveSale==true}">
												<td><fmt:formatNumber value="${w.discount}"
														type="number" maxFractionDigits="0" /></td>
											</c:if>
											<c:if test="${w.haveSale==false}">
												<td></td>
											</c:if>
											<td>${w.colorValue}</td>
											<td>${w.genderName}</td>
											<td>${w.brandName}</td>
											<td>${w.sizeValue}mm</td>
											<td>${w.movementName}</td>
											<td>${w.strapName}</td>
											<td>${w.materialName}</td>
											<td>
												<!-- Button trigger modal -->
												<button type="button" class="btn btn-primary"
													data-toggle="modal" data-target="#description-${w.watchId}">
													Show</button> <!-- Modal Desc-->
												<div class="modal fade" id="description-${w.watchId}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalCenterTitle"
													aria-hidden="true">
													<div class="modal-dialog  modal-dialog-centered"
														role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLongTitle">Description</h5>
																<button type="button" class="close" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
															</div>
															<div class="modal-body">${w.description}</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>

															</div>
														</div>
													</div>
												</div> <!-- Modal Desc-->
											</td>
											<td><fmt:formatDate value="${w.create}"
													pattern="dd/MM/yyyy" /></td>
											<td><a
												href="${contextPath}/admin/watch/edit/${w.watchId}"
												class="btn btn-info">Edit</a> <a
												href="${contextPath}/admin/watch/delete/${w.watchId}"
												class="btn btn-danger"
												onclick="return confirm('Do you delete this watch?')">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->

						<div class="card-footer clearfix">
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
						</div>

					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
