<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<h1 class="pagename" style="margin-top: 10px">신규접수</h1>
<form id="insertForm" name="insertForm" action="/brc/loan/insert" method="post">
	<div style="padding-top: 10px;">
		<table class="crud_tbl" border="1" cellspacing="0" summary="고객정보">
			<tr>
				<th width="10%">접수경로</th>
				<td width="35%">
				    <select name="cdPath" data-validation="required">
		                <option value="" style="background:#ffffff">선 택</option>
		                <c:forEach var="item" items="${code704}">
		                    <option value="${item.code}">${item.text}</option>
		                </c:forEach>
		            </select>
				</td>
				<th width="10%">대출과목</th>
				<td width="45%">
				    <select name="cdPdt" data-validation="required">
					    <option value="" style="background:#ffffff">선 택</option>
					    <c:forEach var="item" items="${pdtList}">
                            <option value="${item.code}">${item.text}</option>
                        </c:forEach>
				    </select>
				</td>
			</tr>
			<tr>
				<th>고객명</th>
				<td><input type="text" name="nmCustom" class="i_text" data-validation="required" value="${requestVO.searchNmCustom}" /></td>
				<th>핸드폰</th>
				<td>
				    <input type="text" name="noTel1Mobile" class="i_text w30"  maxlength="3" value="${requestVO.searchNoMobile1}" data-validation="required" /> -
					<input type="text" name="noTel2Mobile" class="i_text w30"  maxlength="4" value="${requestVO.searchNoMobile2}" data-validation="required" /> - 
					<input type="text" name="noTel3Mobile" class="i_text w30"  maxlength="4" value="${requestVO.searchNoMobile3}" data-validation="required" />
			    </td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td>
				    <input type="text" name="noCustom1" class="i_text w80"  maxlength="6" value="${requestVO.searchNoCustomFirst}"/> -
					<input type="text" name="noCustom2" class="i_text w80"  maxlength="7" value="${requestVO.searchNoCustomSecond}"/>
			    </td>
				<th>이메일</th>
				<td>
				    <input type="text" id="dsEmail"  name="dsEmail" class="i_text w200" />
					<select onchange="changeEmailDomain('dsEmail',this.value)" >
                       <option value="" style="background:#ffffff">직접입력</option>
                       <c:forEach var="item" items="${emailList}">
                           <option value="${item.code}"
                               <c:if test="${item.code==view.dsEmail}">selected</c:if>>${item.text}</option>
                       </c:forEach>                                                        
                   </select>

				</td>
			</tr>
			<tr>
				<th>결혼여부</th>
				<td>
					<select name="cdMarry">
	                    <option value="" style="background:#ffffff">선 택</option>
	                    <c:forEach var="item" items="${code707}">
	                        <option value="${item.code}">${item.text}</option>
	                    </c:forEach>
	                </select>
				</td>
				<th>직장정보</th>
				<td>
					<select name="cdJobKind">
	                    <option value="" style="background:#ffffff">선 택</option>
	                    <c:forEach var="item" items="${code709}">
	                        <option value="${item.code}">${item.text}</option>
	                    </c:forEach>
	                </select>
				</td>
			</tr>
			<tr>
				<th>신청금액</th>
				<td>
				    <input type="text"  id="infoAmCustom" name="amCustom" class="i_text"  data-validation="required"> 
				    <span class="btn_pack small"><input type="button" value="+ 100" onclick="calAmCustom('infoAmCustom',100)"></span> 
                    <span class="btn_pack small"><input type="button" value="+ 50"  onclick="calAmCustom('infoAmCustom',50)"></span> 
                    <span class="btn_pack small"><input type="button" value="- 100" onclick="calAmCustom('infoAmCustom',-100)"></span>
				</td>
				<th>상담자</th>
                <td>
                    <select name="idScreen">
                        <option value="" style="background:#ffffff">선 택</option>
                        <c:forEach var="item" items="${screenList}">
                            <option value="${item.code}" <c:if test="${item.code==userVO.idUser}">selected</c:if>>${item.text}</option>
                        </c:forEach>
                    </select>
                </td>
			</tr>
			 
               <c:choose>
                    <c:when test="${empty regID }">
                    <tr>
                  <th>등록자</th>
                  <td colspan="3">
                     <select id="idReceive" name="idReceive" data-validation="required" >
                        <option value="" style="background:#ffffff">선 택</option>
                        <c:forEach var="item" items="${codeUser}">
                            <option value="${item.code}" <c:if test="${item.code==regID}">selected</c:if>>${item.text}</option>
                        </c:forEach>
                    </select>
		                 </td>
              </tr>
                    </c:when>
                     <c:otherwise>    
                     <input type="hidden" name="idReceive" value="${regID}" readonly="readonly" class="i_text "/>
                    </c:otherwise>
                </c:choose>
                
                
			<tr>
				<td colspan="4" style="padding-top: 20px">
				    <span class="btn_pack medium icon"><span class="check"></span><input type="submit" id="submitBtn" value="신규등록"></span>
				</td>
			</tr>
		</table>
	</div>
</form>

<script src="/js/jquery.form-validator.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/service.brc.js"></script>
<script type="text/javascript">
$(function() {
    //입력후 oppner reload, popup close 
	var resultCode = "${resultCode}";
	
	var f = document.insertForm;
    /*if(!f.idReceive.value){
    	//$("#idReceive").attr("disabled",false);
    }else{
    	//$("#idReceive").attr("disabled",true);
    }*/
	if (resultCode!=null && resultCode!="") {
		//alert(resultCode);
		try{
		    if(resultCode == 'EMPTY_ID_REG'){
			  alert("등록자 정보가 없습니다.")	  
			}else{	
		       alert("정상적으로 등록되었습니다.");      	
			  opener.window.location = "/brc/loan/select";		
			}
		}catch(e){
			//window.close();
		}
	    window.close();
        
	}
	
    //form validation
    window.applyValidation("#insertForm");
});

function submit_before(form_id){
	var f = document.insertForm;
	if(!f.idReceive.value){
		alert("등록자 정보가 없습니다.");
		$("#idReceive").attr("disabled",false);
		return false;
	}
	else{
		return true;
	}
}
</script>
