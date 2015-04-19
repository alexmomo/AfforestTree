<@page.html> 
<script>
	
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
					<label for="login_field"> <@spring.message "email"/> </label>
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
<div id="main">
<div class="container clearfix">
<div class="row">
	<div class="fourcol content">
    <h1>�̻���</h1>
    <p>�̻�����һ�������ڵ��������ɢ��Դ�Ŀ�����ƽ̨��</p>
    <h2>����:</h2>
    <ul>
    	<li>��վ�����������û�͸��������ȫ�����ڹ�����ҵ</li>
    </ul>
    <h2>����:</h2>
    <ul>
    	<li>����:��������֮�ͣ����ܻ�����˴����޴�İ���</li>
    </ul>
    <h2>׬Ǯ:</h2>
    <ul>
    	<li>����ˢ΢����������Ȧ������ʱ��Ҳ��������Ǯ</li>
    	<li>�����ѵ�ÿһ���ӣ��������������Ӧ�ļ�ֵ</li>
    </ul>
  </div>
	<div class="eightcol last">
	<form method="post" action="${controlDomain}/register.do" id="my-form" name="my-form">
	<div>
				<h2>ע��:</h2>
			</div>
			<div><input id="accountId" name="accountId" type="text" placeholder="�ֻ�/����"/></div>
			<div><input id="password" name="password" type="password" placeholder="����"/></div>
			<div><input id="passwordcopy" name="passwordcopy" type="password" placeholder="������һ������"/></div>
			<div>
			<button type="submit">ע��</button>
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