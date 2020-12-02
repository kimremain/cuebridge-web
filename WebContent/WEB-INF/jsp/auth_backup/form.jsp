<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page session="true" pageEncoding="utf-8"%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>Login</title>

<style type="text/css">
html, body{height:100%;margin:0}
.mw_login{display:non1e;position:fixed;_position:absolute;top:0;left:0;z-index:10000;width:100%;height:100%}
.mw_login.open{display:block}
.mw_login .bg{position:absolute;top:0;left:0;width:100%;height:100%;background:#000;opacity:.5;filter:alpha(opacity=50)}
#login{position:absolute;top:50%;left:50%;width:328px;margin:-150px 0 0 -194px;padding:28px 28px 0 28px;border:2px solid #555;background:#fff;font-size:12px;font-family:Tahoma, Geneva, sans-serif;color:#767676;line-height:normal;white-space:normal}
#login form{display:none;margin:0;padding:0}
#login fieldset{margin:0;padding:0;border:0}
#login legend{visibility:hidden;position:absolute;top:0;left:0;width:1px;height:1px;font-size:0;line-height:0}
#login .btn_login,
#login .btn_login input{display:inline-block;overflow:visible;position:relative;height:32px;margin:0;padding:0;border:0;background:transparent url(/images/btn_login.gif) no-repeat;font-size:12px;font-weight:bold;color:#fff;line-height:32px;text-decoration:none !important;vertical-align:middle;cursor:pointer}
#login .btn_login{margin:0 4px 0 0;background-position:left top}
#login .btn_login input{left:4px;padding:0 24px 0 36px;background-position:right top;*vertical-align:top}
#login .item{position:relative}
#login .i_label{display:block;position:static;top:9px;font:bold 11px Tahoma}
#login .i_text{display:block;position:relative;border:1px solid #b7b7b7;border-right-color:#e1e1e1;border-bottom-color:#e1e1e1;background:transparent;font:bold 11px Tahoma;height:14px;color:#767676}
#login .help{float:none;display:block;position:relative;margin:0 -28px;border:0;padding:15px 0;border-top:1px solid #d9d9d9;background:#fafafa;text-align:center;list-style:none;*zoom:1}
#login .help li{display:inline;float:none;margin:0;padding:0 6px 0 10px;border-left:1px solid #c3c3c3 !important;line-height:1}
#login .help li.first{border:0 !important}
#login .help a{display:inline;float:none;padding:0;background:none;font-size:11px;font-family:Dotum, 돋움, Sans-serif;color:#767676;line-height:1;text-decoration:none}
#login .help a:hover,
#login .help a:active,
#login .help a:focus{color:#000;text-decoration:underline}
#login .g_login .i_label{left:10px}
#login .g_login .i_text{width:316px;margin:0 0 5px 0;padding:8px 0 6px 10px}
#login .g_login .btn_login{position:absolute;top:103px;right:28px}
#login .g_login .keeping{float:none;height:32px;margin:10px 0;padding:0;line-height:32px}
#login .g_login .keeping label{position:static;font-family:Dotum, 돋움, Thahoma;cursor:pointer}
#login .g_login .i_check{width:13px;height:13px;margin:0 4px 0 0;padding:0;vertical-align:middle}
#login .g_login .warning{display:none;float:none;margin:10px 0;line-height:1.4}
#login .g_login .warning.open{display:block}
#login .o_login{text-align:center}
#login .o_login .i_label{left:36px}
#login .o_login .i_text{width:291px;margin:0;padding:8px 0 6px 35px;background:url(img/ico_openid.gif) no-repeat 10px center}
#login .o_login .btn_login{margin-top:10px;margin-bottom:10px}
#login.g_login .g_login,
#login.o_login .o_login{display:block}
#login .close{overflow:visible;position:absolute;top:0;right:0;width:25px;height:25px;padding:0;border:0;background:transparent;font:11px/25px Verdana, Geneva, sans-serif;color:#ccc;text-align:center;text-decoration:none !important;cursor:pointer}
</style>
</head>
<body>
<div style="font-size:9px">
Session ID : ${userVO.idUser} <br/>
Session NM : ${userVO.nmUser} <br/>
Session TM : ${userVO.cdTeam} <br/>
Session dsUrl : ${userVO.dsUrl} <br/>

<%
String domainSession = (String) session.getAttribute(CommonConstants.SESSION_KEY_DOMAIN);
out.println( "<br>session 생성 시간 : "+new java.util.Date(session.getCreationTime()).toString());  // creation time
out.println( "<br>session 최종 접속시간 : "+new java.util.Date(session.getLastAccessedTime()).toString()); // last access time
out.println( "<br>session 유지시간 : "+session.getMaxInactiveInterval()); // second
out.println( "<br>domainSession : "+domainSession); // second
%>     
</div>


<div class="mw_login open">
    <div class="bg"></div>
    <div id="login" class="g_login">
        ${domainSession}${loginRequestVO.loginErrorCode } 
        <form name="loginFrm" id="g_login" class="g_login" method="post">
        <input type="hidden" name='login_code' value="S">
            <fieldset>
                <legend>CueBridge Login</legend>
                <div class="item">
                    <label for="uid" class="i_label">ID</label><input name="id" type="text"  id="uid" class="i_text uid">
                </div>
                <div class="item">
                    <label for="upw" class="i_label">PASSWORD</label><input name="passwd" type="password" id="upw" class="i_text upw">
                </div>
                <p class="keeping"></p>
                <p class="warning"></p>
                <span class="btn_login"><input name="" type="submit" value="로그인"></span>
                <ul class="help">
                <li  class="first"><a href="#o_login" class="o_anchor">Bridge 로그인 </a></li>
                </ul>
            </fieldset>
        </form>
        <form  action="/login/check/update" method="post"  id="o_login" class="o_login" method="post">
        <input type="hidden" name="referer" value="${loginRequestVO.referer }" />
            <fieldset>
                <legend>Lincus Login</legend>
                <div class="item">
                    <label for="oid" class="i_label">ID</label><input name="loginUserId" type="text" value="" id="oid" class="i_text oid">
                </div>
                <div class="item">
                    <label for="opw" class="i_label">PASSWORD</label><input name="loginUserPw" type="password" id="opw" class="i_text opw">
                </div>
                <span class="btn_login"><input name="" type="submit" value="로그인"></span>
                <p class="help"><a href="#g_login" class="g_anchor">Lincus 로그인</a></p>
            </fieldset>
        </form>

    </div>
</div>

<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
jQuery(function($){
	
	loginDomain = getCompanyDomain("","${domainSession}");
    document.loginFrm.action = loginDomain+"/importantShare/login.php";
	
    var loginWindow = $('.mw_login');
    var login = $('#login');
    var uid = $('.i_text.uid');
    var upw = $('.i_text.upw');
    var oid = $('.i_text.oid');
    var opw = $('.i_text.opw');
    
    // Show Hide
    $('.login_trigger').click(function(){
        loginWindow.addClass('open');
    });
    $('#login .close').click(function(){
        loginWindow.removeClass('open');
    });
    // o_login
    $('.o_anchor').click(function(){
        login.removeClass('g_login');
        login.addClass('o_login');
    });
    // g_login
    $('.g_anchor').click(function(){
        login.removeClass('o_login');
        login.addClass('g_login');
    });
    // Warning
    $('#keepid').change(function(){
        if($('#keepid[checked]')){
            $('.warning').toggleClass('open');
        };
    });
    // Input Clear
    var i_text = $('.item>.i_label').next('.i_text');
    $('.item>.i_label').css('position','absolute');
    i_text
        .focus(function(){
            $(this).prev('.i_label').css('visibility','hidden');
        })
        .blur(function(){
            if($(this).val() == ''){
                $(this).prev('.i_label').css('visibility','visible');
            } else {
                $(this).prev('.i_label').css('visibility','hidden');
            }
        })
        .change(function(){
            if($(this).val() == ''){
                $(this).prev('.i_label').css('visibility','visible');
            } else {
                $(this).prev('.i_label').css('visibility','hidden');
            }
        })
        .blur();
    // Validation
    $('#login>.g_login input[type=submit]').click(function(){
        if(uid.val() == '' && upw.val() == ''){
            alert('ID와 PASSWORD를 입력하세요!');
            return false;
        }
        else if(uid.val() == ''){
            alert('ID를 입력하세요!');
            return false;
        }
        else if(upw.val() == ''){
            alert('PASSWORD를 입력하세요!');
            return false;
        }
    });
    $('#login>.o_login input[type=submit]').click(function(){
        if(oid.val() == ''){
            alert(' ID를 입력하세요!');
            return false;
        }
        else if(opw.val() == ''){
            alert('PASSWORD를 입력하세요!');
            return false;
        }
    });
    // ESC Event
    $(document).keydown(function(event){
        if(event.keyCode != 27) return true;
        if (loginWindow.hasClass('open')) {
            loginWindow.removeClass('open');
        }
        return false;
    });

});
</script>

</body> 
</html>

