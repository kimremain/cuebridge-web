<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">거래처 정보</h1>
	
	<div class="pt10">
		<table width="100%" height="850" border="0" cellspacing="0"
			cellpadding="0">
			<tbody>
				<tr>
					<td width="30%" valign="top">
						<table border="0" cellpadding="0" class="basic_tbl">
							<thead>
								<tr>
									<th>번호</th>
									<th>거래처코드</th>
									<th>거래처명</th>
									<th>접수 URL</th>
									<th>사용여부</th>
									<th>생성자</th>
									<th>생성일</th>
									<th>수정자</th>
									<th>수정일</th>
									<th>수정/삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="countNo" value="${list.size()}" />
								<c:forEach items="${list}" var="row" varStatus="rowStatus">
									<c:set var="bgcolor" value="#ffffff" />
									<c:if test="${param.no  eq  row.no}">
										<c:set var="bgcolor" value="#ffe8f3" />
									</c:if>
									<tr bgcolor="${bgcolor}"
										onmouseout="this.style.backgroundColor='${bgcolor}'"
										onmouseover="this.style.backgroundColor='#EAECF5'">
										<td>${countNo}</td>
										<td>${row.cdCooperate}</td>
										<td>${row.nmCustomer}</td>
										<td>${row.dsUrl}</td>
										<td>${row.ynUse eq 'Y' ? '사용' : '사용안함'}</td>
										<td>${row.idReg}</td>
										<td>${row.dmReg}</td>
										<td>${row.idUpt}</td>
										<td>${row.dmUpt}</td>
										<td><span style="margin-right: 10px"
											class="btn_pack small"><a
												href="/st/customer/select?no=${row.no}">수정</a></span> <span
											class="btn_pack small"><input type="button" value="삭제"
												onclick="removeRow('${row.no}')"></span></td>
									</tr>
									<c:set var="countNo" value="${countNo-1}" />
								</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td width="70%" valign="top">

						<form
							action="/st/customer/${true eq isUpdate ? 'update' : 'insert'}"
							method="post" name="crudFrm" id="crudFrm"
							class="has-validation-callback">
							<input type="hidden" name="no" value="${view01.no}" />
							<fieldset>
								<legend></legend>
								<div class="form_table">
									<table border="1" cellspacing="0" summary="">
										<tbody>
											<tr>
												<th scope="row">거래처코드</th>
												<td><div class="item">${view01.cdCooperate}</div></td>
												<th scope="row">* 거래처명</th>
												<td><div class="item">
														<input type="text" maxlength="20"
															data-validation="required" value="${view01.nmCustomer}"
															class="i_text" name="nmCustomer" id="nmCustomer">
													</div></td>
											</tr>
											<tr>
												<th scope="row">사용여부</th>
												<td>
													<div class="item">
														<input type="radio" value="Y" class="i_radio" name="ynUse"
															id="ynUseY"
															<c:if test='${view01.ynUse=="Y"}'>checked</c:if>><label
															for="ynUseY">사용</label> <input type="radio" value="N"
															class="i_radio" name="ynUse" id="ynUseN"
															<c:if test='${view01.ynUse!="Y"}'>checked</c:if>><label
															for="ynUseN">사용안함</label>
													</div>
												</td>
												<th scope="row">접수 URL</th>
												<td><div class="item">
														<input type="text" maxlength="200" value="${view01.dsUrl}"
															class="i_text w200" name="dsUrl">
													</div></td>
											</tr>
											<tr>
												<td align="center" colspan="4"><span
													class="btn_pack medium icon"><span class="add"></span><a
														href="/st/customer/select">신규</a></span> <span
													class="btn_pack medium icon"><span class="check"></span><input
														type="submit" value="저장" id="submitBtn"></span></td>
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
<form action="/st/customer/delete" method="post" id="deleteFrm"
	name="deleteFrm">
	<input type="hidden" value="" name="no">
</form>
<script src="/js/jquery.form-validator.min.js" type="text/javascript"></script>
<script type="text/javascript">
 $(function() {
	// form validation
	window.applyValidation("#crudFrm");
	
	$("#start_date").datepicker(CALENDAR_SET);
 });
</script>
