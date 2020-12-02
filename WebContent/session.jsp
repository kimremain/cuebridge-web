<%@page import="java.util.Date"%>
<%@ page language="java" session="true" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<br>

<br>
test::
curl -v --cookie "JSESSIONID=[value]" http://localhost/session.jsp
</br>


cookie : ${cookie[JSESSIONID]} 
<br><br>

<%
Cookie cook[] = request.getCookies();
for (int i=0; cook != null && i<cook.length; i++) {
    out.println(cook[i].getName()+":"+cook[i].getValue()+"<br>");
}


Object tmp = session.getAttribute("sessionNumber");
int sessionNumber = 0;

if(null != tmp && !("").equals(tmp)){
    sessionNumber = Integer.parseInt(tmp+"");
}

sessionNumber = sessionNumber+1;
session.setAttribute("sessionNumber", sessionNumber);
out.println("<br><h1>session value: "+sessionNumber+"<h1><br>");

String seq = System.getProperty("server.seq");
out.println("<br><h1>jvmroute : jvm"+seq+"<h1><br>");

%>

<%
java.text.DateFormat format = java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG);

out.println( "<br>session     생성 시간 : " + format.format( new java.util.Date(session.getCreationTime()) ));  // creation time
out.println( "<br>session 최종 접속시간 : " + format.format(new java.util.Date(session.getLastAccessedTime()))); // last access time
out.println( "<br>session      유지시간 : " + (session.getMaxInactiveInterval() / 60 )+" 분"); // second

%>  