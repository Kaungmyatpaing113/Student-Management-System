<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Teacher" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教師情報修正</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
    </style>
</head>
<body>

    <h2>教師情報修正 (Edit Teacher)</h2>

    <% Teacher t = (Teacher) request.getAttribute("teacher");
       if (t != null) { %>
    <form action="${pageContext.request.contextPath}/TeacherUpdateExecuteServlet" method="post">
        <div class="form-group">
            <label>ユーザーID (変更不可):</label><br>
            <input type="number" name="userId" value="<%= t.getUserId() %>" readonly style="background-color: #e9ecef;">
        </div>
        <div class="form-group">
            <label>教師名:</label><br>
            <input type="text" name="userName" value="<%= t.getUserName() %>" required>
        </div>
        <div class="form-group">
            <label>メールアドレス:</label><br>
            <input type="email" name="mailAddress" value="<%= t.getMailAddress() %>" required>
        </div>
        <input type="submit" value="更新する">
    </form>
    <% } else { %>
        <p style="color:red;">エラー：データが見つかりません。</p>
    <% } %>
    
    <br><a href="${pageContext.request.contextPath}/TeacherListServlet">← 一覧に戻る</a>

</body>
</html>