<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연구 개설하기2</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jQuery.form.min.js" />"></script>

<style type="text/css">

#rightColumn{width: 80%;}

*{padding:0; margin:0}

textarea{width: 100%; height: 100px;}

</style>

</head>
<body>

	<c:if test="${user == null}">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>
	<c:if test="${!user.setupRight}">
		<script>
			alert("연구 개설 권한이 없습니다.");
			location.href="/user/login";
		</script>
	</c:if>
	<c:if test="${researchType == null || rewardType == null}">
		<script>
			alert("잘못된 경로로 접근하셨습니다.");
			location.href="/user/mypage";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	
	<div class="wrap">
        <div class="fileBox">
            <form action="/research/openResearch_detail" method="post" enctype="multipart/form-data">
            <input type="hidden" name="researcher.userId" value="${user.userId}">
            <c:if test="${rewardType != '기타'}">
            	<input type="hidden" name="rewardType" value="${rewardType}">
            </c:if>
            <input type="hidden" name="researchType" value="${researchType}">
                <table border="1">
                    <tr>
                    	<td>연구 제목</td>
                        <td id="rightColumn"><input type="text" name="title" style="width:100%;"></td>
                    </tr>
                    <tr>
                    	<td>연구 목적</td>
                        <td id="rightColumn"><input type="text" name="purpose" style="width:100%;"></td>
                    </tr>
                    <tr>
                    	<td>연구 방법 및 절차</td>
                        <td id="rightColumn"><textarea name="method"></textarea></td>
                    </tr>
                    <tr>
                    	<td>소요시간 (단위: 분)</td>
                        <td id="rightColumn"><input type="number" name="duration" style="width:100%;"></td>
                        <!-- 학점은 그냥 소요시간으로 알아서 서비스에서 계산해서 넣어버리기 -->
                    </tr>
                    <c:if test="${rewardType=='참가비'}">
                    <tr>
                    	<td>참가비 (단위: 원)</td>
                    	<td id="rightColumn"><input type="number" name="rewardValue"></td>
                    </tr>
                    </c:if>
                    <c:if test="${rewardType=='기타'}">
                    <tr>
                    	<td>무엇을 (ex 초코파이를)</td>
                    	<td id="rightColumn"><input type="text" name="rewardType"></td>
                    </tr>
                    <tr>
                    	<td>얼마나</td>
                    	<td id="rightColumn"><input type="number" name="rewardValue">개</td>
                    </tr>
                    </c:if>
                    <tr>
                    	<td>연구계획서 첨부</td>
                    	<td><input type="file" name="file"><br>IRB승인을 받은 연구계획서 첨부가 권장됩니다.</td>
                    </tr>
                </table>
                <div class="buttonBox">
                    <input type="submit" value="연구 신청 완료" />
                </div>
            </form>
        </div>
    </div>

	<jsp:include page="../include/footer.jsp" />

</body>
</html>