<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>
<%// 탭메뉴 노출 결정  %>
<c:set var="displayCustom" value="none" />
<c:set var="displaySurety"  value="none" />
<c:set var="displayBex"  value="none" />
 <c:choose> 
    <c:when test="${!empty param.searchNoSurety}"> 
        <c:set var="tabClassSurety" value="selected" />
        <c:set var="displaySurety" value="" />
    </c:when> 
    <c:when test="${'71004' eq view.cdStatus}"> 
        <c:set var="tabClassBex" value="selected" />
        <c:set var="displayBex" value="" />
    </c:when> 
    <c:otherwise> 
        <c:set var="tabClassCustom" value="selected" />
        <c:set var="displayCustom" value="" />
    </c:otherwise> 
</c:choose>
<%//상담완료,상담종료,거절,취소,허위접수,삭제 스탭에 정보변경불가 %>
<c:if test="${fn:contains('71004,71005,71007,71008,71011,71012',view.cdStatus)}">
    <c:set var="selectDisabled" value="disabled" />
    <c:set var="textReadonly" value="readonly" />
</c:if>

<ul class="tab_menu" id="info_tab_menu" style="cursor: pointer;">
	<li id="info_tab_menu_custom" class="${tabClassCustom}"><a onclick="tabChange('custom')">고객정보</a></li>
	<li id="info_tab_menu_surety" class="${tabClassSurety}">
	 <c:choose> 
	    <c:when test="${'0' eq view.cnSurety  }">
	        <a href="#" onclick="tabChange('surety')">보증인정보(${view.cnSurety})</a>
	     </c:when> 
	    <c:otherwise>
	        <a href="/brc/loan/select?searchNoReq=${view.noReq}&searchNoSurety=${param.searchNoSurety ? param.searchNoSurety : '001' }">보증인정보(${view.cnSurety})</a>
	    </c:otherwise> 
	</c:choose>
	</li>
	<li id="info_tab_menu_bex"  class="${tabClassBex}"><a onclick="tabChange('bex')">실행현황</a></li>
	<li id="info_tab_menu_tm"><a onclick="tabChange('tm')">비대면관리대장</a></li>
