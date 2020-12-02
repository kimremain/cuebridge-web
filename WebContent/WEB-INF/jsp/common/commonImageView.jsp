<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<table border="0" cellspacing="0" class="search_table" >
<tr>
<%-- <td>'${noReq}' '${dsFile}' '${imgExt}'</td> --%>
<td><span class="btn_icon24 submit"><a href="#" onclick="imageAttachUpload()" >업로드</a></span></td>
<td><span class="btn_icon24 submit"><a href="/common/file/download/${dsFileBase64}" onclick="" >다운로드</a></span></td>
</tr>
</table>
<br>

<c:choose>
	<c:when test="${imgExt eq 'tif'}">
		<object width="1200" height="850" classid="CLSID:106E49CF-797A-11D2-81A2-00E02C015623" codebase="/images/alttiff.ocx#version=1,8,2,1">
		 <param name="src" value="/common/file/download/${dsFileBase64}">
		</object>
    </c:when>
	<c:when test="${imgExt eq 'empty'}">
		file empty!
    </c:when>
	<c:otherwise>
		<img src="/common/file/download/${dsFileBase64}">
	</c:otherwise>
</c:choose>                

<form name="imageAttachFrm">
<input  type="hidden" name="dsFileFrom" value="${dsFileBase64}" />
</form>


<script>
<c:if test="${requestResultVO.error ne null }" >
$(function() { // 에러처리 
    printError("${requestResultVO.error}");
});
</c:if>
function imageAttachUpload(){
	var frm = document.imageAttachFrm;
	var parentFrm = opener.document.attachRegistFrm;
	if(parentFrm){
		parentFrm.dsFileFrom.value = frm.dsFileFrom.value;
		popupClose();
	}else{
		alert("첨부파일 WEBFAX 항목이 없습니다.")
	}
}
</script>