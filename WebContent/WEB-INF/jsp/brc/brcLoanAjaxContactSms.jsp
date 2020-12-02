<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
    
           <div class="cb_usr_area">
                <div class="cb_txt_area">    
			      <form id="brcSmsFrm" name="brcSmsFrm" method="post" action="/brc/contact/sendsms" >    
			      <input type="hidden" name="noReq" value="${param.searchNoReq }" />
			      <input type="hidden" name="rcvPhnId" value="${rcvNumber[0].noTelMobileAll}" />
			      <input type="hidden" name="rcvName" value="${rcvNumber[0].nmCustom}" />
			      <input type="hidden" name="cdContact" value="71202" />
			      <input type="hidden" name="messageKind" value="sms" />
			      <input type="hidden" name="brcLonaNoReq" value="${param.searchNoReq }" /><!-- 메세지조회용 -->
                  <table border="0" class="cb_section">
                          <tr>
                              <td>
                                  <table  border="0" cellspacing="0" cellpadding="0">
			                       <tr>
			                           <td width="135" height="123" valign="top" align="center" style="background: url(/images/phone_bg.gif) 0 0 no-repeat;position:relative;">
			                               <div style="position:absolute;top:30px;left:16px;width:100px;height:80px">
			                                     <textarea id="smsMessage"  name="sndMsg" 
			                                     style="width:100px;height:80px;border:0px;background-color:transparent;overflow:hidden;ime-mode:active;white-space:-moz-pre-wrap;word-break:break-all;font-size:11px;" 
			                                     onKeyUp="printLength('smsMessage','smsByte');" readonly="readonly"></textarea>
			                               </div>
			                               <div style="position:absolute;top:130px;left:10px;"><span id="smsByte">0</span> byte</div>
			                           </td>
			                       </tr>
			                       </table>
                              </td>
                              <td>    
                                  <div class="cb_dsc_area">
                                      <div class="clear">
								        <table border="1" cellspacing="0" summary="고객정보" class="crud_tbl">
								            <tbody>
								                <tr>
								                    <td>내용</td>
								                    <td>
								                        <select name="messageNo" id="messageNo" style="width:170px;" onchange="setSmsMessage(this.value,'smsMessage')" >
								                            <option value="" style="background:#ffffff">메세지 선택</option>
								                            <c:forEach var="item" items="${smsMessage}">
								                                <option value="${item.no}" >${item.shortMessage}</option>
								                            </c:forEach>                                                        
								                        </select>
								                    </td>               
								                </tr>
								                <tr>
								                    <td>받는이</td>
								                    <td>
								                    <select  style="width:170px;" onchange="setSmsReceive(this.value)" >
                                                            <c:forEach var="item" items="${rcvNumber}">
                                                                <option value="${item.noTelMobileAll}||${item.nmCustom}"  >${item.nmCustom}(${item.noTelMobileAll} - ${empty item.noSurety ? '본인' : '보증인'})</option>
                                                            </c:forEach>                                                        
                                                        </select>
								                    </td>
								                </tr>
								                <tr>
								                       <td>보내는이</td>
								                       <td><select name="sndPhnId" id="sndPhnId" style="width:170px;" onchange="setSmsSendNumber(this.value)" >
                                                            <c:forEach var="item" items="${sendNumber}">
                                                                <option value="${item.sendPhone}">${item.sendPhone}</option>
                                                            </c:forEach>                                                        
                                                        </select>
                                                        </td>
								                 </tr>
								               </tbody>
								            </table>
								            </form>
                                            <p class="fr">
                                              <span class="btn_pack medium icon"><span class="add"></span><input type="button" value="서류요청 메시지" onclick="sendSmsforMms(this)"></span>
                                              <span class="btn_pack medium icon"><span class="check"></span><input type="button" value="SMS발송" onclick="sendSms(this)"></span>
                                            </p>
                                      </div>
                                  </div>
                              </td>
                          </tr>
                    </table>
                  
              </div>
      </div>

    
    <h5 class="cb_h_type cb_h_type2" style="margin-top:30px;">
        SMS 발송이력  <span>(<strong>${contactList.size()}</strong>)</span>
    </h5>
    <div class="cb_lstcomment" style="min-height:620px">
        <ul>
            <c:forEach items="${contactList}" var="row" varStatus="rowStatus">  
            <li class="cb_comment_area clear" >
                <div class="cb_info_area">
                    <div class="cb_section">
                        ${row.nmReg}<span class="cb_date">${row.dmReg} <font color="gray">&nbsp;[${row.nmResult}]</font></span>
                    </div>
                    <div class="cb_section2">

                    </div>
                </div>
                <div id="memoCont${row.no}"  class="cb_dsc_comment">
                수신번호 : ${row.rcvPhnId} <br />
                발신번호 : ${row.sndPhnId} <br />
                메세지 :  <br />
                ${row.dsMemo}</div>
            </li>
            </c:forEach>
        </ul>
    </div>
    
    
<script>
function setSmsReceive(sel){
	var f = document.brcSmsFrm;
	var receive = sel.split("||");
	f.rcvPhnId.value = receive[0];
	f.rcvName.value = receive[1];
	setSmsMessage(f.messageNo.value,'smsMessage');
}

function setSmsMessage(no,obj){
	var f = document.brcSmsFrm;
    $.ajax({
        type: "POST",
        url: "/common/message/select.json",
        cache:false,
        dataType: "json",
        async: true,
        data: $(f).serializeArray() ,
        success: function(data){
            if(data.result == 'success'){
            	var msg = data.message;
                $("#"+obj).get(0).value = msg;
                printLength('smsMessage','smsByte');
            }else{
                alert(data.message);
            }
        }
    });
}
function sendSms(){
	var f = document.brcSmsFrm;
	if(!f.sndMsg.value){
		alert("메세지를 선택하셔야 합니다.");
	}else{
		$.ajax({
	        type: "POST",
	        url: "/brc/contact/sendsms.json",
	        cache:false,
	        dataType: "json",
	        async: false,
	        data: $(f).serializeArray() ,
	        success: function(data){
	            if(data.result == 'success'){
	                changeContactTab('sms')
	            }else{
	                alert(data.message);
	            }
	        }
	    });
	}
}

function sendSmsforMms(){
	$('#messageNo').val("${mmsInfo.no}");
	$('#sndPhnId').val("${mmsInfo.noTelForMms}");
	setSmsMessage("${mmsInfo.no}",'smsMessage')
}

function setSmsSendNumber(sel){
	$("#sndPhnId").get(0).value = sel;
}
</script>
    
    
    