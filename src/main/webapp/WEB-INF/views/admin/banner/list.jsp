<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Banner</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Banner</li>
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
							<h3 class="card-title">List Banner</h3>

						</div>
						<!-- /.card-header -->
						<div class="card-body table-responsive p-0" style="height: 300px;">
							<table class="table table-head-fixed text-nowrap">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Description</th>
										<th>Url</th>
										<th>Picture</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Expire</th>
										<th>Edit</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bannerList}" var="banner">
										<tr>
											<td>${banner.bannerId}</td>
											<td>${banner.bannerName}</td>
											<td>${banner.bannerDesc}</td>
											<td>${banner.bannerUrl}</td>

											<td><img
												src="${contextPath}/assets_home/img/banner/${banner.picture}"
												width="500" /></td>


											<td><fmt:formatDate value="${banner.start}"></fmt:formatDate>
											</td>
											<td><fmt:formatDate value="${banner.end}"></fmt:formatDate>
											</td>
											<c:choose>
												<c:when test="${banner.expire == true}">
													<td><input type="checkbox" checked disabled
														style="width: 20px; height: 20px;"></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td><a
												href="${contextPath}/admin/banner/edit/${banner.bannerId}"
												class="btn btn-info">Edit</a>
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
