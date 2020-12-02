<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<div id="fix_cont">
	<h1 class="pagename">대출과목관리</h1>
	<div class="search_area">
    <form method="get" action="/st/pdt/select" name="searchFrm">
    <input type="hidden" value="${param.no}" name="no">
    <input type="hidden" value="${param.page}" name="page">
            <table border="0" cellspacing="0" class="search_table" summary="검색폼">
                <tbody>
                    <tr>
                        <th>상품명</th>
                        <td><input type="text" class="s_text w70" name="searchNmPdt" value="${requestVO.getSearchNmPdt()}"></td>
                        <td style="padding-left: 10px"><span class="btn_icon search"><input type="submit" value="검 색" /></span></td>
                        <td style="padding-left: 10px"><a href="/st/pdt/select">초기화</a></td>
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
									<th>번호</th>
									<th>거래처</th>
									<th>상품코드</th>
									<th>상품명</th>
									<th>영업분류</th>
									<th>UPS분배코드</th>
									<th>약정이율</th>
									<th>연체이율</th>
									<th>상환방법</th>
									<th>상환개월수</th>
									<th>월원금상환율</th>
									<th>사용여부</th>
									<th>수정자</th>
									<th>수정일</th>
									<th>수정/삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="countNo" value="${pageListPaginator.totalCount - (pageListPaginator.startRow-1)}" />
								<c:forEach items="${pageList}" var="item" >
									<c:set var="bgcolor" value="#ffffff" />
									<c:if test="${param.no  eq  item.no}">
										<c:set var="bgcolor" value="#ffe8f3" />
									</c:if>
									<tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'">
										<td>${countNo}</td>
										<td>${item.cdCooperate}</td>
										<td>${item.cdPdt}</td>
										<td>${item.nmPdt}</td>
										<td>${item.cdSales}</td>
										<td>${item.idPdtUid}</td>
										<td>${item.rtNor}%</td>
										<td>${item.rtDly}%</td>
										<td>${item.cdKndPay}</td>
										<td>${item.noMonthPay}개월</td>
										<td>${item.rtMonthPay}%</td>
										<td>${item.ynUse eq 'Y' ? '사용' : '사용안함'}</td>
										<td>${item.idUpt}</td>
										<td>${item.dmUpt}</td>
										<td><span style="margin-right:10px" class="btn_pack small"><a href="#" onclick="pageMoveNo(${item.no})">수정</a></span> 
										<span class="btn_pack small"><input type="button" value="삭제" onclick="removeRow('${item.no}')"></span></td>
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
						<form action="/st/pdt/${true eq isUpdate ? 'update' : 'insert'}" method="post" name="crudFrm" id="crudFrm" class="has-validation-callback">
							<input type="hidden" name="no" value="${view.no}" />
							<fieldset>
								<legend></legend>
								<div class="form_table">
									<table border="1" cellspacing="0" summary="">
										<tbody>
											<tr>
												<th scope="row">거래처</th>
												<td>
												    <div class="item">
												        <select name="cdCooperate"  data-validation="required">
						                                <option value="" style="background:#ffffff">선 택</option>
						                                <c:forEach var="item" items="${code703}">
						                                    <option value="${item.code}"
						                                        <c:if test="${item.code eq  view.cdCooperate}">selected</c:if>>${item.text}</option>
						                                </c:forEach>                                                        
						                            </select>
												</div></td>
												<th scope="row">상품명</th>
												<td>
												    <div class="item">
                                                    <input type="text"  name="nmPdt"  maxlength="20" data-validation="required" value="${view.nmPdt}" class="i_text" >
                                                    </div>
                                                </td>
                                                <th scope="row">상품코드</th>
                                                <td>
                                                    <div class="item">
                                                    <input type="text"  name="cdPdt"  maxlength="20" data-validation="number"  value="${view.cdPdt }" class="i_text" >
                                                    </div>
                                                </td>
											    <th scope="row">UPS분배코드</th>
                                                <td>
                                                    <div class="item">
                                                    <input type="text"  name="idPdtUid"  maxlength="20"  value="${view.idPdtUid}" class="i_text" >
                                                    </div>
                                                </td>
                                          </tr>
                                          <tr>
                                                <th scope="row">영업분류</th>
                                                <td>
                                                    <select name="cdSales"  data-validation="required">
                                                        <option value="" style="background:#ffffff">선 택</option>
                                                        <c:forEach var="item" items="${code720}">
                                                            <option value="${item.code}"
                                                                <c:if test="${item.code eq view.cdSales}">selected</c:if>>${item.text}</option>
                                                        </c:forEach>                                                        
                                                    </select>
                                                </td>                                          
                                                <th scope="row">상환방법</th>
                                                <td>
                                                    <select name="cdKndPay"  data-validation="required">
                                                        <option value="" style="background:#ffffff">선 택</option>
                                                        <c:forEach var="item" items="${code113}">
                                                            <option value="${item.code}"
                                                                <c:if test="${item.code eq view.cdKndPay}">selected</c:if>>${item.text}</option>
                                                        </c:forEach>                                                        
                                                    </select>
                                                </td>
                                                <th scope="row">상환개월수</th>
                                                <td>
                                                    <div class="item">
                                                    <input type="text"  name="noMonthPay"  data-validation="number" value="${view.noMonthPay}" class="i_text" >개월
                                                    </div>
                                                </td>
                                                <th scope="row">사용여부</th>
                                                <td>
                                                    <div class="item">
                                                            <input type="radio" value="Y" class="i_radio" name="ynUse" id="ynUseY"
                                                                 <c:if test='${view.ynUse=="Y"}'>checked</c:if>><label for="ynUseY">사용</label> 
                                                            <input type="radio" value="N" class="i_radio" name="ynUse" id="ynUseN"
                                                                 <c:if test='${view.ynUse!="Y"}'>checked</c:if>><label for="ynUseN">사용안함</label>
                                                    </div>
                                                </td>
											</tr>
											<tr>
												<th scope="row">약정이율</th>
												<td>
                                                    <div class="item">
                                                    <input type="text"  name="rtNor"  data-validation="number" data-validation-allowing="float" maxlength="5"  value="${view.rtNor}" class="i_text" >
                                                    </div>
                                                </td>
                                                <th scope="row">연체이율</th>
                                                <td>
                                                    <div class="item">
                                                    <input type="text"  name="rtDly"  data-validation="number" data-validation-allowing="float" maxlength="5"   value="${view.rtDly}" class="i_text" >
                                                    </div>
                                                </td>
                                                <th scope="row">월원금상환율</th>
                                                <td>
                                                    <div class="item">
                                                    <input type="text"  name="rtMonthPay"  data-validation="number" data-validation-allowing="float" maxlength="5"   value="${view.rtMonthPay}" class="i_text" >
                                                    </div>
                                                </td>
											</tr>
											<tr>
												<td align="center" colspan="4"><span class="btn_pack medium icon"><span class="add"></span><a href="/st/pdt/select">신규</a></span> <span
													class="btn_pack medium icon"><span class="check"></span><input type="submit" value="저장" id="submitBtn"></span></td>
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
<form action="/st/pdt/delete" method="post" id="deleteFrm" name="deleteFrm">
<input type="hidden" value="" name="no">
</form>
<script src="/js/jquery.form-validator.min.js" type="text/javascript"></script>
<script type="text/javascript">
 $(function() {
	// form validation
	window.applyValidation("#crudFrm");
	
	$("#start_date").datepicker(CALENDAR_SET);
	
	<c:if test="${requestResultVO.errors ne null }" >
	printError("${requestResultVO.errors}");
	</c:if>
 });
 
//검색폼 페이징이동
 function pageMoveNo(no){
     var f = document.searchFrm; 
     f.no.value = no;
     f.submit();
 }
</script>
