<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja" class="translated-ltr">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>新規登録</title>
</head>
<body
	style="background: #0e0e0e url(image/background_Mountains.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="form-group">
				<div class="card-header">新規登録</div>
				<div class="card-body">
					<form action="NewLoginConfirm" method="post">
						<c:if test="${validationMessage!=null}">
							<div class="alert alert-danger" role="alert">
								${validationMessage}</div>
						</c:if>
						<h5 class="card-title">User Name</h5>
						<input type="text" class="form-control" placeholder="Username"
							value="${udb.name}" name="name" style="width: 500px;" required><br>
						<h5 class="card-title">E-mail address</h5>
						<input type="email" class="form-control" "				placeholder="e-mail"
							value="${udb.address }" name="address" style="width: 500px;"
							required><br>
						<h5 class="card-title">Password</h5>
						<input type="password" class="form-control" placeholder="Password"
							name="password" style="width: 500px;" required><br>
						<h5 class="card-title">Password(Confirm)</h5>
						<input type="password" class="form-control"
							placeholder="Password(Confirm)" name="cfpassword"
							style="width: 500px;" required><br>
						<button type="submit" class="btn btn-primary">Confirm</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>