<html>
<head>
	<meta charset="utf-8">
	<title>Demo平台</title>
    <link rel="stylesheet" href="../static/plugin/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../static/plugin/login/login.css" media="all" />
</head>
<body>
	<video class="video-player" preload="auto" muted autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="100%">
		<source src="../static/plugin/login/login2.mp4" type="video/mp4">
		<!-- 此视频文件为支付宝所有，在此仅供样式参考，如用到商业用途，请自行更换为其他视频或图片，
		否则造成的任何问题使用者本人承担，谢谢 -->
	</video>
<div class="video_mask"></div>

	<div class="login">
	    <h1>管理登录</h1>
	    <form class="layui-form">
	    	<div class="layui-form-item">
				<input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>

		    	<#--<div class="layui-form-item form_code">
				<input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" 	 								autocomplete="off">
                <div class="code">
                    <img src="" id="code"  width="116" height="36">
                </div>
		    	</div>-->

			<button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		</form>
	</div>

    <script type="text/javascript" src="../static/plugin/layui/layui.js"></script>
    <script type="text/javascript" src="../static/plugin/login/login.js"></script>

</body>
</html>