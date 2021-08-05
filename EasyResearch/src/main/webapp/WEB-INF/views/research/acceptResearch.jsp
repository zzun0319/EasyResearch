<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연구개설 페이지</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>

<style type="text/css">
#rightColumn{
	width: 100%;
}

</style>

</head>
<body>

	<c:if test="${user == null}">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>
	<c:if test="${!user.permissionRight}">
		<script>
			alert("해당 페이지 접근 권한이 없습니다.");
			location.href="/user/mypage";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	
		<h2> [개설 연구 승인하기] </h2>
		<p>
			<form method="post" action="/research/changePermission">
				<table border="1">
					<tr>
						<td>연구 제목</td>
						<td>연구자 id</td>
						<td>승인 상태</td>
					</tr>
					<c:forEach var="research" items="${registedResearchList}" varStatus="status">
						<input type="hidden" name="researchId" value="${research.researchId}">
						<tr>
							<td><a href="/research/showOneResearch?researchId=${research.researchId}">${research.title}</a></td>
							<td>${research.researcher.userName}</td>
							<td>${research.permission ? '승인' : '승인대기'}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="저장">
			</form>
		</p>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>