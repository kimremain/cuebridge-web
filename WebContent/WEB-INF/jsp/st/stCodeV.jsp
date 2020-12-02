<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">코드관리</h1>
	<div class="pt10">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td width="30%" valign="top">
						<table border="0" cellspacing="0" class="basic_tbl"
							id="sort_table">
							<thead>
								<tr>
									<th data-sort="string">그룹코드</th>
									<th data-sort="string">그룹명</th>
									<th>그룹명수정</th>
									<th>하위코드관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${groupList}" var="row" varStatus="rowStatus">
									<c:set var="bgcolor" value="#ffffff" />
									<c:if test="${param.searchGroupCode  eq  row.cdGroup}">
										<c:set var="bgcolor" value="#ffe8f3" />
									</c:if>
									<tr bgcolor="${bgcolor}"
										onmouseout="this.style.backgroundColor='${bgcolor}'"
										onmouseover="this.style.backgroundColor='#EAECF5'">
										<td>${row.cdGroup}</td>
										<td style="color: #fff; font-size: 0px;">${row.nmGroup}<input
											type="text" id="NM_GROUP_${row.cdGroup}" name="NM_GROUP"
											class="i_text" value="${row.nmGroup}" maxlength="10"></td>
										<td><span style="margin-right: 10px"
											class="btn_pack small"><a
												onclick="updateGroupInfo('${row.cdGroup}');" href="#">그룹수정</a></span></td>
										<td><span style="margin-right: 10px"
											class="btn_pack small"><a
												href="/st/code/select?searchGroupCode=${row.cdGroup}">코드관리</a></span></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<form method="post" action="/st/groupcode/insert" name="registGrpFrm" id="registGrpFrm" onsubmit="return registGrpFrmCheck(this);">
									<tr>
										<td><input type="text" maxlength="3" class="i_text"
											name="cdGroup" value="<c:if test="null ne groupCodeResultVO">${groupCodeResultVO.cdGroup}</c:if>" ></td>
										<td><input type="text" maxlength="10" class="i_text"
											name="nmGroup" value="<c:if test="null ne groupCodeResultVO">${groupCodeResultVO.nmGroup}</c:if>"></td>
										<td><span style="margin-right: 10px"
											class="btn_pack small"><input type="submit"
												value="그룹추가"  ></span></td>
										<td>&nbsp;</td>
									</tr>
								</form>
							</tfoot>
						</table>
					</td>
					<td width="70%" valign="top" style="padding-left: 20px">
						<!-- 자식코드 시작 --> <c:if test="${null ne param.searchGroupCode}">

							<form action="/st/code/updatebatch" method="post"
								name="updateOrderFrm" id="updateOrderFrm">
								<input type="hidden" name=changeCodeStr /> <input
									type="hidden" name="cdGroup" value="${param.searchGroupCode}" />
								<table border="0" cellspacing="0" class="basic_tbl"
									id="scroll_tbl_child">
									<thead>
										<tr>
											<th>순서</th>
											<th>그룹코드</th>
											<th>코드</th>
											<th>코드명</th>
											<th>사용여부</th>
											<th>등록자</th>
											<th>등록일시</th>
											<th>수정자</th>
											<th>수정일시</th>
											<th>수정/삭제</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${codeList}" var="row" varStatus="rowStatus">
											<tr bgcolor="#ffffff"
												onmouseout="this.style.backgroundColor='#ffffff'"
												onmouseover="this.style.backgroundColor='#EAECF5'">
												<td>
												<input type="hidden" name="changeOrderCodeNo"   value="${row.no}" />
                                                <input type="text" name="changeOrderNum" class="i_text w30"  value="${row.noOrder}" />
												
					
												<td>${row.cdGroup}</td>
												<td>${row.cd}</td>
												<td>${row.nmCd}</td>
												<td>${row.ynUse eq "Y" ? "사용" : "미사용"}</td>
												<td>${row.idReg}</td>
												<td>${row.dmReg}</td>
												<td>${row.idUpt}</td>
												<td>${row.dmUpt}</td>
												<td><span style="margin-right: 10px"
													class="btn_pack small"><a
														onclick="cdUpdate('${row.no}','${row.noOrder}','${row.cd}','${row.nmCd}','${row.ynUse}');return false;"
														href="#">수정</a></span> <span class="btn_pack small"><input
														type="button" value="삭제" onclick="removeRow('${row.no}')"></span>
												</td>
											</tr>
										</c:forEach>
										<tr>
											<td style="text-align: left" colspan="10"><span
												class="btn_pack medium "><input type="submit"
													value="순서일괄변경" ></span> <span
												class="btn_pack medium "><input type="button"
													onclick="cdRegist()" value="신규추가"></span></td>
										</tr>
									</tbody>
								</table>
							</form>

							<div id="codeFormArea" style="display: none">
								<form action="/st/code/insert" method="post" name="codeFrm"
									id="codeFrm">
									<input type="hidden" name="no"> 
									<input type="hidden" name="cdGroup" value="${param.searchGroupCode}">
									<table border="0" cellspacing="0" style="margin-top: 20px"
										class="basic_tbl">
										<thead>
											<tr>
												<th>순서</th>
												<th>그룹코드</th>
												<th>코드</th>
												<th>코드명</th>
												<th>사용여부</th>
												<th>추가/수정</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" data-validation="number" class="i_text w30" name="noOrder" maxlength="3"></td>
												<td>${param.searchGroupCode}</td>
												<td><input type="text" data-validation="number" name="cd" class="i_text" maxlength="5"></td>
												<td><input type="text" data-validation="required" name="nmCd" class="i_text" maxlength="15"></td>
												<td><input type="radio" value="Y" class="i_radio" name="ynUse" id="YN_USE_Y" checked><label
													for="YN_USE_Y">사용</label> <input type="radio" value="N"
													class="i_radio" name="ynUse" id="YN_USE_N"><label
													for="YN_USE_N">사용안함</label></td>
												<td><span class="btn_pack medium "><input
														type="submit" value="확 인" id="submitBtn"></span></td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</c:if> <!-- 자식코드 끝 -->

					</td>
				</tr>
			</tbody>
		</table>

	</div>
