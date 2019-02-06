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
<body 	style="background: #0e0e0e url(image/background_Forest.png); background-size: cover;">
		<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-5">
				<div class="card text-white bg-dark mb-3">
					<div class="card-image">
						<img
							src="${carddata.fileName}"
							width="460" height="600">
					</div>
				</div>
			</div>
			<div class="col-7">
							<div class="card text-white bg-dark mb-3">
				<h4>　${carddata.cardName}</h4>
				<h5>　コスト：${carddata.cardCost}</h5>
				<h5>　クラス：${carddata.className}</h5>
				<h5>　効果　：${carddata.cardEffect}</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>