<@page.html> 
<div id="main">
<div class="container clearfix">
<div class="row">
<div class="sixcol content">
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
 	<div class="sixcol last">
		<form method="post" action="${basePath}/login.do" id="my-form" name="my-form">
		<input type="hidden" id="token" name="token" value="${token}">
			<div>
				<h2>��¼:</h2>
				<#if errorMsg?exists><p><font color="red">(${errorMsg})</font></p></#if>
			</div>
			<div><input id="accountId" name="accountId" type="text" placeholder="ע���ֻ�/����"/></div>
			<div><input id="pass" name="password" type="password" placeholder="����"/></div>
			<div>
			<button type="submit">��¼</button>
			</div>
			<div>
				<h2></h2>
				<ul>
		    	<li><a href="${controlDomain}/forgot_password.shtml">��������?</a></li>
		    	<li><a href="${controlDomain}/register.shtml">���ע��</a></li>
		    	</ul>
			</div>
	    </form>
    </div>
</div>
</div>
</div><! -- End Main -->
	<script>
	  var options = {
	    onFail: function() {
	    },
	    inputs: {
	      'password': {
	        filters: 'required pass',
	      },
	      'accountId': {
	        filters: 'required username',
	      }
	    }
	  };
	  var $myform = $('#my-form').idealforms(options).data('idealforms');
	  $myform.focusFirst();
	</script>
</@page.html>