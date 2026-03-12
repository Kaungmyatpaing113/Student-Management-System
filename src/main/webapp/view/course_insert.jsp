<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>コース追加</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>

    <h2>新しいコースの追加 (Add Course)</h2>

    <% String errorMsg = (String) session.getAttribute("errorMessage");
       if (errorMsg != null) { %>
        <p class="error"><%= errorMsg %></p>
    <% session.removeAttribute("errorMessage"); } %>

    <form action="${pageContext.request.contextPath}/CourseInsertExecuteServlet" method="post">
        <div class="form-group">
            <label>コースID:</label><br>
            <input type="number" name="courseId" required min="1">
        </div>
        <div class="form-group">
            <label>コース名:</label><br>
            <input type="text" name="courseName" required>
        </div>
        <input type="submit" value="登録する">
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/CourseListServlet">← キャンセルして一覧に戻る</a>

</body>
</html>