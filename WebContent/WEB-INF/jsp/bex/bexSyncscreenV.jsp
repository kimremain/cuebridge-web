<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="updateDiv">
	<h1 class="pagename">접수현황 => 심사기표보정</h1>
	<div class="search_area">
    <form method="get" action="/bex/syncscreen/select" name="searchFrm">
    		<input type="hidden" name="noEx" id="noEx" value="${requestVO.noEx}">
            <table border="0" cellspacing="0" class="search_table" summary="검색폼">
                <tbody>
                    <tr>
                        <th>접수번호</th>
                        <td><input type="text" class="s_text w100" name="noReq" value="${requestVO.noReq}"></td>
                        <td style="padding-left: 10px"><span class="btn_icon search"><input type="submit" value="검 색" /></span></td>
                        <td style="padding-left: 10px"><a href="/bex/syncscreen/select">초기화</a></td>
                    </tr>
               </tbody>
            </table>
     </form>     
    </div>  
	<div class="pt10">
		<table width="100%" height="750" border="0" cellspacing="0"
			cellpadding="0">
			<tbody>
				<tr>
					<td  valign="top">
						<table border="0" cellpadding="0" class="basic_tbl">
							<thead>
								<tr>
									<th data-sort="string">번호</th>
									<th>접수번호</th>
									<th data-sort="string">실행번호</th>
									<th data-sort="string">중개협력사</th>
									<th data-sort="string">고객명</th>
									<th data-sort="string">접수경로</th>
									<th data-sort="string">대출상품</th>
									<th data-sort="string">상담자</th>
									<th data-sort="string">접수일시</th>
									<th data-sort="string">심사요청일시</th>
									<th data-sort="int" width="80">신청금액(만원)</th>
									<th data-sort="string">심사업체</th>
									<th data-sort="string">접수위치</th>
									<th data-sort="string">심사상품</th>
									<th data-sort="string">심사상태</th>
									<th data-sort="int" width="80">승인예정금액(만원)</th>
									<th data-sort="int" width="80">승인금액(만원)</th>
									<th data-sort="string">기표변경일시</th>
									<th data-sort="string">심사메모</th>
								</tr>
							</thead>
							<tbody>
							    <c:set var="countNo" value="${masterList.size()}" />
								<c:forEach items="${masterList}" var="row" varStatus="rowStatus">
									<c:set var="bgcolor" value="#ffffff" />
									<c:if test="${requestVO.noEx  eq  row.noEx}">
										<c:set var="bgcolor" value="#ffe8f3" />
									</c:if>
									<tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#D6DAEB'" style="cursor: pointer;"
									onclick="window.location='/bex/syncscreen/select?noReq=${row.noReq}&noEx=${row.noEx}'">
										<td>${countNo}</td>
										<td>${row.noReq}</td>
										<td>${row.noEx}</td>
										<td>${row.cdCooperatePartner}</td>
										<td><a href="/brc/loan/select?noReq=${row.noReq}" target="_blank">${row.nmCustom}</a></td>
										<td>${row.cdPath}</td>
										<td>${row.nmPdt}</td>
										<td>${row.idScreen}</td>
										<td>${row.dmReceive}</td>
										<td>${row.dmReg}</td>
										<td>${row.amApp}</td>
										<td>${row.cdCooperate}</td>
										<td>${row.nmScreenPath}</td>
										<td>${row.nmBexPdt}</td>
										<td>${row.nmScreen}</td>
										<td>${row.amCooperateExpect > 0 ? row.amCooperateExpect : ''}</td>
										<td>${row.amCooperate > 0 ? row.amCooperate : ''}</td>
										<td>${row.dmUpt}</td>
										<td>
					                       <c:choose> 
					                            <c:when test="${row.contactCnt > 0}"> 
					                                <a title="${row.dsCooperate}" class="memo_tooltip" href="#"><img src="/images/icon/comments.png" /></a>
					                                <a href="#" onclick="bexMemoStory('${row.noReq}','${row.noEx}')" >(내역)</a>
					                            </c:when> 
					                            <c:otherwise> 
					                                <img src="/images/icon/comments_gray.png">
					                            </c:otherwise> 
					                        </c:choose>
					                       
					                    </td>
									</tr>
									<c:set var="countNo" value="${countNo-1}" />
					            </c:forEach>
							</tbody>
						</table>
						
						<jsp:include page="../include/paginator.jsp" flush="false" />
					</td>
				</tr>
				<tr>
					<td valign="top">
						<form action="/bex/syncscreen/update" method="post" name="crudFrm" id="crudFrm" class="has-validation-callback" onsubmit="return submitSyncscreen(this)">
							<input type="hidden" name="noReq" value="${view.noReq}" />
							<input type="hidden" name="noEx" value="${view.noEx}" />
							<fieldset>
								<legend></legend>
								<div class="form_table">
									<table border="1" cellspacing="0" summary="">
										<tbody>
											<tr>
												<th scope="row">승인상품</th>
												<td><select name="cdPdt" style="width: 138px"
													data-validation="required" ${selectDisabled}>
														<option value="" style="background: #ffffff">선 택</option>
														<c:forEach var="item" items="${pdtList}">
															<option value="${item.code}"
																<c:if test="${item.code==view.cdPdt}">selected</c:if>>${item.text}</option>
														</c:forEach>
												</select></td>
												<th scope="row">접수위치</th>
												<td><input type="text" name="nmScreenPath"
													maxlength="20" value="${view.nmScreenPath}" class="i_text">
												</td>
												<th scope="row">심사상태</th>
												<td><input type="text" name="nmScreen" maxlength="50"
													value="${view.nmScreen}" class="i_text"></td>
											</tr>
											<tr>
												<th scope="row">승인금액</th>
												<td><input type="text" name="amCooperate"
													maxlength="20" value="${view.amCooperate}" class="i_text" data-validation="number">
												</td>
												<th scope="row">승인일시</th>
												<td colspan="3"><input type="text" name="dmCooperate"
													maxlength="20" value="${view.dmCooperate}" class="i_text"> *입력 예시 : 2015-08-17 17:02:50
												</td>
