<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="false" pageEncoding="utf-8"%>
<jsp:useBean id="now" class="java.util.Date" />
<c:set var="searchCdStatus" value="${requestVO.getSearchCdStatus()}" />

<h1 class="pagename">스텝별 리스트</h1>
<div class="search_area">
	<form method="get" action="/brc/loanall/select" name="searchFrm">
		<fieldset>
			<input type="hidden" value="${param.page}" name="page">
			<input type="hidden" value="${param.sort}" name="sort">
			<legend>Legend</legend>
			<table border="0" cellspacing="0" class="search_table" summary="검색폼">
				<tbody>
					<tr>
						<td>
							<table border="0" cellspacing="0" class="search_table">
								<tr>
									<th>접수번호</th>
									<td><input type="text" class="s_text w90"
										name="searchNoReq" value="${requestVO.getSearchNoReq()}"></td>
									<th>고객명</th>
									<td><input type="text" class="s_text w70"
										name="searchNmCustom" value="${requestVO.getSearchNmCustom()}"></td>
									<th>주민번호</th>
									<td><input type="text" class="s_text w90"
										name="searchNoCustom" value="${requestVO.getSearchNoCustom()}"></td>
									<th>휴대전화</th>
									<td width="140px"><input type="text" class="s_text w30"
										name="searchNoTelMobile1"
										value="${requestVO.getSearchNoTelMobile1()}"> - <input
										type="text" class="s_text w30" name="searchNoTelMobile2"
										value="${requestVO.getSearchNoTelMobile2()}"> - <input
										type="text" class="s_text w30" name="searchNoTelMobile3"
										value="${requestVO.getSearchNoTelMobile3()}"></td>
									<th>접수처번호</th>
									<td>
										<input type="text" class="s_text w100" name="searchNoCooperate" value="${requestVO.getSearchNoCooperate()}"></td>
									<th>검색건수</th>
									<td>
										<input type="text" class="s_text w30" name="limit" value="${param.limit}"> 건
									</td>
									<td>
										<input type="submit" value="검 색" class="submit_icon search" /><a href="/brc/loanall/select">초기화</a>
									</td>
									<td>총 <fmt:formatNumber type="number"
											maxFractionDigits="3" value="${pageListPaginator.totalCount}" />
										건
										<c:if test="${misscall.cnMisscall > 0}">
											<div style="position: relative;">
												<div
													style="position: absolute; top: -15px; right: -20px; font-weight: bold; color: #FF0080">
													미스콜 ${misscall.cnMisscall} 건</div>
											</div>
										</c:if>										
									</td>
								</tr>
							</table>
							<table border="0" cellspacing="0" class="search_table">
								<tr>
									<th>접수상태</th>
									<td><select name="searchCdStatus" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<c:forEach items="${code710}" var="item">
												<option value="${item.code}"
													<c:if test="${item.code == requestVO.getSearchCdStatus()}">selected</c:if>>${item.text}</option>
											</c:forEach>
									</select></td>
									<th>접수경로</th>
									<td><select name="searchCdPath" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<c:forEach items="${code704}" var="item">
												<option value="${item.code}"
													<c:if test="${item.code == requestVO.getSearchCdPath()}">selected</c:if>>${item.text}</option>
											</c:forEach>
									</select></td>
									<th>상담자</th>
									<td><select name="searchIdScreen" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<c:forEach items="${codeUser}" var="item">
												<option value="${item.code}"
													<c:if test="${item.code == requestVO.getSearchIdScreen()}">selected</c:if>>${item.text}</option>
											</c:forEach>
									</select></td>
									<th>세이프키유무</th>
									<td width="140px">
										<select name="searchYnSafekey" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<option value="Yes"
												<c:if test="${'Yes' == requestVO.getSearchYnSafekey()}">selected</c:if>>SAFEKEY
												유</option>
											<option value="No"
												<c:if test="${'No' == requestVO.getSearchYnSafekey()}">selected</c:if>>SAFEKEY
												무</option>
										</select>
									</td>
									<th>판정결과</th>
 									<td>
										<select name="searchCdTactic" class="select">
												<option value="" style="background: #ffffff">전체</option>
												<option value="1"
													<c:if test="${'1' eq requestVO.getSearchCdTactic()}">selected</c:if>>승인가능</option>
												<option value="9"
													<c:if test="${'9' eq requestVO.getSearchCdTactic()}">selected</c:if>>승인불가</option>
										</select> 									
 									</td>
									<th>동의기관수</th>
									<td>
										<input type="text" class="s_text w30" name="searchCnSafekeyExt" value="${requestVO.getSearchCnSafekeyExt()}"> 건
									</td>	
									<th>모집분류</th>
									<td>
										<select name="searchCdRecruitGroup" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<c:forEach items="${code719}" var="item">
												<option value="${item.code}"
													<c:if test="${item.code == requestVO.getSearchCdRecruitGroup()}">selected</c:if>>${item.text}</option>
											</c:forEach>
										</select>
									</td>	
									<th>중개영업대상유무</th>
									<td width="140px">
										<select name="searchYnReSale" class="select">
											<option value="" style="background: #ffffff">전체</option>
											<option value="Y" <c:if test="${'Y' == requestVO.getSearchYnReSale()}">selected</c:if>>유</option>
											<option value="N" <c:if test="${'N' == requestVO.getSearchYnReSale()}">selected</c:if>>무</option>
										</select>
									</td>																								
								</tr>
							</table>
							<table border="0" cellspacing="0" class="search_table">
								<tr>								
									<th>범위</th>
									<td width="450px">
									<select name="searchDmColumn" class="select">
											<option value="" style="background: #ffffff">일자</option>
											<option value="dmContact"
												<c:if test="${requestVO.getSearchDmColumn() == 'dmContact'}">selected</c:if>>최종접촉일</option>
											<option value="dmReceive"
												<c:if test="${requestVO.getSearchDmColumn() == 'dmReceive'}">selected</c:if>>접수일</option>
											<option value="dmScreen"
												<c:if test="${requestVO.getSearchDmColumn() == 'dmScreen'}">selected</c:if>>상담완료일</option>
											<option value="dmReject"
												<c:if test="${requestVO.getSearchDmColumn() == 'dmReject'}">selected</c:if>>거절일</option>
									</select>									
										<input type="text" class="s_text w70" value="${requestVO.getSearchDmStart()}" name="searchDmStart" id="searchDmStart">&nbsp; 
										<a onclick="$('#searchDmStart').focus();" href="#"><img align="absmiddle" src="/images/icon/calendar.gif"></a>~
										<input type="text" class="s_text w70" value="${requestVO.getSearchDmEnd()}" name="searchDmEnd" id="searchDmEnd">&nbsp; 
										<a onclick="$('#searchDmEnd').focus();" href="#"><img src="/images/icon/calendar.gif"></a>
										<a href="#" onclick="setSearchDm(-1)">전일</a>&nbsp; <a href="#" onclick="setSearchDm(0)">당일</a>										
									</td>
								</tr>
							</table>							
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
<div class="pt10">
	<ul class="tab_menu">
		<li <c:if test="${empty param.searchCdStatus }">class="selected"</c:if>  style="margin-right: 10px;"><a  href="#"  onclick="changeTabBrcAll('')">전체</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71001' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71001)">대기(${statusCount.cnt71001})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71002' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71002)">접수(${statusCount.cnt71002})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71003' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71003)">상담중(${statusCount.cnt71003})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71009' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71009)">보류</a></li>
        <li <c:if test="${param.searchCdStatus eq  '71010' }">class="selected"</c:if>  style="margin-right: 10px;"><a href="#" onclick="changeTabBrcAll('71010')">익일영업</a></li>
        
		<li <c:if test="${param.searchCdStatus eq  '71006' }">class="selected"</c:if>><a href="#" onclick="changeTabBrcAll(71006)">재영업대상(${statusCount.cnt71006})</a></li></li>
		<li <c:if test="${param.searchCdStatus eq  '71004' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71004)">상담완료(${statusCount.cnt71004})</a>
		<li <c:if test="${param.searchCdStatus eq  '71005' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71005)">상담종료</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71007' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71007)">거절</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71008' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71008)">취소</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71011' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll('71011')">허위접수</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71012' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll('71012')">삭제</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71013' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll('71013')">중개(${statusCount.cnt71013})</a></li>
	</ul>
	<div style="position: relative;">
		<div style="position: absolute; top: -20px; right: 50px">
			<table border="0" class="search_btn_tbl" summary="확장검색">
				<tbody>
					<tr>
						<td style="font-weight: bold"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd " /> 누적 총 ${statusCount.cntToday}건</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<form method="post" action="/brc/loanall/updatebatch" name="updateBatchFrm" >
	<input type="hidden" name="updateKind" value="" />
	<input type="hidden" name="searchCdStatus" value="${param.searchCdStatus}" />
	<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl2" style="border-top:0px;margin-top:10px;">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="allChecked(this)"></th>
				<th>접수번호</th>
				<th>접수경로</th>
				<th>대출과목</th>
				<th>광고구분</th>
				<th>광고키워드</th>
				<th>접속구분</th>
				<th>모집분류</th>
				<th>고객명</th>
				<th>생년/성별</th>
				<th>SAFEKEY</th>
				<th>동의기관수</th>
				<th>신청금액</th>
				<th>상태</th>
				<c:if test="${ '71004' eq param.searchCdStatus || '71005' eq param.searchCdStatus}" ><th>실행건수</th></c:if>
				<th>등록자</th>
				<th>상담자</th>
				<th>메모</th>
				<th>ASS등급</th>
				<th>판정결과</th>
				<th><a href="#" onclick="listSort('DM_CONTACT','DESC')">최종접촉일시<c:if test="${'DM_CONTACT' eq param.sort }">▼</c:if></a></th>
				<th><a href="#" onclick="listSort('NO','DESC')">접수일시<c:if test="${'NO' eq param.sort || empty param.sort }">▼</c:if></a> </th>
				<c:if test="${fn:contains( '71007,71008',searchCdStatus)}" >
                <th>거절일시</th>
                </c:if>
			</tr>
		</thead>
		<tbody>
		    <c:set var="countNo" value="${pageListPaginator.totalCount - (pageListPaginator.startRow-1)}" />
			<c:forEach items="${pageList}" var="item" varStatus="itemStatus">
                <c:set var="bgcolor" value="#ffffff" />
                <c:if test="${'71002' eq requestVO.getSearchCdStatus() and item.receiveDiff > 20}">
                    <c:set var="bgcolor" value="#FFC19E" />
                </c:if>
               <tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'">
				<td><input type="checkbox" name="updateBatchNo" value="${item.noReq}"></td>
				<td>${item.noReq}</td>
				<td>${item.cdPath}</td>
				<td>${item.cdPdt}</td>
				<td>${item.cdEportal}</td>
				<td>${item.nmEkeyword}</td>
				<td>${item.cdEpath}</td>
				<td>${item.cdRecruitGroup}</td>
				<td><a target="_blank" href="/brc/loan/select?searchNoReq=${item.noReq}">${item.nmCustom}</a> </td>
				<td>${fn:substring(item.noCustom,0,2)}
				<c:if test="${!empty item.noSex}">
                    <c:if test="${'1' eq item.noSex  || '3' eq  item.noSex}">/남</c:if>
                    <c:if test="${'2' eq item.noSex  || '4' eq  item.noSex}">/여</c:if>
                </c:if>  </td>
				<td>${empty item.dsNiceSafekey ? '' : '유'}</td>
				<td>${item.cnSafekeyExt}</td>
				<td>${item.amCustom}만원</td>
				<td>${item.cdStatus}</td>
				<c:if test="${ '71004' eq param.searchCdStatus || '71005' eq param.searchCdStatus}" ><td>${item.bexCount}건</td></c:if>
				<td>${item.idReceive}</td>
				<td>${item.idScreen}</td>
				<td>
				    <%/* 메모출력 시작 */%>
                      <c:set var="memo" value="" />
                      <c:forEach items="${contactList}" var="item02">
                          <c:if test="${item.noReq eq item02.noReq}">
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
                              <a title="${memo}" class="memo_tooltip" href="#"><img src="/images/icon/comments.png"></a>
                          </c:otherwise> 
                      </c:choose>
                      <%/* 메모출력 끝 */%>
				</td>
				<td>${item.dsAssRank}</td>
				<td>${item.cdTactic}</td>
				<td>${item.dmContact}</td>
                <td>${item.dmReceive}</td>
                <c:if test="${fn:contains('71007,71008',searchCdStatus)}" >
                 <td>${item.dmReject}</td>
                </c:if>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<table border="0" cellspacing="0" id="updateBatchBtn">
		<tbody>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td>
				<select name="updateCdStatus" class="select" onchange="changeListCdStatus(this.value)">
	                   <option value="" style="background:#ffffff">접수상태변경</option>
	                   <c:forEach items="${code710}" var="item">
	                        <option value="${item.code}"  >${item.text}</option>
	                   </c:forEach>
	            </select>
	            <!-- 상태변경사유 -->
                <span id="addSelCdReject" style="display:none" >
                <select name="updateCdReject" id="cdReject">
                    <option value="" style="background:#ffffff">선 택</option>
                    <c:forEach var="item" items="${code132}">
                        <option value="${item.code}">${item.text}</option>
                    </c:forEach>
                </select>
                </span>
                <span id="addSelCdCancel" style="display:none"  >
                <select name="updateCdCancel" id="cdCancel">
                    <option value="" style="background:#ffffff">선 택</option>
                    <c:forEach var="item" items="${code131}">
                        <option value="${item.code}">${item.text}</option>
                    </c:forEach>
                </select>
                </span>
                                
				<select name="updateIdScreen" class="select">
                     <option value="" style="background:#ffffff">상담자변경</option>
                     <c:forEach items="${codeUser}" var="item">
                          <option value="${item.code}"  >${item.text}</option>
                     </c:forEach>
                 </select>
				<span class="btn_pack medium icon"><span class="check"></span><input type="button" onclick="chkUpdateBatchSubmit()" value="변경" id="submitBtn"></span>
				<span id="resultMsg" class="resultMsg">처리되었습니다.</span>
				</td>
			</tr>
			<c:if test="${'71005' eq requestVO.getSearchCdStatus()}">
			<tr>
				<td>
				<select name="excuteCdCooperate" class="select">
	                   <option value="" style="background:#ffffff">거래처 심사요청</option>
	                   <c:forEach items="${code703}" var="item">
	                        <option value="${item.code}"  >${item.text}</option>
	                   </c:forEach>
	            </select>
				<span class="btn_pack medium icon"><span class="check"></span><input type="button" onclick="chkExcuteBatchSubmit()" value="심사요청" id="submitBtn"></span>
				<span id="resultMsg" class="resultMsg">처리되었습니다.</span>
				</td>
			</tr>
	       </c:if>			
		</tbody>
	</table>
	</form>
	<jsp:include page="../include/paginator.jsp" flush="false" />
