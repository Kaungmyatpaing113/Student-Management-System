package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            StudentDAO dao = new StudentDAO();
            dao.delete(studentId); // Database ထဲကနေ ဖျက်မယ်
            
            response.sendRedirect(request.getContextPath() + "/StudentListServlet");
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}