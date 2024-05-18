<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#d1{
width:200px;
height:100px;
background-color:yellow;}
</style>
<script>
//定义函数
function clickButton(){
	var spanEle=window.document.getElementById("s1");//得到一整行标签
	/* innerHTML:得到标签之间的内容 */
	var msg=spanEle.innerHTML;
	
	spanEle.innerHTML="书中自有黄金屋";//更换为新内容
	document.getElementById("i1").value=msg;//通过value把id为i1那一行换为旧的文字
	
}
function mouseOver(){
	alert("鼠标进来了...");
}
function mouseOut(){
	alert("鼠标离开了...");
}


</script>
</head>
<body>
 <!-- Javascript的事件驱动：
            用户事件：用户操作，例如单击，鼠标移入，鼠标移出等
            系统事件：系统触发的事件，例如文档加载完成
            
            常用事件：
            onclick:点击
            onload:加载完成
            onblur:失去焦点
            onfocus:获取焦点
            onmouseover:鼠标移入
            onmouseout:鼠标移出 -->
            
            
           
            
            
<input type="button" value="点击我" onclick="clickButton();">

<div id="d1" onmouseover="mouseOver();" onmouseout="mouseOut();"> </div>

 <!-- BOM:Borwser Object Model 浏览器对象模型
               提供可以与浏览器窗口互动的对象，window是顶层对象，其常用子对象有document history location screen navigator frames
                                windows.alert  windows. 可以省略
            
            DOM:Document Object Model 文档对象模型  把整个html页面生成一个DOM树
                 这个DOM就是BOM里面的一个具体对象，这个document就是BOM里的那个document  
             			
             						head:分为meta title
             			文档——html——
             						body:分为h1  p ul(分为li li li) -->
             						
           <!--  元素查询：
            根据id值查询： document.getElementById("id值")  返回一个具体的元素节点
            根据标签名查询： document.getElementByTagName("标签名")  返回元素节点数组
            根据name值查询：document.getElementByName("name值")  返回元素结点数组 -->
            <!-- 点击按钮后实现文字替换 -->
            <span id="s1" >世上无难事，只要肯攀登</span>
            </br>
           <!--  点击按钮把原来的文字显示在文本框 -->
            <input id="i1" type="text" name="msg">
</body>
</html>