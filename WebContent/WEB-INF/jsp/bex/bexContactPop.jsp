<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" pageEncoding="utf-8"%>


<div class="cb_module cb_fluid" style="border:1px solid #aaa;border-top:0px;padding-top:20px;">                     

    <!-- //Comment Input Area -->
<style type="text/css">
.cb_section span{font-weight:bold}
.cb_date {font-family:tahoma;font-size:11px;}
.cb_nobar a{font-size:11px;background:none;}
</style>
    <h5 class="cb_h_type cb_h_type2" >접수 상태 메모 <span>(<strong>${contactList.size()}</strong>)</span></h5>
    <!-- memo List -->
    <div class="cb_lstcomment">
        <ul style=""><!-- height:572px;overflow-y:scroll -->
            <c:forEach items="${contactList}" var="row" varStatus="rowStatus">  
            <li class="cb_thumb_off">
                <div class="cb_comment_area">
                    <div class="cb_info_area">
                        <div class="cb_section">
                            <span class="cb_usr_id"></span>
                            <span class="cb_nick_name">${row.nmScreen}</span>
                            <span class="cb_date">${row.dmReg}</span>
                        </div>
                    </div>
                    <div class="cb_dsc_comment">
                        <p class="cb_dsc">
                            ${row.dsCooperate}
                        </p>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
    <!-- //memo List -->
</div>
<script>
window.onload = function(){
	window.document.body.scroll = "auto";
}
</script>
