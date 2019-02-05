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
	href=" https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>デッキ登録</title>
</head>
<body style="background: #0e0e0e url(image/background_Track_Night.png); background-size: cover;">
	<jsp:include page="/baselayout/logininfo.jsp" />
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form class="container" action="CardSelect">
		<div class="card ">
			<div class="form-group">
				<div class="card-header">デッキ投稿</div>
				<div class="card-body">
					<h5 class="card-title">デッキ名</h5>
					<input type="text" class="form-control" name="name"
						placeholder="デッキ名" style="width: 500px;" required> <br>
					<h5 class="card-title">クラス</h5>
					<br>
					<c:forEach var="classdata" items="${classList}">
													<div class="pretty p-default p-round">
						<input type="radio" name="classId" value="${classdata.id} "
							placeholder="クラス" required>
						<div class="state"><label>${classdata.className}　　</label>
							</div>
							</div>
			</c:forEach>
					<br> <br>
					<button type="submit" class="btn btn-primary">To
						cardselect</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>