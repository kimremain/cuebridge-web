<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<div id="fix_cont">
	<h1 class="pagename">사용자 관리</h1>
	<div class="pt10">
		<form method="post" action="/st/user/select" name="searchFrm" id="searchFrm">
		<input type="hidden" name="searchFlag" value="Y" />
			<div class="search_area">
				<fieldset>
					<input type="hidden" value="" name="page">
					<legend></legend>
					<table border="0" cellspacing="0" class="search_table"
						summary="검색폼">
						<tbody>
							<tr>
								<th>성명</th>
								<td><input type="text" class="s_text w100"
									value="${requestVO.searchNmUser}" name="searchNmUser"
									id="searchNmUser"></td>
								<th>팀</th>
								<td>
									<div class="item">
									<select name="searchCdTeam">
									    <option value="" style="background:#ffffff">선 택</option>
										<c:forEach var="item" items="${teamList}">
											<option value="${item.code}"
												<c:if test="${item.code==requestVO.searchCdTeam}">selected</c:if>>${item.text}</option>
										</c:forEach>								                    
									</select>	
									</div>								
								</td>
								<th>퇴사여부</th>
                                <td>
                                    <div class="item">
                                    <select name="searchYnResign">
                                        <option value="" style="background:#ffffff">선 택</option>
                                        <option value="N" <c:if test="${'N' eq requestVO.searchYnResign}">selected</c:if>>재직</option>
                                        <option value="Y" <c:if test="${'Y' eq requestVO.searchYnResign}">selected</c:if>>퇴사</option>                                                 
                                    </select>   
                                    </div>                              
                                </td>
                                <td>
									<input type="checkbox" class="p_checkbox" name="searchYnScreen" id="searchYnScreen" value="Y" <c:if test="${'Y' eq requestVO.searchYnScreen}">checked</c:if> > <label for="searchYnScreen"><strong>심사자</strong></label>
								</td>
								<td>
									<input type="checkbox" class="p_checkbox" name="searchYnConfirm" id="searchYnConfirm" value="Y" <c:if test="${'Y' eq requestVO.searchYnConfirm}">checked</c:if> > <label for="searchYnConfirm"><strong>결재자</strong></label>
								</td>
								<td>
                                    <input type="checkbox" class="p_checkbox" name="searchYnScreenAssign" id="searchYnScreenAssign" value="Y" <c:if test="${'Y' eq requestVO.searchYnScreenAssign}">checked</c:if> > <label for="searchYnScreenAssign"><strong>자동배정</strong></label>
                                </td>
							
								<td style="padding-left: 10px"><span
									class="btn_pack medium"><input type="submit" value="검 색"></span></td>
								<td style="padding-left: 10px"><span
									class="btn_pack medium icon"> <span class="refresh"></span>
										<input type="button" onclick="serchFormReset()" value="초기화"></span>
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</form>
		<br>
		<table border="0" width="100%" height="800" cellspacing="0"
			cellpadding="0">
			<tr>
				<td width="50%" valign="top">
				    <div style="height:700px;overflow-y:scroll">
					<table border="1" cellspacing="0" id="sort_table" class="basic_tbl">
						<thead>
							<tr>
								<th data-sort="string">아이디</th>
								<th data-sort="string">성명</th>
								<th data-sort="string">팀</th>
								<th data-sort="string">담당업무</th>
								<th data-sort="string">퇴사여부</th>
								<th data-sort="string">심사자</th>
								<th data-sort="string">결재자</th>
								<th data-sort="string">자동배정</th>
								<th data-sort="string">배정비율</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="list">
								<c:set var="bgcolor" value="#ffffff" />
								<c:if test="${param.searchNo  eq  list.no}">
									<c:set var="bgcolor" value="#ffe8f3" />
								</c:if>
								<tr bgcolor="${bgcolor}" style="cursor: pointer;"
									onmouseout="this.style.backgroundColor='${bgcolor}'"
									onmouseover="this.style.backgroundColor='#EAECF5'"
									onclick="window.location='/st/user/select?searchNo=${list.no}&searchNmUser=${requestVO.searchNmUser}&searchCdTeam=${requestVO.searchCdTeam}#${list.idUser}'">
									<td id="${list.idUser}">${list.idUser}</td>
									<td>${list.nmUser}</td>
									<td>${list.cdTeam}</td>
									<td>${list.cdPart}</td>
									<td>${'Y' eq list.ynResign ? '퇴사' : '재직'}</td>
									<td>${list.ynScreen}</td>
									<td>${list.ynConfirm}</td>
									<td>${list.ynScreenAssign}</td>
									<td>${list.cdScreenRatio}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</td>
				<td width="50%" valign="top" style="padding-left: 20px">
					<form id="crudFrm" name="crudFrm" method="post" action="/st/user/update" >
						<input type="hidden" name="no" id="no" value="${view.no}">
						<fieldset>
							<legend></legend>
							<div class="form_table">
								<table border="1" cellspacing="0" summary="">
									<tbody>
										<tr>
											<th scope="row">아이디</th>
											<td name="idUser" id="idUser" value="">${view.idUser}</td>
										</tr>
										<tr>
											<th scope="row">이름</th>
											<td name="nmUser" id="nmUser" value="">${view.nmUser}</td>
										</tr>									
										<sec:authorize access="hasRole('72199')">
										<tr>
											<th scope="row">시스템권한</th>
											<td>
												<div class="item">
												<select name="cdRoleApply"  data-validation="required">
								                    <option value="" style="background:#ffffff">선 택</option>
													<c:forEach var="item" items="${code721}">
														<option value="${item.code}"
															<c:if test="${item.code==view.cdRoleApply}">selected</c:if>>${item.text}</option>
													</c:forEach>									                    
								                </select>												
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row">팀</th>
											<td>
												<div class="item">
												<select name="cdTeam"  data-validation="required">
								                    <option value="" style="background:#ffffff">선 택</option>
													<c:forEach var="item" items="${teamList}">
														<option value="${item.code}"
															<c:if test="${item.code==view.cdTeam}">selected</c:if>>${item.text}</option>
													</c:forEach>								                    
								                </select>	
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row">담당업무코드</th>
											<td>
												<div class="item">
												<select name="cdPart"  data-validation="required">
								                    <option value="" style="background:#ffffff">선 택</option>
													<c:forEach var="item" items="${code701}">
														<option value="${item.code}"
															<c:if test="${item.code==view.cdPart}">selected</c:if>>${item.text}</option>
													</c:forEach>									                    
								                </select>												
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row">이메일</th>
											<td><input name="dsEmail" id="dsEmail" type="text" class="i_text" value="${view.dsEmail}"></td>
										</tr>

										<tr>
											<th scope="row">직급코드</th>
											<td>
												<div class="item">
												<select name="cdRank" data-validation="required">
								                    <option value="" style="background:#ffffff">선 택</option>
													<c:forEach var="item" items="${code133}">
														<option value="${item.code}"
															<c:if test="${item.code==view.cdRank}">selected</c:if>>${item.text}</option>
													</c:forEach>										                    
								                </select>	
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row">핸드폰번호</th>
											<td><input name="noHp" id="noHp" type="text" class="i_text" value="${view.noHp}"></td>
										</tr>
										<tr>
											<th scope="row">시스템관리자</th>
											<td >
												<div class="item">
													<input type="radio" value="Y" class="i_radio" name="ynAdmin"
													<c:if test="${view.ynAdmin=='Y'}">checked</c:if>>
													<label for="ynAdminY">여</label> 
													<input type="radio" value="N" class="i_radio" name="ynAdmin"
													<c:if test="${view.ynAdmin=='N'}">checked</c:if>>
													<label for="ynAdminN">부</label>
												</div>		
											</td>											
										</tr>
										<tr>
											<th scope="row">심사자</th>
											<td >
												<div class="item">
													<input type="radio" value="Y" class="i_radio" name="ynScreen"
													<c:if test="${view.ynScreen=='Y'}">checked</c:if>>
													<label for="ynScreenY">여</label> 
													<input type="radio" value="N" class="i_radio" name="ynScreen"
													<c:if test="${view.ynScreen=='N'}">checked</c:if>>
													<label for="ynScreenN">부</label>
												</div>		
											</td>												
										</tr>
										<tr>
											<th scope="row">결재자</th>
											<td >
												<div class="item">
													<input type="radio" value="Y" class="i_radio" name="ynConfirm"
													<c:if test="${view.ynConfirm=='Y'}">checked</c:if>>
													<label for="ynConfirmY">여</label> 
													<input type="radio" value="N" class="i_radio" name="ynConfirm"
													<c:if test="${view.ynConfirm=='N'}">checked</c:if>>
													<label for="ynConfirmN">부</label>
												</div>		
											</td>												
										</tr>					
										</sec:authorize>
										<tr>
											<th scope="row">자동배정</th>
											<td >
												<div class="item">
													<input type="radio" value="Y" class="i_radio" name="ynScreenAssign"
													<c:if test="${view.ynScreenAssign=='Y'}">checked</c:if>>
													<label for="ynConfirmY">여</label> 
													<input type="radio" value="N" class="i_radio" name="ynScreenAssign"
													<c:if test="${view.ynScreenAssign=='N'}">checked</c:if>>
													<label for="ynConfirmN">부</label>
												</div>		
											</td>												
										</tr>
										<tr>
											<th scope="row">배정비율</th>
											<td>
												<div class="item">
												<select name="cdScreenRatio" data-validation="required">
								                    <option value="" style="background:#ffffff">선 택</option>
													<c:forEach var="item" items="${code713}">
														<option value="${item.code}"
															<c:if test="${item.code==view.cdScreenRatio}">selected</c:if>>${item.text}</option>
													</c:forEach>										                    
								                </select>	
												</div>
											</td>
										</tr>																
										<tr style="display:none">
                                            <th scope="row">최대심사건수</th>
                                            <td >
                                                <div class="item" >
                                                    <input type="text" name="cnScreenMax"  value="${view.cnScreenMax}" class="i_text" />                                       
                                                </div>      
                                            </td>                                               
                                        </tr>
										<tr>
											<td colspan="2" align="center"><span
												class="btn_pack medium icon"><span class="check"></span><input type="submit" id="submitBtn" value="저장"></span></td>
										</tr>
									</tbody>
								</table>
							</div>
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript" src="/js/stupidtable.min.js"></script>
<script type="text/javascript" src="/js/jquery.form-validator.min.js"></script>
<script type="text/javascript">
	$(function() {
		// filter table 
		//$('#sort_table').filterTable();

		// sort table 
		strupidtableSetting("sort_table");

		// form validation
		window.applyValidation('#crudFrm');
	});

	$('#dataset').bind(
			'click',
			function(e) {
				$(e.target).closest('tr').children('td,th').css(
						'background-color', '#000');
			});
</script>
