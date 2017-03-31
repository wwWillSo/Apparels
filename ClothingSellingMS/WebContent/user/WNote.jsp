<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
	    
	    <title>Write Message</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" href="plug-in/frozenui-1.3.0/css/frozen.css"/>
		<link rel="stylesheet" href="plug-in/frozenui-1.3.0/css/demo.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=yes">
	
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		<style>
			.center{ 
				width:auto;
				display:table;
				margin-left:auto;
				margin-right:auto;
				
			}
			body{
			background-image:url(img/paper.jpg);
		 	background-repeat:repeat;
			}
			
		</style>
	</head>
  
  <body >
  	<form action="commentController.do?note&openId=${requestScope.snsUserInfo.openId}&nickname=${requestScope.snsUserInfo.nickname}&headImgUrl=${requestScope.snsUserInfo.headImgUrl}" method="post">
	    <font size="6px"><b>廣藥留言板|寫留言</b></font>
		<center>
			<textarea rows="10" cols="50" name="comments" onkeyup="this.value = this.value.slice(0, 200)" onfocus="if(value=='限200字以内'){value=''}"
       onblur="if (value==''){value='限200字以内'}"></textarea>
		</center>
	
		<section id="btn">
			<div class="demo-item">
		        <div class="demo-block"> 
		            <div class="ui-btn-wrap">
		                <button class="ui-btn-lg ui-btn-primary">
		                    	提交
		                </button>
		            </div>
		        </div>
		    </div>
		</section>
	</form>
  </body>
</html>
