<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
    
 <table border="0" cellspacing="0" style="margin-top:20px" summary="중개전산" class="basic_tbl">
     <tbody>
         <tr>
             <td colspan="8">중개전산 조회결과</td>
         </tr>
         <tr>
             <th width="100">접수번호</th>
             <th width="100">회원이름</th>
             <th width="100">주민번호</th>
             <th width="100">전화번호</th>
             <th width="100">접수자</th>
             <th width="100">심사자</th>
             <th width="100">상태</th>
             <th width="100">최종메모</th>
         </tr>
         <c:forEach items="${bridgeList}" var="item" varStatus="rowStatus">  
         <tr>
             <td>${row.noReq}</td>
             <td>${row.nmCustom}</td>
             <td>${row.noCustom}</td>
             <td>${row.noTel}</td>
             <td>${row.idReceive}</td>
             <td>${row.idScreen}</td>
             <td>${row.cdStatus}</td>
             <td>${row.lastMemo}</td>
             
         <tr>
          </c:forEach>
     </tbody>
 </table>

<table border="0" cellspacing="0" style="margin-top: 20px" summary="회수관리 " class="basic_tbl">
     <tbody>
         <tr>
             <td colspan="7">ERP 회수관리 조회결과</td>
         </tr>
         <tr>
             <th width="100">접수번호</th>
             <th width="100">계약번호</th>
             <th width="100">회원이름</th>
             <th width="100">주민번호</th>
             <th width="100">대출일</th>
             <th width="100">상태</th>
             <th width="100">거래팀</th>
         </tr>
         <c:forEach items="${erpList}" var="item" varStatus="rowStatus">  
         <tr>
             <td>${row.erpNo}</td>
             <td>${row.erpNoUser}</td>
             <td>${row.nmCustom}</td>
             <td>${row.noCustom}</td>
             <td>${row.okDate}</td>
             <td>${row.attributeBig}</td>
             <td>${row.branchTeam}</td>
         <tr>
          </c:forEach>
          <c:if test="${erpList.length == 0}">
          <tr>
             <td colspan="7" height="100">일치하는 정보가 없습니다.</td>
         </tr>
          </c:if>
     </tbody>
 </table>
<table border="0" cellspacing="0" style="margin-top: 20px" summary="대출관리 " class="basic_tbl">
     <tbody>
         <tr>
             <td colspan="7">UPS 대출관리 조회결과</td>
         </tr>
         <tr>
             <th width="100">회원이름</th>
             <th width="100">주민번호</th>
             <th width="100">심사날짜</th>
             <th width="100">상태</th>
             <th width="100">거절사유</th>
             <th width="100">심사자 </th>
         </tr>
         <c:forEach items="${upsList}" var="item" varStatus="rowStatus">  
         <tr>
             <td>${row.nmCustom}</td>
             <td>${row.noCustom}</td>
             <td>${row.bTime}</td>
             <td>${row.upsStatus}</td>
             <td>${row.rejectCode}</td>
             <td>${row.appManagerId}</td>
         <tr>
          </c:forEach>
     </tbody>
 </table>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    