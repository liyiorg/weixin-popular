<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pay js example</title>
<script type="text/javascript">
//json 数据
var x_json = ${json};
function pay(){
	WeixinJSBridge.invoke('getBrandWCPayRequest',x_json,function(res){
		if(res.err_msg == 'get_brand_wcpay_request:ok'){
			//支付成功，可以做跳转到支付成功的提示页面
		}else{
			//支付失败
			alert(res.err_msg);
		}
	});
}
</script>
</head>
<body>

</body>
</html>