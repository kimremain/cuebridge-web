<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div style="border: 1px solid #aaaaaa; padding: 10px 0 10px 0"
	class="search_table" id="search_table">
	<form method="post" action="/brc/loan/select" name="searchFrm">
	<input type="hidden" name="searchCdStatus" value="${param.searchCdStatus}">
	<input type="hidden" value="${requestVO.page}" name="page">
    <input type="hidden" value="${requestVO.sort}" name="sort">
		<fieldset>
			<legend>Legend</legend>
			<table border="0" cellspacing="0" summary="검색폼">
				<tbody>
					<tr>
 						<th>고객명</th>
						<td><input type="text" class="s_text w70" value="${requestVO.searchNmCustom}" name="searchNmCustom"></td>
						<th>주민번호</th>
						<td><input type="text" class="s_text w70" value="${requestVO.searchNoCustom}" name="searchNoCustom"></td>
						<th>휴대폰</th>
						<td><input type="text" class="s_text w70" value="${requestVO.searchNoTelMobile}" name="searchNoTelMobile"></td>
						<td style="padding-left: 10px"><span class="btn_pack medium"><input type="submit" value="검 색"></span></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
<div style="padding-top: 10px;">
	<ul class="tab_menu">
		<li <c:if test="${param.searchCdStatus eq  '71002' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71002)">접수(${brcLoanCount.cnt71002})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71003' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71003)">상담중(${brcLoanCount.cnt71003})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71004' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71004)">상담완료(${brcLoanCount.cnt71004})</a>
		<li <c:if test="${param.searchCdStatus eq  '71005' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71005)">상담종료</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71006' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71006)">재영업대상(${brcLoanCount.cnt71006})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71007' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71007)">거절</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71009' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71009)">보류(${brcLoanCount.cnt71009})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71010' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71010)">익일영업(${brcLoanCount.cnt71010})</a></li>
		<li <c:if test="${param.searchCdStatus eq  '71013' }">class="selected"</c:if> ><a href="#" onclick="changeTabBrcAll(71013)">중개(${brcLoanCount.cnt71013})</a></li>
	</ul>
	<form method="post" action="/brc/loan/updatebatch" name="updateBatchFrm" onsubmit="return chkUpdateBachSubmit(this)">
	<input type="hidden" name="searchCdStatus" value="${param.searchCdStatus}">
	<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="allChecked(this)"></th>
				<th>접수번호</th>			
				<th>고객명</th>
				<th>휴대폰</th>
				<th>접수자</th>
				<th>심사자</th>
				<th>약속시간</th>
				<th>메모</th>
				<th>최종메모일</th>
				<th>접수경로</th>
				<th>접속구분</th>
				<th>신청금액</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="countNo" value="${pageListPaginator.totalCount - (pageListPaginator.startRow-1)}" />
			<c:forEach items="${pageList}" var="brcLoanList">
			<tr bgcolor="#ffffff"
				onmouseout="this.style.backgroundColor='#ffffff'"
				onmouseover="this.style.backgroundColor='#EAECF5'">
				<td><input type="checkbox" name="updateBatchNo" value="${brcLoanList.noReq}"></td>
				<td>${brcLoanList.noReq}</td>				
				<td><a href="/brc/loan/select?searchNoReq=${brcLoanList.noReq}">${brcLoanList.nmCustom}</a></td>				
				<td>${brcLoanList.noTelMobile}</td>
				<td>${brcLoanList.idReceive}</td>
				<td>${brcLoanList.idScreen}</td>
				<td>${brcLoanList.dmPromise}</td>
				<td>
					<c:set var="memo" value="" />
					<c:forEach items="${brcContactList}" var="brcContactList">
					    <c:if test="${brcLoanList.noReq eq brcContactList.noReq}">
					        <c:set var="memo" value="${memo} 
                                 <div class='memo_area'><div class='memo_tlt'>[${brcContactList.nmReg} - ${empty brcContactList.dmUpt ?  brcContactList.dmReg  : brcContactList.dmUpt}]</div>
                                 <div class='memo_desc'>${brcContactList.dsMemo}</div></div>"  /> 
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
				</td>
				<td>${brcLoanList.dmContact}</td>
				<td>${brcLoanList.cdPath}</td>
				<td>${brcLoanList.cdEpath}</td>
				<td>${brcLoanList.amCustom}</td>
				<td>${brcLoanList.nmStatus}</td>
			</tr>
			<c:set var="countNo" value="${countNo-1}" />
			</c:forEach>
		</tbody>
	</table>
	<table border="0" cellspacing="0">
		<tbody>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td>
					<div class="item">					
						<select name="updateCdStatus" class="select" onchange="changeListCdStatus(this.value)">
			                   <option value="" style="background:#ffffff">접수상태변경</option>
							<c:forEach var="item" items="${code710}" >
								<c:if test="${item.code ne '71001' && item.code ne '71001'}">
								<option value="${item.code}">${item.text}</option>					
								</c:if>		
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
						<select name="updateIdScreen"  data-validation="required">
							<option value="">상담자 변경</option>
							<c:forEach var="item" items="${screenList}" >
								<option value="${item.code}">${item.text}</option>			
							</c:forEach>														
						</select> 				
						<span class="btn_pack medium icon"><span class="check"></span>
						<input type="submit" value="변경" id="submitBtn"></span>				
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	</form>
	
	<jsp:include page="../include/paginator.jsp" flush="false" />
	
