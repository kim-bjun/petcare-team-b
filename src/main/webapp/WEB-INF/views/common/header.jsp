<%@ page language="java" pageEncoding="utf-8" import="com.petcare.web.domains.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<div class="header">
		<div class="row align-items-center">
			<div class="top-left">
				<h1 class="logo">
					<a href="/sample/home">
						<img class="logo-img" src="/resources/img/common/logo.png" width="90%"/>
					</a>
				</h1>
			</div>
		    <div class="top-center">
			    <form class="search-box form-inline active-purple-4 align-items-center justify-content-center">
				  <input class="form-control form-control-sm w-75"
				  	type="text"
				  	placeholder="병원을 검색해보세요."
				    aria-label="Search">
				  <i class="search-btn fas fa-search" aria-hidden="true"></i>
				</form>
	    	</div>
	    	<div class="top-right">
	    		<%
	    			UserVO obj = (UserVO)request.getSession().getAttribute("login");
	    			    		    	         	if( obj != null ) {
	    			    		    					String username = obj.getUsername();
	    		%>
    	        	<a href="/user/mypage">
    	        		<button class="auth-button btn btn-primary" type="button"><%= username %> 님</button>
    	        	</a>
		    		<button id="logout" class="auth-button btn btn-primary" type="button">로그아웃</button>
    	        <%
    	         	} else {
    	        %>
		    		<a href="/user/login">
			    		<button class="auth-button btn btn-primary" type="button">로그인</button>
		    		</a>
    	        <% 		
    	         	}
    			%>
	    	</div>
		</div>
	
		<div class="row align-items-center justify-content-center">
		    <div class="col-md-6 ">
		    	<div class="row justify-content-around">
			    	<div class="search-hospital header-nav">
			    		<a href="/sample/hospitalsearch">병원찾기</a>
	    			</div>
	    				<%
	    					UserVO check = (UserVO)request.getSession().getAttribute("login");
			    		    	         	if( check != null ) {
			    		    	         		String userId = obj.getUserid();
	    				%>
			    		    					
						<div class="reservation-confirm header-nav">
							<a href="/reservation/list?userId=<c:out value="<%=userId %>"/>">예약내역</a>
						</div>
	    				<% 
	    					} 
	    				%>
					<div class="community header-nav">
						<a href="">커뮤니티</a>
					</div>
					<div class="faq header-nav">
						<a href="/faq/list">FAQ</a>
					</div>
		    	</div>
		    </div>
	  	</div>
	  	
	</div>

</body>