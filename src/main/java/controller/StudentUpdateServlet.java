package controller;

import java.io.IOException;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            StudentDAO dao = new StudentDAO();
            Student s = dao.findById(studentId); // ယခင် Data ကို ဆွဲထုတ်မယ်
            
            request.setAttribute("student", s);
            request.getRequestDispatcher("/view/update.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}