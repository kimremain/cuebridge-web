<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<c:set var="nameField" value="${'Y' eq param.ynSurety ? '보증인' : '고객'}" /> 
<!-- 
<div id="processLayer" style="z-index: 1000; border: medium none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color:000000;opacity:0.4;filter:alpha(opacity=40); position: absolute;" class="blockUI blockOverlay"></div>
<div id="processBar" style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 242px; left: 323.5px; text-align: center; color: rgb(0, 0, 0); border: 0px solid rgb(170, 170, 170); background-color: rgb(255, 255, 255); cursor: pointer;" class="blockUI blockMsg blockElement">
    <div class="ly_loading"><p class="dsc_loading">문서를 불러오는 중...</p><img src="/images/loading_bar.gif" alt="로딩중" height="20" width="200"></div>
</div>
 -->


<div style="padding:10px;width:980;">
    <div class="search_area" style="background:#f2f2f2" >
       <form id="relationFrm"  name="relationFrm" method="get" action="/brc/search/select" onsubmit="return searchParamChk(this)">
        <input type="hidden" name="noReq"  value="${param.noReq}" />
        <input type="hidden" name="idReceive"  value="${param.lincusId}" /><!--린커스 연계검사에서 신규등록시킬때 사용할 아이디-->
        <input type="hidden" name="searchLincusOpt"   value="${param.searchLincusOpt}" />
        <input type="hidden" name="searchLincusKey"   value="${param.searchLincusKey}" />
        <input type="hidden" name="searchLincusNum"   value="${param.searchLincusNum}" />
        <input type="hidden" name="searchLincusType"  value="${param.searchLincusType}" /> 
        <input type="hidden" name="lincusId"  value="${param.lincusId}" /> 
        <input type="hidden" name="searchConfirm" />
        <input type="hidden" name="ynSurety"  value="${param.ynSurety}" />
            <fieldset>
                    <legend>Legend</legend>
	                <table border="0" cellspacing="0" class="search_table" summary="검색폼" >
	                 <tbody>
	                  <tr>
                          <th>성 명</th>
                          <td><input type="text" class="s_text w100" value="${requestVO.searchNmCustom }"   name="searchNmCustom" maxlength="10" onfocus="this.select();"></td>               
                          <th style="padding-left:10px">주민번호</th>
                          <td><input type="text" class="s_text w70" value="${requestVO.searchNoCustomFirst }"  name="searchNoCustomFirst" maxlength="6" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w70" value="${requestVO.searchNoCustomSecond }"    name="searchNoCustomSecond" maxlength="7" onfocus="this.select();">
                          </td>
                          <td colspan="2" valign="middle">
                                  &nbsp;&nbsp;&nbsp;<span style="" class="btn_icon search"><input type="submit" value="검 색" style="cursor:pointer"></span>
                                  &nbsp;&nbsp;&nbsp;<span style="" class="btn_icon people"><a href="#" onclick="brcRegistMove()">신규등록</a></span>
                                  &nbsp;&nbsp;&nbsp;<a href="/brc/search/select">초기화</a>
                          </td>
                      </tr>
                      <tr><td height="5"></td></tr>
	                  <tr>
	                      <th style="padding-left:10px">핸드폰</th>
                          <td>
                          <input type="text" class="s_text w40" value="${requestVO.searchNoMobile1 }" name="searchNoMobile1" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoMobile2 }" name="searchNoMobile2" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoMobile3 }" name="searchNoMobile3" maxlength="4" onfocus="this.select();">
                          </td>
	                      <th style="padding-left:10px">핸드폰2</th>
	                      <td>
	                      <input type="text" class="s_text w40" value="${requestVO.searchNoMobileSecond1 }" name="searchNoMobileSecond1" maxlength="4" onfocus="this.select();">
	                      -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoMobileSecond2 }" name="searchNoMobileSecond2" maxlength="4" onfocus="this.select();">
	                      -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoMobileSecond3 }" name="searchNoMobileSecond3" maxlength="4" onfocus="this.select();">
	                      </td>                    
	                  </tr>
	                  <tr><td height="5"></td></tr>
                      <tr>
                          <th style="padding-left:10px">집 전화번호</th>
                          <td>
                          <input type="text" class="s_text w40" value="${requestVO.searchNoTel1 }" name="searchNoTel1" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoTel2 }" name="searchNoTel2" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoTel3 }" name="searchNoTel3" maxlength="4" onfocus="this.select();">
                          </td>
                          
                          <th style="padding-left:10px">직장 전화번호</th>
                          <td>
                          <input type="text" class="s_text w40" value="${requestVO.searchNoComTel1 }" name="searchNoComTel1" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoComTel2 }" name="searchNoComTel2" maxlength="4" onfocus="this.select();">
                          -&nbsp;<input type="text" class="s_text w40" value="${requestVO.searchNoComTel3 }" name="searchNoComTel3" maxlength="4" onfocus="this.select();">
                          </td>
                          <th style="padding-left:10px">접근IP</th>
                          <td>
                          <input type="text" class="s_text w120" value="${requestVO.searchIP}" name="searchIP" maxlength="16" onfocus="this.select();">
                          </td>                          
                      </tr>   
	              </tbody>
                </table>
            </fieldset>
        </form>
    </div>

	<div class="relationResult" >
	<h4>조회결과</h4>
	<table border="0" cellspacing="0"  class="basic_tbl" id="allListTbl">
	         <thead>
	         <tr>
	             <th width="100">구분</th>
	             <th width="100">고유번호</th>
	             <th width="100">성명</th>
	             <th width="100">생년월일</th>
	             <th width="100">등록일</th>
	             <th width="100">담당자</th>
	             <th width="100">상태</th>
	             <th width="100">성명일치</th>
	             <th width="100">주민번호일치</th>
	             <th width="100">핸드폰일치</th>
	             <th width="100">전화번호일치</th>
	             <th width="100">IP일치</th>
	         </tr>
	     </thead>
	     <tbody>
	         <c:set var="cntFilterName" value="0" />
	         <c:set var="cntFilterJumin" value="0" />
	         <c:set var="cntFilterMobile" value="0" />
	         <c:set var="cntFilterPhone" value="0" />
	         <c:set var="matchTim" value="" />
             <c:set var="matchUps" value="" />
             <c:set var="matchErp" value="" />
             <c:set var="matchBridge" value="" />
	         <c:forEach items="${allList}" var="item" varStatus="rowStatus">  
	         <c:set var="bgcolor" value="#ffffff" />
	         <tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'"  onmouseover="this.style.backgroundColor='#EAECF5'">
	             <td>${item.nmDivision}</td>
	             <td><a href="#" onclick="openLink('${item.cdDivision}','${item.noCustomReq}','${item.noReq}')"  >${item.noReq}</a></td>
	             <td><a href="#" onclick="openLink('${item.cdDivision}','${item.noCustomReq}','${item.noReq}')"  >${item.nmCustom}</a></td>
	             <td>${item.noCustom1}</td>
	             <td>${item.dmReg}</td>
	             <td>${item.nmScreen}</td>
	             <td>${item.nmStatus}</td>
	             <td>${item.filterName}</td>
	             <td>${item.filterJumin}</td>
	             <td>${item.filterMobile}</td>
	             <td>${item.filterPhone}</td>
	             <td>${item.filterIP}</td>
	         </tr>
	         <c:if test="${!empty item.filterName}"><c:set var="cntFilterName" value="${cntFilterName+1}" />   </c:if>
	         <c:if test="${!empty item.filterJumin}"><c:set var="cntFilterJumin" value="${cntFilterJumin+1}" />   </c:if>
	         <c:if test="${!empty item.filterMobile}"><c:set var="cntFilterMobile" value="${cntFilterMobile+1}" />   </c:if>
	         <c:if test="${!empty item.filterPhone}"><c:set var="cntFilterPhone" value="${cntFilterPhone+1}" />   </c:if>
	         
	          <c:choose>
                    <c:when test="${fn:contains( 'BRIDGE,BRIDGE_SURETY',item.cdDivision) }">
                        <c:if test="${!fn:contains(matchBridge,item.filterName) }"><c:set var="matchBridge" value="${matchBridge}${item.filterName}," /> </c:if>
                        <c:if test="${!fn:contains(matchBridge,item.filterJumin) }"><c:set var="matchBridge" value="${matchBridge}${item.filterJumin}," /> </c:if>
                        <c:if test="${!fn:contains(matchBridge,item.filterMobile) }"><c:set var="matchBridge" value="${matchBridge}${item.filterMobile}," /> </c:if>
                        <c:if test="${!fn:contains(matchBridge,item.filterPhone) }"><c:set var="matchBridge" value="${matchBridge}${item.filterPhone}," /> </c:if>
                    </c:when>
                    <c:when test="${fn:contains( 'TIM,TIM_SURETY',item.cdDivision) }">
                        <c:if test="${!fn:contains(matchTim,item.filterName) }"><c:set var="matchTim" value="${matchTim}${item.filterName}," /> </c:if>
                        <c:if test="${!fn:contains(matchTim,item.filterJumin) }"><c:set var="matchTim" value="${matchTim}${item.filterJumin}," /> </c:if>
                        <c:if test="${!fn:contains(matchTim,item.filterMobile) }"><c:set var="matchTim" value="${matchTim}${item.filterMobile}," /> </c:if>
                        <c:if test="${!fn:contains(matchTim,item.filterPhone) }"><c:set var="matchTim" value="${matchTim}${item.filterPhone}," /> </c:if>
                    </c:when>
                    <c:when test="${fn:contains( 'UPS,UPS_SURETY',item.cdDivision) }">
                        <c:if test="${!fn:contains(matchUps,item.filterName) }"><c:set var="matchUps" value="${matchUps}${item.filterName}," /> </c:if>
                        <c:if test="${!fn:contains(matchUps,item.filterJumin) }"><c:set var="matchUps" value="${matchUps}${item.filterJumin}," /> </c:if>
                        <c:if test="${!fn:contains(matchUps,item.filterMobile) }"><c:set var="matchUps" value="${matchUps}${item.filterMobile}," /> </c:if>
                        <c:if test="${!fn:contains(matchUps,item.filterPhone) }"><c:set var="matchUps" value="${matchUps}${item.filterPhone}," /> </c:if>
                    </c:when>
                    <c:when test="${fn:contains( 'ERP,ERP_SURETY',item.cdDivision) }">
                        <c:if test="${!fn:contains(matchErp,item.filterName) }"><c:set var="matchErp" value="${matchErp}${item.filterName}," /> </c:if>
                        <c:if test="${!fn:contains(matchErp,item.filterJumin) }"><c:set var="matchErp" value="${matchErp}${item.filterJumin}," /> </c:if>
                        <c:if test="${!fn:contains(matchErp,item.filterMobile) }"><c:set var="matchErp" value="${matchErp}${item.filterMobile}," /> </c:if>
                        <c:if test="${!fn:contains(matchErp,item.filterPhone) }"><c:set var="matchErp" value="${matchErp}${item.filterPhone}," /> </c:if>
                    </c:when>
              </c:choose>
	         
	         
	          </c:forEach>
	          <c:if test="${allList.size() eq 0}">
	          <tr>
	             <td colspan="11" >일치하는 정보가 없습니다.</td>
	         </tr>
	          </c:if>
	     </tbody>
	 </table>
	 </div>


