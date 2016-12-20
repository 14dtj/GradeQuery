package servlet;

import dao.DaoFactory;
import dao.UserDao;
import model.Grade;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tjDu on 2016/12/18.
 * 登录并显示成绩
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao dao = DaoFactory.getUserDao();
        List<Grade> data = dao.getGrade(username, password);
        if (data.size() == 0) {
            request.getRequestDispatcher("errorUser.html").forward(request, response);
        } else {
            request.getSession().setAttribute("username", username);
            ServletContext context = request.getSession().getServletContext();
            Integer count = (Integer) context.getAttribute("user_count");
            if (count == null) {
                count = new Integer(1);
            } else {
                int co = count.intValue();
                count = new Integer(co + 1);
            }
            context.setAttribute("user_count", count);
            request.setAttribute("grades", data);
            request.getRequestDispatcher("grade.jsp").forward(request, response);
        }

    }
}
