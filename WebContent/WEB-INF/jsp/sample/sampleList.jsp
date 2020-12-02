<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" pageEncoding="utf-8"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
  <form>
  <option value="1" ${param.number == 1 ? 'selected' : ''}>First option</option>
    <input type="hidden" name="page" value="${empty param.page ? '1' : param.page }"/>
    <input type="hidden" name="limit" value="${empty param.limit ? '20' : param.limit }"/>
    <input type="hidden" name="sort" value="${empty param.sort ? 'name' : param.sort }"/>
    <input type="hidden" name="dir" value="${empty param.dir ? 'asc' : param.dir }"/>
    <table>
      <tr>
        <td>ID</td>
        <td>NAME</td>
      </tr>
      <c:forEach items="${response}" var="sampleList">
        <tr>
          <td><a href="/sample/sampleView?id=${sampleList.id}">${sampleList.id}</a></td>
          <td>${sampleList.name}</td>
        </tr>
      </c:forEach>
    </table>
    <br>
이전 페이지: ${responsePaginator.prePage} 
현재 페이지: ${responsePaginator.page}
다음 페이지: ${responsePaginator.nextPage} <br>
총 페이지 수: ${responsePaginator.totalPages} <br>
총 상품 : ${responsePaginator.totalCount} <br><br>
    ${responsePaginator} <br/> <a href="/sample/sampleForm">insert</a>
  </form>
    </tiles:putAttribute>
</tiles:insertDefinition>