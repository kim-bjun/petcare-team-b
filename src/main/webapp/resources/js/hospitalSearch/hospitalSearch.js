/**
 * hospital search
 */

class Search {
	constructor() {
		this.city = ['서울특별시', '경기도', '인천', '부산', '대구', '광주', '대전', '울산',
			'강원도', '경상남도', '경상북도', '전라남도', '전라북도', '충청남도', '충청북도', '제주도', '세종시'];
		this.gu = ['oo구'];
		this.dong = ['oo동'];
		this.animal = ['강아지', '고양이', '새', '파충류', '특수동물'];
		this.time = ['주간진료', '24시간진료', '야간응급진료'];
		this.subject = ['내과', '외과', '안과', '피부과', '치과', '영상의학', '동물행동학', '한방'];
		this.etc = ['백신접종', '중성화수술', '건강검진', '마이크로칩이식'];
		this.convenience = ['미용', '호텔', '주차'];
		this.selectedAddress = {
			city: '',
			gu: '',
			dong: '',
		};
		this.selectedCheck = {
			animal: [],
			time: [],
			subject: [],
			etc: [],
			convenience: [],
		};
		this.limitSelect = 5;
		
		this.init();
	}
	init () {
		this.cityRender();
		this.checkboxRender();
		this.eventsTrigger();
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
			const selectedCheck = $this.next('label').text();
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
		$('.search-button').on('click', function() {
			console.log(selectedCity);
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
			elem.forEach((e, i) => {
				const element = `
				<div class="custom-control custom-checkbox col">
					<input type="checkbox" id="checkbox${idx+1}-input${i+1}" class="custom-control-input">
					<label class="custom-control-label" for="checkbox${idx+1}-input${i+1}">${e}</label>
				</div>`;
				elements += element;
			});
			$(`#checkbox${idx+1}`).append(elements);
			elements = "";
		});
	}
	countSelect() {
		const selectedCheck = this.selectedCheck;
		const total = selectedCheck.animal.length
			+ selectedCheck.time.length
			+ selectedCheck.subject.length
			+ selectedCheck.etc.length
			+ selectedCheck.convenience.length;
		return total;
	}
	pushOrRemoveCheck(checkedState, category, selected) {
		console.log(checkedState);
		const selectedCheck = this.selectedCheck;
		
		switch(category) {
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
		}
	}
}


(function() {
	new Search()
})();