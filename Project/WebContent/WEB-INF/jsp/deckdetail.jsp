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
<title>デッキ詳細画面</title>
</head>
<body style="background: #0e0e0e url(image/background_Castle.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="text-center">
				<div class="card text-white bg-dark mb-3">
			<h4>${deckdata.deckName}</h4>
			<h5>${deckdata.className}</h5>
			</div>
			<br>
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">カード名</th>
						<th scope="col">コスト</th>
						<th scope="col">枚数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="deckDetail" items="${deckDetailList}">
						<tr>
							<td><a class="badge badge-pill" href="CardDetail?cardId=${deckDetail.cardId}">${deckDetail.cardName}</a></td>
							<td>${deckDetail.cardCost}</td>
							<td>${deckDetail.cardCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>