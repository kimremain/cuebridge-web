<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="false" pageEncoding="utf-8"%>

<h1 class="pagename">약속자 리스트</h1>
<div class="search_area">
	<form method="get" action="/brc/promise/select" name="searchFrm">
		<fieldset>
			<input type="hidden" value="" name="page">
			<legend>Legend</legend>
			<table border="0" cellspacing="0" class="search_table" summary="검색폼">
				<tbody>
					<tr>
						<td>
						<select name="searchIdScreen" class="select">
							<option value="" style="background:#ffffff">상담자</option>
							<c:forEach items="${userCode}" var="item">
                                 <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchIdScreen()}">selected</c:if> >${item.text}</option>
                            </c:forEach>
						</select>
						</td>
						<td>약속일</td>
						<td><input type="text" class="s_text w70" value="${requestVO.getSearchDmPromiseStart()}" name="searchDmPromiseStart" id="searchDmPromiseStart">&nbsp; 
						<a onclick="$('#searchDmPromiseStart').focus();" href="#"><img align="absmiddle" src="/images/icon/calendar.gif"></a>~</td>
						<td><input type="text" class="s_text w70" value="${requestVO.getSearchDmPromiseEnd()}" name="searchDmPromiseEnd" id="searchDmPromiseEnd">&nbsp;
						<a onclick="$('#searchDmPromiseEnd').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
						<th>고객명</th>
						<td><input type="text" class="s_text w70" name="searchNmCustom" value="${requestVO.getSearchNmCustom()}"></td>
						<th>주민번호</th>
						<td><input type="text" class="s_text w70" name="searchNoCustom" value="${requestVO.getSearchNoCustom()}"></td>
						<td style="padding-left: 10px"><span class="btn_icon search"><a href="#" onclick="document.searchFrm.submit();">검 색</a></span></td>
						<td style="padding-left: 10px"><a href="/brc/promise/select">초기화</a></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
<div class="pt10">
	<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl2">
		<thead>
			<tr>
				<th>번호</th>
				<th>약속시간</th>
				<th>등록자</th>
				<th>상담자</th>
				<th>고객명</th>
				<th>신청금액</th>
				<th>상태</th>
				<th>메모</th>
				<th>최종메모일</th>
				<th>접수일시</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="countNo" value="${pageListPaginator.totalCount - (pageListPaginator.startRow-1)}" />
		    <c:forEach items="${pageList}" var="row" varStatus="rowStatus">
				<tr bgcolor="#ffffff"
					onmouseout="this.style.backgroundColor='#ffffff'"
					onmouseover="this.style.backgroundColor='#EAECF5'">
					<td>${countNo}</td>
					<td>${row.dmPromise}</td>
					<td>${row.idReceive}</td>
					<td>${row.idScreen}</td>
					<td><a target="_blank" href="/brc/loan/select?searchNoReq=${row.noReq}">${row.nmCustom}</a></td>
					<td>${row.amApp}만원</td>
					<td>${row.cdStatus}</td>
					<td>
					    <%/* 메모출력 시작 */%>
                        <c:set var="memo" value="" />
                        <c:forEach items="${contactList}" var="item02">
                            <c:if test="${row.noReq eq item02.noReq}">
                                <c:set var="memo" value="${memo} 
                                 <div class='memo_area'><div class='memo_tlt'>[${item02.nmReg} - ${item02.dmReg}]</div>
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
					</td>
					<td>${row.dmContact}</td>
					<td>${row.dmReceive}</td>
				</tr>
		 	<c:set var="countNo" value="${countNo-1}" /> 	
			</c:forEach>
		</tbody>
	</table>
	 <jsp:include page="../include/paginator.jsp" flush="false" />
</div>



<script type="text/javascript">
 $(function() {
	$( "#searchDmPromiseStart" ).datepicker(CALENDAR_SET);
	$( "#searchDmPromiseEnd" ).datepicker(CALENDAR_SET);

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
</script>







