package backend;

import java.sql.*;

public class History {

    public static void showHistory(String cardNumber){

        try{

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
            "SELECT * FROM transactions WHERE card_number=? ORDER BY transaction_date DESC";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, cardNumber);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                System.out.println("--------------------------------");

                System.out.println("Date : "
                        + rs.getTimestamp("transaction_date"));

                System.out.println("Type : "
                        + rs.getString("transaction_type"));

                System.out.println("Amount : ₹"
                        + rs.getDouble("amount"));

                System.out.println("Balance : ₹"
                        + rs.getDouble("balance_after"));

            }

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

}