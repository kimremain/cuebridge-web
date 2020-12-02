<%@ page language="java" session="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<h3>Debug JSP</h3><br>
 <br>
<h3><strong>JSESSIONID : <%= session.getId() %>  </strong></h3>
<br>
<h3><strong> jvmroute : jvm<%=System.getProperty("server.seq")%> </strong></h3>
<br>
<strong>Cookie :<br></strong> 

<%

Cookie cook[] = request.getCookies();
for (int i=0; cook != null && i<cook.length; i++) {
    out.println(cook[i].getName()+":"+cook[i].getValue());
}

String number=session.getValue("sessionNumber")+"";

if(null != number && !("").equals(number)){

  int sessionNumber=Integer.valueOf(session.getAttribute("sessionNumber")+"");
  sessionNumber = sessionNumber+1;
  session.setAttribute("sessionNumber", sessionNumber);
}

%>
    </tiles:putAttribute>
</tiles:insertDefinition>