</div>

<script type="text/javascript" src="/js/stupidtable.min.js"></script>
<script type="text/javascript" src="/js/jquery.form-validator.min.js"></script>
<script type="text/javascript">
	$(function() {
		//window.applyValidation('#registGrpFrm');
		window.applyValidation('#codeFrm');

		// sort table 
		strupidtableSetting("sort_table");
	});
	// 그룹명수정
	function updateGroupInfo(gcode) {

		var f = document.updateGroupFrm;
		var nm_group_input = $("#NM_GROUP_" + gcode).val();
		if (!nm_group_input) {
			alert("그룹명을 입력하셔야 합니다.");
		} else {
			f.nmGroup.value = nm_group_input;
			f.cdGroup.value = gcode;
			process_start();
			f.submit();
		}
	}
	// 그룹추가 
	function registGrpFrmCheck(f) {
		if (!f.cdGroup.value) {
			alert("그룹코드를 입력하셔야 합니다.");
			return false;
		} else if (!f.nmGroup.value) {
			alert("그룹명을 입력하셔야 합니다.");
			return false;
		} else {
			return true;
		}
	}
	// 코드 수정폼 셋팅
	function cdUpdate(no,no_order, cd, nm_cd, yn_use) {
		var f = document.codeFrm;
		f.reset();
		f.action = "/st/code/update";
	    f.no.value = no;
		f.noOrder.value = no_order;
		f.cd.value = cd;
		f.cd.disabled = true;
		f.nmCd.value = nm_cd;
		if (yn_use == 'Y') {
			$("#YN_USE_Y").attr("checked", true);
		} else {
			$("#YN_USE_N").attr("checked", true);
		}
		$("#submitBtn").val("수 정");
		layerFormOpen();

	}
	// 코드 등록폼 셋팅
	function cdRegist() {
		var f = document.codeFrm;
		f.cd.disabled = false;
		f.reset();
		f.action = "/st/code/insert";
		//f.mode.value = "regist";
		$("#submitBtn").val("추 가");
		layerFormOpen()
	}
	// 코드 폼 레이어 오픈 
	function layerFormOpen() {
		//$.blockUI({ message:$("#codeFormArea"),onOverlayClick: $.unblockUI ,cursor: null });
		$.blockUI({
			message : $("#codeFormArea"),
			css : {
				width : '900px',
				height : '100px',
				left : '25%',
				top : '25%',
				border : '2px solid #eaeaea',
				padding : '15px',
				opacity : .8,
				color : '#fff',
				cursor : null
			},
			onOverlayClick : $.unblockUI
		});
	}
	// 순서일괄변경 - 사용안함
	/*
	function codeOrderChange() {
		var orderChangeVars = "";
		$('input[name=changeNoOrder]').each(function() {
			orderChangeVars += $(this).val() + "-" + $(this).attr("no") + "&";
		});
		document.updateOrderFrm.changeCodeStr.value = orderChangeVars;
		document.updateOrderFrm.submit();
	}*/

<c:if test="${requestResultVO.errors ne null }" >
$(function() {
    printError("${requestResultVO.errors}");
});
</c:if>
<c:if test="${groupCodeResultVO.errors ne null}" >
$(function() {
    printError("${groupCodeResultVO.errors}");
});
</c:if>
</script>

<!-- 그룹명 수정폼  -->
<form id="updateGroupFrm" name="updateGroupFrm" method="post"
	action="/st/groupcode/update">
	<input type="hidden" name="nmGroup" value="" /> <input type="hidden"
		name="cdGroup" value="" />
</form>
<!-- 코드 삭제폼  -->
<form id="deleteFrm" name="deleteFrm" method="post"
	action="/st/code/delete">
	<input type="hidden" name="no" value="" /> <input type="hidden"
		name="cdGroup" value="${param.searchGroupCode}" />
</form>