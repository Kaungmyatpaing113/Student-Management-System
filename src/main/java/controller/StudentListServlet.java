package controller;

import java.io.IOException;
import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // DAO သုံးပြီး ကျောင်းသားစာရင်း အကုန်ဆွဲထုတ်မယ်
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.findAll(); 
            
            // JSP ကိုပို့ဖို့ Attribute ထဲ ထည့်မယ်
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            // Error တက်ရင် Error မျက်နှာပြင်ကို ပို့မယ်
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}