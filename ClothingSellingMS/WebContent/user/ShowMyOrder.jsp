<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>All my orders</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/demo.css"/>
    <link rel="stylesheet" href="css/frozen.css"/>
	<link rel="stylesheet" type="text/css" href="css/navigation.css"/>
	<link rel="stylesheet" type="text/css" href="css/search.css"/>
	<link rel="stylesheet" type="text/css" href="css/buttons.css"/>
	<link rel="stylesheet" type="text/css" href="css/buttonb.css"/>
	<link rel="stylesheet" type="text/css" href="css/checkb.css"/>

  </head>
  
  <body bgcolor="#e6e5e5">
    <div ><span class="sright">
			<a class="ibtn" href="Home.jsp">HOME</a>
			</span>
			</div>
			<div class="demo-item">
        <p style="color:#A2CD5A;font-family:Broadway ;font-size:50px;margin-left: 20px">My Order</p>
        </div>
	<table border="0" width="100%" style="margin-left: 30px">
		<tr>
		<td><input type="checkbox" class="squaredFour"></td>
		<td colspan="6"><p style="color: red;font-family:Broadway;font-size: 20px">SELLET ALL</p></td>
		</tr>
		<colgroup> 
        <col width="10%" /> 
        <col width="10%" /> 
        <col width="15%" /> 
        <col width="10%" />
        <col width="10%" /> 
        <col width="10%" />
        <col width="10%" /> 
        <col width="10%" /> 
        <col width="10%" />
    </colgroup> 
		<tr >
			<td>&nbsp;</td>
			<td >Transaction id</td>
			<td >Product's name</td>
			<td >Size</td>
			<td >Price</td>
			<td >Amount</td>
			<td>Total</td>
		</tr>
		<c:forEach items="${basketList}" var="basket">
			<tr> 
			<td> 
			<input type="checkbox" class="squaredFour" /> 
			</td> 
				<td>${order.id }</td>
				<td>${order.product.name }</td>
				<td>${order.size }</td>
				<td>${order.product.price }</td>
				<td>${order.amount }</td>
				<td>${order.sum }</td>
				<td><input type="button" class="ui-btn-wrap ui-btn-s" value="comment" onclick="javascript:window.location.href=''"/></td>
			</tr> 
		</c:forEach>
	</table>
	<div align="right">
 	<button type="button" class="button red" id="button_buy">DELETE</button>       
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