<div style="height:20px"></div>
<%-- 	<c:if test="${!empty requestVO.searchNoMobile1 and !empty requestVO.searchNoMobile2 and !empty requestVO.searchNoMobile3}">
	<div class="relationResult" >
	<h4>HP 통합</h4>
	<table border="0" cellspacing="0"  class="basic_tbl">
	     <tbody>
	         <tr>
	             <th width="100">구분</th>
	             <th width="100">성명</th>
	             <th width="100">고유번호</th>
	             <th width="100">계약번호</th>
	             <th width="100">신청일자</th>
	             <th width="100">담당자</th>
	             <th width="100">상태</th>
	         </tr>
	         <c:forEach items="${hpList}" var="item" varStatus="rowStatus">  
	         <tr>
	             <td>${item.cdKind}</td>
	             <td><a href="#" onclick="openLink('${item.cdKind}','${item.memberListNo}','${item.contractInfoNo}')"  >${item.name}</a></td>
	             <td>${item.memberListNo}</td>
	             <td>${item.contractInfoNo}</td>
	             <td>${item.appDate}</td>
	             <td>${item.nmScreen}</td>
	             <td>${item.status}</td>
	         <tr>
	          </c:forEach>
	          <c:if test="${hpList.size() eq 0}">
	          <tr>
	             <td colspan="7" >일치하는 정보가 없습니다.</td>
	         </tr>
	          </c:if>
	     </tbody>
	 </table>
	 </div>
	 </c:if>
	 
	<c:if test="${!empty requestVO.searchNoCustomFirst and !empty requestVO.searchNoCustomSecond }">
    <div class="relationResult" >
    <h4>주민번호 통합</h4>
    <table border="0" cellspacing="0"  class="basic_tbl">
         <tbody>
             <tr>
                 <th width="100">구분</th>
                 <th width="100">성명</th>
                 <th width="100">고유번호</th>
                 <th width="100">계약번호</th>
                 <th width="100">신청일자</th>
                 <th width="100">담당자</th>
                 <th width="100">상태</th>
             </tr>
             <c:forEach items="${juminHashList}" var="item" varStatus="rowStatus">  
             <tr>
                 <td>${item.cdKind}</td>
                 <td><a href="#" onclick="openLink('${item.cdKind}','${item.memberListNo}','${item.contractInfoNo}')"  >${item.name}</a></td>
                 <td>${item.memberListNo}</td>
                 <td>${item.contractInfoNo}</td>
                 <td>${item.appDate}</td>
                 <td>${item.nmScreen}</td>
                 <td>${item.status}</td>
             <tr>
              </c:forEach>
              <c:if test="${juminList.size() eq 0}">
              <tr>
                 <td colspan="7" >일치하는 정보가 없습니다.</td>
             </tr>
              </c:if>
         </tbody>
     </table>
     </div>
     </c:if> --%>
     
	<c:if test="${(!empty requestVO.searchNoCustomFirst and !empty requestVO.searchNoCustomSecond) or (!empty requestVO.searchNoMobile1 and !empty requestVO.searchNoMobile2 and !empty requestVO.searchNoMobile3) }">
    <div class="relationResult" >
    <h4>통합해쉬 검색</h4>
    <table border="0" cellspacing="0"  class="basic_tbl">
         <tbody>
             <tr>
                 <th width="100">대상</th>
                 <th width="100">시스템</th>
                 <th width="100">성명</th>
                 <th width="100">고유번호</th>
                 <th width="100">계약번호</th>
                 <th width="100">신청일자</th>
                 <th width="100">상태</th>
                 <th width="100">담당자</th>
                 <th width="100">주민번호일치</th>
                 <th width="100">핸드폰일치</th>
             </tr>
             <c:forEach items="${hashList}" var="item" varStatus="rowStatus">  
             <tr>
                 <td>${item.cdMan}</td>
                 <td>${item.cdKind}</td>
                 <td><a href="#" onclick="openLink('${item.cdKind}','${item.memberListNo}','${item.contractInfoNo}')"  >${item.name}</a></td>
                 <td>${item.memberListNo}</td>
                 <td>${item.contractInfoNo}</td>
                 <td>${item.appDate}</td>
                 <td>${item.status}</td>
                 <td>${item.nmManager}</td>
                 <td>${item.ssnFlag}</td>
                 <td>${item.hpFlag}</td>
             <tr>
              </c:forEach>
              <c:if test="${juminList.size() eq 0}">
              <tr>
                 <td colspan="7" >일치하는 정보가 없습니다.</td>
             </tr>
              </c:if>
         </tbody>
     </table>
     </div>
     </c:if>     
	 
	<div style="height:20px"></div>
	<div class="relationResult" >
	<h4 style="color:#4A637B">주의 전화번호</h4>
	<table border="0" cellspacing="0"  class="summary_tbl">
	     <tbody>
	         <tr>
	             <th width="220">전화번호</th>
	             <th width="150">등록일시</th>
	             <th width="100">등록자</th>
	             <th>비고</th>
	         </tr>
	         <c:forEach items="${noticeList}" var="item" varStatus="rowStatus">  
	         <tr>
	             <td>${item.noTel}</td>
	             <td>${item.dmReg}</td>
	             <td>${item.idReg}</td>
	             <td>${item.dsRemk}</td>
	         <tr>
	          </c:forEach>
	          <c:if test="${noticeList.size() eq 0}">
	          <tr>
	             <td colspan="7" >일치하는 정보가 없습니다.</td>
	         </tr>
	          </c:if>
	     </tbody>
	 </table>
	 
	   <!--<div style="padding:10px;width:980;">
            <div class="search_area" style="background:#f2f2f2" >
				
			</div>
		</div>
		-->
	 <form id="noticeFrm"  name="noticeFrm" method="get" action="/st/noticetel/insert" >
            <fieldset style="border:1px solid #A5B7C9;background:#EBEFF3;margin-top:15px;padding:5px 0 5px 0">
                     <table border="0" cellspacing="0" >
                    <tbody>
                        <tr>
                            <th style="padding-left: 10px">주의 전화번호</th>
                            <td><input type="text" class="s_text w120" value="${requestVO.noTel }" name="noTel" maxlength="20" onfocus="this.select();"></td>
                            <th style="padding-left: 10px">비고</th>
                            <td><input type="text" class="s_text w350" value="${requestVO.dsRemk }" name="dsRemk" onfocus="this.select();"> 
                            <a href="#" onclick="insertNoticeTel();"><span style="" class="btn_icon phone">주의 전화번호 등록</span></a>
                            </td>
                        </tr>
                    </tbody>
                </table>                
            </fieldset>
        </form>	
    </div>




        
        
