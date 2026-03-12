package controller;

import java.io.IOException;
import java.util.List;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseListServlet")
public class CourseListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CourseDAO dao = new CourseDAO();
            List<Course> list = dao.findAll();
            request.setAttribute("courseList", list);
            request.getRequestDispatcher("/view/course_list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}