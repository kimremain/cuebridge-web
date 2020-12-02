<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}"  var="today" pattern="yyyy-MM-dd" />



    
    <div class="cb_wrt cb_wrt_default">
        <div class="cb_wrt_box">
            <form name="memoUpdateFrm">
            <input type="hidden" name="no"   />
            <input type="hidden" name="searchNoReq"   />
            <input type="hidden" name="noReq" value="${param.searchNoReq }" />
            <textarea name="dsMemo" style="display:none"></textarea>
            </form>
            <form name="memoRegistFrm" method="post" action="/brc/insertMemo">
            <input type="hidden" name="noReq" value="${param.searchNoReq }" />
            <input type="hidden" name="searchCdStatus"  value="${param.searchCdStatus }" />
            <input type="hidden" name="cdContact"  value="71201" />
            <input type="hidden" name="memoStepFlag"  />
                <fieldset>
                    <legend>메모 등록 폼</legend>
                    <div class="cb_usr_area">
                        <div class="cb_txt_area">
                            <table border="1" cellspacing="0" class="cb_section">
                                <tbody>
                                    <tr>
                                        <td><textarea name="dsMemo" rows="20" cols="80" style="width:365px;height:120px"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="cb_dsc_area">
                                                <div class="clear">
                                                    <!-- 접수상태일때만 동의서 안내메모 노출  -->
                                                    <c:if test="${'71002' eq param.searchCdStatus }">
                                                    <p class="fl">
                                                        <span class="btn_pack medium icon"><span
                                                            class="check"></span><input type="button" value="동의서 안내 메모" onclick="insertMemo(this,'stepup_71003')" ></span>
                                                    </p>
                                                    </c:if>
                                                     <!-- 접수상태일때만 동의서 안내메모 노출  -->
                                                     
                                                    <p class="fr">
                                                        <span class="btn_pack medium icon"><span
                                                            class="check"></span><input type="button" value="메모저장" onclick="insertMemo(this)"></span>
                                                    </p>
                                                </div>

                                            </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <h5 class="cb_h_type cb_h_type2">
        메모이력 <span>(<strong>${contactList.size()}</strong>)</span>
    </h5>
    <div class="cb_lstcomment" style="min-height:620px">
        <ul>
            <c:forEach items="${contactList}" var="row" varStatus="rowStatus">  
            
            
            <li class="cb_comment_area clear">
                <div class="cb_info_area">
                    <div class="cb_section">
                        ${row.nmReg}<span class="cb_date">${row.dmReg}</span>
                    </div>
                    <div class="cb_section2">
                        <!-- 작성자 본인만 ,당일 등록건만 -->
                        <c:if test="${row.idReg eq userVO.idUser and today eq fn:substring(row.dmReg,0,10)}">
                            <a href="#" onclick="makeModifyMemoForm('${row.no}');return false;">수정</a>
                        </c:if>
                         <c:choose>
                            <c:when test="${'Y' eq userVO.ynAdmin }">
                            <a href="#"  onclick="removeMemo('${row.no}');return false;">삭제</a>
                            </c:when>
                            <c:when test="${row.idReg eq userVO.idUser and today eq fn:substring(row.dmReg,0,10)}">
                            <a href="#"  onclick="removeMemo('${row.no}');return false;">삭제</a>
                            </c:when>
                         </c:choose>

                    </div>
                </div>
                <div id="memoCont${row.no}"  class="cb_dsc_comment">${row.dsMemo}</div>
                <div id="memoForm${row.no}"  class="cb_dsc_comment" style="display:none">
				</div>
            </li>
            </c:forEach>
        </ul>
    </div>
    
  