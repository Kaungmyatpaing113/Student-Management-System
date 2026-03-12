package controller;

import java.io.IOException;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TeacherInsertExecuteServlet")
public class TeacherInsertExecuteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Teacher t = new Teacher();
            t.setUserId(Integer.parseInt(request.getParameter("userId")));
            t.setUserName(request.getParameter("userName"));
            t.setMailAddress(request.getParameter("mailAddress"));

            TeacherDAO dao = new TeacherDAO();
            dao.insert(t);
            
            response.sendRedirect(request.getContextPath() + "/TeacherListServlet");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", "IDが重複しているか、入力に誤りがあります。");
            response.sendRedirect(request.getContextPath() + "/view/teacher_insert.jsp");
        }
    }
}