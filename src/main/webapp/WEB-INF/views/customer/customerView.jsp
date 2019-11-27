<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<c:set var="currentURI" value="${requestScope['javax.servlet.forward.request_uri']}" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		
		$.validator.addMethod("passwordCk", function(value){
			var passwordCk = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			return value.match(passwordCk)
		}, '비밀번호는 영문자, 숫자, 특수문자 조합을 입력해야 합니다.');
		
		$.validator.addMethod("isPhone", function(value){
			var isPhone = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
			return value.replace(/\s+/g, "").match(isPhone)
		}, '전화번호 형식에 맞지 않습니다.');
		
		$("#customerRegist").validate({
			rules : {
				user_id : {
					required : true,
					minlength : 4
				},
				user_pass : {
					required : true,
					passwordCk : true,
					minlength : 8,
					maxlength : 16
				},
				user_pass_conf : {
					required : true,
					equalTo : '#user_pass'
				},
				user_name : {
					required : true
				},
				user_phone : {
					required : true,
					isPhone : true
					
				},
				user_email : {
					email:true
				}
			},	messages : {
					user_id : {
						required : "아이디를 입력해주세요.",
						minlength : "최소 4자리 이상 입력해주세요."
					},
					user_pass : {
						required : "패스워드를 입력해주세요.",
						passwordCk : "비밀번호는 영문자, 숫자, 특수문자 조합을 입력해야 합니다."
					},
					user_pass_conf : {
						required : "패스워드를 확인해주세요",
						equalTo : "패스워드가 다릅니다."
					},
					user_name : {
						required : "이름을 입력해주세요."
					},
					user_phone : {
						required : "전화번호를 입력해주세요"
					},
					user_email : {
						email : "올바른 이메일을 입력해주세요."
					}
				} // messages
		});
	});
	</script>
	
<style>
	.search-button {
		margin: 0 auto;
	}
	
	#customerRegist label.error{
		margin-left: 10px;
		color:red;
	}
</style>

<html>
<head>
    <title>Zalbazo</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/common/template.css" /> 
    <link rel="stylesheet" href="/resources/css/home/home.css" />
    <link rel="stylesheet" href="/resources/css/hospitalSearch/hospitalSearch.css" /> 
</head>
<body>
<div id="root">
	<header>
		<%@ include file="../common/header.jsp" %>
	</header>
	<main class="main">
			<div class="hospital-search">
				<section>
					<div class="container">
					<h6 class="section-title">My Page</h6>
					
					<div class="table-responsive">
						<table class = "table table-striped table-bordered table-custom2">
							<colgroup>
								<col width="20%">
								<col width="80%">
							</colgroup>
							
							<tbody>
								<tr>
									<th>아이디</th>
									<td>${customerVO.user_id}</td>
								</tr>
								<tr>
									<th>이름</th>
									<td>${customerVO.user_name }</td>
								</tr>
								
								<tr>
									<th>전화번호</th>
									<td>${customerVO.user_phone }</td>
								</tr>
								
								<tr>
									<th>이메일</th>
									<td>${customerVO.user_email}</td>
								</tr>
								
								<tr>
									<th>주소</th>
									<td>${customerVO.user_address}</td>
								</tr>
							</tbody>
						
						</table>
					</div>
					
					<div class="container">
						<div class="row">
							<div class="col">
								<input type="button" value="반려동물 등록"
									class="search-button btn btn-primary d-flex justify-content-center"
								>
							</div>
						</div>
					</div>
					
			</div>
		</section>
	</div>
</main>

		<footer>
			<%@ include file="../common/footer.jsp" %>
		</footer>
	</div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>  -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b98d20d346.js" crossorigin="anonymous"></script>
	<script src="/resources/js/common/template.js"></script>
</body>
</html>