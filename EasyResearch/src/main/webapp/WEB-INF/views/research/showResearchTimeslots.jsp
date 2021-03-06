<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
#rightColumn{width: 80%;}

*{padding:0; margin:0}

textarea{width: 100%; height: 100px;}

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
	<c:if test="${!user.setupRight}">
		<script>
			alert("해당 페이지의 접근 권한이 없습니다.");
			location.href="/user/mypage";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	<br><br><br><br><br><br><br><br><br><br><br>
		
		<c:if test="${timeslotList == null || timeslotList.size() == 0}">
			생성한 타임슬롯이 없습니다.
		</c:if>
		
		<c:if test="${timeslotList != null && timeslotList.size() != 0}">
		<div>
			<h3>[${timeslotList[0].research.title}의 타임슬롯]</h3>
			<table border="1">
				<tr>
					<td>날짜 및 시간</td>
					<td>참가인원</td>
					<td>연구 장소</td>
					<td>상태변경</td>
				</tr>
				<c:forEach var="timeslot" items="${timeslotList}">
					<tr>
						<td><fmt:formatDate value="${timeslot.startTime}" pattern="yyyy년 MM월 dd일 HH시 mm분"/>~<fmt:formatDate value="${timeslot.endTime}" pattern="HH시 mm분" /></td>
						<td>${timeslot.applyCnt}명 / ${timeslot.place.maxPeople}명</td>
						<td>${timeslot.place.placeName}</td>
						<td><a href="#">상태변경</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<div> <!-- 페이징 처리 -->
				<ul>
				<c:if test="${pc.prev}">
					<li>
					<a href="/research/showResearchTimeslots${pc.MakeURI(pc.startPageNum - 1)}&research.researchId=${timeslotList[0].research.researchId}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
					</li>
				</c:if>
					
					<c:forEach var="pageNum" begin="${pc.startPageNum}" end="${pc.endPageNum}">
						<li>
						<a href="/research/showResearchTimeslots${pc.MakeURI(pageNum)}&research.researchId=${timeslotList[0].research.researchId}" class="numBtn ${(pc.pageInfo.pageNum == pageNum) ? 'page-active' : ''}" style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691;">${pageNum}</a>
						</li>
					</c:forEach>
					
				<c:if test="${pc.next}">	
					<li>
					<a href="/research/showResearchTimeslots${pc.MakeURI(pc.endPageNum + 1)}&research.researchId=${pageInfo.researchId}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
					</li>
				</c:if>
					
				</ul>
			</div>
			
		</div>
		</c:if>
		
		<div style="position: absolute; left: 700px; top: 300px;">
			<input type="button" value="타임슬롯 만들기" onclick="location.href='/research/makeTimeslot?research.researchId=${rId}'">
		</div>
	<br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="../include/footer.jsp" />

</body>
</html>

<script>
	const result = "${msg}"
	if(result != "" && result.length > 0){
		alert(result);
	}
</script>
