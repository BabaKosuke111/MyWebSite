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
	<div class="container">
		<form action="DeckDeleteComplete">
			<div class="card">
				<div class="card-header text-center">デッキを削除してよろしいですか？</div>
				<div class="card-body">
					<div class="row">
						<div class="col-2"></div>
						<div class="col-3">
							<button type="submit" class="btn btn-primary btn-lg btn-block" name="confirm_button" value="cancel">Cancel</button>
						</div>
						<div class="col-2"></div>
						<div class="col-3">
							<button type="submit" class="btn btn-primary btn-lg btn-block" name="confirm_button" value="delete">Delete</button>
						</div>
						<div class="col-2"></div>
					</div>
				</div>
			</div>
			<br>
			<div class="text-center">
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">デッキ名</th>
							<th scope="col">クラス</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="hidden" name="deckId" value="${deckId}"><a class="badge badge-pill"
								href="DeckDetail?deckId=${deckId}" target="_blank">${deckdata.deckName }</a></td>
							<td>${deckdata.className}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</div>
</body>
</html>