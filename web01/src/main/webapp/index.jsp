<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
<script>
          //将span内的文字显示到文本框
$(function(){  // 相当于window.onload();
	//alert("文档加载完毕了")
	$("#d2").click(function(){ //$("#d2")相当于document.getElementById("d2")  // 动态绑定事件
		var msg=$("#s1").html();
		//alert(msg);//弹出获取的span里面的文字
		$("#i1").val(msg);//把span里面的文字放到文本框
		
		//Jquery  --> Dom
		var jobj=$("s1");
		var dobj=jboj.get(0);  //或jobj[0]
		//Dom  --> Jquery
		var jjobj=$(dobj);
	}); 
});

</script>
</head>
<body>
<span id="s1">书山有路勤为径</span><br/>
<input type="text"  id="i1" name="msg"><br/>
<input type="button"  id="d2" value="测试Jquery"><br/>
</body>
</html>