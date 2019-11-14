<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<div class="container tab-menu rounded shadow-sm">
	<div class="row">
	  <div class="col">
	    <ul class="nav nav-tabs">
	      <li class="nav-item">
	        <a class="nav-link active" data-toggle="tab" href="#location">위치</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" data-toggle="tab" href="#review">리뷰</a>
	      </li>
	    </ul>
	    <div class="tab-content">
	      <div class="tab-pane fade show active" id="location">
	        <div id="map" style="width:500px;height:400px;"></div>
	      </div>
	      <div class="tab-pane fade" id="review">
	        <p>리뷰입니다.</p>
	      </div>
	    </div>
	  </div>
	</div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78181022727d3f4454b9edb8ec2c5aee&libraries=services,drawing"></script>
<script>

	const container = document.getElementById('map');
	const options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};
	
	// map 객체 생성
	const map = new kakao.maps.Map(container, options);
	
	// 주소-좌표 변환 객체를 생성
	const geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색
	geocoder.addressSearch('부산 연제구 연산동 104-82', function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        const coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시
	        const marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	    	// 마커 인포
	    	var infoContent="설명입니다.";
	    	var iwContent = '<div style="padding:5px;">'+infoContent+'</div>', // 인포 내용
	    	    iwRemoveable = true; // x버튼 표시
	        // 인포윈도우로 장소에 대한 설명을 표시
	        const infowindow = new kakao.maps.InfoWindow({
	            content: iwContent,
	    	    removable : iwRemoveable
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동
	        map.setCenter(coords);
	        
	    	// 마커 클릭이벤트 등록
	    	kakao.maps.event.addListener(marker, 'click', function() {
	    	      // 마커 위에 인포윈도우 표시
	    	      infowindow.open(map, marker);  
	    	});
	    } 
	});
</script>