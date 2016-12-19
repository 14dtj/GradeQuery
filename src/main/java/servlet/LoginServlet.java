package servlet;

import dao.DaoFactory;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by tjDu on 2016/12/18.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        request.getSession().setAttribute("username", username);
        String password = request.getParameter("password");
        UserDao dao = DaoFactory.getUserDao();
        Map<String, String> map = dao.getGrade(username, password);
        String str = "";
        for (Map.Entry entry : map.entrySet()) {
            str += "<span>" + entry.getKey() + ":" + entry.getValue() + " </span ><br>";
        }
        str += "</div>\n" +
                "</body>\n" +
                "</html>";
        try {
            PrintWriter out = response.getWriter();
            out.print("<html>\n" +
                    "<head>\n" +
                    "    <title>Grade</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>测验情况</h1>\n" +
                    "<div>\n");
            out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
