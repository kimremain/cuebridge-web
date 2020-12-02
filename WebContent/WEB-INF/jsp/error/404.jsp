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
<title>404 Page Not Found</title>
<link rel="stylesheet" type="text/css" href="/css/error.css" />
</head>
<body>
<div id="wrap">
    <div id="container">    
        <div class="msg_area" >
            <h4 class="glyphicon glyphicon-exclamation-sign" >&nbsp;요청하신 페이지를 찾을 수 없습니다.</h4>
            <blockquote class="blockquote">
                <p>페이지의 주소가 잘못 입력되었거나,</p>
                <p>페이지의 주소가 변경 혹은 삭제되어 요청하신 페이지를 찾을 수 없습니다.</p>
                <p>입력하신 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.</p>
                <p>요청하신 페이지 주소 : <strong><c:out value="${requestScope['javax.servlet.error.request_uri']}" /></strong></p>
            </blockquote>
        </div>
        <div class="c_btn" style="">
            <span class="btn_pack large"><a href="#" onclick="history.back()">이전페이지 이동</a></span>   
            <span class="btn_pack large"><a href="/">메인페이지 이동</a></span>   
        </div>
        <!-- <div class="contact">관련 문의사항은&nbsp;<a href="mailto:"></a>&nbsp;에 문의하여 주시면 친절히 안내해드리겠습니다. 감사합니다</div> -->
    </div>
    <div id="footer">
        <address>
                <em>Copyright &copy;</em> <a target="_blank" href="#">JCUESOFT Corp.</a> <span>All Rights Reserved.</span>
        </address>
    </div>
</div>
