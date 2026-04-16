import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String name = request.getParameter("username");

        if (name != null) {
            session.setAttribute("username", name);
            session.setAttribute("startTime", new Date());
        }

        Date startTime = (Date) session.getAttribute("startTime");

        out.println("<html><head><title>Hello Page</title></head><body>");
        out.println("<div style='text-align:right;'>Start Time: " + startTime + "</div>");
        out.println("<h2>Hello, " + session.getAttribute("username") + "!</h2>");
        out.println("<form action='LogoutServlet' method='post'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}