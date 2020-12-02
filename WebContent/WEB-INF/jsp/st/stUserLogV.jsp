<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<div id="fix_cont">
	<h1 class="pagename">사용자로그</h1>
	<div class="search_area">
		<form method="get" action="/st/userlog/select" name="searchFrm" id="searchFrm" onsubmit="return search()">
			<fieldset>
                <input type="hidden" name="logDsRemk" value="" />
				<input type="hidden" value="${pageListPaginator.page }" name="page">
				<legend></legend>
				<table border="0" cellspacing="0" class="search_table" summary="검색폼">
					<tbody>
						<tr>
							<td>
							 <select name="searchDsPgmId" class="select"  >
                                    <option value="" style="background:#ffffff">프로그램</option>
                                    <c:forEach items="${codePgm}" var="item">
                                         <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchDsPgmId()}">selected</c:if> >${item.text}</option>
                                    </c:forEach>
                                </select>
                             </td>
                             <td>
                             <select name="searchCdUserAction" class="select"  >
                                    <option value="" style="background:#ffffff">동작구분</option>
                                    <c:forEach items="${code700}" var="item">
                                         <option value="${item.code}"  <c:if test="${item.code == requestVO.getSearchCdUserAction()}">selected</c:if> >${item.text}</option>
                                    </c:forEach>
                                </select>
                             </td>
                             <th>사용자ID</th>
                            <td>
                        <style>
                        #sort_table td {width:60px;padding:2px 0 0 0;}
.alt{font-weight:bold;color:#369}
.alt *{font-weight:bold;color:#369}
                        </style>
                                <input type="text" name="searchIdUser" id="searchIdUser" class="s_text w100" value="${requestVO.searchIdUser}" onfocus="$('#inputSelectUserLayer').toggle();$('#filteruser').focus();">
                                 <div id="inputSelectUserLayer" style="position: relative;z-index:8000;display:none">
                                    <div style="position: absolute; top: 2px; left: 0px;background:#f2f2f2;border:2px solid #369;padding:5px;" >
		
								    <table border="0" cellspacing="0" style="width: 400px;margin-bottom:10px;table-layout:fixed" id="sort_table" >
								    <tbody>
								    <c:forEach items="${codeUser}" var="item" varStatus="status">
									    <c:if test="${status.index % 7 == 0}"><tr></c:if>
								        <td style="border:0px solid #000"><a href="#" onclick="inputSelectUser('searchIdUser','${item.code}')" >${item.text}</a></td>
								        <c:if test="${(status.index+1) % 7 == 0}"></tr></c:if>
								    </c:forEach>
								    </tbody>
								    <tfoot>
								       <tr style="display:none;">
								           <td colspan="7">No rows match the filter...</td>
								       </tr>
								   </tfoot>
								   </table>
								    </div>
								 </div>
                            </td>
							<th>등록일</th>
							<td>
								<input type="text" class="s_text w100" value="${requestVO.searchDmRegFrom}" name="searchDmRegFrom" id="searchDmRegFrom"> &nbsp;
								<a onclick="$('#searchDmRegFrom').focus();" href="#"><img align="absmiddle" src="/images/icon/calendar.gif"></a> ~ 
								<input type="text" class="s_text w100 " value="${requestVO.searchDmRegTo}" name="searchDmRegTo" id="searchDmRegTo"> &nbsp;
								<a onclick="$('#searchDmRegTo').focus();" href="#"><img src="/images/icon/calendar.gif"></a></td>
							<td style="padding-left: 10px">
							    <span class="btn_pack medium"><input type="submit" value="검 색"></span></td>
		                     <td style="padding-left: 10px"><span class="btn_icon xls"><a href="#" onclick="csvDown()" >CSV 다운로드</a></span></td>
		                     <td><a href="/st/userlog/select">초기화</a>
							 <td>총 ${pageListPaginator.totalCount} 건</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	
	
	<div class="pt10">
		<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl">
			<thead>
				<tr>
					<th>번호</th>
					<th>일련번호</th>
					<th>사용자</th>
					<th>접수번호</th>
					<th>프로그램명</th>
					<th>동작구분</th>
					<th>비고</th>
					<th>등록일시</th>
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
						<td>${list.idUser}-${list.noSeq}</td>
						<td>${list.nmUser}</td>
						<td>${list.noReq}</td>
						<td>${list.dsPgm}</td>
						<td>${list.cdUserAction}</td>
						<td>${list.dsRemk}</td>
						<td>${list.dmReg}</td>
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
		$("#searchDmRegFrom").datepicker(CALENDAR_SET);
		$("#searchDmRegTo").datepicker(CALENDAR_SET);
		
		$('#sort_table').filterTable({containerTag:'div',inputName:'filteruser',inputClass:'s_text_small'});
	});
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
	}
</script>
