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
	<c:if test="${!user.setupRight}">
		<script>
			alert("접근 권한이 없습니다.");
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
	 	<h5>${selectedResearch.researcher.userId}</h5>
	 <c:if test="${(user.userId == selectedResearch.researcher.userId) || user.permissionRight}">
	 	<c:if test="${selectedResearch.uploadFileName != null}">
	 - 첨부파일: <a href="/research/download/${selectedResearch.researchId}">${selectedResearch.uploadFileName}</a> <br>
	 	</c:if>
	 </c:if>
	 <br><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back(-1)"> 뒤로 가기 </a>
	 
	<jsp:include page="../include/footer.jsp" />

</body>
</html>