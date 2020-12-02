//인바운드 검색
function brcSearchInbound(f){
	$('#inboundSearchResult').block({});
	$.post("/brc/inbound/select", $(f).serializeArray() , function(responseData){
           $('#inboundSearchResult').html(responseData);
       });
}
function searchCustomerPopup(){
    //window.open('/customer/popup','customerPOP','width=1500,height=1000');
    //return false;
}
// 접수신규등록 팝업
function registCustomerPopup(){
    window.open('/brc/loanregist/select','customerRegistPOP','width=900,height=300');
    return false;
}
// 연계검사팝업 
function layerInboundOpenPop(){
	window.open("/brc/search/select" ,"","width=800,height=800,scrollbars=yes,resizable=yes");
}
// 접수메모/SMS 탭변경
function changeContactTab(flag){
	if(flag == "tel"){
		reloadListMemo(SEARCH_NO_REQ,"71201");
    }else if(flag == "sms"){
		reloadListMemo(SEARCH_NO_REQ,"71202");
    }
    $('#tab_menu_contact >  li').removeClass('selected');
    $('#tab_menu_contact_'+flag).addClass('selected');
}
// 접수메모/SMS이력  - 리스트 갱신  
function reloadListMemo(searchNoReq,cdContact){
	var noReq = (searchNoReq) ? searchNoReq : SEARCH_NO_REQ;
	var searchCdStatus = document.memoRegistFrm ? document.memoRegistFrm.searchCdStatus.value : '';
	$.ajaxSetup({async: true});
   	$.post("/brc/contact/select", {searchNoReq:noReq,cdContact:cdContact,searchCdStatus:searchCdStatus}, function(responseData){
           $('#memoList').html(responseData);
       });
}
//웹팩스/MMS 탭변경
function changeImageTab(noReq, searchKind, searchParam){
	reloadImageList(noReq, searchKind,searchParam);
    $('#tab_menu_image >  li').removeClass('selected');
    $('#tab_menu_image_'+searchKind).addClass('selected');
}
//웹팩스/MMS - 리스트 갱신  
function reloadImageList(noReq, searchKind, searchParam){	
	$.ajaxSetup({async: true});
   	$.post("/brc/imagelist/select", {noReq:noReq, searchKind:searchKind, searchParam:searchParam}, function(responseData){
           $('#imageList').html(responseData);
       });
}
// 이미지뷰어 팝업
function openImageViewer(noReq, dsFileBase64){
	var url = "/common/imageview/select?noReq="+noReq+"&dsFileBase64="+dsFileBase64;
	window.open(url,"","width=1200,height=950,scrollbars=yes,resizable=yes")
}
// 접수메모 프로세스 실행시작
function processStartMemo(){
    ON_SUBMIT_PROCESS = true;
    $('#memoList').block({});
}
// 접수메모 프로세스 실행종료
function processEndMemo(){
    ON_SUBMIT_PROCESS = false;
    $('#memoList').unblock({});
}
// 접수메모 저장 
function insertMemo(btnObj,flag){
	var f  = document.memoRegistFrm;
	if(ON_SUBMIT_PROCESS){
	    alert("실행중")
    }else{
    	if(!f.dsMemo.value){
    		alert("메모를 입력하셔야 합니다.");
    		return;
    	}else{
    		f.memoStepFlag.value = flag;
    		processStartMemo();
            $.ajax({
                type: "POST",
                url: "/brc/contact/insert.json",
                cache:false,
                dataType: "json",
                async: false,
                data: $(f).serializeArray() ,
                success: function(data){
                    if(data.result == 'success'){
                        if(flag == "stepup_71003"){
                        	// 상태값이 변경된 좌측 메뉴 갱신을 위해 예외적으로 새로고침 한다. 
                        	document.location.href = "/brc/loan/select?searchNoReq="+f.noReq.value+"&searchCdStatus=71003";
                        }else{
                        	reloadListMemo(SEARCH_NO_REQ,"71201");
                        }
                   
                    }else{
                        alert(data.message);
                    }
                    processEndMemo();
                }
             });
    	}
    }
}
// 접수메모 삭제처리 
function removeMemo(no){
    var f  = document.memoRegistFrm;
    if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
        if(confirm("정말 삭제하시겠습니까?")){
        	processStartMemo();
        	$.ajax({
                type: "POST",
                url: "/brc/contact/delete.json",
                cache:false,
                dataType: "json",
                async: false,
                data: "no="+no+"&searchNoReq"+SEARCH_NO_REQ ,
                success: function(data){
                    if(data.result == 'success'){
                    	reloadListMemo(SEARCH_NO_REQ,"71201");
                    }else{
                        alert(data.message);
                    }
                    processEndMemo();
                }
             });
        }
    }
}
//수정폼취소
function cancelModifyMemo(no){
    $("#memoCont"+no).show();
    $("#memoForm"+no).hide();
    $("#memoForm"+no).html('');
}
//수정폼생성 
function makeModifyMemoForm(no){
    $("#memoCont"+no).hide();
   var memoCont = $("#memoCont"+no).html().replace(/\s*<br>\s*/gi,'\r\n'); //html 에서 공백이 들어감 
   //memoCont = memoCont.replace(/(<br>|<br\s*\/>)/gi,"\r\n")
   //memoCont = str_replace('<br>','\r\n',memoCont);
    var formHtml = '<textarea id="dsMemoModify'+no+'"  style="width:100%;height:120px;margin-bottom:10px">'+memoCont+'</textarea>'+
                         '<p class="fl"><span class="btn_pack medium icon"><span class="check"></span><input type="button" value="취소" onclick="cancelModifyMemo('+no+')" ></span></p>'+
    		             '<p class="fr"><span class="btn_pack medium icon"><span class="check"></span><input type="button" value="메모수정" onclick="modifyMemo('+no+')"></span></p>';
    		             
    $("#memoForm"+no).html(formHtml);
    $("#memoForm"+no).show();
}
//수정처리 
function modifyMemo(no){
    var dsMemo = $("#dsMemoModify"+no).get(0).value;
    
     if(ON_SUBMIT_PROCESS){
        alert("실행중")
    }else{
    	if(!dsMemo){
            alert("메모를 입력하셔야 합니다.");
            return;
        }else{
	    	processStartMemo();
	    	var f = document.memoUpdateFrm;
	        f.no.value = no;
	        f.dsMemo.value = dsMemo;
	        f.searchNoReq.value = SEARCH_NO_REQ;
	        //alert(dsMemo);
	         $.ajax({
	             type: "POST",
	             url: "/brc/contact/update.json",
	             cache:false,
	             dataType: "json",
	             async: false,
	             data: $(f).serializeArray() , //"no="+no+"&dsMemo="+dsMemo+"&searchNoReq"+SEARCH_NO_REQ  ,
	             success: function(data){
	                 if(data.result == 'success'){
	                	 reloadListMemo(SEARCH_NO_REQ,"71201");
	                 }else{
	                     alert(data.message);
	                 }
	                 processEndMemo();
	             }
	          });
        }
    }
}
// 상태변경시 2차 콤보박스 셋팅 
function changeCdStatus(sel){
	$("#addSelCdReject").hide();
	$("#addSelCdCancel").hide();
	$("#retryLink").hide();
	
	// 벨리데이션 초기화
	$("#cdRecruitGroup").attr('data-validation', '');
	
	// 각 상태별 벨리데이션 필요할 경우 항목기술
	if(sel == "71001"){ // 대기
		
	}else if(sel == "71002"){ // 접수
		
	}else if(sel == "71003"){ // 상담중
		
	}else if(sel == "71004"){ // 상담완료
		
	}else if(sel == "71005"){ // 상담종료
		$("#cdRecruitGroup").attr('data-validation', 'required');
	}else if(sel == "71006"){ // 재영업대상
		
	}else if(sel == "71007"){ // 거절
		$("#cdRecruitGroup").attr('data-validation', 'required');
	}else if(sel == "71008"){ // 취소
		
	}else if(sel == "71009"){ // 보류
		
	}else if(sel == "71010"){ // 익일영업
		
	}else if(sel == "71011"){ // 허위접수
		
	}else if(sel == "71012"){ // 삭제
		
	}else if(sel == "71013"){ // 중개
		
	}
	
	if(sel == "71007"){ // 거절 
		$("#addSelCdReject").show();
		$("#retryLink").show();
	}else if(sel == "71008"){ // 취소 
		$("#addSelCdCancel").show();
		$("#retryLink").show();
	}
}

