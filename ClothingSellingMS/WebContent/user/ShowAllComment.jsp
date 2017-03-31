<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>All Comments</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=yes">
	<link rel="stylesheet" href="css/demo.css"/>
    <link rel="stylesheet" href="css/frozen.css"/>

  </head>
  
   
  
  <body >
  <div class="demo-block">
            <ul class="ui-list ui-list-one ui-list-link ui-border-tb">
                <li class="ui-border-t">
                    <div class="ui-list-thumb">
                        <span style="background-image:url(images/BB2294.jpg)"></span>
                    </div>
                    <div class="ui-list-info">
                    	
                        <h4 class="ui-nowrap">TYPE:</h4>
                        <h4 class="ui-nowrap">NAME:</h4>
                  	</div>
                </li>
			</ul>
		</div>
  <div class="demo-block">
            <ul class="ui-list ui-list-one ui-list-link ui-border-tb">
                <li class="ui-border-t">
                    <div class="ui-list-thumb">
                        <span style="background-image:url(${product.image})"></span>
                    </div>
                    <div class="ui-list-info">                    	
                        <h4 class="ui-nowrap">TYPE:${product.type }</h4>
                        <h4 class="ui-nowrap">NAME:${product.name }</h4>
                    </div>
                </li>
			</ul>
		</div>
  
	<div class="margin">	
    <div class="demo-item">
        <div class="demo-block">
            <ul class="ui-list ui-border-tb">
                <li class="ui-border-t">
                    <div class="ui-avatar">
                        <span style="background-image:url(images/hair.png)"></span>
                    </div>
                    <div class="ui-list-info">
                        <h4 class="ui-nowrap">Kenny Liu</h4>
                        <p class="ui-nowrap">This girl is on fire!</p>
                    </div>
                </li>
                <li  class="ui-border-t">
                    <div class="ui-avatar">
                        <span  style="background-image:url(images/triangle.jpg)"></span>
                    </div>
                    <div class="ui-list-info">
                        <h4 class="ui-nowrap">Dean Winchester</h4>
                        <p class="ui-nowrap">Masterpiece!</p>
                    </div>
                </li>
                        
                <c:forEach items="${requestScope.notelist}" var="note" >
		                <li class="ui-border-t">
		                    <div class="ui-avatar">
		                        <span style="background-image:url(${note.headimgurl})"></span>
		                    </div>
		                    <div class="ui-list-info">
		                        <h4 class="ui-nowrap">${note.name}</h4>
		                        <p class="ui-nowrap">${note.content}</p>
		                    </div>
		                </li>
		            </c:forEach>
	            </ul>
	        </div>
	    </div>
	</div>
  </body>
</html>
