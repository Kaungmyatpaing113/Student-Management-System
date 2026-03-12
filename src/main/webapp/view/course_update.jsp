<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>コース修正</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
    </style>
</head>
<body>

    <h2>コース修正 (Edit Course)</h2>

    <% Course c = (Course) request.getAttribute("course");
       if (c != null) { %>
    <form action="${pageContext.request.contextPath}/CourseUpdateExecuteServlet" method="post">
        <div class="form-group">
            <label>コースID (変更不可):</label><br>
            <input type="number" name="courseId" value="<%= c.getCourseId() %>" readonly style="background-color: #e9ecef;">
        </div>
        <div class="form-group">
            <label>コース名:</label><br>
            <input type="text" name="courseName" value="<%= c.getCourseName() %>" required>
        </div>
        <input type="submit" value="更新する">
    </form>
    <% } else { %>
        <p style="color:red;">エラー：データが見つかりません。</p>
    <% } %>
    
    <br><a href="${pageContext.request.contextPath}/CourseListServlet">← 一覧に戻る</a>

</body>
</html>