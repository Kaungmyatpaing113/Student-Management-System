package controller;

import java.io.IOException;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    // URL ကနေ တိုက်ရိုက်ခေါ်ရင် Login မျက်နှာပြင်ကို ပြမယ်
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    // Login ခလုတ်နှိပ်ရင် အလုပ်လုပ်မယ့်အပိုင်း
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            
            // JSP ကပို့လိုက်တဲ့ ID နဲ့ Name ကို ယူမယ်
            int userId = Integer.parseInt(request.getParameter("userId"));
            String userName = request.getParameter("userName");
            
            // Database နဲ့ တိုက်စစ်မယ်
            TeacherDAO dao = new TeacherDAO();
            Teacher teacher = dao.login(userId, userName);
            
            if (teacher != null) {
                // မှန်ရင် Session ထဲမှတ်ပြီး Menu ကိုသွားမယ်
                HttpSession session = request.getSession();
                session.setAttribute("loginTeacher", teacher);
                response.sendRedirect(request.getContextPath() + "/view/menu.jsp");
            } else {
                // မှားရင် Error ပြပြီး Login ကို ပြန်သွားမယ်
                request.setAttribute("loginError", "ID または名前が間違っています。");
                request.getRequestDispatcher("/view/login.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // ID ကို ဂဏန်းမရိုက်မိမှ တကယ်ပေါ်မယ့်စာ
            request.setAttribute("loginError", "IDは半角数字で入力してください。");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        } catch (Exception e) {
            // Database မချိတ်မိရင် ပေါ်မယ့်စာ (Eclipse Console မှာ အနီရောင်နဲ့ အသေးစိတ်ပြပေးမယ်)
            e.printStackTrace(); 
            request.setAttribute("loginError", "システムエラー：データベースに接続できません。");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }    
     }
    
}