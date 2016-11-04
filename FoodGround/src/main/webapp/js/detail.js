$( document ).ready(function() { 
	var cookie = $.cookie('9011_FoodGround_cookie');
	
	if(cookie == undefined) {
		$(".edit_mark").css("display","none");
	} else {
		$(".edit_mark").css("display","");
	}
});

var g_name = $("#name").html();
var g_menu = $("#tag_menu").html();
var g_keyword = $("#tag_keyword").html();
var g_service = $("#tag_service").html();

function edit_name() {
	$("#name_edit_btn").show();
	console.log("Hello");
	$("#name").attr("readonly",false);
	$("#name").focus();
}
function edit_menu() {
	$("#menu_edit_btn").show();
	$("#tag_menu").attr("readonly",false);
	$("#tag_menu").focus();
}
function edit_keyword() {
	$("#keyword_edit_btn").show();
	$("#tag_keyword").attr("readonly",false);
	$("#tag_keyword").focus();
}
function edit_service() {
	$("#service_edit_btn").show();
	$("#tag_service").attr("readonly",false);
	$("#tag_service").focus();
}
function edit_address() {
	$("#address_edit_btn").show();
	$("#address").attr("readonly",false);
	$("#address").focus();
}
function edit_telephone() {
	$("#telephone_edit_btn").show();
	$("#telephone").attr("readonly",false);
	$("#telephone").focus();
}

function edit_proc(context ,store_id) {
		
	var cookie = $.cookie('9011_FoodGround_cookie');
	
	if(cookie == undefined) {
		window.location = '/login';
	}
	
	var type = context.value;
	var store_id = store_id;
	var divider = context.id;
	var memo;
	var before_memo;
	
	if(divider == 'name_edit_btn'){
		memo = $("#name").val();
		before_memo = g_name;
	}
	if(divider == 'menu_edit_btn'){	
		memo = $("#tag_menu").val();
		before_memo = g_menu;
	}
	if(divider == 'keyword_edit_btn'){
		memo = $("#tag_keyword").val();
		before_memo = g_keyword;
	}
	if(divider == 'service_edit_btn'){
		memo = $("#tag_service").val();
		before_memo = g_service;
	}
	if(divider == 'address_edit_btn'){
		memo = $("#address").val();
		before_memo = g_service;
	}
	if(divider == 'telephone_edit_btn'){
		memo = $("#telephone").val();
		before_memo = g_service;
	}
	var jsondata = {
    		'logType': type,	
    		'storeId': store_id,
    		'memo': memo,
    		'beforeMemo': before_memo
    };
	$.ajax({
    	method: "POST",
    	data: JSON.stringify(jsondata),  
    	contentType: "application/json",
    	url:'/stores/edit',
        success:function(data){
        	console.log(data.result);
        }
    });
}

function cancel() {
	window.location = '/';
}

var g_toggle = undefined;

function favorite(storeId, toggle) {
	
	var cookie = $.cookie('9011_FoodGround_cookie');
	
	if(cookie == undefined) {
		window.location = '/login';
	}
	if(g_toggle != undefined) {
		toggle = g_toggle;
	}
	if(toggle == '' || toggle== 'N') {
		$("#like").attr("src","../../img/like.png");
		g_toggle = 'Y';
		toggle = 'Y';
	} else if(toggle == 'Y'){
		$("#like").attr("src","../../img/dontlike.png");
		g_toggle = 'N';
		toggle = 'N';
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
        	console.log(toggle);
        }
    });
}

var g_closed = undefined;
var g_name = undefined;

function closed_store(storeId, sectionId, name, open) {
	
	var cookie = $.cookie('9011_FoodGround_cookie');
	if(cookie == undefined) {
		window.location = '/login';
	}
	
	if(g_closed != undefined) {
		open = g_closed;
		name = g_name;
	}
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
	        	$("#name").val(name);
	        	g_name = name;
	        	g_closed = data.open;
	        	if(g_closed == 'Y') {
	        		$("#closed").attr("src","../../img/closed-big.png");
	        		$("#closed_tag").text("폐업신고");
	        		$("#name").val(name);
	        	} else {
	        		$("#closed").attr("src","../../img/open.png");
	        		$("#closed_tag").text("영업신고");
	        		$("#name").val("(폐업)"+name);
	        	}
	        }
	    });
}

function insert_review(storeId) {
	var cookie = $.cookie('9011_FoodGround_cookie');
	
	if(cookie == undefined) {
		window.location = '/login';
	}
	
	var contents = $("#review_box").val();
	
	var jsondata = {
			'storeId': storeId,
			'contents': contents
	};
	
	$.ajax({
    	method: "POST",
    	data: JSON.stringify(jsondata),
    	contentType: "application/json",
    	url:'/reviews/save',

        success:function(data) {
    		window.location = '/stores/'+storeId;
        }
    });

}