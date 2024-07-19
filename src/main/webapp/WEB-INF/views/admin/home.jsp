<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- FullCalendar -->
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.css'
	rel='stylesheet' />
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.js'></script>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Dashboard</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Dashboard</li>
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
			<div class="row">
				<!-- Tổng số đơn hàng -->
				<div class="col-lg-3 col-6">
					<div class="small-box bg-info">
						<div class="inner">
							<h3>${totalOrders }</h3>
							<p>TOTAL NUMBER OF ORDERS</p>
						</div>
						<div class="icon">
							<i class="ion ion-bag"></i>
						</div>
						<a href="${contextPath}/admin/orders" class="small-box-footer">Detail <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- /.col -->

				<!-- Số lượng tài khoản khách hàng -->
				<div class="col-lg-3 col-6">
					<div class="small-box bg-success">
						<div class="inner">
							<h3>${customerAccounts }</h3>
							<p>CUSTOMER ACCOUNTS</p>
						</div>
						<div class="icon">
							<i class="ion ion-person"></i>
						</div>
						<a href="/admin/account" class="small-box-footer">Detail <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- /.col -->

				<!-- Số lượng đơn được đặt -->
				<div class="col-lg-3 col-6">
					<div class="small-box bg-warning">
						<div class="inner">
							<h3>${ordersPlaced }</h3>
							<p>NUMBER OF ORDERS PLACED</p>
						</div>
						<div class="icon">
							<i class="ion ion-stats-bars"></i>
						</div>
						<a href="/admin/orderDetail" class="small-box-footer">Detail <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- Tổng số sản phẩm -->
				<div class="col-lg-3 col-6">
					<div class="small-box bg-danger">
						<div class="inner">
							<h3>${totalProducts }</h3>
							<p>TOTAL PRODUCTS</p>
						</div>
						<div class="icon">
							<i class="ion ion-cube"></i>
						</div>
						<a href="${contextPath}/admin/watch" class="small-box-footer">Detail <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>

				<!-- Biểu đồ doanh thu hàng tháng -->
				<div class="col-md-6">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Monthly revenue chart</h3>
						</div>
						<div class="card-body">
							<canvas id="revenueChart"></canvas>
						</div>
					</div>
				</div>

				<!-- Biểu đồ số lượng sản phẩm đã bán và còn lại -->
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Chart of the number of products sold
							and remaining</h3>
					</div>
					<div class="card-body">
						<canvas id="productChart"></canvas>
					</div>
				</div>

				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
	<script>
    document.addEventListener('DOMContentLoaded', (event) => {
        var ctx = document.getElementById('revenueChart').getContext('2d');
        var monthlyRevenueData = ${monthlyRevenueData};

        var labels = [];
        var data = [];

        <c:forEach var="revenue" items="${monthlyRevenueData}">
            labels.push('Tháng ${revenue[0]}');
            data.push(${revenue[1]});
        </c:forEach>;

        var revenueChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Monthly revenue',
                    data: data,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    });
    
    document.addEventListener('DOMContentLoaded', (event) => {
        var ctx = document.getElementById('productChart').getContext('2d');
        var orderWatchCount = ${orderWatchCount}; // Số lượng sản phẩm đã bán
        var remainingProductsCount = ${remainingProductsCount}; // Số lượng sản phẩm còn lại
        var productChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['Product sold', 'Remaining products'],
                datasets: [{
                    label: 'Số lượng sản phẩm',
                    data: [orderWatchCount, remainingProductsCount], // Thay thế bằng số lượng sản phẩm đã bán và còn lại,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.5)', // Màu đỏ
                        'rgba(54, 162, 235, 0.5)', // Màu xanh
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom',
                    },
                    title: {
                        display: true,
                        text: 'Biểu đồ số lượng sản phẩm đã bán và còn lại',
                    }
                }
            }
        });
    });
    
</script>

</div>
