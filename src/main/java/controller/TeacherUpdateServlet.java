package controller;

import java.io.IOException;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TeacherUpdateServlet")
public class TeacherUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            TeacherDAO dao = new TeacherDAO();
            Teacher t = dao.findById(userId);
            
            request.setAttribute("teacher", t);
            request.getRequestDispatcher("/view/teacher_update.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}