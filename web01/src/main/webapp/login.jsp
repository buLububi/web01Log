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

<body>
    <!-- 登录界面 -->
    <div>
    <!-- action:请求的地址         method:请求的方式 GET:所有要提交的数据都会拼接到请求地址里，不安全 POST:把提交的数据放到请求体里不会暴露出来-->
        <form action="login" name="log" method="post" target="_blank">
            <h3>用户登录</h3>
            <font>用户名：</font>
            <input type="text" name="username" id="username" placeholder="请输入用户名"><br />
           
            <!-- JSP的隐含对象：
            out(JspWriter):相当于response.getWriter()获取的对象，用于在页面中显示信息
            request(HttpServletRequest):HttpServletRequest对象
            response(HttpServletResponse):HttpServletResonse对象
            config(ServletConfig):对应Servlet中的ServletConfig对象
            application(ServletContext):SercletContext对象
            session(HttpSession):HttpSession对象
            page(Object):对应当前的Servlet类,实际上就是this
            pageContext(PageContext):当前页面的上下文，也是一个域对象
            exception(Throwable):错误页面中的异常对象 -->
            
            
            
           <%--  EL表达式： ${EL表达式(可完成取值,简单的判断，简单的运算等)}
            JSP内置的表达式语言，用于替代JSP<%= %>在页面做输出动作，它仅仅用来读取数据 而不能进行修改
                                        有则输出数据，无则什么都不输出
                EL取值的四个域：
                pageScope
                requestScope
                sessionScope
                applicationScope                        
                 EL从这四个域中取数据，需要指定域，不指定时默认从上到下去找                                  --%>
            <span>${requestScope.login_meg}</span><br />
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