<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <!-- datapick -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
	<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
	<!-- datepicker 한국어로 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>

	
</head>
<body>
	<div id="root">
		<header>
			<%@ include file="../common/header.jsp" %>
		</header>
 
 
 <!-- 시작  -->

<div class="container">
<c:if test="${userId != null}">
 <p>${userId}</p>
 <input type="hidden" name="userId" id="userId"value="${userId}">
</c:if>
  <h2>예약 내역</h2>
  <p>
  	기간 조회 <input id="startDate" class="dueDate"> ~ <input id="endDate" class="dueDate">
  	<button>기간으로 조회하기</button>
  </p>
  <table class="table table-bordered">
    <thead>
      <tr>
      	<th>예약 번호</th>
        <th>예약 날짜</th>
        <th>예약 시간</th>
        <th>병원</th>
        <th>반려동물</th>
        <th>등록일</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${list}" var="reservation">
      <tr>
      	<td><a href="/reservation/get?treatNo=<c:out value="${reservation.treatNo}"/>" >
      	<c:out value="${reservation.treatNo}"/></a></td>
      	<td><c:out value="${reservation.resDt}"/></td>
      	<td><c:out value="${reservation.resTime}"/></td>
        <td><c:out value="${reservation.hosName} "/></td>
        <td><c:out value="${reservation.aniName} "/></td>
        <td><c:out value="${reservation.regDt} "/></td>
      </tr>
     </c:forEach>
<%--         <td><fmt formatDate pattern="yyyy-mm-dd" type="date" value="${reservation.res_dt} "/></td>
        <td><fmt formatDate pattern="hh:mm" type="time" value="${reservation.res_dt} "/></td>
        <td><fmt formatDate pattern="yyyy-mm-dd" type="date" value="${reservation.reg_dt}"/> </td> --%>
      
      
    </tbody>
  </table>
  
      
      
      <div>
	      <select>
	      	<option value="hos">병원</option>
	      	<option value="aniname">반려동물이름</option>
	      </select>
	      <form class="search-box form-inline active-purple-4 align-items-center justify-content-center">
			  <input class="form-control form-control-sm w-75"
			  	type="text"
			  	placeholder="search."
			    aria-label="Search">
			  <i class="search-btn fas fa-search" aria-hidden="true"></i>
			</form>
		</div>
      <button id="goReser" type="button" class="btn btn-info">
     	 예약하러가기
      </button>
</div>



 
 
 <!-- 끝 -->
 		<footer>
			<%@ include file="../common/footer.jsp" %>
		</footer>
	</div>
	
	<script type="text/javascript">
		$(document).ready(
		function(){
			$("#goReser").on("click",function(){
				self.location="/reservation/regist";
			});
		
		 function() {
		  $(".dueDate").datepicker({
			  beforeShowDay: $.datepicker.noWeekends,
		      showButtonPanel: true, 
		      currentText: '오늘 날짜',
		      dateFormat: "yymmdd",
		      closeText: '닫기', 
		      showOn: "both", 
		      buttonImage: "/resources/img/reservation/calendar20.svg", 
		      buttonImageOnly: true,
		      
		      //var today= new Date(),
		  	  //$("#datepicker").datepicker( "option", "minDate", today );
		  });
		
		});
	</script>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>    
    <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b98d20d346.js" crossorigin="anonymous"></script>
	<script src="/resources/js/common/template.js"></script>
</body>
</html>