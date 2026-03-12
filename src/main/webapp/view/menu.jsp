<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Teacher" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .menu-container { border: 1px solid #ddd; padding: 20px; border-radius: 5px; background-color: #f9f9f9; width: 400px; }
        .menu-list { list-style-type: none; padding: 0; }
        .menu-list li { margin: 10px 0; }
        .menu-list a { text-decoration: none; color: #007BFF; font-size: 16px; }
        .menu-list a:hover { text-decoration: underline; }
        .logout-btn { display: inline-block; margin-top: 20px; padding: 8px 15px; background-color: #dc3545; color: white; text-decoration: none; border-radius: 3px; }
    </style>
</head>
<body>

    <% Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
       if (teacher == null) {
           response.sendRedirect(request.getContextPath() + "/view/login.jsp");
           return; 
       }
    %>

    <h2>学生管理システム メニュー</h2>
    <p>ログイン中: <b><%= teacher.getUserName() %></b> 先生</p>

    <div class="menu-container">
        <h3>操作メニュー</h3>
        <ul class="menu-list">
            <li><a href="${pageContext.request.contextPath}/StudentListServlet">1. 学生一覧表示</a></li>
            <li><a href="${pageContext.request.contextPath}/view/insert.jsp">2. 学生追加</a></li>
            <li><a href="${pageContext.request.contextPath}/StudentSearchServlet">3. 学生検索</a></li>
            <hr>
            <li><a href="${pageContext.request.contextPath}/TeacherListServlet">4. 教師一覧・管理</a></li>
            <li><a href="${pageContext.request.contextPath}/TeacherSearchServlet">5. 教師検索</a></li>
            <hr>
            <li><a href="${pageContext.request.contextPath}/CourseListServlet">6. コース一覧・管理</a></li>
        </ul>
        
        <a href="${pageContext.request.contextPath}/LogoutServlet" class="logout-btn">ログアウト</a>
    </div>

</body>
</html>