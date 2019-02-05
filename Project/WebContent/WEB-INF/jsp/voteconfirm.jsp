<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja" class="translated-ltr">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css "
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<title>投票画面</title>
</head>
<body
	style="background: #0e0e0e url(image/background_Track_Morning.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="text-center">
			<div class="card border-dark">
				<br>
				<h3 class=" col-12 ">投票が完了しました</h3>
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
		<br> <br>
		<div class="text-center">
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">デッキ名</th>
						<th scope="col">クラス</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${deckdata.deckName}</a></td>
						<td>${deckdata.className}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>