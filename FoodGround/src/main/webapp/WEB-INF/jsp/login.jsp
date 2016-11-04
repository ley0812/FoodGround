<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<title>FoodGround</title>
</head>
<body>
	<header>
		<h2>로그인</h2>
	</header>

	<div class="login">
		<form action="/login" method="POST">
			<fieldset class="input">
				<div class="element">
					<label for="sectionId" class="label">지역 선택</label><br>
					<select name="sectionId" id="sectionId" class="sectionId" size="1">
						<option value="1" selected>서현</option>
						<option value="2">이매</option>
						<option value="3">판교</option>
					</select>
				</div>
				<div class="element">
					<label for="nickName" class="label">닉네임</label><br>
					<input type="text" id="nickName" name="nickName" class="blank">
				</div>
				<div class="element">
					<label for="password" class="label">비밀번호</label><br>
					<input type="password" id="password" name="password" class="blank">
				</div>
			</fieldset>

			<div class="btn_group">
				<button type="submit" class="btn" id="join_btn" value="회원가입">
					<strong>로그인</strong>
				</button>
				<button type="button" class="btn" id="login_btn" onclick="cancel()" value="로그인">
					<strong>취소</strong>
				</button>
			</div>
			<br>
			<span class="label">테스트용 아이디 : admin1234 </span><br>
			<span class="label">테스트용 비밀번호 : admin1234</span>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="../../js/login.js"></script>
</body>
</html>