<c:if test="${!empty requestVO.noReq  or !empty requestVO.searchLincusKey or true}" >

<c:set var="searchResult" value="
[연계검사 검색조건]" />
<c:if test="${!empty requestVO.searchNmCustom}">
<c:set var="searchResult" value="${searchResult}
${nameField}명: ${requestVO.searchNmCustom }" />
</c:if>
<c:if test="${!empty requestVO.searchNoCustom}">
<c:set var="searchResult" value="${searchResult}
생년월일: ${requestVO.searchNoCustomFirst}" />
</c:if>
<c:if test="${!empty requestVO.searchNoMobile1 and !empty requestVO.searchNoMobile2 and !empty requestVO.searchNoMobile3}">
<c:set var="searchResult" value="${searchResult}
핸드폰: ${requestVO.searchNoMobile1 }-${requestVO.searchNoMobile2 }-${requestVO.searchNoMobile3 }" />
</c:if>
<c:if test="${!empty requestVO.searchNoMobileSecond1 and !empty requestVO.searchNoMobileSecond2 and !empty requestVO.searchNoMobileSecond3}">
<c:set var="searchResult" value="${searchResult}
핸드폰2: ${requestVO.searchNoMobileSecond1}-${requestVO.searchNoMobileSecond2}-${requestVO.searchNoMobileSecond3}" />
</c:if>
<c:if test="${!empty requestVO.searchNoTel1 and !empty requestVO.searchNoTel2 and !empty requestVO.searchNoTel3}">
<c:set var="searchResult" value="${searchResult}
집전화번호: ${requestVO.searchNoTel1}-${requestVO.searchNoTel2}-${requestVO.searchNoTel3}" />
</c:if>
<c:if test="${!empty requestVO.searchNoComTel1 and !empty requestVO.searchNoComTel2 and !empty requestVO.searchNoComTel3}">
<c:set var="searchResult" value="${searchResult}
직장전화번호: ${requestVO.searchNoComTel1}-${requestVO.searchNoComTel2}-${requestVO.searchNoComTel3}" />
</c:if>
<c:set var="searchResult" value="${searchResult} 
      
