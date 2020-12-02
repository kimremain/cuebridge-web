<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true" pageEncoding="utf-8"%>
     <c:set  var="paginator"  value="${pageListPaginator}" scope="page" />
    <fmt:parseNumber var="N" value="${paginator.page / 10}"  /> 
    <fmt:parseNumber var="block" value="${N+(1-(N%1))%1}" /> 
    <!-- N ${N } 
    block ${block } 
    start ${((block-1) * 10 ) }  
     end ${(paginator.totalPages >  block) ? ( block) *10 : paginator.totalPages} -->
    <div class="paginate_regular">
    <c:if test="${paginator.hasPrePage}">
        <a class="direction" href="#" onclick="pageMove(${ paginator.prePage })"><span>‹</span> 이전</a>
    </c:if>

    <c:forEach var="counter"  begin="${(block ==0) ? 1 :  ((block-1) * 10 +1)  }" end="${(paginator.totalPages >  block) ? ( block) *10 : paginator.totalPages}" step="1">
        <c:if test="${ counter <= paginator.totalPages }">
            <c:choose>
                <c:when test="${ counter == paginator.page }">
                    <a href="#"><strong><c:out value="${counter}" /></strong></a>
                </c:when>
                <c:otherwise>
                    <a href="#" onclick="pageMove(<c:out value="${counter}"/>)"><c:out value="${counter}" /></a>
                </c:otherwise>
            </c:choose>
        </c:if>
    </c:forEach>
    <c:if test="${paginator.hasNextPage}">
        <a class="direction" href="#"
            onclick="pageMove(${ paginator.nextPage })"> 다음<span>›</span></a>
    </c:if>
    </div>