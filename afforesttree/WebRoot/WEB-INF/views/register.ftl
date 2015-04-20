<@page.html> 
<div class="site clearfix" role="main">
	<div id="site-container" class="context-loader-container" data-pjax-container="">
		<div id="login" class="auth-form">
			<form method="post" action="register.do" accept-charset="UTF-8">
				<div style="margin:0;padding:0;display:inline">
					<input type="hidden" id="token" name="token" value="${token}">
				</div>
				<div class="auth-form-header">
					<h1><@spring.message "register"/></h1>
				</div>
				<div class="auth-form-body">
					<#if errorCode?exists>
						<label for="login_field"><font color="red"> <@spring.message "error_content"+errorCode/> </font></label></br>
					</#if>
					<label for="login_field"> <@spring.message "email"/> <font color="red" id="input_email_error"></font></label>
					<input id="email" class="input-block" type="text" tabindex="1" name="email" autofocus="autofocus" autocorrect="off" autocapitalize="off">
					<label for="login_field"> <@spring.message "username"/> </label>
					<input id="username" class="input-block" type="text" tabindex="2" name="username" autofocus="autofocus" autocorrect="off" autocapitalize="off">
					<label for="password">
						<@spring.message "password"/>
					</label>
					<input id="password" class="input-block" type="password" tabindex="3" name="password">
					<label for="password">
						<@spring.message "re_password"/>
					</label>
					<input id="rePassword" class="input-block" type="password" tabindex="4" name="rePassword">
					<input class="btn" type="submit" value="<@spring.message "register"/>" tabindex="5" name="commit" data-disable-with="<@spring.message "register"/>..." onclick="return buttonSubmit(this);">
				</div>
			</form>
			<script>
				buttonAbled();
			</script>
		</div>
	</div>
</div>
<#--
<script type="text/javascript">
		$(function(){
		$('#email').focus();
		$('#email').focus(function(){
		if ($(this).val() == "")
		{
		$('#input_mail_tip').removeClass('hidden');
		}
		$(this).parent().find('img').remove();
		});
		$('#email').blur(function(){
		$('#input_mail_tip').addClass('hidden');
		if(validate_email_input($(this).val()) == true && $(this).val() != "")
		{
		$(this).after('<img class="n_sucess_pic" src="/images/lg/successB.gif">');
		}
		});
		$('#uid').focus(function(){
		$('#input_uid_tip').removeClass('hidden');
		$(this).parent().find('img').remove();
		});
		$('#uid').blur(function(){
		$('#input_uid_tip').addClass('hidden');
		$(this).parent().find('img').remove();
		});
		$('#pass1').focus(function(){
		$('#input_password_tip').removeClass('hidden');
		$(this).parent().find('img').remove();
		$('#input_password_err').addClass('hidden');
		});
		$('#pass1_c').focus(function(){
		$('#input_repassword_tip').removeClass('hidden');
		$(this).parent().find('img').remove();
		$('#input_repassword_err').addClass('hidden');
		});
		$('#pass1').blur(function(){
		var v = $(this).val();
		var email = $("#email").val();
		var uid = $("#uid").val();
		var digital_conditions = /^\d{6,}$/;
		var flag_digital = digital_conditions.test(v);
		var letter_conditions = /^[a-zA-Z]{6,}$/;
		var flag_letter = letter_conditions.test(v);
		var flag_email = v == email;
		var flag_uid = v == uid;
		var firstWord = v.charAt(0);
		var flag_sameWord = (v.split(firstWord).length-1) == v.length;
		var flag = flag_email || flag_uid || flag_digital || flag_letter || flag_sameWord ;
		if(v.length >= 6 && !flag )
		{
		$(this).after('<img class="n_sucess_pic" src="/images/lg/successB.gif">');
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').addClass('hidden');
		}
		else if(v.length >= 6 && flag_letter)
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate_letter" />");
		}
		else if(v.length >= 6 && flag_digital)
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate_digital" />");
		}
		else if(v.length >= 6 && flag_sameWord)
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate_sameWord" />");
		}
		else if(v.length >= 6 && flag_email)
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate_email" />");
		}
		else if(v.length >= 6 && flag_uid)
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate_uid" />");
		}
		else
		{
		$('#input_password_tip').addClass('hidden');
		$('#input_password_err').removeClass('hidden');
		$('#input_password_err div:eq(1)').text("<@spring.message "password_validate" />");
		}
		});
		$('#pass1_c').blur(function(){
		var v = $(this).val();
		var v2 = $('#pass1').val();
		if(v.length == 0)
		{
		$('#input_repassword_tip').addClass('hidden');
		$('#input_repassword_err').removeClass('hidden');
		$('#input_repassword_err div:eq(1)').text("<@spring.message "input_password_again" />");
		}
		else if(v == v2 && v.length >= 6)
		{
		$(this).after('<img class="n_sucess_pic" src="/images/lg/successB.gif">');
		$('#input_repassword_tip').addClass('hidden');
		$('#input_repassword_err').addClass('hidden');
		}
		else
		{
		$('#input_repassword_tip').addClass('hidden');
		$('#input_repassword_err').removeClass('hidden');
		$('#input_repassword_err div:eq(1)').text("<@spring.message "input_password_different" />");
		}
		});
		});
		</script>
