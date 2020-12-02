<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<div id="fix_cont">
	<h1 class="pagename">IVR 미스콜 관리</h1>
	<div class="search_area">
		<form method="get" action="/brc/misscall/select" name="searchFrm" id="searchFrm" onsubmit="return search()">
			<fieldset>
				<input type="hidden" value="${requestVO.searchMode }" name="searchMode">
				<input type="hidden" value="${pageListPaginator.page }" name="page">
				<legend></legend>
				<table border="0" cellspacing="0" class="search_table" summary="검색폼">
					<tbody>
						<tr>
				            <td>
                                <select name="searchCdCallProc" class="select"  >
                                  <option value="" style="background:#ffffff">처리상태</option>
                                  <c:forEach items="${code715}" var="item">
                                       <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchCdCallProc()}">selected</c:if> >${item.text}</option>
                                  </c:forEach>
                            </select>
                            </td>      
						    <th>수신전화번호</th>
                            <td><input type="text" class="s_text w90" name="searchNoTel" value="${requestVO.getSearchNoTel() }"></td>
                            <th>일자</th>
                            <td><input type="text" class="s_text w70" value="${requestVO.getSearchDmRegStart()}" name="searchDmRegStart" id="searchDmRegStart">&nbsp; 
                                <a onclick="$('#searchDmRegStart').focus();" href="#"><img align="absmiddle" src="/images/icon/calendar.gif"></a>~</td>
                            <td><input type="text" class="s_text w70" value="${requestVO.getSearchDmRegEnd()}" name="searchDmRegEnd" id="searchDmRegEnd">&nbsp;
                                <a onclick="$('#searchDmRegEnd').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
							<td style="padding-left: 10px">
							    <span class="btn_pack medium"><input type="submit" value="검 색"></span></td>
		                     <td><a href="/brc/misscall/select?searchMode=history">초기화</a>
							 <td>총 <fmt:formatNumber type="number"  maxFractionDigits="3" value="${pageListPaginator.totalCount}" /> 건</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	
	
	<div class="pt10">
	   <ul class="tab_menu">
	        <li><a  href="/brc/misscall/select">미스콜 접수대상</a></li>
	        <li class="selected"><a href="#">미스콜 히스토리</a></li>
	    </ul>
		<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl" style="border-top:0px;margin-top:10px;">
			<thead>
				<tr>
					<th width="50">번호</th>
					<th width="150">수신전화번호</th>
					<th width="150">수신일시</th>
					<th width="150">처리상태</th>	
					<th width="150">처리자</th>	
					<th width="150">처리일시</th>	
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="countNo" value="${pageListPaginator.totalCount - (pageListPaginator.startRow-1)}" />
				<c:forEach items="${pageList}" var="list">
					<tr bgcolor="#ffffff"
						onmouseout="this.style.backgroundColor='#ffffff'"
						onmouseover="this.style.backgroundColor='#EAECF5'"
						style="background-color: rgb(255, 255, 255);">
						<td>${countNo}</td>
						<td>${list.noTel}</td>
						<td>${list.dmReg}</td>
						<td>${list.cdCallProc}</td>
						<td>${list.idUpt}</td>
						<td>${list.dmUpt}</td>
						<td>${list.dsRemk}</td>
					</tr>
					<c:set var="countNo" value="${countNo-1}" />
				</c:forEach>
			</tbody>
		</table>
     <jsp:include page="../include/paginator.jsp" flush="false" />
    </div>
</div>
<script src="/js/jquery.filtertable.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
    $("#searchDmRegStart").datepicker(CALENDAR_SET);
    $("#searchDmRegEnd").datepicker(CALENDAR_SET);
});
	
	/*
	function inputSelectUser(inputID,userID){
		$("#"+inputID).get(0).value = userID;
		$("#inputSelectUserLayer").hide();
		
	}
	function csvDown(){
		var f = document.searchFrm;
		f.logDsRemk.value= "${excelFileName}";
		f.action = "/st/userlog/excel";
		f.target = "_blank";
		f.submit();
		f.action = "/st/userlog/select";
        f.target = "";
	}
	function search(){
		var f = document.searchFrm;
		f.logDsRemk.value="";
		return true;
	}*/
</script>
