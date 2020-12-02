<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" pageEncoding="utf-8"%>

<sec:authorize access="isAnonymous()">
	<% response.sendRedirect("/auth/login"); %>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
</sec:authorize>
<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
        <!-- <h1>메인페이지</h1>
        Session ID : ${userVO.idUser} <br/>
		Session NM : ${userVO.nmUser} <br/>
		Session TM : ${userVO.cdTeam} <br/>
		Session dsUrl : ${userVO.dsUrl} <br/>
		Session ynConfirm : ${userVO.ynConfirm} <br/>
		Session FAX : ${userVO.faxNo} <br/>
         -->
		<c:set  var="sesAuthDsUrl"  value="${userVO.dsUrl}" scope="page" />
  </tiles:putAttribute>
</tiles:insertDefinition>