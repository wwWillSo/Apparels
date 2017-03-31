<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Product List</title>
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../css/demo.css"/>
    <link rel="stylesheet" href="../css/frozen.css"/>
    <link rel="stylesheet" href="../css/button.css"/>
	<link rel="stylesheet" type="text/css" href="../css/navigation.css"/>
	<link rel="stylesheet" type="text/css" href="../css/search.css"/>
	<link rel="stylesheet" type="text/css" href="../css/buttons.css"/>

  </head>
  
	<body >
		<div ><span class="sright">
			<a class="ibtn" href="Home.jsp">HOME</a>
			</span>
			</div>
		<div class="demo-item">
        <p class="demo-desc">Product List</p>
        
        <c:forEach items="${productlist}" var="product">
        <div class="demo-block">
            <ul class="ui-list ui-list-one ui-list-link ui-border-tb">
                <li class="ui-border-t">
                    <div class="ui-list-thumb">
                        <span style="background-image:url(images/BB2271.jpg)"></span>
                    </div>
                    <div class="ui-list-info">
                    	<h4 class="ui-nowrap">NO:${product.id }</h4>
                        <h4 class="ui-nowrap">TYPE:${product.type }</h4>
                        <h4 class="ui-nowrap">NAME:${product.name }</h4>
                        <h4 class="ui-nowrap">SIZE:${product.size }</h4>
                        <h4 class="ui-nowrap">PRICE:$${product. price}</h4>
                        <h4 class="ui-nowrap">AMOUNT:${product.amount }</h4>
                    
                        <form id="edit" name="edit" method="post" action="http://www.baidu.com">
							<input name="edit" type="image" value="" class="ui-list-thumb-s" src="images/edit.jpg" title="edit"/>
						</form>
                  	</div>
                </li>
			</ul>
		</div>
		</c:forEach>
	</div>
	<div class="ui-center">
		<form id="add" name="add" method="post" action="AddProduct.jsp">
			<input name="add" type="image" value="" class="ui-list-thumb-s" src="images/add.png" title="add"/>
		</form>
		<h3>Add Product</h3>
	</div>
	</body>
</html>