<div id="input_password_tip" class="n_fieldtips hidden" style="z-index:199">
		<div style="position:relative">
		<div class="n_fieldTipsMsg"><@spring.message "password_validate" /></div>
		</div>
		</div>
		<div id="input_password_err" class="n_fieldtips hidden" style="top:0; left:400px; z-index:199">
		<div style="position:relative">
		<div style="color:#DD4B39; white-space:nowrap;background:#fdf0f7;line-height:25px;padding:0px 10px;box-shadow:1px 1px 3px #cccccc;"><@spring.message "password_validate" /></div>
		</div>
		</div>
		.n_fieldtips {
    float: left;
    left: 0;
    margin-left: 360px;
    margin-top: -60px;
    position: relative;
    top: 0;
}

.n_fieldTipsMsg, .n_fieldErrorMsg {
    left: 0;
}
.n_fieldTipsMsg, .n_fieldErrorMsg {
    background: url("/chinese/images/lg/sc0906231_12.gif") no-repeat scroll 2px 3px #fbf8e9;
    border: 1px solid #fec600;
    color: #666666;
    left: 11px;
    line-height: 19px;
    padding: 1px 1px 1px 25px;
    position: absolute;
    top: 0;
    width: 290px;
}
<img class="n_sucess_pic" src="/chinese/images/lg/successB.gif">
<div id="main">
<div class="container clearfix">
<div class="row">
	<div class="fourcol content">
    <h1>绿化树</h1>
    <p>绿化树是一个致力于调度社会闲散资源的开放性平台。</p>
    <h2>公益:</h2>
    <ul>
    	<li>网站所有收入向用户透明，并将全部用于公益事业</li>
    </ul>
    <h2>快乐:</h2>
    <ul>
    	<li>快乐:您的随手之劳，可能会给别人带来巨大的帮助</li>
    </ul>
    <h2>赚钱:</h2>
    <ul>
    	<li>整天刷微博美剧朋友圈？空闲时间也能拿来挣钱</li>
    	<li>您花费的每一分钟，都会给您带来相应的价值</li>
    </ul>
  </div>
	<div class="eightcol last">
	<form method="post" action="${controlDomain}/register.do" id="my-form" name="my-form">
	<div>
				<h2>注册:</h2>
			</div>
			<div><input id="accountId" name="accountId" type="text" placeholder="手机/邮箱"/></div>
			<div><input id="password" name="password" type="password" placeholder="密码"/></div>
			<div><input id="passwordcopy" name="passwordcopy" type="password" placeholder="再输入一遍密码"/></div>
			<div>
			<button type="submit">注册</button>
			</div>
	</form>
	</div>
</div>
</div>
</div>
	<script>
	  var options = {
	    onFail: function() {
	    },
	    inputs: {
	      'password': {
	        filters: 'required pass',
	      },
	      'accountId': {
	        filters: 'required username ajax',
	        data: {
	          ajax: { url:'${controlDomain}/ajax.do' },
	          method: 'validateAccountIdExist'
	        }
	      },
	      'passwordcopy': {
	        filters: 'required pass copy',
	        data: {
	        	copy: 'password'
	        }
	      }
	    }
	  };
	  var $myform = $('#my-form').idealforms(options).data('idealforms');
	  $myform.focusFirst();
	</script>
-->
</@page.html>