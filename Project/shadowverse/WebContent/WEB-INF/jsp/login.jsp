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
<title>デッキ登録</title>
</head>
<body style="background: #0e0e0e url(image/background_Track_Night.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-header">ログイン</div>
			<div class="card-body">
				<c:if test="${loginerrMsg!=null}">
					<div class="alert alert-danger" role="alert">${loginerrMsg}</div>
				</c:if>
				<form action="LoginResult" method="post">
					<div class="form-group">
						<h5 class="card-title">E-mail address</h5>
						<input type="email" class="form-control" placeholder="e-mail"
							name="address" style="width: 500px;"><br>
						<h5 class="card-title">Password</h5>
						<input type="password" class="form-control" placeholder="Password"
							name="password" style="width: 500px;">
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>