$( document ).ready(function() {
	var cookie = $.cookie('9011_FoodGround_cookie');
	if(cookie != undefined) {
		$("#login_btn").hide();
		$("#join_btn").hide();
		$("#logout_btn").show();
	}else {
		$("#login_btn").show();
		$("#join_btn").show();
		$("#logout_btn").hide();
	}
});
 
function delete_cookie() {
	var cookie = $.cookie('9011_FoodGround_cookie');
	if(cookie != undefined) {
		$.removeCookie('9011_FoodGround_cookie');
	}
}

function show_detail(param) {
	window.location = '/stores/'+param;
}

function favorite(event, storeId, toggle) {
	
	var cookie = $.cookie('9011_FoodGround_cookie');
	
	if(cookie == undefined) {
		window.location = '/login';
	}
	
	event.stopPropagation();

	if(toggle == '' || toggle== 'N'){
		$("#like").attr("src","../../img/like.png");
		toggle = 'Y'
	} else if(toggle == 'Y'){
		$("#like").attr("src","../../img/dontlike.png");
		toggle = 'N'
	}
		
	var jsondata = {
    	'storeId': storeId,
    	'toggle': toggle
	};
	
	$.ajax({
    	method: "POST",
    	data: JSON.stringify(jsondata),
    	contentType: "application/json",
    	url:'/members/' + storeId + '/like',
        success:function(data){
        	console.log(data.result);
        	window.location = '/';
        }
    });
}

function search() {
	var keyword = $("#keyword").val();
	window.location = '/search?keyword='+keyword;
}

function tag_click(keyword) {
	window.location = '/search?keyword='+keyword;
}

function home(){
	window.location = '/';
}

function closed_store(event, storeId, sectionId, name, open) {
	
	var cookie = $.cookie('9011_FoodGround_cookie');
	if(cookie == undefined) {
		window.location = '/login';
	}
	
	event.stopPropagation();
	
	var jsondata = {
	    	'storeId': storeId,
	    	'sectionId': sectionId,
	    	'name': name,
	    	'open': open
		};
		$.ajax({
	    	method: "POST",
	    	data: JSON.stringify(jsondata),
	    	contentType: "application/json",
	    	url:'/stores/close',
	        success:function(data){
	        	window.location = '/';
	        }
	    });
}