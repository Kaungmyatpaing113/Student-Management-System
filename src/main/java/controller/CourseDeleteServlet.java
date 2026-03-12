package controller;

import java.io.IOException;

import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            CourseDAO dao = new CourseDAO();
            dao.delete(courseId);
            
            response.sendRedirect(request.getContextPath() + "/CourseListServlet");
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}