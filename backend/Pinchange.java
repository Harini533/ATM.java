package backend;

import java.sql.*;

public class Pinchange {

    public static boolean changePin(String cardNumber,
                                    String oldPin,
                                    String newPin){

        try{

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
            "UPDATE users SET pin=? WHERE card_number=? AND pin=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, newPin);

            ps.setString(2, cardNumber);

            ps.setString(3, oldPin);

            int rows = ps.executeUpdate();

            return rows > 0;

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

}