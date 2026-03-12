package controller;

import java.io.IOException;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseInsertExecuteServlet")
public class CourseInsertExecuteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Course c = new Course();
            c.setCourseId(Integer.parseInt(request.getParameter("courseId")));
            c.setCourseName(request.getParameter("courseName"));

            CourseDAO dao = new CourseDAO();
            dao.insert(c);
            
            response.sendRedirect(request.getContextPath() + "/CourseListServlet");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", "IDが重複しているか、入力に誤りがあります。");
            response.sendRedirect(request.getContextPath() + "/view/course_insert.jsp");
        }
    }
}