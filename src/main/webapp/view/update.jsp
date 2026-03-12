<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生情報修正</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
    </style>
</head>
<body>

    <h2>学生情報修正 (Edit Student)</h2>

    <% Student student = (Student) request.getAttribute("student");
       if (student != null) { %>
    <form action="${pageContext.request.contextPath}/StudentUpdateExecuteServlet" method="post">
        <div class="form-group">
            <label>学生ID (変更不可):</label><br>
            <input type="number" name="studentId" value="<%= student.getStudentId() %>" readonly style="background-color: #e9ecef;">
        </div>
        <div class="form-group">
            <label>学生名:</label><br>
            <input type="text" name="studentName" value="<%= student.getStudentName() %>" required>
        </div>
        <div class="form-group">
            <label>コース:</label><br>
            <select name="course">
                <option value="システム開発" <%= "システム開発".equals(student.getCourse()) ? "selected" : "" %>>システム開発</option>
                <option value="情報ビジネス" <%= "情報ビジネス".equals(student.getCourse()) ? "selected" : "" %>>情報ビジネス</option>
            </select>
        </div>
        <input type="submit" value="更新する">
    </form>
    <% } else { %>
        <p style="color:red;">エラー：データが見つかりません。</p>
    <% } %>
    
    <br><a href="${pageContext.request.contextPath}/StudentListServlet">← 一覧に戻る</a>

</body>
</html>