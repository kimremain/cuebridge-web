// constant
ON_SUBMIT_PROCESS = false;
CALENDAR_SET = {
	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	dayNamesMin: ['일','월','화','수','목','금','토'],
	changeMonth: true, //월변경가능
	changeYear : true, //년변경가능.
	showMonthAfterYear: true, //년 뒤에 월 표시
	dateFormat:'yy-mm-dd'
}
//오류 팝업레이어출력
function printError(msg){
	var errorLayer ="";
	errorLayer = '<div id="pop_wrap" style="top:20px;left:20px;width:600px;height:500px;z-index:9999">'+
	'<div id="pop_content">'+
	    '<form action="" method="post">'+
	        '<h4 class="ly_header">에러메세지</h4>'+
	            '<dl class="ly_body">'+
	                '<dt id="error_num"></dt>'+
	                '<dd id="error_message"></dd>'+
	            '</dl>'+
	            '<div id="pop_footer">'+
	                '<a href="#" onclick="$.unblockUI(); " ><img src="/images/common/btn_confirm2.gif" alt="취소" height="21" width="38"></a>'+
	            '</div>'+
	            '<a href="#" onclick="$.unblockUI(); " class="close_layer"><img src="/images/common/btn_close2.gif" alt="레이어닫기" height="14" width="15"></a>'+
	    '</form>'+
	'</div>'+
	'</div>';
	// 레이어셋팅 
	$("#error_msg_pop").html(errorLayer);
	// 메세지 셋팅 
	setErrorMessage(msg);

	$.blockUI({
        message : $("#error_msg_pop"),
        css : {
            width : '700px',
            height : '500px',
            left : '30%',
            top : '10%',
            border : '0px solid #eaeaea',
            padding : '0px',
            opacity : .9,
            color : '#fff',
            cursor : null
        },
        onOverlayClick : $.unblockUI
    });
}
// 에러메세지 셋팅 
function setErrorMessage(msg){
	msg = msg.replace(/{|}/g,"");
	var msgArr = explode(",",msg);
	var msgConvertArr = [];
	for(var key in msgArr){
		tempArr = explode("=",msgArr[key]);
		msgConvertArr[$.trim(tempArr[0])] = tempArr[1];
	}
	var returmMsgStr =""
	for(var key in msgConvertArr){
		returmMsgStr += msgConvertArr[key]+"<br />";
	}
	
	$("#error_num").html(msgArr.length + "건 ");
	$("#error_message").html(returmMsgStr);
	
	//return  returmMsgStr;
}
// overlay 출력 
function start_overlay(){
	$.blockUI({ 
		message: '<div class="ly_loading"><p class="dsc_loading">문서를 불러오는 중...</p><img src="/images/loading_bar.gif" alt="로딩중" height="20" width="200"></div> ',
		css: { width:'200px',
			   border: 'none', 
				padding: '15px', 
				backgroundColor: '#000', 
				'-webkit-border-radius': '10px', 
				'-moz-border-radius': '10px', 
				opacity: .5, 
				color: '#fff' ,
				timeout:  2000 ,
				onOverlayClick: $.unblockUI 
			  } 
		}); 
    //setTimeout(end_overlay, 2000); 
}
/*
 * overlay 중단  
 * callback
	$.unblockUI({ 
		onUnblock: function(){ callback } 
	}); 
*/
function end_overlay(){
	$.unblockUI();
}
function process_reset(){
	end_overlay();
	ON_SUBMIT_PROCESS = false;
	if($('#submitBtn')){
		$('#submitBtn').removeAttr('disabled');
	}
}
// submit 전에 실행 
function submit_before(form_id){
	return true;
}
// submit 처리 
function process_start(){
	// process chk
	if(ON_SUBMIT_PROCESS){
		// 이미 submit button 을 클릭한경우 
	}
	ON_SUBMIT_PROCESS = true;
	start_overlay();
	
	// submit button disabled 
	$('#submitBtn').attr('disabled', "true");
}
//url로 이동
function goUrl(url){
	document.location.href = url;
}
// 이전페이지로 이동
function historyBack(){
	window.history.back();
	document.location.href='/'; // 백이 안될경우
}
// 부모창이동
function openerMove(url){
	opener.location.href = url;
	popupClose();
}
//부모창이동
function openerReload(){
	opener.location.reload();
	popupClose();
}