// 이메일 도메인 변경
function changeEmailDomain(inputId,selDomain){
	var nowEmailArr = explode("@",$("#"+inputId).get(0).value);
	var changeEmail ="";
	if(selDomain){
		changeEmail = nowEmailArr[0]+ selDomain;
	}else{
		changeEmail = nowEmailArr[0]+"@";
	}
	$("#"+inputId).get(0).value = changeEmail;
}
function getAgeSexMsg(juminNumber){
	nowDate	 =  new Date();
	nowYear	 =  parseInt(nowDate.getFullYear());
	nowMonth =  parseInt(nowDate.getMonth());

	var msg = "";	
	juminNumber = juminNumber.replace(/[^0-9]/g,"");
	if (juminNumber.length >= 7) {

		sex = juminNumber.substring(6,7);
		
		// 만나이계산 
		if (sex == '1' || sex == '2' || sex == '5' || sex == '6')		year = '19';
		else if (sex == '3' || sex == '4' || sex == '7' || sex == '8')  year = '20';
		else if (sex == '9' || sex == '0')								year = '18';
		
		// 생년
		year = parseInt(year + juminNumber.substring(0,2));
		
		// 생일지났는지 체크 
		if ((nowMonth + 1)* 100 + nowDate.getDate() < juminNumber.substring(2,6) ){
			age = nowYear - year - 1;
		}else{
			age = nowYear - year;
		}
		msg += "만"+age+"세";
		
		// 성별 
		if(sex == '1' || sex == '5'){
			msg += "/남";
		}else if(sex == '2' || sex == '6'){
			msg += "/여";
		}
	}else if (juminNumber.length == 1 ){
		if( juminNumber== 1 ){
			msg = "남";
		}else if(juminNumber ==2){
			msg = "여";
		}
		 
	}
	return msg;
}

