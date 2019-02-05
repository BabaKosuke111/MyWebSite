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
	<div class="text-center">
		<br> <br>
		<form class="container" action="DeckComplete">
			<input type="hidden" name="deckname" value="${deckname}"> <input
				type="hidden" name="classId" value="${classId}">
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">カード名</th>
						<th scope="col">枚数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="deckdetail" items="${deckdetailList}">
						<tr>
							<td><input type="hidden" name="carddeckId"
								value="${deckdetail.cardId}"><a class="badge badge-pill"
								href="CardDetail?cardId=${deckdetail.cardId}" target="_blank">${deckdetail.cardName}</a></td>
							<td><input type="hidden" name="cardCount"
								value="${deckdetail.cardCount}">${deckdetail.cardCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
				</div>
				<div class="col-4"></div>
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>