<!-- 	<div class="paginate_regular">
		<a class="direction" href="#"><span>‹</span> 이전</a> <a href="#">11</a>
		<strong>12</strong> <a href="#">13</a> <a href="#">14</a> <a href="#">15</a>
		<a href="#">16</a> <a href="#">17</a> <a href="#">18</a> <a href="#">19</a>
		<a href="#">20</a> <a class="direction" href="#">다음 <span>›</span></a>
	</div> -->
</div>

<script type="text/javascript">
function allChecked(obj){
	$("input[name=updateBatchNo]:checkbox").each(function() {
        $(this).attr("checked", obj.checked);
    });
}
function chkUpdateBachSubmit(f){
	 if(f.updateCdStatus.value == "" && f.updateIdScreen.value == ""){
		 alert("변경할 항목을 선택하셔야 합니다.");
		 return false;
	 }
	 if(f.updateCdStatus.value == "71007"  ){
		 if(!f.updateCdReject.value){
			 alert("거절사유를 선택하셔야 합니다.");
	         return false;	 
		 }
     }
	 if(f.updateCdStatus.value == "71008"  ){
         if(!f.updateCdCancel.value){
             alert("취소사유를 선택하셔야 합니다.");
             return false;   
         }
     }	 
	 isChecked = false;
	 $("input[name=updateBatchNo]:checked").each(function() {
        isChecked = true;
        return false;
    });
	 if(!isChecked){
		 alert("최소한 1개 이상 선택하셔야 합니다.");
        return false;
	 }else{
		 return true;
	 }
	 
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
//탭검색
function changeTabBrcAll(cdStatus){
    var f = document.searchFrm;
    f.searchCdStatus.value = cdStatus;
    f.page.value = "1";
    f.submit();
}
</script>

<c:set var="searchCdStatus" value="${requestVO.getSearchCdStatus()}" />
<c:choose>
     <c:when test="${fn:contains('71001,71002,71003,71004,71005,71007,71009,71010,71011,71013',searchCdStatus) and !empty searchCdStatus}">
           <c:if test="${fn:contains( '71001',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71002,71009,71010,71011,71012')});</script>
       </c:if>
       <c:if test="${fn:contains('71002,71003',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71007,71008,71009,71010,71011,71012')});</script>
       </c:if>
       <c:if test="${fn:contains('71007',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71005')});</script>
       </c:if>       
       <c:if test="${fn:contains('71009,71010',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71003,71007,71008,71009,71010')});</script>
       </c:if>
       <c:if test="${fn:contains( '71011',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71008,71012')});</script>
           </c:if>
       <c:if test="${fn:contains( '71004,71005',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71006')});</script>
       </c:if>
       <c:if test="${fn:contains('71013',searchCdStatus)}" >
           <script> $(function(){ resetOptions('updateCdStatus','71003,71004,71007,71008,71009,71010,71012')});</script>
       </c:if>
     </c:when>
    <c:otherwise>
          <script> $(function(){ resetOptions('updateCdStatus','')});</script>
    </c:otherwise>
</c:choose>
