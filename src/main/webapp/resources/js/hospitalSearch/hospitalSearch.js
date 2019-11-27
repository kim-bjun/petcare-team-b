"use strict"
class Search {
	constructor(d) {
		this.city = ['서울특별시', '경기도', '인천', '부산', '대구', '광주', '대전', '울산',
			'강원도', '경상남도', '경상북도', '전라남도', '전라북도', '충청남도', '충청북도', '제주도', '세종시'];
		this.gu = ['oo구'];
		this.dong = ['oo동'];
		this.animal = d.animal;
		this.time = d.time;
		this.subject = d.subject;
		this.etc = d.etc;
		this.convenience = d.convenience;	
		this.selectedAddress = {
			city: '',
			gu: '',
			dong: ''
		};
		this.selectedCheck = [];
		this.limitSelect = 5;
		
		this.init();
	}
	init () {
		this.cityRender();
		this.checkboxRender();
		this.eventsTrigger();
		setHospitalList(this.selectedCheck);
	}
	eventsTrigger() {
		const self = this;
		const selectedCheck = this.selectedCheck;
		const total = this.countSelect();
		
		// 시 클릭
		$('#inputGroupSelect1').on('click', function() {
			const city = $(this).val();
			if(city !== '-지역 선택-') {
				self.selectedAddress.city = city;
				console.log(self.selectedAddress.city);
				// 구 렌더
				self.guRender();
			}
		});
		// 구 클릭
		$('#inputGroupSelect2').on('click', function() {
			const gu = $(this).val();
			if(gu !== '-구 선택-') {
				self.selectedAddress.gu = gu;
				console.log(self.selectedAddress.gu);
				// 동 렌더
				self.dongRender();
			}
		});
		// 동 클릭
		$('#inputGroupSelect3').on('click', function() {
			const dong = $(this).val();
			if(dong !== '-동 선택-') {
				self.selectedAddress.dong = dong;
				console.log(self.selectedAddress.dong);
			}
		});
			$('.custom-control-input').on('click', function(e) {
			const $this = $(this);
			const checkedState = $this.prop('checked');
			const category = $this.parent().parent();
			const selectedCheck = $this.next('label').attr("for");
			if(self.countSelect() < self.limitSelect) {
				self.pushOrRemoveCheck(checkedState, category.attr('id'), selectedCheck);
			} else {
				alert('5개 이상 선택하셨습니다.');
				$this.prop('checked', false);
			}
			console.log(self.selectedCheck);
//			let checked = [];
//			$.each($("input:checkbox:checked"), function(){
//				checked.push($(this));
//			});
//			console.log(checked.length);
			
		});
		$('.search-button').click(()=>{
			setHospitalList(this.selectedCheck)
		})
		
	}
	
	
	
	cityRender() {
		this.city.forEach((e, i) => {
			$('#inputGroupSelect1').append(`<option value=${e}>${e}</option>`);
		});
	}
	guRender() {
		this.gu.forEach((e, i) => {
			$('#inputGroupSelect2').append(`<option value=${e}>${e}</option>`);			
		});
	}
	dongRender() {
		this.dong.forEach((e, i) => {
			$('#inputGroupSelect3').append(`<option value=${e}>${e}</option>`);
		});
	}
	checkboxRender() {
		const subtitles = [this.animal, this.time, this.subject, this.etc, this.convenience];
		let elements = "";
		subtitles.forEach((elem, idx) => {
			$.each(elem,(e,i) => {
				const element = `
				<div class="custom-control custom-checkbox col">
					<input type="checkbox" id="${i.hosInfoCode}" class="custom-control-input">
					<label class="custom-control-label" for=${i.hosInfoCode}>${i.codeName}</label>
				</div>`;
				elements += element;
			});
			$(`#checkbox${idx+1}`).append(elements);
			elements = "";
		});
	}
	countSelect() {
		const selectedCheck = this.selectedCheck;
		const total = selectedCheck.length;
		return total;
	}
	//self.pushOrRemoveCheck(checkedState, category.attr('id'), selectedCheck);
	pushOrRemoveCheck(checkedState, category, selected) {
		console.log(checkedState);
		const selectedCheck = this.selectedCheck;
		selectedCheck.push(selected);
	}
}



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
		setHospitalList(Search.constructor.selectedCheck)
		})
	}
	
	$.each(d.blist, (i,j)=>{
		if(j != d.pageNo){
			$('<li class="page-item"><a class="page-link"  href="#">'+j+'</a></li>')
			.appendTo('ul[class="pagination pagination-sm justify-content-center"]')
			.click(e=>{
				e.preventDefault()
				$('input[name="pageNo"]').val(j)
				setHospitalList(Search.constructor.selectedCheck)
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
			setHospitalList(Search.constructor.selectedCheck)
		})		
	}

}	


function setDetailView(x) {
	location.assign('/sch/detail?hosNo='+x.hosNo)
}

(function() {
	$.getJSON('/sch/', d=>{
		new Search(d)
	})

})();