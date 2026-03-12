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

@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
    
    // GET နဲ့လာရင် (Menu ကနေလာရင်) ဖောင်အလွတ်ပြမယ်
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/search.jsp").forward(request, response);
    }

    // POST နဲ့လာရင် (ရှာဖို့ နှိပ်လိုက်ရင်) Database ထဲ သွားရှာမယ်
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");
            if (keyword == null) keyword = "";
            
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.search(keyword);
            
            request.setAttribute("studentList", list);
            request.setAttribute("keyword", keyword); // ရိုက်ခဲ့တဲ့စာသား ပြန်ပေါ်အောင်
            request.getRequestDispatcher("/view/search.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }
}