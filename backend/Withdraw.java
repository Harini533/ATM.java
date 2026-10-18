package backend;

import java.sql.*;

public class Withdraw {

    public static boolean withdraw(String cardNumber,double amount){

        try{

            Connection con =
                    DatabaseConnection.getConnection();

            String balanceQuery =
            "SELECT balance FROM users WHERE card_number=?";

            PreparedStatement ps =
                    con.prepareStatement(balanceQuery);

            ps.setString(1, cardNumber);

            ResultSet rs =
                    ps.executeQuery();

            double balance = 0;

            if(rs.next()){

                balance = rs.getDouble("balance");

            }

            if(balance < amount){

                return false;

            }

            String update =
            "UPDATE users SET balance=balance-? WHERE card_number=?";

            PreparedStatement ps2 =
                    con.prepareStatement(update);

            ps2.setDouble(1, amount);

            ps2.setString(2, cardNumber);

            ps2.executeUpdate();

            balance = balance - amount;

            String insert =
            "INSERT INTO transactions(card_number,transaction_type,amount,balance_after) VALUES(?,?,?,?)";

            PreparedStatement ps3 =
                    con.prepareStatement(insert);

            ps3.setString(1, cardNumber);

            ps3.setString(2, "Withdraw");

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