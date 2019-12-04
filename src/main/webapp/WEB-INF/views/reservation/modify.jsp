<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" pageEncoding="utf-8" import="com.petcare.web.domains.CustomerVO"%>
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

<%-- 	<% 
		request.setCharacterEncoding("euc-kr"); 
	    int hos_no = Integer.parseInt(request.getParameter("hosNo"));
	%> --%>
	   	
	<div id="root">
		<header>
			<%@ include file="../common/header.jsp" %>
		</header>
	</div>
		<%-- <c:if test="${msg == false}">
			<p> 로그인을 해주세요 </p>
		</c:if> --%>
<form id="operForm" method="post">
	<div class="container">
		 <p>
		  	예약날짜: <input type="text" id="datepicker" name="resDt" value="<c:out value='${board.resDt}'/>"/>
		 </p>
		 		
		 <div>
		     <p>예약시간
		         <select id="res_time" name="resTime">
		             <option value="09:00">9:00</option>
		             <option value="10:00">10:00</option>
		             <option value="11:00">11:00</option>
		             <option value="12:00">12:00</option>
		             <option value="14:00">14:00</option>
		             <option value="15:00">15:00</option>
		             <option value="16:00">16:00</option>
		             <option value="17:00">17:00</option>
		         </select>
		       </p>
		 </div>
		 	<div >
			 
				 <p>예약할 반려동물 :
					 <select  name="aniNo">
						 <c:forEach items="${aninoList}" var="Nolist">
			       			<option  value="<c:out value="${Nolist.aniNo}"/>">
			       			<c:out value="${Nolist.aniName}"/></option>
			       		</c:forEach>
					 </select>
				 </p>
			 
			</div>
			 <textarea cols="40" rows="3" name="resItem" ><c:out value='${board.resItem}'/></textarea>
			 <button data-oper="modify" class="btn btn-info">수정하기</button>
			 <button data-oper="remove" class="btn btn-info">삭제하기</button>
	</div>
		 	<input type="hidden" id="treatNo" name="treatNo" value="<c:out value='${treatNo}'/>">
		 	<input type="hidden" id="userId" name="userId" value="<c:out value='${userId}'/>">

</form>
					
			    		    					
						
		
 
	<footer>
		<%@ include file="../common/footer.jsp" %>
	</footer>
	
	<script>
		$(documemt).ready(function(){
			
			
			var operForm= $('#operForm');
			$('button[date-oper="modify"]').on('click',function(e){
				e.preventDefault();
				operForm.attr('action','/reservation/modify').submit();
			});
			$('button[data-oper="remove"]').on('click',function(e){
				e.preventDefault();
				operForm.attr('action','/reservation/remove').submit();
			})
		})
			
			
	
	</script>
	<script>

	 $(document).ready(function(){
		$("#datepicker").datepicker({
			beforeShowDay: $.datepicker.noWeekends,
		      showButtonPanel: true, 
		      dateFormat: "yymmdd",
		      closeText: '닫기', 
		      showOn: "both", 
		      buttonImage: "/resources/img/reservation/calendar20.svg", 
		      buttonImageOnly: true,
		}) ;
		var today = new Date();
		$("#datepicker").datepicker( "option", "minDate", today );
	 });

</script>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b98d20d346.js" crossorigin="anonymous"></script>
	<script src="/resources/js/common/template.js"></script>
</body>
</html>