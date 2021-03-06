<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 페이지</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>

<style type="text/css">
#rightColumn{
	width: 90%;
}
</style>

</head>
<body>

	<jsp:include page="../include/header.jsp" />
	
	<div class="container">
		<p>
		<h2>회원가입 정보를 입력해주세요.</h2>
		</p>
		<p>
		<form method="post" name="reg_form" action="/user/register_otherInfo">
			<table>
				<tr>
					<td>회원분류</td>
					<td id="rightColumn">
						<input value="${umvo.sort}" disabled>
						<input type="hidden" name="userType" value="${umvo.sort}">
					</td>
				</tr>
				<tr>
					<td>학번 / 교번</td>
					<td id="rightColumn">
						<input style="width:60%;" value="${umvo.idNumber}" disabled>
						<input type="hidden" name="univIdNum" value="${umvo.idNumber}">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td id="rightColumn">
						<input style="width:60%;" value="${umvo.registeredName}" disabled>
						<input type="hidden" name="userName" value="${umvo.registeredName}">
					</td>
				</tr>
				<tr>
					<td>학교 이메일</td>
					<td id="rightColumn">
						<input style="width:60%;" value="${umvo.univEmail}" disabled>
						<input type="hidden" name="email" value="${umvo.univEmail}">
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td id="rightColumn">
						<input style="width:60%;" type="text" name="userId" id="user_id" placeholder="아이디를 6자 ~ 14자의 영문대소문자와 숫자로 입력하세요."> &nbsp; &nbsp;
						<input type="button" id="idCheck" value="아이디 중복체크" disabled>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div><span id="idChk"></span></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td id="rightColumn">
						<input style="width:60%;"  type="password" name="userPw" id="user_pw" placeholder="비밀번호를 입력하세요. 8자 ~ 20자, 영문, 숫자, 특수문자 조합">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div><span id="pwChk"></span></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td id="rightColumn">
						<input style="width:60%;" type="password" id="pw_again" placeholder="위의 비밀번호와 똑같이 입력해주세요.">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div><span id="pwAgainChk"></span></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div><span id="idNumChk"></span></div>
					</td>
				</tr>
				<c:if test="${umvo.sort!='강사'}">
					<tr>
						<td>전공</td>
						<td id="rightColumn">
							<input style="width:60%;" value="${umvo.major}" disabled>
							<input type="hidden" name="major" value="${umvo.major}">
						</td>
					</tr>
				</c:if>
				<tr>
					<td>휴대폰 번호</td>
					<td id="rightColumn">
						<input style="width:60%;" type="text" name="tel" id="user_phoneNum" placeholder=" - 없이 숫자만 입력해주세요."> &nbsp; &nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div><span id="phoneNumChk"></span></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="finalRegi" value="회원가입">
					</td>
				</tr>
			</table>
		</form>
		</p>
		
		
	</div>

	<jsp:include page="../include/footer.jsp" />

</body>
</html>

