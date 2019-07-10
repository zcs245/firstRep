<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学院教务</title>
</head>
<h3 style="text-align: center;">课程限制</h3>
<h5 style="text-align: center;">信息添加或变更</h5>
<body style="text-align: center;">
<table border="1" cellpadding="0" cellspacing="0" align="center">
    <form action="/Mytest" method="post">
        <input type="hidden" name="action" value="${action}">
        <input type="hidden" name="id" value="${id}">
        <tr>
            <td height="30" align="center">课程名称</td>
            <td height="30" align="center">课程类型</td>
            <td height="30" align="center">职称要求</td>
            <td height="30" align="center">操作</td>
        </tr>
        <tr>
            <td><input type="text" name="courseName" readonly="readonly" value="${courseName}" style="border:0 none;text-align: center;"></td></td>
            <td height="30" align="center">
                <select name="courseType" style="border: 0 none; appearance:none;-webkit-appearance:none;">
                    <option value ="主课">主课</option>
                    <option value ="非主课">非主课</option>
                </select>
            </td>
            <td height="30" align="center">
                <select name="title" style="border: 0 none; appearance:none;-webkit-appearance:none;" >
                    <option value ="助教及以上">助教及以上</option>
                    <option value ="讲师及以上">讲师及以上</option>
                    <option value="教授及以上">教授及以上</option>
                    <option value="中层干部">中层干部</option>
                </select>
            </td>
            <td height="30" align="center">
                <input type="submit" name="save" value="保存">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
