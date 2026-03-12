package controller;

import java.io.IOException;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentInsertExecuteServlet")
public class StudentInsertExecuteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            s.setStudentName(request.getParameter("studentName"));
            s.setCourse(request.getParameter("course"));

            StudentDAO dao = new StudentDAO();
            dao.insert(s); // Database ထဲ ထည့်မယ်
            
            // ပြီးရင် List မျက်နှာပြင်ကို ပြန်သွားမယ်
            response.sendRedirect(request.getContextPath() + "/StudentListServlet");
        } catch (Exception e) {
            // ID ထပ်နေတာမျိုးဆိုရင် Error ပြမယ်
            request.getSession().setAttribute("errorMessage", "IDが重複しているか、入力に誤りがあります。");
            response.sendRedirect(request.getContextPath() + "/view/insert.jsp");
        }
    }
}