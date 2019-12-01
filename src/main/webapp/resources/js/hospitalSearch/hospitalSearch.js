"use strict"
class Search {
	constructor(d) {
		this.city = d.city;
		this.gu = [];
		this.animal = d.animal;
		this.time = d.time;
		this.subject = d.subject;
		this.etc = d.etc;
		this.convenience = d.convenience;	
		this.selectedAddress = {
			city: '',
			gu: ''
		};
		this.selectedCheck = [];
		this.limitSelect = 5;
		this.schCondition ={
				checkBoxList :[]
				, searchWrd : '' 
				, hosAddress : ''
		};
		this.init();
	}
	init () {
		this.cityRender();
		this.checkboxRender();
		this.eventsTrigger();
		setHospitalList(this.schCondition);
	}
	eventsTrigger() {
			const self = this;
			const selectedCheck = this.selectedCheck;
			const total = this.countSelect();
			
			// 시 클릭
			$('#inputGroupSelect1').on('change', function() {
				$('#inputGroupSelect2').empty();
				const city = $(this).val();
				if(city !== '') {
					self.selectedAddress.city =$(this).find("option:selected").text();
					// 구 렌더
					$.getJSON('/sch/SearchCondition/'+city , d =>{
						self.gu = [{"cd":'',"gb":'',"gbNm":'',"cdNm":"-구 선택-"}]
						self.gu = self.gu.concat(d.gu);
						self.guRender();
					} )
				}else{
					self.gu = [{"cd":'',"gb":'',"gbNm":'',"cdNm":"-구 선택-"}]
					self.selectedAddress.city = ''
					self.selectedAddress.gu = ''
					self.guRender();
				}
			});
			// 구 클릭
			$('#inputGroupSelect2').on('change', function() {
				const gu = $(this).val();
				if(gu != '') {
					self.selectedAddress.gu = $(this).find("option:selected").text();
				}else{
					self.selectedAddress.gu = $(this).val()
				}
			});
			
			$('.custom-control-input').on('click', function(e) {
			const $this = $(this);
			const checkedState = $this.prop('checked');
			const category = $this.parent().parent();
			const selectedCheck = $this.next('label').attr("for");
			if($('input:checkbox[name="checkbox"]:checked').length <= self.limitSelect) {
				self.pushOrRemoveCheck(checkedState, category.attr('id'), selectedCheck);
			} else {
				alert('5개 이상 선택하셨습니다.');
				$this.prop('checked', false);
			}
			console.log(self.selectedCheck);
		});
		
		$('.search-button').click(()=>{
			self.schCondition = {
					checkBoxList : self.selectedCheck 
					, searchWrd : $('input[name="hosName"]').val() 
					, hosAddress : self.selectedAddress.city + self.selectedAddress.gu 
					}
			setHospitalList(self.schCondition)
		})
	}
	
	
	
	cityRender() {
		this.city.forEach((e, i) => {
			$('#inputGroupSelect1').append(`<option value=${e.gb}>${e.gbNm}</option>`);
		});
	}
	guRender() {
		this.gu.forEach((e, i) => {
			$('#inputGroupSelect2').append(`<option value=${e.cd}>${e.cdNm}</option>`);			
		});
	}
	checkboxRender() {
		const subtitles = [this.animal, this.time, this.subject, this.etc, this.convenience];
		let elements = "";
		subtitles.forEach((elem, idx) => {
			$.each(elem,(e,i) => {
				const element = `
				<div class="custom-control custom-checkbox col">
					<input type="checkbox" id="${i.hosInfoCode}" class="custom-control-input" name="checkbox">
					<label class="custom-control-label" for=${i.hosInfoCode}>${i.codeName}</label>
				</div>`;
				elements += element;
			});
			$(`#checkbox${idx+1}`).append(elements);
			elements = "";
		});
	}
	
	countSelect() {
		//const selectedCheck = this.selectedCheck;
		const total = $('input:checkbox[name="checkbox"]:checked').length; // 5개 이상 선택 후, 체크박스 일부 체크 해제하였을 때 토탈 개수 반영이 되지 않아 수정.
		return total;
	}
	
	pushOrRemoveCheck(checkedState, category, selected) {
		console.log(checkedState);
		if(checkedState==true){
			const selectedCheck = this.selectedCheck;
			selectedCheck.push(selected);
		}else{
			const selectedCheck = this.selectedCheck;
			selectedCheck.pop(selected);
		}
	}
}


function setHospitalList(x){
	console.log(x);
	ClearSerachList()	
	var pageNo= ($('input[name="pageNo"]').val() == null ) ? 1 : $('input[name="pageNo"]').val() ;
	let arr = x
	$.ajax({
		url : '/sch/hospitalList/'+pageNo,
		type:'POST',
		dataType:'json',
		data:JSON.stringify(arr),
		contentType:'application/json',
		success: d=>{
			ClearSerachList()
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
			})//each
			pagination(d.pagination)
			
			//검색 결과가 없을 경우."검색 결과가 없습니다." 
			if(d.msg === "NODATA"){
				$('	<div class="row hospital-list shadow-sm rounded">'+
						'		<div class="col-sm-4">'+
						'		</div>'+
						'		<div class="col-sm-8 hospital-detail-wrap">'+	
						'		<h4 style="margin-top : 20px"> 검색 결과가 없습니다. </h4>'+
						'		</div>'+							
						'		</div>'
				)
				.appendTo('div.container.hospital-list-wrap')	
				
				
			}
		},
		error : e=>{
		}
	})
	
}

function ClearSerachList(){
	$('div.container.hospital-list-wrap').empty()  // List container
	$('ul[class="pagination pagination-sm justify-content-center"]').empty()  // pagination container
}

function pagination (d){
	var cnt = 0;
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
}

(function() {
	$.getJSON('/sch/SearchCondition', d=>{
		new Search(d)
	})
})();