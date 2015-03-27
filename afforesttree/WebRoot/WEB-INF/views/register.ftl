<@page.html> 
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
</@page.html>