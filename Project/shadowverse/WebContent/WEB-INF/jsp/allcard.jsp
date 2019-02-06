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
<title>全カード一覧</title>
</head>
<body
	style="background: #0e0e0e url(image/background_Morning_Star.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<div class="container">
		<form action="AllCard" method="post">
			<div class="card ">
				<div class="form-group">
					<div class="card-header">カード検索</div>
					<div class="card-body">
						<h5 class="card-title">カード名</h5>
						<input type="text" class="form-control" placeholder="カード名"
							name="cardName" style="width: 500px;"> <br> <br>
						<h5 class="card-title">クラス</h5>
						<input type="text" class="form-control" placeholder="クラス"
							name="className" style="width: 500px;"> <br> <br>
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</div>
			</div>
		<hr>
		<div class="text-center">
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">カード名</th>
						<th scope="col">クラス</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="carddata" items="${AllCardList}">
						<tr>
							<td><a class=" badge badge-pill "
								href="CardDetail?cardId=${carddata.id}" target="_blank">${carddata.cardName}</a></td>
							<td>${carddata.className}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</form>
	</div>
</body>
</html>