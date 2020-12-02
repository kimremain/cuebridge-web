<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<h1 class="pagename">시스템주요설정</h1>
<div style="padding-top: 10px; width: 500px">
	<form id="crudFrm" name="insertFrm" method="post"
		action="/st/setting/update">
		<fieldset>
			<legend></legend>
			<div class="form_table">
				<table border="1" cellspacing="0" summary="">
					<tbody>
						<tr>
							<th scope="row">일배치허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynDailyBatch" id="ynDailyBatchY"
										value="Y"
										<c:if test='${setting.ynDailyBatch == "Y"}'>checked</c:if> /><label
										for="ynDailyBatchY">허용</label> <input type="radio"
										name="ynDailyBatch" id="ynDailyBatchN" value="N"
										<c:if test='${setting.ynDailyBatch != "Y"}'>checked</c:if> /><label
										for="ynDailyBatchN">허용안함</label>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">자동배정허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynScreenAssign" id="ynScreenAssignY"
										value="Y"
										<c:if test='${setting.ynScreenAssign == "Y"}'>checked</c:if> /><label
										for="ynScreenAssignY">허용</label> <input type="radio"
										name="ynScreenAssign" id="ynScreenAssignN" value="N"
										<c:if test='${setting.ynScreenAssign != "Y"}'>checked</c:if> /><label
										for="ynScreenAssignN">허용안함</label>
								</div>
							</td>
						</tr>						
						<tr>
							<th scope="row">직원동기화허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynSyncUser" id="ynSyncUserY"
										value="Y"
										<c:if test='${setting.ynSyncUser == "Y"}'>checked</c:if> /><label
										for="ynSyncUserY">허용</label> <input type="radio"
										name="ynSyncUser" id="ynSyncUserN" value="N"
										<c:if test='${setting.ynSyncUser != "Y"}'>checked</c:if> /><label
										for="ynSyncUserN">허용안함</label>
								</div>
							</td>
						</tr>
 						<tr>
							<th scope="row">팀동기화허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynSyncTeam" id="ynSyncTeamY"
										value="Y"
										<c:if test='${setting.ynSyncTeam == "Y"}'>checked</c:if> /><label
										for="ynSyncTeamY">허용</label> <input type="radio"
										name="ynSyncTeam" id="ynSyncTeamN" value="N"
										<c:if test='${setting.ynSyncTeam != "Y"}'>checked</c:if> /><label
										for="ynSyncTeamN">허용안함</label>
								</div>
							</td>
						</tr>															
						<tr>
							<th scope="row">온라인배치허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynOnlineBatch" id="ynOnlineBatchY"
										value="Y"
										<c:if test='${setting.ynOnlineBatch == "Y"}'>checked</c:if> /><label
										for="ynOnlineBatchY">허용</label> <input type="radio"
										name="ynOnlineBatch" id="ynOnlineBatchN" value="N"
										<c:if test='${setting.ynOnlineBatch != "Y"}'>checked</c:if> /><label
										for="ynOnlineBatchN">허용안함</label>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">사용자MSG송신허용여부</th>
							<td>
								<div class="item">
									<input type="radio" name="ynUserMsg" id="ynUserMsgY" value="Y"
										<c:if test='${setting.ynUserMsg == "Y"}'>checked</c:if> /><label
										for="ynUserMsgY">허용</label> <input type="radio"
										name="ynUserMsg" id="ynUserMsgN" value="N"
										<c:if test='${setting.ynUserMsg != "Y"}'>checked</c:if> /><label
										for="ynUserMsgN">허용안함</label>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">한신정거래기관코드</th>
							<td>
								<div class="item">
									<input type="text" name="dsNiceCd" class="i_text"
										value="${setting.dsNiceCd}" data-validation="required" />
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">한신정TCPID</th>
							<td>
								<div class="item">
									<input type="text" name="dsNiceTcpId" class="i_text"
										value="${setting.dsNiceTcpId}" data-validation="required" />
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">한신정FTPID</th>
							<td>
								<div class="item">
									<input type="text" name="dsNiceFtpId" class="i_text"
										value="${setting.dsNiceFtpId}" data-validation="required" />
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">수정자</th>
							<td>
								<div class="item">${setting.idUpt}</div>
							</td>
						</tr>
						<tr>
							<th scope="row">수정일시</th>
							<td>
								<div class="item">${setting.dmUpt}
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><span
								class="btn_pack medium icon"><span class="check"></span><input
									type="submit" id="submitBtn" value="저장"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</form>
</div>
<script type="text/javascript" src="/js/jquery.form-validator.min.js"></script>
<script type="text/javascript">
 $(function() {
    
	// form validation
	window.applyValidation('#crudFrm');
	
});

</script>
