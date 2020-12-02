<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false" pageEncoding="utf-8" isErrorPage="true" %>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>403</title>
<link rel="stylesheet" type="text/css" href="/css/error.css" />
</head>
<body>
<div id="wrap">
    <div id="container">    
        <div class="msg_area" >
            <h4 class="glyphicon glyphicon-exclamation-sign" >
            &nbsp;이 세션은 만료되었습니다.</h4>
             <!-- (복수의 동시 로그인이 동일한 사용자로 시도되는 가능성으로 인해) -->
            <blockquote class="blockquote">
                <p>Exception: <c:out value="${requestScope['javax.servlet.error.exception']}" /></p>
                <p>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></p>
                <p>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}" /></p>
                <p>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></p>
                <p>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></p>
                <p>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></p>
            </blockquote>
        </div>
        <div class="c_btn" style="">
            <span class="btn_pack large"><a href="#" onclick="history.back()">이전페이지 이동</a></span>   
            <span class="btn_pack large"><a href="/">메인페이지 이동</a></span>   
        </div>
    </div>
    
</div>