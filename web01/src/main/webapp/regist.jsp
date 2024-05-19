<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
    <style>
        * {
            margin: 0;
            pad: 0;
        }

        .whole {
            width: 400px;
            height: 600px;
            background-color: pink;
        }
    </style>
    <script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
    <script>
    //获取xhr函数
    function getXhr(){
    	var xhr=new XMLHttpRequest();
    	
    	return xhr;
    }
    function checkUsername() {
        var username = document.getElementById("username").value;
        var xhr = getXhr();
        xhr.open("post", "RegistServlet", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var jsonResponse = JSON.parse(xhr.responseText);
                    if (jsonResponse.status === "error") {
                        document.getElementById("regist_span").innerHTML = jsonResponse.message;
                    } else if (jsonResponse.status === "success") {
                        document.getElementById("regist_span").innerHTML = jsonResponse.message;
                        // 可能需要重定向到登录页面或执行其他操作
                        // window.location.href = "login.jsp";
                    }
                }
            }
        };
        xhr.send("username=" + encodeURIComponent(username) + "&password=" + encodeURIComponent(password));
    }
    $(function(){
    	var usernameFlag=false;
    	var passwordFlag=false;
    	
    	$("#username").blur(function(){
    		var username=$("#username").val();
    		//发送异步请求
    		$.ajax({
    			url:"checkUsername",       //url:"checkUsername"+username,
    			type:"post",               //type:"post",
    			data:"username="+username,  //data:"username=",
    			success:function(data){//会将服务器返回的数据保存到data中，不用再手动获取了
    				if(data==0) {
    				$("#regist_span").html("用户名可以使用");
    				usernameFlag=true;
    				}
    				else{
    					$("#regist_span").html("用户名不可以使用");	
    				}	
    			}
    		});
    	});
    	$("#repeatpassword").blur(function(){
    		var password=$("#password").val();
    		var repeatpassword=$("#repeatpassword").val();
    		
    		if(password!=null&&password!=""&&password==repeatpassword){
    			$("#pass_span").html("密码一致");
    			passwordFlag=true;
    		}else{
    			$("#pass_span").html("密码不一致");
    		}
    	});
    	$("form").submit(function(){
    		/* if(usernameFlag==true&&passwordFlag==true){
    			return true;
    		}else{
    			return false;
    		} */
    		return usernameFlag&&passwordFlag;
    	});
    });
    </script>
</head>

<body>
    <!-- 注册界面 -->
    <div class="whole">
        <form action="regist" name="register" method="post" target="_blank" ">
            <h3 class="leftlocation">用户注册</h3>
            <font>用户名：</font>                                 <!-- 用户名输入框失去焦点时发送请求到数据库进行检查 -->
            <input type="text" name="username" id="username" placeholder="请输入用户名"><span id="regist_span">${regist_meg }</span><br />
            <font>性别：</font>
            <font>男</font>
            <input type="radio" name="gender" checked="checked">
            <font>女</font>
            <input type="radio" name="gender"><br />
            <font>手机号：</font>
            <select name="choosetelephone">
                <option selected="selected">--请选择号码归属地--</option>
                <option>中国大陆+86</option>
                <option>香港+852</option>
                <option>澳门+886</option>
                <option>泰国+66</option>
                <option>韩国+82</option>
                <option>美国+1</option>
                <option>加拿大+2</option>
            </select>
            <input type="text" name="telephone" placeholder="请输入手机号">
            <input type="button" name="yanzheng" value="发送验证码">
            <br />
            <font>验证码：</font>
            <input type="text" name="yanzheng" placeholder="请输入验证码"><br />
            <font>请输入密码：</font>
            <input type="password" name="password" id="password" placeholder="请输入密码"><br />
            <font>再次确认密码：</font>
            <input type="password" name="repeatpassword" id="repeatpassword" placeholder="请输入密码"><span id="pass_span"></span><br />
            <input type="submit" value="立即注册">
            <input type="reset" value="清空">
        </form>

    </div>
</body>

</html>