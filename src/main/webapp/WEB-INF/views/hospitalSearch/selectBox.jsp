<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<div class="container">
	<label class="search-title">지역별 검색</label>
	<div class="container">
		<div class="input-group mb-3">
		  <select class="custom-select" id="inputGroupSelect1"
		  onfocus="this.size=8;" onblur="this.size=1;" onchange="this.size=1; this.blur();">
		    <option selected>-지역 선택-</option>
		  </select>
		</div>
		<div class="input-group mb-3">
		  <select class="custom-select" id="inputGroupSelect2"
		  onfocus="this.size=8;" onblur="this.size=1;" onchange="this.size=1; this.blur();">
		    <option selected>-구 선택-</option>
		  </select>
		</div>
		<div class="input-group mb-3">
		  <select class="custom-select" id="inputGroupSelect3"
		  onfocus="this.size=8;" onblur="this.size=1;" onchange="this.size=1; this.blur();">
		    <option selected>-동 선택-</option>
		  </select>
		</div>
	</div>
</div>