package controller;

import java.io.IOException;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentUpdateExecuteServlet")
public class StudentUpdateExecuteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            s.setStudentName(request.getParameter("studentName"));
            s.setCourse(request.getParameter("course"));

            StudentDAO dao = new StudentDAO();
            dao.update(s); // Database မှာ Update လုပ်မယ်
            
            response.sendRedirect(request.getContextPath() + "/StudentListServlet");
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}