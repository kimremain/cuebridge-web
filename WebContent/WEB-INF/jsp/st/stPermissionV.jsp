<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">사용자 권한관리</h1>
	<div class="search_area">
    <form method="get" action="/st/permission/select" name="searchFrm">
    <input type="hidden" value="${param.selectIdUser}" name="selectIdUser">
            <table border="0" cellspacing="0" class="search_table" summary="검색폼">
                <tbody>
                    <tr>
                        <th>팀</th>
                        <td>
                            <select name="searchCdTeam">
                                  <option value="" style="background:#ffffff">선 택</option>
                                  <c:forEach var="item" items="${teamList}">
                                      <option value="${item.code}"
                                          <c:if test="${item.code==requestVO.searchCdTeam}">selected</c:if>>${item.text}</option>
                                  </c:forEach>                                                    
                              </select>   
                         </td>
                        <th>아이디</th>
                        <td><input type="text" class="s_text w70 en" name="searchIdUser" value="${requestVO.getSearchIdUser()}"></td>
                        <th>사용자명</th>
                        <td><input type="text" class="s_text ko w70 ko" name="searchNmUser" value="${requestVO.getSearchNmUser()}"></td>
                        <td style="padding-left: 10px"><input type="submit" value="검 색" class="submit_icon search"  /></td>
                        <td style="padding-left: 10px"><a href="/st/permission/select">초기화</a></td>
                    </tr>
               </tbody>
            </table>
     </form>     
     
    </div>  
	<div style="padding-top: 10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td width="30%" valign="top">
						<div style="width:450px;height:700px;overflow-y:scroll">
	                    <table border="1" cellspacing="0" id="sort_table" class="basic_tbl">
	                        <thead>
	                            <tr>
	                                <th data-sort="string">아이디</th>
	                                <th data-sort="string">사용자명</th>
	                                <th data-sort="string">팀</th>
	                                <th data-sort="string">담당업무</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <c:forEach items="${userList}" var="list">
	                                <c:set var="bgcolor" value="#ffffff" />
	                                <c:if test="${param.selectIdUser  eq  list.idUser}">
	                                    <c:set var="bgcolor" value="#ffe8f3" />
	                                </c:if>
	                                <tr bgcolor="${bgcolor}" style="cursor: pointer;"
	                                    onmouseout="this.style.backgroundColor='${bgcolor}'"
	                                    onmouseover="this.style.backgroundColor='#EAECF5'"
	                                    >
	                                    <td id="${list.idUser}">${list.idUser}</td>
	                                    <td><a href="#${list.idUser}" onclick="selectUser('${list.idUser}')">${list.nmUser}</a></td>
	                                    <td>${list.cdTeam}</td>
	                                    <td>${list.cdPart}</td>
	                                </tr>
	                            </c:forEach>
	                        </tbody>
	                    </table>
	                    </div>
					</td>
					<td width="70%" valign="top" style="padding-left: 20px">
						<form  method="post" name="crudFrm" id="crudFrm" onsubmit="return false">
							<input type="hidden"  name="selectIdUser" value="${param.selectIdUser }"> 
							<input type="hidden"  name="searchIdUser" value="${requestVO.getSearchIdUser()}">
						    <input type="hidden"  name="searchNmUser" value="${requestVO.getSearchNmUser()}">
						    <input type="hidden"  name="searchCdTeam" value="${requestVO.getSearchCdTeam()}">
							<fieldset>
								<legend></legend>
								<div class="form_table">
									<table border="1" cellspacing="0" summary="">
										<tbody>
											<tr>
												<th><input type="checkbox" class="p_checkbox" name="" id="p1_search" onclick="allChecked(this)"></th>
												<th>프로그램ID</th>
												<th>프로그램명</th>
												<th>세부권한</th>
											</tr>
											<c:if test="${permissionList.size() > 0 and !empty param.selectIdUser }">
											 <c:forEach items="${permissionList}" var="item">
			                                     <c:set var="bgcolor" value="#ffffff" />
			                                    <c:set var="checked" value="" />
			                                    <c:if test="${item.no ne  null}">
			                                         <c:set var="checked" value="checked" />
			                                    </c:if>
			                                    <tr bgcolor="${bgcolor}" style="cursor: pointer;"  onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'">
			                                        <td><input type="checkbox" class="p_checkbox" name="authorize"  value="${item.dsPgmId}"  <c:if test="${item.no ne  null}">checked</c:if>
			                                        onclick="lineChecked(this.value,this.checked)"></td>
	                                                <td>${item.dsPgmId}</td>
	                                                <td>${item.dsPgm}</td>
	                                                <td>
		                                                <input type="checkbox" class="p_checkbox" name="ynS" id="ynS${item.dsPgmId}" ${checked} }><label for="ynS${item.dsPgmId}">조회권한</label>
		                                                <input type="checkbox" class="p_checkbox" name="ynU" id="ynU${item.dsPgmId}" ${checked}><label for="ynU${item.dsPgmId}">수정권한</label>
		                                                <input type="checkbox" class="p_checkbox" name="ynD" id="ynD${item.dsPgmId}" ${checked}><label for="ynD${item.dsPgmId}">삭제권한</label>
		                                                <input type="checkbox" class="p_checkbox" name="ynE" id="ynE${item.dsPgmId}" ${checked}><label for="ynE${item.dsPgmId}">엑셀권한</label>
		                                                <input type="checkbox" class="p_checkbox" name="ynP" id="ynP${item.dsPgmId}" ${checked}><label for="ynP${item.dsPgmId}">출력권한</label>
		                                                <input type="checkbox" class="p_checkbox" name="ynA" id="ynA${item.dsPgmId}" ${checked}><label for="ynA${item.dsPgmId}">실행권한</label>
	                                                </td>
			                                    </tr>
			                                </c:forEach>
											<tr>
												<td align="center" colspan="4"><span class="btn_pack medium icon"><span class="check"></span><input type="button" value="저장" id="submitBtn" onclick="formSubmit()"></span></td>
											</tr>
			                                </c:if>
										</tbody>
									</table>
								</div>
							</fieldset>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">
function formSubmit(){
    var f  = document.crudFrm;
    if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
            ON_SUBMIT_PROCESS = true;
            $('#crudFrm').block({});
            $.ajax({
                type: "POST",
                url: "/st/permission/update.json",
                cache:false,
                dataType: "json",
                async: false,
                data: $(f).serializeArray() ,
                success: function(data){
                    if(data.result == 'success'){
                        alert("정상적으로 처리되었습니다.");
                    	//document.location.reload();
                    }else{
                        alert(data.message);
                    }
                    ON_SUBMIT_PROCESS = false;
                    $('#crudFrm').unblock({});
                }
             });
        return false;
    }
}
function selectUser(idUser){
    var f = document.searchFrm;
    f.selectIdUser.value = idUser;
    f.submit();
}
function allChecked(obj){
    $("input[name=authorize]:checkbox").each(function() {
        $(this).attr("checked", obj.checked);
        lineChecked($(this).val(),obj.checked)
    });
}
function lineChecked(pgmID,checked){

	$("#ynS"+pgmID).attr("checked",checked)
	$("#ynU"+pgmID).attr("checked",checked)
	$("#ynD"+pgmID).attr("checked",checked)
	$("#ynE"+pgmID).attr("checked",checked)
	$("#ynP"+pgmID).attr("checked",checked)
	$("#ynA"+pgmID).attr("checked",checked)
	
}
</script>
