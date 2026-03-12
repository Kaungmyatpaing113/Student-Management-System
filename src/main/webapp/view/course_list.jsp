<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>コース一覧</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 60%; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 3px; border: none; cursor: pointer; }
        .btn-edit { background-color: #ffc107; color: black; }
        .btn-delete { background-color: #dc3545; color: white; }
        .btn-add { background-color: #28a745; color: white; display: inline-block; margin-bottom: 10px; }
        .btn-back { background-color: #6c757d; color: white; display: inline-block; margin-bottom: 10px; }
    </style>
</head>
<body>

    <h2>コース一覧 (Course List)</h2>

    <a href="${pageContext.request.contextPath}/view/menu.jsp" class="btn btn-back">← メニューに戻る</a>
    <a href="${pageContext.request.contextPath}/view/course_insert.jsp" class="btn btn-add">+ 新規追加</a>

    <table>
        <tr>
            <th>コースID</th>
            <th>コース名</th>
            <th>操作</th>
        </tr>
        <%
            List<Course> list = (List<Course>) request.getAttribute("courseList");
            if (list != null && !list.isEmpty()) {
                for (Course c : list) {
        %>
        <tr>
            <td><%= c.getCourseId() %></td>
            <td><%= c.getCourseName() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/CourseUpdateServlet" method="get" style="display:inline;">
                    <input type="hidden" name="courseId" value="<%= c.getCourseId() %>">
                    <input type="submit" value="編集" class="btn btn-edit">
                </form>
                <form action="${pageContext.request.contextPath}/CourseDeleteServlet" method="post" style="display:inline;" onsubmit="return confirm('本当に削除しますか？');">
                    <input type="hidden" name="courseId" value="<%= c.getCourseId() %>">
                    <input type="submit" value="削除" class="btn btn-delete">
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="3">データがありません。</td></tr>
        <% } %>
    </table>

</body>
</html>