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
		<div>
		<h4>날짜 및 장소 별 예약 현황 조회</h4>
		<form action="/research/inquireTimeslots?${pc.MakeURI(param.pageNum)}" method="get"><!-- 페이징.. 검색.. 구현 -->
			<input type="hidden" name="research.researchId" value="${researchInfo.researchId}">
			<input type="hidden" name="isParticipant" value=true> <!-- 예약하기 위해 24시간 이후 사용 중인 곳을 조회하는 것이라서 true로 보내줌. -->
			언제부터 : <input type="date" name="tdt.startDate" id="start_date"> ~ 언제까지: <input type="date" name="tdt.endDate" id="end_date"> 
			장소: 
				<select name="tdt.researchPlace">
					<option value="X">=== 장소 선택 ===</option>
					<c:forEach var="location" items="${locations}">
						<option value="${location.placeName}">${location.placeName}(최대 수용인원: ${location.maxPeople}명)</option>
					</c:forEach>
				</select>
			<input type="submit" value="조회하기">
		</form>
		</div>
		
		<div>
		<c:if test="${inquireList == null || inquireList.size() == 0}">
		 조회결과가 없습니다.
		</c:if>
		<c:if test="${inquireList.size() > 0}">
			<table border="1" style="color: blue;">
			<tr>
				<td colspan="3">예약된 장소 및 일정</td>
			</tr>
			<tr>
				<td>장소</td>
				<td>날짜</td>
				<td>시간</td>
			</tr>
			<c:forEach var="inquiredTimeslot" items="${inquireList}">
				<tr>
					<td>${inquiredTimeslot.place.placeName}</td>
					<td><fmt:formatDate value="${inquiredTimeslot.startTime}" pattern="yyyy년 MM월 dd일" /></td>
					<td><fmt:formatDate value="${inquiredTimeslot.startTime}" pattern="HH시 mm분" /> ~ <fmt:formatDate value="${inquiredTimeslot.endTime}" pattern="HH시 mm분" /></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		</div>
		<div> <!-- 페이징 처리 시작 -->
			<ul>
			<c:if test="${pc.prev}">
				<li>
					<a href="/research/makeTimeslot${pc.MakeURI(pc.startPageNum - 1)}&research.researchId=${timeslotList[0].research.researchId}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
				</li>
				</c:if>
					
				<c:forEach var="pageNum" begin="${pc.startPageNum}" end="${pc.endPageNum}">
					<li>
					<a href="/research/makeTimeslot${pc.MakeURI(pageNum)}&research.researchId=${timeslotList[0].research.researchId}" class="numBtn ${(pc.pageInfo.pageNum == pageNum) ? 'page-active' : ''}" style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691;">${pageNum}</a>
					</li>
				</c:forEach>
					
			<c:if test="${pc.next}">	
				<li>
					<a href="/research/makeTimeslot${pc.MakeURI(pc.endPageNum + 1)}&research.researchId=${pageInfo.researchId}" style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
				</li>
			</c:if>
					
			</ul>
		</div> <!-- 페이징 처리 끝 -->
		
		<hr style="border: solid 5px green;">
		
		<c:if test="${researchInfo.researchType == '오프라인 실험' || researchInfo.researchType == '오프라인 설문' || researchInfo.researchType == '기타(오프라인)'}">
			<br> <h3>[타임슬롯 만들기]</h3>
			<form action="/research/makeTimeslot" method="post">
				<input type="hidden" name="research.researchId" value="${researchInfo.researchId}">
				<input type="hidden" name="duration" value="${researchInfo.duration}">
				<table border="1">
					<tr>
						<td>날짜 선택</td> <!-- date타입은 컨트롤러가 Date타입으로 받을 수 있다. -->
						<td id="rightColumn"><input type="date" name="researchDate"></td>
					</tr>
					<tr>
						<td>연구 시작 시간</td> <!-- time은 String으로 받아야한다. 컨트롤러가 Time, Date로 받지 못한다. 초 없이 24시간 형식으로 받아짐. 19:40 이런 식으로-->
						<td id="rightColumn"><input type="time" name="sTime" id="startTime"></td>
					</tr>
					<tr>
						<td>연구 종료 시간</td>
						<td id="rightColumn">연구 초기에 설정된 시간으로 자동으로 계산됩니다. 실험개설시 설정한 시간 : ${researchInfo.duration}분</td>
					</tr>
					<tr>
						<td>연구 장소</td>
						<td id="rightColumn">
							<select name="place.placeName">
								<option>=== 장소 선택 ===</option>
								<c:forEach var="location" items="${locations}">
								<option value="${location.placeName}">${location.placeName}(최대 수용인원: ${location.maxPeople}명)</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>참가자 수</td>
						<td id="rightColumn"><input type="number" name="maxCnt"> 명</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="타임슬롯 생성" style="background-color: skyblue;">
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${researchInfo.researchType == '온라인 실험' || researchInfo.researchType == '온라인 설문' || researchInfo.researchType == '기타(온라인)'}">
			<form method="post" action="/research/attachUrl">
				<p>링크 첨부하기: <input type="url" name="researchUrl"></p>
				<input type="submit" value="링크 첨부">
			</form>
		</c:if>
		
		<hr style="border: solid 5px black;">
		
	<jsp:include page="../include/footer.jsp" />

</body>
</html>

<script>
	const result = "${msg}"
	if(result != "" && result.length > 0){
		alert(result);
	}
</script>