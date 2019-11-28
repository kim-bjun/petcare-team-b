"use strict"
class Dummy {
	constructor() {
		this.init();
	}
	init () {
		this.eventsTrigger();
	}
	eventsTrigger() {
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
	

}

/*
function setHospitalList(x){
	console.log(x);
	$('div.container.hospital-list-wrap').empty()
	var pageNo= ($('input[name="pageNo"]').val() == null ) ? 1 : $('input[name="pageNo"]').val() ;
	let arr = x
	$.ajax({
		url : '/sch/hospitalList/'+pageNo,
		type:'POST',
		dataType:'json',
		data:JSON.stringify(arr),
		contentType:'application/json',
		success: d=>{
			$.each(d.result ,(i,j)=>{
				let divClass;
				if (i==0) {
					divClass = '	<div class="row hospital-list shadow-sm rounded">'
				}else{
					divClass =  '	<div class="row hospital-list">'
				}
					$(divClass +
						'		<div class="col-sm-4">'+
						'			<img src="'+j.hosPhoto+'"/>'+
						'		</div>'+
						'		<div class="col-sm-8 hospital-detail-wrap">'+
						'			<div class="hospital-detail title">'+j.hosName+'</div>'+
						'			<div class="hospital-detail">&nbsp;	 </div>'+
						'			<div class="hospital-detail">'+j.hosPhone+'</div>'+
						'			<div class="hospital-detail">'+j.hosAddress+'</div>'+
						'			<div class="hospital-detail">'+j.hosMajorTreatmentTarget+'</div>'+
						'			<div class="hospital-detail">'+j.hosCourseOfTreatment+'</div>'+
						'		</div>'+
						'	</div>')
						.click(()=>{
							setDetailView(j)
						})
						.appendTo('div.container.hospital-list-wrap')
						pagination(d.pagination)
			})
		},
		error : e=>{
		}
	})
	
}

function pagination (d){
	var cnt = 0;
	$('ul[class="pagination pagination-sm justify-content-center"]').empty()
	if(d.existPrev) {$(' <li class="page-item"><a class="page-link" href="#">Previous</a></li>')
	.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
	.click(e=>{
		$('input[name="pageNo"]').val(d.blist[0]-5),
		$('.search-button').click()
		})
	}
	
	$.each(d.blist, (i,j)=>{
		if(j != d.pageNo){
			$('<li class="page-item"><a class="page-link"  href="#">'+j+'</a></li>')
			.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
			.click(e=>{
				e.preventDefault()
				$('input[name="pageNo"]').val(j)
				$('.search-button').click()				
			})
		}else if(j == d.pageNo){
			$('<li class="page-item"><a class="page-link"  href="#">'+j+'</a></li>')
			.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
			.addClass('active')
		}
		
	})			
	
	if(d.existNext) {
		$('    <li class="page-item"><a class="page-link" href="#">Next</a></li>')
			.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
		.click(e=>{
			e.preventDefault()
			$('input[name="pageNo"]').val(d.blist[0]+5),
			$('.search-button').click()
		})		
	}

}	


function setDetailView(x) {
	location.assign('/sch/detail?hosNo='+x.hosNo)
}*/

(function() {
		new Dummy()
})();