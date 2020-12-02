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
<title>500</title>
<link rel="stylesheet" type="text/css" href="/css/error.css" />
<style>
*{font-family:Verdana}
li{font-size:16px;line-height:22px;font-weight:bold;padding-top:10px;}
.errtlt{color:#369;font-weight:bold;}
</style>
</head>
<body>
<br /><br /><br />
<div style="text-align:left;padding-left:20px;">
<ul >
  <li><div class="errtlt">Exception:</div> <c:out value="${requestScope['javax.servlet.error.exception']}" /></li>
  <li><div class="errtlt">Exception type:</div> <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></li>
  <li><div class="errtlt">Exception message:</div> <c:out value="${requestScope['javax.servlet.error.message']}" /></li>
  <li><div class="errtlt">Request URI:</div> <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></li>
  <!-- <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
  <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></li> -->
</ul>
<br /><br /><br />
 <h3>StackTrace</h3>
<div style="width:100%;font-size:14px;line-height:18px;">
<c:forEach items="${requestScope['javax.servlet.error.exception'].stackTrace}" var="element">
<div><c:out value="${element}" /></div>
</c:forEach>
</div>
<div id="wrap">
    <div id="container">    
        <div class="msg_area" >
            <h4 class="glyphicon glyphicon-exclamation-sign" >&nbsp;500 </h4>
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
    <div id="footer">
        <address>
                <em>Copyright &copy;</em> <a target="_blank" href="#">JCUESOFT Corp.</a> <span>All Rights Reserved.</span>
        </address>
    </div>
</div>
<!-- 
500
<ul>
  <li>Exception: <c:out value="${requestScope['javax.servlet.error.exception']}" /></li>
  <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></li>
  <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}" /></li>
  <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></li>
  <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
  <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></li>
  <li>Stacktrace: <c:forEach items="${requestScope['javax.servlet.error.exception'].stackTrace}" var="element">
      <c:out value="${element}" />
      <br>
    </c:forEach>
</ul>
 -->