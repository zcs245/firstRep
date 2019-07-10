<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学校教务</title>
</head>
<h3 style="text-align: center;">教学计划表</h3>
<h5 style="text-align: center;">信息添加或变更</h5>
<body style="text-align: center;">
<table border="1" cellpadding="0" cellspacing="0" align="center">
    <form action="/Mytest" method="post">
    <input type="hidden" name="action" value="${action}">
    <tr>
        <td height="30" align="center">班级类别</td>
        <td height="30" align="center">班级</td>
        <td height="30" align="center">课程编号</td>
        <td height="30" align="center">课程名称</td>
        <td height="30" align="center">课时</td>
        <td height="30" align="center">操作</td>
    </tr>
    <tr>
        <td height="30" colspan="2" align="center">
            <select name="typeNumber" style="border: 0 none;-webkit-appearance:none;">
                <option value ="本科-软件1班">本科 &nbsp 软件1班</option>
                <option value ="本科-软件2班">本科 &nbsp 软件2班</option>
            </select>
        </td>
        <td height="30" colspan="2" align="center">
            <select name="codeName" style="border: 0 none; appearance:none;-webkit-appearance:none;" >
                <option value ="101-java">101 &nbsp java</option>
                <option value ="102-python">102 &nbsp python</option>
                <option value ="103-C语言">103 &nbsp C语言</option>
                <option value ="104-数据结构">104 &nbsp 数据结构</option>
            </select>
        </td>
        <td height="30" align="center">
            <select name="courseHour" style="border: 0 none; appearance:none;-webkit-appearance:none;">
                <option value ="15">15</option>
                <option value ="30">30</option>
                <option value="45">45</option>
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
