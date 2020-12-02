<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
String domainSession = (String) session.getAttribute(CommonConstants.SESSION_KEY_DOMAIN);
%>
<!DOCTYPE html>
<html>
<head>
<tiles:insertAttribute name="headoc" />
</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="body" />
	</div>
	
	<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
	<script type="text/javascript">
<c:choose>
    <c:when test="${'youi-cuebridge.cashway.co.kr' eq domainSession }">
    LINCUS_DOMAIN = "https://youi-lincus.cashway.co.kr/";
    </c:when>
    <c:when test="${'mill-cuebridge.cashway.co.kr' eq domainSession }">
    LINCUS_DOMAIN = "https://million-lincus.cashway.co.kr/";
    </c:when>
    <c:when test="${'star-cuebridge.cashway.co.kr' eq domainSession }">
    LINCUS_DOMAIN = "https://star-lincus.cashway.co.kr/";
    </c:when>
</c:choose>
jQuery(function($){
    //page_init();
});
</script>
	<iframe id="hiddenFrame" name="hiddenFrame" src="about:blank"
		width="1000" height="1000" style="display: none"></iframe>
</body>
</html>