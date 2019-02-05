<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body style="background: #0e0e0e url(image/background_Lake.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="card bg-light mb-3">
			<div class="card-body">
				<div class="text-center">
					<h3 class=" col-12 ">ログアウトしました</h3>
				</div>
				<br>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-4">
						<a class="btn btn-primary btn-lg btn-block" href="Index">ホーム画面へ</a>
					</div>
					<div class="col-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>