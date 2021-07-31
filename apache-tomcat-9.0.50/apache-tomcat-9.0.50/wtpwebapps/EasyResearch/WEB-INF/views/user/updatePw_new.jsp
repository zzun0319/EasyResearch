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
	<c:if test="${confirm != 'OK'}">
		<script>
			alert("잘못된 경로로 접근하셨습니다.");
			location.href="/user/mypage";
		</script>
	</c:if>


	<jsp:include page="../include/header.jsp" />
	
	<form method="post" name="pw_change_form">
		<input type="hidden" name="userId" value="${user.userId}">
		<table>
			<tr>
				<td>새 비밀번호</td>
				<td><input type="password" name="userPw" id="newPw"></td>
			</tr>
			<tr>
				<td>
					<div><span id="newPwMsg"></span></div>
				</td>
			</tr>
			<tr>
				<td>새 비밀번호 확인</td>
				<td><input type="password" id="newPwCheck"></td>
			</tr>
			<tr>
				<td>
					<div><span id="newPwCheckMsg"></span></div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<br><br><input type="button" value="비밀번호 변경" id="changePWBtn" disabled>
				</td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="../include/footer.jsp" />
</body>
</html>

<script type="text/javascript">

	$(function() {

		const getPwCheck = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,_,~])|([!,@,#,$,%,^,&,*,_,~].*[a-zA-Z0-9]){8,20}/);
		
		const pwChangeBtn = document.getElementById('changePWBtn');
	
		$("#newPw").keyup(function() { // 새 비밀번호 입력칸 검증
			if($("#newPw").val() === ""){
				$("#newPw").css("background-color","pink");
				$("#newPwMsg").html("<b style='font-size: 14px; color: red;'>빈칸으로 남겨둘 수 없습니다.</b>");
				pwChangeBtn.disabled = true;
			}
			else if(!getPwCheck.test($("#newPw").val())){
				$("#newPw").css("background-color","pink");
				$("#newPwMsg").html("<b style='font-size: 14px; color: red;'>비밀번호는 8 ~ 20자의 영문대소문자와 특수문자의 조합이 필수입니다.</b>");
				pwChangeBtn.disabled = true;
			}
			else {
				$("#newPw").css("background-color","white");
				$("#newPwMsg").html("<b style='font-size: 14px; color: green;'>조건 만족. 아래에 비밀번호를 한 번 더 입력해주세요 :) </b>");
				
				$("#newPwCheck").keyup(function() { // 비밀번호 확인란
					if($("#newPwCheck").val() === ""){
						$("#newPwCheck").css("background-color", "pink");
						$("#newPwCheckMsg").html("<b style='font-size: 14px; color: red;'>비밀번호 재입력은 필수 입력사항입니다.</b>");
						pwChangeBtn.disabled = true;
					} 
					else if($("#newPwCheck").val() != $("#newPw").val()){
						$("#newPwCheck").css("background-color", "pink");
						$("#newPwCheckMsg").html("<b style='font-size: 14px; color: red;'>위의 비밀번호와 불일치합니다.</b>");
						pwChangeBtn.disabled = true;
					}
					else{
						$("#newPw").css("background-color", "skyblue");
						$("#newPwCheck").css("background-color", "skyblue");
						$("#newPwCheckMsg").html("<b style='font-size: 14px; color: green;'>비밀번호 확인 완료.</b>");
						pwChangeBtn.disabled = false;
					}
				})// 비밀번호 확인란
			} // else	
		})// 새 비밀번호 입력칸 검증
		
		$("#changePWBtn").click(function() {
			if(confirm("비밀번호를 변경하시겠습니까?")){
				pw_change_form.submit();
			}else{
				return;
			}
		})
		
	})

</script>