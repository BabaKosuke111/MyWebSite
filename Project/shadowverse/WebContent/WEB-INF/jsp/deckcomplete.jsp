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
<body
	style="background: #0e0e0e url(image/background_Track_Night.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-header text-center">登録完了</div>
			<div class="card-body">
				<div class="row">
					<div class="col-4"></div>
					<div class="col-4">
						<a class="btn btn-primary btn-lg btn-block" href="Index">ホーム画面へ</a>
					</div>
					<div class="col-4"></div>
				</div>
			</div>
		</div>
		<br> <br>
		<div class="text-center">
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">カード名</th>
						<th scope="col">枚数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dddb" items="${dddbList}">
						<tr>
							<td>${dddb.cardName}</td>
							<td>${dddb.cardCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br> <br>
		</div>
		<br> <br>
</body>
</html>