package backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
                           throws ServletException, IOException {

        String cardNumber = request.getParameter("cardNumber");
        String pin = request.getParameter("pin");

        boolean success = Login.login(cardNumber, pin);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (success) {

            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome to ATM Interface.</p>");

        } else {

            out.println("<h2>Login Failed!</h2>");
            out.println("<p>Invalid Card Number or PIN.</p>");
        }
    }
}