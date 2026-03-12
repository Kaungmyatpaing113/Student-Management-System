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

@WebServlet("/TeacherSearchServlet")
public class TeacherSearchServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/teacher_search.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");
            if (keyword == null) keyword = "";
            
            TeacherDAO dao = new TeacherDAO();
            List<Teacher> list = dao.search(keyword);
            
            request.setAttribute("teacherList", list);
            request.setAttribute("keyword", keyword); 
            request.getRequestDispatcher("/view/teacher_search.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}