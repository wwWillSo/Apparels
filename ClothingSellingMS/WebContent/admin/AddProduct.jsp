<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddProduct.jsp' starting page</title>
    
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
    <form action="admin/addProduct" method="post" class="basic-grey" enctype="multipart/form-data">
	<h1>ADD PRODUCT
	<span>Please fill all the texts in the fields.</span>
	</h1>
	<label>
	<span>Name: </span>
	<input id="name" type="text" name="name" placeholder="Product's name" onblur="isEmpty();" />
	</label>
	<label>
	<span>Type: </span>
	<input id="type" type="text" name="type" placeholder="product's type" />
	</label>
	
	<label>
	<span>Price: </span>
	<input id="price" type="text" name="price" placeholder="product's price" />
	</label>
	<label>
	<span>Size: </span>
	<input id="size" type="text" name="size" placeholder="product's size" />
	</label>
	<label>
	<span>Detail: </span>
	<textarea id="detail" name="detail" placeholder="More information about the product"></textarea>
	</label>
	<label>
	<span>Image: </span><input type="file" name="pimg" id="p_image"/>
	</label>
	<br/><br/>
	<label>
	<span>&nbsp;</span>
	<button type="submit" id="signup" class="button" >OK</button>
	<button type="reset" id="Sreset" class="button">Reset</button>
	<button type="button" id="Scancel" class="button" onclick="location='admin/showProduct'">Cancel</button>
	</label>
	</form>
  </body>
</html>