[연계검사 검색결과] 
이름:${cntFilterName}건 , 주민번호:${cntFilterJumin}건 , 핸드폰:${cntFilterMobile}건  , 전화번호:${cntFilterPhone}건" />

<c:if test="${!empty matchBridge }">
<c:set var="searchResult" value="${searchResult} 
중개전산:${matchBridge}" />
</c:if>
<c:if test="${!empty matchTim }">
<c:set var="searchResult" value="${searchResult} 
TIM:${matchTim}" />
</c:if>
<c:if test="${!empty matchUps }">
<c:set var="searchResult" value="${searchResult} 
대출관리:${matchUps}" />
</c:if>
<c:if test="${!empty matchErp }">
<c:set var="searchResult" value="${searchResult} 
회수관리:${matchErp}" />
</c:if>


<c:if test="${!empty requestVO.noReq }" >
<form id="relationMemo"  name="relationMemo" method="post" onsubmit="return false;" >
<input type="hidden" name="noReq"  value="${param.noReq}" />
<input type="hidden" name="cdContact"  value="71201" />   
<input type="hidden" name="searchConfirm" />
<textarea id="dsMemo" name="dsMemo" style="display:none;width:400px;height:300px">${searchResult }</textarea>
</form>
<div style="padding:50px 0 50px 0">
     <table border="0" cellspacing="0" class="search_table" summary="검색결과 메모입력">
       <tbody>
       <tr>    
           <th style="padding-left:10px">추가메모</th>
           <td><input type="text" class="s_text w400" name="dsMemoAdd" id="dsMemoAdd"></td>
           <td><span style="" class="btn_pack medium"><a href="#" onclick="insertMemo()">검색결과 메모저장</a></span></td>
        </tr>
    </tbody>
  </table>
