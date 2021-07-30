<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>researchWeb</title>
        <link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value="/css/styles.css" />" rel="stylesheet" />
        
         <!-- JS -->
        <script src="<c:url value="/js/jquery-3.5.1.js" />"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
        <!-- Core theme JS-->
        
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <jsp:include page="include/header.jsp" />
        
        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>About this page</h2>
                        <p class="lead">참가자 모집과 연구 개설을 쉽게!</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="bg-light" id="services">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>Services we offer</h2>
                        <p class="lead">연구 개설 및 연구 참여 기능</p>
                    </div>
                </div>
            </div>
        </section>
        <section id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>Contact me</h2>
                        <p class="lead">zzun0319@naver.com</p>
                    </div>
                </div>
            </div>
        </section>
        
       <jsp:include page="include/footer.jsp" />
        
    </body>
</html>

<script>
	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}
</script>
