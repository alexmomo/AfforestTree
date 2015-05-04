<@page.html> 
<script type="text/javascript">
	var checkArray = ['email','username','password','rePassword'];
	$(function(){
		for(var i = 0;i<checkArray.length;i++){
			$('#'+checkArray[i]).focus(function(){
				checkForm($(this));
			});
			$('#'+checkArray[i]).blur(function(){
				checkForm($(this));
			});
		}
	});
	
	function submitRegister(obj){
		for(var i = 0;i<checkArray.length;i++){
			if(!$('#'+checkArray[i]+'_ideal_icon').hasClass('ideal-icon-valid')){
				$('#'+checkArray[i]).focus();
				return false;
			}
		}
		buttonSubmit(obj);
	}
</script>
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
					<label for="login_field"> <@spring.message "email"/></label>
					<table>
						<tr>
							<td width="95%">
								<input id="email" class="input-block" type="text" tabindex="1" name="email" autofocus="autofocus" autocorrect="off" autocapitalize="off" data-ajax-method="emailValidateExist">
							</td>
							<td>
								<i id="email_ideal_icon" class="ideal-icon ideal-icon-invalid" style="display: block"></i>
							</td>
						</tr>
					</table>
					<div id="input_email_tip" class="n_fieldtips hidden" style="z-index:199">
						<div id="input_email_error" class="ideal_error"></div>
					</div>
					<label for="login_field"> <@spring.message "username"/></label>
					<table>
						<tr>
							<td width="95%">
								<input id="username" class="input-block" type="text" tabindex="2" name="username" autofocus="autofocus" autocorrect="off" autocapitalize="off" data-ajax-method="usernameValidateExist">
							</td>
							<td>
								<i id="username_ideal_icon" class="ideal-icon ideal-icon-invalid" style="display: block"></i>
							</td>
						</tr>
					</table>
					<div id="input_username_tip" class="n_fieldtips hidden" style="z-index:199">
						<div id="input_username_error" class="ideal_error"></div>
					</div>
					<label for="password">
						<@spring.message "password"/>
					</label>
					<table>
						<tr>
							<td width="95%">
								<input id="password" class="input-block" type="password" tabindex="3" name="password">
							</td>
							<td>
								<i id="password_ideal_icon" class="ideal-icon ideal-icon-invalid" style="display: block"></i>
							</td>
						</tr>
					</table>
					<div id="input_password_tip" class="n_fieldtips hidden" style="z-index:199">
						<div id="input_password_error" class="ideal_error"></div>
					</div>
					<label for="password">
						<@spring.message "re_password"/>
					</label>
					<table>
						<tr>
							<td width="95%">
								<input id="rePassword" class="input-block" type="password" tabindex="4" name="rePassword" data-copy-with="password">
							</td>
							<td>
								<i id="rePassword_ideal_icon" class="ideal-icon ideal-icon-invalid" style="display: block"></i>
							</td>
						</tr>
					</table>
					<div id="input_rePassword_tip" class="n_fieldtips hidden" style="z-index:199">
						<div id="input_rePassword_error" class="ideal_error"></div>
					</div>
					<input class="btn" type="submit" value="<@spring.message "register"/>" tabindex="5" name="commit" data-disable-with="<@spring.message "register"/>..." onclick="return submitRegister(this);">
				</div>
			</form>
			<script>
				buttonAbled();
			</script>
		</div>
	</div>
</div>
</@page.html>