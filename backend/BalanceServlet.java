package backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String cardNumber = request.getParameter("cardNumber");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            out.print("Invalid Card Number");
            return;
        }

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql =
                "SELECT balance FROM users WHERE card_number=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, cardNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                out.print("₹ " +
                    String.format("%,.2f", balance));

            } else {

                out.print("Account not found");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
            out.print("Server Error");
        }
    }
}