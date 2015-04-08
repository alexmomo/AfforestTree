<@page.html> 
<div id="main">
<div class="container clearfix">
<div class="row">
<div class="sixcol content">
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
 	<div class="sixcol last">
		<form method="post" action="${basePath}/login.do" id="my-form" name="my-form">
		<input type="hidden" id="token" name="token" value="${token}">
			<div>
				<h2>登录:</h2>
				<#if errorMsg?exists><p><font color="red">(${errorMsg})</font></p></#if>
			</div>
			<div><input id="accountId" name="accountId" type="text" placeholder="注册手机/邮箱"/></div>
			<div><input id="pass" name="password" type="password" placeholder="密码"/></div>
			<div>
			<button type="submit">登录</button>
			</div>
			<div>
				<h2></h2>
				<ul>
		    	<li><a href="${controlDomain}/forgot_password.shtml">忘记密码?</a></li>
		    	<li><a href="${controlDomain}/register.shtml">免费注册</a></li>
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