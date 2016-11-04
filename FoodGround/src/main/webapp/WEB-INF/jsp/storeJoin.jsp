<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/storeJoin.css">
<title>FoodGround</title>
</head>
<body>
	<header>
		<h2>업체등록</h2>
	</header>
	
	<div class="join">
	
	<form:form enctype="multipart/form-data" name="store" commandName="store" action="/stores/save" method="POST">
	<fieldset class="input"> 
			<div class="element">
				<label for="name" class="label">업체명<span class="must">*</span></label><br>
				<form:input path="name" id="name" cssClass="blank" placeholder="업체명을 입력해주세요."/><br>
				<form:errors path="name" cssClass="error"/>
			</div>	 
			
			<div class="element">
				<label for="theme" class="label">분류<span class="must">*</span></label><br>
				<form:input path="category" id="category" cssClass="blank" placeholder="업종을 입력해주세요."/><br>
				<form:errors path="category" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="sectionId" class="label">상권 id<span class="must">*</span></label><br>
					<form:select path="sectionId" name="sectionId" id="sectionId" cssClass="sectionId" size="1">
						<option value="1" selected>서현</option>
						<option value="2">이매</option>
						<option value="3">판교</option>
					</form:select>				
			</div>
		
			<div class="element">
				<label for="zipcode" class="label">우편번호</label><br>
				<input id="zipcode_copy" disabled/>
				<form:input type="hidden" path="zipcode" id="zipcode" cssClass="blank"/>
				<button type="button" class="inner_btn" name="zipcode" onclick="getAddress();">우편번호</button>
			</div>	
		
			<div class="element">
				<label for="mainAddress" class="label">주소<span class="must">*</span></label><br>
				<input id="mainAddress_copy" Class="blank" disabled/>		
				<form:input type="hidden" path="mainAddress" id="mainAddress" cssClass="blank"/>
				<button type="button" class="inner_btn" name="mainAddress" onclick="getAddress();">주소검색</button><br>
				<form:errors path="mainAddress" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="subAddress" class="label">상세주소</label><br>
				<form:input path="subAddress" id="subAddress" cssClass="blank"/>
			</div>
			
			<form:input type="hidden" path="coordinates" id="coordinates" cssClass="blank"/>
			
			<div class="element">
					<label for="telephone" class="label">전화번호<span class="must">*</span></label>
				<div id="telephone">
					<select name="head_number" id="head_number" class="select" size="1" onchange="mainTel();">	
						<option selected>02</option>
						<option>032</option>
					</select> - 
					<input type="text" maxlength="4" size="4" class="tel" name="body_number" id="body_number" onchange="mainTel();"> - 
					<input type="text" maxlength="4" size="4" class="tel" name="tail_number" id="tail_number" onchange="mainTel();">
					<form:input type="hidden" path="mainTelephone" id="mainTelephone" value=""/><br>
					<form:errors path="mainTelephone" cssClass="error"/>
				</div>
			</div>
		
			<div class="element">
				<label for="sub_telephone" class="label">전화번호2</label>
				<div id="sub_telephone">
					<select name="sub_head_number" id="sub_head_number" class="select" size="1" onchange="subTel();">	
						<option selected>선택</option>
						<option>010</option>
						<option>070</option>
					</select> - 
					<input type="text" maxlength="4" size="4" class="tel" name="sub_body_number" id="sub_body_number" onchange="subTel();"> - 
					<input type="text" maxlength="4" size="4" class="tel" name="sub_tail_number" id="sub_tail_number" onchange="subTel();">
					<form:input type="hidden" path="subTelephone" id="subTelephone" value=""/><br>	
					<form:errors path="subTelephone" cssClass="error"/>
				</div>
			</div>
			
			<div class="element">
				<label for="firstImage" class="label">이미지<span class="must">*</span></label><br>
				<form:input path="file1" type="file" name="file1" id="firstImage" value="" cssClass="file_btn"/>
				<form:errors path="file1" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="secondImage" class="label">이미지2</label><br>
				<form:input path="file2" type="file" name="file2" id="firstImage" value="" cssClass="file_btn"/>
			</div>
			
			<div class="element">
				<label for="url" class="label">업체소개 url</label><br>
				<form:input path="url" id="url" value=""/>
				<form:errors path="url" cssClass="error"/>	
			</div>
		
			<div class="element">
				<label for="tagKeyword" class="label">키워드<span class="must">*</span></label><br>
				<form:input path="tagKeyword" id="tagKeyword" value="" placeholder="' , '로 구분하여 입력해주세요."/>
				<form:errors path="tagKeyword" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="tagMenu" class="label">메뉴<span class="must">*</span></label><br>
				<form:input path="tagMenu" id="tagMenu" value="" placeholder="' , '로 구분하여 입력해주세요."/>
				<form:errors path="tagMenu" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="tagService" class="label">편의기능</label><br>
				<form:input path="tagService" id="tagService" value="" placeholder="' , '로 구분하여 입력해주세요."/>
				<form:errors path="tagService" cssClass="error"/>
			</div>
		
			<div class="element">
				<label for="open" class="label">영업 중인가요?<span class="must">*</span></label><br>
				<form:radiobutton path="open" name="open" value="Y" id="open" class="radio" checked="checked"/><span class="radio">Yes</span>
 				<form:radiobutton path="open" name="open" value="N" id="open" class="radio"/><span class="radio">No</span>
			</div>
		</fieldset>
		
		<div class="btn_group">
			<button type="button" class="btn" id="upload" value="등록하기" onclick="check();"><strong>등록하기 </strong></button>
			<button class="btn" type="button" id="cancel" onclick="window.location = '/';" value="취소"><strong>취소</strong></button>
		</div>
	</form:form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="../../js/storeJoin.js"></script>
</body>
</html>