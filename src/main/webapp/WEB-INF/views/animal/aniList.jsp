<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="currentURI" 
		value="${requestScope['javax.servlet.forward.request_uri']}" />

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
    <link rel="stylesheet" href="/resources/css/common/pagination.css" /> 
    <link rel="stylesheet" href="/resources/css/home/home.css" />
    <link rel="stylesheet" href="/resources/css/hospitalSearch/hospitalSearch.css" /> 
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b98d20d346.js" crossorigin="anonymous"></script>
	<script src="/resources/js/common/custom.js"></script>
    
</head>
<body>
<div id="root">
	<header>
		<%@ include file="../common/header.jsp" %>
	</header>
	
	
<form action="${currentURI}" method="get" accept-charset="utf-8" role="form" id="searchForm" name="searchForm">
	<main class="main">
			<div class="hospital-search">
				<section>
					<div class="container">
					<h6 class="section-title">반려동물 목록</h6>
					
					<div class="row">
						<div class="col-xs-9">
							<h5>
								Total : ${NumberRows }건  <small>[${AnimalInfo.page } / ${AnimalInfo.lastPage }] 페이지</small>
							</h5>
						</div>
					</div>
					
					<div class="table-responsive">
						<table class = "table table-striped table-bordered">
							<thead>
								<tr>
									<th>이름</th>
									<th>종류</th>
									<th>품종</th>
									<th>최종 진료병원</th>
									<th>최종 진료일자</th>
									<th>수정</th>
									<th>지우기</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${NumberRows gt 0 }">
									<c:forEach var="animalVO" items="${Result }" varStatus="status">
										<tr>
											<td>${animalVO.ani_name } </td>
											<td>${animalVO.ani_kind } </td>
											<td>${animalVO.ani_breed } </td>
											<td></td>
											<td></td>
											<td>
												<a
													href="<c:url value="/${animalVO.ani_no }?${AnimalInfo.queryString }" context="/animal/modify" />"
													class="search-button btn btn-primary d-flex justify-content-center"
												> 수정
												</a>
											</td>
											<td>
												<a
													href="<c:url value="/${animalVO.ani_no }?${AnimalInfo.queryString }" context="/animal/delete" />"
													class="search-button btn btn-primary d-flex justify-content-center"
												> 삭제
												</a>
											</td>
										</tr>
									</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="5">등록된 동물이 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
												
						</table>
					</div>
					<div class="text-center">${ PaginationUtil }</div>
					
					
					<div class="container">
						<div class="row">
							<div class="col">
								<a
									href="<c:url value="/write?${AnimalInfo.queryString }" context="/animal" />"
									class="search-button btn btn-primary d-flex justify-content-center"
								> 등록
								</a>
							</div>
						</div>
					</div>
					
					</div>
			</section>
		</div>
	</main>
</form>
		<footer>
			<%@ include file="../common/footer.jsp" %>
		</footer>
	</div>
</body>
</html>