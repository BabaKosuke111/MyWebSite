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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>ユーザー更新確認画面</title>
</head>
<body style="background: #0e0e0e url(image/background_Track_Morning.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-header">新規登録確認画面</div>
			<div class="card-body">
				<h3 class=" col-12 ">登録完了</h3>
				<br>
				<div class="form-group">
					<h5 class="card-title">User name</h5>
					<input type="text" class="form-control" value="${udb.name}"
						style="width: 500px;" readonly> <br>
				</div>
				<div class="form-group">
					<h5 class="card-title">Email address</h5>
					<input type="email" class="form-control" value="${udb.address}"
						style="width: 500px;" readonly> <br>
				</div>
				<div class="form-group">
					<h5 class="card-title">Password</h5>
					<input type="password" class="form-control" value="${udb.password}"
						style="width: 500px;" readonly><br>
				</div>
				<br>
				<div class="row">
					<div class="col-3">
						<a class="btn btn-primary btn-lg btn-block" href="Login">ログイン画面へ</a>
					</div>
					<div class="col-4"></div>
					<div class="col-4"></div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>