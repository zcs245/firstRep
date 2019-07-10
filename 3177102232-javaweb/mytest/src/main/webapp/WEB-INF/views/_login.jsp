<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<h3 style="text-align: center;">教务系统-子系统-课程安排</h3>
<h5 style="text-align: center;">用户登录</h5>
<body style="text-align: center;">
<form action="../Login" method="post">
    <input type = "hidden" name="action" value="${action}"/>
    <table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td height="30" align="center">用户名：</td>
            <td>&nbsp;&nbsp;
                <input type="text" name="id"/></td>
        </tr>
        <tr>
            <td height="30" align="center">密 &nbsp; 码：</td>
            <td>&nbsp;&nbsp;
                <input type="password" name="password"/></td>
        </tr>
        <tr>
            <td height="35" align="center">类型</td>
            <td><input type="radio" name="user" value="校教务"/>校教务
                <input type="radio" name="user" value="院教务"/>院教务
                <input type="radio" name="user" value="老师"/>老师
                <input type="radio" name="user" value="学生"/>学生
            </td>
        </tr>
        <tr>
            <td height="30" colspan="2" align="center">
                <input type="submit" value="登录"/>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
<input type="text" value="${errorMsg}" style="border: 0px;background: none; color: red">
</body>
</html>
