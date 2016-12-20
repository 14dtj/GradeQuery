package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tjDu on 2016/12/20.
 */
public class VisitorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("visitor_count");
        if (count == null) {
            count = new Integer(1);
        } else {
            int co = count.intValue();
            count = new Integer(co + 1);
        }
        context.setAttribute("visitor_count", count);
        response.sendRedirect("visitor.jsp");
    }
}