</div>
</c:if>
<c:if test="${!empty requestVO.searchLincusKey }" >
<form id="relationLincusMemo"  name="relationLincusMemo" method="post" onsubmit="return false;" >
<input type="hidden" name="memberListNo"   value="${lncusMemberInfo.memberListNo}" />
<input type="hidden" name="contractInfoNo"   value="${param.searchLincusNum}" />
<input type="hidden" name="communicationCode"   value="19015" />
<input type="hidden" name="saveStatus"   value="Y" />
<input type="hidden" name="workerId"   value="${param.lincusId}" />
<input type="hidden" name="searchLincusOpt"   value="${param.searchLincusOpt}" />
<input type="hidden" name="searchLincusType"  value="${param.searchLincusType}" /> 
        
  
<textarea  name="memo" style="display:none;width:400px;height:300px">${searchResult }</textarea>
</form>
<div style="padding:50px 0 50px 0">
     <table border="0" cellspacing="0" class="search_table" summary="검색결과 메모입력">
       <tbody>
       <tr>    
           <th style="padding-left:10px">추가메모</th>
           <td><input type="text" class="s_text w400" name="lincusMemoAdd" id="lincusMemoAdd"></td>
           <td><span style="" class="btn_pack medium"><a href="#" onclick="insertLincusMemo()">검색결과 메모저장</a></span></td>
        </tr>
    </tbody>
  </table>
