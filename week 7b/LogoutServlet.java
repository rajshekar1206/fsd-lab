import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null) {
            String name = (String) session.getAttribute("username");
            Date startTime = (Date) session.getAttribute("startTime");
            Date endTime = new Date();

            long duration = (endTime.getTime() - startTime.getTime()) / 1000; // seconds

            session.invalidate();

            out.println("<html><head><title>Logout</title></head><body>");
            out.println("<h2>Thank You, " + name + "!</h2>");
            out.println("<p>You used the application for " + duration + " seconds.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body><h2>No active session found.</h2></body></html>");
        }
    }
}