b)Implement a web application using SERVLET,which takes a name as input and on submitting it,shows a hello<name>page.It shows start time at the right top comer of the page and provides a logout button.On clicking logout button,it should show a logout page with Thank You<name>message with the duration of usage(hint:Use session to store name and time).

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String name = request.getParameter("username");

        if (name != null && !name.isEmpty()) {
            session.setAttribute("username", name);
            session.setAttribute("startTime", new Date());
        }

        Date startTime = (Date) session.getAttribute("startTime");

        out.println("<html><body>");
        out.println("<div align='right'>Start Time: " + startTime + "</div>");
        out.println("<h2>Hello, " + session.getAttribute("username") + "!</h2>");

        out.println("<form action='logout' method='post'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}