<@page.html> 
<script type="text/javascript">

	var ideal_filters = {
    required: {
      regex: /.+/,
      error: $.idealforms.errors.required
    },

    number: {
      regex: function( i, v ) { return !isNaN(v) },
      error: $.idealforms.errors.number
    },

    digits: {
      regex: /^\d+$/,
      error: $.idealforms.errors.digits
    },

    name: {
      regex: /^[A-Za-z]{3,}$/,
      error: $.idealforms.errors.name
    },

    username: {
      regex: /(^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$)|(^((13[0-9])|(14[5,7])|(15[^4,\D])|(18[0-9])|(17[0,6-8]))\d{8}$)/,
      error: $.idealforms.errors.username
    },

    pass: {
      regex: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,32}/,
      error: $.idealforms.errors.pass
    },
    
    rePass: {
      regex: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,32}/,
      error: $.idealforms.errors.rePass
    },

    strongpass: {
      regex: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
      error: $.idealforms.errors.strongpass
    },

    email: {
      regex: /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
      error: $.idealforms.errors.email
    },

    phone: {
      regex: /^((13[0-9])|(14[5,7])|(15[^4,\D])|(18[0-9])|(17[0,6-8]))\d{8}$/,
      error: $.idealforms.errors.phone
    },

    zip: {
      regex: /^\d{5}$|^\d{5}-\d{4}$/,
      error: $.idealforms.errors.zip
    },

    url: {
      regex: /^(?:(ftp|http|https):\/\/)?(?:[\w\-]+\.)+[a-z]{2,6}([\:\/?#].*)?$/i,
      error: $.idealforms.errors.url
    },
    
    copy: {
      regex: function( input, value){
    		var copyId="#"+input;
    		var copyValue=$(copyId).val();
    		if(copyValue ==  value){
    			return true;
    		}
    		return false;
    	}
    },

    min: {
      regex: function( input, value ) {
        var $input = input.input,
            min = input.userOptions.data.min,
            isRadioCheck = $input.is('[type="checkbox"], [type="radio"]')
        if ( isRadioCheck ) {
          this.error = $.idealforms.errors.minOption.replace( '{0}', min )
          return $input.filter(':checked').length >= min
        }
        this.error = $.idealforms.errors.minChar.replace( '{0}', min )
        return value.length >= min
      }
    },

    max: {
      regex: function( input, value ) {
        var $input = input.input,
            max = input.userOptions.data.max,
            isRadioCheck = $input.is('[type="checkbox"], [type="radio"]')
        if ( isRadioCheck ) {
          this.error = $.idealforms.errors.maxOption.replace( '{0}', max )
          return $input.filter(':checked').length <= max
        }
        this.error = $.idealforms.errors.maxChar.replace( '{0}', max )
        return value.length <= max
      }
    },

    range: {
      regex: function( input, value ) {
        var range = input.userOptions.data.range,
            val = +value
        this.error = $.idealforms.errors.range
          .replace( '{0}', range[0] )
          .replace( '{1}', range[1] )
        return val >= range[0] && val <= range[1]
      }
    },

    date: {
      regex: function( input, value ) {
        var

        userFormat =
          input.userOptions.data && input.userOptions.data.date
            ? input.userOptions.data.date
            : 'mm/dd/yyyy', // default format

        delimiter = /[^mdy]/.exec( userFormat )[0],
        theFormat = userFormat.split(delimiter),
        theDate = value.split(delimiter),

        isDate = function( date, format ) {
          var m, d, y
          for ( var i = 0, len = format.length; i < len; i++ ) {
            if ( /m/.test( format[i]) ) m = date[i]
            if ( /d/.test( format[i]) ) d = date[i]
            if ( /y/.test( format[i]) ) y = date[i]
          }
          return (
            m > 0 && m < 13 &&
            y && y.length === 4 &&
            d > 0 && d <= ( new Date( y, m, 0 ) ).getDate()
          )
        }

        this.error = $.idealforms.errors.date.replace( '{0}', userFormat )

        return isDate( theDate, theFormat )
      }
    },

    dob: {
      regex: function( input, value ) {
        var

        userFormat =
          input.userOptions.data && input.userOptions.data.dob
            ? input.userOptions.data.dob
            : 'mm/dd/yyyy', // default format

        // Simulate a date input
        dateInput = {
          input: input.input,
          userOptions: {
            data: { date: userFormat }
          }
        },

        // Use internal date filter to validate the date
        isDate = filters.date.regex( dateInput, value ),

        // DOB
        theYear = /\d{4}/.exec( value ),
        maxYear = new Date().getFullYear(), // Current year
        minYear = maxYear - 100

        this.error = $.idealforms.errors.dob

        return isDate && theYear >= minYear && theYear <= maxYear
      }
    },

    exclude: {
      regex: function( input, value ) {
        var $input = input.input,
            exclude = input.userOptions.data.exclude,
            isOption = $input.is('[type="checkbox"], [type="radio"], select')
        this.error = isOption
          ? $.idealforms.errors.excludeOption.replace( '{0}', value )
          : this.error = $.idealforms.errors.exclude.replace( '{0}', value )
        return $.inArray( value, exclude ) === -1
      }
    },

    equalto: {
      regex: function( input, value ) {
        var $equals = $( input.userOptions.data.equalto ),
            $input = input.input,
            name = $equals.attr('name') || $equals.attr('id'),
            isValid = $equals.parents('.ideal-field')
              .filter(function(){ return $(this).data('ideal-isvalid') === true })
              .length
        if ( !isValid ) { return false }
        this.error = $.idealforms.errors.equalto.replace( '{0}', name )
        return $input.val() === $equals.val()
      }
    },

    extension: {
      regex: function( input, value ) {
        var files = input.input[0].files || [{ name: value }],
            extensions = input.userOptions.data.extension,
            re = new RegExp( '\\.'+ extensions.join('|') +'$', 'i' ),
            valid = false
        for ( var i = 0, len = files.length; i < len; i++ ) {
          valid = re.test( files[i].name );
        }
        this.error = $.idealforms.errors.extension.replace( '{0}', extensions.join('", "') )
        return valid
      }
    },

    ajax: {
      regex: function( input, value, showOrHideError ) {
        var self = this
        var $input = input.input
        var userOptions = input.userOptions
        var name = $input.attr('name')
        var $field = $input.parents('.ideal-field')
        var valid = false
        var method = input.userOptions.data.method;
        var customErrors = userOptions.errors && userOptions.errors.ajax
        self.error = {}
        self.error.success = customErrors && customErrors.success
          ? customErrors.success
          : $.idealforms.errors.ajaxSuccess.replace( '{0}', value )
        self.error.fail = customErrors && customErrors.error
          ? customErrors.error
          : $.idealforms.errors.ajaxError

        // Send input name as $_POST[name]
        var data = {}
        data[ name ] = $.trim( value )
        data[ 'method'] = method;
        // Ajax options defined by the user
        var userAjaxOps = input.userOptions.data.ajax
        var ajaxOps = {
          type: 'post',
          dataType: 'json',
          data: data,
          success: function( resp, text, xhr ) {
          console.log(resp)
          	if(resp == 'false'){
	            showOrHideError( self.error.success, true )
	            $input.data({
	              'ideal-ajax-resp': resp,
	              'ideal-ajax-error': self.error.success
	            })
	            $input.trigger('change') // to update counter
	            $field.removeClass('ajax')
	            // Run custom success callback
	            if( userAjaxOps._success ) {
	              userAjaxOps._success( resp, text, xhr )
	            }
            }else{
            	showOrHideError( self.error.success, false )
                $input.data( 'ideal-ajax-error', self.error.success )
                $field.removeClass('ajax')
                // Run custom error callback
                if ( userAjaxOps._success ) {
                  userAjaxOps._error( xhr, text, error )
                }
            }
          },
          error: function( xhr, text, error ) {
            if ( text !== 'abort' ) {
              showOrHideError( self.error.fail, false )
              $input.data( 'ideal-ajax-error', self.error.fail )
              $field.removeClass('ajax')
              // Run custom error callback
              if ( userAjaxOps._error ) {
                userAjaxOps._error( xhr, text, error )
              }
            }
          }
        }
        $.extend( ajaxOps, userAjaxOps )
        // Init
        $input.removeData('ideal-ajax-error')
        $input.removeData('ideal-ajax-resp')
        $field.addClass('ajax')
        // Run request and save it to be able to abort it
        // so requests don't bubble
        $.idealforms.ajaxRequests[ name ] = $.ajax( ajaxOps )
      }
    }
  }
	$(function(){
		$('#email').focus(function(){
			checkForm($(this));
		});
		$('#email').blur(function(){
			checkForm($(this));
		});
		$('#username').focus(function(){
			checkForm($(this));
		});
		$('#username').blur(function(){
			checkForm($(this));
		});
		$('#password').focus(function(){
			checkForm($(this));
		});
		$('#password').blur(function(){
			checkForm($(this));
		});
		$('#rePassword').focus(function(){
			checkForm($(this));
		});
		$('#rePassword').blur(function(){
			checkForm($(this));
		});
	});
	function checkForm(obj){
		var objId = obj.attr("id");
		var regex_content;
		var error_content;
		if(objId == 'email'){
			regex_content = ideal_filters.email.regex;
			error_content = ideal_filters.email.error;
		}else if(objId == 'username'){
			regex_content = ideal_filters.username.regex;
			error_content = ideal_filters.username.error;
		}else if(objId == 'password'){
			regex_content = ideal_filters.pass.regex;
			error_content = ideal_filters.pass.error;
		}else if(objId == 'rePassword'){
			regex_content = ideal_filters.pass.regex;
			error_content = ideal_filters.pass.error;
		}
		if (obj.val() == ""){
			$('#input_'+objId+'_tip').removeClass('hidden');
			$('#input_'+objId+'_tip div:eq(0)').html(ideal_filters.required.error);
			$('#'+objId+'_ideal_icon').addClass('ideal-icon-invalid');
			$('#'+objId+'_ideal_icon').removeClass('ideal-icon-valid');
		}else if(!regex_content.test(obj.val()) || ((objId == 'rePassword') && !ideal_filters.copy.regex("rePassword" , $("#password").val()))){
			if(((objId == 'rePassword') && !ideal_filters.copy.regex("rePassword" , $("#password").val()))){
				error_content = ideal_filters.rePass.error;
			}
			$('#input_'+objId+'_tip').removeClass('hidden');
			$('#input_'+objId+'_tip div:eq(0)').html(error_content);
			$('#'+objId+'_ideal_icon').addClass('ideal-icon-invalid');
			$('#'+objId+'_ideal_icon').removeClass('ideal-icon-valid');
		}else{
			$('#input_'+objId+'_tip').addClass('hidden');
			$('#'+objId+'_ideal_icon').removeClass('ideal-icon-invalid');
			$('#'+objId+'_ideal_icon').addClass('ideal-icon-valid');
		}
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
								<input id="email" class="input-block" type="text" tabindex="1" name="email" autofocus="autofocus" autocorrect="off" autocapitalize="off">
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
								<input id="username" class="input-block" type="text" tabindex="2" name="username" autofocus="autofocus" autocorrect="off" autocapitalize="off">
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
								<input id="rePassword" class="input-block" type="password" tabindex="4" name="rePassword">
							</td>
							<td>
								<i id="rePassword_ideal_icon" class="ideal-icon ideal-icon-invalid" style="display: block"></i>
							</td>
						</tr>
					</table>
					<div id="input_rePassword_tip" class="n_fieldtips hidden" style="z-index:199">
						<div id="input_rePassword_error" class="ideal_error"></div>
					</div>
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