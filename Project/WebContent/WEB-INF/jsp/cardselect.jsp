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
			<div class="card-header">カード選択画面</div>
			<div class="card-body">
				<c:if test="${validationMessage!=null}">
					<div class="alert alert-danger" role="alert">
						${validationMessage}</div>
				</c:if>
				<form action="DeckConfirm">
					<input type="hidden" name="classId" value="${classId}">
					<div class="form-group">
						<h5 class="card-title">デッキ名</h5>
						<input type="text" class="form-control" name="name"
							placeholder="デッキ名" value="${deckname }" style="width: 500px;"
							readonly> <br> <br>
						<button type="submit" class="btn btn-primary">Confirm</button>
					</div>
			</div>
		</div>
		<br> <br>
		<div class="text-center">
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">カード名</th>
						<th scope="col">コスト</th>
						<th scope="col">枚数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cardselect" items="${cardselectList}">
						<tr>
							<td><a class="badge badge-pill"
								href="CardDetail?cardId=${cardselect.id}" target="_blank">${cardselect.cardName}</a></td>
							<td>${cardselect.cardCost}</td>
							<td><input type="hidden" name="carddeckId"
								value="${cardselect.id}">
								<div class="row">
									<div class="col-4"></div>
									<div class="col-4">
										<div class="input-group mb-3">
											<select class="custom-select" name="cardCount">
												<option value="0">ー</option>
												<option value="1">1枚</option>
												<option value="2">2枚</option>
												<option value="3">3枚</option>
											</select>
										</div>
										<div class="col-4"></div>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</form>
	</div>
</body>
</html>