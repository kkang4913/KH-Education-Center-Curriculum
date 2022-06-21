/**
 * 
 */
//1. 브라우저 화면에 로드가 완료 되었을 때 아래의 기능 동작
window.onload = function(){
	createOptionMonth();
}
$(function() {
	createOptionMonth();
	$(".allchk").bind("click",function(e){
		toggleAll(this);
	});
});


function createOptionMonth(){
	var selects = document.querySelectorAll("select[data-calendar='month']");
										//	요소가 month 인것을 찾아 반복문 실행
	for(let select of selects){
		for(let month = 1; month <=12; month++){
			let option = document.createElement("option");
			option.setAttribute("value",month);
			option.innerHTML = `${month} 월`;
			select.append(option);
			}
			
		var calendarId = select.getAttribute("data-calendar-id");
		if(calendarId){
			let dateSelect = document.querySelector(`[data-calendar ='date']`+ 
				`[data-calendar-id='${calendarId}']`);
			select.addEventListener("change", function(e){
				createOptionDate(this,dateSelect);
			});
		}
	}
}

function createOptionDate(month, element) {
	var date = new Date();
	date.setMonth(month.value, 0);
	
	var count = element.childElementCount;
	
	if(count > 1){
		for(let idx = 1; idx <count; idx++){
			element.removeChild(element.children[1]);
		}
	}
	
	for(let num = 1; num <=date.getDate(); num++){
		let option = document.createElement("option");
		option.setAttribute("value", num);
		option.innerText = `${num} 일`;
		element.append(option);
	}	
}

function toggleAll(element){
	var name = element.getAttribute("name");
	var checkboxs = document.getElementsByName(name);
	
	if(element.getAttribute("checked") === null){
		for(checkbox of checkboxs){
			checkbox.setAttribute("checked", "");
			checkbox.checked = true;

		}
	}else{
		for(checkbox of checkboxs){
			checkbox.removeAttribute("checked");
			checkbox.checked = false;
	}
}	
}
