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
		<div>
		<form>
		<select>
		<option value="n">---</option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		</select>
		<input type="text" name="searchCont"/>
		</form>
		</div>
		<div><a href="/faq/regist" style="font-size:20px ; border:1px solid ;float:right" >등록</a></div>
			
			<c:forEach var="faq" items="${list}">
			${faq.faqCat=='register'? 1:2 }${faq.faqNo} &nbsp&nbsp ${faq.faqName} &nbsp&nbsp ${faq.faqCont} &nbsp&nbsp  <a href="/faq/modify?faqCat=${faq.faqCat}&faqName=${faq.faqName}&faqCont=${faq.faqCont}&faqNo=${faq.faqNo}">수정</a> <a href="/faq/delete?faqNo=${faq.faqNo}">삭제</a><br>
			</c:forEach>
			<div>

				<c:if test="${paging.prev}">
					<a href="/faq/list?pageNo=${paging.startPage-1}">prev</a>
				</c:if>
				<c:forEach var="i" begin="${paging.startPage}"
					end="${paging.endPage }" step="1">
					<a href="/faq/list?pageNo=${i}">${i}</a>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="/faq/list?pageNo=${paging.endPage+1}">next</a>
				</c:if>
			</div>
		</section>
		<footer>
			<%@ include file="../common/footer.jsp"%>
		</footer>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/b98d20d346.js"
		crossorigin="anonymous"></script>
	<script src="/resources/js/common/template.js?ver=1"></script>
</body>
<script>
	var result = '${msg}';
	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

</script>
</html>
