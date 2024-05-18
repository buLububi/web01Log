<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
</head>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    div {
        width: 480px;
        height: 677px;

        background-color: #08adff;

    }

    h3 {
        font-weight: 400;
        font-family: 'Times New Roman', Times, serif;
        height: 150px;

        padding: 100px 100px 100px 100px;
        font-size: 40px;
        text-align: center;
        line-height: 200px;
    }

    body {
        width: 1200px;
        height: 697px;
        background-image: skyblue;
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;

    }

    font {
        display: inline-block;
        font-family: 'Times New Roman', Times, serif;
        font-size: 20px;
        text-align: center;
        width: 150px;
        height: 40px;
        line-height: 40px;

    }

    input {
        display: inline-block;
        width: 238px;
        height: 33px;
        padding: 0;
        border: 0;
        border-left: 0;
        padding: 0 9px;
        border-radius: 8px;
    }

    div .cl2 {
        height: 245px;
        text-align: center;

    }

    .submit {
        display: block;
        border: 0;
        width: 200px;
        height: 40px;
        border-radius: 0;
        margin: 10px 50px 20px 50px;
        position: absolute;
        left: 71px;
        top: 569px;
    }

    .submit:hover,
    .reset:hover {
        background-color: #9cd3ef;
    }

    .submit:active,
    reset:active {
        color: red;

    }

    .reset {
        display: block;
        border: 0;
        width: 200px;
        height: 40px;
        border-radius: 0;
        margin: 10px 50px 20px 50px;
        position: absolute;
        left: 71px;
        top: 620px;
    }
    span{
    color:red;
    position:relative;
    left:265px;
    
    }
</style>
<script>
function clearLoginMsg(){
	var spanEle=document.getElementById("Login_span");
	spanEle.innerHTML="";
}
</script>
<body>
    <!-- 登录界面 -->
    <div>
    <!-- action:请求的地址         method:请求的方式 GET:所有要提交的数据都会拼接到请求地址里，不安全 POST:把提交的数据放到请求体里不会暴露出来-->
        <form action="login" name="log" method="post" target="_blank">
            <h3>用户登录</h3>
            <font>用户名：</font>
            <input type="text" name="username" id="username" placeholder="请输入用户名" onfocus="clearLoginMsg();"><br />
           
            <span id="Login_span">${requestScope.login_msg}</span><br />
            <font>密码：</font>
            <input type="password" name="password" id="password" placeholder="请输入密码"><br />
            <div class="cl2">
                <input type="submit" value="登录" class="submit">
                <input type="reset" value="重置" class="reset">
            </div>

        </form>
    </div>
</body>

</html>