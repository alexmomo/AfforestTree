<@page.html> 
<div class="site clearfix" role="main">
	<div id="site-container" class="context-loader-container" data-pjax-container="">
		<div class="container">
			<div class="columns">
				<@form_page.page_setting_left selectedLink="profile"/>
				<div class="column three-fourths">
					<div class="boxed-group">
						<h3>Public profile</h3>
						<div class="boxed-group-inner clearfix">
						<form id="profile_9276604" class="columns js-uploadable-container js-upload-avatar-image is-default" method="post" data-upload-policy-url="/upload/policies/avatars" action="setting/profile.do" accept-charset="UTF-8">
							<div class="column two-thirds">
							<dl class="form">
							<dt>
							<label for="user_profile_name"><@spring.message "username"/></label>
							</dt>
							<dd>
							<input id="username" type="text" value="${profile.username}" size="30" name="username">
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_name"><@spring.message "Sex"/></label>
							</dt>
							<dd>
							<select id="sex" name="sex">
								<option value=0><@spring.message "unknown"/></option>
								<option value=1 <#if profile.sex == 1>selected="selected"</#if>><@spring.message "man"/></option>
								<option value=2 <#if profile.sex == 2>selected="selected"</#if>><@spring.message "women"/></option>
							</select>
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_location"><@spring.message "Location"/></label>
							</dt>
							<dd>
							<script type="text/javascript" src="${basePath}js/city_map.js" charset="gbk"></script>
							<select id="province" name="province" onchange="changeCity('province','city','region',1,'${profile.defaultArea}');">
							</select>
							<select id="city" name="city" onchange="changeCity('province','city','region',2,'${profile.defaultArea}');">
							</select>
							<select id="region" name="region">
							</select>
							<script type="text/javascript">
								changeCity('province','city','region',0,'${profile.defaultArea}');
							</script>
							<p class="note">
							<@spring.message "profile_location_note"/>
							</p>
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_name"><@spring.message "real_name"/></label>
							</dt>
							<dd>
							<input id="realName" type="text" value="${profile.realName}" size="30" name="realName">
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_name"><@spring.message "id_card"/></label>
							</dt>
							<dd>
							<input id="idCard" type="text" value="${profile.idCard}" size="30" name="idCard">
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_name"><@spring.message "zhifubao"/></label>
							</dt>
							<dd>
							<input id="zhifubao" type="text" value="${profile.zhifubao}" size="30" name="zhifubao">
							</dd>
							</dl>
							<p>
							<button class="btn btn-primary" type="submit">Update profile</button>
							</p>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</@page.html>