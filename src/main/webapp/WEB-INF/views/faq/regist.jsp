<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Zalbazo</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/common/template.css" />
<link rel="stylesheet" href="/resources/css/login/login.css" />

</head>
<body>
	<div id="root">
		<header>
			<%@ include file="../common/header.jsp"%>
		</header>
		<section>
			<form role="form" method="post">
			<div class="form-group">
			<label>카테고리</label>
			<select name="faqCat">
				<option value="register">회원가입</option>
				<option value="reservation">예약</option>
				<option value="review">리뷰</option>
			</select>
			</div>
			<div class="form-group">
			<label>제목</label>
			<input type="text" name="faqName" />
			</div>
			<div class="form-group">
			<label>내용</label>
			<textarea name="faqCont" placeholder="Enter..."></textarea>
			</div>
			<div class="form-group">
			<button type="submit">등록</button> 
			</div>
			
			</form>
		</section>
		<footer>
			<%@ include file="../common/footer.jsp"%>
		</footer>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b98d20d346.js" crossorigin="anonymous"></script>
	<script src="/resources/js/common/template.js?ver=1"></script>
</body>

</html>