</div>
<script type="text/javascript">
function allChecked(obj){
	$("input[name=updateBatchNo]:checkbox").each(function() {
        $(this).attr("checked", obj.checked);
    });
}
function setSearchDm(day){
    var f = document.searchFrm;
    var day = getDate(day);
    f.searchDmStart.value =  day;
    f.searchDmEnd.value=day;
 }
 
function chkExcuteBatchSubmit(){
	 var f  = document.updateBatchFrm;
	 var resultMsg;
	 var excuteCnt = 0;
	 f.updateKind.value = "bex";
	 if(f.excuteCdCooperate.value == ""){
		 alert("실행할 거래처를 선택하셔야 합니다.");
		 return;
	 }
	 isChecked = false;
	 $("input[name=updateBatchNo]:checked").each(function() {
         isChecked = true;
         excuteCnt = excuteCnt + 1;
         return;
     });
	 if(!isChecked){
		 alert("최소한 1개 이상 선택하셔야 합니다.");
         return ;
	 }else{
				if(!confirm("총 " + excuteCnt +"건 실행하시겠습니까?"))
				{
					return;
				}		 
			    if(ON_SUBMIT_PROCESS){
			        alert("실행중")
			    }else{
		            ON_SUBMIT_PROCESS = true;
		            $('#updateBatchBtn').block({});
		            $.ajax({
		                type: "POST",
		                url: "/brc/loanall/updatebatch",
		                cache:false,
		                dataType: "json",
		                async: false,
		                data: $(f).serializeArray() ,
		                success: function(data){
		                	resultMsg = data.message;
 		                    if(data.result == 'success'){

		                    }else{

		                    }
		                    ON_SUBMIT_PROCESS = false;
		                    $('#updateBatchBtn').unblock({});
		                }
		             });
			    }	
	 }
	 printInfo(resultMsg, true);
}
 
