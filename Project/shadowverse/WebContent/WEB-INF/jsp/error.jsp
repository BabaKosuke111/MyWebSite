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
<title>全デッキ一覧</title>
</head>
<body
	style="background: #0e0e0e url(image/background_Laboratory.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="text-center">
			<div class="card border-dark">
				<br>
				<h4 class="red-text">システムエラーが発生しました</h4>
				<h5 class="red-text">${errorMessage}</h5>
				<br> <br>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-4">
						<a class="btn btn-primary btn-lg btn-block" href="Index">ホーム画面へ</a>
						<br>
					</div>
					<div class="col-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>