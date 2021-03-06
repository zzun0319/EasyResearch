<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연구개설 페이지</title>

<link rel="icon" type="image/x-icon" href="<c:url value="/assets/favicon.ico" />" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>

<style type="text/css">
#rightColumn{width: 100%;}

li {
	list-style: none;
	display: inline;
}

.page-active{background-color: #643691;}

</style>

</head>
<body>

	<c:if test="${user == null}">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>
	<c:if test="${!user.permissionRight}">
		<script>
			alert("해당 페이지 접근 권한이 없습니다.");
			location.href="/user/mypage";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	
		<h2> [개설 연구 승인하기] </h2>
		<p>
			<table border="1">
				<tr>
					<td>연구 제목</td>
					<td>연구자 이름</td>
					<td>승인 상태</td>
				</tr>
				<c:forEach var="research" items="${registedResearchList}" varStatus="status">
					<tr>
						<td><a href="/research/showOneResearch${param.pageNum == null ? pc.MakeURI(1) : pc.MakeURI(param.pageNum)}&researchId=${research.researchId}&major=${user.major}">${research.title}</a></td>
						<td>${research.researcher.userName}</td>
						<td>${research.permission ? '승인' : '승인대기'}</td>
					</tr>
				</c:forEach>
			</table>
		</p>
		
		<div> <!-- 페이징 처리 -->
			<ul>
			<c:if test="${pc.prev}">
				<li>
				<a href="/research/acceptResearch${pc.MakeURI(pc.startPageNum - 1)}&major=${user.major}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
				</li>
			</c:if>
				
				<c:forEach var="pageNum" begin="${pc.startPageNum}" end="${pc.endPageNum}">
					<li>
					<a href="/research/acceptResearch${pc.MakeURI(pageNum)}&major=${user.major}" class="numBtn ${(pc.pageInfo.pageNum == pageNum) ? 'page-active' : ''}" style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691;">${pageNum}</a>
					</li>
				</c:forEach>
				
			<c:if test="${pc.next}">	
				<li>
				<a href="/research/acceptResearch${pc.MakeURI(pc.endPageNum + 1)}&major=${user.major}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
				</li>
			</c:if>
				
			</ul>
		</div>
		
		<div><!-- 검색 기능 처리 -->
			<select id="condition" name="condition" style="width: 250px;">
				<option value="title" ${param.condition == 'title' ? 'selected' : ''}>연구제목</option>
				<option value="researcher" ${param.condition == 'researcher' ? 'selected' : ''}>연구자</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp;
			<input id="keywordInput" name="keyword" placeholder="검색어를 입력하세요."> &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="검색" id="searchBtn">
		</div>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>

<script>
	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}
	
	$(function() { // JQuery 시작
		
		$("#searchBtn").click(function() {
			const keyword = $("#keywordInput").val();
			const condition = $("#condition option:selected").val();
			location.href = "/research/acceptResearch?keyword=" + keyword + "&condition=" + condition + "&major=${user.major}";
		})
		
		$("#keywordInput").keydown(function(key) {
			if(key.keyCode == 13){
				$("#searchBtn").click();
			}
		})
		
	})
</script>