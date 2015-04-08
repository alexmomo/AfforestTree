<#macro page_header afAccount>
	<header>
		<div class="container clearfix">
			<div class="row">
				<div class="fourcol">
					<h1 id="title">
						<@spring.message "website_name"/>
					</h1>
				</div>
				<div class="fourcol">
				</div>
				<div class="twocol">
					<#if afAccount?exists>
						<h1 id="titleright">
							<@spring.message "welcome"/><@spring.message "you"/><@spring.message "comma"/><a>${afAccount.username}</a>
						</h1>
					</#if>
				</div>
				<div class="twocol last">
					<h1 id="titleright">
						<#if afAccount?exists>
							<a onclick="javascript:window.location.href='login.shtml';">
								<@spring.message "login"/>
							</a>
						<#else>
							<a onclick="javascript:window.location.href='logout.do';">
								<@spring.message "logout"/>
							</a>
						</#if>
						&nbsp;&nbsp;<@spring.message "help"/>&nbsp;&nbsp;
						<a onclick="javascript:window.location.href='index.html';">
							<@spring.message "back_main"/>
						</a>
					</h1>
				</div>
			</div>
		</div>
	</header>
</#macro>