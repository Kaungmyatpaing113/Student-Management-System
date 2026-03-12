package controller;

import java.io.IOException;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TeacherUpdateExecuteServlet")
public class TeacherUpdateExecuteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Teacher t = new Teacher();
            t.setUserId(Integer.parseInt(request.getParameter("userId")));
            t.setUserName(request.getParameter("userName"));
            t.setMailAddress(request.getParameter("mailAddress"));

            TeacherDAO dao = new TeacherDAO();
            dao.update(t);
            
            response.sendRedirect(request.getContextPath() + "/TeacherListServlet");
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}