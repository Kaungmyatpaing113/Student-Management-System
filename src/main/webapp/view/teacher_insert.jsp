<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教師追加</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>

    <h2>新しい教師の追加 (Add Teacher)</h2>

    <% String errorMsg = (String) session.getAttribute("errorMessage");
       if (errorMsg != null) { %>
        <p class="error"><%= errorMsg %></p>
    <% session.removeAttribute("errorMessage"); } %>

    <form action="${pageContext.request.contextPath}/TeacherInsertExecuteServlet" method="post">
        <div class="form-group">
            <label>ユーザーID:</label><br>
            <input type="number" name="userId" required min="1">
        </div>
        <div class="form-group">
            <label>教師名:</label><br>
            <input type="text" name="userName" required>
        </div>
        <div class="form-group">
            <label>メールアドレス:</label><br>
            <input type="email" name="mailAddress" required>
        </div>
        <input type="submit" value="登録する">
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/TeacherListServlet">← キャンセルして一覧に戻る</a>

</body>
</html>