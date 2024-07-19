<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 style="margin-left: 600px; font-style: italic; color: #82ae46">Register</h3>
<p style="color: DodgerBlue; margin-left: 600px;">${success}</p>
<p style="color: red; margin-left: 600px;">${msg}</p>
<form:form action="${contextPath}/register/save" method="post"
	modelAttribute="account" enctype="multipart/form-data">
	<div class="row">
		<div class="col-md-6">
			<table class="table">
				<tr>
					<td>User Name</td>
					<td><form:input path="userName" cssClass="form-control"/>
					<label><form:errors style="color: red" path="userName"></form:errors></label>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password" cssClass="form-control"/>
					<label><form:errors style="color: red" path="password"></form:errors></label>
					</td>
				</tr>
				<tr>
					<td>Full Name</td>
					<td><form:input path="fullName" cssClass="form-control"/>
					<label><form:errors style="color: red" path="fullName"></form:errors></label>
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" cssClass="form-control"/>
					<label><form:errors style="color: red" path="address"></form:errors></label>
					</td>					
				</tr>
				<tr>
					<td>Create Date</td>
					<td><form:input path="createDate" cssClass="form-control"/>
					<label><form:errors style="color: red" path="createDate"></form:errors></label>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-md-6">
			<table class="table">
				<tr>
					<td>Avatar</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" cssClass="form-control"/>
					<label><form:errors style="color: red" path="email"></form:errors></label>
					</td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" cssClass="form-control"/>
					<label><form:errors style="color: red" path="phone"></form:errors></label>
					</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:checkbox path="gender" checked="checked" />Men</td>
				</tr>
			</table>
		</div>
	</div>
	<button style="margin-left: 660px; padding: 10px 30px;"
		class="btn btn-primary">Submit</button>
</form:form>