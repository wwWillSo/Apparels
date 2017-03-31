<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Sign Up</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="css/basicGrey.css" />

  </head>
  <script language="javascript">
	function isEmpty() {
		if (document.getElementById("userid").value=="") {
			document.getElementById("userId").innerHTML = "<div id='warning'>用户id不能为空！</div>" ;
		}
		if (document.getElementById("nickname").value=="") {
			document.getElementById("nickName").innerHTML = "<div id='warning'>用户昵称不能为空！</div>" ;
		}
		if (document.getElementById("password").value=="") {
			document.getElementById("passWord").innerHTML = "<div id='warning'>用户密码不能为空！</div>" ;
		}
	}
</script>
  <body>
  	<form action="user/signUp" method="post" class="basic-grey">
	<h1>SIGN UP
	<span>Please fill all the texts in the fields.</span>
	</h1>
	<label>
	<span>User Name :</span>
	<input id="user_name" type="text" name="name" placeholder="Your User Name" onblur="isEmpty();" />
	</label>
	<label>
	<span>Your Password :</span>
	<input id="password1" type="password" name="password" placeholder="Your Password" />
	</label>
	
	<label>
	<span>Confirm Again :</span>
	<input id="password2" type="password" name="password" placeholder="Confirm Again" />
	</label>
	<label>
	<span>Your TEL :</span>
	<input id="name" type="text" name="TEL" placeholder="Your TEL Number" />
	</label>
	<label>
	<span>Your Email :</span>
	<input id="email" type="email" name="email" placeholder="Valid Email Address" />
	</label>
	<label>
	<span>Your ZIP :</span>
	<input id="ZIP" type="text" name="ZIP" placeholder="Your ZIP CODE" />
	</label>
	<label>
	<span>Upload Avatars</span><input type="file" name="avatars" id="portrait"/>
	</label>
	<br/><br/>
	<label>
	<span>&nbsp;</span>
	<button type="submit" id="signup" class="button" >Sign</button>
	<button type="reset" id="Sreset" class="button">Reset</button>
	<button type="button" id="Scancel" class="button" onclick="webpage/location='../webpage/navigation.html'">Cancel</button>
	</label>
	</form>
  </body>
</html>
