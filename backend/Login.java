package backend;

import java.sql.*;

public class Login {

    public static boolean login(String cardNumber, String pin) {

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
            "SELECT * FROM users WHERE card_number=? AND pin=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, cardNumber);

            ps.setString(2, pin);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

}
