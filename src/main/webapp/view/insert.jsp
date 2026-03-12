<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生追加</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>

    <h2>新しい学生の追加 (Add Student)</h2>

    <% String errorMsg = (String) session.getAttribute("errorMessage");
       if (errorMsg != null) { %>
        <p class="error"><%= errorMsg %></p>
    <% session.removeAttribute("errorMessage"); } %>

    <form action="${pageContext.request.contextPath}/StudentInsertExecuteServlet" method="post">
        <div class="form-group">
            <label>学生ID:</label><br>
            <input type="number" name="studentId" required min="1">
        </div>
        <div class="form-group">
            <label>学生名:</label><br>
            <input type="text" name="studentName" required>
        </div>
        <div class="form-group">
            <label>コース:</label><br>
            <input type="text" name="course" required>
        </div>
        <input type="submit" value="登録する">
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/StudentListServlet">← キャンセルして一覧に戻る</a>

</body>
</html>