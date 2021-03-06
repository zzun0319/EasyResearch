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
	<p> 
	<h3>회원 정보 수정 페이지</h3><br>
	학교 이메일보다 자주 사용하는 이메일로 수정하시면 관련 정보를 더 자주 체크할 수 있습니다. 
	</p>
	<form method="post" name="update_form">
		<input type="hidden" name="userId" value="${user.userId}">
		<table>
			<tr>
				<td>연구 안내 등을 받을 메일</td>
				<td><input name="email" id="email" value="${user.email}"><input type="button" id="emailCheckBtn" value="이메일 중복체크" disabled></td>
			</tr>
			<tr>
				<td colspan="2">
					<div><span id="emailCheck"></span></div>
				</td>
			</tr>
			<tr>
				<td>연락받을 휴대폰 번호</td>
				<td><input name="tel" id="tel" value="${user.tel}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div><span id="telCheck"></span></div>
				</td>
			</tr>
		</table>
		<input type="button" id="updateBtn" value="회원 정보 수정">
	</form>
		<br>
		<br>
		<br>
		 <button id="delete" onclick="location.href='/user/deleteUser'">탈퇴하기</button>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>

<script type="text/javascript">

	$(function() {
		
		const emailCheckBtn = document.getElementById('emailCheckBtn');
		
		const getEmailCheck = RegExp(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,22})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/); // 이메일 형식만 가능
		
		const getTelCheck = RegExp(/^[0-9]{11}$/); // 00000000000 형태만 가능
		
		let chk1 = false, chk2 = false;
		
		$("#email").keyup(function() { // 이메일 검사
			if($("#email").val() === ""){
				$("#email").css("background-color", "pink");
				$("#emailCheck").html("<b style='font-size: 14px; color: red;'> 수정할 이메일을 입력하세요.</b>");
				emailCheckBtn.disabled = true;
				chk1 = false;
			}
			else if(!getEmailCheck.test($("#email").val())){
				$("#email").css("background-color", "pink");
				$("#emailCheck").html("<b style='font-size: 14px; color: red;'> 전체 30글자 내의 이메일 형식으로 입력하세요.</b>");
				emailCheckBtn.disabled = true;
				chk1 = false;
			}
			else{
				$("#email").css("background-color", "white");
				$("#emailCheck").html("<b style='font-size: 14px; color: green;'> 조건을 만족합니다. 중복 체크를 완료하세요.</b>");
				emailCheckBtn.disabled = false;
				$("#emailCheckBtn").click(function() { // 이메일 중복 확인
					
					$.ajax({
						
						type:"POST",
						url:"/user/checkEmail",
						data: {
							emailModified : $("#email").val()
						},
						success: function(result) {
							console.log("통신성공!: " + result);
							if(result === "OK"){
								$("#email").css("background-color", "skyblue");
								$("#emailCheck").html("<b style='font-size: 14px; color: green;'> 사용가능한 이메일입니다.</b>");
								chk1 = true;
							}
							else{
								$("#email").css("background-color", "pink");
								$("#emailCheck").html("<b style='font-size: 14px; color: red;'> 누군가 사용중인 이메일입니다.</b>");
								chk1 = false;
							}
						},
						error: function() {
							console.log("통신 실패!");
						}						
					}); // ajax
					
				})// 이메일 중복 확인
			}
		}) // 이메일 검사
		
		$("#tel").keyup(function() { // 휴대폰 번호 입력값 검증 + 인증번호 보내고 인증하는거 추가해보기
			if($("#tel").val() === ""){
				$("#tel").css("background-color", "pink");
				$("#telCheck").html("<b style='font-size: 14px; color: red;'> 수정할 휴대폰 번호를 입력해주세요.</b>");
				chk2 = false;
			} 
			else if(!getTelCheck.test($("#tel").val())){
				$("#tel").css("background-color", "pink");
				$("#telCheck").html("<b style='font-size: 14px; color: red;'>11자리의 숫자만 입력해주세요.</b>");
				chk2 = false;
			}
			else {
				$("#tel").css("background-color", "skyblue");
				$("#telCheck").html("<b style='font-size: 14px; color: green;'>조건 만족.</b>");
				chk2 = true;
			}
		})// 휴대폰 번호 입력값 검증
		
		$("#updateBtn").click(function() {
			if(!chk1){
				console.log("이메일 입력 문제");
				alert("이메일 입력란에 문제가 있습니다.");
				update_form.email.focus();
				return;
			}
			else if(!chk2){
				console.log("휴대폰 번호 입력 문제");
				alert("휴대폰 번호 입력란에 문제가 있습니다.");
				update_form.tel.focus();
				return;
			}
			else{
				if(confirm("수정 하시겠습니까?")){ // 확인 누르면
					console.log("회원 정보 수정");
					update_form.submit();
				} else { // 취소 누르면
					console.log("회원 정보 수정 취소");
					return;
				}
			}
		})
		
		
	})

</script>
