<@page.html> 
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