</ul>
<div style="border: 1px solid #aaa; border-top: 0px; border-bottom: 0px;min-height: 835px;">
	
    <%//############# 고객정보 영역 ############## %>
	<div class="info_tab" style="display:${displayCustom};" id="custom">
		<div class="sub_section"  >
			<div style="position: relative;z-index:8000;">
				<div style="position: absolute; top: 2px; right: 0px">
					<table border="0" cellspacing="0" class="search_btn_tbl" >
						<tbody>
							<tr>
								<td><a onclick="window.open(LINCUS_DOMAIN+'/ups/application/calculator.php','calculator','left=0,top=0,scrollbars=yes');" href="#">계산기</a> |</td>
								<td><a onclick="relationRequest('N');" href="#">연계검사</a>|</td>
								<td><a onclick="relationLincusRequest('N');" href="#">(E)연계검사</a>|</td>
                                <%-- <c:if test="${'Y' eq view.ynCdtInquiry}"> --%>
								<td><a onclick="hsjRequest('hsj_cb_gappl.php','${view.dsNiceSafekey}','N');" href="#">맞춤형CB정보</a>|</td>
								<%-- <td><a onclick="hsjRequest('total_hsj.php','${view.dsNiceSafekey}','N');" href="#">CFS+CB정보</a>|</td> --%>
								<td><a onclick="hsjRequest('hsj_cb.php','${view.dsNiceSafekey}','N');" href="#">CB조회</a> |</td>
								<%-- <td><a onclick="hsjRequest('hsj_cfs.php','${view.dsNiceSafekey}','N');" href="#">CFS조회</a> | </td> --%>
								<td><a onclick="hsjRequest('hsj_tr800.php','${view.dsNiceSafekey}','N');" href="#">CSS조회</a> | </td>
								<td><a onclick="hsjRequest('hsj_tr800_new.php','${view.dsNiceSafekey}','N');" href="#">신CSS조회</a> | </td>
								<%-- <td><a onclick="hsjRequest('hsj_2a116.php','${view.dsNiceSafekey}','N');" href="#">헌터조회</a> | </td> --%>
                                <%-- </c:if> --%>
								<td><a onclick="npacRequest('search','${view.ynNiceSafekey}','','N', 'old');" href="#">SafeKey조회</a> | </td>
								<td><a onclick="npacRequest('search','${view.ynNiceSafekey}','','N', 'new');" href="#">신SafeKey조회</a></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
			<h3 style="position: relative;" class="sub_title">※ ${view.nmCustom} 고객정보 (${view.noReq})</h3>
			<form id="brcFrm" name="brcFrm" method="post" action="/brc/loan/update">		
			<input type="hidden" name="noReq" id="noReq" value="${view.noReq}">
			<input type="hidden" name="beforeCdStatus" value="${view.cdStatus}">
			<input type="hidden" name="dsAccessIp" id="dsAccessIp" value="${view.dsAccessIp}">
			<table border="1" cellspacing="0" summary="고객정보" class="crud_tbl">
				<tbody>			
					<tr>
						<th width="100">신용조회<br>가능여부</th>
						<td width="350">								
						<c:if test="${'Y' eq userVO.ynConfirm}">
						       <input type="radio" value="Y" class="i_radio" name="ynCdtInquiry" <c:if test="${'Y' eq view.ynCdtInquiry}">checked</c:if> >
                               <label for="ynCdtInquiryY">예</label>
                               <input type="radio" value="N" class="i_radio" name="ynCdtInquiry" <c:if test="${'N' eq view.ynCdtInquiry}">checked</c:if> >
                               <label for="ynCdtInquiryN">아니오</label>
						</c:if>
						<c:if test="${'Y' ne userVO.ynConfirm}">
						       <input type="radio" value="Y" class="i_radio" name="ynCdtInquiry" <c:if test="${'Y' eq view.ynCdtInquiry}">checked</c:if> 
						       																							<c:if test="${'Y' ne view.ynCdtInquiry}">disabled</c:if>>
                               <label for="ynCdtInquiryY">예</label>
                               <input type="radio" value="N" class="i_radio" name="ynCdtInquiry" <c:if test="${'N' eq view.ynCdtInquiry}">checked</c:if>
						       																							<c:if test="${'N' ne view.ynCdtInquiry}">disabled</c:if>>
                               <label for="ynCdtInquiryN">아니오</label>
						</c:if>
                         </td>
						<th width="100">신용조회<br>요약정보</th>
						<td width="450">
							<table class="ExcelTable2007">
								<tr>
									<th>&nbsp;대부건수&nbsp;</th>
									<th>&nbsp;대부금액&nbsp;</th>
									<th>&nbsp;CB등급&nbsp;</th>
									<th>&nbsp;SP등급&nbsp;</th>
									<th>&nbsp;PI등급&nbsp;</th>
									<th>&nbsp;AS등급&nbsp;</th>
									<th>&nbsp;판정결과&nbsp;</th>
									<th>&nbsp;전략한도&nbsp;</th>
								</tr>
								<tr>
									<td class="heading">&nbsp;${view.dsCntCb}&nbsp;</td>
									<td class="heading">&nbsp;${view.dsAmtCb}&nbsp;</td>
									<td class="heading">&nbsp;${view.ds2ndRank}&nbsp;</td>
									<td class="heading">&nbsp;${view.ds1stRank}&nbsp;</td>
									<td class="heading">&nbsp;${view.dsPiRank}&nbsp;</td>
									<td class="heading">&nbsp;${view.dsAssRank}&nbsp;</td>
									<td class="heading">&nbsp;${view.cdTactic}&nbsp;</td>
									<td class="heading">&nbsp;${view.cdTacticLimit}&nbsp;</td>									
								</tr>
							</table>					
						</td>	
					</tr>
					<tr>
						<th width="100">대출과목</th>
						<td width="350">
							<select name="cdPdt"  style="width:138px" data-validation="required" ${selectDisabled} >
	                            <option value="" style="background:#ffffff">선 택</option>
	                            <c:forEach var="item" items="${pdtList}">
	                                <option value="${item.code}"
	                                    <c:if test="${item.code==view.cdPdt}">selected</c:if>>${item.text}</option>
	                            </c:forEach>                                                        
	                        </select>
						</td>				
						<th width="100">접수경로</th>
						<td width="450">					
							<div class="item">	
							<select name="cdPath"  data-validation="required" ${selectDisabled} >
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code704}">
									<option value="${item.code}"
										<c:if test="${item.code==view.cdPath}">selected</c:if>>${item.text}</option>
								</c:forEach>									                    
							</select>
							<font color="6699FF">&nbsp;${view.nmEkeyword}</font>
							</div>			
						</td>
					</tr>
					<tr>
						<th>고객명</th>
						<td>
						<c:choose>
						<c:when test="${('Y' == userVO.ynConfirm)}">
						<input type="text" class="i_text" name="nmCustom" value="${view.nmCustom}" data-validation="required">
						       &nbsp;<a onclick="relationRequest('N');" href="#"><span class="btn_icon search">연계검사</span></a>
						</c:when>
						<c:otherwise>
						<input type="text" class="i_text" name="nmCustom" value="${view.nmCustom}" data-validation="required" ${textReadonly}>
						       &nbsp;<a onclick="relationRequest('N');" href="#"><span class="btn_icon search">연계검사</span></a>						
						</c:otherwise>
						</c:choose>
						</td>
						<th>핸드폰</th>
						<td>
							<div class="item">	
							<select name="cdKndMobile" >
							    <option value=" " style="background:#ffffff">선 택</option><!--초기화 하는경우 있어 공백추가-->
								<c:forEach var="item" items="${code708}">
									<option value="${item.code}"
										<c:if test="${item.code==view.cdKndMobile}">selected</c:if>>${item.text}</option>
								</c:forEach>									                    
							</select>											
							     <input type="text" value="${view.noTel1Mobile}" class="i_text w30" name="noTel1Mobile" maxlength="3" ${textReadonly}>
								- <input type="text" value="${view.noTel2Mobile}" class="i_text w30" name="noTel2Mobile" maxlength="4" ${textReadonly}>
								- <input type="text" value="${view.noTel3Mobile}" class="i_text w30" name="noTel3Mobile" maxlength="4" ${textReadonly}>
								<a href="#" onclick="clicktocall('${view.noTel1Mobile}${view.noTel2Mobile}${view.noTel3Mobile}')"><span class="btn_icon phone">통화하기</span></a>
								<a href="#" onclick="hpAuthLincusRequest(
                                                                                                    'BRG',
                                                                                                    '${view.noReq}',
                                                                                                    'M',
                                                                                                    '${view.noCustom}',
                                                                                                    '${view.nmCustom}',
                                                                                                    '${userVO.idUser}'
                                                                                                    )"><span class="btn_icon email">인증</span></a>
							</div>							
						</td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" value="${view.noCustom}" class="i_text" name="noCustom" id="noCustom" maxlength="14" onblur="$('#ageSexMsg').html(getAgeSexMsg(this.value))" ${textReadonly}>
							<span id="ageSexMsg"></span>
						</td>
						<th>위탁동의여부</th>
						<td>
						       <input type="radio" value="Y" class="i_radio" id="YN_NICE_SAFEKEY_Y" name="ynNiceSafekey"  onclick="$('#safeKeyRequestBtn').show()" <c:if test="${'Y' eq view.ynNiceSafekey}">checked</c:if> >
                               <label for="YN_NICE_SAFEKEY_Y">예</label>
                               <input type="radio" value="N" class="i_radio" id="YN_NICE_SAFEKEY_N" name="ynNiceSafekey" onclick="$('#safeKeyRequestBtn').hide()" <c:if test="${'N' eq view.ynNiceSafekey}">checked</c:if>>
                               <label for="YN_NICE_SAFEKEY_N">아니오</label>
