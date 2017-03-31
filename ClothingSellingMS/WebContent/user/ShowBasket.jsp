<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'ShowBasket.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../css/demo.css"/>
    <link rel="stylesheet" href="../css/frozen.css"/>
	<link rel="stylesheet" type="text/css" href="../css/navigation.css"/>
	<link rel="stylesheet" type="text/css" href="../css/search.css"/>
	<link rel="stylesheet" type="text/css" href="../css/buttons.css"/>
	<link rel="stylesheet" type="text/css" href="../css/buttonb.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>		
  </head>
  
  <body>
<!--    This is my JSP page. <br/> ${adminlist[0].id }<br/> ${admin.name }<br/> ${admin.password }<br/>-->
	<div ><span class="sright">
			<a class="ibtn" href="webpge/navigation.html">HOME</a>
			</span>
			</div>
			<div class="demo-item">
        <p style="color:#A2CD5A;font-family:Broadway ;font-size:50px">My Basket</p>
        </div>
	<table border="0" width="100%" style="margin-left: 30px">
		<tr>
		<td><input type="checkbox" class="selectAll"></td>
		<td colspan="6"><p style="color: red;font-family:Broadway">SELLET ALL</p></td>
		</tr>
		<colgroup> 
        <col width="10%" /> 
        <col width="10%" /> 
        <col width="15%" /> 
        <col width="10%" />
        <col width="10%" /> 
        <col width="10%" /> 
    </colgroup> 
		<tr >
			<td>&nbsp;</td>
			<td >id</td>
			<td >name</td>
			<td >size</td>
			<td >price</td>
			<td >amount</td>
			<td>sum</td>
		</tr>
		
		<c:forEach items="${basketList}" var="basket">
			<tr>
			<td>
			<input type="checkbox" class="selectOne">
			</td>
				<td>${basket.id }</td> 
				<td>${basket.product.name }</td> 
				<td>${basket.size }</td> 
				<td>${basket.product.price }</td> 
				<td>${basket.amount }</td> 
				<td>${basket.sum }</td>  
				<td><input type="button" name="edit_basket" value="edit" class="button gray larrow"/></td>
			</tr>
		</c:forEach>
	</table>
    
    <div class="demo-block">
            <ul class="ui-list ui-list-one ui-list-link ui-border-tb">
                <li class="ui-border-t">
                    <div class="ui-list-thumb-s">
                        <span style="background-image:url(image/total.png)"></span>
                    </div>
                    <div class="ui-list-info">
                    	<h4 class="ui-nowrap" style="color: red;font-family:Broadway">TOTAL COST:${product.id }</h4>
                       <button type="button" class="button red" id="button_buy">BUY NOW</button>
                  	</div>
                </li>
			</ul>
		</div>
    
    <script>
    	$('#button_buy').click(function (e) {
    		
    		var productSelected = '' ;
    		
    		var productList = $('.selectOne') ;
    		
    		for (var i = 0 ; i < productList.length ; i ++) {
    			console.log(productList[i])
    		}
    	})
    </script>
  </body>
</html>
