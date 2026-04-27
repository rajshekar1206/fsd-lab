1)reate a user validation web application using JSP, where the user submits the login
name and password to the server. The name and password are checked against the data
already available in database and if the data matches, a successfull login page is
returned. Otherwise show a failure message to the user.

package com.uday;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb",
                    "root",
                    "yourpassword");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("failure.jsp");
                rd.forward(request, response);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
