package controller;

import java.io.IOException;
import java.util.List;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TeacherListServlet")
public class TeacherListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TeacherDAO dao = new TeacherDAO();
            List<Teacher> list = dao.findAll();
            request.setAttribute("teacherList", list);
            request.getRequestDispatcher("/view/teacher_list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}