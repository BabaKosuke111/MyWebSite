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
	style="background: #0e0e0e url(image/background_Hall.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<form class="container" action="AllDeck" method="post">
		<div class="card ">
			<div class="form-group">
				<div class="card-header">デッキ検索</div>
				<div class="card-body">
					<h5 class="card-title">デッキ名</h5>
					<input type="text" class="form-control" placeholder="デッキ名"
						name="deckName" style="width: 500px;"> <br> <br>
					<h5 class="card-title">クラス</h5>
					<input type="text" class="form-control" placeholder="クラス"
						name="className" style="width: 500px;"> <br> <br>
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</div>
	</form>
	<hr>
	<div class="text-center">
	<table class="container table table-dark">
		<thead>
			<tr>
				<th scope="col">デッキ名</th>
				<th scope="col">クラス</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="deckdata" items="${AllDeckList}">
				<tr>
					<td><a class=" badge badge-pill "
						href="DeckDetail?deckId=${deckdata.id}" target="_blank">${deckdata.deckName}</a></td>
					<td>${deckdata.className}</td>
					<c:if test="${userInfo.name=='admin'}">
						<td><a class="btn btn-primary"
							href="DeckDelete?deckId=${deckdata.id}" role="button">削除</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>