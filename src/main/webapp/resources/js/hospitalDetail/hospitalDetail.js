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
	
	let setReviewList =(x)=>{
		$('#reviewList').empty()
		var pageNo= ($('input[name="pageNo"]').val() == null ) ? 1 : $('input[name="pageNo"]').val() ;
		$.ajax({
			url : '/sch/'+hosNo+'/pageNo/'+pageNo ,
			type : 'GET',
			contentType: 'application/json',
			success : d=>{
				$.each( d.review ,(i,j)=>{
					$('<div>'+j.comment+'</div>')
					.appendTo('#reviewList')
					.css({'border':'1px solid pink'})
				})
				pagination(d.pagenation)
			},
			error : e =>{
				
			}
		})
	}
 	let pagination=d=>{
		var cnt = 0;
		$('ul[class="pagination pagination-sm justify-content-center"]').empty()
		if(d.existPrev) {$(' <li class="page-item"><a class="page-link" href="#">Previous</a></li>')
		.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
		.click(e=>{
			$('input[name="pageNo"]').val(d.blist[0]-5),
			setReviewList()
			})
		}
		
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