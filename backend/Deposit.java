package backend;

import java.sql.*;

public class Deposit {

    public static boolean deposit(String cardNumber,double amount){

        try{

            Connection con =
                    DatabaseConnection.getConnection();

            String updateBalance =
            "UPDATE users SET balance=balance+? WHERE card_number=?";

            PreparedStatement ps =
                    con.prepareStatement(updateBalance);

            ps.setDouble(1, amount);

            ps.setString(2, cardNumber);

            ps.executeUpdate();

            String balanceQuery =
            "SELECT balance FROM users WHERE card_number=?";

            PreparedStatement ps2 =
                    con.prepareStatement(balanceQuery);

            ps2.setString(1, cardNumber);

            ResultSet rs =
                    ps2.executeQuery();

            double balance = 0;

            if(rs.next()){

                balance = rs.getDouble("balance");

            }

            String insert =
            "INSERT INTO transactions(card_number,transaction_type,amount,balance_after) VALUES(?,?,?,?)";

            PreparedStatement ps3 =
                    con.prepareStatement(insert);

            ps3.setString(1, cardNumber);

            ps3.setString(2, "Deposit");

            ps3.setDouble(3, amount);

            ps3.setDouble(4, balance);

            ps3.executeUpdate();

            return true;

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

}
