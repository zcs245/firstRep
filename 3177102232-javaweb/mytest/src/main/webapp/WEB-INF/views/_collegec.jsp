<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学院教务</title>
    <script language="javascript">
        function delSubmit(action,list)
        {
            action.value = "collegecdelete";
            if (list.value==1){
                document.getElementById("List1").submit();
            }else if (list.value==2){
                document.getElementById("List2").submit();
            }else if(list.value==3){
                document.getElementById("List3").submit();
            }
        }
        function ediSubmit(action,list) {
            action.value = "collegecupdate";
            if (list.value == 1) {
                document.getElementById("List1").submit();
            } else if (list.value == 2) {
                document.getElementById("List2").submit();
            } else if (list.value == 3) {
                document.getElementById("List3").submit();
            }
        }
    </script>
</head>
<h3 style="text-align: center;">课程限制</h3>
<h5 style="text-align: center"><a href="/Logout">退出</a></h5>
<body style="text-align: center;">
<table border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td height="30" align="center">课程名</td>
        <td height="30" align="center">课程类型</td>
        <td height="30" align="center">职称要求</td>
        <td height="30" align="center">操作</td>
    </tr>
    <c:forEach items="${pager.dates}" var="plan" varStatus="plans">
        <form id="List${plans.count}" action="/Mytest">
            <tr>
                <input type="hidden" name="action" value="null">
                <input type="hidden" name="list" value="${plans.count}">
                <input type="hidden" name="id" value="${plan.getRestrictiveCode().getCourseCode()}">
                <td><input type="text" name="courseName" readonly="readonly" value="${plan.getRestrictiveCode().getCourseName()}" style="border:0 none;text-align: center;"></td>
                <td><input type="text" name="courseType" readonly="readonly" value="${plan.getCourseType()}" style="border:0 none;text-align: center;"></td>
                <td><input type="text" name = "title" readonly="readonly" value="${plan.getTitle()}" style="border:0 none;text-align: center;"></td>
                <td><input type="button"  name = "delete" value="删除" onclick="delSubmit(List${plans.count}.action,List${plans.count}.list)">
                    <input type="button" name="updata" value="修改" onclick="ediSubmit(List${plans.count}.action,List${plans.count}.list)">
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
<a href="?pager=1&pageSize=${pager.pageSize}">首页</a>
<a href="?pager=${pager.prev}&pageSize=${pager.pageSize}">上一页</a>
<a href="?pager=${pager.next}&pageSize=${pager.pageSize}">下一页</a>
<a href="?pager=${pager.pages}&pageSize=${pager.pageSize}">尾页</a>
<br>
总的记录数：${pager.rows},共${pager.pages}页,当前为${pager.page}页
<br>
<h3 style="text-align: center;"><a href="CList1">教师限制</a> </h3>
</body>
</html>
