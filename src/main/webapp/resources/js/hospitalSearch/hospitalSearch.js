"use strict"
class Search {
	constructor() {
		this.city = ['서울특별시', '경기도', '인천', '부산', '대구', '광주', '대전', '울산',
			'강원도', '경상남도', '경상북도', '전라남도', '전라북도', '충청남도', '충청북도', '제주도', '세종시'];
		this.gu = ['oo구'];
		this.dong = ['oo동'];
		this.animal = {'101':'강아지', '102': '고양이', '103': '새', '104': '파충류', '105': '특수동물'};
		this.time = {'201': '주간진료', '202': '24시간진료', '203': '야간응급진료'};
		this.subject = {'301': '내과','302':  '외과', '303': '안과', '304': '피부과', '305': '치과', '306': '영상의학', '307': '동물행동학', '308': '한방'};
		this.etc = {'401': '백신접종', '402': '중성화수술', '403': '건강검진', '404': '마이크로칩이식'};
		this.convenience = {'501': '미용', '502': '호텔', '503': '주차'};	
/*		this.animal = ['강아지', '고양이', '새', '파충류', '특수동물'];
		this.time = ['주간진료', '24시간진료', '야간응급진료'];
		this.subject = ['내과', '외과', '안과', '피부과', '치과', '영상의학', '동물행동학', '한방'];
		this.etc = ['백신접종', '중성화수술', '건강검진', '마이크로칩이식'];
		this.convenience = ['미용', '호텔', '주차'];*/
		this.selectedAddress = {
			city: '',
			gu: '',
			dong: ''
		};
		this.selectedCheck = [
/*			animal: {},
			time: {},
			subject: {},
			etc: {},
			convenience: {}*/
		];
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
					<input type="checkbox" id="${e}" class="custom-control-input">
					<label class="custom-control-label" for=${e}>${i}</label>
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
/*		switch(category) {
			case 'checkbox1': {
				console.log('dfsdf')
				if(checkedState) {
					console.log('미나으리ㅏㅁㄴ을')
					selectedCheck.animal.push(selected);					
				} else {
					console.log('s여기')
					selectedCheck.animal = selectedCheck.animal.filter(e => e !== selected);
				}
				break;
			}
			case 'checkbox2': {
				if(checkedState) {
					selectedCheck.time.push(selected);					
				} else {
					selectedCheck.time.filter(e => e !== selected);
				}
				break;
			}
			case 'checkbox3': {
				if(checkedState) {
					selectedCheck.subject.push(selected);					
				} else {
					selectedCheck.subject.filter(e => e !== selected);
				}
				break;
			}
			case 'checkbox4': {
				if(checkedState) {
					selectedCheck.etc.push(selected);					
				} else {
					selectedCheck.etc.filter(e => e !== selected);
				}
				break;
			}
			case 'checkbox5': {
				selectedCheck.convenience.push(selected);
				break;
			}
			default: {
				console.log('error');
			}
		}*/
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
	new Search()
})();