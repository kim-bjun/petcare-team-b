<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<div class="container detailAndReservation shadow-sm rounded">
	<div class="card rounded">
		<div class="card-header">
	        <div class="container">
	        	<div class="row">	        		
	        		<div class="col-sm-10">
	        			<div class="detail-label">병원 정보</div>
	        		</div>
	        		<div class="col-sm-1 detail-icon-btn-wrap">
	        			<i class="far fa-calendar-alt detail-icon-btn" aria-hidden="true"></i>
	        		</div>
	        		<div class="col-sm-1 detail-icon-btn-wrap">
		        		<i class="far fa-bookmark detail-icon-btn" aria-hidden="true"></i>
						<i class="fas fa-bookmark detail-icon-btn" aria-hidden="true" style="display: none;"></i>
	        		</div>
	        	</div>
	        </div>
		</div>
		<div class="card-body card-body-wrap">
			<div class="row shadow-sm rounded">
			  <div class="col-sm-6">
			    <div class="card">
			      <div class="card-body card-body-part">
					<img class="hospital-image" src="/resources/img/hospitalDetail/animal_hospital.jpg" style="width: 100%;"/>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6">
			    <div class="card">
			      <div class="card-body card-body-part">
			      	<div class="container hospital-info">
				        <div class="card-title hospital-info-title">MS 동물 병원</div>
				        <div class="card-text hospital-info-text">부산 연제구 연산동 104-82</div>
				        <div class="card-text hospital-info-text">051-868-6631</div>
				        <div class="card-text hospital-info-text">	http://blog.naver.com/vet4910</div>
				        <div class="card-text hospital-info-text">내과, 외과, 안과, 치과, 피부과</div>
				        <div class="card-text hospital-info-text">개,고양이</div>
			      	</div>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</div>