//팝업창 닫기
function popupClose(){
	top.window.opener = top;
	top.window.open('','_parent', '');
	top.window.close();
}
// 연계검사
function relationSearchPopup(query){
	var url = "/brc/search/select"; 
	if(query){
		url = url+"?searchConfirm=Y"+query;
	}
    window.open( url,"","width=960,height=880,scrollbars=yes,resizable=yes");
}

function urlencode(str) {
	  str = (str + '').toString();
	  return encodeURIComponent(str)
	    .replace(/!/g, '%21')
	    .replace(/'/g, '%27')
	    .replace(/\(/g, '%28')
	    .replace(/\)/g, '%29')
	    .replace(/\*/g, '%2A')
	    .replace(/%20/g, '+');
}
function urldecode(str) {
	  return decodeURIComponent((str + '').replace(/%(?![\da-f]{2})/gi, function() { return '%25';}).replace(/\+/g, '%20'));
}
//의료보험소득계산
function calcInsuranceMoney(val,output){
    var num=val.replace(/,+/g,"");
    num = parseInt(num);
    $("#"+output).html('<strong style="color:#ff0000">[소득 :'+ number_format(Math.round(num/2.9*100)+"")+']</strong> ');
}

// 클릭투콜 
function clicktocall(phone){
			
    //var url = LINCUS_DOMAIN+"importantShare/click2call_new.php?ph="+phone+"&no=0&member_list_no=0&ups=TIM&type=";
    var url = LINCUS_DOMAIN+"importantShare/click2call_new_frame.php?ph="+phone+"&no=0&member_list_no=0&ups=TIM&type=";
    document.getElementById("hiddenFrame").src = url;
    //window.open(url,"Click2Call","left=50,top=50,toolbar=no,width=520,height=600,status=yes,scrollbars=yes,resizable=yes");   
}
//Lincus 연계검사
function relation_check(opt,nmCustom,noCustom){
	var param = "?opt="+opt;
	noCustom = $.trim(noCustom.replace(/(-)/g,''));
	if(nmCustom || noCustom){
		
		if(nmCustom){
			//param += "&name="+urlencode(nmCustom);
			param += "&name="+nmCustom;
		}
		if(noCustom.length ==13 ){
			var noCustom1 = noCustom.substring(0,6);
			var noCustom2 = noCustom.substring(6,13);
			param += "&ssn11="+noCustom1;
			param += "&ssn12="+noCustom2;
		}
	}
	//alert(param);
	window.open(LINCUS_DOMAIN+"/ups/application/relation_check.php"+param,"","left=0,top=0,width=400,height=400,scrollbars=yes,resizable=yes");
}
function hsj(filename,name,ssn,member_list_no){
	ssn = ssn.replace(/[^0-9]/gi,'');
	member_list_no = '';
    window.open(LINCUS_DOMAIN+"/hsj/"+filename+"?ssn="+ssn+"&div=TIM&name="+name+"&member_list_no=", "", "left=0,top=0,width=750,scrollbars=yes,resizable=yes");
}
function hsj_s(filename,name,ssn,req,phone,safe_key){
	ssn = ssn.replace(/[^0-9]/gi,'');
	req = req.replace(/-/gi,'');
	birthdate = ssn.substring(0,6);
	gender    = ssn.substring(6,7);
	name 	 = encodeURIComponent(name); 
    window.open(LINCUS_DOMAIN+"/hsj/"+filename+"?birthdate="+birthdate+"&div=BRIDGE&name="+name+"&member_list_no="+req+"&safe_key="+safe_key+"&gender="+gender+"&phone="+phone, "", "left=0,top=0,width=750,scrollbars=yes,resizable=yes");
}

function hsjRequest(filename,safeKey,isGuarantor){
	
	var div = "";
	var f 	   = ""; 
	var req 		  ="";
	var no_req = "";
	var no_surety = "";
	
	if(isGuarantor == 'Y'){
		div = "BRIDGE_GUARANTOR";
		f = document.brcSuretyFrm;
	    req = f.brcSuretyNo.value;
	    no_req = f.noReq.value;
	    no_surety = f.searchNoSurety.value;
	}else{
		div ="BRIDGE";
		f = document.brcFrm;
		req = f.noReq.value.replace(/-/gi,'');
		no_req = f.noReq.value;
		no_surety = "";
	}
	safeKey = jQuery.trim(safeKey);
	var name 		= f.nmCustom.value; 
	var jumin 		= jQuery.trim(f.noCustom.value.replace(/[^0-9]/gi,''));
	
	var param 		= "?div="+div+"&name="+name+"&member_list_no=&safe_key="+safeKey+"&ssn="+jumin+"&no_req="+no_req+"&no_surety="+no_surety;
    window.open(LINCUS_DOMAIN+"/hsj/"+filename+param, "", "left=0,top=0,width=750,scrollbars=yes,resizable=yes");
}

function relationRequest(isGuarantor){
	var noReq = "";
	var ynSurety = ""
	if(isGuarantor == 'Y'){
		f = document.brcSuretyFrm;
		noReq = f.brcSuretyNo.value;
		ynSurety = "Y";
	}else{
		f = document.brcFrm;
		noReq = f.noReq.value;
		ynSurety = "N";
	}
	//var param = "?noReq="+noReq+"&searchConfirm=Y&ynSurety="+ynSurety+"&searchNmCustom="+f.nmCustom.value;
	var param = "?noReq="+noReq+"&searchConfirm=Y&ynSurety="+ynSurety+"&searchNmCustom=";
	var jumin 		= jQuery.trim(f.noCustom.value.replace(/[^0-9]/gi,''));
	var ip 		= jQuery.trim(f.dsAccessIp.value);
	if(jumin.length > 6){
		param += "&searchNoCustomFirst="+jumin.substring(0,6);
		param += "&searchNoCustomSecond="+ jumin.substring(6,13);
	}
	if(ip.length > 6){
		param += "&searchIP="+ip;		
	}
	param += "&searchNoMobile1="+f.noTel1Mobile.value;
	param += "&searchNoMobile2="+f.noTel2Mobile.value;
	param += "&searchNoMobile3="+f.noTel3Mobile.value;
    window.open("/brc/search/select"+param ,"","width=850,height=950,scrollbars=yes,resizable=yes");
}
function resizeWin(w,h) {
    window.resizeTo(w, h);                            
    window.focus();                                        
}
//Lincus 연계검사
function relationLincusRequest(isGuarantor){
	if(isGuarantor == 'Y'){
		f = document.brcSuretyFrm;
	}else{
		f = document.brcFrm;
	}

	//var param = "?opt=ETC&name="+f.nmCustom.value;;
	var param = "?opt=ETC&name=";
	var jumin 		= $.trim(f.noCustom.value.replace(/(-)/g,''));
	if(jumin.length ==13){
			param += "&ssn11="+jumin.substring(0,6);
			param += "&ssn12="+jumin.substring(6,13);
	}
	param += "&ph21="+f.noTel1Mobile.value;
	param += "&ph22="+f.noTel2Mobile.value;
	param += "&ph23="+f.noTel3Mobile.value;
	
	//alert(param);
	window.open(LINCUS_DOMAIN+"/ups/application/relation_check.php"+param,"","left=0,top=0,width=400,height=400,scrollbars=yes,resizable=yes");
}
//Lincus 휴대폰본인인증
function hpAuthLincusRequest(p_cd_biz, p_no_req, p_man_type, p_no_custom, p_nm_custom, p_id_reg){

	var title = '휴대폰본인인증';
    var date = new Date();
    var dtm = date.getFullYear().toString() + pad2(date.getMonth() + 1) + pad2( date.getDate()) + pad2( date.getHours() ) + pad2( date.getMinutes() ) + pad2( date.getSeconds() );
    var no_custom = p_no_custom.replace("-", "");
    var no_req = p_no_req.replace("-", "");
    var year = '19' + no_custom.substr(0,2);
    var month = no_custom.substr(2,2);
    var day = no_custom.substr(4,2);    
    var sex_code = '0' + no_custom.substr(6,1);

    var url = '/kcp/WEB_ENC/kcpcert_start.php?ordr_idxx='+ p_cd_biz 
    + '_' + no_req
    + '_' + p_man_type
    + '_' + p_id_reg
    + '_' + dtm
    + '&user_name=' + p_nm_custom
    + '&year=' + year
    + '&month=' + month
    + '&day=' + day
    + '&sex_code=' + sex_code;    
	//alert(param);
	window.open(LINCUS_DOMAIN+url,"","left=0,top=0,width=600,height=350,status=no");
}
function npacRequest(mode,npacAgree,safeKey,isGuarantor, npacKind){
	
	var div = "";
	var f 	   = ""; 
	var filename = "";
	var req 		  ="";
	if(isGuarantor == 'Y'){
		div = "BRIDGE_GUARANTOR";
		f = document.brcSuretyFrm;
	    req = f.brcSuretyNo.value;
	}else{
		div ="BRIDGE";
		f = document.brcFrm;
		req = f.noReq.value.replace(/-/gi,'');
	}
	if(npacKind == "old"){
		if(mode == "request"){
			filename   = "hsj_npac_req.php";
			if(npacAgree != 'Y'){
				alert("위탁동의 후 요청 하실 수 있습니다.");
				return;
			}
		}else{
			filename   = "hsj_npac_res.php";
		}
	}else{
		if(mode == "request"){
			filename   = "hsj_link_npac_req.php";
			if(npacAgree != 'Y'){
				alert("위탁동의 후 요청 하실 수 있습니다.");
				return;
			}
		}else{
			filename   = "hsj_link_npac_res.php";
		}
	}
	


	var name 		= urlencode(f.nmCustom.value); 
	var jumin 		= f.noCustom.value.replace(/[^0-9]/gi,'');
	
	var birthdate  = jumin.substring(0,6);
	var gender     = jumin.substring(6,7);
	var phone      = f.noTel1Mobile.value+f.noTel2Mobile.value+f.noTel3Mobile.value;
	var email      = f.dsEmail.value;
	
	var param 		= "?birthdate="+birthdate+"&div="+div+"&name="+name+"&member_list_no="+req+"&safe_key="+safeKey+"&gender="+gender+"&phone="+phone+"&npac_agree="+npacAgree+"&email="+email;
    window.open(LINCUS_DOMAIN+"/hsj/"+filename+param, "", "left=0,top=0,width=750,scrollbars=yes,resizable=yes");

}

//심사메모내역팝업 
function bexMemoStory(noReq,noEx) {
	window.open("/bex/contact/select?searchNoReq="+noReq+"&searchNoEx="+noEx, "memohistory","width=500,height=700");
}
// 삭제 폼 실행 
function removeRow(no){
	 var f = document.deleteFrm;
	if(confirm("정말 삭제하시겠습니까?"))
	{
		f.no.value = no;
	 	f.submit();
	}
}
//검색폼 페이징이동
function pageMove(page,frm){
	var f;
	if(frm){
		f = frm;
	}else{
		var f = document.searchFrm;	
	}
    f.page.value = page;
    f.submit();
}
// 금액 계산
function calAmCustom(changeAm,plusAm){
	var amObj     = $("#"+changeAm);
	var am = amObj.get(0).value != "" ? amObj.get(0).value : 0;
	var resAm =  parseInt(am) + plusAm
	if(resAm > 0 ){
		amObj.get(0).value =resAm;				
	}
}
// input 숫자만 입력
function onlyNum() { 
  var keycode = window.event.keyCode;
  if(keycode == 8 || (keycode >= 35 && keycode <= 40) || (keycode >= 46 && keycode <= 57) || (keycode >= 96 && keycode <= 105) || keycode == 110 || keycode == 190) {
    window.event.returnValue = true;
    return;
  } else {
    window.event.returnValue = false;
    return;
  }
}

// opt 외 option 제거 
function resetOptions(name,opt){
	var optArr = opt.split(",");
	$("select[name='"+name+"']").find('option').each(function() {
		var isRemove = true;
		for(var i=0; i<optArr.length; i++){
			if($(this).val() == "" || $(this).val() ==optArr[i]  ){
				isRemove = false;
			}
		}
		if(isRemove){
			$(this).remove();
		}
	});
}
// table rowspan 
function tableRowSpanning(Table, spanning_row_index){
	var RowspanTd = false;
	var RowspanText = false;
	var RowspanCount = 0;
	var Rows = $('tbody tr', Table);

	$.each(Rows, function() {
		var This = $('td', this)[spanning_row_index];
		var text = $(This).text();

		if(RowspanTd == false){
			RowspanTd = This;
			RowspanText = text;
			RowspanCount = 1;
		}else if(RowspanText != text){
			$(RowspanTd)
			.attr('rowSpan', RowspanCount);
			RowspanTd = This;
			RowspanText = text;
			RowspanCount = 1;
		}else{
			$(This).remove();
			RowspanCount++;
		}
	});
	// 반복 종료 후 마지막 rowspan 적용
	$(RowspanTd)
	.attr('rowSpan', RowspanCount);
}

// 메뉴셋팅 
function page_init(){
	// Menu
	var menu = $('div.menu');
	var major = $('div.major');
	var li_list = major.find('>ul>li');

	// Selected
	function onselectmenu(){
		var myclass = [];
		
		$(this).parent('li').each(function(){
			myclass.push( $(this).attr('class') );
		});
		
		myclass = myclass.join(' ');
		if (!major.hasClass(myclass)) major.attr('class','major').addClass(myclass);
	}

	// Show Menu
	function show_menu(){
		t = $(this);
		li_list.removeClass('active');
		t.parent('li').addClass('active');
		// IE7 or IE7 documentMode bug fix
		if($.browser.msie) {
			var v = document.documentMode || parseInt($.browser.version);
			if (v == 7) {
				var subWidth = t.next('div.sub').eq(-1).width();
				t.next('div.sub').css('width',subWidth);
			}
		}
	}
	li_list.find('>a').click(onselectmenu).mouseover(show_menu).focus(show_menu);

	// Hide Menu
	function hide_menu(){
		li_list.removeClass('active');
	}
	menu.mouseleave(hide_menu);
	li_list.find('div.sub>ul').mouseleave(hide_menu);

	//icon
	major.find('div.sub').prev('a').find('>span').append('<span class="i"></span>');

	// Aside
	var aside_li = $('.menu>.inset>.aside>ul>li');
	var aside_a = $('.menu>.inset>.aside>ul>li>a');

	// Show Aside
	function show_aside(){
		li_list.removeClass('active');
		aside_li.removeClass('active');
		$(this).parent('li').addClass('active');

		// IE7 or IE7 documentMode bug fix
		if($.browser.msie) {
			var v = document.documentMode || parseInt($.browser.version);

			if (v == 7) {
				var sub = $(this).next('div.sub').eq(-1);
				sub.css('width', '').css('width', sub.width()+'px');
			}
		}
	}	
	aside_a.mouseover(show_aside).focus(show_aside);

	// Hide Aside
	function hide_aside(){
		aside_li.removeClass('active');
	}	
	menu.mouseleave(hide_aside);
	aside_li.find('div.sub>ul').mouseleave(hide_aside);

	// Hide Menu & Aside
	$('*:not(".menu *")').focus(hide_menu).focus(hide_aside);

	//anchorsBlur
	/*var anchors = document.getElementsByTagName("a");
	for (i = 0; i < anchors.length; i++){
		anchors.item(i).onfocus = new Function("anchors.item(" + i + ").blur()");
		//anchors.item(i).target = '_parent';
	}*/
}
// 테이블 정렬
function strupidtableSetting(tbl_id){
	 var table = $("#"+tbl_id).stupidtable({
		"date":function(a,b){
		  aDate = date_from_string(a);
		  bDate = date_from_string(b);
		  return aDate - bDate;
		},
		"moveBlanks": moveBlanks,
		"moveBlanksDesc": moveBlanksDesc
	  });
	  table.on("aftertablesort", function (event, data) {
		var th = $(this).find("th");
		th.find(".order").remove();
		var dir = $.fn.stupidtable.dir;

		var arrow = data.direction === dir.ASC ? "&uarr;" : "&darr;";
		th.eq(data.column).append('<span class="order">' + arrow +'</span>');
	  });

	$("tr").slice(1).click(function(){
		$(".awesome").removeClass("awesome");
		$(this).addClass("awesome");
	});
}
// 입력글자수 표기
function printLength(objID, byteID){
	$("#"+byteID).html($("#"+objID).get(0).value.bytes());
}
//이미지 확장자체크 
function checkAllowExt(file){
    var result = false;
    while (file.indexOf("\\") != -1){
        file = file.slice(file.indexOf("\\") + 1);
    }
    var fileExt = file.slice(file.indexOf(".")).toLowerCase();
    var allowExt = [".jpg", ".jpeg", ".gif", ".png", ".tif", ".tiff"];
    jQuery.each( allowExt, function( i, ext ) { 
        if(ext == fileExt) result = true;
    });
    return result;
}

function getDate(day){
	var searchDate	= "";	
	var today		= new Date();
	if(day == 0){
		searchDate	= today.getFullYear()+ "-" +(today.getMonth() + 1) + "-" + today.getDate() ;
	}
	else if(day < 0 || day > 0){
		var addTimeStemp = 24*60*60*day*1000;
		var selectDay	 = new Date(today.valueOf() + (addTimeStemp));
		searchDate	= selectDay.getFullYear()+ "-" +(selectDay.getMonth() + 1) + "-" + selectDay.getDate() ;
	}
	return searchDate;
}

function getCompanyDomain(loginCode,domainSession){
	var domain = "";
	if(loginCode == 'Y' || domainSession == 'youi-cuebridge.cashway.co.kr'){
		domain = "https://youi-lincus.cashway.co.kr";
	}else if(loginCode == 'M' || domainSession == 'mill-cuebridge.cashway.co.kr'){
		domain = "https://million-lincus.cashway.co.kr";
	}else if(loginCode == 'S' || domainSession == 'star-cuebridge.cashway.co.kr'){
		domain = "https://star-lincus.cashway.co.kr";
	}
	return domain;
}

/* prototype */
String.prototype.isEmail = function() {
	return /^(\.?[-!#$%&\'*+/0-9=?A-Z^_a-z`{|}~])*@[a-zA-Z](-?[a-zA-Z0-9])*(\.[a-zA-Z](-?[a-zA-Z0-9])*)+$/.test(this);
}
String.prototype.isID = function() {
	return /^[a-zA-Z0-9-_]{3,20}$/.test(this);
}
String.prototype.bytes = function() {
    for(var i = l = 0; i < this.length; i++) {
        l += (this.charCodeAt(i) > 127) ? 2 : 1;
	}
    return l;
}
/*
 * phpjs
*/
function explode(delimiter, string, limit) {
  if (arguments.length < 2 || typeof delimiter === 'undefined' || typeof string === 'undefined') return null;
  if (delimiter === '' || delimiter === false || delimiter === null) return false;
  if (typeof delimiter === 'function' || typeof delimiter === 'object' || typeof string === 'function' || typeof string ===
    'object') {
    return {
      0: ''
    };
  }
  if (delimiter === true) delimiter = '1';

  delimiter += '';
  string += '';

  var s = string.split(delimiter);

  if (typeof limit === 'undefined') return s;

  // Support for limit
  if (limit === 0) limit = 1;

  // Positive limit
  if (limit > 0) {
    if (limit >= s.length) return s;
    return s.slice(0, limit - 1)
      .concat([s.slice(limit - 1)
        .join(delimiter)
      ]);
  }

  // Negative limit
  if (-limit >= s.length) return [];

  s.splice(s.length + limit);
  return s;
}
function number_format(number, decimals, dec_point, thousands_sep) {
  number = (number + '')
    .replace(/[^0-9+\-Ee.]/g, '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n))
    .split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '')
    .length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1)
      .join('0');
  }
  return s.join(dec);
}
function intval(mixed_var, base) {
  var tmp;

  var type = typeof mixed_var;

  if (type === 'boolean') {
    return +mixed_var;
  } else if (type === 'string') {
    tmp = parseInt(mixed_var, base || 10);
    return (isNaN(tmp) || !isFinite(tmp)) ? 0 : tmp;
  } else if (type === 'number' && isFinite(mixed_var)) {
    return mixed_var | 0;
  } else {
    return 0;
  }
}
function str_replace(search, replace, subject, count) {
  var i = 0,
    j = 0,
    temp = '',
    repl = '',
    sl = 0,
    fl = 0,
    f = [].concat(search),
    r = [].concat(replace),
    s = subject,
    ra = Object.prototype.toString.call(r) === '[object Array]',
    sa = Object.prototype.toString.call(s) === '[object Array]';
  s = [].concat(s);
  if (count) {
    this.window[count] = 0;
  }

  for (i = 0, sl = s.length; i < sl; i++) {
    if (s[i] === '') {
      continue;
    }
    for (j = 0, fl = f.length; j < fl; j++) {
      temp = s[i] + '';
      repl = ra ? (r[j] !== undefined ? r[j] : '') : r[0];
      s[i] = (temp)
        .split(f[j])
        .join(repl);
      if (count && s[i] !== temp) {
        this.window[count] += (temp.length - s[i].length) / f[j].length;
      }
    }
  }
  return sa ? s : s[0];
}

function print_r(array, return_val) {

	var output = '', pad_char = ' ', pad_val = 4, d = this.window.document, getFuncName = function(
			fn) {
		var name = (/\W*function\s+([\w\$]+)\s*\(/).exec(fn);
		if (!name) {
			return '(Anonymous)';
		}
		return name[1];
	};
	repeat_char = function(len, pad_char) {
		var str = '';
		for (var i = 0; i < len; i++) {
			str += pad_char;
		}
		return str;
	};
	formatArray = function(obj, cur_depth, pad_val, pad_char) {
		if (cur_depth > 0) {
			cur_depth++;
		}

		var base_pad = repeat_char(pad_val * cur_depth, pad_char);
		var thick_pad = repeat_char(pad_val * (cur_depth + 1), pad_char);
		var str = '';

		if (typeof obj === 'object' && obj !== null && obj.constructor
				&& getFuncName(obj.constructor) !== 'PHPJS_Resource') {
			str += 'Array\n' + base_pad + '(\n';
			for ( var key in obj) {
				if (Object.prototype.toString.call(obj[key]) === '[object Array]') {
					str += thick_pad
							+ '['
							+ key
							+ '] => '
							+ formatArray(obj[key], cur_depth + 1, pad_val,
									pad_char);
				} else {
					str += thick_pad + '[' + key + '] => ' + obj[key] + '\n';
				}
			}
			str += base_pad + ')\n';
		} else if (obj === null || obj === undefined) {
			str = '';
		} else { // for our "resource" class
			str = obj.toString();
		}

		return str;
	};

	output = formatArray(array, 0, pad_val, pad_char);

	return output;
}

function pad2(n) { return n < 10 ? '0' + n : n }

// daum 우편번호
function execDaumPostcode(noPostFront, noPostRear, dsStrt, dsAddr) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }
            
/*            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }*/
            
            // *********** 도로명 주소만 강제            
            fullAddr = data.roadAddress;
            //법정동명이 있을 경우 추가한다.
            if(data.bname !== ''){
                extraAddr += data.bname;
            }
            // 건물명이 있을 경우 추가한다.
            if(data.buildingName !== ''){
                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
            fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');            
            

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            noPostFront.value = data.postcode1;
            noPostRear.value = data.postcode2;
            dsStrt.value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            dsAddr.focus();
        }
    }).open();
}

