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
						<form id="profile_9276604" class="columns js-uploadable-container js-upload-avatar-image is-default" method="post" data-upload-policy-url="/upload/policies/avatars" action="/users/alexmomo" accept-charset="UTF-8">
							<div class="column two-thirds">
							<dl class="form">
							<dt>
							<label for="user_profile_name">Name</label>
							</dt>
							<dd>
							<input id="user_profile_name" type="text" value="Tirion" size="30" name="user[profile_name]">
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_email">Public email</label>
							</dt>
							<dd>
							<select id="user_profile_email" name="user[profile_email]">
							<option value="">Don't show my email address</option>
							<option selected="selected" value="1016921902@qq.com">1016921902@qq.com</option>
							</select>
							<p class="note">
							You can add or remove email addresses in your
							<a href="/settings/emails">personal email settings </a>
							.
							</p>
							</dd>
							</dl>
							<dl class="form">
							<dt>
							<label for="user_profile_location">Location</label>
							</dt>
							<dd>
							<input id="user_profile_location" type="text" value="China.ZheJiang.HangZhou" size="30" name="user[profile_location]">
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