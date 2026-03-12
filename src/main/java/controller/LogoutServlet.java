package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session ကို ဖျက်ဆီးပစ်မယ်
        HttpSession session = request.getSession();
        session.invalidate(); 
        
        // Login မျက်နှာပြင်ကို ပြန်ပို့မယ်
        response.sendRedirect(request.getContextPath() + "/view/login.jsp");
    }
}