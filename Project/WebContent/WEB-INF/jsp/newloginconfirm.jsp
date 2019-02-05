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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>ユーザー一覧</title>
</head>
<body style="background: #0e0e0e url(image/background_Mausoleum.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-header">新規登録確認画面</div>
			<div class="card-body">
				<form action="NewLoginResist" method="post">
					<div class="form-group">
						<h5 class="card-title">User name</h5>
						<input type="text" class="form-control" value="${udb.name }"
							name="name" style="width: 500px;" readonly><br>
						<h5 class="card-title">E-mail address</h5>
						<input type="email" class="form-control"
							"				value="${udb.address}" name="address" style="width: 500px;"
							readonly><br>
						<h5 class="card-title">Password</h5>
						<input type="password" class="form-control"
							value="${udb.password}" name="password" style="width: 500px;"
							readonly><br>
					</div>
					<div class="row">
						<div class="col-1">
							<button type="submit" class="btn btn-primary"
								name="confirm_button" value="cancel">Cancel</button>
						</div>
						<div class="col-1">
							<button type="submit" class="btn btn-primary"
								name="confirm_button" value="regist">Resist</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>