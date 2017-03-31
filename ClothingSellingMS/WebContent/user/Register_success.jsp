<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SUCCEED!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" href="css/demo.css"/>
    <link rel="stylesheet" href="css/frozen.css"/>
    <link rel="stylesheet" href="css/button.css"/>
	<link rel="stylesheet" type="text/css" href="css/navigation.css"/>
	<link rel="stylesheet" type="text/css" href="css/search.css"/>
	<link rel="stylesheet" type="text/css" href="css/buttons.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <section id="notice">
    <div class="demo-item">
        <p class="demo-desc"></p>
        <div class="demo-block">
            <section class="ui-notice">
                <li><img src="images/BB2271.jpg/"/></li>
                <p>Registration Successful</p>
                <div class="ui-notice-btn">
                    <button class="ui-btn-primary ui-btn-lg">MORE PRODUCT FOR YOU!</button>
                </div>
            </section>
        </div>
    </div>
</section>
  </body>
</html>
