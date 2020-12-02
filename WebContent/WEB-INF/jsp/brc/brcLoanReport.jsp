<%@ page session="false" pageEncoding="utf-8"%>
<table border="0" cellspacing="0" cellpadding="0">
	<!-- style="border-left:1px solid  #aaa;" -->
	<tr>
		<td width="1000" valign="top" style="padding-left: 20px;">

			<ul id="info_tab_menu" class="tab_menu">
				<li id="info_tab_menu_1"><a href="/rc/personal?custno=1">고객정보</a>
				</li>
				<li id="info_tab_menu_2"><a
					href="/rc/personal?custno=1&g_custno=1">보증인정보</a></li>
				<li id="info_tab_menu_3" class="selected"><a
					href="/rc/personal?custno=1&step=2">실행현황</a></li>
			</ul>
			<div id="info_tab_1" class="info_tab"
				style="border: 0px solid #aaa; border-top: 0px; border-bottom: 0px; padding-top: 30px;">
				<table border="0" cellspacing="0" id="scroll_tbl" class="basic_tbl">
					<thead>
						<tr>
							<th>고객전화번호</th>
							<th>고객명</th>
							<th>업체명</th>
							<th>신청금액</th>
							<th>접수위치</th>
							<th>접수상태</th>
							<th>대출금</th>
							<th>상담완료일시</th>
						</tr>
					</thead>
					<tbody>
						<tr onmouseover="this.style.backgroundColor='#EAECF5'"
							onmouseout="this.style.backgroundColor='#FFC8E3'"
							bgcolor="#FFC8E3">
							<td>010-0000-1234</td>
							<td><a href="/rc/personal?custno=1">나고객</a></td>
							<td>스타크레디트</td>
							<td>300만원</td>
							<td>UPS</td>
							<td>거절</td>
							<td>0</td>
							<td>2014-06-10 17:50:55</td>
						</tr>
						<tr onmouseover="this.style.backgroundColor='#EAECF5'"
							onmouseout="this.style.backgroundColor='#F4FFFF'"
							bgcolor="#F4FFFF">
							<td>010-0000-1234</td>
							<td><a href="/rc/personal?custno=1">나고객</a></td>
							<td>유아이크레디트</td>
							<td>100만원</td>
							<td>UPS-ADD</td>
							<td>대출</td>
							<td>100만원</td>
							<td>2014-06-10 17:50:55</td>
						</tr>
						<tr onmouseover="this.style.backgroundColor='#EAECF5'"
							onmouseout="this.style.backgroundColor=''" bgcolor="">
							<td>010-0000-1234</td>
							<td><a href="/rc/personal?custno=1">나고객</a></td>
							<td>밀리언캐쉬</td>
							<td>300만원</td>
							<td>UPS</td>
							<td>심사</td>
							<td>0</td>
							<td></td>
						</tr>
					</tbody>
				</table>

				<div style="padding-top: 10px; width: 100%">
					<select class="">
						<option>스타크레디트</option>
						<option>유아이크레디트</option>
						<option>밀리언캐쉬</option>
						<option>미래크레디트</option>
						<option>엑트</option>
					</select> <span class="btn_pack medium icon"><span class="check"></span><a
						href="/rc/personal?custno=1&step=2">심사요청</a></span> <span
						class="btn_pack medium icon" style="float: right"><span
						class="check"></span><input type="submit" id="submitBtn"
						value="상담종료"></span>
				</div>