function chkUpdateBatchSubmit(){
	 var f  = document.updateBatchFrm;
	 f.updateKind.value = "brc";	 
	 if(f.updateCdStatus.value == "" && f.updateIdScreen.value == ""){
		 alert("변경할 항목을 선택하셔야 합니다.");
		 return;
	 }
	 if(f.updateCdStatus.value == "71007"  ){
		 if(!f.updateCdReject.value){
			 alert("거절사유를 선택하셔야 합니다.");
	         return;	 
		 }
     }
	 if(f.updateCdStatus.value == "71008"  ){
         if(!f.updateCdCancel.value){
             alert("취소사유를 선택하셔야 합니다.");
             return ;   
         }
     }
	 isChecked = false;
	 $("input[name=updateBatchNo]:checked").each(function() {
         isChecked = true;
         return;
     });
	 if(!isChecked){
		 alert("최소한 1개 이상 선택하셔야 합니다.");
         return ;
	 }else{
			    if(ON_SUBMIT_PROCESS){
			        alert("실행중")
			    }else{
		            ON_SUBMIT_PROCESS = true;
		            $('#updateBatchBtn').block({});
		            $.ajax({
		                type: "POST",
		                url: "/brc/loanall/updatebatch",
		                cache:false,
		                dataType: "json",
		                async: false,
		                data: $(f).serializeArray() ,
		                success: function(data){
		                    if(data.result == 'success'){
		                    	document.location.reload();
		                    }else{
		                        alert(data.message);
		                    }
		                    ON_SUBMIT_PROCESS = false;
		                    $('#updateBatchBtn').unblock({});
		                }
		             });
			    }
			
	 }
 }

 
 $(function() {
	$("#searchDmStart").datepicker(CALENDAR_SET);
	$("#searchDmEnd").datepicker(CALENDAR_SET);
	$( ".memo_tooltip" ).tooltip({
		show: null,
		hide: null,
		position: {
		my: "left top",
		at: "left bottom"
		},
		open: function( event, ui ) {
		//ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
		},
		content: function() {
		return $(this).attr('title');
		}
    });
});
function listSort(sort,dir){
    var f = document.searchFrm;
    f.sort.value = sort; 
    f.dir.value = dir;
    f.submit();
}
//탭검색
function changeTabBrcAll(cdStatus){
    var f = document.searchFrm;
    f.searchCdStatus.value = cdStatus;
    f.page.value = "1";
    f.submit();
}
//상태변경시 2차 콤보박스 셋팅 - 일괄변경
function changeListCdStatus(sel){
    $("#addSelCdReject").hide();
    $("#addSelCdCancel").hide();
    if(sel == "71007"){ // 거절 
        $("#addSelCdReject").show();
    }else if(sel == "71008"){ // 취소 
        $("#addSelCdCancel").show();
    }
}
</script>



<c:choose>
     <c:when test="${fn:contains('71001,71002,71003,71004,71007,71009,71010,71011,71013',searchCdStatus) and !empty searchCdStatus}">
       <c:if test="${fn:contains( '71001',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71002,71006,71009,71010,71011,71012')});</script>
       </c:if>
       <c:if test="${fn:contains('71002,71003',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71007,71006,71008,71009,71010,71011,71012')});</script>
       </c:if>
       <c:if test="${fn:contains('71007',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71005')});</script>
       </c:if>       
       <c:if test="${fn:contains('71009,71010',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71003,71006,71007,71008,71009,71010')});</script>
       </c:if>
       <c:if test="${fn:contains( '71011',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71008,71012')});</script>
	  </c:if>
       <c:if test="${fn:contains( '71004',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71005')});</script>
       </c:if>
       <c:if test="${fn:contains('71013',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71003,71004,71007,71008,71009,71010,71012')});</script>
       </c:if>       
     </c:when>
    <c:otherwise>
          <script> $(function(){ resetOptions('updateCdStatus','')});</script>
    </c:otherwise>
</c:choose>
   