function printInfo(p_msg, p_refresh){
	var html = "";
	p_msg = p_msg.replace(/(?:\r\n|\r|\n)/g, '<br />');
	
	html = '<div class="layer">'+
	'<div class="bg"></div>'+
		'<div id="openLayer" class="pop-layer">'+
			'<div class="pop-container">'+
				'<div class="pop-conts">'+
					'<p class="ctxt mb20">'+
					'</p>'+
					'<h3 class="ly_header">*Info*</h3>'+'<br>'+'<br>'+
					p_msg+'<br>'+'<br>'+
					'<a href="#" class="cbtn">Close</a>'+'<br>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'+
	'</div>';
	$("#info_msg_pop").html(html);
	
	
	var temp = $("#openLayer");
	var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

	if(bg){
		$('.layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
	}else{
		temp.fadeIn();
	}

	// 화면의 중앙에 레이어를 띄운다.
	if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
	else temp.css('top', '0px');
	if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
	else temp.css('left', '0px');

	temp.find('a.cbtn').click(function(e){
		if(bg){
			$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
		}else{
			temp.fadeOut();
		}
		e.preventDefault();
		if(p_refresh == true){
			document.location.reload();
		}
	});

	$('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
		if(p_refresh == true){
			document.location.reload();
		}
	});

}	