<%--                                <span class="btn_icon key" id="safeKeyRequestBtn"style="${'N' eq view.ynNiceSafekey ? '' : 'none'}" >
                               <a onclick="npacRequest('request','${view.ynNiceSafekey}','','N','old');" href="#">SafeKey 요청</a>
                               </span> --%>
                               <span class="btn_icon key" id="safeKeyRequestBtn" style="${'N' eq view.ynNiceSafekey ? '' : 'none'}" >
								<a onclick="npacRequest('request','${view.ynNiceSafekey}','','N','new');" href="#">신SafeKey 요청</a>
                               </span>                               
                               <c:if test="${'Y' eq view.ynNiceSafekey}">
                               <br><cite>SAFEKEY: ${view.dsNiceSafekey} / 동의기관수: ${view.cnSafekeyExt}</cite>
                               </c:if>
                         </td>
					</tr>
					<tr>
                        <th>동의일</th>
                        <td>
                            <div class="item">              
                            <input type="text" class="s_text w80 " value="${view.dtCbAgree}" name="dtCbAgree" id="dtCbAgree" readonly> &nbsp;
                            <a onclick="$('#dtCbAgree').focus();" href="#"><img src="/images/icon/calendar.gif"></a>
                            </div>
                        </td>
                        <th>이메일</th>
                        <td>
                        <div class="item">
                            <input type="text" value="${view.dsEmail}" class="i_text w140" name="dsEmail" id="dsEmail"  ${textReadonly} >                     
                            <select onchange="changeEmailDomain('dsEmail',this.value)">
                                <option value=""  style="background:#ffffff">직접입력</option>
                                <c:forEach var="item" items="${emailList}">
                                    <option value="${item.code}"
                                        <c:if test="${fn:contains(view.dsEmail,item.code)}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>
                            <!-- <span class="btn_icon email"><a href="#">동의서</a></span>-->
                        </div>  
                        </td>
                    </tr>
					<tr>
						<th>결혼여부</th>
						<td>
							<div class="item">	
							<select name="cdMarry" ${selectDisabled}>
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code707}">
									<option value="${item.code}"
										<c:if test="${item.code==view.cdMarry}">selected</c:if>>${item.text}</option>
								</c:forEach>									                    
							</select>
							</div>					
						</td>
						<th>직장정보</th>
						<td>
							<div class="item">	
							<select name="cdJobKind" onchange="changeCdStatus(sel)" ${selectDisabled}>
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code709}">
									<option value="${item.code}"
										<c:if test="${item.code==view.cdJobKind}">selected</c:if>>${item.text}</option>
								</c:forEach>
							</select>
							의보신고금액 <input type="text" value="" class="i_text w70" onblur="calcInsuranceMoney(this.value,'insuranceMoney');" >
							<span id="insuranceMoney"></span>
							</div>
						</td>
					</tr>
					<tr>
						<th>신청금액</th>
                        <td><input type="text" value="${view.amCustom}" class="i_text w50"   id="infoAmCustom" name="amCustom" style="ime-mode:disabled;" maxlength="5" onkeydown="onlyNum();" data-validation="required" ${textReadonly} > 만원&nbsp;&nbsp;&nbsp;
                            <span class="btn_pack small"><input type="button" value="+100" onclick="calAmCustom('infoAmCustom',100)"></span> 
                            <span class="btn_pack small"><input type="button" value="+50"  onclick="calAmCustom('infoAmCustom',50)"></span> 
                            <span class="btn_pack small"><input type="button" value="-100" onclick="calAmCustom('infoAmCustom',-100)"></span>
                        </td>
						<th>상담 예약시간</th>
						<td>
							<div class="item">					
							<input type="text" value="${view.dmPromiseYMD}" class="i_text w90" name="dmPromiseYMD" id="dmPromiseYMD">
							<select name="dmPromiseHH" id="dmPromiseHH"  style="width:50px;">
							    <option value="" style="background:#ffffff">시</option>
								<c:forEach var="item" items="${HH}">
									<option value="${item.code}"
										<c:if test="${item.code==view.dmPromiseHH}">selected</c:if>>${item.text}</option>
								</c:forEach>								                    
							</select>
							<select name="dmPromiseMI" id="dmPromiseMI"  style="width:50px;">
							    <option value="" style="background:#ffffff">분</option>
								<c:forEach var="item" items="${MI}">
									<option value="${item.code}"
										<c:if test="${item.code==view.dmPromiseMI}">selected</c:if>>${item.text}</option>
								</c:forEach>								                    
							</select>
								<a href="#" onclick="promiseDateReset()">초기화</a>		
							</div>						
						</td>
					</tr>
                    <tr>
                        <th width="100" style="background: #85AFDA"><b>상태변경</b></th>
                        <td>
                            <div class="item">                  
                                <select name="cdStatus"  onchange="changeCdStatus(this.value)">
                                    <option value="" style="background:#ffffff">선 택</option>
                                    <c:forEach var="item" items="${code710}">
                                    <c:if test="${item.code ne '71001' && item.code ne '71001'}">
                                        <option value="${item.code}"
                                            <c:if test="${item.code==view.cdStatus}">selected</c:if>>${item.text}</option>
                                    </c:if>
                                    </c:forEach>
                                </select>   
                                <!-- 상태변경사유 -->
                                <span id="addSelCdReject" style="display:${'71007' eq view.cdStatus ? '' :  'none'}" >
                                <select name="cdReject" id="cdReject" style="width:150px">
                                    <option value="" style="background:#ffffff">선 택</option>
                                    <c:forEach var="item" items="${code132}">
                                        <option value="${item.code}"
                                            <c:if test="${item.code==view.cdReject}">selected</c:if>>${item.text}</option>
                                    </c:forEach>
                                </select>
                                </span>
                                <span id="addSelCdCancel" style="display:${'71008' eq view.cdStatus ? '' :  'none'}" >
                                <select name="cdCancel" id="cdCancel" style="width:150px">
                                    <option value="" style="background:#ffffff">선 택</option>
                                    <c:forEach var="item" items="${code131}">
                                        <option value="${item.code}"
                                            <c:if test="${item.code==view.cdCancel}">selected</c:if>>${item.text}</option>
                                    </c:forEach>
                                </select>
                                </span>
                                <c:if test="${fn:contains( '71004,71005,71006,71007,71008',view.cdStatus)}">
                                <a href="#" onclick="document.brcReAppFrm.submit();"><font color="blue">&nbsp;&nbsp;재접수</font></a>  
                                </c:if>

                            </div>              
                        </td>
                        <th>상담자</th>
                        <td>
                        <select  class="select" style="width:100px" disabled="disabled">
                            <option value="" style="background:#ffffff">심사자</option>
                            <c:forEach items="${screenList}" var="item">
                                 <option value="${item.code}"  <c:if test="${item.code == view.idScreen}">selected</c:if> >${item.text}</option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
			     </tbody>
		     </table>
            
            <!--  -->
		     <div id="" style="margin:10px 0 0px 0">    
		     <h3 class="sub_title">추가정보</h3>
		     <table border="1" cellspacing="0" summary="추가정보" class="crud_tbl">
                <tbody>
                    <tr>
                        <th width="100">모집분류</th>
                        <td width="350" colspan="3">
                            <select name="cdRecruitGroup" id="cdRecruitGroup" data-validation="">
                                <option value="" style="background:#ffffff" >선 택</option>
                                <c:forEach var="item" items="${code719}">
                                    <option value="${item.code}"
                                        <c:if test="${item.code==view.cdRecruitGroup}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>
                        </td>                                            
                    </tr>                
                    <tr>
                        <th width="100">직장명</th>
                        <td width="350">
                            <input type="text" class="i_text  w200" name="nmComp" value="${view.nmComp}"  ${textReadonly}>
                        </td>               
                        <th width="100">부서명</th>
                        <td width="450">
                              <input type="text" class="i_text" name="nmDept" value="${view.nmDept}" ${textReadonly} >
                         </td>                                   
                    </tr>
                    <tr>
                        <th>직급</th>
                        <td>
                            <select name="cdRank" ${selectDisabled}>
                                <option value="" style="background:#ffffff" >선 택</option>
                                <c:forEach var="item" items="${code133}">
                                    <option value="${item.code}"
                                        <c:if test="${item.code==view.cdRank}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>
                        </td>    
                        <th>직장대표전화</th>
                        <td>
                           <input type="text" value="${view.noMaintel1Comp}" class="i_text w30" name="noMaintel1Comp" maxlength="3" ${textReadonly}>
                            - <input type="text" value="${view.noMaintel2Comp}" class="i_text w30" name="noMaintel2Comp" maxlength="4" ${textReadonly}>
                            - <input type="text" value="${view.noMaintel3Comp}" class="i_text w30" name="noMaintel3Comp" maxlength="4" ${textReadonly}>
                        </td>     
                    </tr> 
                    <tr>
                        <th>고용형태</th>
                        <td>                    
                            <div class="item">  
                            <select name="cdJobStatus" ${selectDisabled}>
                                <option value="" style="background:#ffffff">선 택</option>
                                <c:forEach var="item" items="${code185}">
                                    <option value="${item.code}"
                                        <c:if test="${item.code==view.cdJobStatus}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                         
                            </select>
                            </div>                  
                        </td> 
                        <th>직업구분</th>
                        <td>                    
                             <select name="cdJobAct" ${selectDisabled}>
                                <option value="" style="background:#ffffff">선 택</option>
                                <c:forEach var="item" items="${code186}">
                                    <option value="${item.code}"
                                        <c:if test="${item.code==view.cdJobAct}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>
                        </td>                 
                    </tr>
                    <tr>
                       <th>입사일</th>
                       <td>
                          <input type="text" class="i_text w80" id="dtRegJoin" name="dtRegJoin" value="${view.dtRegJoin}"  maxlength="10" ${textReadonly}>
                          <a onclick=" $('#dtRegJoin').datepicker(CALENDAR_SET);$('#dtRegJoin').focus();" href="#"><img src="/images/icon/calendar.gif"></a>
                       </td>               
                       <th>월수입</th>
						<td>                    
						<input type="text" class="i_text w50" name="amPayMonth"  value="${view.amPayMonth}" maxlength="5" onkeydown="onlyNum();" >&nbsp;만원  
						</td>
                      </tr>
                      <tr>
                       <th>실거주지</th>
                          <td width="900" colspan="3" >                
                           <input type="text" value="${view.noPostRealFront}" class="i_text w30" id="noPostRealFront" name="noPostRealFront" maxlength="3" readonly="readonly">
                            - <input type="text" value="${view.noPostRealRear}" class="i_text w30" id="noPostRealRear" name="noPostRealRear" maxlength="3" readonly="readonly">
							<span class="btn_icon search"><span class="check"></span><input type="button" value="우편번호 찾기" onclick="execDaumPostcode(noPostRealFront,noPostRealRear,dsStrtReal,dsAddrReal)"></span>
                            <br>
                            <input type="text" value="${view.dsStrtReal}" class="i_text w400" id="dsStrtReal" name="dsStrtReal" maxlength="50" readonly="readonly">&nbsp;
                            <input type="text" value="${view.dsAddrReal}" class="i_text w350"  id="dsAddrReal" name="dsAddrReal" maxlength="50" >
                          </td>             
                      </tr>                                        
                      <tr>
                        <th width="100">거절메모</th>
                        <td width="900" colspan="3">
                            <div class="item">                  
                                <input type="text" value="${view.dsScreen} " class="i_text w600"   name="dsScreen" maxlength="50" >
								<img src="/images/icon/arrowup.png" onclick="resize(document.brcFrm.dsCooperate, 'minus');" style='cursor:hand;'/>
								<img src="/images/icon/arrowdown.png" onclick="resize(document.brcFrm.dsCooperate, 'add');" style='cursor:hand;'/>
                            </div>              
                        </td>
                    </tr>
                      <tr>
                        <th width="100">거래처메모</th>
                        <td width="900" colspan="3">
                            <div class="item">
                            	<textarea name="dsCooperate" style="width:100%;height:40px;font-size:11px;">${view.dsCooperate}</textarea>
                            </div>
                        </td>
                    </tr>
                 </tbody>
             </table>
            </div>
             
		     <table cellspacing="0" >
				<tr>
					<td style="padding-top: 10px" colspan="4">
					<c:if  test="${'71005' ne view.cdStatus }">
					<span class="btn_pack medium icon"><span class="check"></span><input type="submit" value="정보수정" id="submitBtn"></span>
                    </c:if>
					<span id="resultMsg" class="resultMsg">처리되었습니다.</span>
					</td>			
				</tr>
		     </table>
			</form>
		</div>
	</div>

	<%--############# 보증인정보 영역 ##############--%>
	<div class="info_tab"  style="display:${displaySurety};"  id="surety">
		<div class="sub_section">
		<form id="brcSuretyFrm" name="brcSuretyFrm" method="post" >
			<input type="hidden" name="noReq" value="${param.searchNoReq}">
			<input type="hidden" name="noSurety" value="${param.searchNoSurety}">
			<input type="hidden" name="searchNoSurety" value="${param.searchNoSurety}">
			<input type="hidden" name="brcSuretyNo" value="${suretyView.brcSuretyNo}">
			<input type="hidden" name="dsAccessIp" id="dsAccessIp" value="">
			<div style="position: relative;">
				<div style="position: absolute; top: 2px; right: 0px">
					<table border="0" cellspacing="0" class="search_btn_tbl"
						summary="확장검색">
						<tbody>
							<tr>
	                            <td><a onclick="relationRequest('Y');" href="#">연계검사</a>|</td>
                                <td><a onclick="relationLincusRequest('Y');" href="#">(E)연계검사</a>|</td>
                                <%-- <c:if test="${'Y' eq suretyView.ynCdtInquiry}"> --%>
                                <td><a onclick="hsjRequest('hsj_cb_gappl.php','${suretyView.dsNiceSafekey}','Y');" href="#">맞춤형CB정보</a>|</td>
                                <%-- <td><a onclick="hsjRequest('total_hsj.php','${suretyView.dsNiceSafekey}','Y');" href="#">CFS+CB정보</a>|</td> --%>
                                <td><a onclick="hsjRequest('hsj_cb.php','${suretyView.dsNiceSafekey}','Y');" href="#">CB조회</a> |</td>
                                <%-- <td><a onclick="hsjRequest('hsj_cfs.php','${suretyView.dsNiceSafekey}','Y');" href="#">CFS조회</a> | </td> --%>
                                <td><a onclick="hsjRequest('hsj_tr800.php','${suretyView.dsNiceSafekey}','Y');" href="#">CSS조회</a> | </td>
                                <td><a onclick="hsjRequest('hsj_tr800_new.php','${suretyView.dsNiceSafekey}','Y');" href="#">신CSS조회</a> | </td>
                                <%-- <td><a onclick="hsjRequest('hsj_2a116.php','${suretyView.dsNiceSafekey}','N');" href="#">헌터조회</a> | </td>       --%>                          
                                <%-- </c:if> --%>
                                <td><a onclick="npacRequest('search','${suretyView.ynNiceSafekey}','','Y','old');" href="#">SafeKey조회</a> | </td>
                                <td><a onclick="npacRequest('search','${suretyView.ynNiceSafekey}','','Y','new');" href="#">신SafeKey조회</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<h3 class="sub_title">※ 보증인정보</h3>
			<table border="1" cellspacing="0" style="margin-top: 10px" summary="보증인리스트" class="basic_tbl blue">
				<thead>
					<tr>
						<th>보증인번호</th>
						<th>보증인명</th>
						<th>주민번호</th>
						<th>휴대폰</th>
						<th>등록일시</th>
						<th>등록자</th>
					</tr>
				</thead>			
				<tbody>
					<c:forEach items="${suretyList}" var="suretyList">
						<c:set var="bgcolor" value="#ffffff" />
						<c:set var="fontcolor" value="black" />
						<c:if test="${param.searchNoSurety  eq  suretyList.noSurety}">
							<c:set var="fontcolor" value="red" />
						</c:if>															
						<tr bgcolor="${bgcolor}" style="cursor: pointer;"
							onmouseout="this.style.backgroundColor='${bgcolor}'"
							onmouseover="this.style.backgroundColor='#EAECF5'"
							onclick="window.location='/brc/loan/select?searchNoReq=${suretyList.noReq}&searchNoSurety=${suretyList.noSurety}'">
							<td><font color="${fontcolor}">${suretyList.noSurety}</font></td>
							<td><font color="${fontcolor}">${suretyList.nmCustom}</font></td>
							<td><font color="${fontcolor}">${suretyList.noCustom}</font></td>
							<td><font color="${fontcolor}">${suretyList.noTel1Mobile}-${suretyList.noTel2Mobile}-${suretyList.noTel3Mobile}</font></td>
							<td><font color="${fontcolor}">${suretyList.dmReg}</font></td>
							<td><font color="${fontcolor}">${suretyList.idReg}</font></td>
						</tr>
					</c:forEach>	
					  <tr>
					     <td style="padding-top: 10px;text-align:right" colspan="6" ><span
                            class="btn_pack medium icon"><span class="check"></span><input
                                type="button" value="신규등록" id="submitBtn" onclick="brcSuretySubmit('/brc/surety/insert');"></span></td>
                      </tr>           	
				</tbody>
			</table>
			<br>
			<table border="1" cellspacing="0" summary="보증인정보" class="crud_tbl">
				<tbody>
					<tr>
						<th width="10%">신용조회<br>가능여부</th>
						<td width="35%">								
						<c:if test="${'Y' eq userVO.ynConfirm}">
						       <input type="radio" value="Y" class="i_radio" name="ynCdtInquiry" <c:if test="${'Y' eq suretyView.ynCdtInquiry}">checked</c:if> >
                               <label for="ynCdtInquiryY">예</label>
                               <input type="radio" value="N" class="i_radio" name="ynCdtInquiry" <c:if test="${'N' eq suretyView.ynCdtInquiry}">checked</c:if> >
                               <label for="ynCdtInquiryN">아니오</label>
						</c:if>
						<c:if test="${'Y' ne userVO.ynConfirm}">
						       <input type="radio" value="Y" class="i_radio" name="ynCdtInquiry" <c:if test="${'Y' eq suretyView.ynCdtInquiry}">checked</c:if> 
						       																							<c:if test="${'Y' ne suretyView.ynCdtInquiry}">disabled</c:if>>
                               <label for="ynCdtInquiryY">예</label>
                               <input type="radio" value="N" class="i_radio" name="ynCdtInquiry" <c:if test="${'N' eq suretyView.ynCdtInquiry}">checked</c:if>
						       																							<c:if test="${'N' ne suretyView.ynCdtInquiry}">disabled</c:if>>
                               <label for="ynCdtInquiryN">아니오</label>
						</c:if>
                         </td>						
						<th width="10%">신용조회<br>요약정보</th>
						<td width="45%">
							<table class="ExcelTable2007">
								<tr>
									<th>&nbsp;대부건수&nbsp;</th>
									<th>&nbsp;대부금액&nbsp;</th>
									<th>&nbsp;CB등급&nbsp;</th>
									<th>&nbsp;SP등급&nbsp;</th>
									<th>&nbsp;PI등급&nbsp;</th>
									<th>&nbsp;AS등급&nbsp;</th>
									<th>&nbsp;판정결과&nbsp;</th>
									<th>&nbsp;전략한도&nbsp;</th>
								</tr>
								<tr>
									<td class="heading">&nbsp;${suretyView.dsCntCb}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.dsAmtCb}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.ds2ndRank}&nbsp;</td>									
									<td class="heading">&nbsp;${suretyView.ds1stRank}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.dsPiRank}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.dsAssRank}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.cdTactic}&nbsp;</td>
									<td class="heading">&nbsp;${suretyView.cdTacticLimit}&nbsp;</td>									
								</tr>
							</table>					
						</td>	
					</tr>				
	 				<tr>
						<th width="10%">보증인명</th>
						<td width="35%">
							<input type="text" value="${suretyView.nmCustom}" class="i_text" name="nmCustom" > 
						</td>
						<th width="10%">핸드폰</th>
						<td width="45%">
							<div class="item">	
							<select name="cdKndMobile" >
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code708}">
									<option value="${item.code}"
										<c:if test="${item.code==suretyView.cdKndMobile}">selected</c:if>>${item.text}</option>
								</c:forEach>									                    
							</select>
							<input type="text" value="${suretyView.noTel1Mobile}" class="i_text w30" name="noTel1Mobile" maxlength="3"> - 
							<input type="text" value="${suretyView.noTel2Mobile}" class="i_text w30" name="noTel2Mobile" maxlength="4"> - 
							<input type="text" value="${suretyView.noTel3Mobile}" class="i_text w30" name="noTel3Mobile" maxlength="4">	
							<span class="btn_icon phone"><a href="#" onclick="clicktocall('${suretyView.noTel1Mobile}${suretyView.noTel2Mobile}${suretyView.noTel3Mobile}')">통화하기</a></span>
								<span class="btn_icon email"><a href="#" onclick="hpAuthLincusRequest(
																									'BRG',
																									'${view.noReq}',
																									'G',
																									'${suretyView.noCustom}',
																									'${suretyView.nmCustom}',
																									'${userVO.idUser}'
																									)">인증</a></span>																	
							</div>
						</td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" value="${suretyView.noCustom}" class="i_text" name="noCustom" id="noSurety" maxlength="14" onblur="$('#ageSexSuretyMsg').html(getAgeSexMsg(this.value))" >
	                        <span id="ageSexSuretyMsg"></span>	
						<th>위탁동의여부</th>
                        <td>
                               <input type="radio" value="Y" class="i_radio" id="YN_NICE_SAFEKEY_Y_SURETY" name="ynNiceSafekey" <c:if test="${'Y' eq suretyView.ynNiceSafekey}">checked</c:if> >
                               <label for="YN_NICE_SAFEKEY_Y_SURETY">예</label>
                               <input type="radio" value="N" class="i_radio" id="YN_NICE_SAFEKEY_N_SURETY" name="ynNiceSafekey" <c:if test="${'N' eq suretyView.ynNiceSafekey}">checked</c:if>>
                               <label for="YN_NICE_SAFEKEY_N_SURETY">아니오</label>
                               <c:if test="${'Y' eq suretyView.ynNiceSafekey}">