<%-- 												<th scope="row">변경일시</th>
												<td><input type="text" name="dmUpt" maxlength="50"
													value="${view.dmUpt}" class="i_text"></td> --%>
											</tr>
											<tr>
												<th scope="row">거래처메모</th>
												<td colspan="5"><input type="text" name="dsCooperate"
													maxlength="100" value="${view.dsCooperate}"
													class="i_text w600"></td>
											</tr>
											<tr>
												<td align="center" colspan="6">
													<span class="btn_pack medium icon"><span class="check"></span><input type="submit" value="저장" id="submitBtn"></span>
												</td>
											</tr> 
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

<!-- 
<div class="upload_area">
	<form name="fileFrm" method="POST" action="/bex/syncscreen/upload" enctype="multipart/form-data" onsubmit="return uploadCSV(this)">
		<fieldset>
			<legend>Legend</legend>
			<table border="0" cellspacing="0" class="search_table" summary="검색폼">
				<tbody>
					<tr>
						<th width="5%">파일</th>
						<td width="30%"><input type="file" name="file" class="s_text w600"></td>
						<td style="padding-left: 10px">
							<span class="btn_icon xls"><span class="check"></span><input type="submit" value="파일등록" id="submitUploadBtn"></span>
						</td>
					</tr>					
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
					 -->

<script type="text/javascript">
function submitSyncscreen(f){

	if(!$.trim(f.noReq.value)){
	    alert("변경할 실행건을 선택하십시오.");
	    return false;
	}
	if(!$.trim(f.noEx.value)){
	    alert("변경할 실행건을 선택하십시오.");
	    return false;
	}	
	if(confirm("저장하시겠습니까?")){
		 return true;
	}else{
		return false;
	}
   
}

function uploadCSV(f){
    if(!f.file.value){
        alert("업로드할 CSV파일을 선택하셔야 합니다.");
        return false;
    }else{
    	var fileExt = f.file.value.substring(f.file.value.lastIndexOf('.')+1);
    	if(fileExt.toUpperCase() != "CSV")
		{
			alert("CSV 형식만 업로드할 수 있습니다");
			return false;
		}
    	return true;
    }
}
</script>
