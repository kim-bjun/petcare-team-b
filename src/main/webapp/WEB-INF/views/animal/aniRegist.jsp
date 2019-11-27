<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<c:set var="currentURI" value="${requestScope['javax.servlet.forward.request_uri']}" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>

	
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
					<h6 class="section-title">동물 등록</h6>
					
					<form:form action="${currentURI}" method = "post" accept-charset="utf-8"
								role="form" id="animalRegist" modelAttribute="animalVO">
								
					<div style="display:none">
						<c:forEach items="${AnimalInfo }" var="map">
							<c:if test="${map.key ne 'queryString' }">
								<input type="hidden" name="${map.key }" value="${map.value }" />
							</c:if>
						</c:forEach>
					</div>
					
					<div class="table-responsive">
						<table class = "table table-striped table-bordered table-custom2">
							<colgroup>
								<col width="20%">
								<col width="80%">
							</colgroup>
							
							<tbody>
								<tr>
									<th>이름</th>
									<td><input type="text"
											value="${animalVO.ani_name}" id="ani_name" name="ani_name"
											class="col-sm-3 form-control" placeholder="동물이름" maxlength="16" />
										
									</td>
								</tr>
								
								<tr>
									<th>종류</th>
									<td><input type="text" name="ani_kind"
											value="${animalVO.ani_kind}" id="ani_kind"
											class="col-sm-3 form-control" placeholder="동물종류" maxlength="16" />
									</td>
								</tr>
								
								<tr>
									<th>품종</th>
									<td><input type="text" name="ani_breed"
											value="${animalVO.ani_breed}" id="ani_breed"
											class="col-sm-3 form-control" placeholder="동물품종" maxlength="16" />
									</td>
								</tr>
							</tbody>
						
						</table>
					</div>
					
					<div class="container">
						<div class="row">
							<div class="col">
								<button
									type="submit"
									class="search-button btn btn-primary d-flex justify-content-center"
								>
									동물등록
								</button>
							</div>
						</div>
					</div>
					</form:form>
					
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