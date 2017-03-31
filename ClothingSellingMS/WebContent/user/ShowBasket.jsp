<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
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
				<td data-flag="id">${basket.id }</td> 
				<td>${basket.product.name }</td> 
				<td>${basket.size }</td> 
				<td>${basket.product.price }</td> 
				<td>${basket.amount }</td> 
				<td>${basket.sum }</td>  
				<td><input type="button" name="edit_basket" value="edit" class="button gray larrow" data-toggle="modal" data-target="#editBasketModal" data-price="120"  data-product="1" data-basket="${basket.id }" data-amount="${basket.amount }" data-size="${basket.size }"/></td>
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
    
    <div class="modal fade" id="editBasketModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
	      </div>
	      <div class="modal-body">
	        <form id="editBasketForm" action="editBasket">
	          <div class="form-group">
	            <label for="basketId" class="control-label">basketId:</label>
	            <input type="text" class="form-control" id="basketId" name="basketId" readonly="readonly">
	          </div>
	          <div class="form-group">
	            <label for="productId" class="control-label">productId:</label>
	            <input type="text" class="form-control" id="productId" name="productId" readonly="readonly">
	          </div>
	          <div class="form-group">
	            <label for="price" class="control-label">price:</label>
	            <input type="text" class="form-control" id="price" name="price" readonly="readonly">
	          </div>
	          <div class="form-group">
	            <label for="amount" class="control-label">amount:</label>
	            <input type="text" class="form-control" id="amount" name="amount" onchange="hehe()">
	          </div>
	          <div class="form-group">
	            <label for="size" class="control-label">size:</label>
	            <input type="text" class="form-control" id="size" name="size">
	          </div>
	          <div class="form-group">
	            <label for="sum" class="control-label">sum:</label>
	            <input type="text" class="form-control" id="sum" name="sum" readonly="readonly">
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="editBasket_confirm">Save</button>
	      </div>
	    </div>
	  </div>
	</div>
    
    <script>
    	//全选
    	$('.selectAll').click(function (e) {
    		if ($(this).is(":checked"))
    			$("input[type='checkbox']").prop("checked",true);
    		else 
    			$("input[type='checkbox']").prop("checked", false); 
    	})
    	
    	$('#button_buy').click(function (e) {
    		
    		var productSelected = $("input[class='selectOne']:checkbox:checked")
    		
    		var productSelectedStr = '' ;
    		
    		for (var i = 0 ; i < productSelected.length ; i ++) {
    			var str = $(productSelected[i]).parent().siblings("td[data-flag='id']").text() ;
    			
    			productSelectedStr += (str + ',') ;
    		}
    		
    		console.log(productSelectedStr + '被选中')
    		
    		if (productSelectedStr != '') {
    			window.location.href = "userNewOrder?item=" + productSelectedStr 
    		} else {
    			alert('最少选择一个')
    		}
    		
    	})
    	
    	//模态框的操作
    	$('#editBasketModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var price = button.data('price') // Extract info from data-* attributes
		  var productId = button.data('product')
		  var basketId = button.data('basket')
		  var amount = button.data('amount')
		  var size = button.data('size')
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('EDIT THE BASKET')
		  modal.find('#price').val(price)
		  modal.find('#productId').val(productId)
		  modal.find('#basketId').val(basketId)
		  modal.find('#amount').val(amount)
		  modal.find('#size').val(size)
		  
		  var sum = $('#price').val() * $('#amount').val()
		  $('#sum').val(sum)
// 		  modal.find('.modal-body input').val(recipient)
		})
		
		function hehe() {
			var sum = $('#price').val() * $('#amount').val()
			
			$('#sum').val(sum)
			
			console.log(sum)
		}
		
		$('#editBasket_confirm').click(function (e) {
			$('#editBasketForm').submit()
		})
    </script>
  </body>
</html>