//첨부파일 삭제
function deleteAttach(){
	 if(confirm("정말 삭제하시겠습니까?")){
		 var f = document.attachUpdateFrm;
	     f.action = "/brc/attach/delete";
	     document.attachUpdateFrm.submit();
	 }
	 return;
}

// 첨부파일 수정 
function updateAttach(){
	 var f = document.attachUpdateFrm;
	 f.action = "/brc/attach/update";
	 document.attachUpdateFrm.submit();
}

// 첨부파일 뷰어 
function setFileViewer(p_obj, no,cdFile,dsPath,nmFile){
    
	var f = document.attachUpdateFrm;
	f.no.value = no;
	f.cdFile.value = cdFile;
	f.dsPath.value = dsPath;
	f.nmFile.value = nmFile;
    $("#updateNmFileUser").html($("#attachNmFileUser"+no).html());
	f.dsRemk.value = $("#attachDsRemk"+no).html();
	$("#fileForm").show();
	
    var fileExt = nmFile.slice(nmFile.indexOf(".")).toLowerCase();
    var url = "/common/file/download/";
    var dsFileBase64 = p_obj.value;

    if(fileExt == '.tif' || fileExt == '.tiff'){
    	   var i = '<object width="980" height="800"  classid="CLSID:106E49CF-797A-11D2-81A2-00E02C015623" codebase="/images/alttiff.ocx#version=1,8,2,1">'+
    	    '<param name="src" value="'+url+dsFileBase64+'">'+
    	        '</object>';
    }
    else if(fileExt == '.jpg' || fileExt == '.jpeg' || fileExt == '.gif' || fileExt == '.png'){
    	var i = '<img src="'+url+dsFileBase64+'" width="980" />';
    }
	$("#fileViewer").html(i);
}
// 약속시간초기화
function promiseDateReset(){
	var f = document.brcFrm;
	f.dmPromiseYMD.value="";
	f.dmPromiseHH.value="";
	f.dmPromiseMI.value="";
}
// 첨부파일 submit 
function uploadChk(f){
    if((f.dsFileFrom)|| f.file.value){
       if(f.file.value){
            if(!checkAllowExt(f.file.value)){
                alert("이미지 형식만 업로드 하실 수 있습니다.");
                return false;
            }
       }
       if(!f.cdFile.value){
           alert("첨부파일 구분을 선택하셔야 합니다.");
           return false;
       }else{
           return true;
       }
    }else{
            alert("업로드할 파일 혹은 WEBFAX 를 선택하셔야 합니다.");
            return false;
    }
}

//보증인 정보 submit 
function brcSuretySubmit(p_flag){
	var f = document.brcSuretyFrm;
	if(!$.trim(f.nmCustom.value)){
	    alert("보증인명을 입력하셔야 합니다.");
	    f.nmCustom.focus();
 }else{
 	f.action = p_flag;
     f.submit();
 }
}
//대출실행 submit
function submitBexMaster(f){
	var company = $("#bexCdCooperate option:selected").text(); 
	var f = document.brcFrm;
/*	if(!$.trim(f.noPostRealFront.value)){
	    alert("실거주지 우편번호를 입력하셔야 합니다.");
	    return false;
	}
	if(!$.trim(f.noPostRealRear.value)){
	    alert("실거주지 우편번호를 입력하셔야 합니다.");
	    return false;
	}
	if(!$.trim(f.dsStrtReal.value)){
	    alert("실거주지 주소를 입력하셔야 합니다.");
	    return false;
	}*/
	if($.trim(f.amCustom.value)=="" || $.trim(f.amCustom.value)==0){
	    alert("신청금액을 입력하셔야 합니다.");
	    return false;
	}
	if(confirm(company+"로 대출 실행을 진행하시겠습니까?")){
		 $("#submitCooperateBtn").attr("disabled","disabled");
		 $('#cooperateArea').block({});
		 return true;
	}else{
		return false;
	}
   
}
