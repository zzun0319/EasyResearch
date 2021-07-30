<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>

<!-- Core theme CSS (includes Bootstrap)-->
<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>

</head>
<body>
	<c:if test="${user == null}">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	<p> 회원 정보 수정 페이지 </p>
	<form method="post">
		<input type="hidden" name="userId" value="${user.userId}">
		<table>
			<tr>
				<td>연구 안내 등을 받을 메일</td>
				<td><input name="email" value="${user.email}"></td>
			</tr>
			<tr>
				<td>연락받을 휴대폰 번호</td>
				<td><input name="tel" value="${user.tel}"></td>
			</tr>
		</table>
		<input type="submit" value="회원 정보 수정">
	</form>
		<br>
		<br>
		<br>
		 <button id="delete" onclick="location.href='/user/deleteUser'">탈퇴하기</button>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>
