"use strict"
var hospitalDetail = hospitalDetail || {}
hospitalDetail = (()=>{
	
	let hosNo;
	let init =(x)=>{
		hosNo = x
	}
	let onCreate =(x)=>{
		init(x)
		setReviewList()
	}
	
	// 리뷰 리스트 생성
	let setReviewList =(x)=>{
		$('#media').empty()	
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