<script type="text/javascript">

	$(function() { // 검증 함수 시작
		
		const getIdCheck = RegExp(/^[a-zA-z0-9]{6,14}$/); // 따옴표(/), 적용 시작(^), 적용 끝($), [허용되는 것: 영문 대소문자 & 숫자, 띄어쓰기 불가능]{최소, 최대}
		
		const getPwCheck = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,_,~])|([!,@,#,$,%,^,&,*,_,~].*[a-zA-Z0-9]){8,20}/); // a.(a로 시작하는 것들) .n(n으로 끝나는 것들) / *(반복가능), 
		// 영문 대소문자 & 숫자 포함한 걸로 시작(.), 반복 가능(*), 특수문자 포함해야함.
		
		const getPhoneNumCheck = RegExp(/^[0-9]{11}$/); // 00000000000 형태만 가능
		
		let chk1 = false, chk2 = false, chk3 = false;
		// chk1: 아이디 체크, chk2: 비밀번호 체크, chk3: 휴대폰 번호 체크
		
		const idCheckBtn = document.getElementById('idCheck');
		
		$("#user_id").keyup(function() { // ID 입력값 검증
			if($("#user_id").val() === ""){
				$("#user_id").css("background-color","pink");
				$("#idChk").html("<b style='font-size: 14px; color: red;'>아이디는 필수 정보입니다.</b>");
				idCheckBtn.disabled = true;
				chk1 = false;
			}
			else if(!getIdCheck.test($("#user_id").val())){
				$("#user_id").css("background-color","pink");
				$("#idChk").html("<b style='font-size: 14px; color: red;'>아이디는 6 ~ 14자의 영문대소문자와 숫자로만 이뤄져야하고 공백이 없어야 합니다.</b>");
				idCheckBtn.disabled = true;
				chk1 = false;
			} else {
				$("#user_id").css("background-color","white");
				$("#idChk").html("<b style='font-size: 14px; color: green;'>조건 만족. 중복 체크를 완료하세요 :) </b>");
				idCheckBtn.disabled = false;
				$("#idCheck").click(function() { // id 중복확인
					
					$.ajax({ 
						type: "POST",
						url: "/user/checkId",
						data: {
							id : $("#user_id").val()
						},
						success: function(result) {
							console.log("통신 성공!: " + result);
							if(result === "OK"){
								$("#user_id").css("background-color", "skyblue");
								$("#idChk").html("<b style='font-size: 14px; color: green;'>사용 가능한 아이디입니다.</b>");
								chk1 = true;
							}
							else {
								$("#user_id").css("background-color", "pink");
								$("#idChk").html("<b style='font-size: 14px; color: red;'>이미 사용중인 아이디입니다.</b>");
								chk1 = false;
							}
						},
						error: function() {
							console.log("통신 실패!");
						}
						
					}); // ajax
				})// id 중복확인
				
			} // else
		}) // ID 입력값 검증
		
		////////////////////////////////////////////////////////
		
		$("#user_pw").keyup(function() { // 비밀번호 입력값 검증
			
			if($("#user_pw").val() === ""){
				$("#user_pw").css("background-color", "pink");
				$("#pwChk").html("<b style='font-size: 14px; color: red;'>비밀번호는 필수 입력사항입니다.</b>");
				chk2 = false;
			} 
			else if(!getPwCheck.test($("#user_pw").val())){
				$("#user_pw").css("background-color","pink");
				$("#pwChk").html("<b style='font-size: 14px; color: red;'>비밀번호는 8 ~ 20자의 영문대소문자와 특수문자의 조합이 필수입니다.</b>");
				chk2 = false;
			}
			else {
				$("#user_pw").css("background-color","white");
				$("#pwChk").html("<b style='font-size: 14px; color: green;'>조건 만족. 아래에 비밀번호를 한 번 더 입력해주세요 :) </b>");
				
				$("#pw_again").keyup(function() { // 비밀번호 확인란
					if($("#pw_again").val() === ""){
						$("#pw_again").css("background-color", "pink");
						$("#pwAgainChk").html("<b style='font-size: 14px; color: red;'>비밀번호 재입력은 필수 입력사항입니다.</b>");
						chk2 = false;
					} 
					else if($("#pw_again").val() != $("#user_pw").val()){
						$("#pw_again").css("background-color", "pink");
						$("#pwAgainChk").html("<b style='font-size: 14px; color: red;'>위의 비밀번호와 불일치합니다.</b>");
						chk2 = false;
					}
					else{
						$("#user_pw").css("background-color", "skyblue");
						$("#pw_again").css("background-color", "skyblue");
						$("#pwAgainChk").html("<b style='font-size: 14px; color: green;'>비밀번호 확인 완료.</b>");
						chk2 = true;
					}
				})// 비밀번호 확인란
				
			}
				
				
		})// 비밀번호 입력값 검증
		
		//////////////////////////////////////////
		
		$("#user_phoneNum").keyup(function() { // 휴대폰 번호 입력값 검증 + 인증번호 보내고 인증하는거 추가해보기
			if($("#user_phoneNum").val() === ""){
				$("#user_phoneNum").css("background-color", "pink");
				$("#phoneNumChk").html("<b style='font-size: 14px; color: red;'>휴대폰 번호는 필수 입력 값입니다.</b>");
				chk3 = false;
			} 
			else if(!getPhoneNumCheck.test($("#user_phoneNum").val())){
				$("#user_phoneNum").css("background-color", "pink");
				$("#phoneNumChk").html("<b style='font-size: 14px; color: red;'>11자리의 숫자만 입력해주세요.</b>");
				chk3 = false;
			}
			else {
				$("#user_phoneNum").css("background-color", "skyblue");
				$("#phoneNumChk").html("<b style='font-size: 14px; color: green;'>조건 만족.</b>");
				chk3 = true;
			}
		})// 휴대폰 번호 입력값 검증
		
		$("#finalRegi").click(function() {
			if(!chk1){
				console.log("id문제");
				alert("아이디 입력란에 문제가 있습니다.");
				reg_form.userId.focus();
				return;
			}
			else if(!chk2){
				console.log("pw문제");
				alert("비밀번호나 비밀번호 확인란에 문제가 있습니다.");
				reg_form.userPw.focus();
				return;
			}
			else if(!chk3){
				console.log("phone문제");
				alert("휴대폰 번호 입력란에 문제가 있습니다.");
				reg_form.tel.focus();
				return;
			}
			else{
				if(confirm("회원가입 하시겠습니까?")){ // 확인 누르면
					console.log("회원 가입 승인");
					reg_form.submit();
				} else { // 취소 누르면
					console.log("회원 가입 취소");
					return;
				}
			}
		})
		
	}) // 검증 함수 끝
	
</script>
