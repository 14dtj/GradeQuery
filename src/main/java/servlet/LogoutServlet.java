package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by tjDu on 2016/12/20.
 * 注销登录
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        ServletContext context = session.getServletContext();
        Integer count = (Integer) context.getAttribute("user_count");
        int co = count.intValue();
        count = new Integer(co - 1);
        context.setAttribute("user_count", count);
        response.sendRedirect("index.jsp");
    }
}
