<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/css/styles.css" />" rel="stylesheet" />

</head>
<body>

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="/">EasyResearch</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                    	<c:if test="${user == null}">
                        	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="/user/login">로그인</a></li>
                        	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="/user/register_checkUnivMember">회원가입</a></li>
                        </c:if>
                        <c:if test="${user != null}">
                        	<div style="position: relative; right: 100px; top:10px; color: white;">${user.userName}님(${user.userType})</div>
                        	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="/user/logout">로그아웃</a></li>
                        	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="/user/mypage">마이페이지</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="bg-primary text-white">
            <div class="container text-center">
            	<c:if test="${user == null}">
                	<h1>EasyResearch에 방문해주셔서 감사합니다.</h1>
                	<p class="lead">EasyResearch는 연구자, 연구참여자 모두 간편하게 사용할 수 있는 연구 서포트 웹입니다.</p>
                </c:if>
                <c:if test="${user != null && user.emailVerification}">
                        <c:if test="${user.participationRight}">
                        	<input type="button" value="연구 참여 신청하기" onclick="location.href='/research/searchResearch'">
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${user.setupRight}">
                        	<input type="button" value="연구 개설 신청하기" onclick="location.href='/research/openResearch'">
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${user.classRegiRight}">
                        	<input type="button" value="연구 참여 과목 설정하기" onclick="location.href='/class/registerClassForResearch'">
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	<input type="button" value="연구 참여 점수 파일 다운로드" onclick="location.href='/class/downloadCreditFile'">
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${user.permissionRight}">
                        	<input type="button" value="개설 연구 승인하기" onclick="location.href='/research/acceptResearch?major=${user.major}'">
                        </c:if>
                </c:if>
            </div>
        </header>

</body>
</html>