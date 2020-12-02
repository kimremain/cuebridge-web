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

	/* anchorsBlur
	var anchors = document.getElementsByTagName("a");
	for (i = 0; i < anchors.length; i++){
		anchors.item(i).onfocus = new Function("anchors.item(" + i + ").blur()");
		//anchors.item(i).target = '_parent';
	}*/
}

var enErrorDialogs = {
    errorTitle : '유효하지 않은 입력값이 있습니다.',
    requiredFields : '필수 항목입니다.',
    badTime : '유효하지 않은 시간입니다.',
    badEmail : '유효하지 않은 E-Mail주소입니다.',
    badTelephone : '유효하지 않은 전화번호 입니다.',
    badSecurityAnswer : '보안 입력값이 올바르지 않습니다.',
    badDate : '유효하지 않은 날짜 입니다',
    lengthBadStart : 'You must give an answer between ',
    lengthBadEnd : 'characters',
    lengthTooLongStart : 'You have given an answer longer than ',
    lengthTooShortStart : 'You have given an answer shorter than ',
    notConfirmed : 'Values could not be confirmed',
    badDomain : 'Incorrect domain value',
    badUrl : '유효하지 않은 URL 입니다.',
    badCustomVal : 'You gave an incorrect answer',
    badInt : '숫자형식으로만 입력하셔야 합니다.',
    badSecurityNumber : 'Your social security number was incorrect',
    badUKVatAnswer : 'Incorrect UK VAT Number',
    badStrength : 'The password isn\'t strong enough',
    badNumberOfSelectedOptionsStart : 'You have to choose at least ',
    badNumberOfSelectedOptionsEnd : ' answers',
    badAlphaNumeric : 'The answer you gave must contain only alphanumeric characters ',
    badAlphaNumericExtra: ' and ',
    wrongFileSize : 'The file you are trying to upload is too large',
    wrongFileType : 'The file you are trying to upload is of wrong type',
    groupCheckedTooFewStart : 'Please choose at least ',
    groupCheckedTooManyStart : 'Please choose a maximum of ', 
    groupCheckedRangeStart : '유효한 항목만 선택할 수 있습니다.( ',
    groupCheckedEnd : ' 항목)'
};

window.applyValidation = function(form_id , modules) {
	$.validate({
		form : form_id,
		modules : modules,
		language : enErrorDialogs,
	    validateOnBlur : true,
		errorMessagePosition : '',
		scrollToTopOnError : false,
		onError : function() {
			//end_overlay();
			//console.log('form validation onError');
		},
		onSuccess : function() {
		  //console.log('form validation onSuccess submit!');
		  //start_overlay();
		  process_start();
		  return true;
		  //return false; // Will stop the submission of the form
		},
		onValidate : function($f) {
		  //console.log('validate start =  '+$f.attr('id'));
		}
	  });
}