package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by tjDu on 2016/12/20.
 */
public class CountListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("user_count");
        if (count == null) {
            count = new Integer(1);
        } else {
            int co = count.intValue();
            count = new Integer(co + 1);
        }
        context.setAttribute("user_count", count);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("user_count");
        int co = count.intValue();
        count = new Integer(co - 1);
        context.setAttribute("user_count", count);
    }
}
