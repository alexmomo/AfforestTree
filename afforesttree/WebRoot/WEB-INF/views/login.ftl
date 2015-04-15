<@page.html> 
<div class="site clearfix" role="main">
	<div id="site-container" class="context-loader-container" data-pjax-container="">
		<div id="login" class="auth-form">
			<form method="post" action="login.do" accept-charset="UTF-8">
				<div style="margin:0;padding:0;display:inline">
					<input type="hidden" id="token" name="token" value="${token}">
				</div>
				<div class="auth-form-header">
					<h1>Sign in</h1>
				</div>
				<div class="auth-form-body">
					<label for="login_field"> Username or Email </label>
					<input id="accountId" class="input-block" type="text" tabindex="1" name="accountId" autofocus="autofocus" autocorrect="off" autocapitalize="off">
					<label for="password">
						Password
						<a href="forgot_password.shtml">(forgot password)</a>
					</label>
					<input id="password" class="input-block" type="password" tabindex="2" name="password">
					<input class="btn" type="submit" value="Sign in" tabindex="3" name="commit" data-disable-with="Signing in¡­" onclick="return buttonSubmit(this);">
				</div>
			</form>
			<script>
			buttonAbled();
		</script>
		</div>
	</div>
</div>
</@page.html>