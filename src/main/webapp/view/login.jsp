<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 100px; }
        .login-box { border: 1px solid #ccc; padding: 20px; width: 300px; margin: 0 auto; background-color: #f9f9f9; border-radius: 5px; }
        .error { color: red; font-size: 14px; margin-bottom: 10px; }
        input[type="number"], input[type="text"] { width: 90%; padding: 8px; margin: 10px 0; }
        input[type="submit"] { padding: 10px 20px; background-color: #007BFF; color: white; border: none; border-radius: 3px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>学生管理システム</h2>
    <div class="login-box">
        <h3>ログイン</h3>
        
        <% String errorMsg = (String) request.getAttribute("loginError");
           if (errorMsg != null) { %>
            <div class="error"><%= errorMsg %></div>
        <% } %>
        
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <label>ユーザーID:</label><br>
            <input type="number" name="userId" required min="1"><br>
            
            <label>教師名:</label><br>
            <input type="text" name="userName" required><br>
            
            <input type="submit" value="ログイン">
        </form>
    </div>
</body>
</html>