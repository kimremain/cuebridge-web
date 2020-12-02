/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: KO (Korean; 한국어)
 http://formvalidator.net/
 */
 /*
(function($) {
	$.extend($.validator.messages, {
		required: "필수 항목입니다.",
		remote: "항목을 수정하세요.",
		email: "유효하지 않은 E-Mail주소입니다.",
		url: "유효하지 않은 URL입니다.",
		date: "올바른 날짜를 입력하세요.",
		dateISO: "올바른 날짜(ISO)를 입력하세요.",
		number: "유효한 숫자가 아닙니다.",
		digits: "숫자만 입력 가능합니다.",
		creditcard: "신용카드 번호가 바르지 않습니다.",
		equalTo: "같은 값을 다시 입력하세요.",
		extension: "올바른 확장자가 아닙니다.",
		maxlength: $.validator.format("{0}자를 넘을 수 없습니다. "),
		minlength: $.validator.format("{0}자 이상 입력하세요."),
		rangelength: $.validator.format("문자 길이가 {0} 에서 {1} 사이의 값을 입력하세요."),
		range: $.validator.format("{0} 에서 {1} 사이의 값을 입력하세요."),
		max: $.validator.format("{0} 이하의 값을 입력하세요."),
		min: $.validator.format("{0} 이상의 값을 입력하세요.")
	});
}(jQuery));


var enErrorDialogs = {
    errorTitle : 'Form submission failed!',
    requiredFields : '필수 항목입니다.',
    badTime : 'You have not given a correct time',
    badEmail : 'You have not given a correct e-mail address',
    badTelephone : 'You have not given a correct phone number',
    badSecurityAnswer : 'You have not given a correct answer to the security question',
    badDate : 'You have not given a correct date',
    lengthBadStart : 'You must give an answer between ',
    lengthBadEnd : 'characters',
    lengthTooLongStart : 'You have given an answer longer than ',
    lengthTooShortStart : 'You have given an answer shorter than ',
    notConfirmed : 'Values could not be confirmed',
    badDomain : 'Incorrect domain value',
    badUrl : 'The answer you gave was not a correct URL',
    badCustomVal : 'You gave an incorrect answer',
    badInt : 'The answer you gave was not a correct number',
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
    groupCheckedRangeStart : 'Please choose between ',
    groupCheckedEnd : ' item(s)'
};
*/


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

/*
debug
$('input')
	.on('beforeValidation', function() {
		console.log('About to validate input "'+this.name+'"');
	})
   
.on('validation', function(evt, isValid) {
		var validationResult = '';
		if( isValid === null ) {
			validationResult = 'not validated';
		} else if( isValid ) {
			validationResult = 'VALID';
		} else {
			validationResult = 'INVALID';
		}
		console.log('Input '+this.name+' is '+validationResult);
});*/

