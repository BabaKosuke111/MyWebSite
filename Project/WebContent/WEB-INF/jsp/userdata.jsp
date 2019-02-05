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
<body style="background: #0e0e0e url(image/background_Morning_Star.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="form-group">
				<div class="card-header">ユーザーデータ画面</div>
				<div class="card-body">
					<c:if test="${validationMessage!=null}">
						<div class="alert alert-danger" role="alert">
							${validationMessage}</div>
					</c:if>
					<form action="UserDataConfirm" method="post">
						<h5 class="card-title">User Name</h5>
						<input type="text" class="form-control" placeholder="Username"
							name="name" value="${userInfo.name}" style="width: 500px;"
							required> <br>
						<h5 class="card-title">E-mail address</h5>
						<input type="email" class="form-control" "				placeholder="e-mail"
							name="address" value="${userInfo.address }" style="width: 500px;"
							required> <br>
						<h5 class="card-title">Password</h5>
						<input type="password" class="form-control" placeholder="Password"
							name="password" value="" style="width: 500px;" required><br>
						<h5 class="card-title">Password(Confirm)</h5>
						<input type="password" class="form-control"
							placeholder="Password(Confirm)" name="cfpassword" value=""
							style="width: 500px;" required> <br>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>
			</div>
		</div>
		<hr>
		<div class="text-center">
			<table class="container table table-dark">
				<thead>
					<tr>
						<th scope="col">登録デッキ</th>
						<th scope="col">クラス</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="userdeckdata" items="${userdeckList}">
						<tr>
							<td><a class="badge badge-pill"
								href="DeckDetail?deckId=${userdeckdata.id }">${userdeckdata.deckName }</a></td>
							<td>${userdeckdata.className}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>