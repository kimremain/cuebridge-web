<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

	<table border="0" cellspacing="0" style="margin-top: 0px;"  class="basic_tbl">
        <tbody>
        	<tr>
        		<span id="spanFax" style="display:${searchKind eq 'fax' ? '' :  'none'}" >
				<a href="#" onclick="changeImageTab('${param.searchNoReq}', 'fax', $('#selectFaxNumber option:selected').val())"><img width="16" src="/images/icon/reload.jpg"></a>        		
				<select style="width: 170px" id="selectFaxNumber" name="selectFaxNumber"  onchange="changeImageTab('${param.searchNoReq}', 'fax', $('#selectFaxNumber option:selected').val())">
					<c:forEach var="item" items="${teamFaxList}">
					<option value="${item.key}" <c:if test="${item.key eq param.searchParam}">selected</c:if> >${item.value}</option>
					</c:forEach>    				
				</select>
        		</span>
        		<span id="spanMms" style="display:${searchKind eq 'mms' ? '' :  'none'}" >
        		<a href="#" onclick="changeImageTab('${param.searchNoReq}', 'mms', '${param.searchParam}')"><img width="16" src="/images/icon/reload.jpg"></a>
        		</span>
			</tr>
            <tr>
                <th>발신번호</th>
                <th>수신일자</th>
            </tr>
            
            <c:forEach items="${imageList}" var="row" varStatus="rowStatus">  
            <tr>
                <td>
                	<a href="javascript:openImageViewer('${row.noReq}', '${row.dsFileBase64}')" class="imageLink" >${row.noRcvTel}</a>          	
                </td>
                <td><a href="javascript:openImageViewer('${row.noReq}', '${row.dsFileBase64}')" class="imageLink">${row.dmRcv}</a>
                	<c:if test="${not empty row.dsMsg}">
                	<a title="${row.dsMsg}" class="memo_tooltip" href="#"><img src="/images/icon/comments.png" /></a>
                	</c:if>
                	<c:if test="${empty row.dsMsg}">
					<a title="${row.dsMsg}" class="memo_tooltip" href="#"><img src="/images/icon/comments_gray.png" /></a>
                	</c:if>                	
                </td>
            </tr>
            </c:forEach>
<%--             <c:forEach items="" var="row" varStatus="rowStatus">  
            <tr>
                <td><a href="javascript:faxViewerPopup('${row.no}','${row.fileName}','${row.path}','${row.callSndNum}')" class="imageLink"  >${row.callSndNum}</a></td>
                <td><a href="javascript:faxViewerPopup('${row.no}','${row.fileName}','${row.path}','${row.callSndNum}')"  class="imageLink" >${row.recvTime}</a></td>
            </tr>
            </c:forEach> --%>
        </tbody>
    </table>
      
<script type="text/javascript">
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
</script>