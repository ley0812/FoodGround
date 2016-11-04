function duplicate() {
	var sectionId = $("#sectionId").val();
	var nickName = $("#nickName").val();

	$.ajax({
		url: "/members/"+sectionId+"/"+nickName,
  		type: "GET",
  		dataType: "json",
  		success: function(data){
  			if(data.result == true) {
  				duplication_msg(true);
  			}
  			if(data.result == false) {
  				duplication_msg(false);
  			}
  		}
	}); 
}

function duplication_msg(token) {
	if($("#duplication_msg").css("display") == "none"){
		$("#duplication_msg").css("display", "block");	
	}
		
	if(token == true) {
		$("#duplication_msg").css("color","red");
		$("#duplication_msg").html("닉네임이 중복됩니다.")
	}
		
	if(token == false) {
		$("#duplication_msg").css("color","blue");
		$("#duplication_msg").html("닉네임이 사용가능합니다.")
	}
}

function passwordVerify() {
	if( $("#password").val() == $("#repassword").val() ) {
		$("#verify").text("일치합니다.")
	} else {
		$("#verify").text("일치하지 않습니다.")
	}
}

function cancel() {
	window.location = '/';
}

function check() { 
	if( $("#password").val() == $("#repassword").val() ) {
		document.member.submit();
		return true;
	} else {
		$("#verify").text("일치하지 않습니다.")
	}
}