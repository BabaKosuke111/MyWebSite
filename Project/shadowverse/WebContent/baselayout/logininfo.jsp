<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
	class="navbar-brand" href="Index">ShadowverseLogs</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarNav" aria-controls="navbarNav"
	aria-expanded="false" aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="Index">Home
				<span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="AllDeck">全デッキ一覧</a></li>
		<li class="nav-item"><a class="nav-link" href="AllCard">全カード一覧</a></li>
		<li class="nav-item"><a class="nav-link" href="UserVote">投票画面</a></li>
		<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>
			<%if(isLogin){ %>
		<li class="nav-item"><a class="nav-link" href="DeckSubmit">デッキ投稿</a></li>
			<%} %>
	</ul>
</div>
<div class="collapse navbar-collapse" id="navbarNav">
<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">

	<%if(isLogin){ %>
	<li class="nav-item"><a class="nav-link far fa-user-circle fa-2x" href="UserData"></a></li>
	<%}else{ %>
	<li class="nav-item"><a class="nav-link fas fa-sign-in-alt fa-2x" href="Login"></a></li>
	<%} %>

	<%if(isLogin){ %>
		<li class="nav-item"><a class="nav-link fas fa-sign-out-alt fa-2x" href="Logout"></a></li>
	<%}else{ %>
	<li class="nav-item"><a class="nav-link fas fa-plus fa-2x" href="NewLogin"></a></li>
	<%} %>

</ul>

</div>
</nav>