<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
        <table border="1" cellspacing="0" style="margin-top: 10px" summary="비대면관리대장" class="basic_tbl">
            <thead>
                <tr>
                    <th>관리번호</th>
                    <th>성명</th>
                    <th>ERP회원번호</th>
                    <th>UPS회원번호</th>
                    <th>BRG접수번호</th>
                    <th>접촉일시</th>               
                    <th>상담자</th>
                    <th>동의시점</th>
                    <th>인/아웃</th>
                    <th>접촉방법</th>   
                </tr>
            </thead>    
            <tbody>
                <c:forEach items="${memberListInoutTmList}" var="memberListInoutTmList">
                    <c:set var="bgcolor" value="#ffffff" />
                    <tr bgcolor="${bgcolor}">
                        <td>${memberListInoutTmList.seq}</td>
                        <td>${memberListInoutTmList.nmCustom}</td>
                        <td>${memberListInoutTmList.erpNo}</td>
                        <td>${memberListInoutTmList.upsNo}</td>
                        <td>${memberListInoutTmList.noReq}</td>
                        <td>${memberListInoutTmList.dtmReg}</td>                    
                        <td>${memberListInoutTmList.idReg}</td>
                        <td>${memberListInoutTmList.dtAgreeInfo}</td>
                        <td>${memberListInoutTmList.cdInout}</td>
                        <td>${memberListInoutTmList.cdKind}</td>            
                    </tr>
                </c:forEach>        
            </tbody>        
        </table>
