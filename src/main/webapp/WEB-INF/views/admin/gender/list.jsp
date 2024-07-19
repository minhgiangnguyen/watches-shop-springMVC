<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content-wrapper">
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">Gender Management</h1>
                </div>
                <!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Gender</li>
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
            <a href="${contextPath}/admin/gender/form" class="btn btn-success mb-2">Add New Gender</a>
            <h3 style="color: ${colorCss}">${msg}</h3>
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">List Gender</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table class="table table-bordered table-responsive">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Gender Name</th>
                                        <th>Gender Picture</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${genderList}" var="acc">
                                        <tr>
                                            <td>${acc.genderId}</td>
                                            <td>${acc.genderName}</td>
                                            <td>
                                                <img src="${contextPath}/assets_admin/dist/img/gender/${acc.genderPicture}" width="100" />
                                            </td>
                                            <td>
                                                <a href="${contextPath}/admin/gender/edit/${acc.genderId}" class="btn btn-info">Edit</a>
                                                <a href="${contextPath}/admin/gender/delete/${acc.genderId}" class="btn btn-danger" onclick="return confirm('Do you delete this gender?')">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                        <!--
                        <div class="card-footer clearfix">
                            <ul class="pagination m-0 float-right">
                                <c:forEach var="i" begin="1" end="${totalPage}">
                                    <c:choose>
                                        <c:when test="${i == currentPage}">
                                            <li class="page-item disabled"><a class="page-link" href="${contextPath}/admin/watch?pageNo=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-item"><a class="page-link" href="${contextPath}/admin/watch?pageNo=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </div>
                        -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </section>
    <!-- /.content -->
</div>