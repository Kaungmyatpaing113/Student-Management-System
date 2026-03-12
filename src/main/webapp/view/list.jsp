<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生一覧表示</title>
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

    <h2>学生一覧表示 (Student List)</h2>

    <a href="${pageContext.request.contextPath}/view/menu.jsp" class="btn btn-back">← メニューに戻る</a>
    <a href="${pageContext.request.contextPath}/view/insert.jsp" class="btn btn-add">+ 新規追加</a>
    <a href="${pageContext.request.contextPath}/StudentCSVDownloadServlet" style="margin-left:10px;">📥 CSVダウンロード</a>

    <table>
        <tr>
            <th>学生ID</th>
            <th>学生名</th>
            <th>コース</th>
            <th>操作</th>
        </tr>
        <%
            List<Student> list = (List<Student>) request.getAttribute("studentList");
            if (list != null && !list.isEmpty()) {
                for (Student s : list) {
        %>
        <tr>
            <td><%= s.getStudentId() %></td>
            <td><%= s.getStudentName() %></td>
            <td><%= s.getCourse() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/StudentUpdateServlet" method="get" style="display:inline;">
                    <input type="hidden" name="studentId" value="<%= s.getStudentId() %>">
                    <input type="submit" value="編集" class="btn btn-edit">
                </form>
                <form action="${pageContext.request.contextPath}/StudentDeleteServlet" method="post" style="display:inline;" onsubmit="return confirm('本当に削除しますか？');">
                    <input type="hidden" name="studentId" value="<%= s.getStudentId() %>">
                    <input type="submit" value="削除" class="btn btn-delete">
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="4">データがありません。</td></tr>
        <% } %>
    </table>

</body>
</html>