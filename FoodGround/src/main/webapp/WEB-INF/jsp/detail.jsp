<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/detail.css">
<title>FoodGround</title>
</head>
<body>
	<header>
		<h2>업체상세</h2>
	</header>	
	<body>
		<div class="img_div">
			<img src="/${store.firstImage}" class="img"/>
		</div>	
		
		<div class="content_div">
			<img src="../../img/edit.png" onclick="edit_name();" class="edit_mark">
			<img src="../../img/name-big.png" class="edit_logo" style="padding-bottom: 30px;">
			<c:set var="open" value="${store.open}" />
			<c:choose>
  				<c:when test="${open eq 'N'.charAt(0)}">
					<textarea rows="1" cols="30" name="name" class="name" id="name" readonly><c:out value="(폐업)${store.name}"/></textarea>		
  				</c:when>
    			<c:otherwise>
					<textarea rows="1" cols="30" name="name" class="name" id="name" readonly><c:out value="${store.name}"/></textarea>		
    			</c:otherwise>
			</c:choose>	
			<button type="button" class="edit_btn" id="name_edit_btn" onclick="edit_proc(this, ${store.id});" value="store_name">
			<strong>수정</strong>
			</button>
		<br>
			<img src="../../img/edit.png" onclick="edit_menu();" class="edit_mark">
			<img src="../../img/menu-big.png" class="edit_logo">
			<textarea rows="1" cols="30" name="tag_menu" class="tag_menu" id="tag_menu" readonly><c:out value="${store.tagMenu}"/></textarea>	
			<button type="button" class="edit_btn" id="menu_edit_btn" onclick="edit_proc(this, ${store.id});" value="tag_menu">
			<strong>수정</strong>
			</button>
		<br>
			<img src="../../img/edit.png" onclick="edit_keyword();" class="edit_mark">
			<img src="../../img/keyword-big.png" class="edit_logo">
			<textarea rows="1" cols="30" name="tag_keyword" class="tag_keyword" id="tag_keyword" readonly><c:out value="${store.tagKeyword}"/></textarea>	
			<button type="button" class="edit_btn" id="keyword_edit_btn" onclick="edit_proc(this, ${store.id});" value="tag_keyword">
			<strong>수정</strong>
			</button>
		<br>
			<img src="../../img/edit.png" onclick="edit_service();" class="edit_mark">
			<img src="../../img/service-big.png" class="edit_logo">
			<textarea rows="1" cols="30" name="tag_service" class="tag_service" id="tag_service" readonly><c:out value="${store.tagService}"/></textarea>	
			<button type="button" class="edit_btn" id="service_edit_btn" onclick="edit_proc(this, ${store.id});" value="tag_service">
			<strong>수정</strong>
			</button>
		<br>
			<img src="../../img/edit.png" onclick="edit_address();" class="edit_mark">
			<img src="../../img/location-big.png" class="edit_logo">
			<textarea rows="1" cols="30" name="address" class="address" id="address" readonly><c:out value="${store.mainAddress}"/></textarea>	
			<button type="button" class="edit_btn" id="address_edit_btn" onclick="edit_proc(this, ${store.id});" value="address1">
			<strong>수정</strong>
			</button>
		<br>
			<img src="../../img/edit.png" onclick="edit_telephone();" class="edit_mark">
			<img src="../../img/tel-big.png" class="edit_logo">
			<textarea rows="1" cols="30" name="telephone" class="telephone" id="telephone" readonly><c:out value="${store.mainTelephone}"/></textarea>	
			<button type="button" class="edit_btn" id="telephone_edit_btn" onclick="edit_proc(this, ${store.id});" value="tel_main">
			<strong>수정</strong>
			</button>
		</div>
		<button type="button" class="back_btn" id="back_btn" value="뒤로가기" onclick="cancel();">
			<strong>뒤로가기</strong>
		</button>
		<div id="button-tool" class="button-tool">
			<div class="like">
			<c:set var="toggle" value="${store.toggle}" />
			<c:choose>
					<c:when test="${toggle eq ''}">
						<img src="../../img/dontlike.png" id="like" onclick="favorite(${store.id}, 'N');"/>
  				   	</c:when>
  				     <c:when test="${toggle eq 'N'.charAt(0)}">
						<img src="../../img/dontlike.png" id="like" onclick="favorite(${store.id}, '${store.toggle}');"/>
  				   	</c:when>
    				<c:otherwise>
						<img src="../../img/like.png" id="like" onclick="favorite(${store.id}, '${store.toggle}');"/>
    				</c:otherwise>
			</c:choose>			
			<span>좋아요</span>
			</div>
			<div id="recommend" class="recommend">
				<img src="../../img/up.png"/>
				<img src="../../img/down.png"/>	
				<span>100점</span>
			</div>
			
			<div id="closed_div" class="closed_div" onclick="closed_store(${store.id}, ${store.sectionId}, '${store.name}', '${store.open}');">
			<c:set var="open" value="${store.open}" />
				<c:choose>
  				    <c:when test="${open eq 'Y'.charAt(0)}">
					<img src="../../img/closed-big.png" id="closed" style="width:100px; height:100px;">
					<span id="closed_tag" class="tag">폐업신고</span>
		  			</c:when>
		  			<c:when test="${open eq 'N'.charAt(0)}">
					<img src="../../img/open.png" id="closed" style="width:100px; height:100px;">
					<span id="closed_tag" class="tag">영업신고</span>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div id="review_div">
			<div>
				<textarea rows="3" cols="37" name="review_box" id="review_box" class="review_box"></textarea>	
				<button type="button" class="review_button" onclick="insert_review(${store.id});">등록</button>
			</div>
			<c:forEach var="review" items="${reviews}">
			<div id="review_list">
				<textarea rows="3" cols="37" name="review_box" id="review_box" class="review_box">${review.contents} by ${review.nickName} ${review.ip}</textarea>	
			</div>
			</c:forEach>
		</div>
	</body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="../../js/jquery.cookie.js"></script>	
	<script src="../../js/detail.js"></script>
</body>
</html>