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
	style="background: #0e0e0e url(image/background_Lake_Night.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<form action="VoteConfirm" method="post">
			<div class="card">
				<div class="card-header text-center">投票画面</div>
				<div class="card-body">
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-lg btn-block">Vote</button>
						</div>
						<div class="col-4"></div>
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
						<c:forEach var="deckdata" items="${AllDeckList}">
							<tr>
								<td><a class="badge badge-pill"
									href="DeckDetail?deckId=${deckdata.id }" target="_blank">${deckdata.deckName }</a></td>
								<td>${deckdata.className}</td>
								<td>
									<div class="pretty p-default p-round">
										<input type="radio" name="voteId" value="${deckdata.id }"
											required>
										<div class="state">
											<label></label>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>