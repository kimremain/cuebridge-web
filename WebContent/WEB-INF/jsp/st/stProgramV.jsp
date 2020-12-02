<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">프로그램관리</h1>
	<div class="search_area">
		<form method="get" action="/st/program/select" name="searchFrm">
			<input type="hidden" name="no" id="no" value="${view01.no}">
			<input type="hidden" name="page" value="">
			<fieldset>
				<legend>Legend</legend>
				<table border="0" cellspacing="0" class="search_table" summary="검색폼">
					<tbody>
						<tr>
							<th>프로그램명</th>
							<td><input type="text" class="s_text w100" value="${requestVO.searchDsPgm}" name="searchDsPgm" id="searchDsPgm"></td>
							<td style="padding-left: 10px"><span class="btn_pack medium"><input type="submit" value="검 색"></span></td>
							<td style="padding-left: 10px"><span class="btn_pack medium"><input type="button" onclick="" value="초기화"></span></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	<div class="pt10">
		<table width="100%" height="650" border="0" cellspacing="0"
			cellpadding="0">
			<tbody>
				<tr>
					<td width="30%" valign="top">
						<table border="0" cellspacing="0" class="basic_tbl"
							id="scroll_tbl">
							<thead>
								<tr>
									<th>번호</th>
									<th>프로그램ID</th>
									<th>프로그램명</th>
									<th>적용여부</th>
									<th>관리자</th>
									<th>배치구분코드</th>
									<th>수정일시</th>
									<th>수정자</th>
									<th>수정/삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list01}">
									<c:set var="bgcolor" value="#ffffff" />
									<c:if test="${param.no  eq  item.no}">
										<c:set var="bgcolor" value="#ffe8f3" />
									</c:if>
									<tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'">
										<td>${item.no}</td>
										<td>${item.dsPgmId}</td>
										<td>${item.dsPgm}</td>
										<td>${item.ynApply}</td>
										<td>${item.ynAdmin}</td>
										<td>${item.cdOnoff}</td>
										<td>${item.dmUpt}</td>
										<td>${item.idUpt}</td>
										<td>
										    <span class="btn_pack small" style="margin-right: 10px"><a href="/st/program/select?no=${item.no}&searchDsPgm=${requestVO.searchDsPgm}">수정</a></span> 
										    <span class="btn_pack small"><input type="button" value="삭제" onclick="removeRow('${item.no}')"></span>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<p class="paginate_regular">
							<strong>1</strong>
						</p>
					</td>
				</tr>
				<tr>
					<td width="70%" valign="top">
						<form action="/st/program/${true eq isUpdate ? 'update' : 'insert'}" method="post" name="crudFrm" id="crudFrm" class="has-validation-callback">
							<input type="hidden" value="${view01.no}" name="no" id="no" /> 
							<input type="hidden" value="" name="ynApply" id="ynApply" /> 
							<input type="hidden" value="" name="ynAdmin" id="ynAdmin" /> 
							<fieldset>
								<legend></legend>
								<div class="form_table">
									<table border="1" cellspacing="0" summary="">
										<tbody>
											<tr>
												<th scope="row">* 프로그램ID</th>
												<td>
													<div class="item">
														<input type="text" data-validation="required" value="${true eq isUpdate ? view01.dsPgmId : requestVO.dsPgmId}" class="i_text" name="dsPgmId" id="dsPgmId" <c:if test="${isUpdate==true}">readonly</c:if>>
													</div>
												</td>
												<th scope="row">* 프로그램명</th>
												<td>
													<div class="item">
														<input type="text" data-validation="required" value="${true eq isUpdate ? view01.dsPgm : requestVO.dsPgm}" class="i_text" name="dsPgm" id="dsPgm">
													</div>
												</td>
												<th scope="row">적용여부</th>
												<td>
													<div class="item">
														<input type="radio" value="Y" class="i_radio" name="YN_APPLY" <c:if test="${'Y' == (true eq isUpdate ? view01.ynApply : requestVO.ynApply)}">checked</c:if>>
														<label for="YN_APPLY_Y">예</label>
														<input type="radio" value="N" class="i_radio" name="YN_APPLY" <c:if test="${'N' == (true eq isUpdate ? view01.ynApply : requestVO.ynApply)}">checked</c:if>>
														<label for="YN_APPLY_N">아니오</label>
													</div>
												</td>
												<th scope="row">온라인 배치 구분코드</th>
												<td>
													<div class="item">
														<select name="cdOnoff" id="cdOnoff">
															<option value="" style="background:#ffffff">선 택</option>
															<c:forEach var="item" items="${code702}">
																<option value="${item.code}"
																	<c:if test="${item.code == (true eq isUpdate ? view01.cdOnoff : requestVO.cdOnoff)}">selected</c:if>>${item.text}</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">URL</th>
												<td>
													<div class="item">
														<input type="text" value="${true eq isUpdate ? view01.dsUrl : requestVO.dsUrl}" class="i_text" name="dsUrl" id="dsUrl">
													</div>
												</td>
												<th scope="row">관리자프로그램여부</th>
												<td>
													<div class="item">
														<input type="radio" value="Y" class="i_radio" name="YN_ADMIM" <c:if test="${'Y' == (true eq isUpdate ? view01.ynAdmin : requestVO.ynAdmin)}">checked</c:if>>
														<label for="YN_ADMIM_Y">예</label>
														<input type="radio" value="N" class="i_radio" name="YN_ADMIM" <c:if test="${'N' == (true eq isUpdate ? view01.ynAdmin : requestVO.ynAdmin)}">checked</c:if>>
														<label for="YN_ADMIM_N">아니오</label>
													</div>
												</td>
												<th scope="row">도움말</th>
												<td colspan="3">
													<div class="item">
														<input type="text" value="${true eq isUpdate ? view01.dsHelp : requestVO.dsHelp}" maxlength="4" class="i_text w350" name="dsHelp" id="dsHelp">
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">생성자</th>
												<td>
													<div class="item">${view01.idReg}</div>
												</td>
												<th scope="row">생성일시</th>
												<td>
													<div class="item">${view01.dmReg}</div>
												</td>
												<th scope="row">수정자</th>
												<td>
													<div class="item">${view01.idUpt}</div>
												</td>
												<th scope="row">수정일시</th>
												<td>
													<div class="item">${view01.dmUpt}</div>
												</td>
											</tr>
											<tr>
												<td align="center" colspan="2">
												    <span class="btn_pack medium icon"><span class="add"></span><a href="/st/program/select">신규</a></span> 
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

<div style="color:red;">
    <c:out value="${requestVO.errMsg}" />
</div>

<!-- 삭제폼  -->
<form action="/st/program/delete" method="post" id="deleteFrm" name="deleteFrm">
	<input type="hidden" name="no" value="">
</form>
<script src="/js/jquery.form-validator.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	// form validation
	window.applyValidation("#crudFrm");
});

// Overriding
function submit_before(form_id){
	//parameter	        
	$("#ynApply").val($("input[name='YN_APPLY']:checked").val());
	$("#ynAdmin").val($("input[name='YN_ADMIM']:checked").val());
	   
	return true; 
}

<c:if test="${requestResultVO.errors ne null}" >
$(function() {
    printError("${requestResultVO.errors}");
});
</c:if>
</script>


