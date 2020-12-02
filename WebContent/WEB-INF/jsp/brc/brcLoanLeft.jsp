<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div style="padding: 10px 0 10px 10px" class="btn_workset" id="search_table">
    <span style="" class="btn_icon24 member_add"><a onclick="registCustomerPopup()">신규등록</a></span> 
    <span style="" class="btn_icon24 search"><a onclick="relationSearchPopup()" href="#">연계검사</a></span>
</div>

<%/* 접수내역 트리 시작 */%>
<div style="width: 152px;min-height:700px;" class="nav_tree">
    <ul>
        <%/* 접수상태출력 시작 */%>
        <c:forEach items="${code710}" var="item">
            <c:if test="${item.code ne '71001' && item.code ne '71012'}"> <%/* 접수상태제외(대기,삭제) */%>
                <li class="nav_tree_on">
                    <img id="img${item.code}" src="/images/tree/tree-folder-open.gif"> 
                    <strong class="nav_tree_label"><a href="/brc/loan/select?searchCdStatus=${item.code}">${item.text} <span id="spn${item.code}"></span></a></strong>
                   
                    <%/* 접수상태안의 접수내역출력 시작 */%>
                    <c:set var="no" value="0" /> 
                    <c:forEach items="${list01}" var="item01">
                        <c:if test="${item.code eq item01.cdStatus}">
                            <c:set var="no" value="${no+1}" /> 
                            <c:set var="bgcolor" value="#eaeaea" />
                            <c:set var="selClass" value="" />
                            <c:if test="${param.searchNoReq  eq  item01.noReq}">
                               <c:set var="selClass" value="selected" />
                            </c:if>
                            <c:if test="${fn:contains('71002,71003', item01.cdStatus) && '70401' eq item01.cdPath}">
                               <!-- #bcdede -->
                            </c:if>
                            <ul>
                                <li id="li${item.code}${no}">
                                    <table border="0" cellspacing="0" cellpadding="0" class="nav_tree_tbl">
                                        <tbody>
                                            <tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#C2D8ED'" >
                                                <td><a href="#"><img src="/images/tree/tree-doc.gif"></a></td>
                                                <td><a href="/brc/loan/select?searchNoReq=${item01.noReq}<c:if test="${ item.code eq '71004'}">&tabChange=bex</c:if>" class="${selClass}" >${item01.nmCustom}</a></td>
                                                <td class="home_ivr ${selClass}">(${item01.cdPathFlag})</td>
                                                <td class="memo">
                                                    <%/* 메모보여줄 접수상태 (접수,상담중,재영업대상) */%>
                                                    <c:if test="${item.code eq '71002' || item.code eq '71003' || item.code eq '71004'  || item.code eq '71006' || item.code eq '71010'}">
                                                        
                                                        <%/* 메모출력 시작 */%>
                                                        <c:set var="memo" value="" />
                                                        <c:forEach items="${list02}" var="item02">
                                                            <c:if test="${item01.noReq eq item02.noReq}">
                                                                 <c:set var="memo" value="${memo} 
								                                 <div class='memo_area'><div class='memo_tlt'>[${item02.nmReg} - ${empty item02.dmUpt ?  item02.dmReg  : item02.dmUpt}]</div>
								                                 <div class='memo_desc'>${item02.dsMemo}</div></div>"  /> 
                                                            </c:if>
                                                        </c:forEach>
                                                        
                                                        <c:choose> 
															<c:when test="${memo eq ''}"> 
															    <a href="#"><img src="/images/icon/comments_gray.png"></a>
															</c:when> 
															<c:otherwise> 
															    <a title="${memo}" class="memo_tooltip" href="#">
		                                                            <img src="/images/icon/comments.png">
		                                                        </a>
															</c:otherwise> 
														</c:choose>
                                                        <%/* 메모출력 끝 */%>
                                                        
                                                    </c:if>    
                                                </td>
                                                <td class="time">${item01.dmPromise}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </li>
                            </ul>
                        </c:if>
                    </c:forEach>
                    <script>
                    <c:if test="${item.code eq '71002' || item.code eq '71003'  || item.code eq '71004'  || item.code eq '71006'  || item.code eq '71010'}"> 
                        $("#spn${item.code}").html("(${no})"); <%/* 접수내역 count */%>
                    </c:if>
                        $("#li${item.code}${no}").attr("class","nav_tree_last"); <%/* last tree img */%>
                        if ("${no}"=="0") $("#img${item.code}").attr("src","/images/tree/tree-folder.gif"); <%/* close forder */%>
                    </script>
                    <%/* 접수상태안의 접수내역출력 끝 */%>
                   
                </li>
            </c:if>
        </c:forEach>
        <%/* 접수상태출력 끝 */%>
    </ul>
</div>
<%/* 접수내역 트리 끝 */%>