<%--                                <span class="btn_icon key">
                               <a onclick="npacRequest('request','${suretyView.ynNiceSafekey}','','Y','old');" href="#">SafeKey 요청</a></span> --%>
                               <span class="btn_icon key">
                               <a onclick="npacRequest('request','${suretyView.ynNiceSafekey}','','Y','new');" href="#">신SafeKey 요청</a></span>
                               <br><cite>SAFEKEY: ${suretyView.dsNiceSafekey} / 동의기관수: ${suretyView.cnSafekeyExt}</cite>                                
                               </c:if>
                         </td>
					</tr>
					<tr>
						<th>결혼여부</th>
						<td>
							<div class="item">	
							<select name="cdMarry"  data-validation="required">
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code707}">
									<option value="${item.code}"
										<c:if test="${item.code==suretyView.cdMarry}">selected</c:if>>${item.text}</option>
								</c:forEach>									                    
							</select>
							</div>					
						</td>				
						<th>직장정보</th>
						<td>
							<div class="item">	
							<select name="cdJobKind"  data-validation="required">
							    <option value="" style="background:#ffffff">선 택</option>
								<c:forEach var="item" items="${code709}">
									<option value="${item.code}"
										<c:if test="${item.code==suretyView.cdJobKind}">selected</c:if>>${item.text}</option>
								</c:forEach>
							</select>
							</div>
						</td>					
					</tr>
					<tr>
                       <th>이메일</th>
                        <td colspan="3">
                        <input type="text" value="${suretyView.dsEmail}" class="i_text w140" name="dsEmail" id="suretyDsEmail">                       
                            <select onchange="changeEmailDomain('suretyDsEmail',this.value)">
                                <option value="" style="background:#ffffff">직접입력</option>
                                <c:forEach var="item" items="${emailList}">
                                    <option value="${item.code}"
                                        <c:if test="${fn:contains(suretyView.dsEmail,item.code)}">selected</c:if>>${item.text}</option>
                                </c:forEach>                                                        
                            </select>               
                       </td>
                    </tr>
					 <tr>
						<c:if  test="${'0' ne view.cnSurety}">
						<td style="padding-top: 10px;text-align:left" colspan="4"><span
							class="btn_pack medium icon"><span class="check"></span><input
								type="button" value="정보수정" id="submitBtn" onclick="brcSuretySubmit('/brc/surety/update');"></span></td>
						</c:if>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>

    <%-- ############# 첨부파일 시작  고객정보,보증인일때만 노출 ############# --%>
    <div class="sub_section" id="attach" style="display:${'' eq displayCustom || '' eq displaySurety ? '' : 'none'}">
        <h3 class="sub_title">※ 첨부파일</h3>
        <form name="attachRegistFrm" method="POST" action="/brc/loan/upload" enctype="multipart/form-data" onsubmit="return uploadChk(this)">
        <input type="hidden" name="noReq" id="noReq" value="${view.noReq}">
        <table border="1" cellspacing="0" summary="첨부파일" class="crud_tbl gray">
            <tbody>
                <tr>
                    <th width="10%">구분</th>
                    <td width="35%">
                        <div class="item">  
                        <select name="cdFile" >
                            <option value="" style="background:#ffffff">선 택</option>
                            <c:forEach var="item" items="${code203}">
                                <option value="${item.code}">${item.text}</option>
                            </c:forEach>                                                    
                        </select>
                        </div>                  
                    </td>
                    <th width="10%">이미지</th>
                    <td width="45%"><input type="file" name="file" class="i_text"></td>
                </tr>
                <tr>
                    <th width="10%">메모</th>
                    <td><input type="text" name="dsRemk" class="i_text w250"></td>
                    <th width="10%">WEBFAX</th>
                    <td><input type="text" name="dsFileFrom" class="i_text w250" readonly="readonly"></td>
                </tr>
                <tr>
                    <td style="padding-top: 10px;" colspan="4">
                        <span class="btn_pack medium icon"><span class="check"></span><input type="submit" value="파일등록" id="submitUploadBtn"></span>
                    </td>
                </tr>
            </tbody>
        </table>
        </form>
        <table border="1" cellspacing="0" style="margin-top: 10px" summary="첨부파일" class="basic_tbl" id="attachTbl">
            <thead>
                <tr>
                    <th>구분</th>
                    <th colspan="2">파일명</th>
                    <th>등록자</th>
                    <th>등록일시</th>
                    <th>메모</th>
                </tr>
            </thead>            
            <tbody>
                <c:forEach items="${fileList}" var="fileList">
                    <c:set var="bgcolor" value="#ffffff" />
                    <tr bgcolor="${bgcolor}" style="cursor: pointer;" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'" 
                    value="${fileList.dsFileBase64}" data-value="${fileList.dsFileBase64}" onclick="setFileViewer(this, '${fileList.no}','${fileList.cdFile}','${fileList.dsPath}','${fileList.nmFile}')">                    	
                        <td>${fileList.nmCdFile}</td>                        
                        <td id="attachNmFileUser${fileList.no}">${fileList.nmFileUser}</td>
                        <td><a href="/common/file/download/${fileList.dsFileBase64}" target="_blank"><font color="blue">[다운로드]</font></a></td>
                        <td>${fileList.idReg}</td>
                        <td>${fileList.dmReg}</td>
                        <td id="attachDsRemk${fileList.no}">${fileList.dsRemk}</td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>
        <div id="fileForm" style="padding:20px 0 0 0;display:none">
        <form name="attachUpdateFrm" method="post" action="/brc/attach/update" >
         <input type="hidden" name="noReq" value="${view.noReq}">
         <input type="hidden" name="no" >
         <input type="hidden" name="dsPath" >
         <input type="hidden" name="nmFile" >
         <table border="0" cellspacing="0" class="crud_tbl" style="border:1px solid #000">
             <tbody>
                 <tr>
                     <td><strong id="updateNmFileUser" style="color:#369"></strong></td>
                     <td>구분</td>
                     <td>
                         <div class="item">  
                         <select name="cdFile" >
                             <c:forEach var="item" items="${code203}">
                                 <option value="${item.code}">${item.text}</option>
                             </c:forEach>                                                    
                         </select>
                         </div>                  
                     </td>
                     <td>메모</td>
                     <td><input type="text" name="dsRemk" class="i_text w400"></td>
                     <td>
                         <span class="btn_pack small icon"><span class="check"></span><input type="button" value="수정" onclick="updateAttach()"></span>
                         <span class="btn_pack small icon"><span class="delete"></span><input type="button" value="삭제" onclick="deleteAttach()"></span>
                     </td>
                 </tr>
             </tbody>
         </table>
         </form>
        </div>
        <div id="fileViewer" style="text-align:center"></div>
    </div>


	<%-- ############# 실행내역 ##############--%>
	<div class="info_tab"  style="display:${displayBex};"  id="bex">
		<div class="sub_section">
		<form id="bexMasterFrm" name="bexMasterFrm" action="/bex/master/insert"  method="post" onsubmit="return submitBexMaster(this)">
		<input type="hidden" name="noReq" value="${param.searchNoReq}">		
		<h3 class="sub_title">※ ${view.nmCustom} 실행현황 (${view.noReq}) </h3>
		<table border="1" cellspacing="0" style="margin-top: 10px" summary="실행현황" class="basic_tbl" id="bexMasterTbl">
			<thead>
				<tr>
	                    <th>실행번호</th>
	                    <th>실행일시</th>
	                    <th width="80">신청금액</th>
	                    <th>중개협력사</th>	                    
	                    <th>접수처</th>
	                    <th>접수위치</th>
	                    <th>심사상태</th>
	                    <th  width="80">승인예정금액</th>
	                    <th  width="80">승인금액</th>
	                    <th>승인상품</th>
	                    <th>심사완료일시</th>
	                    <th>심사메모</th>
				</tr>
			</thead>			
			<tbody>
				<c:forEach items="${bexList}" var="bexList">
					<c:choose>
					<c:when test="${('Y' == bexList.ynPartnerAct)}">
					<c:set var="fontcolor" value="gray" />
					<c:set var="bgcolor" value="#F5F5F5" />
					</c:when>
					<c:otherwise>
					<c:set var="fontcolor" value="black" />
					<c:set var="bgcolor" value="#ffffff" />
					</c:otherwise>
					</c:choose>		
					<tr bgcolor="${bgcolor}" onmouseout="this.style.backgroundColor='${bgcolor}'" onmouseover="this.style.backgroundColor='#EAECF5'">
	                        <td><font color="${fontcolor}">${bexList.noEx}</font></td>
	                        <td><font color="${fontcolor}">${bexList.dmReg}</font></td>
	                        <td><font color="${fontcolor}">${bexList.amApp}</font></td>
	                        <td><font color="${fontcolor}">${bexList.cdCooperatePartner}</font></td>	                        
	                        <td><font color="${fontcolor}">${bexList.cdCooperate}</font></td>
	                        <td><font color="${fontcolor}">${bexList.nmScreenPath}</font></td>
	                        <td><font color="${fontcolor}">${bexList.nmScreen}</font></td>
	                        <td><font color="${fontcolor}">${bexList.amCooperateExpect > 0 ? bexList.amCooperateExpect : ''}</font></td>
	                        <td><font color="${fontcolor}">${bexList.amCooperate > 0 ? bexList.amCooperate : ''}</font></td>
	                        <td><font color="${fontcolor}">${bexList.cdPdt}</font></td>
	                        <td><font color="${fontcolor}">${bexList.dmUpt}</font></td>
	                        <td>
	                           <c:choose> 
	                                <c:when test="${bexList.contactCnt > 0}"> 
	                                    <a title="${bexList.dsCooperate}" class="memo_tooltip" href="#"><img src="/images/icon/comments.png" /></a>
	                                    <a href="#" onclick="bexMemoStory('${bexList.noReq}','${bexList.noEx}')" ><img src="/images/icon/comments_send.png" /></a>
	                                </c:when> 
	                                <c:otherwise> 
	                                    <img src="/images/icon/comments_gray.png">
	                                    <img src="/images/icon/comments_send_gray.png" />
	                                </c:otherwise> 
	                            </c:choose>
	                        </td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>	
		<br>
	   <c:if  test="${('71004' == view.cdStatus) || ('71005' == view.cdStatus && ('Y' == userVO.ynConfirm))}">
		<div id="cooperateArea" class="item">	
		심사요청&nbsp;
		<select id="bexCdCooperate" name="cdCooperate" >
			<c:forEach var="item" items="${code703}">
				<option value="${item.code}">${item.text}</option>
			</c:forEach>									                    
		</select>	
		<span class="btn_pack medium icon">
			<span class="check"></span>
			<input type="submit" value="심사요청" id="submitCooperateBtn">
		</span>
		</div>
		</c:if>
		</form>
		</div>
	</div>

	<%-- ############# 비대면  ##############--%>
	<div class="info_tab"  style="display:none;"  id="tm">
		<div class="sub_section">
			<h3 class="sub_title">※ 비대면관리대장</h3>
			<div id="tmList"></div>
		</div>
	</div>	
