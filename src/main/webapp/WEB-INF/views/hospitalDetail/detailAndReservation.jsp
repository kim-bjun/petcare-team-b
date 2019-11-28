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
					<img class="hospital-image" src=${result.hosPhoto} style="width: 100%;"/>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6">
			    <div class="card">
			      <div class="card-body card-body-part">
			      	<div class="container hospital-info">
			      		
			      		<form action="/reservation/regist" method="post">
			      			<input type="hidden" value="${result.hosNo}" name="hosNo"/>
			      		</form>
				        <div class="card-title hospital-info-title">${result.hosName}</div>
				        <div class="card-text hospital-info-text">${result.hosPhone}</div>
				        <div class="card-text hospital-info-text">${result.hosAddress}</div>
				        <div class="card-text hospital-info-text"><a href="${result.hosSite}" target="_blank">${result.hosSite}</a></div>
				        <div class="card-text hospital-info-text">${result.hosMajorTreatmentTarget}</div>
				        <div class="card-text hospital-info-text">${result.hosCourseOfTreatment}</div>
			      	</div>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</div>