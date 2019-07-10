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
        <td height="30" align="center">姓名</td>
        <td height="30" align="center">职称</td>
        <td height="30" align="center">教学情况</td>
        <td height="30" align="center">最低周课时</td>
        <td height="30" align="center">最高周课时</td>
        <td height="30" align="center">最多课程数</td>
        <td height="30" align="center">操作</td>
    </tr>
        <tr>
            <td><input type="text" readonly="readonly" value="${name}" style="border:0 none;text-align: center;"></td>
            <td><input type="text" readonly="readonly" value="${title}" style="border:0 none;text-align: center;"></td>
            <td><input type="text" readonly="readonly" value="${teachSituation}" style="border:0 none;text-align: center;"></td>
    <td height="30" align="center">
        <select name="minWeekHour" style="border: 0 none; appearance:none;-webkit-appearance:none;">
            <option value ="1">1</option>
            <option value ="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
    </td>
    <td height="30" align="center">
        <select name="maxWeekHour" style="border: 0 none; appearance:none;-webkit-appearance:none;">
            <option value ="2">2</option>
            <option value ="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
        </select>
    </td>
    <td height="30" align="center">
        <select name="maxCourseNumber" style="border: 0 none; appearance:none;-webkit-appearance:none;">
            <option value ="1">1</option>
            <option value ="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
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
