<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 개설한 연구보기</title>

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
			location.href="/user/mypage";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	
		<p><h2>나의 연구들</h2></p>
		<p>
			<c:if test="${myResearchList.size() == 0}">
				개설 신청한 연구가 없습니다.
			</c:if>
			<c:if test="${myResearchList.size() > 0}">
			<table border="1">
				<tr>
					<td><b>연구제목</b></td>
					<td><b>상태</b></td>
					<td><b>스케줄 보기</b></td>
				</tr>
				<c:forEach var="research" items="${myResearchList}">
					<tr>
						<td><a href="/research/showOneResearch?researchId=${research.researchId}">${research.title}</a></td>
						<td>${research.permission ? "승인 완료" : "승인 대기중"}</td>
						<td><a href="/research/makeTimeSlot?researchId=${research.researchId}">${research.permission ? "스케줄 보기" : ""}</a></td>
					</tr>
				</c:forEach>
			</table>
			</c:if>
		</p>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>