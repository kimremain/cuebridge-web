<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!doctype html>
<html>
<head>
<tiles:insertAttribute name="headoc" />
</head>
<body>
	<div id="wrap">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="container">
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<div id="info_msg_pop"></div>
		<div id="error_msg_pop"></div>
	</div>
	<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
	<script type="text/javascript">
	 <c:choose>
	     <c:when test="${'Y' eq userVO.cdCompany }">
	     LINCUS_DOMAIN = "https://youi-lincus.cashway.co.kr/";
	     </c:when>
	     <c:when test="${'M' eq userVO.cdCompany }">
	     LINCUS_DOMAIN = "https://million-lincus.cashway.co.kr/";
	     </c:when>
	     <c:when test="${'S' eq userVO.cdCompany }">
	     LINCUS_DOMAIN = "https://star-lincus.cashway.co.kr/";
	     </c:when>
     </c:choose>

jQuery(function($){
    page_init();
});
</script>
<iframe src="about:blank" id="hiddenFrame" name="hiddenFrame" style="display:none"></iframe> 
</body>
</html>