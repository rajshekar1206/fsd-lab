
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

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

        HttpSession session = request.getSession(false);

        if (session != null) {
            String name = (String) session.getAttribute("username");
            Date startTime = (Date) session.getAttribute("startTime");
            Date endTime = new Date();

            long duration = (endTime.getTime() - startTime.getTime()) / 1000;

            session.invalidate();

            out.println("<html><body>");
            out.println("<h2>Thank You, " + name + "!</h2>");
            out.println("<p>You used the application for " + duration + " seconds.</p>");
            out.println("</body></html>");
        } else {
            out.println("<h2>No active session found.</h2>");
        }
    }
}