</div>
</c:if>

</c:if>

<style>
.relationResult {padding:10px 0 10px 0;}
.relationResult h4{margin:0px 0 5px 0;font-size:12px;text-align:left;}
.relationResult h5{margin:0px 0 5px 0;color:#369;font-size:12px;text-align:left;}
</style>

<script>

var msg = '${param.msg}'; 
if(msg != ""){
	alert(msg);	
}
 

function insertNoticeTel(){
	var f = document.noticeFrm;
	if(f.noTel.value == ""){
		f.noTel.focus();
	    alert("주의 전화번호가 입력되지 않았습니다. ")
        return false;		
	}else{
		f.action = "/st/noticetel/insert";
		f.submit();		
	}
}

function brcRegistMove(){
	var f = document.relationFrm;
	f.action = "/brc/loanregist/select";
	f.submit();
}
function input_ups(n){
    var url = LINCUS_DOMAIN+"/ups/application/frame.php?no="+n;
    var wnd = window.open(url, "ups_application_info_from_relation_check", "left=0,top=0,width=500,height=500,scrollbars=yes,resizable=yes");
    wnd.focus();
}
function input_erp(cno,mno){
    var url = LINCUS_DOMAIN+"/erp/application/frame.php?member_list_no="+mno+"&contract_no="+cno+"&contract_info_no="+cno+"&limit_no=0";
    var wnd = window.open(url, "erp_application_info_from_relation_check", "left=0,top=0,width=500,height=500,scrollbars=yes,resizable=yes");
    wnd.focus();
}
function input_tim(n){
    var url = LINCUS_DOMAIN+"/ups/tim/frame_inquire.php?no="+n;
    var wnd = window.open(url, "tim_application_info_from_relation_check", "left=0,top=0,width=500,height=500,scrollbars=yes,resizable=yes");
    wnd.focus();
}
function input_bridge(n){
    var url = "/brc/loan/select?searchNoReq="+n;
    var wnd = window.open(url, "bridge_application_info_from_relation_check", "scrollbars=yes,resizable=yes");
    wnd.focus();
}

function openLink(cdDivision,noCustomReq, noReq  ){

    if(cdDivision == "ERP" || cdDivision == "ERP_SURETY")
    {   
    	// noReq           - contract_info_no
    	// noCustomReq - member_list_no
        input_erp(noReq,noCustomReq );
    }
    else if(cdDivision == "UPS" || cdDivision == "UPS_SURETY")
    {
        input_ups(noCustomReq);
    }
    else if(cdDivision == "TIM" || cdDivision == "TIM_SURETY")
    {
        input_tim(noCustomReq);
    }
    else if(cdDivision == "BRG" || cdDivision == "BRIDGE" || cdDivision == "BRIDGE_SURETY")
    {
    	input_bridge(noCustomReq);
    }
}
function searchParamChk(f){
    var isPassSearch = false;
    
    if(f.searchNmCustom.value){
        isPassSearch = true;
    } 
    if(f.searchNoCustomFirst.value && f.searchNoCustomSecond.value){
        isPassSearch = true;
    } 
    if(f.searchNoMobile1.value && f.searchNoMobile2.value  && f.searchNoMobile3.value){
        isPassSearch = true;
    }
    if(f.searchNoMobileSecond1.value && f.searchNoMobileSecond2.value  && f.searchNoMobileSecond3.value){
        isPassSearch = true;
    }
    if(f.searchNoTel1.value && f.searchNoTel2.value  && f.searchNoTel3.value){
        isPassSearch = true;
    }
    if(f.searchNoComTel1.value && f.searchNoComTel2.value  && f.searchNoComTel3.value){
        isPassSearch = true;
    }
    
    if(isPassSearch){
        f.searchConfirm.value = 'Y';
        return true;
    }else{
        alert("한개 이상의 검색조건을 입력하셔야 합니다. ")
        return false;
    }
}
// 브릿지 접수메모 저장 
function insertMemo(){
    var f  = document.relationMemo;
    if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
        
        if(!f.dsMemo.value){
            alert("메모를 입력하셔야 합니다.");
            return;
        }else{
            f.dsMemo.value = $('#dsMemoAdd').get(0).value+"\n\n"+f.dsMemo.value
            ON_SUBMIT_PROCESS = true;
            $('#relationMemo').block({});
            
            $.ajax({
                type: "POST",
                url: "/brc/contact/insert.json",
                cache:false,
                dataType: "json",
                async: false,
                data: $(f).serializeArray() ,
                success: function(data){
                    if(data.result == 'success'){
                        openerReload();
                        //opener.location.reload();
                    }else{
                        alert(data.message);
                    }
                    ON_SUBMIT_PROCESS = false;
                    $('#relationMemo').block({});
                }
             });
            
        }
    }
}
// 린커스 접수메모 저장 
function insertLincusMemo(){
    var f  = document.relationLincusMemo;
    if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
    	
        if(!f.memo.value){
            alert("메모를 입력하셔야 합니다.");
            return;
        }else{
        	f.memo.value = $('#lincusMemoAdd').get(0).value+"\n\n"+f.memo.value
        	ON_SUBMIT_PROCESS = true;
            $('#relationLincusMemo').block({});
            
            $.ajax({
                type: "POST",
                url: "/brc/lincuscontact/insert.json",
                cache:false,
                dataType: "json",
                async: false,
                data: $(f).serializeArray() ,
                success: function(data){
                    if(data.result == 'success'){
                    	//openerReload();
                    	//opener.location.reload();
                    	alert("정상적으로 등록 되었습니다.");
                    	popupClose();
                    }else{
                        alert(data.message);
                    }
                    ON_SUBMIT_PROCESS = false;
                    $('#relationMemo').block({});
                }
             });
            
        }
    }
}

//table rowspan 
function tableRowSpanning2(Table, spanning_row_index){
    var RowspanTd = false;
    var RowspanText = false;
    var RowspanCount = 0;
    var Rows = $('tbody tr', Table);

    
    $.each(Rows, function() {
        var This = $('td', this)[spanning_row_index];
        var text = $(This).text();

        if(RowspanTd == false){
            RowspanTd = This;
            RowspanText = text;
            RowspanCount = 1;
        }else if(RowspanText != text){
            $(RowspanTd)
            .attr('rowSpan', RowspanCount);
            RowspanTd = This;
            RowspanText = text;
            RowspanCount = 1;
        }else{
            $(This).remove();
            RowspanCount++;
        }
    });
    // 반복 종료 후 마지막 rowspan 적용
    $(RowspanTd)
    .attr('rowSpan', RowspanCount);
}

$(function() {
	tableRowSpanning2($('table#allListTbl'),0);
	if(self==top)
    {
		resizeWin(960,screen.availHeight );
    }
	//$('#processLayer').hide(); 
	//$('#processBar').hide(); 
});
</script>
    
    
    
    
    
    
    