<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProductInfo.jsp' starting page</title>
    
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
  </head>
  <style>
  .tableS{
  	margin-top: 100px;
  }
  .pname{
  font-size: 28px;
  font-family: Forte;
  }
  .pinfo{
  	position:relative;
	left:20%;
  }
  .ptype{
  font-size: 20px;
  font-family: Candara;
  }
  .pprice{
  text-align:center;
  font-size: 25px;
  font-family:Broadway;
  color: red;
  }
  .psa{
  font-family:Candara;
  color: #3d85c6;
  }
  </style>
  <body bgcolor="#f1f1f1">
  <div style="margin-left: 20px;">
   <font style="font-family:'Oleo Script', cursive ;font-size: 40px;">CUSTOMIZE | originals</font>
  </div>
  <div>
  	<form id="home" name="home" method="post" action="webpage/navigation.html">
	<input type="image" value="home" src="images/home.png" class="ibtn" title="HOME" onclick="location='../webpage/navigation.html'"/>
	</form>	
	<form id="go" name="go" method="post" action="userShowBasket">
	<input type="image" value="search" src="images/basketBLACK.png" class="ibtn" title="GO"/>
	</form>
	<form action="#" method="get"> 
	<input type="text" name="s" class="sinput" placeholder="search" autofocus x-webkit-speech/>  
	</form>	
  </div>
  
  <div class="tableS pinfo">
	  <table>
	  
		  <tr>
		  <td rowspan="5" ><img src="images/BB2271.jpg" width="400px" height="400px"/></td>
		  <td rowspan="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td colspan="4" class="ptype">WOMEN'S ORIGINALS</td>
		  </tr>
		  <tr>
		  <td colspan="4" class="pname">SUPERSTAR BOUNCE SHOES</td>
		  </tr>
		  <tr>
		  <td colspan="4" class="pprice">$65</td>
		  </tr>
		  <tr>
		  <td>SIZE:</td>
		  <td >
		  	<select name="size">
                 <option value="36">36</option>
                 <option value="37">37</option>
                 <option value="38">38</option>
                 <option value="39">39</option>
            </select></td>
            <td>AMOUNT:</td>
		<td >
			<select name="amount" >
			    <option value="1">1</option>
			    <option value="1">2</option>
			    <option value="1">3</option>
			    <option value="1">4</option>
			    <option value="1">5</option>
			</select></td>
		  </tr>
		  <tr>
		  <td colspan="4" style="text-align: center"><input type="button" name="add" value="ADD TO BASKET" class="button red"/></td>
		  </tr>
	  </table>
  </div>
  <div class="ui-btn-wrap">
    <button class="ui-btn-lg">
        View the comments
    </button>
</div>
	<script>
		$('#addToBasketModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var price = button.data('price') // Extract info from data-* attributes
		  var productId = button.data('product')
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('添加到购物车')
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
