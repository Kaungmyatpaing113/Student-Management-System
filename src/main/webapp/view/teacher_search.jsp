<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Teacher" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教師検索</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .search-box { margin-bottom: 20px; padding: 15px; background-color: #f8f9fa; border: 1px solid #ddd; display: inline-block;}
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

    <h2>教師検索 (Search Teacher)</h2>

    <div class="search-box">
        <form action="${pageContext.request.contextPath}/TeacherSearchServlet" method="post">
            <label>教師名で検索:</label>
            <input type="text" name="keyword" value="<%= (request.getAttribute("keyword") != null) ? request.getAttribute("keyword") : "" %>">
            <input type="submit" value="検索">
            <a href="${pageContext.request.contextPath}/view/menu.jsp" style="margin-left: 15px;">メニューに戻る</a>
        </form>
    </div>

    <table>
        <tr>
            <th>ユーザーID</th>
            <th>教師名</th>
            <th>メールアドレス</th>
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
        </tr>
        <%      }
            } else {
        %>
        <tr><td colspan="3">検索結果がありません。</td></tr>
        <% } %>
    </table>

</body>
</html>