<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연구 상세보기</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jQuery.form.min.js" />"></script>

<style type="text/css">
#rightColumn{width: 80%;}

*{padding:0; margin:0}

textarea{width: 100%; height: 100px;}

td{width:40%;}

</style>

</head>
<body>

	<c:if test="${user == null}">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" /> <!-- 연구자, 학부생은 상세보기 창이 달라야하네.. -->
	<h2>${selectedResearch.title}</h2>
	 - 연구 종류: ${selectedResearch.researchType} <br>
	 - 연구 목적: ${selectedResearch.purpose} <br>
	 - 연구 방법: ${selectedResearch.method} <br>
	 - 소요 시간: ${selectedResearch.duration} <br>
	 - 보상 종류: ${selectedResearch.rewardType} <br>
	 - 보상: ${selectedResearch.rewardValue} ${selectedResearch.rewardType == "학점" ?  "점" : selectedResearch.rewardType == "참가비" ? "원" : "개"}<br>
	 	<br>
	 	
	 <c:if test="${(user.userId == selectedResearch.researcher.userId) || user.permissionRight}">
	 	<c:if test="${selectedResearch.uploadFileName != null}">
	 - 첨부파일: <a href="/research/download/${selectedResearch.researchId}">${selectedResearch.uploadFileName}</a> <br><br>
	 	</c:if>
	 </c:if>
	 
	 <c:if test="${user.permissionRight}">
	 		<form action="/research/permitResearch" method="post">
	 			<input type="hidden" name="researchId" value="${selectedResearch.researchId}">
	 			<input type="hidden" name="major" value="${user.major}">
	 			<input type="hidden" name="userType" value="${user.userType}">
	 			<input type="hidden" name="researcher.userId" value="${user.userId}">
	 			<textarea name="content" placeholder="피드백을 입력하세요." style="width:60%;"></textarea> <br>
	 			<input type="radio" name="permission" value=true ${selectedResearch.permission ? 'checked' : ''}> 승인 <br>
	 			<input type="radio" name="permission" value=false ${!selectedResearch.permission ? 'checked' : ''}> 승인 대기 <br>
	 			<input type="submit" value="저장">
	 		</form>
	 </c:if>
	 <c:if test="${user.userId == selectedResearch.researcher.userId}">
	 		<form action="/research/permitResearch" method="post"><!-- 이거 받는 부분도 페이징해서 넘겨야해.. -->
	 			<input type="hidden" name="researchId" value="${selectedResearch.researchId}">
	 			<input type="hidden" name="major" value="${user.major}">
	 			<input type="hidden" name="userType" value="${user.userType}">
	 			<input type="hidden" name="researcher.userId" value="${user.userId}">
	 			<textarea name="content" placeholder="댓글을 입력하세요." style="width:60%;"></textarea> <br>
	 			<input type="submit" value="저장">
	 		</form>
	 </c:if>
	 
	 <c:if test="${(user.userId == selectedResearch.researcher.userId) || user.permissionRight}">
		 <c:if test="${comments.size() > 0 && comments != null}">
		 	<table border="1">
		 	<tr>
		 		<td>작성자</td>
		 		<td>내용</td>
		 		<td>작성일자</td>
		 	</tr>
		 	<c:forEach var="com" items="${comments}">
		 		<tr>
		 			<td>${com.writer.userName}</td>
		 			<td>${com.content}</td> <!-- 새로 작성한 글이라는 이미지 보이게 하기 -->
		 			<td>${com.writeDate}</td> <!-- 포맷 바꾸기 -->
		 		</tr>
		 	</c:forEach>
		 	</table>
		 </c:if>
	 </c:if>
	 
	 <br><br>
	 	<c:choose>
	 		<c:when test="${user.userType == '지도교수'}">
	 		&nbsp;&nbsp;&nbsp;&nbsp;<a href="/research/acceptResearch?pageNum=${msvo.pageNum}&cntPerPage=${msvo.cntPerPage}&condition=${msvo.condition}&keyword=${msvo.keyword}&major=${msvo.major}"> 뒤로 가기 </a> <br><br><br>
	 		</c:when>
	 		<c:otherwise>
	 		&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back(-1)"> 뒤로 가기 </a> <br><br><br>
	 		</c:otherwise>
	 	</c:choose>
	<jsp:include page="../include/footer.jsp" />

</body>
</html>


