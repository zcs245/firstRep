<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师</title>
</head>
<body style="text-align: center;">
<h3 style="text-align: center;">授课额计划表</h3>
<h5 style="text-align: center;">添加与变更信息</h5>
<form action="/Mytest" method="post">
    <input type="hidden" name="action" value="${action}">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="oldCourseName" value="${oldCourseName}">
<table border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td height="30" align="center">课程名称</td>
        <td height="30" align="center">时间</td>
        <td height="30" align="center">操作</td>
    </tr>
    <tr>
        <td>
            <select name="courseName" style="border: 0 none; appearance:none;-webkit-appearance:none;" >
                <option value ="java">java</option>
                <option value ="python">python</option>
                <option value="c语言">c语言</option>
                <option value="数据结构">数据结构</option>
            </select>
        </td>
        <td>
            <select name="courseHour" style="border: 0 none; appearance:none;-webkit-appearance:none;">
                <option value ="周一上午1 2节">周一上午1 2节</option>
                <option value ="周一上午3 4节">周一上午3 4节</option>
                <option value ="周一下午5 6节">周一下午5 6节</option>
                <option value ="周一下午7 8节">周一下午7 8节</option>
                <option value ="周一晚上9 10节">周一下午9 10节</option>
                <option value ="周二上午1 2节">周二上午1 2节</option>
                <option value ="周二上午3 4节">周二上午3 4节</option>
                <option value ="周二下午5 6节">周二下午5 6节</option>
                <option value ="周二下午7 8节">周二下午7 8节</option>
                <option value ="周二晚上9 10节">周二下午9 10节</option>
                <option value ="周三上午1 2节">周三上午1 2节</option>
                <option value ="周三上午3 4节">周三上午3 4节</option>
                <option value ="周三下午5 6节">周三下午5 6节</option>
                <option value ="周三下午7 8节">周三下午7 8节</option>
                <option value ="周三晚上9 10节">周三下午9 10节</option>
                <option value ="周四上午1 2节">周四上午1 2节</option>
                <option value ="周四上午3 4节">周四上午3 4节</option>
                <option value ="周四下午5 6节">周四下午5 6节</option>
                <option value ="周四下午7 8节">周四下午7 8节</option>
                <option value ="周四晚上9 10节">周四下午9 10节</option>
                <option value ="周五上午1 2节">周五上午1 2节</option>
                <option value ="周五上午3 4节">周五上午3 4节</option>
                <option value ="周五下午5 6节">周五下午5 6节</option>
                <option value ="周五下午7 8节">周五下午7 8节</option>
                <option value ="周五晚上9 10节">周五下午9 10节</option>
            </select>
        </td>
        <td>
            <input type="submit" name="save" value="保存">
        </td>
    </tr>
</table>
</form>
</body>
</html>
