<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>

<c:set  var="sesAuthDsUrl"  value="${userVO.dsUrl}" scope="page" />

<div id="menu" class="menu mc_gray">
    <div class="inset">
        <div class="major">
            <ul>
            	<li class="m1"><a href="/" target="_blank"><span><font color="red">CueBridge</font></span></a></li>
                <li class="m2"><a href="/st/user/select"><span>업무공통</span></a>
                    <div class="sub">
                        <ul>
                            <li><a href="/st/user/select"><span>사용자 관리</span></a></li>
                            <!-- <li><a href="/st/permission/select"><span>사용자 권한관리</span></a></li> -->
                            <li><a href="/st/userlog/select"><span>사용자 로그</span></a></li>
                            <li class="line"></li>
                            <li><a href="/st/customer/select"><span>거래처정보</span></a></li>
                            <li><a href="/st/pdt/select"><span>대출과목관리</span></a></li>
                            <li><a href="/st/code/select"><span>코드관리</span></a></li>
                            <li class="line"></li>
                            <li><a href="/st/setting/select"><span>시스템 주요설정</span></a></li>
                            <li><a href="/st/program/select"><span>프로그램 관리</span></a></li>
                            <li><a href="/st/smssend/select"><span>SMS 발송내역</span></a></li>                            
                        </ul>
                    </div>
				</li>                
                <li class="m3"><a href="/brc/loan/select"><span>접수관리</span></a>
                    <div class="sub">
                        <ul>
                            <li><a href="/brc/loan/select"><span>접수내역</span></a></li>
                            <li><a href="/brc/promise/select"><span>약속자리스트</span></a></li>
                            <li><a href="/brc/loanall/select"><span>스텝별리스트</span></a></li>
                            <li><a href="/brc/excel/select"><span>데이터추출</span></a></li>
                            <li><a href="/brc/misscall/select"><span>IVR 미스콜</span></a></li>
                        </ul>
                    </div>
                </li>                
                <li class="m4"><a href="/bex/master/select" class="parent"><span>접수현황</span></a>
                    <div class="sub">
                        <ul>
                            <li><a href="/bex/master/select"><span>대출심사현황</span></a>
                            <li><a href="/bex/syncscreen/select"><span>심사기표보정</span></a>
<!--                             <li><a href="#"><span>기간별 접수현황</span></a></li>
                            <li><a href="#"><span>영업일보</span></a></li> -->
                        </ul>
                    </div>
                </li>
			</ul>
		</div>
        <div class="aside" style="position: relative;z-index:8000;">
            <ul>
				<sec:authorize access="isAnonymous()">
					<a href="/j_spring_security_check"><span>로그인</span></a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				     <li class="m1"><a href="#"><span><b>${userVO.nmUser}</b>님</span></a></li>
				     <%-- <span><b>${authDTO.username}</b>님</span> --%>
				     <%-- ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user.idUser} --%>				     
				     <!-- <li class="m2"><a href="/j_spring_security_logout"><span>로그아웃</span></a></li> -->
				     <li class="m2"><a href="/auth/logout"><span>로그아웃</span></a></li>
				</sec:authorize>
            </ul>
             <div style="position: absolute; top:0px; right:400px">
             	<a onclick="relationSearchPopup()" href="#" style="color:#FFFF80">연계검사</a>
             </div>
            <div class="logo" style="float:right;padding:0px;margin:0px;">
            <c:choose>
                  <c:when test="${'S' eq userVO.cdCompany}">
                      <img src="/images/logo/main_logo_star.jpg" width="100" height="35"/>
                  </c:when>
                  <c:when test="${'M' eq userVO.cdCompany}">
                      <img src="/images/logo/main_logo_mill.gif" width="100" height="35"/>
                  </c:when>
                  <c:when test="${'Y' eq userVO.cdCompany}">
                      <img src="/images/logo/main_logo_youi.gif" width="100" height="35"/>
                  </c:when>
            </c:choose>
            </div>
        </div>                
	<span class="gradient"></span>
    </div>
    <span class="shadow"></span>
</div>
<div style="clear:both"></div>