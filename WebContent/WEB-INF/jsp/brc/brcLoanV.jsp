<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<h1 class="pagename">접수내역
<c:forEach items="${screenList}" var="item">
    <span style="color:#000"><c:if test="${item.code == view.idScreen}">&lt;상담자 : ${item.text}&gt;</c:if></span>
</c:forEach>
</h1>

<div style="padding-top: 10px;margin-bottom:50px;">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <!-- left -->
            <td width="200" valign="top" bgcolor="#eaeaea" style="border: 1px solid #9E9E9E">
                <jsp:include page="brcLoanLeft.jsp" flush="false" />
            </td>
            <td width="1700" valign="top">
                <c:choose>
                    <c:when test="${empty param.searchNoReq && !empty param.searchCdStatus}">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="100%" valign="top" style="padding-left: 20px;">
                                    <jsp:include page="brcLoanList.jsp" flush="false" />
                                </td>
                            </tr>
                        </table>
                    </c:when>
                    <c:when test="${!empty param.searchNoReq}">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <!-- style="border-left:1px solid  #aaa;" -->
                            <tr>
                                <td width="1000" valign="top" style="padding-left: 20px;">
                                    <jsp:include page="brcLoanInfo.jsp" flush="false" />
                                </td>
                                <td width="400" valign="top" style="padding-left: 20px;">
                                    <ul id="tab_menu_contact" class="tab_menu_memo">
									    <li id="tab_menu_contact_tel" class="selected"><a href="#" onclick="changeContactTab('tel')">메모</a></li>
									    <li id="tab_menu_contact_sms"><a href="#" onclick="changeContactTab('sms')">문자발송</a></li>
									</ul>
							
									<div id="memoList" style="border: 1px solid #aaa; border-top: 0px; background-color: #FFFFB5" class="cb_module cb_fluid">
									    <jsp:include page="brcLoanAjaxContactTel.jsp" flush="false" >
									    <jsp:param name="searchCdStatus" value="${view.cdStatus}"/> 
                                        </jsp:include>
									</div>
                                </td>
								<td width="200" valign="top" style="padding-left: 20px;">
									<ul id="tab_menu_image" class="tab_menu">
										<li id="tab_menu_image_fax" class="selected"><a href="#" onclick="changeImageTab('${param.searchNoReq}', 'fax', $('#selectFaxNumber option:selected').val())">웹팩스</a></li>
										<li id="tab_menu_image_mms"><a href="#" onclick="changeImageTab('${param.searchNoReq}', 'mms', '${param.searchNoReq}')">MMS</a></li>
									</ul>
									<div id="imageList" >
									</div>
								</td>
							</tr>
                        </table>
                     </c:when>
                    <c:otherwise>    
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>    
    </table>
</div>

<script type="text/javascript">
SEARCH_NO_REQ = "${param.searchNoReq}";

$(function() {
    $(".memo_tooltip" ).tooltip({
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

 
window.onload = function() {
	//이미지리스트 기본탭 웹팩스
	var noFaxCompany = '${userVO.noFaxCompany}'; 
	var defFaxNo = '${userVO.faxNo}';
	if(defFaxNo == null || defFaxNo.length == 0){
		defFaxNo = noFaxCompany;
	}	
	changeImageTab('${param.searchNoReq}', 'fax', defFaxNo);
}	 

</script>
<script type="text/javascript" src="/js/jquery.formatter.min.js"></script>
<script type="text/javascript" src="/js/service.brc.js"></script>
