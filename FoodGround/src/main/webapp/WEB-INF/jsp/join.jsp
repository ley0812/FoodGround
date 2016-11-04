<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/join.css">
<title>FoodGround</title>
</head>
<body>
	<header>
		<h2>회원가입</h2>
	</header>

	<div class="join">

		<form:form commandName="member" name="member" action="/members/save" method="POST">
			<fieldset class="input">
				<div class="element">
					<label for="sectionId" class="label">지역 선택<span class="must">*</span></label><br>
					<form:select path="sectionId" name="sectionId" id="sectionId" class="sectionId" size="1">
						<option value="1" selected>서현</option>
						<option value="2">이매</option>
						<option value="3">판교</option>
					</form:select>
				</div>
		
				<div class="element">
					<label for="nickname" class="label">닉네임<span class="must">*</span></label><br>
					<form:input path="nickName" id="nickName" name="nickName" cssClass="blank" placeholder="영문,숫자를 조합해 3~10자를 입력하세요."/>
					<button type="button" id="duplication" class="inner_btn" onclick="duplicate();">중복확인</button><br>
					<form:errors path="nickName" cssClass="error"/>
					<span id="duplication_msg" style="display: none">닉네임이 존재하고 있습니다.</span>
					<input type="hidden" id="duplication_token" value=""/>
				</div>
				
				<div class="element">
					<label for="password" class="label">비밀번호<span class="must">*</span></label><br>
					<form:password path="password" id="password" name="password" class="blank" placeholder="영문,숫자를 조합해 6~10자를 입력하세요."/><br>
					<form:errors path="password" cssClass="error"/>
				</div>
				
				<div class="element">
					<label for="repassword" class="label">비밀번호 확인<span
						class="must">*</span></label><br> 
						<input type="password" id="repassword" class="blank" placeholder="비밀번호를 한번 더 입력해주세요." onchange="passwordVerify();">
						<span id="verify" class="error"></span>
				</div>
				
				<div class="element">
					<label for="email" class="label">이메일</label><br> 
					<form:input path="email" name="email" id="email" value="" placeholder="ex)food1@foodground.com"/>
					<form:errors path="email" cssClass="error"/>
				</div>
			</fieldset>

			<div class="btn_group">
				<button type="button" class="btn" id="join_btn" value="가입" onclick="check();">
					<strong>가입하기 </strong>
				</button>
				<button type="button" class="btn" id="login_btn" onclick="cancel();" value="취소">
					<strong>취소</strong>
				</button>
			</div>
		</form:form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>	
	<script src="../../js/join.js"></script>
</body>
</html>