</div>

<form id="brcReAppFrm" name="brcReAppFrm" action="/brc/loancopy/insert"  method="post" >
	<input type="hidden" name="noReq" value="${param.searchNoReq}">
</form>	     
<script type="text/javascript" src="/js/jquery.form-validator.min.js"></script>
<script type="text/javascript">
// 고객정보 submit - jquery.form-validator.min.js applyValidation 에서 call 
function submit_before(){
	var f  = document.brcFrm;
    if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
        	ON_SUBMIT_PROCESS = true;
            $('#custom').block({});
            $.ajax({
                type: "POST",
                url: "/brc/loan/update.json",
                cache:false,
                dataType: "json",
                async: false,
                data: $(f).serializeArray() ,
                success: function(data){
                    if(data.result == 'success'){
                    	document.location.reload();
                    	//$('#resultMsg').fadeIn('slow');
                    	//$('#resultMsg').fadeOut('slow');
                    }else{
                        alert(data.message);
                    }
                    ON_SUBMIT_PROCESS = false;
                    $('#custom').unblock({});
                }
             });
        return false;
    }
}
function tabChange(flag){
	$('.info_tab').hide();
	$('#'+flag).show();

	$('#info_tab_menu >  li').removeClass('selected');
	$('#info_tab_menu_'+flag).addClass('selected');
	
	if(flag == "bex" || flag == "tm"){
		$('#attach').hide();
	}else{
		$('#attach').show();		
	}
	if(flag == "tm"){
		$("#tmList").block({});
	    $.post("/brc/loantm/select", {searchNoReq:SEARCH_NO_REQ} , function(responseData){
           $('#tmList').html(responseData);
       });
	}
}

