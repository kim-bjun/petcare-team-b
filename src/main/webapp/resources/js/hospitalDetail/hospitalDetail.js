"use strict"
var hospitalDetail = hospitalDetail || {}
hospitalDetail = (()=>{
	
	let hosNo;
	let init =(x)=>{
		hosNo = x
		$('.far.fa-calendar-alt.detail-icon-btn')
		.click(()=>{
			alert('예약 페이지로 이동합니다.')
			$.getJSON('/reservation/regist/'+hosNo,d=>{
			})
		})
		
		
	}
	let onCreate =(x)=>{
		init(x)
		setReviewList()
	}
	let setReservationPage=()=>{
		
	}
	// 리뷰 리스트 생성
	let setReviewWriteForm =()=>{
		$('#media').empty()	
		$('ul[class="pagination pagination-sm justify-content-center"]').empty()
		const reviewForm = '<div class="container" style="width:90%; margin-top : 10px; ">'
	    	  +'<form id="write_form" class="form-horizontal">'
	    	  +'<div class="form-group form-group-sm">'
	    	  +'<label class="col-sm-2 control-label" for="formGroupInputLarge"> 작성자 </label>'
	    	  +'<div class="col-sm-10">'
	    	  +'<input type="text"  name="userId" class="form-control" id="formGroupInputSmall" placeholder="아이디를 입력하세요" />'
	    	  +'</div>'
	    	  +'<label class="col-sm-2 control-label" for="formGroupInputLarge"> Comment </label>'
	    	  +'<div class="col-sm-10">'
	    	  +'<textarea name="comment" class="form-control" id="formGroupInputSmall" rows="5"  placeholder="리뷰를 적어주세요" ></textarea>' 
	    	  +'</div>'
	    	  +'<div id ="underRow" style="margin-top : 10px; margin-left : 15px;width:88% "><select name="rate" ></select></div>'
	    	  +'</div>'	    	  
	    	  +'<input type="hidden" name="hosNo" class="form-control" value="${result.hosNo}" />'
	    	  +'</form>'
	    	  +'</div>'
	    	  
	    $(reviewForm)
	    .appendTo('#media')
	    let star=''
	    for (var i = 1; i < 6; i++) {
	    	star += '★'  
			$('<option value='+i+'>'+star+'</option>').appendTo('#write_form select')
		}
	    
	 	$('<button>',{
			text : 'SUBMIT' , 
			href: '#' ,
			style:  'float:right;width:100px;margin-right:10%'
		})
		.addClass('btn btn-primary')
		.appendTo("#underRow")     
		.click(e=>{
			e.preventDefault()
			let json = { 
					userId :  $('#write_form input[name="userId"]').val() ,
					comment : $('#write_form textarea[name="comment"]').val(),
					hosNo : hosNo,
					rate : $('#write_form select[name="rate"]').val()
			}
			$.ajax({
				url : '/sch/writeReview/',
				type : 'POST',
				dataType : 'json',
				data: JSON.stringify(json) , 
				contentType : 'application/json', 
				success : d =>{
					alert('게시 성공  ' + d.msg);
					setReviewList(hosNo)
				},
				error : e =>{
					alert('게시 실패');
				}
			})  	
		})   
	    
	    
	}
	let setReviewList =(x)=>{
		$('#media').empty()	
		$('<button type="button" class="btn btn-default">리뷰쓰기</button>')
		.click(e=>{
			e.preventDefault()
			setReviewWriteForm()
		})
		.appendTo('#media')
		var pageNo= ($('input[name="pageNo"]').val() == null ) ? 1 : $('input[name="pageNo"]').val() ;
		$.ajax({
			url : '/sch/'+hosNo+'/pageNo/'+pageNo ,
			type : 'GET',
			contentType: 'application/json',
			success : d=>{
				if(d.review.length ==0){	// 남겨진 리뷰가 없을 시
					$('<blockquote class="blockquote">'+
							'  <p class="mb-0"> 아직 작성된 리뷰가 없어요!  </p>'+
							'  <footer class="blockquote-footer"><b>우리 병원 리뷰를 남겨주세요!</b></footer>'+
							'</blockquote>')
					.appendTo('#media')
				}else{
					$.each( d.review ,(i,j)=>{
						let tempReview ='<blockquote class="blockquote"><div>'
						let star=0
						for(; star < j.rate ; star++ ){ tempReview += '★'}
						for(star = j.rate ; star < 5 ; star++){ tempReview += '☆' } // 별점
						tempReview += '</div>'+
								'  <p class="mb-0">'+j.comment+'</p>'+
								'  <footer class="blockquote-footer"><cite title="Source Title"><b>'+j.userId+'</b></cite>'+ 
								'&nbsp;&nbsp;&nbsp;in &nbsp;'+j.writeDate
						if(j.treatNo != ""){
							tempReview += '&nbsp;&nbsp;<span class="label label-primary">실 사용자입니다.</span>'	// 실사용자 구분
						}
						tempReview += '</footer></blockquote>'
						
						$(tempReview)
						.appendTo('#media')
					})
					pagination(d.pagenation)	// 페이지 네이션
				}
			},
			error : e =>{}
		})
	}
	
	
 	let pagination=d=>{
		var cnt = 0;
		// 이전 블록 있을 시 Previous 버튼 생성
		$('ul[class="pagination pagination-sm justify-content-center"]').empty()
		if(d.existPrev) {$(' <li class="page-item"><a class="page-link" href="#">Previous</a></li>')
		.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
		.click(e=>{
			$('input[name="pageNo"]').val(d.blist[0]-5),
			setReviewList()
			})
		}
		
		// 페이지 생성
		$.each(d.blist, (i,j)=>{
			if(j != d.pageNo){
				$('<li class="page-item"><a class="page-link"  href="#">'+j+'</a></li>')
				.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
				.click(e=>{
					e.preventDefault()
					$('input[name="pageNo"]').val(j)
					setReviewList()
				})
			}else if(j == d.pageNo){
				$('<li class="page-item"><a class="page-link"  href="#">'+j+'</a></li>')
				.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
				.addClass('active')
			}
		})			

		// 다음 블록 있을 시 Next 버튼 생성
		if(d.existNext ) {
			$('    <li class="page-item"><a class="page-link" href="#">Next</a></li>')
			.appendTo('ul[class="pagination-sm justify-content-center"]')
			.click(e=>{
				e.preventDefault()
				$('input[name="pageNo"]').val(d.blist[0]+5),
				setReviewList()
			})		
		}

	}	
	return {onCreate}
})();