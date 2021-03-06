<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학 구성원 인증 페이지</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>

</head>
<body>

	<jsp:include page="../include/header.jsp" />
	
	<div class="container">
		<p>
		<h2>회원가입을 환영합니다.</h2>
		</p>
		<p>
		<form method="post">
			<table>
				<tr>
					<td>회원분류</td>
					<td>
						<select name="sort">
							<option>=== 선택 === </option>
							<option value="학부생">학부생</option>
							<option value="석사과정대학원생">석사과정대학원생</option>
							<option value="박사과정대학원생">박사과정대학원생</option>
							<option value="강사">강사</option>
							<option value="교수">교수</option>
							<option value="지도교수">지도교수</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>학번/교번 입력</td>
					<td><input name="idNumber"></td>
				</tr>
				<tr>
					<td>학교에 등록된 이름 입력</td>
					<td><input name="registeredName"></td>
				</tr>
				<tr>
					<td>학교 이메일 입력</td>
					<td><input name="univEmail"></td>
				</tr>
				<tr>
					<td rowspan="2">
						<input type="submit" value="다음">
					</td>
				</tr>
			</table>
		</form>
		</p>
		
		
	</div>

	<jsp:include page="../include/footer.jsp" />

</body>
</html>


<script>
	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}
</script>