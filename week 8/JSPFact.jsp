<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Factorial Calculator</title>
    </head>

    <body>
        <h2>Factorial of a Number</h2>
        <form action="" method="post">
            Enter a number: <input type="text" name="num" />
            <input type="submit" value="Calculate" />
        </form>

        <% String numStr=request.getParameter("num"); if (numStr !=null && !numStr.isEmpty()) { try { int
            num=Integer.parseInt(numStr); long fact=1; for (int i=1; i <=num; i++) { fact *=i; } %>

            <p>Factorial of <%= num %> is: <%= fact %>
            </p>

            <% } catch (NumberFormatException e) { %>

                <p>Please enter a valid integer.</p>

                <% } } %>
    </body>

    </html>