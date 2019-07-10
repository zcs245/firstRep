<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师</title>
    <script language="javascript">
        function delSubmit(action,list)
        {
            action.value = "teacherdelete";
            if (list.value==1){
                document.getElementById("List1").submit();
            }else if (list.value==2){
                document.getElementById("List2").submit();
            }else if(list.value==3){
                document.getElementById("List3").submit();
            }
        }
        function ediSubmit(action,list) {;
            action.value = "teacherupdate";
            if (list.value==1){
                document.getElementById("List1").submit();
            }else if (list.value==2){
                document.getElementById("List2").submit();
            }else if(list.value==3){
                document.getElementById("List3").submit();
            }
        }
        function addSubmit() {
            window.location="/Mytest?action=teacheradd&id=${id}"
        }
    </script>
</head>
<body style="text-align: center;">
<h3 style="text-align: center;">授课计划表</h3>
<h5 style="text-align: left;">欢迎您，${name}${userType}<a href="/Logout">退出</a> </h5>
<table border="1" cellpadding="0" cellspacing="0" align="center">
<tr>
    <td height="30" align="center">课程名称</td>
    <td height="30" align="center">课时</td>
    <td height="30" align="center">操作</td>
</tr>
<c:forEach items="${pager.dates}" var="plan" varStatus="plans">
    <form id="List${plans.count}" action="/Mytest">
        <tr>
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="action" value="null">
            <input type="hidden" name="list" value="${plans.count}">
            <input type="hidden" name="userType" value="${userType}">
            <td><input type="text" name="courseName" readonly="readonly" value="${plan.getCourseName()}" style="border:0 none;text-align: center;"></td>
            <td><input type="text" name="time" readonly="readonly" value="${plan.getTime()}" style="border:0 none;text-align: center;"></td>
            <td><input type="button"  name = "delete" value="删除" onclick="delSubmit(List${plans.count}.action,List${plans.count}.list)">
                <input type="button" name="updata" value="修改" onclick="ediSubmit(List${plans.count}.action,List${plans.count}.list)">
            </td>
        </tr>
    </form>
</c:forEach>
</table>
<input type="button" value="添加" onclick="addSubmit()"><br>
<a href="?pager=1&pageSize=${pager.pageSize}&id=${id}&userType=${userType}">首页</a>
<a href="?pager=${pager.prev}&pageSize=${pager.pageSize}&id=${id}&userType=${userType}">上一页</a>
<a href="?pager=${pager.next}&pageSize=${pager.pageSize}&id=${id}&userType=${userType}">下一页</a>
<a href="?pager=${pager.pages}&pageSize=${pager.pageSize}&id=${id}&userType=${userType}">尾页</a>
<br>
总的记录数：${pager.rows},共${pager.pages}页,当前为${pager.page}页
</body>
</html>
