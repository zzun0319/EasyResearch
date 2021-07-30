<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

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
	<p> 회원 탈퇴 페이지 </p>
	<form method="post">
		<input type="hidden" name="userId" value="${user.userId}">
		<table>
			<tr>
				<td>비밀번호를 입력하세요.</td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
			<td colspan="2">
				<button type="submit">탈퇴하기</button>
			</td>
			</tr>
		</table>
	</form>
		<br>
		<br>
		<br>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>
