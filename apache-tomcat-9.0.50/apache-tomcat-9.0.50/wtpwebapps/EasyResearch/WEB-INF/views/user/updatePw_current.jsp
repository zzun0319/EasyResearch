<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>

<!-- Core theme CSS (includes Bootstrap)-->
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
	
	<form method="post">
		<input type="hidden" name="userId" value="${user.userId}">
		<table>
			<tr>
				<td>현재 비밀번호</td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="다음">
				</td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="../include/footer.jsp" />
</body>
</html>

<script>
	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}
</script>