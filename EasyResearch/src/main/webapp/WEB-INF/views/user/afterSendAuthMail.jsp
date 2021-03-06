<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증메일발송</title>

<link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="/js/jquery-3.5.1.js"></script>

</head>
<body>
	<c:if test="${user == null}">
		<script>
			alert("로그인이 필요한 서비스입니다.");
			location.href="/user/login";
		</script>
	</c:if>
	
	<jsp:include page="../include/header.jsp" />
	<div class="container">
	<br>
	<br>
	<br>
	<br>
	<br>
		<h3> 인증 메일이 발송되었습니다. 회원 가입 시 사용한 학교 이메일에서 확인해주세요. </h3>
		<h4> 메일이 안 보인다면 스팸메일함도 확인해주세요. 발송자 메일은 aer38783@gmail.com입니다. </h4>
	<br>	
	<br>	
	<br>	
	<br>	
	<br>	
	<br>	
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