<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Promotion</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Promotion</li>
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
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">List Promotion</h3>

							<div class="card-tools">
								<form action="${contextPath}/admin/promotion/search"
									method="post">
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
										<th>Name</th>
										<th>Picture</th>
										<th>Description</th>
										<th>Discount Rate</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Expire</th>
										<th>Edit</th>
										<th>Watch List</th>
										<th>Select Watch</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${promoList}" var="promo">
										<tr>
											<td>${promo.promotionId}</td>
											<td>${promo.promotionName}</td>
											<c:choose>
												<c:when test="${!empty promo.promotionPicture}">
													<td><img
														src="${contextPath}/assets_home/images/logo_brand/${b.brandLogo}"
														width="100" /></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td>${promo.promotionDesc}</td>
											<td><fmt:formatNumber value="${promo.discount}"></fmt:formatNumber>
											</td>
											<td><fmt:formatDate value="${promo.start}"></fmt:formatDate>
											</td>
											<td><fmt:formatDate value="${promo.end}"></fmt:formatDate>
											</td>
											<c:choose>
												<c:when test="${promo.expire == true}">
													<td><input type="checkbox" checked disabled
														style="width: 20px; height: 20px;"></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${promo.expire == false}">
													<td><a
														href="${contextPath}/admin/promotion/edit/${promo.promotionId}"
														class="btn btn-info">Edit</a></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>


											<!-- Modal show watches-->
											<td>
												<button type="button" class="btn btn-primary"
													data-toggle="modal"
													data-target="#modal-${promo.promotionId}"
													onclick="showWatches('${promo.promotionId}')">Show</button>


												<div class="modal fade" id="modal-${promo.promotionId}"
													tabindex="-1" role="dialog"
													aria-labelledby="myLargeModalLabel" aria-hidden="true">
													<div class="modal-dialog modal-lg">
														<div class="modal-content">
															<!-- /.row -->
															<div class="row">
																<div class="col-12">
																	<div class="card">
																		<div class="card-header">
																			<h3 class="card-title">Watch List</h3>


																		</div>
																		<!-- /.card-header -->
																		<div class="card-body table-responsive p-0">
																			<table class="table table-hover text-nowrap">
																				<thead>
																					<tr>
																						<th>ID</th>
																						<th>Name</th>
																						<th>Picture</th>
																						<th>Price</th>
																						<th>Sale Price</th>
																					</tr>
																				</thead>
																				<tbody id="watches-${promo.promotionId}">

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
													</div>
												</div>
											</td>
											<c:choose>
												<c:when test="${promo.expire == false}">
													<td><a
														href="${contextPath}/admin/promotion/list/${promo.promotionId}/select-watch"
														class="btn btn-info">SELECT</a></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
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

<script>
	var path = '${pageContext.servletContext.contextPath}';
	function showWatches(promoId) {
		$.post(path + "/admin/promotion/show-watches/" + promoId,
				function(data) {
					console.log(data)
					/* $('#watches-'+promoId).remove(); */
					$('#watches-' + '' + promoId).html(data);
				})
	}
</script>