$(function() {
	// 고객정보 submit check 
	window.applyValidation('#brcFrm');
	
    // 달력셋팅 
	$("#dtCbAgree").datepicker(CALENDAR_SET);
    $("#dmPromiseYMD").datepicker(CALENDAR_SET);    
    $("#dtCbAgreeSurety").datepicker(CALENDAR_SET);
    $("#dmPromiseYMDSurety").datepicker(CALENDAR_SET);
   
    <c:if test="${'readonly' ne textReadonly}">
	// input format 
	$('#noCustom').formatter({
		'pattern' : '{{999999}}-{{9999999}}'
	});
    </c:if>
	$('#noSurety').formatter({
		'pattern' : '{{999999}}-{{9999999}}'
	});

	$('#dtCbAgree').formatter({
		'pattern' : '{{9999}}-{{99}}-{{99}}'
	});

	$('#dtCbAgreeSurety').formatter({
		'pattern' : '{{9999}}-{{99}}-{{99}}'
	});
/*
	$('#dmPromise').formatter({
		'pattern' : '{{9999}}-{{99}}-{{99}}'
	});
*/	
   $('#dtRegJoin').formatter({
        'pattern' : '{{9999}}-{{99}}-{{99}}'
       // 'persistent': true
    });

	// 나이/성별 셋팅 
	$('#ageSexMsg').html(getAgeSexMsg($('#noCustom').get(0).value));
	$('#ageSexSuretyMsg').html(getAgeSexMsg($('#noSurety').get(0).value));
});


