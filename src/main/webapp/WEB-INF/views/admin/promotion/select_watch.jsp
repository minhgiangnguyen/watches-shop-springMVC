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
							<h3 class="card-title">Select Watch</h3>

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
							<f:form
								action="${contextPath}/admin/promotion/list/${promoId}/select-watch/save"
								method="post" modelAttribute="promoWatchForm">
								<table class="table table-head-fixed text-nowrap">
									<thead>
										<tr>
											<th></th>
											<th>ID</th>
											<th>Name</th>
											<th>Picture</th>
											<th>Price</th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${watchList}" var="w">	
												<tr>
													<td> <f:checkbox path="watchIdList" value="${w.watchId}"/></td>								
													<td>${w.watchId}</td>
													<td>${w.watchName}</td>

													<td><img
														src="${contextPath}/assets_home/img/product/${w.thumbnail}"
														width="100" /></td>


													<td><fmt:formatNumber value="${w.price}"></fmt:formatNumber>
													</td>
												</tr>
											</c:forEach>
										
										<!-- /.card-body -->


									</tbody>
								</table>
								<div class="card-footer">
									<button class="btn btn-primary">Submit</button>
								</div>
							</f:form>
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