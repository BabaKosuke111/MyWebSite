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
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<title>Shadowverselogs</title>
</head>
<body class="text-center"
	style="background: #0e0e0e url(image/background_Track_Morning.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<table class="container table table-dark">
		<thead>
			<tr>
				<th scope="col">デッキ名</th>
				<th scope="col">クラス</th>
				<th scope="col">投票数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="deckrank" items="${deckRankingList}">
				<tr>
					<td><a class="badge badge-pill" href="DeckDetail?deckId=${deckrank.id }" target="_blank">${deckrank.deckName }</a></td>
					<td>${deckrank.className}</td>
					<td>${deckrank.voteCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>