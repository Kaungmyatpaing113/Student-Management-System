package tool;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// "/*" လို့ပေးထားလို့ Project တစ်ခုလုံးက Request တွေကို အလိုလို UTF-8 ပြောင်းပေးမယ်
@WebFilter("/*")
public class EncodingFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Request နဲ့ Response ကို UTF-8 အဖြစ် သတ်မှတ်မယ်
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        chain.doFilter(request, response);
    }

    public void destroy() {}
}