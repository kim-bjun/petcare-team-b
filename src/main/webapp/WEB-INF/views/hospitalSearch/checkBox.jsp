<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<div class="container">
	<label class="search-title">선택 검색</label>
	<label class="search-title-description">5개까지 선택 가능</label>
	<div class="container field-set shadow-sm rounded">
		<p class="search-subtitle">진료 동물</p>
		<div id="checkbox1" class="row">
			<div class="custom-control custom-checkbox col" style="display: none;">
				<input type="checkbox" id="checkbox1-input0" class="custom-control-input">
				<label class="custom-control-label" for="checkbox1-input0">강아지</label>
			</div>
		</div>
	</div>
	<div class="container field-set shadow-sm rounded">
		<p class="search-subtitle">진료 시간</p>
		<div id="checkbox2" class="row">
		</div>
	</div>
	<div class="container field-set shadow-sm rounded">
		<p class="search-subtitle">진료 과목</p>
		<div id="checkbox3" class="row">
		</div>
	</div>
	<div class="container field-set shadow-sm rounded">
		<p class="search-subtitle">기타</p>
		<div id="checkbox4" class="row">
		</div>
	</div>
	<div class="container field-set shadow-sm rounded">
		<p class="search-subtitle">편의 시설</p>
		<div id="checkbox5" class="row">
		</div>
	</div>
	<input type="hidden" value="120" name="pageno"/>
</div>