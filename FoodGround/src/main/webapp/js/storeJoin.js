function getAddress() {
	daum.postcode.load(function(){
        new daum.Postcode({
        	onresize: function(size) {
        		size.width = 200;
        		size.height = 200;
            },
            oncomplete: function(data) {
            	$("#zipcode_copy").val(data.postcode);
            	$("#zipcode").val(data.postcode);

            	if(data.jibunAddress != "") {
            		$("#mainAddress_copy").val(data.jibunAddress);
            		$("#mainAddress").val(data.jibunAddress);

            	}else {
            		$("#mainAddress_copy").val(data.jibunAddress);
            		$("#mainAddress").val(data.jibunAddress);
            	}
           }
        }).open();
    });
}

function mainTel() {
	var head_number = $("#head_number").val();
	var body_number = $("#body_number").val();
	var tail_number = $("#tail_number").val();

	$("#mainTelephone").val( head_number+'-'+body_number+'-'+tail_number );
}

function subTel() {
	var sub_head_number = $("#sub_head_number").val();
	var sub_body_number = $("#sub_body_number").val();
	var sub_tail_number = $("#sub_tail_number").val();
	$("#subTelephone").val( sub_head_number+'-'+sub_body_number+'-'+sub_tail_number );
}

function check() {
	if($("#sub_head_number").val() == "선택") {
		$("#subTelephone").val("000-000-0000");
	}
	document.store.submit();
	return true;
}