(function($) {
/*jshint expr:true 

var m = /(MSIE) ([\w.]+)/.exec( navigator.userAgent );
var patch = m && m[1] && m[2] < 9;

if (patch) {
    $.fn.fadeIn = function(speed, callback) {
        return this.animate({opacity: 'show'}, speed, function() {
            this.style.removeAttribute('filter'); 
            callback && callback(); 
        });
    };

    $.fn.fadeOut = function(speed, callback) {
        return this.animate({opacity: 'hide'}, speed, function() {
            this.style.removeAttribute('filter'); 
            callback && callback(); 
        });
    };

    $.fn.fadeTo = function(speed,to,callback) {
        return this.animate({opacity: to}, speed, function() {
            to == 1 && this.style.removeAttribute('filter'); 
            callback && callback(); 
        });
    };
}*/    
})(jQuery);
</script>
<script>
<c:if test="${requestResultVO.error ne null }" >
$(function() { // 에러처리 
    printError("${requestResultVO.error}");
});
</c:if>
function resize(p_obj, p_kind) {
	if(p_kind=="add"){
		p_obj.style.height = "350px";
	}else if(p_kind=="minus"){
		p_obj.style.height = "40px";
	}
  }
</script>

<%// 변경 가능한 상태값 설정   %>
<c:set var="loanCdStatus" value="${view.cdStatus}" />
<c:choose>
     <c:when test="${fn:contains('71002,71003,71004,71006,71007,71008,71009,71010,71011,71013',loanCdStatus) and !empty loanCdStatus}">
            <c:choose>
                <c:when test="${fn:contains('71002,71003',loanCdStatus)}" >
                    <script> $(function(){ resetOptions('cdStatus','71002,71003,71004,71006,71007,71008,71009,71010,71011,71012')});</script>
               </c:when>
               <c:when  test="${'71004' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71004,71005')});</script>
               </c:when>
               <c:when test="${'71006' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71005,71006')});</script>
               </c:when>
               <c:when test="${'71007' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71007,71012,71005')});</script>
               </c:when>
               <c:when  test="${'71008' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71008,71012')});</script>
               </c:when>
               <c:when test="${fn:contains( '71009,71010',loanCdStatus)}" >
                    <script> $(function(){ resetOptions('cdStatus','71003,71007,71008,71009,71010')});</script>
               </c:when>
               <c:when test="${'71011' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71008,71011,71012')});</script>
               </c:when>
               <c:when test="${'71013' eq loanCdStatus}" >
                    <script> $(function(){ resetOptions('cdStatus','71003,71004,71007,71008,71009,71010,71012')});</script>
               </c:when>
               <c:otherwise>
               </c:otherwise>
           </c:choose>
     </c:when>
    <c:otherwise>
          <script> $(function(){ resetOptions('cdStatus','${loanCdStatus}')});</script>
    </c:otherwise>
</c:choose>

