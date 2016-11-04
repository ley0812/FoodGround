<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/home.css">
<title>FoodGround</title>
</head>
<body>
	<div class="top_container">
	<header>
		<h2 onclick="home();">FOOOD GROUND</h2>
	</header>
	<div class="btn_group">
		<form action="/members/join" method="GET" class="form">
			<button type="submit" class="btn" id="join_btn" value="회원가입">
				<strong>회원가입</strong>
			</button>
		</form>
		<form action="/login" method="GET" class="form">
		<button type="submit" class="btn" id="login_btn" value="로그인">
			<strong>로그인</strong>
		</button>
		</form>
		<form action="/logout" method="GET" class="form">
			<button type="submit" class="btn" id="logout_btn" value="로그아웃" onclick="delete_cookie();">
			<strong>로그아웃</strong>
		</button>
		</form>
	</div>
	<div class="search_group">	
		<input type="text" id="keyword" name="keyword" class="search_blank">
		<button type="button" id="search_impl" class="search_btn" onclick="search();">검색</button><br>
	</div>	
	<table class="tags">
		<tbody>
			<tr>
			<c:forEach var="tag" end="11" items="${tags}" varStatus="status">
				<c:if test="${status.index%4==0}">
				</tr><tr>
				</c:if>
				<td onclick="tag_click('${tag.key}')">${tag.key}(${tag.value})</td>
			</c:forEach>
			</tr>
		</tbody>
	</table>
	</div>
	
	<c:forEach var="store" items="${stores}">
	<div id=container class="container" onclick="show_detail(${store.id});">
		<div id="content" class="content">
			<img src="/${store.firstImage}"/>
			<div class="parent_div">
			<div class="left_div">
				<div class="names">
					<c:set var="open" value="${store.open}" />
					<c:choose>
  					    <c:when test="${open eq 'N'.charAt(0)}">
							<h3><c:out value="(폐업)${store.name}"/></h3><br>
  					   	</c:when>
    					<c:otherwise>
							<h3><c:out value="${store.name}"/></h3><br>
    					</c:otherwise>
					</c:choose>
				<span id="tag_menu" class="tag"><c:out value="${store.tagMenu}"/></span>
				</div>
				<div id="favorite_div" class="favorite_div" style="width:610px; padding-top: 60px;">
					<c:set var="toggle" value="${store.toggle}" />
					<c:choose>
						<c:when test="${toggle eq ''}">
							<img src="../../img/dontlike.png" id="like" onclick="favorite(event, ${store.id}, 'N');"/>
  					   	</c:when>
  					     	<c:when test="${toggle eq 'N'.charAt(0)}">
							<img src="../../img/dontlike.png" id="like" onclick="favorite(event, ${store.id}, '${store.toggle}');"/>
  					   	</c:when>
    					<c:otherwise>
							<img src="../../img/like.png" id="like" onclick="favorite(event, ${store.id}, '${store.toggle}');"/>
    					</c:otherwise>
					</c:choose>		
					<span id="favorite_tag" class="tag" style="float: right; padding-top: 10px; padding-right: 40px" onclick="favorite(event, ${store.id}, '${store.toggle}');">좋아요</span>
				</div>
				<div id="recommend_div" class="recommend_div" style="width:400px;">
					<span id="score" class="tag" style=" padding-left: 12px; font-size:40px; color: rgba(255, 104, 39, 0.9);">80</span>
					<span id="recommend_tag" class="tag" style="width=30px;">점</span>
				</div>
			</div>	
			<div class="right_div">
				<div id="keyword_div" class="keyword_div">
					<span id="tag_keyword" class="tag"><c:out value="${store.tagKeyword}"/></span>
					<img src="../../img/key.png" style="width:25px; height:25px;">
				</div>
				<div id="address_div" class="address_div">
					<span id="address_tag" class="tag"><c:out value="${store.mainAddress}"/></span>
					<img src="../../img/marker.png" style="width:25px; height:25px;">
				</div>
				<div id="telephone_div" class="telephone_div">
					<span id="telephone_tag" class="tag"><c:out value="${store.mainTelephone}"/></span>
					<img src="../../img/phone.png" style="width:25px; height:25px;">
				</div>
				<div id="closed_div" class="closed_div">
					<c:set var="open" value="${store.open}" />
					<c:choose>
  						<c:when test="${open eq 'N'.charAt(0)}">
							<span id="closed_tag" class="tag" onclick="closed_store(event, ${store.id}, ${store.sectionId}, '${store.name}', '${store.open}')">영업신고</span>
  						</c:when>
    					<c:otherwise>
							<span id="closed_tag" class="tag" onclick="closed_store(event, ${store.id}, ${store.sectionId}, '${store.name}', '${store.open}')">폐업신고</span>
    					</c:otherwise>
					</c:choose>		
					<img src="../../img/closed.png" style="width:25px; height:25px;">
				</div>
			</div>
			</div>
		</div>
	</div>
	</c:forEach>
	
	<form action="/stores/save" method="GET" class="form">
		<button type="submit" class="store_save_btn" id="store_save_btn" value="업체등록">
			<strong>업체등록</strong>
		</button>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>	
	<script src="../../js/jquery.cookie.js"></script>	
	<script src="../../js/home.js"></script>
</body>
</html>