<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>MyHtml.html</title>
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../css/demo.css"/>
    <link rel="stylesheet" href="../css/frozen.css"/>
    <link rel="stylesheet" href="../css/button.css"/>
	<link rel="stylesheet" type="text/css" href="../css/navigation.css"/>
	<link rel="stylesheet" type="text/css" href="../css/search.css"/>
	<link rel="stylesheet" type="text/css" href="../css/buttons.css"/>
	
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </head>
  
  <body >
  <div style="margin-left: 20px;">
   <font style="font-family:'Oleo Script', cursive ;font-size: 40px;">CUSTOMIZE | originals</font>
  </div>
  <div>
   
  	<form id="home" name="home" method="post" action="../webpage/navigation.html">
	<input type="image" value="home" src="../images/home.png" class="ibtn" title="HOME" />
	</form>	
	<form id="go" name="go" method="post" action="userShowBasket">
	<input type="image" value="search" src="../images/basketBLACK.png" class="ibtn" title="BASKET"/>
	</form>
	<form action="#" method="get"> 
	<input type="text" name="s" class="sinput" placeholder="search" autofocus x-webkit-speech/>  
	</form>	
  </div>
  <br/><br/>
  	<div class="demo-item h-center">
        <div class="demo-block">
            <ul class="ui-grid-trisect ui-border-b">
                <li>
                    <div class="ui-grid-trisect-img">
                        <span style="background-image:url(../images/BB2271.jpg)"></span>
                    </div>
                    <h4>SUPERSTAR BOOST SHOES <span style="font-size: 10px;">WOMEN'S ORIGINALS</span></h4>
                    <button class="ui-btn-s ui-btn-progress">$120</button>
                </li>
                <li>
                    <div class="ui-grid-trisect-img">
                        <span style="background-image:url(../images/BB2294.jpg)"></span>
                    </div>
                    <h4>SUPERSTAR BOUNCE SHOES <span style="font-size: 10px;">WOMEN'S ORIGINALS</span></h4>
                    <button class="ui-btn-s ui-btn-progress">$90</button>
                </li>
                <li>
                    <div class="ui-grid-trisect-img">
                        <span style="background-image:url(../images/S81338.jpg)"></span>
                    </div>
                    <h4>SUPERSTAR SLIP-ON SHOES <span style="font-size: 10px;">WOMEN'S ORIGINALS</span></h4>
                    <button class="ui-btn-s ui-btn-progress">$65</button>
                </li>
                <li>
                    <div class="ui-grid-trisect-img">
                        <span style="background-image:url(../images/C77153.jpg)"></span>
                    </div>
                    <h4>SUPERSTAR SHOES <span style="font-size: 10px;">WOMEN'S ORIGINALS</span></h4>
                    <button class="ui-btn-s ui-btn-progress" data-toggle="modal" data-target="#addToBasketModal" data-price="120" data-product="1">$80</button>
                </li>
            </ul>
        </div>
    </div>
    
    <div class="modal fade" id="addToBasketModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
	      </div>
	      <div class="modal-body">
	        <form id="addToBasketForm" action="addToBasket">
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
	        <button type="button" class="btn btn-primary" id="addToBasket_confirm">Save</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
		$('#addToBasketModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var price = button.data('price') // Extract info from data-* attributes
		  var productId = button.data('product')
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('EDIT THE BASKET')
		  modal.find('#price').val(price)
		  modal.find('#productId').val(productId)
// 		  modal.find('.modal-body input').val(recipient)
		})
		
		function hehe() {
			var sum = $('#price').val() * $('#amount').val()
			
			$('#sum').val(sum)
			
			console.log(sum)
		}
		
		$('#addToBasket_confirm').click(function (e) {
			$('#addToBasketForm').submit()
		})
	</script>
	
    </body>
</html>

