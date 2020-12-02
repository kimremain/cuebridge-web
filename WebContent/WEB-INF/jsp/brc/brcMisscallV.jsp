<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<div id="fix_cont">
	<h1 class="pagename">IVR 미스콜 관리</h1>

	<div class="pt10">
	   <ul class="tab_menu">
	        <li class="selected" ><a  href="#" >미스콜 접수대상</a></li>
	        <li><a href="/brc/misscall/select?searchMode=history">미스콜 히스토리</a></li>
	    </ul>
	   <form method="post" action="/brc/loanall/updatebatch" name="updateBatchFrm" >
		<table border="0" cellspacing="0" class="basic_tbl" id="scroll_tbl" style="border-top:0px;margin-top:10px;">
			<thead>
				<tr>
					<th width="50"><input type="checkbox" onclick="allChecked(this)"></th>
					<th width="50">번호</th>
					<th width="180">수신전화번호</th>
					<th width="120">수신일시</th>
					<th width="120">미스콜</th>
					<th width="120">중개전산일치(본인)</th>
					<th width="120">중개전산일치(보증인)</th>
					<th width="120">처리상태</th>	
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="countNo" value="${misscallList.size()}" />
				<c:forEach items="${misscallList}" var="list">
					<tr bgcolor="#ffffff"
						onmouseout="this.style.backgroundColor='#ffffff'"
						onmouseover="this.style.backgroundColor='#EAECF5'"
						style="background-color: rgb(255, 255, 255);">
						<td><input type="checkbox"   name="updateBatchNo" value="${list.no}" >
						<input type="hidden" id="updateBatchNoTel${list.no}"name="updateBatchNoTel" value="${list.noTel}" /></td>
						<td>${countNo}</td>
						<td>${list.noTel}&nbsp;&nbsp;
						<span class="btn_pack small"><a href="#" onclick="realationSearchTel('${list.noTel1Mobile}','${list.noTel2Mobile}','${list.noTel3Mobile}')">연계검사</a></span></td>
						<td>${list.dmRegMax}</td>
						<td><a href="/brc/misscall/select?searchMode=history&searchNoTel=${list.noTel}">${list.cnMisscall}건</a></td>
						<td>${list.cnCustomTel}건</td>
						<td>${list.cnSuretyTel}건</td>
						<td>미처리</td>
						<td><input type="text" id="updateBatchDsRemk${list.no}" name="updateBatchDsRemk" value="${list.dsRemk}" style="width:90%" /></td>
					</tr>
					<c:set var="countNo" value="${countNo-1}" />
				</c:forEach>
			</tbody>
		</table>
		
		<table border="0" cellspacing="0" id="updateBatchBtn">
        <tbody>
            <tr>
                <td height="10"></td>
            </tr>
            <tr>
                <td>
                <select name="updateCdCallProc" class="select" >
                       <option value="" style="background:#ffffff">처리상태변경</option>
                       <c:forEach items="${code715}" var="item">
                            <option value="${item.code}"  >${item.text}</option>
                       </c:forEach>
                </select>
                <span class="btn_pack medium icon"><span class="check"></span><input type="button" onclick="chkUpdateBachSubmit()" value="변경" id="submitBtn"></span>
                <span id="resultMsg" class="resultMsg">처리되었습니다.</span>
                </td>
            </tr>
        </tbody>
        </table>
    </form>
     <jsp:include page="../include/paginator.jsp" flush="false" />
    </div>
</div>
<script src="/js/jquery.filtertable.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
    $("#searchDmRegStart").datepicker(CALENDAR_SET);
    $("#searchDmRegEnd").datepicker(CALENDAR_SET);
    
    resetOptions('updateCdCallProc','71502,71599');
});
function allChecked(obj){
    $("input[name=updateBatchNo]:checkbox").each(function() {
        $(this).attr("checked", obj.checked);
    });
}
function realationSearchTel(tel1,tel2,tel3){		
	var query = "&searchNoMobile1="+tel1+"&searchNoMobile2="+tel2+"&searchNoMobile3="+tel3;
	relationSearchPopup(query);
}
function chkUpdateBachSubmit(){
    var f  = document.updateBatchFrm;
    if(f.updateCdCallProc.value == "" ){
        alert("변경할 처리상태를 선택하셔야 합니다.");
        return;
    }
    isChecked = false;
    $("input[name=updateBatchNo]:checked").each(function() {
    	var no =this.value;
    	this.value = this.value +"-"+$("#updateBatchNoTel"+no).val();
    	this.value = this.value +"-"+$("#updateBatchDsRemk"+no).val()+" ";
    	isChecked = true;
        //return;
    });
    if(!isChecked){
        alert("최소한 1개 이상 선택하셔야 합니다.");
        return ;
    }else{
               if(ON_SUBMIT_PROCESS){
                   alert("실행중")
               }else{
                   ON_SUBMIT_PROCESS = true;
                   $('#updateBatchBtn').block({});
                   $.ajax({
                       type: "POST",
                       url: "/brc/misscall/updatebatch",
                       cache:false,
                       dataType: "json",
                       async: false,
                       data: $(f).serializeArray() ,
                       success: function(data){
                           if(data.result == 'success'){
                               document.location.reload();
                           }else{
                               alert("오류메세지 ["+data.message+"]");
                           }
                           ON_SUBMIT_PROCESS = false;
                           $('#updateBatchBtn').unblock({});
                       }
                    });
               }
           
    }
}


	
	
	
	
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
