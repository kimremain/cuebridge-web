<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">대출심사현황</h1>
	<div class="search_area">
		<form method="get" action="/bex/master/select" name="searchFrm">
			<fieldset>
				<input type="hidden" value="" name="page">
				<legend>Legend</legend>
				<table border="0" cellspacing="0" class="search_table" summary="검색폼">
					<tbody>
						<tr>
							<td>
                            <select name="searchCdPath" class="select"  >
                                    <option value="" style="background:#ffffff">접수경로</option>
                                    <c:forEach items="${code704}" var="item">
                                         <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchCdPath()}">selected</c:if> >${item.text}</option>
                                    </c:forEach>
                                </select>
                            </td>
                              <td>
                            <select name="searchCdCooperate" class="select"  >
                                    <option value="" style="background:#ffffff">심사업체</option>
                                    <c:forEach items="${code703}" var="item">
                                         <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchCdCooperate()}">selected</c:if> >${item.text}</option>
                                    </c:forEach>
                                </select>
                            </td>
							<th>심사요청일</th>
							<td><input type="text" class="s_text w70" value="${requestVO.getSearchDmRegStart()}" name="searchDmRegStart" id="searchDmRegStart" class="dateCalendarInput">&nbsp;
							      <a onclick="$('#searchDmRegStart').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
							<td><input type="text" class="s_text w70" value="${requestVO.getSearchDmRegEnd()}" name="searchDmRegEnd" id="searchDmRegEnd">&nbsp;
							      <a onclick="$('#searchDmRegEnd').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
							<th>기표변경일</th>
							<td>
							      <input type="text" class="s_text w70" value="${requestVO.getSearchDmCooperteStart()}" name="searchDmCooperteStart" id="searchDmCooperteStart">&nbsp;
							      <a onclick="$('#searchDmCooperteStart').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
							<td>
							      <input type="text" class="s_text w70" value="${requestVO.getSearchDmCooperteEnd()}" name="searchDmCooperteEnd" id="searchDmCooperteEnd">&nbsp;
							      <a onclick="$('#searchDmCooperteEnd').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
						    
							<td style="padding-left: 10px">
							<input type="submit" value="검 색" class="submit_icon search"  />
							</td>
							<td style="padding-left: 10px"><a href="#" onclick="formReset();return false;">초기화</a></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	<div class="pt10">
		<table border="0" cellspacing="0" style="width: 1500px;margin-bottom:100px" id="sort_table" class="basic_tbl" >
			<thead>
				<tr>
					<th data-sort="string">번호</th>
					<th>접수번호</th>
					<th data-sort="string">실행번호</th>
					<th data-sort="string">고객명</th>
					<th data-sort="string">접수경로</th>
					<th data-sort="string">대출상품</th>
					<th data-sort="string">상담자</th>
					<th data-sort="string">접수일시</th>
					<th data-sort="string">심사요청일시</th>
					<th data-sort="int" width="80">신청금액(만원)</th>
					<th data-sort="string">심사업체</th>
					<th data-sort="string">접수위치</th>
					<th data-sort="string">심사상품</th>
					<th data-sort="string">심사상태</th>
					<th data-sort="int" width="80">승인예정금액(만원)</th>
					<th data-sort="int" width="80">승인금액(만원)</th>
					<th data-sort="string">기표변경일시</th>
					<th data-sort="string">심사메모</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="countNo" value="${masterList.size()}" />
			    <c:set var="bgcolor" value="#ffffff" />
				<c:forEach items="${masterList}" var="row" varStatus="rowStatus">
	                 <c:if test="${row.noReq ne historyNoReq}">
	                        <c:choose> 
	                            <c:when test="${'#EEFFFF' eq bgcolor}"> 
	                                <c:set var="bgcolor" value="#ffffff" />
	                            </c:when> 
	                            <c:when test="${'#ffffff' eq bgcolor}"> 
	                                <c:set var="bgcolor" value="#EEFFFF" />
	                            </c:when> 
	                        </c:choose>
	                 </c:if>
	                 <c:set var="historyNoReq" value="${row.noReq}" />
					<tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#D6DAEB'">
						<td>${countNo}</td>
						<td>${row.noReq}</td>
						<td>${row.noEx}</td>
						<td><a href="/brc/loan/select?searchNoReq=${row.noReq}" target="_blank">${row.nmCustom}</a></td>
						<td>${row.cdPath}</td>
						<td>${row.nmPdt}</td>
						<td>${row.idScreen}</td>
						<td>${row.dmReceive}</td>
						<td>${row.dmReg}</td>
						<td>${row.amApp}</td>
						<td>${row.cdCooperate}</td>
						<td>${row.nmScreenPath}</td>
						<td>${row.nmBexPdt}</td>
						<td>${row.nmScreen}</td>
						<td>${row.amCooperateExpect > 0 ? row.amCooperateExpect : ''}</td>
						<td>${row.amCooperate > 0 ? row.amCooperate : ''}</td>
						<td>${row.dmUpt}</td>
						<td>
	                       <c:choose> 
	                            <c:when test="${row.contactCnt > 0}"> 
	                                <a title="${row.dsCooperate}" class="memo_tooltip" href="#"><img src="/images/icon/comments.png" /></a>
	                                <a href="#" onclick="bexMemoStory('${row.noReq}','${row.noEx}')" >(내역)</a>
	                            </c:when> 
	                            <c:otherwise> 
	                                <img src="/images/icon/comments_gray.png">
	                            </c:otherwise> 
	                        </c:choose>
	                       
	                    </td>
					</tr>
					<c:set var="countNo" value="${countNo-1}" />
	            </c:forEach>
			</tbody>
			<tfoot>
				<tr style="display: none;">
					<td colspan="10">No rows match the filter...</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<style>
.alt{font-weight:bold;color:red}
.alt *{font-weight:bold;color:red}
</style>
<script src="/js/jquery.filtertable.js" type="text/javascript"></script>
<script src="/js/stupidtable.min.js" type="text/javascript"></script>
<script type="text/javascript">

	$(function() {
		// calendar
		$("#searchDmRegStart").datepicker(CALENDAR_SET);
        $("#searchDmRegEnd").datepicker(CALENDAR_SET);
        $("#searchDmCooperteStart").datepicker(CALENDAR_SET);
        $("#searchDmCooperteEnd").datepicker(CALENDAR_SET);
        
        // rowspan 
       // tableRowSpanning($('table#sort_table'), 1)
		// filter table 
		$('#sort_table').filterTable();

		// sort table 
		strupidtableSetting("sort_table");

		$(".memo_tooltip").tooltip({
			show : null,
			hide : null,
			position : {
				my : "left top",
				at : "left bottom"
			},
			open : function(event, ui) {
				//ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
			},
			content : function() {
				return $(this).attr('title');
			}
		});
	});
	
	function formReset(){
		var f = document.searchFrm;
		f.reset();
		f.searchDmRegStart.value = "";
		f.searchDmRegEnd.value = "";
		f.searchDmCooperteStart.value = "";
        f.searchDmCooperteEnd.value = "";
		
	}

</script>