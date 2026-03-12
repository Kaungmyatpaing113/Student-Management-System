<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Teacher" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教師一覧</title>
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

    <h2>教師一覧 (Teacher List)</h2>

    <a href="${pageContext.request.contextPath}/view/menu.jsp" class="btn btn-back">← メニューに戻る</a>
    <a href="${pageContext.request.contextPath}/view/teacher_insert.jsp" class="btn btn-add">+ 新規追加</a>

    <table>
        <tr>
            <th>ユーザーID</th>
            <th>教師名</th>
            <th>メールアドレス</th>
            <th>操作</th>
        </tr>
        <%
            List<Teacher> list = (List<Teacher>) request.getAttribute("teacherList");
            if (list != null && !list.isEmpty()) {
                for (Teacher t : list) {
        %>
        <tr>
            <td><%= t.getUserId() %></td>
            <td><%= t.getUserName() %></td>
            <td><%= t.getMailAddress() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/TeacherUpdateServlet" method="get" style="display:inline;">
                    <input type="hidden" name="userId" value="<%= t.getUserId() %>">
                    <input type="submit" value="編集" class="btn btn-edit">
                </form>
                <form action="${pageContext.request.contextPath}/TeacherDeleteServlet" method="post" style="display:inline;" onsubmit="return confirm('本当に削除しますか？');">
                    <input type="hidden" name="userId" value="<%= t.getUserId() %>">
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