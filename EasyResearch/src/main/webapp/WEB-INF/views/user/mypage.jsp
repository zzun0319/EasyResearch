<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

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
	
	<c:if test="${!user.emailVerification}"> <!-- 메일 인증 안 받은 상태 -->
		<h3><a href="/user/sendAuthenticationMail?userId=${user.userId}"> 인증 메일 발송하기 </a></h3>
	</c:if>
	<br><br><br>
	<c:if test="${user.emailVerification}"> <!-- 메일 인증 받은 상태 -->
		<c:if test="${user.participationRight}">
			<input type="button" value="수강 중인 과목 체크하기" onclick="location.href='/research/studentAddClass?studentId=${user.userId}'"><br><br>
			<input type="button" value="나의 연구 참여 신청 현황" onclick="location.href='/research/showMyApply?studentId=${user.userId}'"><br>
		<br><br>
		</c:if>
		<c:if test="${user.setupRight}">
			<input type="button" value="내 연구 보기" onclick="location.href='/research/showMyResearch?userId=${user.userId}'"><br><br>
			<input type="button" value="예약 중인 장소 보기" onclick="location.href='#'"><br>
		<br><br>
		</c:if>
		<c:if test="${user.classRegiRight}">
			<input type="button" value="연구 참여 중인 과목 보기" onclick="location.href='/research/showMyClasses?instructorId=${user.userId}'"><br>
		<br><br>
		</c:if>
		<c:if test="${user.permissionRight}">
			<input type="button" value="개설 연구 승인하기" onclick="location.href='/research/acceptResearch?major=${user.major}'"><br>
		<br><br>
		</c:if>
	
		<input type="button" value="회원정보 수정" onclick="location.href='/user/updateUserInfo'"><br><br>
		<input type="button" value="비밀번호 수정" onclick="location.href='/user/updatePw_current'"><br>
		<br><br><br>
	</c:if>
	
	
	<jsp:include page="../include/footer.jsp" />
</body>
</html>

<script>
	const result = "${msg}"
	if(result != "" && result.length > 0){
		alert(result);
	}


</script>