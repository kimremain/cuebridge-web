<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" pageEncoding="utf-8"%>

<style>
.search_table td{line-height:25px;}
</style>
<h1 class="pagename">접수내역</h1>
<div class="search_area">
	<form method="post" action="/brc/excel/excel" name="excelFrm" target="_blank">
		<input type="hidden" name="logDsRemk" value="${excelFileName}" />
		<fieldset>
			<legend>Legend</legend>
			<table border="0" cellspacing="0" class="search_table" summary="검색폼">
				<tbody>

					<tr>
						<th>접수상태</th>
						<td>
                              <select name="cdStatus"  style="width:100px">
                                <option value="" style="background:#ffffff">전 체</option>
                                <c:forEach var="item" items="${code710}">
                                    <option value="${item.code}" <c:if test="${item.code==requestVO.cdStatus}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>    
                        </td>
					</tr>
					<tr>
                        <th>심사자</th>
                        <td>
                              <select name="idScreen"  style="width:100px">
                                <option value="" style="background:#ffffff">전 체</option>
                                <c:forEach var="item" items="${screenList}">
                                    <option value="${item.code}" <c:if test="${item.code==requestVO.idScreen}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>    
                        </td>
                    </tr>
					<tr>
						<th>접수경로</th>
						<td>
						      <select name="cdPdt"  style="width:100px">
                                <option value="" style="background:#ffffff">전 체</option>
                                <c:forEach var="item" items="${pdtList}">
                                    <option value="${item.code}" <c:if test="${item.code==requestVO.cdPdt}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>    
						</td>
					</tr>
					<tr>
					    <th>대출과목</th>
	                    <td>
	                        <select name="cdPath"  style="width:100px">
	                            <option value="" style="background:#ffffff">전 체</option>
	                            <c:forEach var="item" items="${code704}">
	                                <option value="${item.code}" <c:if test="${item.code==requestVO.cdPath}">selected</c:if>>${item.text}</option>
	                            </c:forEach>                                                        
	                        </select>
	                    </td>       
					</tr>
					<tr>
						<th>접수일</th>
						<td>
						<input type="text" class="s_text w70" id="dmReceiveStart" name="dmReceiveStart"  value="${requestVO.dmReceiveStart}" >&nbsp; ~ &nbsp;
						<input type="text" class="s_text w70" id="dmReceiveEnd" name="dmReceiveEnd"  value="${requestVO.dmReceiveEnd}" >
						</td>
					</tr>
					<tr>
                        <th>최종접촉일</th>
                        <td>
                        <input type="text" class="s_text w70" id="dmContactStart" name="dmContactStart"  value="${requestVO.dmContactStart}" >&nbsp; ~ &nbsp;
                        <input type="text" class="s_text w70" id="dmContactEnd" name="dmContactEnd"  value="${requestVO.dmContactEnd}" >
                        </td>
                    </tr>
					<tr>
                        <th>상담완료일</th>
                        <td>
                        <input type="text" class="s_text w70" id="dmScreenStart" name="dmScreenStart"  value="${requestVO.dmScreenStart}" >&nbsp; ~ &nbsp;
                        <input type="text" class="s_text w70" id="dmScreenEnd" name="dmScreenEnd"  value="${requestVO.dmScreenEnd}" >
                        </td>
                    </tr>
					<tr>
						<td style="padding-left: 10px"><span class="btn_icon xls"><a href="#" onclick="document.excelFrm.submit();" >CSV 다운로드</a></span></td>
						<td style="padding-left: 10px"><a href="/brc/excel/select">초기화</a></td>
					</tr>
				</tbody>
			</table>

		</fieldset>
	</form>
</div>
<div style="padding-top: 10px;"></div>       

<h1 class="pagename">대출심사현황</h1>
<div class="search_area">
    <form method="post" action="/bex/excel/excel" name="bexExcelFrm" target="_blank">
        <input type="hidden" name="logDsRemk" value="${bexExcelFileName}" />
        <fieldset>
            <legend>Legend</legend>
            <table border="0" cellspacing="0" class="search_table" summary="검색폼">
                    <tbody>
                        <tr>
                            <th>접수경로</th>
                            <td>
                            <select name="searchCdPath" class="select"  style="width:100px" >
                                    <option value="" style="background:#ffffff">전체</option>
                                    <c:forEach items="${code704}" var="item">
                                         <option value="${item.code}" >${item.text}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>심사업체</th>
                            <td>
                            <select name="searchCdCooperate" class="select"  style="width:100px" >
                                    <option value="" style="background:#ffffff">전체</option>
                                    <c:forEach items="${code703}" var="item">
                                         <option value="${item.code}" >${item.text}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>심사요청일</th>
                            <td>
                                <input type="text" class="s_text w70" value="${requestVO.dmReceiveStart}" name="searchDmRegStart" id="searchDmRegStart" >&nbsp; ~ &nbsp;
                                <input type="text" class="s_text w70" value="${requestVO.dmReceiveStart}" name="searchDmRegEnd" id="searchDmRegEnd">
                            </td>
                        </tr>
                        <tr>   
                            <th>기표변경일</th>
                            <td>
                                  <input type="text" class="s_text w70" value="" name="searchDmCooperteStart" id="searchDmCooperteStart">&nbsp; ~ &nbsp;
                                  <input type="text" class="s_text w70" value="" name="searchDmCooperteEnd" id="searchDmCooperteEnd">
                            </td>
                       </tr>
                       <tr>     
                            <td style="padding-left: 10px"><span class="btn_icon xls"><a href="#" onclick="document.bexExcelFrm.submit();" >CSV 다운로드</a></span></td>
                            <td style="padding-left: 10px"><a href="/brc/excel/select">초기화</a></td>
                        </tr>
                    </tbody>
                </table>

        </fieldset>
    </form>
</div>     
<script type="text/javascript">
 $(function() {
	$( "#dmReceiveStart" ).datepicker(CALENDAR_SET);
	$( "#dmReceiveEnd" ).datepicker(CALENDAR_SET);
	$( "#dmContactStart" ).datepicker(CALENDAR_SET);
	$( "#dmContactEnd" ).datepicker(CALENDAR_SET);
	$( "#dmScreenStart" ).datepicker(CALENDAR_SET);
	$( "#dmScreenEnd" ).datepicker(CALENDAR_SET);
	$( "#searchDmRegStart" ).datepicker(CALENDAR_SET);
	$( "#searchDmRegEnd" ).datepicker(CALENDAR_SET);
	$( "#searchDmCooperteStart" ).datepicker(CALENDAR_SET);
	$( "#searchDmCooperteEnd" ).datepicker(CALENDAR_SET);

});
</script>
<iframe id="hiddenFrame" name="hiddenFrame" style="display:none"></iframe>
