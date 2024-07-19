<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:400px;margin:auto;padding:20px;border-style: outset;">
<h4 class="title-group" style="margin-left:120px;color:#82ae46;margin-bottom:20px;">Home Login</h4>
<p style="color:red;">${msg}</p>
	<form action="${contextPath}/login" method="post">
		<div class="form-group">
			<input type="text"
				class="form-control" placeholder="Enter the user name" name="username">
		</div>
		<div class="form-group">
			<input type="password"
				class="form-control" placeholder="Enter the password" name="password">
		</div>
		<button type="submit" class="btn btn-primary" style="margin-left:120px;margin-top:20px;padding:10px 30px">Login</button>
	</form>
	   <ul style="list-style-type: none;margin-top:10px;"><li> <span>Do not have an account ?</span><a href="${contextPath}/register" style="text-decoration: none;color:#82ae46;">Create an Account</a></li>
		</ul>
</div>