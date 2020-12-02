<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" pageEncoding="utf-8"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
  <h2>Spring MVC Rest Demo</h2>

  <table border="1">
    <tr>
      <th>Id</th>
      <th>First Name</th>
      <th>Last Name</th>
    </tr>
    <c:forEach var="row" varStatus="loop" items="${peopleList}">
      <tr>
        <td>${row.id}</td>
        <td>${row.firstName}</td>
        <td>${row.lastName}</td>
      </tr>
    </c:forEach>
  </table>
  <p />
  Created by Pas Apicella
    </tiles:putAttribute>
</tiles:insertDefinition>
