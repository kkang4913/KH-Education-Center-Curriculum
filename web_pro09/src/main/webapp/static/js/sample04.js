/**
 * 
 */


function f1(){
	var date = document.getElementById("id_input1_date");
	
	var res1 = document.getElementById("res1");
	
	//res1.innerHTML += "<div>" + "<h2>" + date+ "</h2>" + "</div>"
	res1.innerHTML = new Date(date.value);
	
}